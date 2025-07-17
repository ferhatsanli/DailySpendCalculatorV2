package com.ferhat.dailyspendcalculatorv2

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ferhat.dailyspendcalculatorv2.layouts.DataTable
import com.ferhat.dailyspendcalculatorv2.layouts.TestDataTable
import com.ferhat.dailyspendcalculatorv2.ui.theme.DailySpendCalculatorV2Theme
import android.widget.Toast


class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ToastUtils.init(this)
        enableEdgeToEdge()
        Log.i("FERHAT", "onCreate: started, INTENT: ${intent.type?.toString()}")
        // Reading CSV file from the bank app
        if (intent?.action == Intent.ACTION_SEND && intent.type?.contains("text/csv") == true) {
            val csvUri = intent.getParcelableExtra(Intent.EXTRA_STREAM, Uri::class.java)
            val csvContent = FileProcesses.readCsv(this, csvUri)
            setContent {
                Column {
                    Spacer(Modifier.height(32.dp))
                    DataTable(
                        csvContent,
                        true
                    )
                }
            }
        }
        else {
            Log.i("FERHAT", "onCreate: else block")
            setContent {
                Column {
                    Spacer(Modifier.height(32.dp))
                    TestDataTable()
                }
            }

        }

    }


}

object ToastUtils {
    private var appContext: android.content.Context? = null

    fun init(context: android.content.Context) {
        appContext = context.applicationContext
    }

    fun showMessage(text: String) {
        appContext?.let {
            Toast.makeText(it, text, Toast.LENGTH_SHORT).show()
        }
    }
}