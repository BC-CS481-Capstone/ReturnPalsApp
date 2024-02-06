package com.example.returnpals.composetools

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.navigation.NavController
import com.example.returnpals.PackageInfo
import com.example.returnpals.PackageLabelType
import com.example.returnpals.ScheduleReturn

// TODO: RemoveLabelButton
// TODO: EditDescriptionButton
// TODO: put icons in add-label buttons
// TODO: implement pop up ui for adding label

/////////////////////////////////////////////////////////////////////////////
// PUBLIC API
////////////////////

@Composable
fun ScheduleReturn.PackagesUI(
    packages: List<PackageInfo> = listOf(),
    navController: NavController? = null,
    onAddLabel: (PackageInfo) -> Unit = {},
    onRemoveLabel: (Long) -> Unit = {},
) {
    val showDialogue: MutableState<Boolean> = remember { mutableStateOf(false) }
    val dialogueType: MutableState<PackageLabelType?> = remember { mutableStateOf(null) }

    ScheduleReturnScaffold(
        step = 4,
        onClickNext = { /*TODO: navigate to pay & confirm */ },
        onClickBack = { /*TODO: navigate to choose plan */ },
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
                color = MaterialTheme.colorScheme.secondary,
            )
            Text(
                text = "Upload a label and we'll handle the label printing and repackaging.",
                fontSize = 16.sp,
                textAlign = TextAlign.Center,
                color = MaterialTheme.colorScheme.secondary,
            )
            Row(
                modifier = Modifier.padding(vertical=15.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                AddLabelButton(
                    text = "Physical Label",
                    onClick = {
                        showDialogue.value = true
                        dialogueType.value = PackageLabelType.PHYSICAL
                    },
                    modifier = Modifier.weight(1.0f)
                )
                Spacer(Modifier.width(15.dp))
                AddLabelButton(
                    text = "Digital Label",
                    onClick = {
                        showDialogue.value = true
                        dialogueType.value = PackageLabelType.DIGITAL
                    },
                    modifier = Modifier.weight(1.0f)
                )
                Spacer(Modifier.width(15.dp))
                AddLabelButton(
                    text = "Amazon QR Code",
                    onClick = {
                        showDialogue.value = true
                        dialogueType.value = PackageLabelType.QRCODE
                    },
                    modifier = Modifier.weight(1.0f)
                )
            }
            PackagesTable(
                items = packages,
                onClickItem = { onRemoveLabel(it.id) },
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

@Composable
fun AddLabelContent(xButton:()->Unit,
                    addButton:(String, String)->Unit) {
    val config = getConfig()
    Column(
        Modifier
            .size(width = (config.screenWidthDp - 6).dp, height = (config.screenHeightDp - 100).dp)
            .background(color = getBackGroundColor(), shape = RoundedCornerShape(10)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center)
    {
        Text("X",
            Modifier.clickable(onClick = xButton),
            color = getBlueIconColor(),
            fontWeight = FontWeight.Bold, fontSize = 16.sp)
        Text("Add Digital Label",
            fontWeight = FontWeight.Bold,
            color = Color(0xFF052A42))
        UploadReturnContent()
        DescriptionContent()
        ButtonManager.NextButton(
            text = "Add Package",
            onClick = { addButton("filename", "description") }
        )
    }
}

@Composable
fun UploadReturnContent() {
    Column(horizontalAlignment = Alignment.Start){
        Text("Upload Return Label")
        Column(
            Modifier
                .background(color = Color(0x0F008BE7), shape = RoundedCornerShape(15))
                //.border() // TODO add border dashed line
                ,
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        )
        {
            IconManager().getFileIcon(modifier = Modifier.size(width=100.dp,height=100.dp))
            Text(" Drag label here or browse files ") //TODO Add composable string to change browse files color to blue
        }
    }
}

@Composable
fun DescriptionContent() {
    Column(horizontalAlignment = Alignment.Start){
        Text("Description")
        TextField(value = "Label the item(s) inside: i.e 'laptop covers'", onValueChange = { })
    }
}

/////////////////////////////////////////////////////////////////////////////
// PRIVATE API
////////////////////

@Preview(showBackground = true)
@Composable
private fun PackagesPreview() {
    ScheduleReturn.PackagesUI(
        packages = listOf(
            PackageInfo(
                1,
                "Nordstrom.png",
                PackageLabelType.DIGITAL,
                "Digital"
            )
        )
    )
}

@Composable
private fun AddLabelDialogue(
    type: PackageLabelType,
    onAddLabel: (PackageInfo) -> Unit,
    onCancel: () -> Unit,
) {
    Dialog(onDismissRequest = { /*TODO*/ }) {
        AddLabelContent(
            xButton = onCancel,
            addButton = { filename, description ->
                onAddLabel(PackageInfo(0, filename, type, description))
            }
        )
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
    items: List<PackageInfo>,
    onClickItem: (PackageInfo) -> Unit,
    modifier: Modifier = Modifier,
    horizontal: Alignment.Horizontal = Alignment.CenterHorizontally,
    vertical: Arrangement.Vertical = Arrangement.Top
) {
    LazyColumn(
        modifier = modifier,
        horizontalAlignment = horizontal,
        verticalArrangement = vertical,
    ) {
        // HEADER ROW
        this.item {
            Row {
                HeaderCell(
                    modifier = Modifier.weight(1.6f),
                    text = "Attachment",
                )
                HeaderCell(
                    modifier = Modifier.weight(1.0f),
                    text = "Label Type",
                )
            }
        }
        // DATA ROWS
        this.items(
            items = items,
            key = { it.id }
        ) {
            Row(
                Modifier.clickable(onClick = { onClickItem(it) })
            ) {
                Cell(
                    text = it.label,
                    modifier = Modifier.weight(1.6f),
                )
                Cell(
                    text = it.labelType.toString(),
                    modifier = Modifier.weight(1.0f),
                )
            }
            Divider(
                color = MaterialTheme.colorScheme.secondary,
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
) {
    Box(
        modifier = modifier
            .border(width = 1.dp, color = Color.White)
            .background(MaterialTheme.colorScheme.secondary),
        contentAlignment = textAlignment
    ) {
        Text(
            text = text,
            modifier = Modifier
                .padding(10.dp, 5.dp),
            color = textColor,
            overflow = TextOverflow.Ellipsis,
            softWrap = false,
        )
    }
}

@Composable
private fun Cell(
    text: String,
    modifier: Modifier = Modifier,
    textColor: Color = MaterialTheme.colorScheme.secondary,
    textAlignment: Alignment = Alignment.Center,
) {
    Box(
        modifier = modifier,
        contentAlignment = textAlignment
    ) {
        Text(
            text = text,
            modifier = Modifier
                .padding(10.dp, 5.dp),
            color = textColor,
            overflow = TextOverflow.Ellipsis,
            softWrap = false,
        )
    }
}
