package com.example.quiz.screen.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.toggleable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.selection.selectable

@Composable
fun CaixaSelecionavel(
    texto: String,
    marcado: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val cor = if (marcado) MaterialTheme.colorScheme.primary
    else MaterialTheme.colorScheme.outlineVariant

    Surface(
        modifier = modifier
            .fillMaxWidth()
            .selectable(
                selected = marcado,
                role = Role.RadioButton,
                onClick = onClick
            ),
        shape = RoundedCornerShape(12.dp),
        border = BorderStroke(if (marcado) 2.dp else 1.dp, cor),
        color = if (marcado) MaterialTheme.colorScheme.primary.copy(alpha = 0.08f)
        else MaterialTheme.colorScheme.surface
    ) {
        Row(
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 14.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = texto,
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.weight(1f)
            )
            if (marcado) {
                Icon(
                    imageVector = Icons.Default.Check,
                    contentDescription = "Selecionado",
                    tint = cor
                )
            }
        }
    }
}