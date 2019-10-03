package itachi_waiyan.com.padc_plant_app.data.models

import android.content.Context
import itachi_waiyan.com.padc_plant_app.network.dataagents.PlantsDataAgent
import itachi_waiyan.com.padc_plant_app.network.dataagents.PlantsDataAgentImpl
import itachi_waiyan.com.padc_plant_app.persistence.MyDatabase

abstract class BaseModel {
    val dataAgent : PlantsDataAgent = PlantsDataAgentImpl
    lateinit var database : MyDatabase

    fun initDatabase(context : Context){
        database = MyDatabase.getInstance(context)
    }
}