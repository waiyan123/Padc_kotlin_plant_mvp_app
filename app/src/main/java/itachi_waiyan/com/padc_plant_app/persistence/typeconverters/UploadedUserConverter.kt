package itachi_waiyan.com.padc_plant_app.persistence.typeconverters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import itachi_waiyan.com.padc_plant_app.data.vos.PlantVO
import itachi_waiyan.com.padc_plant_app.data.vos.UploadedUserVO

class UploadedUserConverter {

    @TypeConverter
    fun toString (list:List<UploadedUserVO>):String {
        return Gson().toJson(list)
    }

    @TypeConverter
    fun toList (json:String):List<UploadedUserVO>{

        val typeToken = object : TypeToken<List<UploadedUserVO>>(){

        }.type

        return Gson().fromJson(json,typeToken)
    }
}