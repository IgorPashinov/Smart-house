package com.example.myapplication.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.myapplication.R

class Lightfragment:Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_light, container, false)
    }
}


private var isClick = false
override fun onCreateView(){
    val view = Infalter.inflate(R.layout. fragment_light.container, false)
    val btn = view.findViewById(R.id.btn)
    btn.set0ClickListener{
        isClick = true
        if(isClick) {
            btn.text = "Вкл"
        }else{
            btn.text = "Выкл"
        }
    }
    return view
}