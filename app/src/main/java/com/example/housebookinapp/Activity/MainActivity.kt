package com.example.housebookinapp.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.housebookinapp.Adapter.ItemsAdapter
import com.example.housebookinapp.Model.ItemsDomain
import com.example.housebookinapp.R
import com.example.housebookinapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)

        initList()
    }

    private fun initList() {
        val items = arrayListOf(
            ItemsDomain(
                "Apartment",
                "Bidhan Apartment",
                "Hargeisa SL",
                "item_1",
                2,
                3,
                1500,
                350,
                true,
                4.5,
                "ku yaala biriijka agtiisa This page explains how to format code in ordinary text sentences. For more information about formatting and explaining placeholders, command-line syntax, and code samples, see the following resources:"
            ),
            ItemsDomain(
                "House",
                "Rugsan Village",
                "Hargeisa SL",
                "item_2",
                1,
                2,
                800,
                500,
                false,
                4.9,
                "ku yaala masallaha This page explains how to format code in ordinary text sentences. For more information about formatting and explaining placeholders, command-line syntax, and code samples, see the following resources:"
            ),
            ItemsDomain(
                "Apartment",
                "Badacas Apartment",
                "Hargeisa SL",
                "item_3",
                3,
                3,
                1600,
                390,
                true,
                4.5,
                "ku yaala madaxtooyada agteeda This page explains how to format code in ordinary text sentences. For more information about formatting and explaining placeholders, command-line syntax, and code samples, see the following resources:"
            ),
            ItemsDomain(
                "House",
                "Aragsan Village",
                "Hargeisa SL",
                "item_4",
                5,
                3,
                1000,
                500,
                false,
                4.7,
                "ku yaala buurta kala jeexan This page explains how to format code in ordinary text sentences. For more information about formatting and explaining placeholders, command-line syntax, and code samples, see the following resources:"
            )

        )
        binding.recommendView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.recommendView.adapter = ItemsAdapter(items)
    }
}