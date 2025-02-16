package com.example.assignment1_businesscardapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.assignment1_businesscardapp.ui.theme.Assignment1_BusinessCardAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Assignment1_BusinessCardAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    BusinessCardScreen(
                        modifier = Modifier.padding(innerPadding),
                    )
                    ContactInformation()
                }
            }
        }
    }
}

@Composable
fun BusinessCardScreen(modifier: Modifier = Modifier) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color(0xFFCAE8D0) // Background color
    ) {
        Column(
            modifier = Modifier.fillMaxSize().padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            BusinessCardApp(modifier = Modifier.weight(1f)) // Assign flexible height
        }
    }
}


@Composable
fun BusinessCardApp(modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(10.dp),
        modifier = Modifier.fillMaxSize()
            .padding(0.dp, 280.dp, 0.dp, 0.dp)
    ) {
        Box{
            Image(
                painter = painterResource(R.drawable.android_logo),
                contentDescription = null,
                modifier = modifier.height(140.dp)
                    .width(140.dp)
                    .background(Color(0xFF0D333D))
                    .padding(10.dp)
            )
        }
        Text(
            text = "Jennifer Doe",
            fontSize = 50.sp
        )
        Text(
            text = "Android Developer Extraordinaire",
            color = Color(0xFF3ddc84),
            fontSize = 20.sp,
            fontWeight = FontWeight.ExtraBold
        )
    }
}


@Composable
fun ContactInformation(modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom,
        modifier = Modifier.fillMaxSize()
            .padding(80.dp)
    ) {
        ContactRow(icon = Icons.Filled.Call, text = "+11 (123) 444 555 666", tint = Color(0xFF3ddc84))
        ContactRow(icon = Icons.Filled.Share, text = "@AndroidDev", tint = Color(0xFF3ddc84))
        ContactRow(icon = Icons.Filled.Email, text = "jen.doe@android.com", tint = Color(0xFF3ddc84))
    }
}

@Composable
fun ContactRow(icon: ImageVector, text: String, tint: Color) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(20.dp),
        modifier = Modifier.fillMaxWidth()
            .padding(10.dp)
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = tint, // Customize color to fit the business card style
            modifier = Modifier.size(24.dp)
        )
        Text(
            text = text,
            fontSize = 20.sp,
            textAlign = TextAlign.Start,

        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Assignment1_BusinessCardAppTheme {
        BusinessCardScreen()
        ContactInformation()
    }
}