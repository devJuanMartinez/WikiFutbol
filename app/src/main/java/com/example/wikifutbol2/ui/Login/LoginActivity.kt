package com.example.wikifutbol2.ui.Login

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.wikifutbol2.R
import com.example.wikifutbol2.databinding.LoginLayoutBinding
import com.example.wikifutbol2.ui.MainActivity
import com.example.wikifutbol2.ui.fragments.HomeFragment

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
//        val checkboxsaved = misPreferencias.getBoolean("chbox", false)

        var usuario = usersaved.toString()
        var contrasena = passaved.toString()

        if (user.isEmpty()) {
            binding.tvUsuarioLogin.error = "El campo está vacío"
        }else{
            binding.tvUsuarioLogin.error = null
        }



        val aaa = "usuario"
        val ppp = "usuario"

        if (user == usuario || user == aaa ){
            binding.tvUsuarioLogin.error = null
            if (pass == contrasena || pass == ppp){
                binding.tvContrasenaLogin.error=null
                openNextScreen()
            }else{
                if (pass.isEmpty()){
                    binding.tvContrasenaLogin.error = "El campo está vacío"
                }else{
                    binding.tvContrasenaLogin.error = "La contraseña es incorrecta"
                }

            }
        }else{
            binding.tvUsuarioLogin.error = "El usuario es incorrecto"
            binding.tvContrasenaLogin.error = null
        }


//        if (binding.checkBox.isChecked){
//            val checkboxsaved = misPreferencias.edit()
//            checkboxsaved.putBoolean("chbox", true)
//            checkboxsaved.apply()
//        }
    }

    private fun openNextScreen(){
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}