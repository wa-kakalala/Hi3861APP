package com.example.hi3861app

import android.app.AlertDialog
import android.content.Intent
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.hi3861app.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val ipport_font = Typeface.createFromAsset(assets,"iconfont.ttf");

        binding.ipAddress.typeface = ipport_font
        binding.portNum.typeface = ipport_font

        binding.bntConnect.setOnClickListener{
            val ipText = binding.textIp.text.toString()
            val portText = binding.textPort.text.toString()

            // 进行端口校验
            if (CheckIPAddress().matchesIP(ipText) && CheckIPAddress().matchesPort(portText)){
                //Toast.makeText(applicationContext, "默认的Toast11", Toast.LENGTH_SHORT).show()
                Intent(this,FunctionActivity::class.java).apply{
                    putExtra("ip_port_info",IpPortInfo(ipText,portText.toInt()))
                    startActivity(this)
                }
            }else{
                Toast.makeText(applicationContext, "IP/Port ERROR ?", Toast.LENGTH_SHORT).show()
            }
        }
    }
}