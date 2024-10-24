package com.brian.myapplication.views.authentication

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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

@Composable
fun SignUpScreen(navController: NavController) {
    var username by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var isPasswordVisible by remember { mutableStateOf(false) }
   //Glassmorpshism()

    Column(
        modifier = Modifier
            .fillMaxSize()
        , horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box {
            AnimatedPreloader(modifier = Modifier.size(250.dp), R.raw.signup)
        }
        Text(text = "Welcome to StarPay", fontSize = 28.sp,fontFamily = afacadfluxFontFamily,
            fontWeight = FontWeight.Bold )
        Text(text = "Signup to continue", fontSize = 24.sp, fontFamily = afacadfluxFontFamily,
            fontWeight = FontWeight.Medium, )
        OutlinedTextField(modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp), value = username, onValueChange = { username = it }, label = { Text("Username",fontFamily = afacadfluxFontFamily,
            fontWeight = FontWeight.Light,) }, leadingIcon = {
           Icon( imageVector =  Icons.Default.Person,
            contentDescription = "User Name Icon",
            tint = Color.Gray
        )}, singleLine = true, shape = RoundedCornerShape(20.dp))

        OutlinedTextField(modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp), value = email, onValueChange = { email = it }, label = { Text("Email",fontFamily = afacadfluxFontFamily,
            fontWeight = FontWeight.Light,) }, leadingIcon = {
            Icon( imageVector =  Icons.Default.Email,
                contentDescription = "Email Icon",
                tint = Color.Gray
            )}, singleLine = true, shape = RoundedCornerShape(20.dp))

        Spacer(modifier = Modifier.height(5.dp))

        OutlinedTextField(modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp), value = password, onValueChange = { password = it }, label = { Text("Password",fontFamily = afacadfluxFontFamily,
            fontWeight = FontWeight.Light,) },   visualTransformation = if (isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            trailingIcon = {
                IconButton(onClick = { isPasswordVisible = !isPasswordVisible }) {
                    Icon(
                        imageVector =  if (isPasswordVisible) Icons.Default.Visibility else Icons.Default.VisibilityOff,
                        contentDescription = if (isPasswordVisible) "Hide password" else "Show password",
                        tint = Color.Gray
                    )
                }
            }, singleLine = true, shape = RoundedCornerShape(20.dp))


        OutlinedTextField(modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp), value = password, onValueChange = { password = it }, label = { Text("Confirm Password",fontFamily = afacadfluxFontFamily,
            fontWeight = FontWeight.Light,) },   visualTransformation = if (isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            trailingIcon = {
                IconButton(onClick = { isPasswordVisible = !isPasswordVisible }) {
                    Icon(
                        imageVector =  if (isPasswordVisible) Icons.Default.Visibility else Icons.Default.VisibilityOff,
                        contentDescription = if (isPasswordVisible) "Hide password" else "Show password",
                        tint = Color.Gray
                    )
                }
            }, singleLine = true, shape = RoundedCornerShape(20.dp))

        Spacer(modifier = Modifier.height(5.dp))

        Button(modifier = Modifier.fillMaxWidth(0.4f),onClick = { navController.navigate(Screens.SignIn.route)}, colors = ButtonDefaults.buttonColors(Color.Black)) {
            Text("Sign Up", fontSize = 24.sp,fontFamily = afacadfluxFontFamily,
                fontWeight = FontWeight.SemiBold,)
        }
        Spacer(modifier = Modifier.height(8.dp))

        Text("Already SignIn ?", fontSize = 20.sp,fontFamily = afacadfluxFontFamily,
            fontWeight = FontWeight.Normal, color = Color.Gray)
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewLandingScreen() {
    val navController = rememberNavController()

     SignUpScreen(navController = navController)

}





//@Composable
//fun Glassmorpshism() {
//    val scrollState = rememberScrollState()
//    Box(
//    ) {
//        Image(
//            painter = painterResource(id = R.drawable.background),
//            contentDescription = "background",
//            modifier = Modifier
//                .fillMaxSize()
//                .blur(7.dp),
//            contentScale = ContentScale.Crop,
//        )
//        Column(
//            modifier = Modifier
//                .fillMaxSize()
//                .background(Color(0xDD000000)),
//            horizontalAlignment = Alignment.CenterHorizontally,
//            verticalArrangement = Arrangement.SpaceEvenly
//        ) {
//            Column(
//                modifier = Modifier
//                    .padding(top = 40.dp)
//                    .fillMaxHeight()
//                    .verticalScroll(scrollState),
//                verticalArrangement = Arrangement.SpaceEvenly,
//            ) {
//                fullCard(icon = Icons.Rounded.WbSunny, 65, "San Francisco, California")
//                fullCard(icon = Icons.Rounded.WbCloudy, 54, "Seattle, Washington")
//                fullCard(icon = Icons.Rounded.AcUnit, 2, "Detroit, Michigan")
//
//            }
//
//        }
//    }
//}
//
//
//@Composable
//fun fullCard(icon: ImageVector, temp: Int, place: String) {
//    var tint = if (icon == Icons.Rounded.WbSunny) {
//        Color(0xFFE9E38C)
//    } else if (icon == Icons.Rounded.WbCloudy) {
//        Color(0xFF5CA9E6)
//    } else {
//        Color(0xFFFFFFFF)
//    }
//    Card(
//        modifier = Modifier
//            .padding(vertical = 16.dp)
//            .width(300.dp)
//            .height(325.dp),
//        backgroundColor = Color(0xFFFFFFF),
//        border = BorderStroke(1.dp, color = Color(0x25FFFFFF)),
//        shape = RoundedCornerShape(16.dp)
//    ) {
//        Box(
//            modifier = Modifier
//                .fillMaxSize()
//                .alpha(1f)
//                .blur(
//                    radius = 28.dp,
//                    edgeTreatment = BlurredEdgeTreatment.Unbounded
//                )
//                .background(
//                    Brush.radialGradient(
//                        listOf(
//                            Color(0x12FFFFFF),
//                            Color(0xDFFFFFF),
//                            Color(0x9FFFFFFF)
//
//                        ),
//                        radius = 2200f,
//                        center = Offset.Infinite
//                    )
//                )
//
//
//        ) {
//
//        }
//        Column(
//            verticalArrangement = Arrangement.Center,
//            horizontalAlignment = Alignment.CenterHorizontally
//        ) {
//            Icon(
//                imageVector = icon,
//                contentDescription = "Sunny",
//                modifier = Modifier.size(88.dp),
//                tint = tint
//            )
//            Spacer(modifier = Modifier.padding(vertical = 8.dp))
//            Text(
//                text = "$temp°",
//                style = MaterialTheme.typography.headlineMedium
//            )
//            Spacer(modifier = Modifier.padding(vertical = 8.dp))
//            Text(text = place)
//        }
//    }
//}

