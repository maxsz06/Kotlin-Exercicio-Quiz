package com.example.quiz.screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.quiz.R

@Composable
fun Resultado(
    modifier: Modifier = Modifier,
    navController: NavController,
    acertos: Int,
    total: Int
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Logo
        Image(
            painter = painterResource(id = R.drawable.questionario),
            contentDescription = "Logo Imagem",
            modifier = Modifier
                .padding(top = 16.dp, bottom = 16.dp)
                .size(125.dp)
        )

        // Faixa azul
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFF87D7F7))
                .padding(vertical = 32.dp, horizontal = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Surface(
                shape = RoundedCornerShape(16.dp),
                color = Color(0xFF8BD3A8),
                border = BorderStroke(1.dp, Color.DarkGray)
            ) {
                Text(
                    text = "Bom trabalho!",
                    fontSize = 24.sp,
                    color = Color.Black,
                    modifier = Modifier.padding(horizontal = 56.dp, vertical = 16.dp)
                )
            }

            Spacer(Modifier.height(48.dp))

            Text(
                text = "Você acertou $acertos de $total perguntas",
                fontSize = 22.sp,
                color = Color.Black
            )
        }

        Spacer(Modifier.height(32.dp))

        // Botão
        Button(
            onClick = {
                navController.navigate("perguntas") {
                    popUpTo("perguntas") { inclusive = true }
                }
            },
            shape = RoundedCornerShape(50),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFF8E04F),
                contentColor = Color.Black
            ),
            border = BorderStroke(1.dp, Color.DarkGray),
            contentPadding = PaddingValues(horizontal = 40.dp, vertical = 16.dp)
        ) {
            Text("JOGAR NOVAMENTE", fontSize = 20.sp)
        }
    }
}