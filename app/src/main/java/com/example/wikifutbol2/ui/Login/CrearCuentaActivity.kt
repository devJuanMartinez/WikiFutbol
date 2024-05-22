package com.example.wikifutbol2.ui.Login

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.wikifutbol2.R
import com.example.wikifutbol2.databinding.CrearcuentaLayoutBinding
import com.example.wikifutbol2.databinding.LoginLayoutBinding


class CrearCuentaActivity : AppCompatActivity() {

    private lateinit var binding: CrearcuentaLayoutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.login_layout)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding = CrearcuentaLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.btCreearCuenta.setOnClickListener {
            val user = binding.tvUsuarioCrearCuenta.text.toString()
            val pass = binding.tvContrasenaCrearCuenta.text.toString()
            val mail = binding.tvCorreoCrearCuenta.text.toString()
            compruebaCrearCuenta(user, pass, mail)
        }

        binding.tvIniciarSeesion.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    private fun compruebaCrearCuenta(user: String, pass: String, mail: String) {


        if (user.isEmpty() && pass.isEmpty() && mail.isEmpty()) {
            binding.tvUsuarioCrearCuenta.error = "El campo está vacío"
            binding.tvContrasenaCrearCuenta.error = "El campo está vacío"
            binding.tvCorreoCrearCuenta.error = "El campo está vacío"
            return
        }else if(user.isEmpty() && pass.isEmpty()){
            binding.tvUsuarioCrearCuenta.error = "El campo está vacío"
            binding.tvContrasenaCrearCuenta.error = "El campo está vacío"
        }else if (user.isEmpty() && mail.isEmpty()){
            binding.tvUsuarioCrearCuenta.error = "El campo está vacío"
            binding.tvCorreoCrearCuenta.error = "El campo está vacío"
        }else if(pass.isEmpty() && mail.isEmpty()){
            binding.tvContrasenaCrearCuenta.error = "El campo está vacío"
            binding.tvCorreoCrearCuenta.error = "El campo está vacío"
        }else if(user.isEmpty()){
            binding.tvUsuarioCrearCuenta.error = "El campo está vacío"
        }else if(pass.isEmpty()){
            binding.tvContrasenaCrearCuenta.error = "El campo está vacío"
        }else if(mail.isEmpty()){
            binding.tvCorreoCrearCuenta.error = "El campo está vacío"
        }
    }
}