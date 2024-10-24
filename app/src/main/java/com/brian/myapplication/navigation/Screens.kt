package com.brian.myapplication.navigation

sealed class Screens(val route: String) {
    object Landing : Screens("landing")
    object Home : Screens("home")
    object SignIn : Screens("sign_in")
    object SignUp : Screens("sign_up")
    object FingerPrint : Screens("fingerprint")
    object TransactionScreen : Screens("transaction")
    object TransactionDetail : Screens("transaction_detail/{transactionId}") {
        fun createRoute(transactionId: String) = "transaction_detail/$transactionId"
    }
    object Account : Screens("account")
    object Search : Screens("search")
    object Notifications : Screens("notifications")
    object UserDetails : Screens("user_details/{userId}") {
        fun createRoute(userId: String) = "user_details/$userId"
    }
}