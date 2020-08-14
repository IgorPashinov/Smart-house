package com.example.myapplication.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.example.myapplication.R
import com.example.myapplication.web.WebClient
import com.jjoe64.graphview.series.DataPoint
import com.jjoe64.graphview.series.LineGraphSeries
import kotlinx.android.synthetic.main.fragment_temperatura.*
import kotlinx.coroutines.launch

class TemperaturaFragment:Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_temperatura, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        lifecycleScope.launch{
            val history = WebClient.gettemperaturahistory()
            val point = history.history.map {
                DataPoint( it.date.toDouble(), it.value.toDouble())
            }
            GraphTrmperatura.addSeries(LineGraphSeries(point.toTypedArray()))
        }
        lifecycleScope.launch{
            val history = WebClient.getvlaznosthistory()
            val point = history.history.map {
                DataPoint( it.date.toDouble(), it.value.toDouble())
            }
            GraphVlaznost.addSeries(LineGraphSeries(point.toTypedArray()))
        }
        lifecycleScope.launch{
            val history = WebClient.getdavleniehistory()
            val point = history.history.map {
                DataPoint( it.date.toDouble(), it.value.toDouble())
            }
            GraphDavlenie.addSeries(LineGraphSeries(point.toTypedArray()))
        }
        lifecycleScope.launch{
            val history = WebClient.getCO2history()
            val point = history.history.map {
                DataPoint( it.date.toDouble(), it.value.toDouble())
            }
            GraphC02.addSeries(LineGraphSeries(point.toTypedArray()))
        }
    }
}

