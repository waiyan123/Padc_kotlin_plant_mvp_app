package itachi_waiyan.com.padc_plant_app.network.responses

import com.google.gson.annotations.SerializedName
import itachi_waiyan.com.padc_plant_app.persistence.UserEntity
import itachi_waiyan.com.padc_plant_app.utils.CODE_RESPONSE_OK

class LoginResponse (

    @SerializedName("message")
    val message : String,

    @SerializedName("code")
    val code : Int,

    @SerializedName("data")
    val data : UserEntity

)
{
    fun isResponseOk() : Boolean {
        return code == CODE_RESPONSE_OK && data!=null
    }
}