package com.example.wikifutbol2.ui.Login

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.wikifutbol2.ui.MainActivity
import com.example.wikifutbol2.R
import com.example.wikifutbol2.databinding.LoginLayoutBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: LoginLayoutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.login_layout)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding = LoginLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.btLogin.setOnClickListener {
            val user = binding.tvUsuario.text.toString()
            val pass = binding.tvContrasena.text.toString()
            compruebaLogin(user, pass)
        }
    }

    private fun compruebaLogin(user: String, pass: String) {

        var usuario = "usuario"
        var contrasena = "usuario"

        if (usuario.isEmpty() && contrasena.isEmpty()) {
            binding.tvUsuario.error = "El campo está vacío"
            binding.tvContrasena.error = "El campo está vacío"
            return
        }

        if (user == usuario && pass == contrasena){
            openNextScreen()
        }else{
            binding.tvUsuario.error = "El usuario o la contraseña es incorrecta"
            binding.tvContrasena.error = "El usuario o la contraseña es incorrecta"
            return
        }
    }

    private fun openNextScreen(){
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}