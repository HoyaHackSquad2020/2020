package com.example.frontenduserinterface

import java.util.*
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

//import com.mongodb.MongoClient
//import com.mongodb.MongoClientURI
import com.mongodb.client.MongoDatabase



class MainActivity : AppCompatActivity() {

    //private lateinit var fusedLocationClient: FusedLocationProviderClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)
    }

    // Called when user presses cmdSend
    fun sendMessage(view: View){

        //val uri = MongoClientURI("mongodb+srv://js:hoyahackathon@cluster0-yieuo.mongodb.net/test?retryWrites=true&w=majority")
        //val mongoClient = MongoClient(uri)
        //val database: MongoDatabase = mongoClient.getDatabase("zip_codes")
        //val myCollection = database.getCollection("usa")
        //val query = myCollection.find().limit(5)


        val lblResults = findViewById<EditText>(R.id.lblResults)
        lblResults.setTextColor(Color.RED)
        lblResults.setText("Incorrect")
        val txtZIPcode = findViewById<EditText>(R.id.txtZIPcode)
        val zip = txtZIPcode.text.toString().trim() // Read ZIP code and trim whitespace
        if(zip.length == 5) {
            val x = zip.toIntOrNull()
            if (x != null) {
                if ((x % 1) == 0) {
                    if (x > 0) {
                        lblResults.setText("Correct")
                        lblResults.setTextColor(Color.GREEN)
                    }
                }
            }
        }
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

        /*fusedLocationClient.lastLocation
            .addOnSuccessListener { location : Location? ->
                // Got last known location. In some rare situations this can be null.
        }*/
    }

    // Called when user presses cmdRecycleCode
    fun recyclecode(view: View){
        val rand = Random()
        val n = rand.nextInt(7) + 1 // Generates a random number between 1 and 7
        val txtRecycleCode = findViewById<EditText>(R.id.txtRecycleCpde)
        txtRecycleCode.setText(n.toString())
    }





}
