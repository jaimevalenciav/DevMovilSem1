package com.example.exp1_sem1_jaime_valencia

data class Usuarios (
    val nombreUsuario: String,
    val nombre: String,
    val apellidoP : String,
    val apellidoM : String,
    val correo : String,
    val contrasena: String
    )

object UsuarioRepositorio{
    val usuariosList = mutableListOf<Usuarios>()

    val usuario = listOf(
        Usuarios(
            "admin",
            "Administrador",
            "Sin ApellidoP",
            "Sin ApellidoM",
            "correo@correo.cl",
            "admin123"
        )
    )

    fun agregarUsuario(usuario: Usuarios){
        usuariosList.add(usuario)
    }

    fun validarUsuario(username: String, password: String): Boolean {
        return usuario.any { it.nombreUsuario == username && it.contrasena == password }
    }
    fun obtenerUsuarios(): List<Usuarios>{
        return usuariosList.toList()
    }


    fun existeUsuario(username: String): Boolean {
        return usuariosList.any { it.nombreUsuario == username }
    }


    fun resetearContrasena(username: String, nuevaContrasena: String): Boolean {
        val usuarioIndex = usuariosList.indexOfFirst { it.nombreUsuario == username }
        return if (usuarioIndex != -1) {
            val usuarioActual = usuariosList[usuarioIndex]
            val usuarioActualizado = usuarioActual.copy(contrasena = nuevaContrasena)
            usuariosList[usuarioIndex] = usuarioActualizado
            true
        } else {
            false
        }
    }
}

