package itachi_waiyan.com.padc_plant_app.network

import itachi_waiyan.com.padc_plant_app.network.responses.GetAllPlantsResponse
import itachi_waiyan.com.padc_plant_app.network.responses.LoginResponse
import itachi_waiyan.com.padc_plant_app.utils.GET_PLANTS
import itachi_waiyan.com.padc_plant_app.utils.LOGIN
import itachi_waiyan.com.padc_plant_app.utils.PARAM_ACCESS_TOKEN
import retrofit2.Call
import retrofit2.http.*

interface PlantsApi {

    @POST(GET_PLANTS)
    @FormUrlEncoded
    fun getAllPlants(@Field(PARAM_ACCESS_TOKEN)accessToken : String) : Call<GetAllPlantsResponse>

    @POST(LOGIN)
    @FormUrlEncoded
    fun login(@Field(PARAM_ACCESS_TOKEN)accessToken: String, @Field ("email") email :String, @Field ("password") password : String) : Call<LoginResponse>

}