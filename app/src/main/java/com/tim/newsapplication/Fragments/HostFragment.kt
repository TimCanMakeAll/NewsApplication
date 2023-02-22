package com.tim.newsapplication.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.tim.newsapplication.adapters.RecyclerViewAdapter
import com.tim.newsapplication.databinding.FragmentHostBinding
import com.tim.newsapplication.models.ItemsDataClass

class HostFragment : Fragment() {

    private lateinit var binding: FragmentHostBinding
    lateinit var adapter: RecyclerViewAdapter

    private var names = mutableListOf<String>()
    private var imageLinks = mutableListOf<String>()
    private var newsDates = mutableListOf<String>()
    private var shortDescriptions = mutableListOf<String>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHostBinding.inflate(layoutInflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.RecyclerViewMain.layoutManager = LinearLayoutManager(this.requireContext())

        //get data from viewModel
        //data filling test
        val data = dataSet()
        data
        addToList(data)
        adapter = RecyclerViewAdapter(names, imageLinks, newsDates, shortDescriptions)
        binding.RecyclerViewMain.adapter = adapter
    }

    //here should be viewModel calling
    private fun dataSet() : MutableList<ItemsDataClass> {

        val list = mutableListOf<ItemsDataClass>()

        for (i in 0 .. 19){

            list.add(ItemsDataClass(
                "test",
                "News ${i + 1}",
                "Ferrari show new supercar",
                "21.02.2023",
                "test test test test test test tes"))
        }

        return list
    }

    private fun addToList(itemsDataClassList: List<ItemsDataClass>){


        for (i in itemsDataClassList.indices){

            names.add(itemsDataClassList[i].newsName)
            imageLinks.add(itemsDataClassList[i].imageLink)
            newsDates.add( itemsDataClassList[i].newsDate)
            shortDescriptions.add(itemsDataClassList[i].newsShortDescription)

            //adapter.notifyItemInserted(adapter.itemCount)
        }
    }
}