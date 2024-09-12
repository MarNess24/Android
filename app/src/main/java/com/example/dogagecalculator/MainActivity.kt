// Layla Vanessa González Martínez 21130868

package com.example.dogagecalculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.dogagecalculator.ui.theme.DogAgeCalculatorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DogAgeCalculatorTheme {
                Surface( modifier = Modifier, color = MaterialTheme.colorScheme.background ) {
                    Greeting( modifier = Modifier)
                }
            }
        }
    }
}

@Composable
fun Greeting(modifier: Modifier = Modifier) {
    val imagen = painterResource ( id = R.drawable.perrito )

    Column (
        verticalArrangement = Arrangement.Top,
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image (
            painter = imagen,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .height( 500.dp )
                .padding( top = 30.dp )
        )

        var ageN by remember {
            mutableStateOf ( TextFieldValue ( "" ) )
        }

        OutlinedTextField (
            value = ageN,
            label = { Text ( text = "Enter your age", fontSize = 18.sp ) },
            keyboardOptions = KeyboardOptions ( keyboardType = KeyboardType.Number ),
            onValueChange = { newText -> ageN = newText},
            leadingIcon = { Icon ( imageVector = Icons.Default.Star, contentDescription = "icon" ) },
            modifier = modifier
                .padding(15.dp)
        )

        Button(
            onClick = {
                // Calculate age
            },
            colors = ButtonDefaults.buttonColors( containerColor = Color( 0xFF542579 ) ),
            //modifier = modifier
              //  .padding(15.dp)
        ) {
            Text (
                text = "Calculate",
                fontSize = 20.sp,
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    DogAgeCalculatorTheme {
        Greeting()
    }
}