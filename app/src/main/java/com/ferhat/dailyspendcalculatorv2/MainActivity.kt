package com.ferhat.dailyspendcalculatorv2

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ferhat.dailyspendcalculatorv2.ui.theme.DailySpendCalculatorV2Theme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // Reading CSV file from the bank app
        if (intent?.action == Intent.ACTION_SEND && intent.type?.contains("csv") == true) {
            val csvUri = intent.getParcelableExtra(Intent.EXTRA_STREAM, Uri::class.java)
            val csvContent = FileProcesses.readCsv(this, csvUri)
            setContent {
                DailySpendCalculatorV2Theme {
                    Scaffold(
                        modifier = Modifier.fillMaxSize()) { innerPadding ->
                        Column {
                            Spacer(modifier = Modifier.height(32.dp).padding( innerPadding))
                            CsvContentTable.ColumnNamesLine(csvContent[0])
                        }
                    }
                }
            }
        }
        else {
            setContent {
                DailySpendCalculatorV2Theme {
                    Scaffold(
                        modifier = Modifier.fillMaxSize()) { innerPadding ->
                        Text("-")
                        Spacer(modifier = Modifier.height(32.dp).padding( innerPadding))
                        Greeting(
                            name = "Android",
                            modifier = Modifier.padding(innerPadding)
                        )
                    }
                }
            }

        }

    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    DailySpendCalculatorV2Theme {
        Greeting("Android")
    }
}