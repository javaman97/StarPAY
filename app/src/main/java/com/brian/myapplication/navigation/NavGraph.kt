package com.brian.myapplication.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.brian.myapplication.views.AccountScreen
import com.brian.myapplication.views.HomeScreen
import com.brian.myapplication.views.authentication.LandingScreen
import com.brian.myapplication.views.NotificationScreen
import com.brian.myapplication.views.SearchScreen
import com.brian.myapplication.views.authentication.SignInScreen
import com.brian.myapplication.views.authentication.SignUpScreen
import com.brian.myapplication.views.TransactionDetailScreen
import com.brian.myapplication.views.TransactionsListScreen
import com.brian.myapplication.views.UserDetailsScreen
import com.brian.myapplication.viewmodels.AuthViewModel
import com.brian.myapplication.views.authentication.FingerPrintLockScreen

@Composable
fun NavGraph(authViewModel: AuthViewModel, navController: NavHostController, showAppBar: MutableState<Boolean>) {
    val isAuthenticated by authViewModel.isAuthenticated.observeAsState(initial = false)

    val startDestination = if (isAuthenticated) {
        Screens.Home.route
    } else {
        Screens.Landing.route
    }

    NavHost(navController, startDestination = startDestination, Modifier.padding(8.dp)) {

            composable(Screens.Landing.route) {
                showAppBar.value = false
                LandingScreen(authViewModel, navController)
            }
            composable(Screens.SignIn.route) {
                showAppBar.value = false
                SignInScreen( navController)
            }
            composable(Screens.SignUp.route) {
                showAppBar.value = false
                SignUpScreen(navController)
            }
            composable(Screens.FingerPrint.route) {
                showAppBar.value = false
                FingerPrintLockScreen(authViewModel,navController)
            }

            composable(Screens.Home.route) {
                showAppBar.value = true
                HomeScreen()
            }
            composable(Screens.TransactionScreen.route) {
                showAppBar.value = true
                TransactionsListScreen()
            }
            composable(Screens.TransactionDetail.route) { backStackEntry ->
                val transactionId = backStackEntry.arguments?.getString("transactionId")
                showAppBar.value = true
                TransactionDetailScreen(transactionId ?: "Unknown")
            }
            composable(Screens.Account.route) {
                showAppBar.value = true
                AccountScreen(authViewModel)
            }
            composable(Screens.Search.route) {
                showAppBar.value = true
                SearchScreen()
            }
            composable(Screens.Notifications.route) {
                showAppBar.value = true
                NotificationScreen()
            }
            composable(Screens.UserDetails.route) {
                    backStackEntry ->
                val userId = backStackEntry.arguments?.getString("userId")
                showAppBar.value = true
                UserDetailsScreen(userId ?: "Unknown")
            }
        }
    }