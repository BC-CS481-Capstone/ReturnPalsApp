package com.example.returnpals.composetools.pickup

import android.location.Address
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.capitalize
import androidx.compose.ui.text.decapitalize
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.toLowerCase
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.compose.ReturnPalTheme
import com.example.returnpals.PackageInfo
import com.example.returnpals.PackageLabelType
import com.example.returnpals.PickupMethod
import com.example.returnpals.PricingPlan
import com.example.returnpals.composetools.IconManager
import com.example.returnpals.composetools.ScheduleReturnScaffold
import com.example.returnpals.composetools.getBackGroundColor
import com.example.returnpals.composetools.getBlueIconColor
import com.example.returnpals.composetools.getConfig
import com.example.returnpals.services.PickupInfo
import java.time.LocalDate
import java.util.Locale

@Preview
@Composable
fun ConfirmPickupScreen(
    info: PickupInfo = PickupInfo(),
    visaLastFour: Int = 5555,
    onClickNext:() -> Unit = {},
    onClickBack: () -> Unit = {},
    onClickPromoButton: () -> Unit = {}
) {
    if (info.address == null)
        Log.println(Log.ERROR, "ConfirmPickupScreen", "Invalid pickup! Address not specified.")
    if (info.method == null)
        Log.println(Log.ERROR, "ConfirmPickupScreen", "Invalid pickup! Method not specified.")
    if (info.plan == null)
        Log.println(Log.ERROR, "ConfirmPickupScreen", "Invalid pickup! Method not specified.")

    ScheduleReturnScaffold(
        step = 5,
        onClickBack = onClickBack,
        onClickNext = onClickNext,
        nextButtonText = "Confirm"
    ) { padding ->
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .background(getBackGroundColor())
                .padding(padding)
                .padding(horizontal = 20.dp)
                .fillMaxSize()
        ) {
            Text(
                text = "Confirm Your Pickup",
                color = Color.Black,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                fontSize = 28.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 10.dp)
            )
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxSize()
            ) {
                ConfirmPickupContent(
                    info = info,
                    visaLastFour = visaLastFour
                )
            }
        }
    }
}

fun LocalDate.toNiceString(): String {
    return this.month.name.lowercase().replaceFirstChar { it.uppercase() } + " " +
            this.dayOfMonth.toString() + ", " +
            this.year.toString()
}

@Preview
@Composable
private fun ConfirmPickupPreview() {
    ConfirmPickupScreen(
        info = PickupInfo(
            plan = PricingPlan.BRONZE,
            method = PickupMethod.HANDOFF,
            address = "something something address",
            packages = listOf(
                PackageInfo(labelType = PackageLabelType.PHYSICAL),
                PackageInfo(labelType = PackageLabelType.PHYSICAL),
                PackageInfo(labelType = PackageLabelType.PHYSICAL),
                PackageInfo(labelType = PackageLabelType.DIGITAL),
                PackageInfo(labelType = PackageLabelType.DIGITAL),
                PackageInfo(labelType = PackageLabelType.QRCODE)
            )
        )
    )
}

@Preview
@Composable
private fun ConfirmPickupContent(
    info: PickupInfo = PickupInfo(),
    visaLastFour: Int = 5555,
) {
    Column(
        Modifier
            .background(
                color = ReturnPalTheme.colorScheme.onPrimary,
                shape = RoundedCornerShape(10)
            )
            .padding(32.dp),
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Order Summary",
            fontWeight = FontWeight.SemiBold,
            color = ReturnPalTheme.colorScheme.primary,
            fontSize = 34.sp
        )
        Divider(
            color = ReturnPalTheme.colorScheme.tertiary,
            thickness = 2.dp,
            modifier = Modifier.padding(0.dp, 2.dp)
        )
        SummaryRow(
            name = "Date:",
            value = info.date.toNiceString()
        )
        SummaryRow(
            name = "Pickup by:",
            value = info.method?.toString() ?: ""
        )
        SummaryRow(
            name = "Address:",
            value = info.address ?: ""
        )

        PackagesText(info)
        PricingContent(info = info, visaLastFour = visaLastFour)
    }
}

