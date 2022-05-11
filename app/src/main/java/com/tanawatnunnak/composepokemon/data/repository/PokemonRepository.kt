package com.tanawatnunnak.composepokemon.data.repository

import com.tanawatnunnak.composepokemon.data.remote.response.PokemonDetailResponse
import com.tanawatnunnak.composepokemon.data.remote.response.PokemonsResponse
import com.tanawatnunnak.composepokemon.data.remote.service.PokemonApi
import com.tanawatnunnak.composepokemon.utlis.Resource
import com.tanawatnunnak.composepokemon.utlis.safeApiCall
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PokemonRepository @Inject constructor(
    private val pokemonApi: PokemonApi,
    private val dispatcher: CoroutineDispatcher
) : IPokemonRepository {

    override suspend fun getPokemonList(limit: Int, offset: Int): Resource<PokemonsResponse> {
        return safeApiCall(dispatcher) {
            pokemonApi.getPokemonList(limit, offset)
        }
    }

    override suspend fun getPokemonDetail(name: String): Resource<PokemonDetailResponse> {
        return safeApiCall(dispatcher) {
            pokemonApi.getPokemonDetail(name)
        }
    }
}