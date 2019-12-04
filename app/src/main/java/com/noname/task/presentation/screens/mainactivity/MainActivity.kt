package com.noname.task.presentation.screens.mainactivity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.noname.task.R
import com.noname.task.presentation.screens.charactersfragment.CharactersFragment
import android.support.annotation.NonNull
import com.noname.task.presentation.screens.search.SearchFragment


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction().replace(R.id.fram,CharactersFragment()).addToBackStack("main").commit()
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(@NonNull item: MenuItem): Boolean {

        if (item.itemId == R.id.search) {
            supportFragmentManager.beginTransaction().replace(R.id.fram, SearchFragment())
                .addToBackStack("").commit()

        }

        return true
    }
}
