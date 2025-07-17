package com.ferhat.dailyspendcalculatorv2

import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

object CsvContentTable {
    @OptIn(ExperimentalLayoutApi::class)
    @Composable
    fun ColumnNamesLine(names: List<String>, innerPadding: PaddingValues){
        FlowRow {
            for (n in names){
                Text(n.removeSurrounding("\""), Modifier.padding(innerPadding))
                Text(" | ", Modifier.padding(innerPadding))
            }
        }
    }
}