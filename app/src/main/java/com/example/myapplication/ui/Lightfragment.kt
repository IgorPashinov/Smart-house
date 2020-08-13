package com.example.myapplication.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.example.myapplication.R
import com.example.myapplication.data.DataIlumination
import com.example.myapplication.data.Turnoforturnon
import com.example.myapplication.web.WebClient
import kotlinx.android.synthetic.main.fragment_light.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.HttpException

class Lightfragment:Fragment() {
    private var isClick = false
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {



       // return null

        val view = inflater.inflate(R.layout.fragment_light, container, false)


        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        update()
        rangeSeekbar1.setOnRangeSeekbarFinalValueListener { minValue, maxValue ->
            lifecycleScope.launch{
                WebClient.setIllumination(DataIlumination(lamp, minValue.toFloat(), maxValue.toFloat()))
            }
        }
        btn.setOnClickListener{
            lifecycleScope.launch(Dispatchers.IO) {
                WebClient.setTurnoforturnon(Turnoforturnon(!lamp, 100))
                lifecycleScope.launch(Dispatchers.Main) {
                    try {
                        update()
                    } catch (e: HttpException) {
                        Log.d("lightFragment", "error Http")
                    }
                }

            }

        }
    }
    var lamp: Boolean = false


    fun update() {
        Log.v("CytckCheck", "1")
        lifecycleScope.launch(Dispatchers.IO) {
            Log.v("CytckCheck", "2")
            val state = WebClient.getTurnoforturnon()
            lamp = state.state
            launch(Dispatchers.Main) {
                Log.v("CytckCheck", "3")
                if (lamp) {
                    btn.text = "Вкл"
                } else {
                    btn.text = "Выкл"
                }
                val illumination = WebClient.getIllumination()
                rangeSeekbar1.setMinValue(illumination.minIllumination)
                rangeSeekbar1.setMaxValue(illumination.maxIllumination)
            }
        }

    }

}


