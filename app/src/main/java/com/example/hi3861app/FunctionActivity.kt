package com.example.hi3861app

import android.os.Build
import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity
import com.example.hi3861app.databinding.ActivityFunctionBinding


class FunctionActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFunctionBinding

    private var nowTask : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFunctionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val IpPortInfoer:IpPortInfo?  = if (Build.VERSION.SDK_INT >= 33)
            intent.getParcelableExtra("ip_port_info", IpPortInfo::class.java)
        else
            intent.getParcelableExtra("ip_port_info") as? IpPortInfo

        val ipinfo = IpPortInfoer?.ip
        val portinfo = IpPortInfoer?.port

        binding.bntForward.setOnClickListener{
            nowTask = 1
        }
        binding.bntRight.setOnClickListener{
            nowTask = 2
        }
        binding.bntBackward.setOnClickListener{
            nowTask = 3
        }
        binding.bntLeft.setOnClickListener{
            nowTask = 4
        }
        binding.bntStop.setOnClickListener{
            nowTask = 5
        }

        Thread {
            val byteArray = ByteArray(64)
            val connstate : Boolean
            if ((ipinfo != null) && (portinfo != null)) {
                val udper :UdpCommunication= UdpCommunication(ipinfo,portinfo)
                udper.send("hello".toByteArray())
                val len = udper.recv(byteArray,64)

                if(String(byteArray, Charsets.UTF_8).indexOf("ok") == 0){
                    binding.debugText.text = "连接成功"
                    connstate = true
                }else{
                    binding.debugText.text = "连接失败"
                    connstate = false
                }

                while(connstate){
                    when ( nowTask ){
                        1 -> {
                            udper.send("forward".toByteArray())
                            udper.send("forward".toByteArray())
                            nowTask = 0
                        }
                        2 -> {
                            udper.send("turn_right".toByteArray())
                            udper.send("turn_right".toByteArray())
                            nowTask = 0
                        }
                        3 -> {
                            udper.send("backward".toByteArray())
                            udper.send("backward".toByteArray())
                            nowTask = 0
                        }
                        4 -> {
                            udper.send("turn_left".toByteArray())
                            udper.send("turn_left".toByteArray())
                            nowTask = 0
                        }
                        5 -> {
                            udper.send("stop".toByteArray())
                            udper.send("stop".toByteArray())
                            nowTask = 0
                        }
                    }
                }

            } else {
                // error
            }
        }.start()

    }

}