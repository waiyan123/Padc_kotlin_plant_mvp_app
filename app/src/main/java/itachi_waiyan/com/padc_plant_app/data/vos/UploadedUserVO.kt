package itachi_waiyan.com.padc_plant_app.data.vos

import androidx.room.ColumnInfo
import com.google.gson.annotations.SerializedName

data class UploadedUserVO(

    @ColumnInfo(name = "name")
    @SerializedName("name")
    val name : String,

    @ColumnInfo(name = "user_photo")
    @SerializedName("user_photo")
    val user_photo : String,

    @ColumnInfo(name = "uploaded_time")
    @SerializedName("uploaded_time")
    val uploaded_time : String,

    @ColumnInfo(name = "user_rank")
    @SerializedName("user_rank")
    val user_rank : String
)

{
}