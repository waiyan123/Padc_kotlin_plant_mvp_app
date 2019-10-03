package itachi_waiyan.com.padc_plant_app.data.models

import itachi_waiyan.com.padc_plant_app.data.vos.PlantVO
import itachi_waiyan.com.padc_plant_app.network.dataagents.PlantsDataAgent
import itachi_waiyan.com.padc_plant_app.network.dataagents.PlantsDataAgentImpl
import itachi_waiyan.com.padc_plant_app.utils.DUMMY_ACCESS_TOKEN

object PlantsModelImpl : PlantsModel,BaseModel(){


    override fun getAllPlants(accessToken: String,onSuccess: (List<PlantVO>) -> Unit, onFailure: (String) -> Unit) {
        val plantsFromDb = database.plantsDao().getAllMovies()
        if(plantsFromDb.isEmpty()){
            onSuccess(plantsFromDb)
        }
        else {
            dataAgent.getAllPlants(DUMMY_ACCESS_TOKEN,
                {
                    onSuccess(it)
                },{
                    onFailure(it)
                })
        }
        dataAgent.getAllPlants(
            DUMMY_ACCESS_TOKEN,
            onSuccess,
            onFailure
        )
    }


}