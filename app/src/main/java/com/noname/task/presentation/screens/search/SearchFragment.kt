package com.noname.task.presentation.screens.search

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.noname.task.R
import com.noname.task.model.entities.character
import com.noname.task.model.helper.OnItemClick
import com.noname.task.model.usecases.showToastBasedOnThrowable
import com.noname.task.presentation.screens.charactersdetails.CharctersDetailsFragment
import com.noname.task.presentation.screens.charactersfragment.CharachtersViewModel
import com.noname.task.presentation.screens.charactersfragment.ViewModelFactory
import kotlinx.android.synthetic.main.search_fragment.view.*
import kotlinx.android.synthetic.main.characters_fragment.*
import kotlinx.android.synthetic.main.characters_fragment.view.progress
import java.util.*
import android.support.v7.app.AppCompatActivity



class SearchFragment : Fragment(), OnItemClick {

    val viewModel: CharachtersViewModel by lazy {
        ViewModelProviders.of(this,getViewModelFactory()).get(CharachtersViewModel::class.java)
    }

     var searchAdapter: SearchCharcterAdapter? = null
    var ListCharacts: ArrayList<character> = arrayListOf()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.search_fragment, container, false)


        view.search.setOnClickListener {
            notfound.visibility=View.GONE
            viewModel.geCharctsResult(view.search_key.text.toString())
        }

        view.cancel.setOnClickListener {
                view.search_key.setText("")
                ListCharacts.clear()
                searchAdapter?.notifyDataSetChanged()
        }

        viewModel.CharachtsData.observe(this, Observer {
            viewModel.loadnow = false
                ListCharacts = ArrayList(it)
                if (ListCharacts.size>0) {
                    notfound.visibility=View.GONE
                    searchAdapter = SearchCharcterAdapter(activity!!, ListCharacts,this )
                    view.rc_charchters.adapter = searchAdapter
                }
                else
                    notfound.visibility=View.VISIBLE
        })


        viewModel.errorLivedat.observe(this, Observer {
            if (viewModel.page==1)
            showToastBasedOnThrowable(context,it)
            viewModel.loadnow = false
           // Toast.makeText(context,it.toString(),Toast.LENGTH_LONG).show()
        })

        viewModel.loadingLivedat.observe(this,
            Observer { loading ->
                view.progress.setVisibility(if (loading!!) View.VISIBLE else View.GONE) })

        return view
    }

    // go to details
    override fun onItemClick(charid: Int) {
        val fragment = CharctersDetailsFragment()
        val args = Bundle()
        args.putSerializable("charchterId", charid )
         fragment.setArguments(args)
        activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.fram, fragment)?.addToBackStack(null)?.commit()
    }


    ///// initialize viewmode with factory
    fun getViewModelFactory(): ViewModelFactory {
        return ViewModelFactory(activity?.application!!)
    }

    override fun onResume() {
        super.onResume()
        (activity as AppCompatActivity).supportActionBar!!.hide()
    }

    override fun onStop() {
        super.onStop()
        (activity as AppCompatActivity).supportActionBar!!.show()
    }
}
