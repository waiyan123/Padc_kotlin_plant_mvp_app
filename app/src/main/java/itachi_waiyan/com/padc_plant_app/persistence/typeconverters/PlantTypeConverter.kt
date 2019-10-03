package itachi_waiyan.com.padc_plant_app.persistence.typeconverters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken



class PlantTypeConverter {

    @TypeConverter
    fun toString(list : List<String>) :String {

        return Gson().toJson(list)
    }

    @TypeConverter
    fun toList(data: String?): ArrayList<HashMap<String, OtherServiceEntity>> {
        if (data == null) {
            return ArrayList()
        }

        val listType = object : TypeToken<ArrayList<HashMap<String, OtherServiceEntity>>>() {

        }.type

        return gson.fromJson<ArrayList<HashMap<String, OtherServiceEntity>>>(data, listType)
    }
}