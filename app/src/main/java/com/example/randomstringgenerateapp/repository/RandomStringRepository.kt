package com.example.randomstringgenerateapp.repository

import android.content.ContentResolver
import android.net.Uri
import android.os.Bundle
import com.example.randomstringgenerateapp.model.RandomText
import org.json.JSONObject
import javax.inject.Inject

class RandomStringRepository @Inject constructor(private val contentResolver: ContentResolver) {
    fun fetchRandomString(maxLength: Int): RandomText? {
        val uri = Uri.parse("content://com.iav.contestdataprovider/text")
        val cursor = contentResolver.query(
            uri, null, null, null,
            Bundle().apply { putInt(ContentResolver.QUERY_ARG_LIMIT, maxLength) }.toString()
        )
        cursor?.use {
            if (it.moveToFirst()) {
                val jsonString = it.getString(it.getColumnIndexOrThrow("data"))
                val jsonObject = JSONObject(jsonString).getJSONObject("randomText")
                return RandomText(
                    value = jsonObject.getString("value"),
                    length = jsonObject.getInt("length"),
                    created = jsonObject.getString("created")
                )
            }
        }
        return null
    }
}