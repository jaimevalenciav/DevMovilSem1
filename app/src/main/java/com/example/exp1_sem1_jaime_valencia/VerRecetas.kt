package com.example.exp1_sem1_jaime_valencia

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.exp1_sem1_jaime_valencia.ui.theme.Exp1_Sem1_Jaime_ValenciaTheme

class VerRecetas : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Exp1_Sem1_Jaime_ValenciaTheme {
                ListaRecetas()

            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListaRecetas() {
    val recetas = RecetaRepositorio.recetas

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("📖 Mis Recetas")},

            )
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
        ) {
            items(recetas) { receta ->
                RecetaCard(receta)
            }
        }
    }
}



@Composable
fun RecetaCard(receta: Receta) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFCCF1EF)
        )

    ) {
        Column(modifier = Modifier.padding(12.dp)) {
            Image(
                painter = painterResource(id = receta.imageRes),
                contentDescription = receta.nombreReceta,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = receta.nombreReceta, style = MaterialTheme.typography.titleLarge)
            Text(text = "👩‍🍳 Autor: ${receta.creadorReceta}", style = MaterialTheme.typography.bodyMedium, fontSize = 10.sp)
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = "Ingredientes: ${receta.ingredientes}", style = MaterialTheme.typography.bodySmall, fontSize = 15.sp)
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = "Instrucciones: ${receta.instrucciones}", style = MaterialTheme.typography.bodySmall, fontSize = 15.sp)
        }
    }
}

