package com.ferhat.dailyspendcalculatorv2.layouts

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ferhat.dailyspendcalculatorv2.ToastUtils
import com.ferhat.dailyspendcalculatorv2.ui.theme.DailySpendCalculatorV2Theme
import com.ferhat.dailyspendcalculatorv2.toInt

@Composable
fun DataTable(inputData: List<List<String>>,
              yesColumnNames: Boolean = false,
              modifier: Modifier = Modifier) {
    DailySpendCalculatorV2Theme {
        Column {
            // Column Names Row
            Row (modifier.fillMaxWidth()) {
                if (yesColumnNames){
                    // custom column names in the first line of the data
                    for (colName in inputData[0]){
                        ColumnNameCell(colName, modifier.weight(1.0f))
                    }
                }
                else {
                    // Random incremental column names
                    for (i in 1..inputData[0].size + 1) {
                        ColumnNameCell("Column $i", modifier.weight(1.0f))
                    }
                }

            }
            // Data Rows
            for (iRow in (yesColumnNames.toInt())..inputData.size - 1) {
                Row (Modifier.fillMaxWidth()) {
                    for (colVal in inputData[iRow])
                        DataCell(colVal, modifier = modifier.weight(1.0f))
                }
            }
        }
    }

}
@Composable
fun ColumnNameCell(name: String, modifier: Modifier){
    Text(name.removeSurrounding("\""),
        modifier
        .border(2.dp, MaterialTheme.colorScheme.onSecondaryContainer)
        .background(MaterialTheme.colorScheme.secondary )
        .padding(4.dp),
        maxLines = 1,
        overflow = TextOverflow.Ellipsis
    )
}

@Preview(showBackground = true)
@Composable
fun ColumnNameCellPreview(){
    Row{
        ColumnNameCell("Name", Modifier.weight(1.0f))
    }
}

@Composable
fun DataCell(value: String, modifier: Modifier) {
    Text(
        value.removeSurrounding("\""),
        modifier
            .border(1.dp, MaterialTheme.colorScheme.onPrimaryContainer)
            .background(MaterialTheme.colorScheme.primary)
            .padding(2.dp)
            .clickable {
                ToastUtils.showMessage(value)
            },
        maxLines = 1,
        overflow = TextOverflow.Ellipsis
    )
}

@Preview(showBackground = true)
@Composable
fun DataCellPreview() {
    Column{
        Row (modifier = Modifier.width(50.dp)){
            DataCell("Value", modifier = Modifier.weight(1.0f))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TestColumnNames() {
    Row{
        for (i in 1..3){
            ColumnNameCell("Col $i", Modifier.weight(1.0f))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DataTablePreview(){
    DataTable(
        listOf(
            listOf("Name", "Description", "Cost"),
            listOf("Vomar", "Eggs", "3.59"),
            listOf("Pathe", "Movie", "12.99"),
            listOf("Basic-Fit", "GYM", "32.99")
        ), true,
        modifier = Modifier)
}

@Composable
fun TestDataTable(){
    DataTable(
        listOf(
            listOf("Name", "Description", "Cost"),
            listOf("Vomar", "Eggs", "3.59"),
            listOf("Pathe", "Movie", "12.99"),
            listOf("Basic-Fit", "GYM", "32.99")
        ), true)
}