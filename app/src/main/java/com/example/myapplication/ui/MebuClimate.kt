package com.example.myapplication.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.myapplication.MainActivity
import com.example.myapplication.R
import kotlinx.android.synthetic.main.fragment_climate.*

class MebuClimate:Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_climate, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        buttonrezimauto.setOnClickListener {
           (activity as? MainActivity)?.add(AutoClimateFragment())

        }
        buttonrezimruchnoi.setOnClickListener {
            (activity as? MainActivity)?.add(ClimateFragment())
        }
        buttongraphs.setOnClickListener {
            (activity as? MainActivity)?.add(TemperaturaFragment())
        }
    }
}