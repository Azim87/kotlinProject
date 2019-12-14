package com.kubatov.firstkotlinproject

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.kubatov.firstkotlinproject.util.Show
import kotlinx.android.synthetic.main.activity_second.*


class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        getMessageFromMain()
        title = "second activity"
    }

    private fun getMessageFromMain() {
        val message: String? = intent.getStringExtra("text")
        Show.me("second activity: " + message)
        sent_edit_text_2.setText(message)

        button_send_2.setOnClickListener {
            if (sent_edit_text_2.text.isEmpty()) {
                Show.me("Текстовое поле пусто, введите данные")
            } else {
                val result:String = sent_edit_text_2.text.toString().trim()
                val intent = Intent(this, MainActivity::class.java)
                intent.putExtra("result", result)
                startActivity(intent)
                finish()
            }
        }
    }
}
