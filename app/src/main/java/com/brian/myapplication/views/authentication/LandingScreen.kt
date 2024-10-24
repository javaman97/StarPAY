package com.brian.myapplication.views.authentication

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CreditCard
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.brian.myapplication.R
import com.brian.myapplication.navigation.Screens
import com.brian.myapplication.ui.theme.afacadfluxFontFamily
import com.brian.myapplication.ui.theme.fontFamily
import com.brian.myapplication.viewmodels.AuthViewModel

@Composable
fun LandingScreen(authViewModel: AuthViewModel, navController: NavController) {
    val isAuthenticated by authViewModel.isAuthenticated.observeAsState(initial = false)

    if (isAuthenticated) {

        LaunchedEffect(Unit) {
            navController.navigate(Screens.Home.route) {
                popUpTo(Screens.Landing.route) { inclusive = true }
            }
        }
    } else {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(5.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceAround
        ) {
            Row {
                Icon(imageVector = Icons.Default.CreditCard, contentDescription = "Logo Icon", modifier = Modifier.size(36.dp))
                Text(text = "StarPay", fontSize = 24.sp,   fontFamily = afacadfluxFontFamily,
                    fontWeight = FontWeight.Bold)
            }
            Image(modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.5f), painter = painterResource(id = R.drawable.glass_card), contentDescription = "Landing Image")

            Column (modifier = Modifier.fillMaxWidth(), verticalArrangement = Arrangement.SpaceBetween){
                Text(
                    text = "Effortlessly Manage,\nEarn, and Monitor Your\nFinancials",
                    fontSize = 30.sp,
                    fontFamily = afacadfluxFontFamily,
                    fontWeight = FontWeight.SemiBold
                )
                Text(
                    text = "Manage you finances wisely,\nin just a single click\nwith StarPay",
                    fontFamily = afacadfluxFontFamily,
                    fontWeight = FontWeight.Normal,
                    fontSize = 20.sp,
                    color = Color.Gray
                )
            }

            Row(horizontalArrangement = Arrangement.SpaceAround) {
                Button(
                    modifier = Modifier.weight(1f),
                    onClick = { navController.navigate(Screens.SignUp.route) },
                    colors = ButtonDefaults.buttonColors(Color.Black)
                ) {
                    Text(text = "Sign Up",   fontFamily = afacadfluxFontFamily,
                        fontWeight = FontWeight.Bold, color = Color.White)
                }
                Button(
                    modifier = Modifier.weight(1f),
                    onClick = { navController.navigate(Screens.SignIn.route) },
                    colors = ButtonDefaults.buttonColors(Color.White)
                ) {
                    Text(text = "Sign In",   fontFamily = afacadfluxFontFamily,
                        fontWeight = FontWeight.Bold, color = Color.Black)
                }
            }
        }
    }
}


//@Preview
//@Composable
//fun PreviewLandingScreen() {
//    val authViewModel = remember { AuthViewModel(application = S) }
//    val navController = rememberNavController()
//
//    LandingScreen(authViewModel = authViewModel, navController = navController)
//}


