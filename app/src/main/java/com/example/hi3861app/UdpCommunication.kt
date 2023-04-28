package com.example.hi3861app

import java.net.DatagramPacket
import java.net.DatagramSocket
import java.net.InetAddress
import java.net.InetSocketAddress

class UdpCommunication(host: String, port: Int) {
    private val inetAddress = InetSocketAddress(InetAddress.getByName(host),port)
    private val clientSocket = DatagramSocket(0)
    fun send(data: ByteArray) = clientSocket.send(DatagramPacket(data, data.size, inetAddress))
    fun send(data: ByteArray, length: Int) = clientSocket.send(DatagramPacket(data, length, inetAddress))
    fun recv(data: ByteArray) = clientSocket.receive(DatagramPacket(data, data.size, inetAddress))
    fun recv(data: ByteArray, length: Int) = clientSocket.receive(DatagramPacket(data, length, inetAddress))
}



