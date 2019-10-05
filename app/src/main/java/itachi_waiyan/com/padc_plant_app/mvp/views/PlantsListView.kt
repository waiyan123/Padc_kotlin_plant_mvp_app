package itachi_waiyan.com.padc_plant_app.mvp.views

import itachi_waiyan.com.padc_plant_app.data.vos.PlantVO

interface PlantsListView : BaseView{

    fun displayPlantsList(list:List<PlantVO>)

    fun displayError (error:String)

    fun navigateToDetail(plantId:String)
}