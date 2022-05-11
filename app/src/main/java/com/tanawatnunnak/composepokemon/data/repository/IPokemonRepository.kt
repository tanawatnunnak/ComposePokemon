package com.tanawatnunnak.composepokemon.data.repository

import com.tanawatnunnak.composepokemon.data.remote.response.PokemonDetailResponse
import com.tanawatnunnak.composepokemon.data.remote.response.PokemonsResponse
import com.tanawatnunnak.composepokemon.utlis.Resource

interface IPokemonRepository {
    suspend fun getPokemonList(limit: Int, offset: Int): Resource<PokemonsResponse>
    suspend fun getPokemonDetail(name: String): Resource<PokemonDetailResponse>
}