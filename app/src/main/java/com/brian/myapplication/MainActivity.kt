package com.brian.myapplication

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.brian.myapplication.navigation.NavGraph
import com.brian.myapplication.ui.theme.StarPAYTheme
import com.brian.myapplication.views.components.BottomNavigationBar
import com.brian.myapplication.views.components.TopAppBarMain
import com.brian.myapplication.viewmodels.AuthViewModel
import com.brian.myapplication.viewmodels.HomeViewModel

private const val TAG = "MainActivity"

class MainActivity : ComponentActivity() {
    private val SMS_PERMISSION_CODE = 1
    private lateinit var authViewModel: AuthViewModel
    private lateinit var homeViewModel: HomeViewModel
    private lateinit var navController: NavHostController

    // Declare an ActivityResultLauncher for SMS permissions
    private lateinit var smsPermissionLauncher: ActivityResultLauncher<String>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Initialize the permission launcher
        smsPermissionLauncher = registerForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted ->
            if (isGranted) {
                // Permission granted, handle any additional logic if needed
            } else {
                // Permission denied, show a message or handle accordingly
            }
        }

        requestSmsPermission()

        authViewModel = ViewModelProvider(this).get(AuthViewModel::class.java)
        homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)

        setContent {
            StarPAYTheme {
                navController = rememberNavController()
                val showAppBar = remember { mutableStateOf(true) }

                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = {
                        if (showAppBar.value) {
                            TopAppBarMain(
                                navController = navController,
                                homeViewModel = homeViewModel
                            )
                        }
                    },
                    bottomBar = {
                        if (showAppBar.value) {
                            BottomNavigationBar(navController)
                        }
                    }
                ) { paddingValues ->
                    Column(Modifier.padding(paddingValues)) {
                        NavGraph(
                            authViewModel,
                            navController,
                            showAppBar
                        )
                    }
                }
            }
        }
    }


    private fun requestSmsPermission() {
        // Check if the permission is already granted
        when {
            ContextCompat.checkSelfPermission(this, Manifest.permission.RECEIVE_SMS) == PackageManager.PERMISSION_GRANTED -> {
                // Permission already granted
            }
            else -> {
                // Request the permission
                smsPermissionLauncher.launch(Manifest.permission.RECEIVE_SMS)
            }
        }
    }




}
