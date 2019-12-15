package com.kubatov.firstkotlinproject

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.kubatov.firstkotlinproject.util.Show
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    companion object {
        const val REQUEST_CODE = 1
        const val EXTRA_DATA = "text"
    }

    private lateinit var message: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        sendMessage()
        title = "main activity"
    }

    private fun sendMessage() {
        button_send_1.setOnClickListener {
            message = sent_edit_text_1.text.toString()

            if (message.trim().isEmpty()) {
                Show.me("Текстовое поле пусто, введите данные")

            } else {
                val text: String = sent_edit_text_1.text.toString()
                val intent = Intent(this, SecondActivity::class.java)
                intent.putExtra(EXTRA_DATA, text)
                startActivityForResult(intent, REQUEST_CODE)
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CODE) {
            if (resultCode == Activity.RESULT_OK) {
                if (data != null) {
                    val result = data.getStringExtra(SecondActivity.RESULT_TEXT)
                    if (result != message) {
                        sent_edit_text_1.setText(result)
                        Show.me("Данные изменились с $message на $result")
                    } else {
                        Show.me("Данные не изменились!")
                    }
                }
            }
        }
    }
}
