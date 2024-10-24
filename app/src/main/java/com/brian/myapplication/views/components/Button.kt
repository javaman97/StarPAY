package com.brian.myapplication.views.components

import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.brian.myapplication.ui.theme.fontFamily

@Composable
fun AuthenticationButton(text:String, color: Color,  onClick: () -> Unit){
     Button(onClick =  onClick, colors = ButtonDefaults.buttonColors(color)) {
        Text(text = text, fontFamily = fontFamily, color = Color.White)
    }
}