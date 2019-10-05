package itachi_waiyan.com.padc_plant_app.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import itachi_waiyan.com.padc_plant_app.R
import itachi_waiyan.com.padc_plant_app.data.vos.PlantVO
import itachi_waiyan.com.padc_plant_app.delegates.PlantsItemDelegate
import itachi_waiyan.com.padc_plant_app.views.holders.BaseViewHolder
import itachi_waiyan.com.padc_plant_app.views.holders.PlantItemViewHolder

class PlantListRecyclerAdapter(private val mPlantsItemDelegate: PlantsItemDelegate) :
    BaseRecyclerAdapter<PlantItemViewHolder,PlantVO>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlantItemViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.plant_item_view,parent,false)
        return PlantItemViewHolder(itemView,mPlantsItemDelegate)
    }


}