package dev.pvulnguyen.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.twotone.Email
import androidx.compose.material.icons.twotone.Phone
import androidx.compose.material.icons.twotone.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.pvulnguyen.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Card(
                        image = painterResource(R.drawable.android_logo),
                        name = stringResource(R.string.name),
                        title = stringResource(R.string.title),
                        phone = stringResource(R.string.phone),
                        handle = stringResource(R.string.handle),
                        email = stringResource(R.string.email),
                        backgroundColor = colorResource(R.color.background)
                    )
                }
            }
        }
    }
}

@Composable
fun Card(
    image: Painter,
    name: String,
    title: String,
    phone: String,
    handle: String,
    email: String,
    backgroundColor: Color,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = modifier.fillMaxSize().background(backgroundColor)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier.padding(top = 288.dp)
        ) {
            CardImage(image = image)
            Person(name = name, title = title)
        }
        ContactInformation(phone = phone, handle = handle, email = email)
    }
}

@Composable
fun CardImage(image: Painter, modifier: Modifier = Modifier) {
    Column(modifier = modifier.size(96.dp)) {
        Box(modifier = modifier.background(colorResource(R.color.background_logo))) {
            Image(
                painter = image,
                contentDescription = null
            )
        }
    }
}

@Composable
fun Person(name: String, title: String, modifier: Modifier = Modifier) {
    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = modifier) {
        Text(
            text = name,
            fontSize = 48.sp,
            fontWeight = FontWeight.Light
        )
        Text(
            text = title,
            fontSize = 24.sp,
            fontWeight = FontWeight.SemiBold
        )
    }
}

@Composable
fun ContactInformation(
    phone: String,
    handle: String,
    email: String,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.padding(16.dp)) {
        Row {
            Icon(
                Icons.TwoTone.Phone,
                contentDescription = "Phone"
            )
            Spacer(modifier = modifier.size(16.dp))
            Text(
                text = phone,
                modifier = modifier.padding(bottom = 16.dp)
            )
        }
        Row {
            Icon(
                Icons.TwoTone.Share,
                contentDescription = "Social Media"
            )
            Spacer(modifier = modifier.size(16.dp))
            Text(
                text = handle,
                modifier = modifier.padding(bottom = 16.dp)
            )
        }
        Row {
            Icon(
                Icons.TwoTone.Email,
                contentDescription = "Email"
            )
            Spacer(modifier = modifier.size(16.dp))
            Text(
                text = email,
                modifier = modifier.padding(bottom = 16.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BusinessCardTheme {
        Card(
            image = painterResource(R.drawable.android_logo),
            name = stringResource(R.string.name),
            title = stringResource(R.string.title),
            phone = stringResource(R.string.phone),
            handle = stringResource(R.string.handle),
            email = stringResource(R.string.email),
            backgroundColor = colorResource(R.color.background)
        )
    }
}