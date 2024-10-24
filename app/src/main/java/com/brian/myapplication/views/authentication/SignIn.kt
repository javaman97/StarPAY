package com.brian.myapplication.views.authentication

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.brian.myapplication.R
import com.brian.myapplication.navigation.Screens
import com.brian.myapplication.ui.theme.afacadfluxFontFamily
import com.brian.myapplication.ui.theme.fontFamily
import com.brian.myapplication.views.components.AnimatedPreloader
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@Composable
fun SignInScreen( navController: NavController) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var isPasswordVisible by remember { mutableStateOf(false) }
    val isChecked = remember { mutableStateOf(false) }
    var isLoading by remember { mutableStateOf(false) }
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize().
                padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(8.dp))

        Box {
            AnimatedPreloader(modifier = Modifier.size(350.dp), R.raw.signin)
        }

        Text(text = "SignIn to StarPay", fontSize = 28.sp,     fontFamily = afacadfluxFontFamily,
            fontWeight = FontWeight.Bold)

        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            value = email,
            onValueChange = { email = it },
            label = { Text("Email"  ,  fontFamily = afacadfluxFontFamily,
                fontWeight = FontWeight.Light,) },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Email,
                    contentDescription = "Email Icon",
                    tint = Color.Gray
                )
            },
            singleLine = true,
            shape = RoundedCornerShape(20.dp)
        )
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            value = password,
            onValueChange = { password = it },
            label = { Text("Password",    fontFamily = afacadfluxFontFamily,
                fontWeight = FontWeight.Light,) },
            visualTransformation = if (isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            trailingIcon = {
                IconButton(onClick = { isPasswordVisible = !isPasswordVisible }) {
                    Icon(
                        imageVector = if (isPasswordVisible) Icons.Default.Visibility else Icons.Default.VisibilityOff,
                        contentDescription = if (isPasswordVisible) "Hide password" else "Show password",
                        tint = Color.Gray
                    )
                }
            },
            singleLine = true,
            shape = RoundedCornerShape(20.dp)
        )

        Box(modifier = Modifier.align(Alignment.End)) {
            Text("Forget Password?", color = Color.Gray,    fontFamily = afacadfluxFontFamily,
                fontWeight = FontWeight.Normal,)
        }

        Box(modifier = Modifier.align(Alignment.Start)){
            Row(verticalAlignment = Alignment.CenterVertically) {
                Checkbox(
                    checked = isChecked.value,
                    onCheckedChange = { isChecked.value = it }
                )
                Text(text = "Remember Me",fontFamily = afacadfluxFontFamily,
                    fontWeight = FontWeight.Normal,)
            }
        }


        Button(
            modifier = Modifier.fillMaxWidth(0.4f),
            onClick = {
                isLoading = true
                CoroutineScope(Dispatchers.IO).launch {
                    
                    withContext(Dispatchers.Main) {
                        isLoading = false
                        if (email.isNotBlank() && password.isNotBlank()) {
                            navController.navigate(Screens.Home.route)
                        } else {
                            Toast.makeText(context,"Email or Password is Empty", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            },
            colors = ButtonDefaults.buttonColors(
                Color.Black
            )
        ) {
            Text("Sign In", fontSize = 24.sp,fontFamily = afacadfluxFontFamily,
                fontWeight = FontWeight.SemiBold,)
        }

        Spacer(modifier = Modifier.height(14.dp))

        Button(
            onClick = {
                navController.navigate(Screens.FingerPrint.route)
            }, colors = ButtonDefaults.buttonColors(
                Color.White
            )
        ) {
            Text("Use Fingerprint", fontSize = 28.sp, fontFamily = afacadfluxFontFamily,
                fontWeight = FontWeight.SemiBold,color= Color.Black)
        }
    }
}



@Preview()
@Composable
fun PreviewSignInScreen() {
    val navController = rememberNavController()
    SignInScreen(navController = navController)

}



