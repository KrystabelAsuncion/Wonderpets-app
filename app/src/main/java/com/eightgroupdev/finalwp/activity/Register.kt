package com.eightgroupdev.finalwp.activity

import android.content.ContentValues
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.eightgroupdev.finalwp.database.DB_Class
import com.eightgroupdev.finalwp.databinding.ActivityRegisterBinding

class Register : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var dbhelp = DB_Class(applicationContext)
        var db = dbhelp.writableDatabase

        binding.btnCreate.setOnClickListener{

            var fname = binding.etFname.text.toString()
            var usn = binding.etUsn.text.toString()
            var pw = binding.etPw.text.toString()

            if(fname.isNotEmpty() && usn.isNotEmpty() && pw.isNotEmpty()){
                var data = ContentValues()
                data.put("fullname", binding.etFname.text.toString())
                data.put("username", binding.etUsn.text.toString())
                data.put("pswd", binding.etPw.text.toString())

                var rs:Long = db.insert("user",null,data)
                if(!rs.equals(-1)){

                    var ad = AlertDialog.Builder(this)
                    ad.setTitle("Message")
                    ad.setMessage("Account registered successfully")
                    ad.setPositiveButton("Okay"){
                        _:DialogInterface, _: Int -> startActivity(Intent(this@Register, LogIn::class.java))
                    }
                    ad.show()

                }
                else{
                    var ad = AlertDialog.Builder(this)
                    ad.setTitle("Message")
                    ad.setMessage("Record not added")
                    ad.setPositiveButton("Okay", null)
                    ad.show()
                }
            } else {
                Toast.makeText(this, "All fields required",Toast.LENGTH_SHORT).show()
            }
        }
        binding.tvClickLog.setOnClickListener{
            startActivity(Intent(this@Register, LogIn::class.java))
        }
    }
}