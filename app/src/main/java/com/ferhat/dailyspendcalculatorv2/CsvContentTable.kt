package com.ferhat.dailyspendcalculatorv2

import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

object CsvContentTable {
    @OptIn(ExperimentalLayoutApi::class)
    @Composable
    fun ColumnNamesLine(names: List<String>){
        FlowRow {
            for (n in names){
                Text(n.removeSurrounding("\""))
                Text(" | ")
            }
        }
    }
}