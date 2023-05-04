package com.arkam.pockemonque.data.remote

import com.arkam.pockemonque.data.remote.responses.Pokemon
import com.arkam.pockemonque.data.remote.responses.PokemonList
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

//This retrofit interface defines that functions that will be used to request data from the pokeApi.
interface PokeApi {

    //Get tells us that the retrofit query is only seeking to get information and is not sending anything.
    //The string specifies what part of the URL the request should go to.
    @GET("pokemon")
    suspend fun getPokemonList(
        @Query("limit") limit: Int,
        @Query("offset") offset: Int
        ): PokemonList

    //The name passed within the suspend function will be passed to the URL.
    @GET("pokemon/{name}")
    suspend fun getPokemonInfo(
        @Path("name") name: String
    ): Pokemon
}