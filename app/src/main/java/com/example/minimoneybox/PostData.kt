package com.example.minimoneybox

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.ValueAnimator
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.TextInputLayout
import android.view.ActionMode
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.airbnb.lottie.LottieAnimationView
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_login.view.*
import okhttp3.*
import java.io.BufferedReader
import java.util.regex.Pattern
import java.io.IOException
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.net.HttpURLConnection
import java.net.URL
import java.net.URLEncoder
import android.animation.Animator.AnimatorListener as AnimatorListener1
import android.R.string
import android.os.AsyncTask
import android.os.AsyncTask.execute
import okhttp3.RequestBody
import okhttp3.OkHttpClient
import org.w3c.dom.Text


class PostData : AsyncTask<Void, Void, String>(){

    private val client = OkHttpClient()
    lateinit var et_email : String
    lateinit var et_password : String

    override fun doInBackground(vararg params: Void?): String? {
        val formBody = RequestBody.create( MediaType.parse("application/json"),"{\n" +
                "  \"Email\": \"" + et_email + "\",\n" +
                "  \"Password\": \""+et_password+"\",\n" +
                "  \"Idfa\": \"ANYTHING\"\n" +
                "}")

        val request = Request.Builder()
            .url("https://api-test01.moneyboxapp.com/users/login")
            .header("AppId", "3a97b932a9d449c981b595")
            .header("Content-Type", "application/json")
            .header("appVersion", "5.10.0")
            .header("apiVersion", "3.0.0")
            .post(formBody)
            .build()

        val response = client.newCall(request).execute()
        if (!response.isSuccessful) throw IOException("Unexpected code $response")

        System.out.println(response.body().toString())
        return "something"
    }

    override fun onPreExecute() {
        super.onPreExecute()
        // ...
    }

    override fun onPostExecute(result: String?) {
        super.onPostExecute(result)
        // ...
    }
    fun sendPostRequest(email:String, password:String): String? {
        et_email=email
        et_password=password
        return doInBackground()
    }
}