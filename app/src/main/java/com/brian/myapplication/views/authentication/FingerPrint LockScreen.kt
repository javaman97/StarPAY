package com.brian.myapplication.views.authentication

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import androidx.biometric.BiometricPrompt
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.content.ContextCompat
import androidx.navigation.NavHostController
import com.brian.myapplication.viewmodels.AuthViewModel


@Composable
fun FingerPrintLockScreen(authViewModel: AuthViewModel, navController: NavHostController) {
    val context = LocalContext.current
    val activity = context.findActivity()
    val executor = ContextCompat.getMainExecutor(context)
    var showPinPrompt by remember { mutableStateOf(false) }

    val promptInfo = BiometricPrompt.PromptInfo.Builder()
        .setTitle("Biometric Authentication")
        .setSubtitle("Log in using your fingerprint")
        .setNegativeButtonText("Use PIN")
        .build()

    if (showPinPrompt) {
        PinAuthenticationUI { showPinPrompt = false }
    } else {
        Button(onClick = {
            activity?.let {
                BiometricPrompt(it, executor, object : BiometricPrompt.AuthenticationCallback() {
                    override fun onAuthenticationError(errorCode: Int, errString: CharSequence) {
                        super.onAuthenticationError(errorCode, errString)
                        // Handle error
                    }

                    override fun onAuthenticationSucceeded(result: BiometricPrompt.AuthenticationResult) {
                        super.onAuthenticationSucceeded(result)
                        // Authentication succeeded
                    }

                    override fun onAuthenticationFailed() {
                        super.onAuthenticationFailed()
                        // Handle failure
                    }
                })
            }?.authenticate(promptInfo)
        }) {
            Text("Authenticate")
        }
    }
}


@Composable
fun PinAuthenticationUI(onPinEntered: () -> Unit) {
    var pin by remember { mutableStateOf("") }

    Column {
        TextField(
            value = pin,
            onValueChange = { pin = it },
            label = { Text("Enter PIN") }
        )
        Button(onClick = {
            // Check PIN here
            onPinEntered()
        }) {
            Text("Submit")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PinScreenPreview() {
    PinAuthenticationUI(onPinEntered = {})
}

fun Context.findActivity(): AppCompatActivity? {
    return this as? AppCompatActivity
}





