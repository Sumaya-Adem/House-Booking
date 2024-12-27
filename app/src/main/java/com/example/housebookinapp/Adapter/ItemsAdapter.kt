package com.example.housebookinapp.Adapter


import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.housebookinapp.Activity.DetailActivity
import com.example.housebookinapp.Model.ItemsDomain
import com.example.housebookinapp.databinding.ViewholderItemBinding

class ItemsAdapter(private val items:ArrayList<ItemsDomain>):
    RecyclerView.Adapter<ItemsAdapter.Viewholder>() {
        private lateinit var context : Context

    class Viewholder(val binding: ViewholderItemBinding):
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemsAdapter.Viewholder {
 val binding  = ViewholderItemBinding.inflate(LayoutInflater.from(parent.context),
     parent,false)
        context = parent.context
        return Viewholder(binding)
    }

    override fun onBindViewHolder(holder: ItemsAdapter.Viewholder, position: Int) {
        val item = items[position]
        with(holder.binding){
            titleText.text = item.title
            homePrice.text="$${item.price}"
            bedroomNumber.text= item.bed.toString()
            bathroomNumber.text=item.bath.toString()


            val drawableResourceId = holder.itemView.resources.getIdentifier(
                item.pickPath,"drawable",holder.itemView.context.packageName
            )

            Glide.with(context).load(drawableResourceId).into(pic1)

            holder.itemView.setOnClickListener {
             val intent = Intent(context,DetailActivity::class.java)
                intent.putExtra("object", item)
                context.startActivity(intent)
            }
        }
    }

    override fun getItemCount(): Int= items.size

}