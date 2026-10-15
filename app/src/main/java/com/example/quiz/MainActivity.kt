package com.example.quiz

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.quiz.screen.Perguntas
import com.example.quiz.screen.Resultado
import com.example.quiz.screen.TelaInicial
import com.example.quiz.ui.theme.QuizTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            QuizTheme {
                val navController = rememberNavController()

                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    NavHost(
                        navController = navController,
                        startDestination = "telainicial"
                    ) {
                        composable(route = "telainicial") {
                            TelaInicial(
                                modifier = Modifier.padding(innerPadding),
                                navController = navController
                            )
                        }

                        composable("perguntas") {
                            Perguntas(navController = navController)
                        }

                        composable(
                            route = "resultado/{acertos}/{total}",
                            arguments = listOf(
                                navArgument("acertos") { type = NavType.IntType },
                                navArgument("total") { type = NavType.IntType }
                            )
                        ) { backStackEntry ->
                            val acertos = backStackEntry.arguments?.getInt("acertos") ?: 0
                            val total = backStackEntry.arguments?.getInt("total") ?: 0

                            Resultado(
                                navController = navController,
                                acertos = acertos,
                                total = total
                            )
                        }
                    }
                }
            }
        }
    }
}
