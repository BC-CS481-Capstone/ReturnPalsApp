package com.example.returnpals.dataRepository

class PaymentAppRepositoryAmplify {
    fun getPaymentSheet(pricingPlan:String,priceToPay:String,result:(Boolean)->Unit) {
        result(true)
        /*Amplify.API.query(//TODO Move logic to repositor
            getPaymentSheetQueryOptions(),
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
    }*/
    }
}