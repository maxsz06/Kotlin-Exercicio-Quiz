package com.example.quiz.screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.quiz.screen.components.CaixaSelecionavel

data class Questao(
    val enunciado: String,
    val opcoes: List<String>,
    val respostaCorreta: Int
)

@Composable
fun Perguntas(
    modifier: Modifier = Modifier,
    navController: NavController
) {
    val questoes = remember {
        listOf(
            Questao("Qual é a capital da Inglaterra?", listOf("Londres", "Paris", "Roma"), 0),
            Questao("Qual é a capital da França?", listOf("Berlim", "Paris", "Madri"), 1),
            Questao("Qual é a capital da Itália?", listOf("Lisboa", "Atenas", "Roma"), 2)
        )
    }

    var questaoAtual by remember { mutableIntStateOf(0) }
    var selecionada by remember { mutableStateOf<Int?>(null) }
    var acertos by remember { mutableIntStateOf(0) }
    var terminou by remember { mutableStateOf(false) }

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFFE498D4))
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if (terminou) {
                Text(
                    text = "Você acertou $acertos de ${questoes.size}!",
                    fontSize = 22.sp,
                    color = Color.Black
                )
                Spacer(Modifier.height(24.dp))
                Button(onClick = {
                    questaoAtual = 0
                    selecionada = null
                    acertos = 0
                    terminou = false
                }) {
                    Text("Refazer")
                }
            } else {

                val questao = questoes[questaoAtual]

                Surface(
                    shape = RoundedCornerShape(12.dp),
                    color = Color(0xFF8BD3A8),
                    border = BorderStroke(1.dp, Color.Black)
                ) {
                    Text(
                        text = "Pergunta ${questaoAtual + 1} de  ${questoes.size}",
                        fontSize = 22.sp,
                        color = Color.Black,
                        modifier = Modifier.padding(horizontal = 40.dp, vertical = 12.dp)
                    )
                }

                    Spacer(Modifier.height(16.dp))

                Surface(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(20.dp),
                    color = Color.White,
                    shadowElevation = 8.dp
                ){
                    Column(modifier= Modifier.padding(24.dp)) {
                        Text(
                            text = questao.enunciado,
                            fontSize = 22.sp,
                            color = Color.Black
                        )
                        Spacer(Modifier.height(24.dp))

                        Column(
                            modifier = Modifier.fillMaxWidth(),
                            verticalArrangement = Arrangement.spacedBy(12.dp)
                        ) {
                            questao.opcoes.forEachIndexed { index, texto ->
                                CaixaSelecionavel(
                                    texto = texto,
                                    marcado = selecionada == index,
                                    onClick = { selecionada = index }
                                )
                            }
                        }
                    }
                }

                Button(
                    onClick = {
                        val acertou = selecionada == questao.respostaCorreta
                        val acertosFinal = if (acertou) acertos + 1 else acertos

                        if (questaoAtual < questoes.lastIndex) {
                            acertos = acertosFinal
                            questaoAtual++
                            selecionada = null
                        } else {
                            navController.navigate("resultado/$acertosFinal/${questoes.size}")
                        }
                    },
                    enabled = selecionada != null
                ) {
                    Text(if (questaoAtual == questoes.lastIndex) "Finalizar" else "Confirmar")
                }

            }
        }
    }
}