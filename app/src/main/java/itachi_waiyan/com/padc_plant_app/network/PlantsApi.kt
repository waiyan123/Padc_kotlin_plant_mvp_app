package itachi_waiyan.com.padc_plant_app.network

import itachi_waiyan.com.padc_plant_app.network.responses.GetAllPlantsResponse
import itachi_waiyan.com.padc_plant_app.utils.GET_PLANTS
import itachi_waiyan.com.padc_plant_app.utils.PARAM_ACCESS_TOKEN
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface PlantsApi {

    @POST(GET_PLANTS)
    @FormUrlEncoded
    fun getAllPlants(@Field(PARAM_ACCESS_TOKEN)accessToken : String) : Call<GetAllPlantsResponse>
}