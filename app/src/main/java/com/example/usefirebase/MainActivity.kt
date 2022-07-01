package com.example.usefirebase

import android.app.backup.BackupAgent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.usefirebase.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)

//        binding.deletedUsersTxt.setOnClickListener {
//            var userName
//        }

        val adder = findViewById<Button>(R.id.addBtn)
        val remover = findViewById<Button>(R.id.removeBtn)

        adder.setOnClickListener() {
            registerUser()
        }

//        remover.setOnClickListener() {
//            removeUser()
//        }

    }

//    private fun removeUser() {
//        val db = FirebaseFirestore.getInstance().
//
//    }

    private fun registerUser() {

        val db = FirebaseFirestore.getInstance()
        val user: MutableMap<String, Any> = HashMap()
        user["firstName"] = findViewById<EditText>(R.id.firstNameEditTxt).text.toString()
        user["lastName"] = findViewById<EditText>(R.id.lastNameEditTxt).text.toString()
        user["age"] = findViewById<EditText>(R.id.ageEditTxt).text.toString()
        user["email"] = findViewById<EditText>(R.id.emailEditTxt).text.toString()

        db.collection("Users")
            .add(user)
            .addOnSuccessListener {
                Toast.makeText(this, "Added successfully", Toast.LENGTH_SHORT).show()
            }
            .addOnFailureListener {
                Toast.makeText(this, "Add failed", Toast.LENGTH_SHORT).show()

            }
    }
}