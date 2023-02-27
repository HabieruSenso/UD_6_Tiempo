package com.utad.ud_6_tiempo.genres

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tema19mvm.genres.WeatherAdapter
import com.example.tema19mvm.genres.WeatherViewModel
import com.utad.ud_6_tiempo.R
import kotlinx.coroutines.launch


class TiempoFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tiempo, container, false)
    }

    private lateinit var pbLoading: View
    private lateinit var rvTemperaturas: RecyclerView
    private var adapter: WeatherAdapter? = null

    private val viewModel: WeatherViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rvTemperaturas = view . findViewById (R.id.rvTemperaturas)
        pbLoading = view.findViewById(R.id.progressBar)

        initList()
        listenEvents()
        viewModel . getWeather()
    }

    private fun initList() {
        val mLayoutManager = GridLayoutManager(context, 1)
        rvTemperaturas.layoutManager = mLayoutManager

        //para que carge
        adapter = WeatherAdapter(){

        }
        rvTemperaturas.adapter = adapter

    }

    private fun listenEvents() {

        viewLifecycleOwner.lifecycleScope.launch {

            repeatOnLifecycle(Lifecycle.State.STARTED) {

                launch {

                    viewModel.weatherList.collect {

                        adapter?.data = it
                        adapter ?. notifyDataSetChanged ()

                    }
                }
                launch {
                    viewModel.loading.collect {
                        pbLoading.isVisible = it
                    }
                }
            }
        }
    }
}