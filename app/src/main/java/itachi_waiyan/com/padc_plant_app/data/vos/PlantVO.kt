package itachi_waiyan.com.padc_plant_app.data.vos

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import itachi_waiyan.com.padc_plant_app.persistence.typeconverters.PlantTypeConverter

@Entity(tableName = "plant_table")
data class PlantVO(

    @PrimaryKey
    @ColumnInfo(name = "plant_id")
    @SerializedName("plant_id")
    val plant_id : String,

    @ColumnInfo(name = "plant_name")
    @SerializedName("plant_name")
    val plant_name : String,

    @ColumnInfo(name = "plant_type")
    @SerializedName("plant_type")
    val plant_type :  ArrayList<String>,

    @ColumnInfo(name = "description")
    @SerializedName("description")
    val description : String,

    @ColumnInfo(name = "top_tip")
    @SerializedName("top_tip")
    val top_tip : String,

    @ColumnInfo(name = "tips")
    @SerializedName("tips")
    val tips : TipsVO,

    @ColumnInfo(name = "uploaded_user")
    @SerializedName("uploaded_user")
    val uploaded_user : UploadedUserVO,

    @ColumnInfo(name = "plant_photo")
    @SerializedName("plant_photo")
    val plant_photo : String
)

{
}