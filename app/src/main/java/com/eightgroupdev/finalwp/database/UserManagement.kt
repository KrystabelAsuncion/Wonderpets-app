package com.eightgroupdev.finalwp.database

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import com.eightgroupdev.finalwp.database.DB_Class
import android.database.sqlite.SQLiteDatabase
import com.google.firebase.firestore.auth.User

class UserManagement(context: Context) {
    val dbClass = DB_Class(context)

    fun resetPassword(username: String, newPassword: String): Boolean {
        val db = dbClass.writableDatabase

        // Simulated password reset logic (insecure, for demonstration purposes).
        // You should implement secure password reset logic with hashing and validation.
        val values = ContentValues()
        values.put(DB_Class.KEY_PSWD, newPassword)

        val updatedRows = db.update(
            DB_Class.TABLE_CONTACTS,
            values,
            "${DB_Class.KEY_UNAME}=?",
            arrayOf(username)
        )

        db.close()

        return updatedRows > 0
    }

}
