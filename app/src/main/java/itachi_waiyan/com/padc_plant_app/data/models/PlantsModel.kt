package itachi_waiyan.com.padc_plant_app.data.models

import itachi_waiyan.com.padc_plant_app.data.vos.PlantVO

interface PlantsModel {

    fun getAllPlants(
        accessToken: String,
        onSuccess : (List<PlantVO>)-> Unit,
        onFailure : (String)-> Unit
    )

}