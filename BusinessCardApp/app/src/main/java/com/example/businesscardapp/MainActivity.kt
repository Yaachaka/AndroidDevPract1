package com.example.businesscardapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscardapp.ui.theme.BusinessCardAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BusinessCardApp()
                }
            }
        }
    }
}

@Composable
fun BusinessCardApp(modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.android_logo)
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = image,
                contentDescription = null,
                modifier = Modifier
                    .width(100.dp)
                    .height(100.dp)
                    .background(Color.Blue)
            )
            Text(
                text = "Yaachaka",
                fontSize = 34.sp
            )
            Text(
                text = "Junior Android Developer",
                fontSize = 16.sp,
                color = Color.Green
            )
        }    // inner first column

        Column(
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(top = 270.dp, bottom = 20.dp),

            ) {
            Row(
                horizontalArrangement = Arrangement.Absolute.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                val phoneIcon = painterResource(R.drawable.phoneicon)
                val phone = "080-1234-561789"
                ContactDisplay(icon = phoneIcon, string = phone)
            }
            Row(
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {
                val shareIcon = painterResource(R.drawable.shareicon)
                val connect = "@AndroidDev"
                ContactDisplay(icon = shareIcon, string = connect)
            }
            Row(
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {
                val emailIcon = painterResource(R.drawable.emailicon)
                val emailID = "yaachaka@android.com"
                ContactDisplay(icon = emailIcon, string = emailID)
            }
        }   // inner second column
    }    // Outermost column
}

@Composable
fun ContactDisplay(modifier: Modifier = Modifier, icon: Painter, string: String){
    Icon(
        painter = icon,
        contentDescription = null,
        modifier = modifier
            .width(20.dp)
            .height(20.dp)
            .padding(end = 10.dp)
    )
    Text(
        text = string
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BusinessCardAppTheme {
        BusinessCardApp()
    }
}