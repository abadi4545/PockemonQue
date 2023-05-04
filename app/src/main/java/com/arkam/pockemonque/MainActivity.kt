package com.arkam.pockemonque

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.arkam.pockemonque.pokemondetail.PokemonDetailScreen
import com.arkam.pockemonque.pokemonlist.PokemonListScreen
import com.arkam.pockemonque.ui.theme.PokemonProjectTheme
import dagger.hilt.android.AndroidEntryPoint
import java.util.*

//@HiltAndroidApp
//class PokemonApplication: Application()

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            //All compose screens within this will use the project theme.
            PokemonProjectTheme {
                //Simple nav graph allows navigation between composable screens.
                val navController = rememberNavController()
                //As this is a relatively simple application that will not have many screens, defining the screens
                //in the main activity seems most efficient. If screen numbers increase, the nav-controller logic can be
                //written in a separate Kotlin object file.
                NavHost(
                    navController = navController,
                    startDestination = "pokemon_list_screen"
                ){
                    composable("pokemon_list_screen"){
                        PokemonListScreen(navController = navController)
                    }
                    //This screen takes the dominantColor (Pokemon type specific) and the pokemon name,
                    //This will then allow the colour of the screen to reflect the pokemon type, and the name will allow
                    //the pokemon to be searched for.
                    composable(
                        "pokemon_detail_screen/{dominantColor}/{pokemonName}",
                        arguments = listOf(
                            navArgument("dominantColor"){
                                type = NavType.IntType
                            },
                            navArgument("pokemonName"){
                                type = NavType.StringType
                            }
                        )
                    ){
                        //If the dominant color call returns null, then the default returned color will be white.
                        val dominantColor = remember {
                            val color = it.arguments?.getInt("dominantColor")
                            color?.let{ Color(it) } ?: Color.White
                        }
                        val pokemonName = remember {
                            it.arguments?.getString("pokemonName")
                        }
                        PokemonDetailScreen(
                            dominantColor = dominantColor,
                            pokemonName = pokemonName?.lowercase(Locale.ROOT) ?: "",
                            navController = navController)
                    }
                }
            }
        }
    }
}