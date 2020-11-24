package com.mezet.actaandroid.fragments.main.promo

import android.media.Image
import android.os.Bundle
import android.view.Gravity
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mezet.actaandroid.R
import com.mezet.actaandroid.adapters.PromoTopAdapter
import com.mezet.actaandroid.adapters.TopFiveAdapter
import com.mezet.actaandroid.adapters.VijestiAdapterOne
import com.mezet.actaandroid.models.promo.PromoPayload
import com.mezet.actaandroid.models.promohomepage.PromoHome
import com.mezet.actaandroid.presenters.promo.PromoHomePresenter
import com.mezet.actaandroid.presenters.promo.PromoPresenter
import com.mezet.actaandroid.views.PromoHomeView
import com.mezet.actaandroid.views.PromoView

class PromoFragment : Fragment(),PromoHomeView {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v = inflater.inflate(R.layout.fragment_promo, container, false)

        val categoryId = 1
        PromoHomePresenter(this).getPredstavljamo()

        val parent: Fragment? = (parentFragment as NavHostFragment).parentFragment
        val promo = parent?.view?.findViewById(R.id.promo_btn) as Button
        val kategorije = parent?.view?.findViewById(R.id.kategorije_btn) as Button
        val objavi = parent?.view?.findViewById(R.id.objavi_btn) as Button

        val promo_choosed = parent?.view?.findViewById(R.id.promo_choosed) as ImageView
        val kategorije_choosed = parent?.view?.findViewById(R.id.kategorije_choosed) as ImageView
        val objavi_choosed = parent?.view?.findViewById(R.id.objavi_choosed) as ImageView

        promo_choosed.visibility=View.VISIBLE
        kategorije_choosed.visibility=View.GONE
        objavi_choosed.visibility=View.GONE

        promo.setOnClickListener(View.OnClickListener {

        })
        kategorije.setOnClickListener(View.OnClickListener {
            findNavController().navigate(R.id.action_promoFragment_to_promoKategorijeFragment)
        })
        objavi.setOnClickListener(View.OnClickListener {

        })
        return v
    }

    override fun getPromoRespones(promoPayload: PromoHome?) {
        val adapter =context?.let { promoPayload?.let { it1 -> PromoTopAdapter(it1, it) } }
        val recyclerView = view?.findViewById(R.id.najnovije_promo_top) as RecyclerView
        recyclerView.layoutManager= LinearLayoutManager(context,
            LinearLayoutManager.HORIZONTAL,false)
        recyclerView.adapter = adapter

        val promoImgName = promoPayload?.SugestedArticles?.get(2)?.ImgName
        val promoImg = view?.findViewById<ImageView>(R.id.image_promo)
        val promoTitle = view?.findViewById<TextView>(R.id.title)
        val promoDesc =view?.findViewById<TextView>(R.id.text_bellow_title)
        context?.let {
            promoImg?.let { it1 ->
                Glide
                    .with(it)
                    .load(promoImgName)
                    .centerCrop()
                    .into(it1)
            }
        }
        promoTitle?.text=promoPayload?.SugestedArticles?.get(2)?.Title
        promoDesc?.text=promoPayload?.SugestedArticles?.get(2)?.Description


        val adapter1 =context?.let { promoPayload?.let { it1 -> TopFiveAdapter(it1, it,1) } }
        val recyclerView1 = view?.findViewById(R.id.recycler_promo_top5) as RecyclerView
        recyclerView1.layoutManager= LinearLayoutManager(context,
            LinearLayoutManager.VERTICAL,false)
        recyclerView1.adapter = adapter1

        val najcitanije_btn = view?.findViewById<Button>(R.id.najcitanije_promo)
        val najnovije_btn = view?.findViewById<Button>(R.id.najnovije_promo)

        najcitanije_btn?.setOnClickListener(View.OnClickListener {
            val adapter1 =context?.let { promoPayload?.let { it1 -> TopFiveAdapter(it1, it,2) } }
            val recyclerView1 = view?.findViewById(R.id.recycler_promo_top5) as RecyclerView
            recyclerView1.layoutManager= LinearLayoutManager(context,
                LinearLayoutManager.VERTICAL,false)
            recyclerView1.adapter = adapter1

            najcitanije_btn.setBackgroundResource(R.drawable.pink)
            najnovije_btn?.setBackgroundResource(R.drawable.ic_purple_gray)
        })

        najnovije_btn?.setOnClickListener(View.OnClickListener {
            val adapter1 =context?.let { promoPayload?.let { it1 -> TopFiveAdapter(it1, it,1) } }
            val recyclerView1 = view?.findViewById(R.id.recycler_promo_top5) as RecyclerView
            recyclerView1.layoutManager= LinearLayoutManager(context,
                LinearLayoutManager.VERTICAL,false)
            recyclerView1.adapter = adapter1

            najcitanije_btn?.setBackgroundResource(R.drawable.ic_purple_gray)
            najnovije_btn.setBackgroundResource(R.drawable.pink)
        })
    }


}