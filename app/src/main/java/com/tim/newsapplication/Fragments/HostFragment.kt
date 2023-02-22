package com.tim.newsapplication.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.LinearLayoutManager
import com.tim.newsapplication.adapters.RecyclerViewAdapterHost
import com.tim.newsapplication.databinding.FragmentHostBinding
import com.tim.newsapplication.models.ItemsDataClass

class HostFragment : Fragment() {

    private lateinit var binding: FragmentHostBinding
    lateinit var adapter: RecyclerViewAdapterHost
    val data = MutableLiveData<List<ItemsDataClass>>(listOf())

    var names = mutableListOf<String>()
    var imageLinks = mutableListOf<String>()
    var newsDates = mutableListOf<String>()
    var shortDescriptions = mutableListOf<String>()

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

        //get data from viewModel
        //data filling test
        data.value = dataSet()
//        data.observe(viewLifecycleOwner){
//            addToList(it)
//        }

        val recyclerView = binding.RecyclerViewMain
        recyclerView.layoutManager = LinearLayoutManager(this.context)
        //adapter = RecyclerViewAdapter(names, imageLinks, newsDates, shortDescriptions)
        data.value?.let { addToList(it) }
        adapter = RecyclerViewAdapterHost(names, imageLinks, newsDates, shortDescriptions)
        recyclerView.adapter = adapter

//        scrollListener(
//            recyclerView,
//            recyclerView.layoutManager as LinearLayoutManager,
//            adapter
//        )
    }

//    private fun scrollListener(
//        recyclerView: RecyclerView,
//        layoutManager: LinearLayoutManager,
//        adapter: RecyclerViewAdapter,
//    ){
//
//        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
//            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
//
//                //val loading = viewModel.isLoading
//
//                val visibleItemCount: Int = layoutManager.childCount
//                val pastVisibleItem: Int = layoutManager.findFirstCompletelyVisibleItemPosition()
//                val totalItemNumber: Int = adapter.itemCount
//
//                //if (!loading.value){
//
//                    if (visibleItemCount + pastVisibleItem >= totalItemNumber){
//                        //viewModel.pagination()
//                        data.value = dataSet()
//                        data.value?.let { addToList(it) }
//                    }
//                //}
//                Log.d("TestTest", "${visibleItemCount} \t ${pastVisibleItem} \t ${totalItemNumber}")
//                super.onScrolled(recyclerView, dx, dy)
//            }
//        })
//    }

    //here should be viewModel calling
    private fun dataSet() : List<ItemsDataClass> {

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

        for (i in 0 .. itemsDataClassList.size - 1 ){

            names.add(itemsDataClassList[i].newsName)
            imageLinks.add(itemsDataClassList[i].imageLink)
            newsDates.add( itemsDataClassList[i].newsDate)
            shortDescriptions.add(itemsDataClassList[i].newsShortDescription)

            //adapter.notifyItemInserted(adapter.itemCount)
        }
    }
}