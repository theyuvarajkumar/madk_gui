package com.example.madk_graphicalprimitives

import android.app.Activity
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import android.widget.ImageView

class MainActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Creating a Bitmap
        val bg = Bitmap.createBitmap(720, 1280, Bitmap.Config.ARGB_8888)

        // Setting the Bitmap as background for the ImageView
        val imageView = findViewById<ImageView>(R.id.imageView)
        imageView.background = BitmapDrawable(resources, bg)

        // Creating the Canvas Object
        val canvas = Canvas(bg)

        // Drawing shapes with specified colors
        drawRectangle(canvas)
        drawCircle(canvas)
        drawSquare(canvas)
        drawLine(canvas)
    }

    private fun drawRectangle(canvas: Canvas) {
        val paint = Paint().apply {
            color = Color.BLUE
            textSize = 50f
        }
        canvas.drawText("Rectangle", 420f, 150f, paint)
        canvas.drawRect(400f, 200f, 650f, 700f, paint)
    }

    private fun drawCircle(canvas: Canvas) {
        val paint = Paint().apply {
            color = Color.BLUE
            textSize = 50f
        }
        canvas.drawText("Circle", 120f, 150f, paint)
        canvas.drawCircle(200f, 350f, 150f, paint)
    }

    private fun drawSquare(canvas: Canvas) {
        val paint = Paint().apply {
            color = Color.BLUE
            textSize = 50f
        }
        canvas.drawText("Square", 120f, 800f, paint)
        canvas.drawRect(50f, 850f, 350f, 1150f, paint)
    }

    private fun drawLine(canvas: Canvas) {
        val paint = Paint().apply {
            color = Color.BLUE
            textSize = 50f
        }
        canvas.drawText("Line", 480f, 800f, paint)
        canvas.drawLine(520f, 850f, 520f, 1150f, paint)
    }
}
