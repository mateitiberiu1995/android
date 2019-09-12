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
import java.util.regex.Pattern
import android.animation.Animator.AnimatorListener as AnimatorListener1

/**
 * A login screen that offers login via email/password.
 */
class LoginActivity : AppCompatActivity() {

    lateinit var btn_sign_in : Button
    lateinit var til_email : TextInputLayout
    lateinit var et_email : EditText
    lateinit var til_password : TextInputLayout
    lateinit var et_password : EditText
    lateinit var til_name : TextInputLayout
    lateinit var et_name : EditText
    lateinit var pigAnimation : LottieAnimationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        setupViews()
    }

    override fun onStart() {
        super.onStart()
        setupAnimation()

    }



    private fun setupViews() {
        btn_sign_in = findViewById(R.id.btn_sign_in)
        til_email = findViewById(R.id.til_email)
        et_email = findViewById(R.id.et_email)
        til_password = findViewById(R.id.til_password)
        et_password = findViewById(R.id.et_password)
        til_name = findViewById(R.id.til_name)
        et_name = findViewById(R.id.et_name)
        pigAnimation = findViewById(R.id.animation)

        btn_sign_in.setOnClickListener {
            if (allFieldsValid()) {
                Toast.makeText(this, R.string.input_valid, Toast.LENGTH_LONG).show()
            }
        }


    }

    private fun allFieldsValid() : Boolean {
        var allValid = false
        if(et_email.text.toString()!="" && et_password.text.toString()!="" && et_name.text.toString()!="")
        {
            if (Pattern.matches(EMAIL_REGEX, et_email.text.toString()) && Pattern.matches(PASSWORD_REGEX, et_password.text.toString()) && Pattern.matches(NAME_REGEX, et_name.text.toString()))
            {
                    allValid=true;
            }
            else
            {
                if (!Pattern.matches(EMAIL_REGEX, et_email.text.toString()))
                    til_email.error = getString(R.string.email_address_error)
                if (!Pattern.matches(PASSWORD_REGEX, et_password.text.toString()))
                    til_password.error = getString(R.string.password_error)
                if (!Pattern.matches(NAME_REGEX, et_name.text.toString()))
                    til_name.error = getString(R.string.full_name_error)
            }
        }
        else
            if (et_email.text.toString() != "" && et_password.text.toString() != "") {
                if (Pattern.matches(EMAIL_REGEX, et_email.text.toString()) && Pattern.matches(PASSWORD_REGEX, et_password.text.toString()))
                {
                    allValid = true;
                } else {
                    if (!Pattern.matches(EMAIL_REGEX, et_email.text.toString()))
                        til_email.error = getString(R.string.email_address_error)
                    if (!Pattern.matches(PASSWORD_REGEX, et_password.text.toString()))
                        til_password.error = getString(R.string.password_error)
                }
            }
            else
            {
                if (et_email.text.toString() == "")
                    til_email.error = "Email is not optional!"
                if(et_password.text.toString() == "")
                    til_password.error="Password is not optional"
                if (!Pattern.matches(NAME_REGEX, et_name.text.toString()))
                    til_name.error = getString(R.string.full_name_error)
            }


        return allValid
    }

    private fun setupAnimation() {
        pigAnimation.playAnimation()

        pigAnimation.addAnimatorListener(object : Animator.AnimatorListener{
            override fun onAnimationStart(animation: Animator?) {
                pigAnimation.loop(true)
            }

            override fun onAnimationCancel(animation: Animator?) {            }

            override fun onAnimationRepeat(animation: Animator?) {
                pigAnimation.setMinAndMaxFrame(131,158)
            }


            override fun onAnimationEnd(animation: Animator?) {
            }

        })

    }



    companion object {
        val EMAIL_REGEX = "[^@]+@[^.]+\\..+"
        val NAME_REGEX = "[a-zA-Z]{6,30}"
        val PASSWORD_REGEX = "^(?=.*[0-9])(?=.*[A-Z]).{10,50}$"
        val firstAnim = 0 to 109
        val secondAnim = 131 to 158
    }
}
