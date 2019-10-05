package itachi_waiyan.com.padc_plant_app.data.models

import itachi_waiyan.com.padc_plant_app.data.vos.PlantVO
import itachi_waiyan.com.padc_plant_app.network.dataagents.PlantsDataAgent
import itachi_waiyan.com.padc_plant_app.network.dataagents.PlantsDataAgentImpl
import itachi_waiyan.com.padc_plant_app.persistence.UserEntity
import itachi_waiyan.com.padc_plant_app.utils.DUMMY_ACCESS_TOKEN

object PlantsModelImpl : PlantsModel,BaseModel(){
    override fun getPlantById(id: String): PlantVO {
        val plantVOFromDb = database.plantsDao().getPlantById(id)
        return plantVOFromDb
    }


    override fun getAllPlants(accessToken: String,onSuccess: (List<PlantVO>) -> Unit, onFailure: (String) -> Unit) {
        val plantsFromDb = database.plantsDao().getAllPlants()
        if(plantsFromDb.isNotEmpty()){
            onSuccess(plantsFromDb)
        }
        else {
            dataAgent.getAllPlants(DUMMY_ACCESS_TOKEN,
                {
                    onSuccess(it)
                    database.plantsDao().insertMovies(it.toMutableList())
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

    override fun login(
        accessToken: String,
        name:String,
        password:String,
        onSuccess: (UserEntity) -> Unit,
        onFailure: (String) -> Unit
    ) {
        val userFromDb = database.plantsDao().getUser()
        if(userFromDb!=null){
            onSuccess(userFromDb)
        }
        else {
            dataAgent.login(DUMMY_ACCESS_TOKEN,
                name,
                password,
                {
                    onSuccess(it)
                    database.plantsDao().insertUser(it)
                },{
                    onFailure(it)
                })
        }
        dataAgent.login(
            DUMMY_ACCESS_TOKEN,
            name,
            password,
            onSuccess,
            onFailure
        )
    }

    override fun alreadyLogin(): UserEntity? {
        val userFromDb = database.plantsDao().getUser()
        if(userFromDb!=null) return userFromDb
        return null
    }


}