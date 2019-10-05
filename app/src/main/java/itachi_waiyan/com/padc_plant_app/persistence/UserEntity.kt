package itachi_waiyan.com.padc_plant_app.persistence

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "user_table")
data class UserEntity(

    @PrimaryKey
    @ColumnInfo(name = "user_id")
    @SerializedName("user_id")
    var user_id : String,

    @ColumnInfo(name = "user_name")
    @SerializedName("user_name")
    var user_name : String = "",

    @ColumnInfo(name = "user_photo_url")
    @SerializedName("user_photo_url")
    var user_photo_url : String = "",

    @ColumnInfo(name = "member_since")
    @SerializedName("member_since")
    var member_since : String = "",

    @ColumnInfo(name = "member_rank")
    @SerializedName("member_rank")
    var member_rank : String = ""
)
{
}