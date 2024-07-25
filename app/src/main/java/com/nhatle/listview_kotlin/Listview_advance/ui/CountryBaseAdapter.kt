package com.nhatle.listview_kotlin.Listview_advance.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.nhatle.listview_kotlin.Listview_advance.data.Country
import com.nhatle.listview_kotlin.Listview_advance.utils.CountryUltils
import com.nhatle.listview_kotlin.R

class CountryBaseAdapter : BaseAdapter() {

    private val countryList = mutableListOf<Country>()
    override fun getCount(): Int {
//         dung de tra ve so phan tu trong listview
        return countryList.size
    }

    override fun getItem(p0: Int): Any {
//        tra ve phan tu hien tai trong listview co tai vi tri p0
        return countryList[p0]
    }

    override fun getItemId(p0: Int): Long {
//        tra ve id cua phan tu hien tai trong listview co tai vi tri p0 hoac co the tra ve positon
        return p0.toLong()
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {

//        tra ve view dung de hien thi phan tu trong listview co tai vi tri p0, dung viewHolder
//        val holder: CountryViewHolder
//        var newConvertView = p1
//        if (p1 == null) {
//            val layoutInflater = LayoutInflater.from(p2?.context)
//            newConvertView = layoutInflater.inflate(R.layout.item_country, p2, false)
//            holder = CountryViewHolder(newConvertView)
//            newConvertView.tag = holder
//        } else {
//            holder = newConvertView?.tag as CountryViewHolder
//        }
//        holder.bind(countryList[p0])
//        return newConvertView!!
        //cach 2
        val view: View?
        val vh: CountryViewHolder
        if (p1 == null) {
            val mInflator = LayoutInflater.from(p2?.context)
            view = mInflator.inflate(R.layout.item_country, p2, false)
            vh = CountryViewHolder(view)
            view.tag = vh
        } else {
            view = p1
            vh = view.tag as CountryViewHolder
        }

        vh.bind(countryList[p0])
        return view!!
    }
    fun updateListCountry(list: List<Country>){
        this.countryList.clear()
        this.countryList.addAll(list)
        notifyDataSetChanged()
    }
    class CountryViewHolder(private val view: View){
        private val img_flag = view.findViewById<ImageView>(R.id.image_flag)
        private val textCountryName = view.findViewById<TextView>(R.id.text_country_name)
        private val textCapital = view.findViewById<TextView>(R.id.text_country_capital)
        fun bind(country: Country){
            //bind data
//            lay id anh
            img_flag.setImageResource(CountryUltils.getFlag(country.flag))
            textCountryName.text = country.name
            textCapital.text = country.capital
        }
    }
}