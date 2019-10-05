package itachi_waiyan.com.padc_plant_app.mvp.presenters

import itachi_waiyan.com.padc_plant_app.data.models.PlantsModelImpl
import itachi_waiyan.com.padc_plant_app.data.vos.PlantVO
import itachi_waiyan.com.padc_plant_app.mvp.views.PlantDetailView

class PlantDetailPresenter : BasePresenter<PlantDetailView>(){

    fun onUiReady(id: String){
        if(id!=null){
            val model = PlantsModelImpl
            val plantVO : PlantVO = model.getPlantById(id)
            val plantList : List<PlantVO> = model.database.plantsDao().getAllPlants()
            mView.getAllPlants(plantList)
            mView.displayPlantDetail(plantVO)
        }
    }

    override fun onCreate(){

    }

    override fun onStart(){

    }

    override fun onResume(){

    }

    override fun onPause(){

    }

    override fun onStop(){

    }

    override fun onDestroy(){

    }

}