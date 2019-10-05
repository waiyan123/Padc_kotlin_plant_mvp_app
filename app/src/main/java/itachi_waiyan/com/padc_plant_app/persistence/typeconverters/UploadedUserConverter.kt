package itachi_waiyan.com.padc_plant_app.persistence.typeconverters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import itachi_waiyan.com.padc_plant_app.data.vos.PlantVO
import itachi_waiyan.com.padc_plant_app.data.vos.UploadedUserVO

class UploadedUserConverter {

    @TypeConverter
    fun toString (uploadedUserVO : UploadedUserVO):String {
        return Gson().toJson(uploadedUserVO)
    }

    @TypeConverter
    fun toVO (json:String) : UploadedUserVO{

        val typeToken = object : TypeToken<UploadedUserVO>(){

        }.type

        return Gson().fromJson(json,typeToken)
    }
}