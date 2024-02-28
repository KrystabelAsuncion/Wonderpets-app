package com.eightgroupdev.finalwp.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import com.eightgroupdev.finalwp.R
import com.eightgroupdev.finalwp.database.UserManagement

class ResetPW : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reset_pw)
        backbtn()
        resetBtn()


    }

    fun backbtn(){
        val backbtn = findViewById<Button>(R.id.tvback)
        backbtn.setOnClickListener{
            startActivity(Intent(this@ResetPW, LogIn::class.java))
            finish()
        }

    }

    fun resetBtn(){
        val userManagement = UserManagement(this)

        val etUsername = findViewById<EditText>(R.id.et_usnLog)
        val etNewPassword = findViewById<EditText>(R.id.et_newpwLog)
        val resetButton = findViewById<Button>(R.id.btn_resetpw)

        resetButton.setOnClickListener {
            val username = etUsername.text.toString()
            val newPassword = etNewPassword.text.toString()

            if (username.isNotEmpty() && newPassword.isNotEmpty()) {
                val passwordResetSuccessful = userManagement.resetPassword(username, newPassword)

                val builder = AlertDialog.Builder(this) // "this" refers to the context of your activity
                builder.setTitle("Password Reset")

                if (passwordResetSuccessful) {
                    // Password reset was successful, show a success message
                    builder.setMessage("Password reset successful.")
                } else {
                    // Password reset failed, show an error message
                    builder.setMessage("Password reset failed.")
                }

                builder.setPositiveButton("OKAY") { _, _ ->
                    // Handle the "OK" button click, e.g., return to the previous activity
                    finish() // This closes the PasswordResetActivity
                }

                val dialog = builder.create()
                dialog.show()
            } else {
                // Handle input validation (e.g., show a validation error)
            }

        }

    }


}