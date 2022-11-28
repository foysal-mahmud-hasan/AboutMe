package com.foysal.practice.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.databinding.DataBindingUtil
import com.foysal.practice.aboutme.R.layout.activity_main
import com.foysal.practice.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    private val myName : MyName = MyName("Foysal Mahmud")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, activity_main)

        binding.myName = myName

        binding.btnDone.setOnClickListener{

            nickName(it)

        }
    }

    private fun nickName(view: View) {
        binding.apply {
            binding.tvNickName.text = binding.edNickName.text.toString()

            invalidateAll()

            binding.btnDone.visibility = View.GONE
            binding.edNickName.visibility = View.GONE
            tvNickName.visibility = View.VISIBLE

            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(view.windowToken, 0)
        }
    }
}