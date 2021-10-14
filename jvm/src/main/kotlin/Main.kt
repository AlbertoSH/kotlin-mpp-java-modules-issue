package com.example.jvm

import com.example.mpp.Mpp

fun main() {
    val mpp = Mpp("mpp")
    val demo = Demo(mpp)
    println(demo)
}