package com.brian.myapplication.views.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.brian.myapplication.R
import com.brian.myapplication.ui.theme.LightOrange
import com.brian.myapplication.ui.theme.LightPink
import com.brian.myapplication.ui.theme.SpendingColor
import com.brian.myapplication.ui.theme.afacadfluxFontFamily
import com.brian.myapplication.ui.theme.fontFamily

@Composable
fun ProfilewithName(name:String, profileImg:Int){
    Column(modifier = Modifier.padding(horizontal = 8.dp), verticalArrangement = Arrangement.SpaceBetween, horizontalAlignment = Alignment.CenterHorizontally) {
        Image( modifier = Modifier
            .clip(CircleShape)
            .background(MaterialTheme.colorScheme.onSurface.copy(alpha = 0.2f))
            .size(56.dp), painter = painterResource(id = profileImg ), contentDescription ="Profile Pic",
            contentScale = ContentScale.Crop)
        Text(text = name, fontSize = 16.sp, fontFamily = fontFamily,textAlign = TextAlign.Center)
    }
}

@Composable
fun ProfilewithIcon(greeting:String, name:String, profileImg:Int){

    Row(modifier = Modifier.fillMaxWidth().padding(8.dp), horizontalArrangement = Arrangement.Start, verticalAlignment = Alignment.CenterVertically) {
        Image( modifier = Modifier
            .clip(CircleShape)
            .background(MaterialTheme.colorScheme.onSurface.copy(alpha = 0.2f))
            .size(56.dp), painter = painterResource(id = profileImg ), contentDescription ="Profile Pic",
            contentScale = ContentScale.Crop)

        Column(modifier = Modifier.padding(start = 12.dp)) {
            Text(
                text = greeting,
                fontFamily = afacadfluxFontFamily,
                fontWeight = FontWeight.Medium,
                color = Color.Gray
            )

            Text(
                text = name,
                fontSize = 20.sp,
                fontFamily = afacadfluxFontFamily,
                fontWeight = FontWeight.SemiBold
            )
        }
        Spacer(modifier = Modifier.fillMaxWidth(0.8f))
        Box(modifier = Modifier.align(Alignment.CenterVertically)) {
            Icon(
                imageVector = Icons.Filled.Notifications,
                contentDescription = "Notification"
            )
        }
    }
}

@Composable
fun TransactionwithIcon(
    transTime: String,
    transName: String,
    transIcon: Int,
    amount: Long,
    cardType: String
){

    Row(modifier = Modifier.fillMaxWidth().padding(8.dp), horizontalArrangement = Arrangement.Start, verticalAlignment = Alignment.CenterVertically) {
        Box( modifier = Modifier
            .size(40.dp)
            .clip(CircleShape)
            .background(if(cardType == "Debit Card")LightPink else LightOrange)
            .padding(8.dp)){
            Icon(painter = painterResource(id = transIcon), contentDescription = "Transaction Icon", tint = Color.White )
        }
        Spacer(modifier = Modifier.width(10.dp))
        Column (modifier = Modifier.fillMaxWidth(0.8f)){
            Text(
                text = transName,
                fontFamily = afacadfluxFontFamily,
                fontWeight = FontWeight.SemiBold,
                fontSize = 20.sp,
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Today, ${transTime}",
                fontFamily = afacadfluxFontFamily,
                fontWeight = FontWeight.Medium,
                 color = Color.Gray
            )
        }
        Text(
            text = "-$${amount}",
            fontFamily = afacadfluxFontFamily,
            fontWeight = FontWeight.Normal,
            color = SpendingColor
        )
    }
}

@Composable
fun HeaderSection(title: String, seeAllText: String) {
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 12.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween) {

        Text(
            text = title,
            fontSize = 24.sp,
            fontFamily = afacadfluxFontFamily,
            fontWeight = FontWeight.SemiBold
        )
        Text(
            text = seeAllText,
            fontSize = 18.sp,
            fontFamily = afacadfluxFontFamily,
            fontWeight = FontWeight.Medium,
            color = Color.Gray
        )
    }
}

@Preview
@Composable
fun PreviewProfile(){
    //ProfilewithName(name = "Alie", profileImg = R.drawable.profile2)
    ProfilewithIcon(greeting = "Good Night", name = "Emily Evans", profileImg = R.drawable.profile3)

//    TransactionwithIcon(
//        "08:29 PM",
//        "Transfer to Lily",
//        R.drawable.baseline_credit_card_24,
//        650,
//        "Debit Card"
//    )
}