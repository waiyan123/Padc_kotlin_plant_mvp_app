package itachi_waiyan.com.padc_plant_app.network.responses

import com.google.gson.annotations.SerializedName
import itachi_waiyan.com.padc_plant_app.data.vos.PlantVO
import itachi_waiyan.com.padc_plant_app.utils.CODE_RESPONSE_OK

class GetAllPlantsResponse (

    @SerializedName("message")
    val message : String,

    @SerializedName("code")
    val code : Int,

    @SerializedName("data")
    val data : List<PlantVO>


)

{
    fun isResponseOk() : Boolean {
        return code == CODE_RESPONSE_OK && data!=null
    }
}