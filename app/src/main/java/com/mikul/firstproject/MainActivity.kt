package com.mikul.firstproject

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.util.Linkify
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.util.regex.Pattern

import android.text.style.ClickableSpan
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        showToast("onCreate")

        val buttonSkills = findViewById<Button>(R.id.btnSkills)
        val buttonExperience = findViewById<Button>(R.id.btnExperience)
        val buttonEducation = findViewById<Button>(R.id.btnEducation)
        val buttonProjects = findViewById<TextView>(R.id.btnProjects)

        val tvContacts = findViewById<TextView>(R.id.tvContacts)
        val spannableString = SpannableString(tvContacts.text)
        Linkify.addLinks(spannableString, Linkify.WEB_URLS)

        val githubUrl = "https://github.com/Michjosh"
        val githubClickableSpan = object : ClickableSpan() {
            override fun onClick(view: View) {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(githubUrl))
                startActivity(intent)
            }
        }

        val githubPattern = Pattern.compile("Github: Michjosh")
        val matcher = githubPattern.matcher(tvContacts.text)
        while (matcher.find()) {
            spannableString.setSpan(
                githubClickableSpan,
                matcher.start(),
                matcher.end(),
                Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
            )
        }

        tvContacts.text = spannableString


        buttonSkills.setOnClickListener {
            intent = Intent(this, SkillsActivity::class.java)
            startActivity(intent)
        }

        buttonExperience.setOnClickListener {
            val intent = Intent(this, ExperienceActivity::class.java)
            startActivity(intent)
        }

        buttonEducation.setOnClickListener {
            val intent = Intent(this, EducationActivity::class.java)
            startActivity(intent)
        }

        buttonProjects.setOnClickListener {
            val intent = Intent(this, ProjectsActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onStart() {
        super.onStart()
        showToast("onStart")
    }

    override fun onResume() {
        super.onResume()
        showToast("onResume")
    }

    override fun onPause() {
        super.onPause()
        showToast("onPause")
    }

    override fun onStop() {
        super.onStop()
        showToast("onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        showToast("onDestroy")
    }

    override fun onRestart() {
        super.onRestart()
        showToast("onRestart")
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
