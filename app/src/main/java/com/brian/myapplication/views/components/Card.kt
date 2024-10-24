package com.brian.myapplication.views.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardDoubleArrowDown
import androidx.compose.material.icons.filled.KeyboardDoubleArrowUp
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.brian.myapplication.R
import com.brian.myapplication.ui.theme.EarningColor
import com.brian.myapplication.ui.theme.LightOrange
import com.brian.myapplication.ui.theme.LightPink
import com.brian.myapplication.ui.theme.SpendingColor
import com.brian.myapplication.ui.theme.afacadfluxFontFamily
import com.brian.myapplication.ui.theme.fontFamily

@Composable
fun PaymentCard(amount: Long, cardType:String, expiryDate: String){
    val colorStops = arrayOf(
        0.0f to LightPink,
        0.2f to LightOrange,
        1f to EarningColor
    )

    Card (
        modifier = Modifier.padding(end = 8.dp),
        shape = RoundedCornerShape(16.dp),
        border = BorderStroke(1.dp, Color.White),
        elevation = CardDefaults.cardElevation(8.dp)){
        Box(modifier = Modifier
                .width(125.dp)
                .height(150.dp)
                .background(Brush.linearGradient(colorStops = colorStops)
        )) {
            Column(
                modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.SpaceAround
            ) {

//                Text(
//                    text = cardType,
//                    fontSize = 20.sp,
//                    fontFamily = afacadfluxFontFamily,
//                    fontWeight = FontWeight.Bold,
//                    color = Color.White,
//                    modifier = Modifier.padding(12.dp)
//                )

                Box(modifier = Modifier.align(Alignment.End)) {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            painterResource(id = R.drawable.see_hide),
                            contentDescription = "See or Hide Amount"
                        )
                    }
                }

                Column(modifier = Modifier.padding(start = 8.dp), horizontalAlignment = Alignment.Start) {
                        Text(
                            text = "Total Balance",
                            fontFamily = afacadfluxFontFamily,
                            fontWeight = FontWeight.Normal,
                            color = Color.White
                        )

                    Text(
                        text = "$${amount}",
                        fontSize = 18.sp,
                        fontFamily = afacadfluxFontFamily,
                        fontWeight = FontWeight.SemiBold,
                        color = Color.White
                    )
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        , verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            painterResource(id = R.drawable.visa),
                            contentDescription = "Card Type"
                        )
                    }

                    Text(text = expiryDate,  fontFamily = afacadfluxFontFamily,
                        fontWeight = FontWeight.Normal, color = Color.White)
                }

            }
        }
    }
}

@Composable
fun DailyReportCard(totalamount: Long, spending:Long, earning:Long){
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                   horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(modifier = Modifier.weight(1f),horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(
                            text = "Total Balance",
                            fontFamily = afacadfluxFontFamily,
                            fontWeight = FontWeight.SemiBold,
                            color = Color.Gray
                        )
                        Text(
                            text = "$$totalamount",
                            fontFamily = afacadfluxFontFamily,
                            fontWeight = FontWeight.Bold,
                            fontSize = 22.sp,
                        )
                    }
                        EarningSpendingCard(title ="Earning" , amount = earning , bgColor = EarningColor,Icons.Default.KeyboardDoubleArrowUp,  modifier = Modifier.weight(1f))
                        EarningSpendingCard(title ="Spending" , amount = spending, bgColor = SpendingColor,Icons.Default.KeyboardDoubleArrowDown,  modifier = Modifier.weight(1f) )
                    Icon(
                        imageVector = Icons.Default.Visibility,
                        contentDescription = "EarningSpending Icon",
                        tint = Color.Gray
                    )
                }
}


@Composable
fun EarningSpendingCard(title: String, amount: Long, bgColor: Color, icon: ImageVector, modifier: Modifier = Modifier) {
    Card(
        onClick = {  },
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(8.dp),
        modifier = modifier.padding(5.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(bgColor),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
                Icon(
                    imageVector = icon,
                    contentDescription = "EarningSpending Icon",
                    tint = Color.White
                )

                    Text(
                        text = title,
                        fontFamily = afacadfluxFontFamily,
                        fontWeight = FontWeight.Normal,
                    )
                    Text(
                        text = "$$amount",
                        fontFamily = afacadfluxFontFamily,
                        fontWeight = FontWeight.Medium,
                        fontSize = 18.sp,
                        color = Color.White
                    )
                }
        }
}



@Preview
@Composable
fun PreviewCard(){

    PaymentCard(
        amount = 5550,
        cardType = "Credit Card",
        expiryDate = "02/25",
    )
}