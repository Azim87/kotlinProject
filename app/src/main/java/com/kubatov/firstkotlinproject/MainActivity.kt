package com.kubatov.firstkotlinproject

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.kubatov.firstkotlinproject.util.Show
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        sendMessage()
        title = "main activity"
    }

    private fun sendMessage() {
        button_send_1.setOnClickListener {
            val message: String = sent_edit_text_1.text.toString()

            if (message.trim().isEmpty()) {
                Show.me("Текстовое поле пусто, введите данные")

            } else {
                val text: String = sent_edit_text_1.text.toString()
                val intent = Intent(this, SecondActivity::class.java)
                intent.putExtra("text", text)
                startActivity(intent)
                finish()
            }
        }
        getDataFromSecondActivity()
    }

    private fun getDataFromSecondActivity() {
        val result: String? = intent.getStringExtra("result")
        sent_edit_text_1.setText(result)
        Show.me("main activity: " + result)
    }
}
