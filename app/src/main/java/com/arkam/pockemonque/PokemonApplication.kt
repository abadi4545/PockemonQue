package com.arkam.pockemonque

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

//Gives Hilt access to the application context.
@HiltAndroidApp
class PokemonApplication:Application()