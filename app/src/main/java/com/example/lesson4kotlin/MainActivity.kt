package com.example.lesson4kotlin

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    private val getContent = registerForActivityResult (ActivityResultContracts.GetContent()) { uri ->
            ivWat.setImageURI(uri)
        }

    private lateinit var ivWat: ImageView
    private lateinit var etNumber: EditText
    private lateinit var btnWhatsApp: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ivWat = this.findViewById(R.id.ivWat)
        etNumber = this.findViewById(R.id.etNumber)
        btnWhatsApp = this.findViewById(R.id.btnWhatsApp)

        goToWatsapp()
    }

    private fun startActivity(watsaapIntent: String) {

    }

    private fun goToWatsapp() {
        btnWhatsApp.setOnClickListener {
            val guery = etNumber.text.toString().trim()
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://api.whatsapp.com/send?phone=$guery"))
            startActivity(intent)

        }
        ivWat.setOnClickListener {
            openGallery()
        }
    }

    private fun openGallery() {
        getContent.launch("image/*")
    }
    }
