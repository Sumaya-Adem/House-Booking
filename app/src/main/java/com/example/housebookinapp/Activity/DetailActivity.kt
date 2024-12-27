package com.example.housebookinapp.Activity

import android.app.Dialog
import android.content.res.Resources
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AlertDialog
import com.bumptech.glide.Glide
import com.example.housebookinapp.Model.ItemsDomain
import com.example.housebookinapp.R
import com.example.housebookinapp.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding
    private lateinit var property: ItemsDomain
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.addBtn.setOnClickListener {
            ShowDialog()
        }
        getBundles()
        setVariables()
    }

    private fun setVariables() {
        binding.backBtn.setOnClickListener { finish() }
        val drawableResourceId= resources.getIdentifier(property.pickPath,"drawable",packageName)
        Glide.with(this@DetailActivity)
            .load(drawableResourceId)
            .into(binding.picDrtail)

//        calling data from property>ItemDomain
        binding.titleAddress.text = "${property.title} in ${property.address}"
        binding.apartmentName.text = property.title
        binding.descripTxt.text = property.description
        binding.scoreRating.text = "${property.score}"
        binding.priceText.text = "$${property.price}"
        binding.bedTxt.text = "${property.bed} Bedroom"
        binding.bathTxt.text ="${property.bath} Bathroom"
        binding.grageTxt.text = if(property.isGarage)"car garage" else "no-car-garage"
        binding.houseSize.text = "${property.size} m2"
    }

    private fun getBundles() {
        property = intent.getSerializableExtra("object") as ItemsDomain
    }




//    Dialog
    private fun ShowDialog(){

        val builder = AlertDialog.Builder(this)
        builder.setTitle("Request Appointment")
               .setMessage("Are sure you want to request an appointment?")
               .setPositiveButton("Yes"){ Dialog, _ ->
                   Dialog.dismiss()
               }
            .setNegativeButton("No") {Dialog, _ ->
                Dialog.dismiss()
            }

        val dialog = builder.create()
            dialog.show()
    }
}