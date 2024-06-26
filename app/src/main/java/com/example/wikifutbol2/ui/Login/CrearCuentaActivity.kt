package com.example.wikifutbol2.ui.Login

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.wikifutbol2.R
import com.example.wikifutbol2.databinding.CrearcuentaLayoutBinding


class CrearCuentaActivity : AppCompatActivity() {

    private lateinit var binding: CrearcuentaLayoutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = CrearcuentaLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btCrearCuenta.setOnClickListener {
            val user = binding.tvUsuarioCrearCuenta.text.toString()
            val pass = binding.tvContrasenaCrearCuenta.text.toString()
            val mail = binding.tvCorreoCrearCuenta.text.toString()
            compruebaCrearCuenta(user, pass, mail)
        }

        binding.tvIniciarSesion.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    private fun compruebaCrearCuenta(user: String, pass: String, mail: String) {

//         Estos if sirven para comprobar si los inputs estan vacios

        if (user.isEmpty()){
            binding.tvUsuarioCrearCuenta.error = "El campo está vacío"
        }
        if (pass.isEmpty()){
            binding.tvContrasenaCrearCuenta.error = "El campo está vacío"
        }
        if (mail.isEmpty()){
            binding.tvCorreoCrearCuenta.error = "El campo está vacío"
        }



        val misPreferencias = getSharedPreferences("myprefs", MODE_PRIVATE)
        val usersaved = misPreferencias.getString("user", "")
        val passaved = misPreferencias.getString("pass", "")
        val emailsaved = misPreferencias.getString("email", "")


        if (user.isNotEmpty() && pass.isNotEmpty() && mail.isNotEmpty()) {
            val usersaved = misPreferencias.edit()
            usersaved.putString("user", user)
            usersaved.apply()

            val passaved = misPreferencias.edit()
            usersaved.putString("pass", pass)
            usersaved.apply()

            val emailsaved = misPreferencias.edit()
            usersaved.putString("email", pass)
            usersaved.apply()

            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}