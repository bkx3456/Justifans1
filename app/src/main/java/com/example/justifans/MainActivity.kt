package com.example.justifans

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.justifans.databinding.ActivityMainBinding
import com.example.justifans.home.HomeFragment
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class MainActivity : AppCompatActivity() {
    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var loginButton: Button
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance()

        // Find views by ID
        emailEditText = findViewById(R.id.EmailEditText)
        passwordEditText = findViewById(R.id.PasswordEditText)
        loginButton = findViewById(R.id.LoginButton)

        // Set login button onClickListener
        loginButton.setOnClickListener {
            val email = emailEditText.text.toString().trim()
            val password = passwordEditText.text.toString().trim()

            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Please enter both email and password", Toast.LENGTH_SHORT).show()
            } else {
                loginUser(email, password)
            }
        }
    }

    private fun loginUser(email: String, password: String) {
        mAuth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success
                    val user: FirebaseUser? = mAuth.currentUser
                    user?.let {
                        val userEmail = it.email // Rename to userEmail to avoid shadowing
                        if (!userEmail.isNullOrEmpty()) {
                            Toast.makeText(this, "Welcome $userEmail!", Toast.LENGTH_SHORT).show()
                        } else {
                            Toast.makeText(this, "Welcome, user!", Toast.LENGTH_SHORT).show()
                        }
                    }

                    // Redirect to HomeFragment
                    val intent = Intent(this, HomeFragment::class.java)
                    startActivity(intent)
                    finish() // Close the login activity
                } else {
                    // If sign in fails, display a message to the user.
                    Toast.makeText(this, "Login Failed.", Toast.LENGTH_SHORT).show()
                }
            }
    }

    private fun createAccount(email: String, password: String) {
        mAuth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Account creation successful
                    val user = mAuth.currentUser
                    user?.let {
                        Toast.makeText(this, "Account created for ${it.email}!", Toast.LENGTH_SHORT).show()
                    }
                } else {
                    // Account creation failed
                    Toast.makeText(this, "Account creation failed.", Toast.LENGTH_SHORT).show()
                }
            }
    }

    private fun logout() {
        mAuth.signOut()
        Toast.makeText(this, "Logged out successfully.", Toast.LENGTH_SHORT).show()
    }

    override fun onStart() {
        super.onStart()
        // Check if user is already logged in
        val currentUser: FirebaseUser? = mAuth.currentUser
        if (currentUser != null) {
            // If user is already logged in, navigate to HomeFragment
            val intent = Intent(this, HomeFragment::class.java)
            startActivity(intent)
            finish()
        }
    }
}
