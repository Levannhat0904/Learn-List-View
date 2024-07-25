package com.nhatle.listview_kotlin.Listview_advance.data

import com.fasterxml.jackson.annotation.JsonProperty

//"name": "India",
//"flag": "india.png",
//"capital": "New Delhi",
//"population": 1428.6,
//"density": 481,
//"area": 2973190,
//"world_share": "17.76 %"
data class Country(
    @JsonProperty("name")
    val name:String,
    @JsonProperty("flag")
    val flag:String,
    @JsonProperty("capital")
    val capital:String,
    @JsonProperty("population")
    val population:Float,
    @JsonProperty("density")
    val density:Int,
    @JsonProperty("area")
    val area:Int,
    @JsonProperty("world_share")
    val worldShare:String,
)
