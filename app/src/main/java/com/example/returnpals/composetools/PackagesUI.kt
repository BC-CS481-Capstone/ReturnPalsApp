package com.example.returnpals.composetools

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// TODO: make table rows clickable/editable
// TODO: remove description from table?
// TODO: put images in add-label buttons
// TODO: allow user to upload files (pop up ui) as shown in figma

@Composable
fun PackagesUI(
    packages: List<PackageInfo>,
    onClickNext: () -> Unit,
    onClickBack: () -> Unit,
) {
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
                Button(
                    onClick = { /* TODO */ },
                    modifier = Modifier.weight(1.0f).requiredHeight(80.dp),
                    shape = RoundedCornerShape(20)
                ) {
                    Text(
                        text = "Physical Label",
                        fontWeight = FontWeight.Medium,
                        textAlign = TextAlign.Center,
                    )
                }
                Spacer(Modifier.width(15.dp))
                Button(
                    onClick = { /* TODO */ },
                    modifier = Modifier.weight(1.0f).requiredHeight(80.dp),
                    shape = RoundedCornerShape(20)
                ) {
                    Text(
                        text = "Digital Label",
                        fontWeight = FontWeight.Medium,
                        textAlign = TextAlign.Center,
                    )
                }
                Spacer(Modifier.width(15.dp))
                Button(
                    onClick = { /* TODO */ },
                    modifier = Modifier.weight(1.0f).requiredHeight(80.dp),
                    shape = RoundedCornerShape(20)
                ) {
                    Text(
                        text = "Amazon QR Code",
                        fontWeight = FontWeight.Medium,
                        textAlign = TextAlign.Center,
                    )
                }
            }
            PackagesTable(
                packages,
                Modifier.fillMaxSize()
            )
        }
    }
}

// @Composable (LazyItemScope.() -> Unit)?  = null

@Composable
private fun PackagesTable(
    items: List<PackageInfo>,
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
                HeaderCell(
                    modifier = Modifier.weight(1.4f),
                    text = "Description",
                )
            }
        }
        // DATA ROWS
        this.items(items) { item ->
            Row {
                Cell(
                    text = item.label,
                    modifier = Modifier.weight(1.6f),
                )
                Cell(
                    text = item.labelType,
                    modifier = Modifier.weight(1.0f),
                )
                Cell(
                    text = if (item.description != null) {
                            "${item.description}"
                        } else {
                            "--"
                        },
                    modifier = Modifier.weight(1.4f),
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

@Preview(showBackground = true)
@Composable
private fun PackagesPreview() {
    PackagesUI(
        packages = listOf(
            PackageInfo(
                "Nordstrom.png",
                "Digital"
            )
        ),
        onClickNext = {},
        onClickBack = {},
    )
}