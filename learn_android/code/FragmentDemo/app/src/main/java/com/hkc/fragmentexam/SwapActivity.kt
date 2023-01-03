package com.hkc.fragmentexam

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_swap.*

class SwapActivity : AppCompatActivity() {

    private lateinit var detail:DetailFragment
    private lateinit var contact:ContactFragment


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_swap)

        contact = ContactFragment.instance
        detail = DetailFragment.instance
        supportFragmentManager.beginTransaction().run{
            add(R.id.container,contact)
            commit()
        }

        fab.setOnClickListener {
            swap()
        }
    }

    private fun swap() {
        supportFragmentManager.beginTransaction().run {
            replace(R.id.container,detail)
//            addToBackStack(null)
//            commit()
//            remove(contact)
//            add(detail,null)
            addToBackStack(null)
            commit()


        }

    }
}