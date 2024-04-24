package com.example.returnpals.composetools.pickup

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog

import androidx.core.util.toAndroidPair
import coil.compose.AsyncImage


import com.amplifyframework.datastore.generated.model.LabelType
import com.example.compose.ReturnPalTheme
import com.example.returnpals.PackageInfo

import com.example.returnpals.composetools.ButtonManager

import com.example.returnpals.composetools.IconManager
import com.example.returnpals.composetools.ScheduleReturnScaffold
import com.example.returnpals.composetools.getBackGroundColor
import com.example.returnpals.services.Backend
import java.io.File

// TODO: RemoveLabelButton
// TODO: EditDescriptionButton
// TODO: put icons in add-label buttons
// TODO: implement upload photo functionality

/////////////////////////////////////////////////////////////////////////////
// PUBLIC API
////////////////////

@Preview
@Composable
fun AddPackagesScreen(
    packages: Map<Int, PackageInfo> = mapOf(),
    onAddLabel: (PackageInfo) -> Unit = {},
    onRemoveLabel: (Int) -> Unit = {},
    onClickNext: () -> Unit = {},
    onClickBack: () -> Unit = {},
) {
    val showDialogue: MutableState<Boolean> = remember { mutableStateOf(false) }
    val dialogueType: MutableState<LabelType?> = remember { mutableStateOf(null) }

    ScheduleReturnScaffold(
        step = 4,
        onClickNext = onClickNext,
        onClickBack = onClickBack,
        enabledNext = packages.isNotEmpty(),
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .padding(horizontal = 20.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                modifier = Modifier
                    .padding(10.dp)
                    .offset(0.dp, 10.dp),
                text = "My Packages",
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp,
                textAlign = TextAlign.Center,
                color = ReturnPalTheme.colorScheme.secondary,
            )
            Text(
                text = "Upload a label and we'll handle the label printing and repackaging.",
                fontSize = 16.sp,
                textAlign = TextAlign.Center,
                color = ReturnPalTheme.colorScheme.secondary,
            )
            Row(
                modifier = Modifier.padding(vertical=15.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                AddLabelButton(
                    text = "Physical Label",
                    onClick = {
                        showDialogue.value = true
                        dialogueType.value = LabelType.PHYSICAL
                    },
                    modifier = Modifier.weight(1.0f)
                )
                Spacer(Modifier.width(15.dp))
                AddLabelButton(
                    text = "Digital Label",
                    onClick = {
                        showDialogue.value = true
                        dialogueType.value = LabelType.DIGITAL
                    },
                    modifier = Modifier.weight(1.0f)
                )
                Spacer(Modifier.width(15.dp))
                AddLabelButton(
                    text = "Amazon QR Code",
                    onClick = {
                        showDialogue.value = true
                        dialogueType.value = LabelType.QRCODE
                    },
                    modifier = Modifier.weight(1.0f)
                )
            }
            PackagesTable(
                packages = packages,
                onClickItem = { id, _ -> onRemoveLabel(id) },
                modifier = Modifier.fillMaxSize()
            )
            if (showDialogue.value && dialogueType.value != null) {
                AddLabelDialogue(
                    type = dialogueType.value!!,
                    onAddLabel = { label ->
                        showDialogue.value = false
                        onAddLabel(label)
                    },
                    onCancel = { showDialogue.value = false }
                )
            }
        }
    }
}

fun getFilename(filepath: String): String {
    val i = filepath.lastIndexOf('/')
    return if (i == -1) ""
        else filepath.substring(i + 1)
}

/////////////////////////////////////////////////////////////////////////////
// PRIVATE API
////////////////////
@Composable
private fun AddLabelDialogue(
    type: LabelType,
    onAddLabel: (PackageInfo) -> Unit,
    onCancel: () -> Unit,
) {
    var image by remember { mutableStateOf<String?>(null) }
    var imageUri by remember { mutableStateOf<Uri?>(null) }
    val context = LocalContext.current
    val imagePicker = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.PickVisualMedia(),
        onResult = { uri ->
            val imageStream = context.contentResolver.openInputStream(uri!!)
            val tempFile = File.createTempFile("image", ".image")
            Backend.copyStreamToFile(imageStream!!, tempFile)
            image = tempFile.absolutePath
            imageUri = uri}
    )
    Dialog(onDismissRequest = onCancel) {
        AddLabelDialogueContent(
            label = imageUri,
            type = type,
            onCancel = onCancel,
            onUpload = {
                imagePicker.launch(PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly))
            },
            onConfirm = { description ->
                if (image != null) onAddLabel(PackageInfo(image!!, type, description))
                else onCancel()
            }
        )
    }
}
@Preview
@Composable
private fun AddLabelDialogueContent(
    label: Uri? = null,
    type: LabelType? = null,
    onCancel: () -> Unit = {},
    onUpload: () -> Unit = {},
    onConfirm: (String) -> Unit = {}
) {
    var description by remember { mutableStateOf("") }
    Column(
        Modifier
            .padding(12.dp, 50.dp)
            .background(color = getBackGroundColor(), shape = RoundedCornerShape(10)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
//        Row(
//            Modifier
//                .fillMaxWidth()
//                .padding(20.dp), horizontalArrangement = Arrangement.End
//        ) {
//            Text(
//                text = "X",
//                color = getBlueIconColor(),
//                fontWeight = FontWeight.Bold, fontSize = 16.sp,
//                modifier = Modifier.clickable(onClick = onCancel)
//            )
//        }
        Text(
            text = when (type) {
                LabelType.PHYSICAL -> "Add a Physical Label"
                LabelType.DIGITAL -> "Add a Digital Label"
                LabelType.QRCODE -> "Add a QR Code"
                else -> "Add a Label" },
            color = ReturnPalTheme.colorScheme.secondary,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(20.dp)
        )
        UploadLabelContent(label, onUpload)
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(30.dp, 10.dp)
        ) {
            OutlinedTextField(
                value = description,
                label = { Text("Description") },
                placeholder = { Text("Label the item(s) inside: i.e 'laptop covers'") },
                onValueChange = { description = it },
                modifier = Modifier.fillMaxWidth()
            )
            Row(modifier = Modifier.padding(0.dp, 10.dp)) {
                OutlinedButton(onClick = onCancel) { Text("Cancel") }
                Spacer(Modifier.weight(1f))
                Button(onClick = { onConfirm(description) }) { Text("Add Package") }
            }
        }
    }
}

