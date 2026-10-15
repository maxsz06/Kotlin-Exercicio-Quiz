package com.example.quiz.screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.quiz.R

@Composable
fun TelaInicial(
    modifier: Modifier = Modifier,
    navController: NavController
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFF82D6F8))
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(112.dp))

            Image(
                painter = painterResource(id = R.drawable.questionario),
                contentDescription = "Logo Imagem",
                modifier = Modifier.size(125.dp)
            )

            Spacer(modifier = Modifier.height(105.dp))

            Text(
                text = "QUIZATRON 3000",
                fontSize = 32.sp,
                fontWeight = FontWeight.Normal,
                color = Color.Black
            )

            Spacer(modifier = Modifier.height(57.dp))

            Button(
                onClick = {
                    navController.navigate("perguntas")
                },
                modifier = Modifier
                    .fillMaxWidth(0.63f)
                    .height(52.dp),
                shape = RoundedCornerShape(50),
                border = BorderStroke(1.dp, Color.Black),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFF9DF5A)
                )
            ) {
                Text(
                    text = "COMECAR!",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Normal,
                    color = Color.Black
                )
            }
        }
    }
}