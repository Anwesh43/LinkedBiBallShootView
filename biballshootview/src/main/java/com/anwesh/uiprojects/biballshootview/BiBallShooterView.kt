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

fun Canvas.drawBall(sf1 : Float, sf2 : Float, sf3 : Float, w : Float, h : Float, paint : Paint) {
    val r : Float = Math.min(w, h) / ballRFactor
    for (j in 0..1) {
        save()
        scale(1f, 1f - 2 * j)
        translate((h / 2 - r) - (h / 2 - 2 * r) * sf2 + (w / 2 - 2 * r) * sf3, 0f)
        drawCircle(0f, 0f, r * sf1, paint)
        restore()
    }
}

fun Canvas.drawLines(sf1 : Float, w : Float, h : Float, paint : Paint) {
    val r : Float = Math.min(w, h) / ballRFactor
    for (j in 0..1) {
        save()
        translate(r * (1 - 2 * j), 0f)
        drawLine(0f, -2 * r * sf1, 0f, 2 * r * sf1, paint)
        restore()
    }
}

fun Canvas.drawBiBallShooter(scale : Float, w : Float, h : Float, paint : Paint) {
    val sf : Float = scale.sinify()
    val sf1 : Float = sf.divideScale(0, parts)
    val sf2 : Float = sf.divideScale(1, parts)
    val sf3 : Float = sf.divideScale(2, parts)
    val sf4 : Float = sf.divideScale(3, parts)
    val sf5 : Float = sf.divideScale(4, parts)
    save()
    translate(w / 2, h / 2)
    rotate(-rot * sf5)
    drawLines(sf3, w, h, paint)
    drawBall(sf1, sf2, sf4, w, h, paint)
    restore()
}

fun Canvas.drawBBSNode(i : Int, scale : Float, paint : Paint) {
    val w : Float = width.toFloat()
    val h : Float = height.toFloat()
    paint.color = colors[i]
    paint.strokeCap = Paint.Cap.ROUND
    paint.strokeWidth = Math.min(w, h) / strokeFactor
    drawBiBallShooter(scale, w, h, paint)
}

class BiBallShooterView(ctx : Context) : View(ctx) {

    override fun onDraw(canvas : Canvas) {

    }

    override fun onTouchEvent(event : MotionEvent) : Boolean {
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {

            }
        }
        return true
    }
}