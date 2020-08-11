package com.example.myapplication.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.example.myapplication.R
import com.example.myapplication.data.Turnoforturnon
import com.example.myapplication.web.WebClient
import kotlinx.android.synthetic.main.fragment_light.*
import kotlinx.coroutines.launch

class Lightfragment:Fragment() {
    private var isClick = false
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {



        return null

        val view = inflater.inflate(R.layout.fragment_light, container, false)


        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
       update()
        btn.setOnClickListener{
            lifecycleScope.launch {
                WebClient.setTurnoforturnon(Turnoforturnon(!lamp, 100))
                update()
            }

        }
    }
    var lamp: Boolean = false


    fun update() {
        lifecycleScope.launch {
            val state = WebClient.getTurnoforturnon()
            lamp = state.state
            if(lamp) {
                btn.text = "Вкл"
            }else{
                btn.text = "Выкл"
            }
        }

    }

}


