package itachi_waiyan.com.padc_plant_app.mvp.presenters

import itachi_waiyan.com.padc_plant_app.data.models.PlantsModelImpl
import itachi_waiyan.com.padc_plant_app.delegates.PlantsItemDelegate
import itachi_waiyan.com.padc_plant_app.mvp.views.PlantsListView

class PlantsListPresenter : BasePresenter<PlantsListView>(),PlantsItemDelegate{
    override fun onTabItem(id: String) {
        mView.navigateToDetail(id)
    }

    override fun onCreate(){
        val model = PlantsModelImpl

        model.getAllPlants("",
            {
                mView.displayPlantsList(it)
            },
            {
                mView.displayError(it)
            })
    }

    override fun onStart() {

    }

    override fun onResume() {

    }

    override fun onPause() {

    }

    override fun onStop() {

    }

    override fun onDestroy() {

    }
}