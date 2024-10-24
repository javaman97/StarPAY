package com.brian.myapplication.views.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.brian.myapplication.R
import com.brian.myapplication.ui.theme.LightOrange
import com.brian.myapplication.ui.theme.LightPink
import com.brian.myapplication.ui.theme.afacadfluxFontFamily
import com.brian.myapplication.viewmodels.HomeViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarMain(
    navController: NavHostController,
    homeViewModel: HomeViewModel
) {
   TopAppBar(
       colors = TopAppBarDefaults.topAppBarColors(LightPink),
        title = {
            Text(
                text =  stringResource(id = R.string.app_name) ,
                fontWeight = FontWeight.ExtraBold,
               fontFamily = afacadfluxFontFamily,
                fontSize = 22.sp,
                color = Color.Black
            )
        },
        actions = {


            IconButton(
                onClick = {
                  //  navController.navigate(SETTING)
                },
            ) {
               Icon(
                   Icons.Filled.Settings,
                    "Settings Button",
                    modifier = Modifier.size(24.dp),
                    tint = Color.Black
                )
            }
        }
    )
}