@Composable
private fun UploadLabelContent(
    label: Uri? = null,
    onClick: () -> Unit = {}
) {
    Column(
        Modifier
            .fillMaxWidth()
            .padding(5.dp)
            .height(230.dp),horizontalAlignment = Alignment.Start
    ) {
//        Text("Upload Return Label")
        val borderColor = ReturnPalTheme.colorScheme.primary
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .clickable(onClick = onClick)
                .fillMaxSize()
                .padding(10.dp, 0.dp)
                .background(color = Color(0x0F008BE7), shape = RoundedCornerShape(15))
                .drawBehind {
                    drawRoundRect(
                        color = borderColor,
                        style = Stroke(
                            width = 4f,
                            pathEffect = PathEffect.dashPathEffect(floatArrayOf(10f, 10f), phase = 0f)
                        )
                    )
                }
        ) {
            if (label == null) {
                IconManager().getFileIcon(Modifier.size(width=100.dp,height=100.dp))
                Text(
                    text = "Drag label here or browse files",
                    color = ReturnPalTheme.colorScheme.primary
                )
            } else {
                AsyncImage(
                    model = label,
                    contentDescription = null,
                    contentScale = ContentScale.Inside,
                )
            }
        }
    }
}



@Composable
private fun AddLabelButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Button(
        onClick = onClick,
        modifier = modifier,
        shape = RoundedCornerShape(20)
    ) {
        Text(
            text = text,
            fontWeight = FontWeight.Medium,
            textAlign = TextAlign.Center,
        )
    }
}

@Composable
private fun PackagesTable(
    packages: Map<Int, PackageInfo>,
    onClickItem: (Int, PackageInfo) -> Unit,
    modifier: Modifier = Modifier,
    horizontal: Alignment.Horizontal = Alignment.CenterHorizontally,
    vertical: Arrangement.Vertical = Arrangement.Top
) {
    val columnWeights = floatArrayOf(1.0f, 0.9f, 1.4f)
    LazyColumn(
        modifier = modifier,
        horizontalAlignment = horizontal,
        verticalArrangement = vertical,
    ) {
        // HEADER ROW
        this.item {
            Row {
                HeaderCell(
                    modifier = Modifier.weight(columnWeights[0]),
                    text = "Label",
                )
                HeaderCell(
                    modifier = Modifier.weight(columnWeights[1]),
                    text = "Type",
                )
                HeaderCell(
                    modifier = Modifier.weight(columnWeights[2]),
                    text = "Description",
                )
            }
        }
        // PACKAGES:
        this.items(
            items = packages.toList(),
            key = { it.first }
        ) {
            val packageInfo = it.second
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.requiredHeight(60.dp)
                    .clickable(onClick = { onClickItem(it.first, it.second) })
            ) {
                Cell( // Label
                    modifier = Modifier.weight(columnWeights[0]).fillMaxSize(),
                ) {
                    AsyncImage(
                        model = packageInfo.label,
                        contentDescription = null,
                        alignment = Alignment.Center,
                        contentScale = ContentScale.Crop,
                    )
                }
                Cell( // Label Type
                    modifier = Modifier.weight(columnWeights[1]),
                ) {
                    CellText(packageInfo.labelType.toString())
                }
                Cell( // Description
                    modifier = Modifier.weight(columnWeights[2]),
                ) {
                    packageInfo.description?.let { text -> CellText(text) }
                }
            }
            Divider(
                color = ReturnPalTheme.colorScheme.secondary,
            )
        }
    }
}

@Composable
private fun HeaderCell(
    text: String,
    modifier: Modifier = Modifier,
    textColor: Color = Color.White,
    textAlignment: Alignment = Alignment.Center,
    padding: PaddingValues = PaddingValues(10.dp, 5.dp),
) {
    Box(
        modifier = modifier
            .border(width = 1.dp, color = Color.White)
            .background(ReturnPalTheme.colorScheme.secondary)
            .padding(padding),
        contentAlignment = textAlignment
    ) {
        Text(
            text = text,
            color = textColor,
            overflow = TextOverflow.Ellipsis,
            softWrap = false,
        )
    }
}

@Composable
private fun Cell(
    modifier: Modifier = Modifier,
    alignment: Alignment = Alignment.Center,
    padding: PaddingValues = PaddingValues(10.dp, 5.dp),
    content: @Composable BoxScope.() -> Unit
) {
    Box(
        modifier = modifier.padding(padding),
        contentAlignment = alignment,
        propagateMinConstraints = true,
        content = content
    )
}

@Composable
private fun CellText(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = ReturnPalTheme.colorScheme.secondary
) {
    Text(
        text = text,
        fontSize = 14.sp,
        textAlign = TextAlign.Center,
        modifier = modifier,
        color = color,
        overflow = TextOverflow.Ellipsis,
        softWrap = false,
    )
}
