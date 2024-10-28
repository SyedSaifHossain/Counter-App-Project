package com.syedsaifhossain.counterappproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.vector.VectorProperty
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.syedsaifhossain.counterappproject.ui.theme.CounterAppProjectTheme
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CounterAppProjectTheme {
                CounterApp()
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CounterApp(modifier: Modifier = Modifier) {

        Scaffold( modifier = Modifier.fillMaxSize(),
            topBar = {
                TopAppBar(title =
                { Text(text = "Counter App Project",
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Bold)},

                    colors=topAppBarColors(
                        containerColor = Color.Black,
                        titleContentColor = Color.Cyan)
                ) }
        )
        {

            val counter = remember{ mutableStateOf(0) }
            Column(modifier=modifier.padding(it)
                .background(color = Color.Blue)
                .fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally) {

                Text(text = "This is Counter",
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Green)

                Spacer(modifier.height(20.dp))
                Text(text = "${counter.value}",
                    fontSize = 50.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Green)
                Spacer(modifier.height(50.dp))

                Row(modifier.fillMaxWidth().padding(20.dp),
                    horizontalArrangement = Arrangement.Center){
                    OutlinedButton(onClick = {
                    counter.value--
                    },
                        modifier.weight(1f),
                        border= BorderStroke(3.dp,Color.Green)
                    ) {

                    Text(text = "-",
                        fontSize = 30.sp,
                        color=Color.Green,
                        fontWeight = FontWeight.Bold
                        )
                    }
                    Spacer(modifier.padding(30.dp))

                    OutlinedButton(onClick = {
                        counter.value++ },
                        modifier.weight(1f),
                        border=BorderStroke(3.dp,Color.Green))
                    { Text(text = "+",
                            fontSize = 30.sp,
                            color=Color.Green,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }

        }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CounterAppProjectTheme {
        CounterApp()
    }
}