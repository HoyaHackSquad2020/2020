package com.example.frontenduserinterface

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.os.StrictMode
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import java.util.*

import java.io.BufferedReader;
import com.opencsv.CSVReader
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (Build.VERSION.SDK_INT > 9) {
            val policy =
                StrictMode.ThreadPolicy.Builder().permitAll().build()
            StrictMode.setThreadPolicy(policy)
        }
        //fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)
    }

    // Called when user presses cmdSend
    fun sendMessage(view: View){
        var valid = true
        val lblResults = findViewById<EditText>(R.id.lblResults)
        lblResults.setTextColor(Color.BLUE)
        lblResults.setText("No")
        val zip = findViewById<EditText>(R.id.txtZIPcode).text.toString()
        if (zip.length != 5) valid = false
        val rcode = findViewById<EditText>(R.id.txtRecycleCode).text.toString()
        if (rcode.length != 1) valid = false
        if (valid){
            if (checkData(zip, rcode))
            {
                lblResults.setText("Yes!")
                lblResults.setTextColor(Color.GREEN)
            }
        }
        else {
            lblResults.setText("Invalid Input")
            lblResults.setTextColor(Color.RED)
        }
    }

    // calls to search for a zip code and recycle code match in csv database
    fun checkData(zip: String, rcode: String): Boolean{
        var foundTotalMatch = false
        val inputStream: InputStream = resources.openRawResource(R.raw.us_zipcodes_recyclecodes)
        val reader = BufferedReader(InputStreamReader(inputStream, Charset.forName("UTF-8")))
        var firstLine = true
        for (line in reader.readLines()){
            if (firstLine) // skip first line (header)
            {
                firstLine = false
                continue
            }
            val items = line.split(",")
            var zipMatch = false
            var count = 0
            for (i in items){
                if (count == 0) { // first column (zip codes)
                    if (i.equals(zip)){
                        zipMatch = true
                    }
                }
                if (! zipMatch)   break
                if (count == 5) { // last column (recycle codes)
                    if (i.indexOf(rcode) > -1) // substring found in larger string
                    {
                        foundTotalMatch = true
                        break
                    }
                }
                ++count
            }
            if (foundTotalMatch)    break
        }
        return foundTotalMatch
    }

    // Called when user presses cmdZIPcode
    fun zipcode(view: View){
        val rand = Random();
        val randString = StringBuilder()
        for (x in 0 until 5) // Generates a 5-digit random number
        {
            randString.append((rand.nextInt(9) + 1).toString())
        }
        val txtZIPcode = findViewById<EditText>(R.id.txtZIPcode)
        txtZIPcode.setText(randString.toString())
    }

    // Called when user presses cmdRecycleCode
    fun recyclecode(view: View){
        val rand = Random()
        val n = rand.nextInt(7) + 1 // Generates a random number between 1 and 7
        val txtRecycleCode = findViewById<EditText>(R.id.txtRecycleCode)
        txtRecycleCode.setText(n.toString())
    }
}
