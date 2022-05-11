package com.tanawatnunnak.composepokemon

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
import com.tanawatnunnak.composepokemon.ui.route.Arguments
import com.tanawatnunnak.composepokemon.ui.route.Routes
import com.tanawatnunnak.composepokemon.ui.theme.ComposePokemonTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposePokemonTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = Routes.POKEMON_LIST
                ) {
                    composable(Routes.POKEMON_LIST) {

                    }

                    composable(
                        route = Routes.POKEMON_DETAIL,
                        arguments = listOf(
                            navArgument(Arguments.POKEMON_COLOR) {
                                type = NavType.IntType
                            },
                            navArgument(Arguments.POKEMON_NAME) {
                                type = NavType.StringType
                            }
                        )
                    ) { entry ->
                        val pokemonColor = remember {
                            val color = entry.arguments?.getInt(Arguments.POKEMON_COLOR)
                            color?.let { Color(it) } ?: Color.White
                        }

                        val pokemonName = entry.arguments?.getString(Arguments.POKEMON_NAME)
                    }
                }
            }
        }
    }
}
