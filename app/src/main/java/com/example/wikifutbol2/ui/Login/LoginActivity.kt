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
        binding = LoginLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Thread.sleep(1000)
        screenSplash.setKeepOnScreenCondition{false}


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

        val misPreferencias = getSharedPreferences("myprefs", MODE_PRIVATE)
        val usersaved = misPreferencias.getString("user", "")
        val passaved = misPreferencias.getString("pass", "")
        val checkboxsaved = misPreferencias.getBoolean("chbox", false)

        var usuario = usersaved.toString()
        var contrasena = passaved.toString()

        if (user.isEmpty() && pass.isEmpty()) {
            binding.tvUsuarioLogin.error = "El campo está vacío"
            binding.tvContrasenaLogin.error = "El campo está vacío"
            return
        }

        val aaa = "usuario"
        val ppp = "usuario"

        if (user == usuario && pass == contrasena || user == aaa && pass == ppp){
            openNextScreen()
        }else{
            binding.tvUsuarioLogin.error = "El usuario o la contraseña es incorrecta"
            binding.tvContrasenaLogin.error = "El usuario o la contraseña es incorrecta"
            return
        }
        if (binding.checkBox.isChecked){
            val checkboxsaved = misPreferencias.edit()
            checkboxsaved.putBoolean("chbox", true)
            checkboxsaved.apply()
        }
    }

    private fun openNextScreen(){
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}