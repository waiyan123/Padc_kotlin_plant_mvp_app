package itachi_waiyan.com.padc_plant_app.views.holders

import android.view.View
import com.bumptech.glide.Glide
import itachi_waiyan.com.padc_plant_app.data.vos.PlantVO
import kotlinx.android.synthetic.main.plant_detail_item_view.view.*

class PlantTemperatureViewHolder(itemView: View) :BaseViewHolder<PlantVO>(itemView){


    override fun bindData(data: PlantVO) {
        itemView.tv_temperature.text = data.tips.temperature
        itemView.tv_light.text = data.tips.light

        Glide.with(itemView)
            .load(data.plant_photo)
            .into(itemView.img_plant_pic)
    }

}