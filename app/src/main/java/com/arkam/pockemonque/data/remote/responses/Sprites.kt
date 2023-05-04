package com.arkam.pockemonque.data.remote.responses

data class Sprites(
    val back_default: String,
    val back_female: Any,
    val back_shiny: String,
    val back_shinyFemale: Any,
    val front_default: String,
    val front_female: Any,
    val front_shiny: String,
    val front_shinyFemale: Any,
    val other: Other,
    val versions: Versions
)