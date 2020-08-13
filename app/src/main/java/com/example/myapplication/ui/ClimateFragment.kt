package com.example.myapplication.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.example.myapplication.R
import com.example.myapplication.data.ClimateBake
import com.example.myapplication.data.ClimateHumidifier
import com.example.myapplication.data.ClimateWindow
import com.example.myapplication.web.WebClient
import kotlinx.android.synthetic.main.slot_climate.*
import kotlinx.coroutines.launch

class ClimateFragment: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.slot_climate, container, false)
    }
    var bake = false
    var humidifier = false
    var window = false
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        update()
        buttonbake.setOnClickListener {
            lifecycleScope.launch {
                WebClient.setclimatemanualmodebake(ClimateBake(!bake))
                update()
            }
        }
        buttonhumidifier.setOnClickListener {
            lifecycleScope.launch {
                WebClient.setclimatemanualmodehumidifier(ClimateHumidifier(!humidifier))
                update()
            }
        }
        buttonwindow.setOnClickListener {
            lifecycleScope.launch {
                WebClient.setclimatemanualmodewindow(ClimateWindow(!window))
                update()
            }
        }

    }
    fun getBakeState(){
        lifecycleScope.launch {
            val bakestate = WebClient.getclimatemanualmodebake()
            bake = bakestate.bake
        }
    }
    fun update(){
            lifecycleScope.launch {
                val bakestate = WebClient.getclimatemanualmodebake()
                val humidifierstate = WebClient.getclimatemanualmodehumidifier()
                val windowstate = WebClient.getclimatemanualmodewindow()
                bake= bakestate.bake
                humidifier = humidifierstate.humidifier
                window = windowstate.window
                if (bake){
                    buttonbake.text="Выключить"
                }
                else{
                    buttonbake.text="Включить"
                }
                if (humidifier){
                    buttonhumidifier.text="Выключить"
                }
                else{
                    buttonhumidifier.text="Включить"
                }
                if (window){
                    buttonwindow.text="Выключить"
                }
                else{
                    buttonwindow.text="Включить"
                }
            }
    }
}