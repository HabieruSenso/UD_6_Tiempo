package com.example.tema19mvm.genres

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.tema19mvm.data.models.WeatherResponse
import com.utad.ud_6_tiempo.R


class WeatherAdapter(var data: List<WeatherResponse.Main> = listOf(), val onClick:(WeatherResponse.Main)->Unit) :
    RecyclerView.Adapter<WeatherAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_weather, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int = data.size

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val card = itemView.findViewById<CardView>(R.id.card)

        val tiempo = itemView.findViewById<TextView>(R.id.tiempo)

        val humedad = itemView.findViewById<TextView>(R.id.humedad)


        fun bind(item: WeatherResponse.Main) {
            tiempo.text = item.temp.toString() + " º"
            humedad.text = item.humidity.toString() + " humedad"

            card.setCardBackgroundColor(generateColor().toInt())

            card.setOnClickListener {
                Log.v("Temperatura", item.temp.toString())
                Log.v("Humedad", item.humidity.toString())
                onClick(item)
            }
        }

        fun generateColor(): Long {
            val colors = arrayListOf(
                0xfff44336, 0xffe91e63, 0xff9c27b0, 0xff673ab7,
                0xff3f51b5, 0xff2196f3, 0xff03a9f4, 0xff00bcd4,
                0xff009688, 0xff4caf50, 0xff8bc34a, 0xffcddc39,
                0xffffeb3b, 0xffffc107, 0xffff9800, 0xffff5722,
                0xff795548, 0xff9e9e9e, 0xff607d8b, 0xff333333
            )
            return colors.random()
        }
    }
}