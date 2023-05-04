package com.arkam.pockemonque.util

import androidx.compose.ui.graphics.Color
import com.arkam.pockemonque.data.remote.responses.Type
import com.arkam.pockemonque.data.remote.responses.Stat
import com.arkam.pockemonque.ui.theme.*
import java.util.*


//Pokemon types to their corresponding types colours.
fun parseTypeToColor(type: Type): Color {
    return when(type.type.name.lowercase(Locale.getDefault())) {
        "normal" -> TypeNormal
        "fire" -> TypeFire
        "water" -> TypeWater
        "electric" -> TypeElectric
        "grass" -> TypeGrass
        "ice" -> TypeIce
        "fighting" -> TypeFighting
        "poison" -> TypePoison
        "ground" -> TypeGround
        "flying" -> TypeFlying
        "psychic" -> TypePsychic
        "bug" -> TypeBug
        "rock" -> TypeRock
        "ghost" -> TypeGhost
        "dragon" -> TypeDragon
        "dark" -> TypeDark
        "steel" -> TypeSteel
        "fairy" -> TypeFairy
        else -> Color.Black
    }
}

//Pokemon stats to their corresponding colours.
fun parseStatToColor(stat: Stat): Color {
    return when(stat.stat.name.lowercase(Locale.getDefault())) {
        "hp" -> HPColor
        "attack" -> AtkColor
        "defense" -> DefColor
        "special-attack" -> SpAtkColor
        "special-defense" -> SpDefColor
        "speed" -> SpdColor
        else -> Color.White
    }
}

//Stat abbreviations.
fun parseStatToAbbr(stat: Stat): String {
    return when(stat.stat.name.lowercase(Locale.getDefault())) {
        "hp" -> "HP"
        "attack" -> "Atk"
        "defense" -> "Def"
        "special-attack" -> "SpAtk"
        "special-defense" -> "SpDef"
        "speed" -> "Spd"
        else -> ""
    }
}