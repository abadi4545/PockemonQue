package com.arkam.pockemonque.di

import com.arkam.pockemonque.data.remote.PokeApi
import com.arkam.pockemonque.repository.PokemonRepository
import com.arkam.pockemonque.util.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
//The repository and Api are included here, so dagger hilt knows what dependencies we want to inject into the viewmodels.

    @Singleton
    @Provides
    fun providePokemonRepository(
        api: PokeApi
    ) = PokemonRepository(api)


    //The Gson converter factory will convert the JSON files into the Kotlin data classes.
    @Singleton
    @Provides
    fun providePokeApi(): PokeApi {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(PokeApi::class.java)
    }


}