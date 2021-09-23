package com.jrumpe.orbtour.ui.Favorites

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.jrumpe.orbtour.R
import com.jrumpe.orbtour.ui.city.City

class FavoritesAdapter(val context: Context, var favCityList: ArrayList<City>) :
    RecyclerView.Adapter<FavoritesAdapter.FavCityViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): FavoritesAdapter.FavCityViewHolder {
        val itemView =
            LayoutInflater.from(context).inflate(R.layout.list_item_favorite, parent, false)
        return FavCityViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: FavoritesAdapter.FavCityViewHolder, position: Int) {
        val city = favCityList[position]
        holder.setData(city, position)
    }

    override fun getItemCount(): Int {
        return favCityList.size
    }

    inner class FavCityViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private var currentPosition: Int = -1
        private var currentCity: City? = null

        private val txvCityName = itemView.findViewById<TextView>(R.id.txv_city_name)
        private val imvCityImage = itemView.findViewById<ImageView>(R.id.imv_city)

        fun setData(city: City, position: Int) {

            txvCityName.text = city.name
            imvCityImage.setImageResource(city.imageId)

            this.currentPosition = position
            this.currentCity = city
        }
    }
}