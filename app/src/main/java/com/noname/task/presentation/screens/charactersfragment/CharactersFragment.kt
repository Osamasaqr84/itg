package com.noname.task.presentation.screens.charactersfragment

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.noname.task.R
import com.noname.task.model.entities.character
import com.noname.task.model.helper.OnItemClick
import com.noname.task.model.usecases.showToastBasedOnThrowable
import com.noname.task.presentation.screens.charactersdetails.CharctersDetailsFragment
import kotlinx.android.synthetic.main.characters_fragment.*
import kotlinx.android.synthetic.main.characters_fragment.view.*
import java.util.*

class CharactersFragment : Fragment(), OnItemClick {

    val viewModel: CharachtersViewModel by lazy {
        ViewModelProviders.of(this,getViewModelFactory()).get(CharachtersViewModel::class.java)
    }

    lateinit var charcterAdapter: CharcterAdapter
    internal lateinit var ListCharacts: ArrayList<character>
    var againdata = true


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.characters_fragment, container, false)

        viewModel.geCharcts()
        viewModel.CharachtsData.observe(this, Observer {
            viewModel.loadnow = false
            if (viewModel.page == 1) {
                ListCharacts = ArrayList(it)
                if (ListCharacts.size>0) {
                    charcterAdapter = CharcterAdapter(activity!!, ListCharacts,this )
                    view.characters.adapter = charcterAdapter
                }
                else
                    notfound.visibility=View.VISIBLE

            } else {
                if (it!!.size>0) {
                    ListCharacts.addAll(it)
                    charcterAdapter.notifyDataSetChanged()
                 //   view.repositries.scrollToPosition(CharcterAdapter.getItemCount() - 14)
                }else
                    againdata = false
            }
        })

        //// handel pagination
        view.characters.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                val lastVisibleItem =
                    (Objects.requireNonNull(recyclerView.layoutManager) as LinearLayoutManager).findLastCompletelyVisibleItemPosition()
                if (lastVisibleItem == charcterAdapter.getItemCount() - 1&& dy>0) {
                   // if (viewModel.page) {
                        if (againdata)
                            viewModel.page++;
                        viewModel.geCharcts( )
                 //   }
                }
            }
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

}
