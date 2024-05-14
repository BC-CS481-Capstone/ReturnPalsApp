package com.example.returnpals.services

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import com.amplifyframework.api.aws.GsonVariablesSerializer
import com.amplifyframework.api.graphql.GraphQLRequest
import com.amplifyframework.api.graphql.SimpleGraphQLRequest
import com.amplifyframework.core.Amplify
import com.example.returnpals.PickupInfo
import com.example.returnpals.composetools.pickup.ConfirmPickupScreen
import com.stripe.android.PaymentConfiguration
import com.stripe.android.paymentsheet.PaymentSheet
import com.stripe.android.paymentsheet.PaymentSheetResult
import com.stripe.android.paymentsheet.rememberPaymentSheet


/**
 This File is to create the payment functions that gather customer info to send to server. The server will handle the transaction.
 This file follow the tutorial available from stripe documentation
 https://docs.stripe.com/payments/accept-a-payment?platform=android&ui=payment-sheet&lang=node
NOTE Before displaying the mobile Payment Element, your checkout page should:
 1 Show the products being purchased and the total amount
 2 Collect any required shipping information using the Address Element
 3 Include a checkout button to present Stripe’s UI
 */

@Composable
fun PaymentApp(info: PickupInfo, onClickBack:()->Unit,isCompletedPay:()->Unit) {

    val paymentSheet = rememberPaymentSheet(::onPaymentSheetResultold)
    val context = LocalContext.current
    var customerConfig by remember {mutableStateOf< PaymentSheet.CustomerConfiguration?>(null)}
    var paymentIntentClientSecret by remember {mutableStateOf<String?>(null)}

    LaunchedEffect(context) {
        Log.e("PaymentApp","StartLogs LaunchedEffect")

        Amplify.API.query(getPaymentSheetQueryOptions(),
            {
                if (!it.hasErrors() && it.hasData()) {
                    paymentIntentClientSecret = it.data.paymentIntent
                    customerConfig = PaymentSheet.CustomerConfiguration(
                        it.data.customer,
                        it.data.ephemeralKey
                    )
                    val publishableKey = it.data.publishableKey
                    PaymentConfiguration.init(context,publishableKey)
                } else {
                    Log.e("PaymentApp",it.toString())
                }
            },
            {
                Log.e("PaymentApp",it.toString())
            })
    }
    val onCheckOutButton = {
        Log.e("PaymentApp","OnClick")
        val currentConfig = customerConfig
        val currentClientSecret = paymentIntentClientSecret
        if (currentConfig !=null && currentClientSecret != null ) {
            presentPaymentSheet(paymentSheet,currentConfig,currentClientSecret)
        }
    }
    ConfirmPickupScreen(info = info,onClickNext = onCheckOutButton,onClickBack = onClickBack)
    /** Checkout Button
    Button(
        onClick = {
            Log.e("PaymentApp","OnClick")
            val currentConfig = customerConfig
            val currentClientSecret = paymentIntentClientSecret
            if (currentConfig !=null && currentClientSecret != null ) {
                presentPaymentSheet(paymentSheet,currentConfig,currentClientSecret)
            }
        }
    ) {
        Text("Checkout")
    }
    */
}


private fun presentPaymentSheet(
    paymentSheet:PaymentSheet,
    customerConfig:PaymentSheet.CustomerConfiguration,
    paymentIntentClientSecret:String
) {
    paymentSheet.presentWithPaymentIntent(paymentIntentClientSecret,
        PaymentSheet.Configuration(
            merchantDisplayName = "ReturnPal",
            customer = customerConfig
                    // Set `allowsDelayedPaymentMethods` to true if your business handles
                    // delayed notification payment methods like US bank accounts.
                    ,allowsDelayedPaymentMethods = true
        ))
}

private fun onPaymentSheetResultold(paymentSheetResult:PaymentSheetResult){
    when(paymentSheetResult) {
        is PaymentSheetResult.Canceled -> {
            Log.e("PaymentApp","Canceled")
            print("Canceled")
        }
        is PaymentSheetResult.Failed -> {
            Log.e("PaymentApp","Error")
            print("Error: ${paymentSheetResult.error}")
        }
        is PaymentSheetResult.Completed -> {
            Log.e("PaymentApp","Completed")
        }
    }
}

//Following examples from https://github.com/aws-amplify/docs/pull/2141/files to create custom query
private fun getPaymentSheetQueryOptions() : GraphQLRequest<com.amplifyframework.datastore.generated.model.PaymentSheet> {
    val document = "query MyQuery {\n" +
            "  getPaymentSheet {\n" +
            "    paymentIntent\n" +
            "    publishableKey\n" +
            "    ephemeralKey\n" +
            "    customer\n" +
            "  }\n" +
            "}"
    return SimpleGraphQLRequest(document,
        com.amplifyframework.datastore.generated.model.PaymentSheet::class.java,
        GsonVariablesSerializer())
}