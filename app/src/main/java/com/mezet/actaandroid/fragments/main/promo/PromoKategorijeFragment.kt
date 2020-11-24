package com.mezet.actaandroid.fragments.main.promo

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mezet.actaandroid.R
import com.mezet.actaandroid.adapters.PromoKategorijeAdapter
import com.mezet.actaandroid.adapters.TopFiveAdapter
import com.mezet.actaandroid.models.promokategorije.PromoKategorije
import com.mezet.actaandroid.presenters.promo.PromoCategoriesPresenter
import com.mezet.actaandroid.views.PromoKategorijeView
import kotlinx.android.synthetic.main.fragment_promo_main.*


class PromoKategorijeFragment : Fragment(),PromoKategorijeView {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v = inflater.inflate(R.layout.fragment_promo_kategorije, container, false)

        //recycler_kategorije_promo

        PromoCategoriesPresenter(this).getKategorije()

        val parent: Fragment? = (parentFragment as NavHostFragment).parentFragment
        val promo = parent?.view?.findViewById(R.id.promo_btn) as Button
        val kategorije = parent?.view?.findViewById(R.id.kategorije_btn) as Button
        val objavi = parent?.view?.findViewById(R.id.objavi_btn) as Button

        val promo_choosed = parent?.view?.findViewById(R.id.promo_choosed) as ImageView
        val kategorije_choosed = parent?.view?.findViewById(R.id.kategorije_choosed) as ImageView
        val objavi_choosed = parent?.view?.findViewById(R.id.objavi_choosed) as ImageView

        promo_choosed.visibility=View.GONE
        kategorije_choosed.visibility=View.VISIBLE
        objavi_choosed.visibility=View.GONE

        promo.setOnClickListener(View.OnClickListener {
            findNavController().navigate(R.id.action_promoKategorijeFragment_to_promoFragment)
        })
        kategorije.setOnClickListener(View.OnClickListener {

        })
        objavi.setOnClickListener(View.OnClickListener {

        })

        return v
    }

    override fun getPromoRespones(promoKategorije: PromoKategorije?) {
        val promoKategorijeeditted = promoKategorije
        promoKategorijeeditted?.remove(promoKategorije?.get(1))
        promoKategorijeeditted?.remove(promoKategorije?.get(0))

        val adapter1 =context?.let { promoKategorijeeditted?.let { it1 -> PromoKategorijeAdapter(it1, it) } }
        val recyclerView1 = view?.findViewById(R.id.recycler_kategorije_promo) as RecyclerView
        recyclerView1.layoutManager= LinearLayoutManager(context,
            LinearLayoutManager.VERTICAL,false)
        recyclerView1.adapter = adapter1
    }


}