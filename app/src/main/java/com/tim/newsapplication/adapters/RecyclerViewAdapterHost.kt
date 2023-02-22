package com.tim.newsapplication.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tim.newsapplication.R
import com.tim.newsapplication.databinding.RecyclerViewCardsBinding

class RecyclerViewAdapterHost(
    private var names: List<String>,
    private var imagesLinks: List<String>,
    private var newsDates: List<String>,
    private var shortDescriptions: List<String>
) : RecyclerView.Adapter<RecyclerViewAdapterHost.ViewHolder>() {

    lateinit var binding: RecyclerViewCardsBinding

    inner class ViewHolder(binding: RecyclerViewCardsBinding) :
        RecyclerView.ViewHolder(binding.root) {

        var itemName = binding.newsName
        var itemImage = binding.newsImageMain
        var itemDate = binding.dateOfNewsMain
        var itemShortDescription = binding.shortDescriptionNewsMain
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        binding =
            RecyclerViewCardsBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return names.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.itemName.text = names[position]
        holder.itemImage.setImageResource(R.drawable.ic_baseline_home_24)
        holder.itemDate.text = newsDates[position]
        holder.itemShortDescription.text = shortDescriptions[position]
//        binding.newsName.text = names[position]
//        binding.newsImageMain.setImageResource(R.drawable.ic_baseline_home_24)
//        binding.dateOfNewsMain.text = newsDates[position]
//        binding.shortDescriptionNewsMain.text = shortDescriptions[position]

//            Picasso.get()
//                .load(imagesLinks[position])
//                .fit()
//                .into(holder.itemImage)
    }
}