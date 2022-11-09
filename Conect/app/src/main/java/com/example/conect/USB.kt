package com.example.conect

import android.annotation.SuppressLint
import android.app.Application
import cn.wch.ch34xuartdriver.CH34xUARTDriver


object USB : Application() {
    @SuppressLint("StaticFieldLeak")
    var driver: CH34xUARTDriver? = null
}