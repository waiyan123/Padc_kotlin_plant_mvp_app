package itachi_waiyan.com.padc_plant_app.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import itachi_waiyan.com.padc_plant_app.R
import itachi_waiyan.com.padc_plant_app.data.vos.PlantVO
import itachi_waiyan.com.padc_plant_app.views.holders.PlantItemViewHolder
import itachi_waiyan.com.padc_plant_app.views.holders.PlantTemperatureViewHolder

class PlantDetailsRecyclerAdapter : BaseRecyclerAdapter<PlantTemperatureViewHolder,PlantVO>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlantTemperatureViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.plant_detail_item_view,parent,false)
        return PlantTemperatureViewHolder(itemView)
    }
}