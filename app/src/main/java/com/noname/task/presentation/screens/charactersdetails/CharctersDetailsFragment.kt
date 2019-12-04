package com.noname.task.presentation.screens.charactersdetails

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.noname.task.R
import com.noname.task.model.entities.CharchtDetails
import com.noname.task.model.usecases.loadUrl
import com.noname.task.model.usecases.loudImage
import com.noname.task.model.usecases.showToastBasedOnThrowable
import com.noname.task.presentation.screens.charactersdetails.adapter.DetailsAdapter
import com.noname.task.presentation.screens.charactersfragment.CharachtersViewModel
import com.noname.task.presentation.screens.charactersfragment.ViewModelFactory
import kotlinx.android.synthetic.main.character_details_fragment.view.*

class CharctersDetailsFragment : Fragment() {

    val viewModel: CharachtersViewModel by lazy {
        ViewModelProviders.of(this, getViewModelFactory()).get(CharachtersViewModel::class.java)
    }

    var  details: CharchtDetails? =null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.character_details_fragment, container, false)
        val charchterId = arguments?.getInt("charchterId", 0)!!
        viewModel.getCharchterData(charchterId)
        viewModel.getComicsData(charchterId)
        viewModel.getSeriesData(charchterId)
        viewModel.getStoresData(charchterId)
        viewModel.getEventsData(charchterId)

        viewModel.detailsLivedat.observe(this, Observer {
            details = it
            view.des_txt.text = it?.data?.results?.get(0)?.description
            view.name_txt.text = it?.data?.results?.get(0)?.name
            loudImage(
                context, view.charchter_img, it?.data?.results?.get(0)?.thumbnail?.path + "." +
                        it?.data?.results?.get(0)?.thumbnail?.extension
            )
        })

        view.details.setOnClickListener {
            details?.data?.results?.get(0)?.urls?.map {
                    charchtUrl ->
                if (charchtUrl.type.equals("detail"))
                    loadUrl(context!!,charchtUrl.url)
            }
        }

        view.wiki.setOnClickListener {
            details?.data?.results?.get(0)?.urls?.map {
                    charchtUrl ->
                if (charchtUrl.type.equals("wiki"))
                    loadUrl(context!!,charchtUrl.url)
            }
        }
        view.comik.setOnClickListener {
            details?.data?.results?.get(0)?.urls?.map {
                    charchtUrl ->
                if (charchtUrl.type.equals("comoklink"))
                    loadUrl(context!!,charchtUrl.url)
            }
        }
        viewModel.comicsData.observe(this, Observer {
            view.rc_comics.adapter = DetailsAdapter(activity!!, it)
        })

        viewModel.storesData.observe(this, Observer {
            view.rc_stories.adapter = DetailsAdapter(activity!!, it)

        })

        viewModel.seriesData.observe(this, Observer {
            view.rc_series.adapter = DetailsAdapter(activity!!, it)
        })

        viewModel.eventsData.observe(this, Observer {
            view.rc_events.adapter = DetailsAdapter(activity!!, it)

        })
        viewModel.errorLivedat.observe(this, Observer {
            showToastBasedOnThrowable(context, it)
        })

        viewModel.loadingLivedat.observe(this,
            Observer { loading ->
                view.progress.setVisibility(if (loading!!) View.VISIBLE else View.GONE)
            })

        return view
    }

    fun getViewModelFactory(): ViewModelFactory {
        return ViewModelFactory(activity?.application!!)
    }

}
