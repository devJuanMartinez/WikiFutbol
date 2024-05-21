package com.example.wikifutbol2.ui.Login

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.wikifutbol2.ui.MainActivity
import com.example.wikifutbol2.R
import com.example.wikifutbol2.databinding.LoginLayoutBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: LoginLayoutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        val screenSplash = installSplashScreen()
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.login_layout)
        Thread.sleep(2000)
        screenSplash.setKeepOnScreenCondition{false}
        //val intent = Intent(this, LoginActivity::class.java)
        //startActivity(intent)
        //finish()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding = LoginLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.btLogin.setOnClickListener {
            val user = binding.tvUsuarioLogin.text.toString()
            val pass = binding.tvContrasenaLogin.text.toString()
            compruebaLogin(user, pass)
        }

        binding.tvCrearCuenta.setOnClickListener {
            val intent = Intent(this, CrearCuentaActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    private fun compruebaLogin(user: String, pass: String) {

        var usuario = "usuario"
        var contrasena = "usuario"

        if (usuario.isEmpty() && contrasena.isEmpty()) {
            binding.tvUsuarioLogin.error = "El campo está vacío"
            binding.tvContrasenaLogin.error = "El campo está vacío"
            return
        }

        if (user == usuario && pass == contrasena){
            openNextScreen()
        }else{
            binding.tvUsuarioLogin.error = "El usuario o la contraseña es incorrecta"
            binding.tvContrasenaLogin.error = "El usuario o la contraseña es incorrecta"
            return
        }
    }

    private fun openNextScreen(){
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}