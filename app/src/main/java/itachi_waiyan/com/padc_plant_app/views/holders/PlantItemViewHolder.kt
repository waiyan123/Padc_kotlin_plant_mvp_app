package itachi_waiyan.com.padc_plant_app.views.holders

import android.util.Log
import android.view.View
import com.bumptech.glide.Glide
import itachi_waiyan.com.padc_plant_app.data.vos.PlantVO
import itachi_waiyan.com.padc_plant_app.delegates.PlantsItemDelegate
import kotlinx.android.synthetic.main.plant_item_view.view.*

class PlantItemViewHolder (itemView: View, private val delegate: PlantsItemDelegate):
    BaseViewHolder<PlantVO>(itemView){

    init {
//        Log.d("test---","init")
        Log.d("test---","init")
        itemView.setOnClickListener {
            data?.plant_id?.let {
                delegate.onTabItem(it,itemView.img_plant_pic)
            }

        }
    }

    override fun bindData(data: PlantVO) {
        Log.d("test---","bind data")
        itemView.tv_plant_name.text = data.plant_name
        itemView.tv_plant_owner.text = data.uploaded_user.name

        Glide.with(itemView)
            .load(data.plant_photo)
            .into(itemView.img_plant_pic)

        Glide.with(itemView)
            .load(data.uploaded_user.user_photo)
            .into(itemView.img_owner)
    }

}