package com.mezet.actaandroid.fragments.sections

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mezet.actaandroid.R
import com.mezet.actaandroid.adapters.FourNewsAdapter
import com.mezet.actaandroid.adapters.VijestiAdapterOne
import com.mezet.actaandroid.models.mostrecentnews.MostRecentNews
import com.mezet.actaandroid.presenters.FourNewsPresenter
import com.mezet.actaandroid.views.MostRecentNewsView

class FourNewsTextSectionFragment : Fragment(),MostRecentNewsView {


    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        FourNewsPresenter(this).getMostRecentFromAPI()
        val view = inflater.inflate(R.layout.fragment_four_news_text_section, container, false)

        val textontop = view.findViewById(R.id.section_title) as TextView
        textontop.text = "Top 5 vijesti"

        return view
    }

    override fun onMostRecentNews(mostRecentNews: MostRecentNews?) {
        val adapter = context?.let { FourNewsAdapter(mostRecentNews, it) }
        val recyclerView = view?.findViewById(R.id.four_news_recycler) as RecyclerView
        recyclerView.layoutManager= LinearLayoutManager(context,
            LinearLayoutManager.VERTICAL,false)
        recyclerView.adapter = adapter
    }

    override fun onFailiuer(string: String) {

    }

}