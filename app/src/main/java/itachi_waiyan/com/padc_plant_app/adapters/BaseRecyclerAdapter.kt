package itachi_waiyan.com.padc_plant_app.adapters

import androidx.recyclerview.widget.RecyclerView
import itachi_waiyan.com.padc_plant_app.data.vos.PlantVO
import itachi_waiyan.com.padc_plant_app.views.holders.BaseViewHolder

abstract class BaseRecyclerAdapter<VH : BaseViewHolder<T>,T> :RecyclerView.Adapter<VH>(){

    var plantList : MutableList<T> = ArrayList()

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.data = plantList[position]
    }

    override fun getItemCount(): Int {
        return plantList.size
    }

    fun setNewData(list:List<T>){
        plantList = list.toMutableList()
        notifyDataSetChanged()
    }

    fun appendNewData(list:List<T>){
        plantList.addAll(list.toMutableList())
    }
}