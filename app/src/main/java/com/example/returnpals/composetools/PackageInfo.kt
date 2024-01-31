package com.example.returnpals.composetools

// TODO: develop backend

data class PackageInfo(
    val label: String, // label is a filename
    val labelType: String,
    val description: String? = null, // additional info provided by user
)