@Preview
@Composable
private fun PricingContent(
    info: PickupInfo = PickupInfo(),
    visaLastFour: Int = 9999
) {
    SubtitleRow()
    SummaryRow(
        name = "Pricing Plan:",
        value = info.plan?.toString() ?: ""
    )
    if (info.plan == PricingPlan.BRONZE) {
        BronzePricingText(
            info = info,
            visaLastFour = visaLastFour
        )
    }
}

@Composable
private fun BronzePricingText(
    info: PickupInfo = PickupInfo(),
    visaLastFour: Int = 5555
) {
    PricingRow(
        name = "Cost:",
        value = info.cost.toString()
    )
    PricingRow(
        name = "Tax:",
        value = info.tax.toString()
    )
    PricingRow(
        name = "Total:",
        value = info.total.toString()
    )
    SubtitleRow()
    Text(
        text = buildAnnotatedString {
            append("Charged to ")
            withStyle(SpanStyle(fontWeight = FontWeight.Bold)) {
                append("Visa")
            }
            append(" ending in ")
            withStyle(SpanStyle(fontWeight = FontWeight.Bold)) {
                append(visaLastFour.toString())
            }
        }
    )
}

@Composable
private fun PricingRow(
    name: String,
    value: String,
) {
    Row(
        Modifier.padding(20.dp, 1.dp)
    ) {
        Text(text = name,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Start,
            modifier = Modifier
                .padding(10.dp, 0.dp))
        Text(text = value,
            textAlign = TextAlign.End,
            modifier = Modifier
                .weight(1f)
                .padding(10.dp, 0.dp))
    }
}

@Composable
private fun SubtitleRow(
    modifier: Modifier = Modifier,
    name: String? = null,
    padding: PaddingValues = PaddingValues(15.dp, 2.dp),
) {
    Row(
        horizontalArrangement =  Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier.padding(padding)
    ) {
        name?.let {
            Text(
                text = name,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Start,
                fontSize = 16.sp,
                color = ReturnPalTheme.colorScheme.secondary
            )
            Spacer(Modifier.width(10.dp))
        }
        Divider(color = ReturnPalTheme.colorScheme.tertiary)

    }
}

@Composable
private fun SummaryRow(
    modifier: Modifier = Modifier,
    name: String = "",
    value: String = "",
    padding: PaddingValues = PaddingValues(20.dp, 2.dp),
    icon: @Composable RowScope.() -> Unit = {}
) {
    Row(
        horizontalArrangement =  Arrangement.Start,
        verticalAlignment = Alignment.Top,
        modifier = modifier.padding(padding)
    ) {
        Text(text = name,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Start,
            modifier = Modifier
                .padding(10.dp, 0.dp))
        Text(
            text = value,
            textAlign = TextAlign.End,
            modifier = Modifier
                .padding(10.dp, 0.dp)
                .weight(1f)
        )
        icon()
    }
}

@Composable
private fun AddressText(address: String) {
//    val fsize = (getConfig().screenWidthDp/20)
    Text(
        text = buildAnnotatedString {
            withStyle(SpanStyle(fontWeight = FontWeight.Bold)) {
                append("Address:")
            }
            append(address)
        }
    )
}

@Composable
private fun PackagesText(info: PickupInfo) {
    val fsize = (getConfig().screenWidthDp/16)
    val numberOfPhysical = info.packages.count { it.labelType == PackageLabelType.PHYSICAL }
    val numberOfDigital = info.packages.count { it.labelType == PackageLabelType.DIGITAL }
    val numberOfQRCodes = info.packages.count { it.labelType == PackageLabelType.QRCODE }

    SubtitleRow(name = "Packages")
    SummaryRow(
        name = "Physical Labels:",
        value = numberOfPhysical.toString(),
    ) {
        IconManager().getBoxIcon(modifier = Modifier.height(fsize.dp))
    }
    SummaryRow(
        name = "Digital Labels:",
        value = numberOfDigital.toString(),
    ) {
        IconManager().getComputerIcon(modifier = Modifier.height(fsize.dp))
    }
    SummaryRow(
        name = "Amazon QR Codes:",
        value = numberOfQRCodes.toString(),
    ) {
        IconManager().getAmazonIcon(modifier = Modifier.height(fsize.dp))
    }
}