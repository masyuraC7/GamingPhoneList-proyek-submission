package com.example.gamingphonelist

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gamingphonelist.databinding.ActivityMainBinding
import kotlin.system.exitProcess

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val list = ArrayList<Phone>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.title = "Gaming Phone"

        binding.rvGamingPhone.setHasFixedSize(true)

        list.addAll(getListPhone())
        showRecyclerList()
    }

    private fun getListPhone(): Collection<Phone> {
        val dataName            = resources.getStringArray(R.array.data_phoneName)
        val dataVarian          = resources.getStringArray(R.array.data_varian)
        val dataDescription     = resources.getStringArray(R.array.data_description)
        val dataOsVersion       = resources.getStringArray(R.array.data_osVersion)
        val dataLayar           = resources.getStringArray(R.array.data_layar)
        val dataScreen          = resources.getStringArray(R.array.data_screen)
        val dataProcessor       = resources.getStringArray(R.array.data_processor)
        val dataRAM             = resources.getStringArray(R.array.data_ram)
        val dataROM             = resources.getStringArray(R.array.data_rom)
        val dataKameraBelakang  = resources.getStringArray(R.array.data_kameraBelakang)
        val dataKameraUtamaLn   = resources.getStringArray(R.array.data_kameraUtamaLn)
        val dataKameraDepan     = resources.getStringArray(R.array.data_kameraDepan)
        val dataNFC             = resources.getIntArray(R.array.data_nfc)
        val dataUSB             = resources.getStringArray(R.array.data_usb)
        val dataBaterai         = resources.getStringArray(R.array.data_baterai)
        val dataImg             = resources.getStringArray(R.array.data_phoneImg)
        val listPhone = ArrayList<Phone>()
        for (i in dataName.indices) {
            val phone = Phone(dataName[i], dataVarian[i], dataDescription[i], dataOsVersion [i],
                dataLayar[i], dataScreen[i], dataProcessor[i], dataRAM[i], dataROM[i],
                dataKameraBelakang[i], dataKameraUtamaLn[i], dataKameraDepan[i],
                dataNFC[i], dataUSB[i], dataBaterai[i], dataImg[i])
            listPhone.add(phone)
        }
        return listPhone
    }

    private fun showRecyclerList() {
        binding.rvGamingPhone.layoutManager = LinearLayoutManager(this)
        val listPhoneAdapter = ListPhoneAdapter(list)
        binding.rvGamingPhone.adapter = listPhoneAdapter
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.about_page -> {
                val moveToAboutPageIntent = Intent(this@MainActivity, AboutPageActivity::class.java)
                startActivity(moveToAboutPageIntent)
            }
            R.id.logout -> {
                finish()
                exitProcess(0)
            }
        }
        return super.onOptionsItemSelected(item)
    }
}