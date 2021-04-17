package com.example.testdmmp

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class NavActivity : AppCompatActivity() {
    lateinit var toolbar: ActionBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nav)
        toolbar = supportActionBar!!
        val bottomNavigation: BottomNavigationView = findViewById(R.id.bottom_nav)
        val HomeFragment=HomeFragment()
        val QuizFragment=QuizFragment()
        val SpaceFragment=SpaceFragment()
        setCurrentFragment(HomeFragment)

       /* if(intent.getStringExtra("email") != null) {
            val email_valeur = intent.getStringExtra("email")


            val bundle = Bundle()
            bundle.putString("params",email_valeur.toString())
            Toast.makeText(this,email_valeur,Toast.LENGTH_LONG).show()
            HomeFragment.arguments = bundle
        }*/

        bottomNavigation.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.nav_home->setCurrentFragment(HomeFragment)
                R.id.nav_quiz->setCurrentFragment(QuizFragment)
                R.id.nav_space->setCurrentFragment(SpaceFragment)

            }
            true
        }

    }
    public fun getMyData(): String? {
        return intent.getStringExtra("email").toString()
    }
    private fun setCurrentFragment(fragment:Fragment)=
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragment,fragment)
            commit()
        }
    }

