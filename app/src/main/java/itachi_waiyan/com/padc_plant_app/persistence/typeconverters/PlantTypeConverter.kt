package itachi_waiyan.com.padc_plant_app.persistence.typeconverters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import itachi_waiyan.com.padc_plant_app.data.vos.TipsVO


class PlantTypeConverter {

    @TypeConverter
    fun toString(list : ArrayList<String>) :String {

        return Gson().toJson(list)
    }

    @TypeConverter
    fun toList(json:String) : ArrayList<String>{

        val typeToken = object : TypeToken<List<String>>(){

        }.type
        return Gson().fromJson(json,typeToken)
    }
}