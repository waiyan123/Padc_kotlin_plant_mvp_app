package itachi_waiyan.com.padc_plant_app.network.dataagents

import itachi_waiyan.com.padc_plant_app.data.vos.PlantVO
import itachi_waiyan.com.padc_plant_app.persistence.UserEntity

interface PlantsDataAgent {


    fun getAllPlants(
        accessToken: String,
        onSuccess : (List<PlantVO>)-> Unit,
        onFailure : (String)-> Unit
    )

    fun login(
        accessToken : String,
        name : String,
        password : String,
        onSuccess : (UserEntity)-> Unit,
        onFailure: (String) -> Unit
    )
}