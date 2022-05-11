package com.tanawatnunnak.composepokemon.di

import com.tanawatnunnak.composepokemon.data.constants.Constants
import com.tanawatnunnak.composepokemon.data.remote.service.PokemonApi
import com.tanawatnunnak.composepokemon.data.repository.IPokemonRepository
import com.tanawatnunnak.composepokemon.data.repository.PokemonRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Singleton
    @Provides
    fun providePokemonRepository(
        api: PokemonApi,
        dispatcher: CoroutineDispatcher
    ): IPokemonRepository {
        return PokemonRepository(api, dispatcher)
    }

    @Singleton
    @Provides
    fun providePokemonApi(retrofit: Retrofit): PokemonApi {
        return retrofit.create(PokemonApi::class.java)
    }

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    fun provideDispatcher(): CoroutineDispatcher = Dispatchers.IO
}