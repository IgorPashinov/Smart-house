package com.example.myapplication.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.myapplication.MainActivity
import com.example.myapplication.R
import kotlinx.android.synthetic.main.fragment_main.*
import kotlin.math.acosh

class MainFragment: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        light.setOnClickListener {
                (activity as? MainActivity)?.add(Lightfragment())
        }
        access.setOnClickListener {
            (activity as? MainActivity)?.add(DostupFragment())
        }
        climate.setOnClickListener {
            (activity as? MainActivity)?.add(MebuClimate())
        }
    }
}