package com.mezet.actaandroid.fragments.main.vijesti

import android.content.Intent
import android.os.Bundle
import android.text.Html
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toolbar
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mezet.actaandroid.R
import com.mezet.actaandroid.activities.MainActivity
import com.mezet.actaandroid.activities.pretraga.PretragaVijestiActivity
import com.mezet.actaandroid.adapters.PovezaneFirmeAdapter
import com.mezet.actaandroid.adapters.PovezaneVijestiAdapter
import com.mezet.actaandroid.models.jedinstvenavijesti.JedinstvenaVijest
import com.mezet.actaandroid.presenters.vijesti.JedinstvenaVijestPresenter
import com.mezet.actaandroid.views.JedinstvenaVijestView
import kotlinx.android.synthetic.main.appbar_small.view.*

class JedinstvenaVijestFragment : Fragment(),JedinstvenaVijestView {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v = inflater.inflate(R.layout.fragment_jedinstvena_vijest, container, false)
        val vrati_na=activity?.intent?.getStringExtra("vrati_na")
        val pretraga=activity?.intent?.getStringExtra("zadnja_pretraga")

        Log.d("pretraga: ","vijest: "+pretraga)
        val appbar_text =activity?.findViewById(R.id.appbar_jedinstvena) as Toolbar
        appbar_text.back_btn_appbar.setOnClickListener(View.OnClickListener {
            vrati_na?.let { it1 -> pretraga?.let { it2 -> back(it1, it2) } }
        })

        requireActivity().onBackPressedDispatcher.addCallback(
            viewLifecycleOwner,
            object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    vrati_na?.let { pretraga?.let { it1 -> back(it, it1) } }
                }
            }
        )
        val article_id=activity?.intent?.getIntExtra("article_id",0)
        Log.d("article_id","dobijam: "+article_id)
        article_id?.let { JedinstvenaVijestPresenter(this).getJedinstvenaVijesti(it) }

        return v
    }
    fun back(vrati_na : String,pretraga:String){
        if(vrati_na=="home"){
            val intent = Intent (activity, MainActivity::class.java)
            intent.putExtra("open","fin")
            this.startActivity(intent)
        }else if(vrati_na=="pretraga") {
            Log.d("pretraga: ","back: "+pretraga)
            val intent = Intent (activity, PretragaVijestiActivity::class.java)
            intent.putExtra("open","rezultati")
            intent.putExtra("zadnja_pretraga",pretraga)
            this.startActivity(intent)
        }
    }

    override fun getJedinstvenaVijesti(jedinstvenaVijest: JedinstvenaVijest?) {
        val text1 = view?.findViewById<TextView>(R.id.jedinstvena_vijest_description)
        text1?.text = Html.fromHtml(jedinstvenaVijest?.news_content)

        val titletext = view?.findViewById<TextView>(R.id.jedinstvena_vijest_title)
        val image_bis = view?.findViewById<ImageView>(R.id.jedinstvena_vijesti_image)

        image_bis?.let {
            Glide
                .with(this)
                .load(jedinstvenaVijest?.news_image)
                .centerCrop()
                .into(it)
        }

        titletext?.text = jedinstvenaVijest?.news_name

        val adapter =context?.let { jedinstvenaVijest?.let { it1 -> PovezaneFirmeAdapter(it1, it) } }
        val recyclerView = view?.findViewById(R.id.recycler_povezane_firme) as RecyclerView
        recyclerView.layoutManager= LinearLayoutManager(context, LinearLayoutManager.VERTICAL,false)
        recyclerView.adapter = adapter

        val adapter1 =context?.let { jedinstvenaVijest?.let { it1 -> PovezaneVijestiAdapter(it1, it) } }
        val recyclerView1 = view?.findViewById(R.id.recycler_povezane_vijesti) as RecyclerView
        recyclerView1.layoutManager= LinearLayoutManager(context, LinearLayoutManager.VERTICAL,false)
        recyclerView1.adapter = adapter1
    }

}