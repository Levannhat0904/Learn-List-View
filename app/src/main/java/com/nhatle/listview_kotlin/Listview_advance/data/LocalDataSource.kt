package com.nhatle.listview_kotlin.Listview_advance.data
import android.content.res.Resources
import com.fasterxml.jackson.core.JsonParseException
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.nhatle.listview_kotlin.R
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.io.StringWriter

class LocalDataSource(private val resources: Resources) {
    fun loadCountry(): List<Country> {
        val jsonString = readJsonFile()
        println(jsonString)
        val mapper = jacksonObjectMapper()
//        chuyen json sang list object
        return try {
//            mapper.readValue(jsonString,Array<Country>::class.java).toList()
//            cach khac
            mapper.readValue<List<Country>>(jsonString)
//            val listCountry: List<Country> = mapper.readValue(jsonString)
//            List<User> = mapper.readValue(json)
        }catch (_:JsonParseException){
            emptyList()
        }
    }
    //doc json tu file
    private fun readJsonFile(): String {

        val writer = StringWriter()
        val buffer = CharArray(1024)
        try {
            resources.openRawResource(R.raw.country).use { inputStream ->
                val reader = BufferedReader(InputStreamReader(inputStream, "UTF-8"))
                var n: Int
                while (reader.read(buffer).also { n = it } != -1) {
                    writer.write(buffer, 0, n)
                }
            }
        }catch (_:IOException){

        }
        return writer.toString()
    }

}