package com.example.frontenduserinterface

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.view.View
import android.widget.EditText
import java.util.Random
import androidx.core.app.ComponentActivity
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import java.util.regex.Pattern


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


    /** Called when the user taps the Send button*/
    fun sendMessage(view: View){
        val newText = findViewById<EditText>(R.id.txtrecycle)
        newText.setText("wrong");

        val editText = findViewById<EditText>(R.id.txtzipcode)
        val zip = editText.text.toString()
        zip.trim()
//        val myPattern = "\\d{5}";
//        val validCharacterPattern = Pattern.compile(myPattern)
//        val matcher = validCharacterPattern.matcher(zip.toString());
//        val b = matcher.find();
        if(zip.length == 5) {
            val x = zip.toIntOrNull();
            if (x != null) {

                if ((x % 1) == 0) {
                    if (x > 0) {
                        val actualText = findViewById<EditText>(R.id.txtrecycle)
                        actualText.setText("correct");

                    }
                }
                //        if (b) {
                //                if ()
                //Do something in response to button
            }
        }
//        }
//        else{
//            val editText = findViewById<EditText>(R.id.txtrecycle)
//            editText.setText("wrong");
//        }
    }

    fun zipcode(view: View){
        val rand = Random();

        val n = rand.nextInt(99999) + 1;

            //Do something in response to button
            val editText = findViewById<EditText>(R.id.txtzipcode)
            editText.setText(n.toString());
    }

    fun recyclecode(view: View){
        val rand = Random();
        val n = rand.nextInt(7) + 1;
//        Do something in response to button
        val editText = findViewById<EditText>(R.id.txtrecycle)
//        editText.setText("123");
        editText.setText(n.toString());
    }
}