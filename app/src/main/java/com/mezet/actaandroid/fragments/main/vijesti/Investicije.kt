package com.mezet.actaandroid.fragments.main.vijesti

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mezet.actaandroid.R
import com.mezet.actaandroid.adapters.VijestiAdapterOne
import com.mezet.actaandroid.models.mostrecentnews.MostRecentNews
import com.mezet.actaandroid.presenters.MostRecentNewsInvesticijePresenter
import com.mezet.actaandroid.presenters.MostRecentNewsVijestiPresenter
import com.mezet.actaandroid.views.MostRecentNewsView

class Investicije : Fragment(),MostRecentNewsView {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val view : View = inflater.inflate(R.layout.fragment_investicije, container, false)
        MostRecentNewsInvesticijePresenter(this).getMostRecentFromAPI()


        return view
    }

    override fun onMostRecentNews(mostRecentNews: MostRecentNews?) {
        val adapter = context?.let { VijestiAdapterOne(mostRecentNews, it) }
        val recyclerView = view?.findViewById(R.id.najnovije_top) as RecyclerView
        recyclerView.layoutManager= LinearLayoutManager(context,
            LinearLayoutManager.HORIZONTAL,false)
        recyclerView.adapter = adapter
    }

    override fun onFailiuer(string: String) {
        Toast.makeText(context,string, Toast.LENGTH_LONG).show()
    }

}