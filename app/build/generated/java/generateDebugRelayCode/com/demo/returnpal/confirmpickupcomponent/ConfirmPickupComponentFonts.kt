package com.demo.returnpal.confirmpickupcomponent

import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import com.demo.returnpal.R

val cairo: FontFamily = FontFamily(
    Font(R.font.relay_cairo_black, weight = FontWeight.W900, style = FontStyle.Normal),
    Font(R.font.relay_cairo_bold, weight = FontWeight.W700, style = FontStyle.Normal),
    Font(R.font.relay_cairo_extrabold, weight = FontWeight.W800, style = FontStyle.Normal),
    Font(R.font.relay_cairo_extralight, weight = FontWeight.W200, style = FontStyle.Normal),
    Font(R.font.relay_cairo_light, weight = FontWeight.W300, style = FontStyle.Normal),
    Font(R.font.relay_cairo_medium, weight = FontWeight.W500, style = FontStyle.Normal),
    Font(R.font.relay_cairo_regular, weight = FontWeight.W400, style = FontStyle.Normal),
    Font(R.font.relay_cairo_semibold, weight = FontWeight.W600, style = FontStyle.Normal)
)
val avenirNext: FontFamily = FontFamily.Default