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
            rangeSeekbar2.setMinStartValue(temperatura.min_temperatura.toFloat())
                .setMaxStartValue(temperatura.max_temperatura.toFloat()).apply()

            rangeSeekbar3.setMinStartValue(vlaznostc.min_vlazhnost.toFloat())
            .setMaxStartValue(vlaznostc.max_vlazhnost.toFloat()).apply()

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
        rangeSeekbar2.setMaxValue(100f).setMinValue(18f).apply()

    }
}