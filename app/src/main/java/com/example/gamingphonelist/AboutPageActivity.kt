package com.example.gamingphonelist

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.gamingphonelist.databinding.ActivityAboutPageBinding

class AboutPageActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityAboutPageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAboutPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.title = "About Page"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val dicodingProfile = "https://dicoding-web-img.sgp1.cdn.digitaloceanspaces.com/small/avatar/dos:3bfc7bffdb2ac02f5a56ffe0387f9a2b20230902145645.png"

        Glide.with(this).load(dicodingProfile).circleCrop().into(binding.ivDicodingProfile)

        binding.btnToDicodingProfile.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id) {
            R.id.btn_toDicodingProfile -> {
                val moveToDicodingProfilePageIntent = Intent("android.intent.action.VIEW",
                    Uri.parse("https://www.dicoding.com/users/pyrism/academies"))
                startActivity(moveToDicodingProfilePageIntent)
            }
        }
    }
}