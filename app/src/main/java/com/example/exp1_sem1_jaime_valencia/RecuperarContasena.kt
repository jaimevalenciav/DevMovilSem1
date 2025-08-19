package com.example.exp1_sem1_jaime_valencia

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp



class RecuperarContrasenaActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ResetPasswordTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ResetPasswordScreen()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ResetPasswordScreen() {
    var username by remember { mutableStateOf("") }
    var newPassword by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    var showNewPassword by remember { mutableStateOf(false) }
    var showConfirmPassword by remember { mutableStateOf(false) }
    var isLoading by remember { mutableStateOf(false) }

    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = "Recuperar Contraseña",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(bottom = 32.dp)
        )


        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
            shape = RoundedCornerShape(16.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                OutlinedTextField(
                    value = username,
                    onValueChange = { username = it },
                    label = { Text("Nombre de usuario") },
                    singleLine = true,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 16.dp),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
                )


                OutlinedTextField(
                    value = newPassword,
                    onValueChange = { newPassword = it },
                    label = { Text("Nueva contraseña") },
                    singleLine = true,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 16.dp)
                        .height(55.dp)
                        .background(Color.White, shape = RoundedCornerShape(4.dp)),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = Color(0xFF02504C),
                        unfocusedTextColor = Color(0xFF02504C),
                        focusedContainerColor = Color(0xFFCCF1EF),
                        unfocusedContainerColor = Color.Transparent,
                        cursorColor = Color.Black
                    ),
                    visualTransformation = if (showNewPassword) VisualTransformation.None else PasswordVisualTransformation(),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                    trailingIcon = {
                        TextButton(
                            onClick = { showConfirmPassword = !showConfirmPassword }
                        ) {
                            Text(
                                text = if (showConfirmPassword) "Ocultar" else "Mostrar",
                                fontSize = 12.sp,
                                color = Color(0xFF02504C)
                            )
                        }
                    }
                )


                OutlinedTextField(
                    value = confirmPassword,
                    onValueChange = { confirmPassword = it },
                    label = { Text("Repetir nueva contraseña") },
                    singleLine = true,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 24.dp)
                        .height(55.dp)
                        .background(Color.White, shape = RoundedCornerShape(4.dp)),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = Color(0xFF02504C),
                        unfocusedTextColor = Color(0xFF02504C),
                        focusedContainerColor = Color(0xFFCCF1EF),
                        unfocusedContainerColor = Color.Transparent,
                        cursorColor = Color.Black
                    ),
                    visualTransformation = if (showConfirmPassword) VisualTransformation.None else PasswordVisualTransformation(),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                    trailingIcon = {
                        TextButton(
                            onClick = { showConfirmPassword = !showConfirmPassword }
                        ) {
                            Text(
                                text = if (showConfirmPassword) "Ocultar" else "Mostrar",
                                fontSize = 12.sp,
                                color = Color(0xFF02504C)
                            )
                        }
                    },
                    isError = confirmPassword.isNotEmpty() && newPassword != confirmPassword
                )

                if (confirmPassword.isNotEmpty() && newPassword != confirmPassword) {
                    Text(
                        text = "Las contraseñas no coinciden",
                        color = MaterialTheme.colorScheme.error,
                        fontSize = 12.sp,
                        modifier = Modifier.padding(bottom = 16.dp)
                    )
                }

                Button(
                    onClick = {
                        isLoading = true
                        resetPassword(
                            username = username,
                            newPassword = newPassword,
                            confirmPassword = confirmPassword,
                            context = context,
                            onComplete = {
                                isLoading = false
                                // Limpiar campos después del éxito
                                username = ""
                                newPassword = ""
                                confirmPassword = ""
                            }
                        )
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp),
                    enabled = !isLoading && username.isNotEmpty() &&
                            newPassword.isNotEmpty() && confirmPassword.isNotEmpty() &&
                            newPassword == confirmPassword,
                    shape = RoundedCornerShape(12.dp)
                ) {
                    if (isLoading) {
                        CircularProgressIndicator(
                            modifier = Modifier.size(20.dp),
                            color = MaterialTheme.colorScheme.onPrimary
                        )
                    } else {
                        Text(
                            text = "Actualizar Contraseña",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Medium
                        )
                    }
                }
            }
        }
    }
}

private fun resetPassword(
    username: String,
    newPassword: String,
    confirmPassword: String,
    context: android.content.Context,
    onComplete: () -> Unit
) {
    when {
        username.isBlank() -> {
            Toast.makeText(context, "Ingrese el nombre de usuario", Toast.LENGTH_SHORT).show()
            onComplete()
        }
        newPassword.isBlank() -> {
            Toast.makeText(context, "Ingrese la nueva contraseña", Toast.LENGTH_SHORT).show()
            onComplete()
        }
        confirmPassword.isBlank() -> {
            Toast.makeText(context, "Confirme la nueva contraseña", Toast.LENGTH_SHORT).show()
            onComplete()
        }
        newPassword != confirmPassword -> {
            Toast.makeText(context, "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show()
            onComplete()
        }
        newPassword.length < 6 -> {
            Toast.makeText(context, "La contraseña debe tener al menos 6 caracteres", Toast.LENGTH_SHORT).show()
            onComplete()
        }
        !UsuarioRepositorio.existeUsuario(username) -> {
            Toast.makeText(context, "El usuario no existe", Toast.LENGTH_SHORT).show()
            onComplete()
        }
        else -> {
            val success = UsuarioRepositorio.resetearContrasena(username, newPassword)
            if (success) {
                Toast.makeText(context, "Contraseña actualizada exitosamente", Toast.LENGTH_LONG).show()
                onComplete()
            } else {
                Toast.makeText(context, "Error al actualizar la contraseña", Toast.LENGTH_SHORT).show()
                onComplete()
            }
        }
    }
}

@Composable
fun ResetPasswordTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        content = content
    )
}