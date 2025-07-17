package com.ferhat.dailyspendcalculatorv2

import android.content.ContentResolver
import android.content.Context
import android.net.Uri

object FileProcesses {
    fun readCsv(context: Context, uri: Uri?): List<List<String>> {
        if (uri == null)
            return emptyList()
        val res = mutableListOf<List<String>>()
        context.contentResolver.openInputStream(uri)?.use {
            inputStream ->
                inputStream.bufferedReader().useLines {
                    lines ->
                        lines.forEach {
                            line ->
                                val columns = line.split(";")
                                res.add(columns)
                        }
                }
        }
        return res
    }
}