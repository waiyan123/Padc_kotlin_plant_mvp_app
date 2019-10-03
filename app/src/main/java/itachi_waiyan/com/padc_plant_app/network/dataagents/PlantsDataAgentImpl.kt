package itachi_waiyan.com.padc_plant_app.network.dataagents

import itachi_waiyan.com.padc_plant_app.data.vos.PlantVO
import itachi_waiyan.com.padc_plant_app.network.PlantsApi
import itachi_waiyan.com.padc_plant_app.network.responses.GetAllPlantsResponse
import itachi_waiyan.com.padc_plant_app.utils.BASE_URL
import itachi_waiyan.com.padc_plant_app.utils.EM_NULL_EVENT_RESPONSE
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object PlantsDataAgentImpl :PlantsDataAgent {

    private val plantsApi : PlantsApi
    init {

        val okHttpClient = OkHttpClient.Builder()
            .connectTimeout(15,TimeUnit.SECONDS)
            .readTimeout(15,TimeUnit.SECONDS)
            .writeTimeout(15,TimeUnit.SECONDS)
            .build()

        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .baseUrl(BASE_URL)
            .build()

        plantsApi = retrofit.create(PlantsApi::class.java)
    }

    override fun getAllPlants(accessToken: String,onSuccess: (List<PlantVO>) -> Unit, onFailure: (String) -> Unit) {

        val call = plantsApi.getAllPlants(accessToken)
        call.enqueue(object : Callback<GetAllPlantsResponse>{
            override fun onFailure(call: Call<GetAllPlantsResponse>, t: Throwable) {
                onFailure(t.localizedMessage)
            }

            override fun onResponse(
                call: Call<GetAllPlantsResponse>,
                response: Response<GetAllPlantsResponse>
            ) {
                val mResponse = response.body()
                if (mResponse != null) {
                    if(mResponse.data!=null){
                        onSuccess(mResponse.data)
                    }
                    else onFailure(mResponse.message)
                }
                else onFailure(EM_NULL_EVENT_RESPONSE)
            }

        })
    }

}