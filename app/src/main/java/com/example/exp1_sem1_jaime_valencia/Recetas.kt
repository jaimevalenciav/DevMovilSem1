package com.example.exp1_sem1_jaime_valencia

import com.example.exp1_sem1_jaime_valencia.R

data class Receta(
    val nombreReceta: String,
    val creadorReceta: String,
    val ingredientes: String,
    val instrucciones: String,
    val imageRes: Int
)

object RecetaRepositorio {
    val recetas = listOf(
        Receta(
            "Spaghetti Bolognese",
            "Jaime",
            "Spaghetti, carne molida, tomate, cebolla, ajo",
            "Cocer la pasta, preparar la salsa con carne y tomate, mezclar y servir.",
            R.drawable.espaghetti
        ),
        Receta(
            "Ensalada César",
            "María",
            "Lechuga, pollo, crutones, parmesano, aderezo César",
            "Mezclar todos los ingredientes y servir fría.",
            R.drawable.ensalada
        ),
        Receta(
            "Tacos de Carne",
            "Pedro",
            "Tortillas, carne, cebolla, cilantro, salsa",
            "Calentar tortillas, rellenar con carne y acompañar con cebolla y salsa.",
            R.drawable.tacos
        ),
        Receta(
            "Sopa de Verduras",
            "Lucía",
            "Zanahoria, papa, apio, caldo de pollo, especias",
            "Cocinar las verduras en el caldo hasta que estén suaves.",
            R.drawable.sopa
        ),
        Receta(
            "Panqueques",
            "Ana",
            "Harina, huevo, leche, azúcar, mantequilla",
            "Mezclar ingredientes, verter en sartén caliente y dorar ambos lados.",
            R.drawable.panqueques
        )
    )
}
