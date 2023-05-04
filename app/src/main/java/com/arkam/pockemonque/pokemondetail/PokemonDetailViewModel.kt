package com.arkam.pockemonque.pokemondetail

import androidx.lifecycle.ViewModel
import com.arkam.pockemonque.data.remote.responses.Pokemon
import com.arkam.pockemonque.repository.PokemonRepository
import com.arkam.pockemonque.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


//The view model contains a function to retrieve the Pokemon specific information.
@HiltViewModel
class PokemonDetailViewModel @Inject constructor(
    private val repository: PokemonRepository
): ViewModel() {

    suspend fun getPokemonInfo(pokemonName: String): Resource<Pokemon>{
        return repository.getPokemonInfo(pokemonName)
    }
}