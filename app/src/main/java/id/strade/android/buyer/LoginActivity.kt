package id.strade.android.buyer

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import org.androidannotations.annotations.AfterViews
import org.androidannotations.annotations.Click
import org.androidannotations.annotations.EActivity

@EActivity(R.layout.activity_login)
open class LoginActivity : AppCompatActivity() {

    @AfterViews
    fun init() {

    }

    @Click(R.id.btn_login_api)
    fun login(){
        var username = findViewById<EditText>(R.id.username_edit_text).text.toString()
        var password = findViewById<EditText>(R.id.password_edit_text).text.toString()
        Log.i("login", "user :" +username+ " LOGIN API")

    }
}
