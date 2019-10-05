package itachi_waiyan.com.padc_plant_app.mvp.views

import itachi_waiyan.com.padc_plant_app.data.vos.PlantVO

interface PlantDetailView : BaseView{

    fun displayPlantDetail(plantVO : PlantVO)

    fun getAllPlants(list:List<PlantVO>)
}