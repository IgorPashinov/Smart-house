package com.example.myapplication.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.data.AccessHistoryItem
import com.example.myapplication.web.WebClient
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.history_door.*
import kotlinx.android.synthetic.main.item_history.view.*
import kotlinx.coroutines.launch

class HistoryDoorFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.history_door, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        spisok.layoutManager=LinearLayoutManager(view.context)
        val adapter=Adapter()
        spisok.adapter=adapter
        lifecycleScope.launch {
            val history=WebClient.getaccesshistory().history
            adapter.setNewList(history.toList())
        }
    }

    class Adapter : RecyclerView.Adapter<Adapter.ViewHolder>() {

        private val list = mutableListOf<AccessHistoryItem>()

        fun setNewList(newList: List<AccessHistoryItem>) {
            list.clear()
            list.addAll(newList)
            notifyDataSetChanged()
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_history, parent, false)
            return ViewHolder(view)
        }

        override fun getItemCount(): Int {
            return list.size
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.bind(list[position])
        }

        class ViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView),
            LayoutContainer {

            fun bind(item: AccessHistoryItem) {
                containerView.DataTime.text = "Дата: ${item.date}"
                containerView.Door.text = ""
            }
        }
    }
}

