package com.arkam.pockemonque.repository

import com.arkam.pockemonque.data.remote.PokeApi
import com.arkam.pockemonque.data.remote.responses.Pokemon
import com.arkam.pockemonque.data.remote.responses.PokemonList
import com.arkam.pockemonque.util.Resource
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject


//The repository will live as long as the activity does.
@ActivityScoped
class PokemonRepository @Inject constructor(
    private val api: PokeApi
) {
    suspend fun getPokemonList(limit: Int, offset: Int): Resource<PokemonList> {
        val response = try {
            api.getPokemonList(limit, offset)
        }catch(e: Exception){
            return Resource.Error("An unknown error occurred.")
        }
        return Resource.Success(response)
    }

    suspend fun getPokemonInfo(pokemonName: String): Resource<Pokemon>{
        val response = try {
            api.getPokemonInfo(name = pokemonName)
        }catch(e: Exception){
            return Resource.Error("An unknown error occurred.")
        }
        return Resource.Success(response)
    }
}