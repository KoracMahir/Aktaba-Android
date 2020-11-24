package com.mezet.actaandroid.fragments.sections

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mezet.actaandroid.R
import com.mezet.actaandroid.activities.JedinstvenaVijestActivity
import com.mezet.actaandroid.activities.pretraga.RegistarCompanyActivity
import com.mezet.actaandroid.adapters.VijestiAdapterOne
import com.mezet.actaandroid.adapters.VijestiAdapterTwo
import com.mezet.actaandroid.models.mostrecentnews.MostRecentNews
import com.mezet.actaandroid.presenters.VijestiPresenter
import com.mezet.actaandroid.views.VijestiView


class OnePlusTwoFragment : Fragment(), VijestiView {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view : View = inflater.inflate(R.layout.fragment_one_plus_two, container, false)
        VijestiPresenter(this).getVijestiFromAPI()


        return view
    }
    override fun onVijesti(mostRecentNews: MostRecentNews?) {
        val image_big_vijesti = view?.findViewById(R.id.image_big_one) as ImageView
        val text_big_vijesti = view?.findViewById(R.id.title_big_one) as TextView
        val text_bellow_big_title = view?.findViewById<TextView>(R.id.text_bellow_big_title)
        Glide
            .with(this)
            .load(mostRecentNews?.get(0)?.news_image)
            .centerCrop()
            .into(image_big_vijesti)
        text_big_vijesti.text = mostRecentNews?.get(0)?.news_name
        val id =mostRecentNews?.get(0)?.news_id

        image_big_vijesti.setOnClickListener(View.OnClickListener {
            val intent = Intent (activity, JedinstvenaVijestActivity::class.java)
            intent.putExtra("article_id",id)
            this.startActivity(intent)
            Log.d("article_id","saljem: "+id)
        })
        text_big_vijesti.setOnClickListener(View.OnClickListener {
            val intent = Intent (activity, JedinstvenaVijestActivity::class.java)
            intent.putExtra("article_id",mostRecentNews?.get(0)?.news_id)
            this.startActivity(intent)
        })

        val mostRecentNewseditted = mostRecentNews
        Log.d("position","non-edited:"+ mostRecentNews?.size.toString())
        mostRecentNewseditted?.remove(mostRecentNewseditted?.get(0))
        Log.d("position","edited:"+ mostRecentNewseditted?.size.toString())



        val adapter = context?.let { VijestiAdapterTwo(mostRecentNewseditted, it) }
        val recyclerView = view?.findViewById(R.id.recycler_vijesti2) as RecyclerView
        recyclerView.layoutManager= LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false)
        recyclerView.adapter = adapter



    }

    override fun onVijestiFailiuer(string: String) {
        Toast.makeText(context,string,Toast.LENGTH_LONG).show()
    }

}