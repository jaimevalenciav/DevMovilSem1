
package com.example.exp1_sem1_jaime_valencia

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.exp1_sem1_jaime_valencia.ui.theme.Exp1_Sem1_Jaime_ValenciaTheme
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.res.fontResource

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Exp1_Sem1_Jaime_ValenciaTheme {
                Surface (
                    modifier = Modifier.fillMaxSize(),
                    color = Color(0xFFFFFFFF)
                ){
                    LoginsScreen()
                }


            }
        }
    }
}

@Preview
@Composable
fun LoginsScreen(){
    val context = LocalContext.current
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    val cookiefont = FontFamily(
        Font(R.font.cookie, FontWeight.Normal)

    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 32.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
        )
        {

            val composition by rememberLottieComposition(
                spec = LottieCompositionSpec.RawRes(resId = R.raw.loginrecetas)
            )

            val progress by animateLottieCompositionAsState(
                composition,
                iterations = LottieConstants.IterateForever
            )
            LottieAnimation(
                composition = composition,
                progress = {progress},
                modifier = Modifier
                    .fillMaxWidth()
                    .height(380.dp)
            )


            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Recetario Familiar",
                fontFamily = cookiefont,
                fontSize = 58.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF02504C)

            )
            Spacer(modifier = Modifier.height(height = 8.dp))
            Text(
                text = "Iniciar sesion para continuar",
                fontSize = 14.sp,
                color = Color(0xFF02504C)
            )
            Spacer(modifier = Modifier.height(height = 8.dp))
            OutlinedTextField(
                value = username,
                onValueChange = { username = it },
                placeholder = {
                    Text("Username",
                        color = Color.Gray,
                        style = TextStyle(textAlign = TextAlign.Center),
                        modifier = Modifier.fillMaxWidth()
                    )
                },
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
                shape = RoundedCornerShape(4.dp),
                singleLine = true,
            )
            Spacer(modifier = Modifier.height(height = 8.dp))
            OutlinedTextField(
                value = password,
                onValueChange =  { password = it },
                placeholder = {
                    Text("Contraseña",
                        color = Color.Gray,
                        style = TextStyle(textAlign = TextAlign.Center),
                        modifier = Modifier.fillMaxWidth()
                    )
                },
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
                shape = RoundedCornerShape(4.dp),
                singleLine = true,
                visualTransformation = PasswordVisualTransformation(),
            )
            Spacer(modifier = Modifier.height(height = 12.dp))
            Button(
                onClick = { if (UsuarioRepositorio.validarUsuario(username, password)) {

                    val intent = Intent(context, VerRecetas::class.java)
                    context.startActivity(intent)
                } else {

                    Toast.makeText(context, "Usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show()
                }},
                modifier = Modifier
                    .fillMaxWidth()
                    .height(52.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF5ED5B2)),
                shape = RoundedCornerShape(4.dp)
            ) {
                Text("Iniciar Sesion", fontSize = 20.sp, color=Color.White, fontWeight = FontWeight.Bold)
            }
            Spacer(modifier = Modifier.height(height = 12.dp))
            Text(
                text = "Recuperar contraseña",
                color = Color.Gray,
                fontSize = 14.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.clickable{
                    val intent = Intent(context, RecuperarContrasenaActivity::class.java)
                    context.startActivity(intent)
                }
            )

            Text(
                text = "Registrar nuevo usuario",
                color = Color.Gray,
                fontSize = 14.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.clickable{
                    val intent = Intent(context, Registro::class.java)
                    context.startActivity(intent)

                }
            )
        }

    }
