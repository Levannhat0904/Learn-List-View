package com.nhatle.listview_kotlin.Listview_advance.utils

import com.nhatle.listview_kotlin.R

//logic dung chung cho toan bo ung dung
object CountryUltils {
    private val idOfFlags = mapOf(
        "bangladesh.png" to R.drawable.bangladesh,
        "china.png" to R.drawable.china,
        "egypt.png" to R.drawable.egypt,
        "india.png" to R.drawable.india,
        "indonesia.png" to R.drawable.indonesia,
        "japan.png" to R.drawable.japan,
        "mexico.png" to R.drawable.mexico,
        "nigeria.png" to R.drawable.nigeria,
        "pakistan.png" to R.drawable.pakistan,
        "philippines.png" to R.drawable.philippines,
        "russia.png" to R.drawable.russia,
        "united_states.png" to R.drawable.united_states,
        "vietnam.png" to R.drawable.vietnam,
        "dr_congo.png" to R.drawable.dr_congo,
        "canada.png" to R.drawable.canada,
        "ethiopia.png" to R.drawable.ethiopia
    )

    fun getFlag(flag: String): Int {
        return idOfFlags[flag] ?: R.drawable.vietnam
    }
}