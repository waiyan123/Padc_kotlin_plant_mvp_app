package itachi_waiyan.com.padc_plant_app.network.dataagents

import itachi_waiyan.com.padc_plant_app.data.vos.PlantVO

interface PlantsDataAgent {


    fun getAllPlants(
        accessToken: String,
        onSuccess : (List<PlantVO>)-> Unit,
        onFailure : (String)-> Unit

    )
}