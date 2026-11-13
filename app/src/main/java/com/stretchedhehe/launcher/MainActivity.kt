package com.stretchedhehe.launcher

import android.app.Activity
import android.content.Intent
import android.graphics.Typeface
import android.os.Bundle
import android.view.Gravity
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast

class MainActivity : Activity() {
    private val pubgPackage = "com.tencent.ig"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val root = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            gravity = Gravity.CENTER
            setPadding(28, 32, 28, 32)
            setBackgroundColor(0xFF101820.toInt())
        }

        val title = TextView(this).apply {
            text = "PUBG STRETCH LAUNCHER"
            textSize = 23f
            setTextColor(0xFFFFFFFF.toInt())
            typeface = Typeface.DEFAULT_BOLD
            gravity = Gravity.CENTER
        }
        root.addView(title, matchWrap())

        val subtitle = TextView(this).apply {
            text = "A simple launcher for PUBG Mobile"
            textSize = 15f
            setTextColor(0xFFCAD5DF.toInt())
            gravity = Gravity.CENTER
            setPadding(0, 14, 0, 28)
        }
        root.addView(subtitle, matchWrap())

        val launch = Button(this).apply {
            text = "OPEN PUBG MOBILE"
            textSize = 16f
            setOnClickListener { openPubg() }
        }
        root.addView(launch, LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT
        ))

        val note = TextView(this).apply {
            text = "IMPORTANT\nAndroid does not provide a reliable third-party API to stretch only another app's display. This launcher does not change screen resolution, density, orientation, or system display settings. Use your phone maker's per-app full-screen or aspect-ratio option, if available."
            textSize = 14f
            setTextColor(0xFFE2E8EE.toInt())
            gravity = Gravity.CENTER
            setPadding(0, 28, 0, 0)
        }
        root.addView(note, matchWrap())

        setContentView(root)
    }

    private fun openPubg() {
        val intent = packageManager.getLaunchIntentForPackage(pubgPackage)
        if (intent == null) {
            Toast.makeText(this, "PUBG Mobile Global is not installed.", Toast.LENGTH_LONG).show()
            return
        }
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        startActivity(intent)
    }

    private fun matchWrap() = LinearLayout.LayoutParams(
        ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT
    )
}
