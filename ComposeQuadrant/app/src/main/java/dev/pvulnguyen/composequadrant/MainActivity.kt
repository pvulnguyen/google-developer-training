package dev.pvulnguyen.composequadrant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.pvulnguyen.composequadrant.ui.theme.ComposeQuadrantTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeQuadrantTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column(Modifier.fillMaxWidth()) {
                        Row(Modifier.weight(1f)) {
                            Card(
                                header = stringResource(R.string.composable_header_text),
                                body = stringResource(R.string.composable_body_text),
                                backgroundColor = colorResource(R.color.purple_200),
                                modifier = Modifier.weight(1f)
                            )
                            Card(
                                header = stringResource(R.string.composable_header_image),
                                body = stringResource(R.string.composable_body_image),
                                backgroundColor = colorResource(R.color.purple_300),
                                modifier = Modifier.weight(1f)
                            )
                        }
                        Row(Modifier.weight(1f)) {
                            Card(
                                header = stringResource(R.string.composable_header_row),
                                body = stringResource(R.string.composable_body_row),
                                backgroundColor = colorResource(R.color.purple_400),
                                modifier = Modifier.weight(1f)
                            )
                            Card(
                                header = stringResource(R.string.composable_header_column),
                                body = stringResource(R.string.composable_body_column),
                                backgroundColor = colorResource(R.color.purple_100),
                                modifier = Modifier.weight(1f)
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Card(
    header: String,
    body: String,
    backgroundColor: Color,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(backgroundColor)
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = header,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Text(
            text = body,
            textAlign = TextAlign.Justify
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeQuadrantTheme {
        Column(Modifier.fillMaxWidth()) {
            Row(Modifier.weight(1f)) {
                Card(
                    header = stringResource(R.string.composable_header_text),
                    body = stringResource(R.string.composable_body_text),
                    backgroundColor = colorResource(R.color.purple_200),
                    modifier = Modifier.weight(1f)
                )
                Card(
                    header = stringResource(R.string.composable_header_image),
                    body = stringResource(R.string.composable_body_image),
                    backgroundColor = colorResource(R.color.purple_300),
                    modifier = Modifier.weight(1f)
                )
            }
            Row(Modifier.weight(1f)) {
                Card(
                    header = stringResource(R.string.composable_header_row),
                    body = stringResource(R.string.composable_body_row),
                    backgroundColor = colorResource(R.color.purple_400),
                    modifier = Modifier.weight(1f)
                )
                Card(
                    header = stringResource(R.string.composable_header_column),
                    body = stringResource(R.string.composable_body_column),
                    backgroundColor = colorResource(R.color.purple_100),
                    modifier = Modifier.weight(1f)
                )
            }
        }
    }
}