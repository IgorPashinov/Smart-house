package com.example.myapplication.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.example.myapplication.R
import com.example.myapplication.web.WebClient
import kotlinx.android.synthetic.main.znachenia_climate.*
import kotlinx.coroutines.launch

class ZnacheniaClimate:Fragment() {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        lifecycleScope.launch {
            val znacheniye = WebClient.getclimate()
            znacheniatemperatura.text = znacheniye.temperatura.toString()
            znacheniavlaznost.text = znacheniye.vlaznost.toString()
            znacheniadavlenya.text = znacheniye.davlenie.toString()
            znacheniaCO2.text = znacheniye.CO2.toString()
        }


    }

    override fun onCreateView(

        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.znachenia_climate, container, false)
    }
}