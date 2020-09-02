package com.anwesh.uiprojects.biballshootview

/**
 * Created by anweshmishra on 03/09/20.
 */

import android.view.View
import android.view.MotionEvent
import android.graphics.Paint
import android.graphics.Canvas
import android.graphics.Color
import android.content.Context
import android.app.Activity

val parts : Int = 5
val colors : Array<Int> = arrayOf(Color.RED, Color.GREEN, Color.CYAN, Color.MAGENTA, Color.YELLOW)
val scGap : Float = 0.02f / 5
val strokeFactor : Float = 90f
val ballRFactor : Float = 6.8f
val delay : Long = 20
val rot : Float = 90f
val balls : Int = 2
val lines : Int = 2

fun Int.inverse() : Float = 1f / this
fun Float.maxScale(i : Int, n : Int) : Float = Math.max(0f, this - i * n.inverse())
fun Float.divideScale(i : Int, n : Int) : Float = Math.min(i.inverse(), maxScale(i, n)) * n
fun Float.sinify() : Float = Math.sin(this * Math.PI).toFloat()
