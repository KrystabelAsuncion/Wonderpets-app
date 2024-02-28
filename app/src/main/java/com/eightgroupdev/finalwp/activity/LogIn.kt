package com.eightgroupdev.finalwp.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import com.eightgroupdev.finalwp.database.DB_Class
import com.eightgroupdev.finalwp.databinding.ActivityLogInBinding
import com.eightgroupdev.finalwp.activity.LogIn as ActivityLogIn

class LogIn : AppCompatActivity() {
    private lateinit var binding: ActivityLogInBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLogInBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var dbhelp = DB_Class(applicationContext)
        var db = dbhelp.readableDatabase

        binding.btnLog.setOnClickListener {

            var username = binding.etUsnLog.text.toString();
            var password = binding.etPwLog.text.toString()
            val query = "SELECT * FROM user WHERE username='"+username+"' AND pswd='"+password+"'"
            val rs = db.rawQuery(query,null)

            if(rs.moveToFirst()){
                val name = rs.getString(rs.getColumnIndex("fullname"))
                rs.close()

                // Access the parent activity's intent
                val activityIntent = this.intent

                // Check if the parent activity's intent is not null
                if (activityIntent != null) {
                    // Add the data to the parent activity's intent
                    activityIntent.putExtra("name", name)
                }

                startActivity(Intent(this@LogIn, BottomNavBar::class.java))
                this.finish()
            }

            else{
                var ad = AlertDialog.Builder(this)
                ad.setTitle("Message")
                ad.setMessage("Username or password is incorrect!")
                ad.setPositiveButton("Okay", null)
                ad.show()
            }

        }

        binding.tvCreateAcct.setOnClickListener {
            val intent = Intent(this, Register::class.java)
            startActivity(intent)
        }

        binding.tvForgotPw.setOnClickListener {
            startActivity(Intent(this,ResetPW::class.java))
        }
    }
}