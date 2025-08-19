package com.example.exp1_sem1_jaime_valencia

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.exp1_sem1_jaime_valencia.ui.theme.Exp1_Sem1_Jaime_ValenciaTheme

class Registro : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Exp1_Sem1_Jaime_ValenciaTheme {
                PantallaRegistro()
            }
        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PantallaRegistro() {
    var nombreUsuario by remember { mutableStateOf("") }
    var nombre by remember { mutableStateOf("") }
    var apellidoP by remember { mutableStateOf("") }
    var apellidoM by remember { mutableStateOf("") }
    var correo by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    val context = LocalContext.current

    Scaffold(
        topBar = {
            androidx.compose.material3.TopAppBar(
                title = { Text("Registro de Usuario") }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            OutlinedTextField(
                value = nombreUsuario,
                onValueChange = { nombreUsuario = it },
                label = { Text("Nombre de Usuario") },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(55.dp)
                    .background(Color.White, shape = RoundedCornerShape(4.dp)),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor= Color(0xFF02504C),
                    unfocusedTextColor = Color(0xFF02504C),
                    focusedContainerColor = Color(0xFFCCF1EF),
                    unfocusedContainerColor = Color.Transparent,
                    cursorColor = Color.Black
                ),
            )
            OutlinedTextField(
                value = nombre,
                onValueChange = { nombre = it },
                label = { Text("Nombre") },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(55.dp)
                    .background(Color.White, shape = RoundedCornerShape(4.dp)),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor= Color(0xFF02504C),
                    unfocusedTextColor = Color(0xFF02504C),
                    focusedContainerColor = Color(0xFFCCF1EF),
                    unfocusedContainerColor = Color.Transparent,
                    cursorColor = Color.Black
                ),
            )
            OutlinedTextField(
                value = apellidoP,
                onValueChange = { apellidoP = it },
                label = { Text("Apellido Paterno") },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(55.dp)
                    .background(Color.White, shape = RoundedCornerShape(4.dp)),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor= Color(0xFF02504C),
                    unfocusedTextColor = Color(0xFF02504C),
                    focusedContainerColor = Color(0xFFCCF1EF),
                    unfocusedContainerColor = Color.Transparent,
                    cursorColor = Color.Black
                ),
            )
            OutlinedTextField(
                value = apellidoM,
                onValueChange = { apellidoM = it },
                label = { Text("Apellido Materno") },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(55.dp)
                    .background(Color.White, shape = RoundedCornerShape(4.dp)),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor= Color(0xFF02504C),
                    unfocusedTextColor = Color(0xFF02504C),
                    focusedContainerColor = Color(0xFFCCF1EF),
                    unfocusedContainerColor = Color.Transparent,
                    cursorColor = Color.Black
                ),
            )
            OutlinedTextField(
                value = correo,
                onValueChange = { correo = it },
                label = { Text("Correo") },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(55.dp)
                    .background(Color.White, shape = RoundedCornerShape(4.dp)),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor= Color(0xFF02504C),
                    unfocusedTextColor = Color(0xFF02504C),
                    focusedContainerColor = Color(0xFFCCF1EF),
                    unfocusedContainerColor = Color.Transparent,
                    cursorColor = Color.Black
                ),
            )
            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("Contraseña") },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(55.dp)
                    .background(Color.White, shape = RoundedCornerShape(4.dp)),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor= Color(0xFF02504C),
                    unfocusedTextColor = Color(0xFF02504C),
                    focusedContainerColor = Color(0xFFCCF1EF),
                    unfocusedContainerColor = Color.Transparent,
                    cursorColor = Color.Black
                ),
            )

            Button(
                onClick = {
                    val nuevoUsuario = Usuarios(
                        nombreUsuario,
                        nombre,
                        apellidoP,
                        apellidoM,
                        correo,
                        contrasena = password
                    )
                    UsuarioRepositorio.agregarUsuario(nuevoUsuario)
                    Toast.makeText(context,"Registrado exitosamente", Toast.LENGTH_SHORT).show()
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(52.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF5ED5B2)),
                shape = RoundedCornerShape(4.dp)
            ) {
                Text("Registrar")
            }
        }
    }
}


@Preview
@Composable
fun RegistroPreview(){

}
