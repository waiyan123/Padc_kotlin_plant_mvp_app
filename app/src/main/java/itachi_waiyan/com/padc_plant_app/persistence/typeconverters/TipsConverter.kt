package itachi_waiyan.com.padc_plant_app.persistence.typeconverters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import itachi_waiyan.com.padc_plant_app.data.vos.PlantVO
import itachi_waiyan.com.padc_plant_app.data.vos.TipsVO

class TipsConverter {

    @TypeConverter
    fun toString(tipsVO :TipsVO) : String {
        return Gson().toJson(tipsVO)
    }

    @TypeConverter
    fun toObject(json : String) : TipsVO{

        val typeToken = object : TypeToken<TipsVO>(){

        }.type
        return Gson().fromJson(json,typeToken)
    }
}