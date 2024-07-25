package com.nhatle.listview_kotlin.Listview_base

import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.nhatle.listview_kotlin.R

class MainActivity : AppCompatActivity() {
    private lateinit var ListLanguage: ListView
    private lateinit var languages: Array<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        languages = resources.getStringArray(R.array.programming_languages)
        ListLanguage = findViewById(R.id.lv_language)
        val lvLanguageAdapter = ArrayAdapter<String>(this, R.layout.list_item, languages)
        ListLanguage.adapter = lvLanguageAdapter
        //tao duong phan cach
        configDivider()
        // thiết lập phản hồi sự kiện khi một phần tử view được nhấn
        configEventHandler()
    }

    private fun configEventHandler() {
        // dấu gạch dưới có nghĩa là bỏ qua tham số đó vì không dùng tới
        ListLanguage.onItemClickListener =
            AdapterView.OnItemClickListener { _, _, position, _ ->
                Toast.makeText(
                    this,
                    languages[position],
                    Toast.LENGTH_SHORT
                ).show()
            }
//        ListLanguage.setOnItemClickListener { parent, view, position, id ->
//            Toast.makeText(
//                this,
//                languages[position],
//                Toast.LENGTH_SHORT
//            ).show()
//        }
    }

    private fun configDivider() {
        ListLanguage.divider =
            ColorDrawable(resources.getColor(R.color.orange, null))
        ListLanguage.dividerHeight = 2
    }
}