package com.example.gamingphonelist

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Phone(
    val name: String,
    val varian: String,
    val description: String,
    val osVersion: String,
    val layar: String,
    val screen: String,
    val processor: String,
    val ram: String,
    val rom: String,
    val kameraBelakang: String,
    val kameraUtamaLn: String,
    val kameraDepan: String,
    val nfc: Int,
    val usb: String,
    val baterai: String,
    val img: String
) : Parcelable
