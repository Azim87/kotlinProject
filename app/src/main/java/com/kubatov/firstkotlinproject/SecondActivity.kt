package com.kubatov.firstkotlinproject

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.kubatov.firstkotlinproject.util.Show
import kotlinx.android.synthetic.main.activity_second.*


class SecondActivity : AppCompatActivity() {
    private var text: String? = null
    private var textResult: String? = null

    companion object {
        const val RESULT_TEXT = "result"
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        sendToMain()
        getMessageFromMain()
        title = "second activity"
    }

    private fun getMessageFromMain() {
        text = intent.getStringExtra(MainActivity.EXTRA_DATA)
        Show.me("second activity: $text")
        sent_edit_text_2.setText(text)
    }

    private fun sendToMain() {
        button2.setOnClickListener {
            textResult = sent_edit_text_2.text.toString()
            if (textResult.isNullOrEmpty()) {
                Show.me("Пусто")

            } else {
                val intent = Intent(this, MainActivity::class.java)
                intent.putExtra(RESULT_TEXT, textResult)
                setResult(Activity.RESULT_OK, intent)
                finish()
            }
        }
    }
}
