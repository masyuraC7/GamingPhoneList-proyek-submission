package com.example.gamingphonelist

import android.content.Intent
import android.graphics.text.LineBreaker.JUSTIFICATION_MODE_INTER_WORD
import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.gamingphonelist.databinding.ActivityDetailPhoneBinding

class DetailPhoneActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailPhoneBinding

    companion object {
        const val KEY_PHONE = "key_phone"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailPhoneBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.title = "Detail Phone"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val dataHero = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra(KEY_PHONE, Phone::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra(KEY_PHONE)
        }

        if (dataHero != null){
            Glide.with(this).load(dataHero.img).into(binding.ivPhoneDetail)
            binding.txtTitleDetail.text = dataHero.name

            if (Build.VERSION.SDK_INT >= 33) {
                binding.txtDescriptionDetail.justificationMode = JUSTIFICATION_MODE_INTER_WORD
            }

            binding.txtDescriptionDetail.text = dataHero.description
            binding.txtOsVersion.text = dataHero.osVersion
            binding.txtLayar.text = dataHero.layar
            binding.txtScreen.text = dataHero.screen
            binding.txtProcessor.text = dataHero.processor
            binding.txtRam.text = dataHero.ram
            binding.txtRom.text = dataHero.rom
            binding.txtKameraBelakang.text = dataHero.kameraBelakang
            binding.txtKameraUtamaLn.text = dataHero.kameraUtamaLn
            binding.txtKameraDepan.text = dataHero.kameraDepan
            binding.txtUsb.text = dataHero.usb
            binding.txtNfc.text = if (dataHero.nfc == 1) "Ya" else "No"
            binding.txtBaterai.text = dataHero.baterai

            binding.btnShare.setOnClickListener{
                val sendIntent = Intent().apply {
                    action = Intent.ACTION_SEND
                    val extraText = dataHero.description
                    val extraSubject = dataHero.name
                    putExtra(Intent.EXTRA_TEXT, extraText)
                    putExtra(Intent.EXTRA_SUBJECT, extraSubject)
                    type = "text/plain"
                }
                val shareIntent = Intent.createChooser(sendIntent, "Share To:")
                startActivity(shareIntent)
            }
        }
    }
}