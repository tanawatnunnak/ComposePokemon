package com.tanawatnunnak.composepokemon.data.remote.service

import com.tanawatnunnak.composepokemon.data.remote.response.PokemonDetailResponse
import com.tanawatnunnak.composepokemon.data.remote.response.PokemonsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface PokemonApi {
    @GET("pokemon")
    suspend fun getPokemonList(
        @Query("limit") limit: Int,
        @Query("offset") offset: Int
    ): PokemonsResponse

    @GET("pokemon/{name}")
    suspend fun getPokemonDetail(
        @Query("name") name: String
    ): PokemonDetailResponse
}