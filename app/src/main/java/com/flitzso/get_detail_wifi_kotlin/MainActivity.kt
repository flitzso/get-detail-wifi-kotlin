package com.flitzso.get_detail_wifi_kotlin

import android.content.Context
import android.net.wifi.WifiManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnWifiList = findViewById<Button>(R.id.button) as Button
        val wifiText = findViewById<TextView>(R.id.wifiList) as TextView

        btnWifiList.setOnClickListener{
            val wifiManager = applicationContext.getSystemService(Context.WIFI_SERVICE) as WifiManager
            val wifiInfo = wifiManager.connectionInfo
            val ipAddress:Int = wifiInfo.ipAddress
            val bssid:String = wifiInfo.ssid
            val macAddress:String = wifiInfo.macAddress
            val ssid:String = wifiInfo.ssid
            val linkSpeed:Int = wifiInfo.linkSpeed
            val rssi:Int = wifiInfo.rssi
            val networkId:Int = wifiInfo.networkId
            val ipAddressFormat = android.text.format.Formatter.formatIpAddress(ipAddress)

            val wifiInfoList:String = "IP Address:- $ipAddressFormat \nBSSID:-$bssid \nMAC Address:- $macAddress \nSSID:- $ssid" +
                    "\nLink Speed:- $linkSpeed \nRSSI:- $rssi \nNetwork Id:- $networkId"

            wifiText.text = wifiInfoList
        }
    }
}