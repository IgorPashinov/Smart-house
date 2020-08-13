package com.example.myapplication.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.example.myapplication.R
import com.example.myapplication.data.AutoModeTemperatura
import com.example.myapplication.data.AutoModeVlaznost
import com.example.myapplication.web.WebClient
import kotlinx.android.synthetic.main.climate_auto.*
import kotlinx.coroutines.launch

class AutoClimateFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.climate_auto, container, false)
    }

    fun update() {
        lifecycleScope.launch {
            val temperatura = WebClient.getclimateautomodetemperatura()
            val vlaznostc = WebClient.getclimateautomodevlaznost()
            rangeSeekbar2.setMinValue(temperatura.min_temperatura.toFloat())
            rangeSeekbar2.setMinValue(temperatura.max_temperatura.toFloat())
            rangeSeekbar3.setMinValue(vlaznostc.min_vlasnost.toFloat())
            rangeSeekbar3.setMinValue(vlaznostc.max_vlasnost.toFloat())
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        update()/**/
        rangeSeekbar2.setOnRangeSeekbarFinalValueListener { minValue, maxValue ->
            lifecycleScope.launch {
                WebClient.setclimateautomodetemperatura(
                    AutoModeTemperatura(
                        minValue.toInt(),
                        maxValue.toInt()
                    )
                )
            }

        }
        rangeSeekbar3.setOnRangeSeekbarFinalValueListener { minValue, maxValue ->
            lifecycleScope.launch {
                WebClient.setclimateautomodevlaznost(
                    AutoModeVlaznost(
                        minValue.toInt(),
                        maxValue.toInt()
                    )
                )
            }

        }
    }
}