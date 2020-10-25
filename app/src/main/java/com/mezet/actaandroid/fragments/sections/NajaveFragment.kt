package com.mezet.actaandroid.fragments.sections

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mezet.actaandroid.R
import com.mezet.actaandroid.adapters.BlueBlackAdapter
import com.mezet.actaandroid.models.mostrecentnews.MostRecentNews
import com.mezet.actaandroid.presenters.AnalizePresenter
import com.mezet.actaandroid.presenters.NajavePresenter
import com.mezet.actaandroid.views.NajaveView

class NajaveFragment : Fragment(),NajaveView {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        NajavePresenter(this).getVijestiFromAPI()

        return inflater.inflate(R.layout.fragment_najave, container, false)

    }

    override fun onNajave(mostRecentNews: MostRecentNews?) {
        val adapter = context?.let { BlueBlackAdapter(mostRecentNews, it) }
        val recyclerView = view?.findViewById(R.id.blue_black_recycler_najave) as RecyclerView
        recyclerView.layoutManager= LinearLayoutManager(context,
            LinearLayoutManager.VERTICAL,false)
        recyclerView.adapter = adapter
    }

}