package com.brian.myapplication.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.brian.myapplication.R
import com.brian.myapplication.model.CardItem
import com.brian.myapplication.model.Transaction
import com.brian.myapplication.model.User
import com.brian.myapplication.ui.theme.LightPink
import com.brian.myapplication.views.components.DailyReportCard
import com.brian.myapplication.views.components.HeaderSection
import com.brian.myapplication.views.components.PaymentCard
import com.brian.myapplication.views.components.ProfilewithIcon
import com.brian.myapplication.views.components.ProfilewithName
import com.brian.myapplication.views.components.TransactionwithIcon

@Composable
fun HomeScreen() {

    val users = listOf(User(R.drawable.profile, "Alina"),User(R.drawable.profile1, "Marie"),User(R.drawable.profile2, "Lily"),User(R.drawable.profile3, "Emily"),User(R.drawable.profile1, "Marie"),User(R.drawable.profile, "Alina"),User(R.drawable.profile, "Alina"),User(R.drawable.profile1, "Marie"),User(R.drawable.profile2, "Lily"),User(R.drawable.profile3, "Emily"),User(R.drawable.profile1, "Marie"),User(R.drawable.profile, "Alina"))

    val cards = listOf(CardItem(140000,"Debit Card", "12/05"),
        CardItem(100,"Credit Card", "01/08"),
        CardItem(4500,"Debit Card", "02/09")
    ,CardItem(10,"Credit Card", "17/02"),
                CardItem(3000,"Debit Card", "22/12"),
        CardItem(1500,"Credit Card", "11/08"),
        CardItem(400,"Debit Card", "01/29"),
        CardItem(50,"Credit Card", "01/08"),
        CardItem(4500,"Debit Card", "02/09"))

    val transactions = listOf(Transaction("Transfer to Lily",650,"09:37 AM", "Debit Card"),Transaction("Coffee",50,"09:37 AM", "Debit Card"),Transaction("Burger ",105,"02:17 PM", "Credit Card"),Transaction("Shoes",250,"07:15 PM", "Debit Card"))

    LazyColumn(modifier = Modifier
        .fillMaxSize()) {

        item {
            ProfilewithIcon(
                greeting = "Good Night",
                name = "Emily",
                profileImg = R.drawable.profile3
            )

            Spacer(modifier = Modifier.height(10.dp))
        }

        item {
            DailyReportCard(totalamount = 500, spending = 200, earning = 300)
        }

        item {

            LazyRow(modifier = Modifier.padding(horizontal = 5.dp)) {
                items(cards.size) { index ->
                    val card = cards[index]

                    PaymentCard(
                        amount = card.totalBalance,
                        cardType = card.cardType,
                        expiryDate = card.expiryDate,

                        )
                }
            }

            Spacer(modifier = Modifier.height(12.dp))
        }

item {
    HeaderSection(title = "Transfer", seeAllText = "See All")


    Spacer(modifier = Modifier.height(8.dp))
}

        item {
            LazyRow {
                items(users) { user ->
                    ProfilewithName(name = user.name, profileImg = user.profilePic)
                }
            }

            Spacer(modifier = Modifier.height(8.dp))
        }
        
        item {

            HeaderSection(title = "Transactions", seeAllText = "See All")

            Spacer(modifier = Modifier.height(8.dp))
        }
            items(transactions) {  transaction ->
                TransactionwithIcon(transaction.time,transaction.title,R.drawable.baseline_credit_card_24 ,transaction.amount, transaction.cardType)
            }
    }
}



@Preview(showBackground = true)
@Composable
fun PreviewHomeScreen(){
    HomeScreen()
}

