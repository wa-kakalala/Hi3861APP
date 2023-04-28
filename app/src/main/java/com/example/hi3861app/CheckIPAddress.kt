package com.example.hi3861app


class CheckIPAddress(){
    fun matchesIP(text:String): Boolean {
        return if (text.isNotEmpty()) {
            // 定义正则表达式
            val regexString = "^(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|[1-9])\\." +
            "(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\."  +
            "(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\."  +
            "(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)$"
            val regex = Regex(regexString)
            // 判断ip地址是否与正则表达式匹配
            text.matches(regex)
        }else{
            false
        }
    }
    fun matchesPort(text:String): Boolean {
        return if (text.isNotEmpty()) {
            // 定义正则表达式
            val regexString = "^([0-9]|[1-9]\\d{1,3}|[1-5]\\d{4}|6[0-4]\\d{4}|65[0-4]\\d{2}|655[0-2]\\d|6553[0-5])$"

            val regex = Regex(regexString)
            // 判断port是否与正则表达式匹配
            text.matches(regex)
        }else{
            false
        }
    }
}

