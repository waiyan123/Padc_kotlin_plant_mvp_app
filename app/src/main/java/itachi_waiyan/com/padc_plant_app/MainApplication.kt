package itachi_waiyan.com.padc_plant_app

import android.app.Application
import itachi_waiyan.com.padc_plant_app.data.models.PlantsModelImpl

class MainApplication : Application(){

    override fun onCreate() {
        super.onCreate()
        PlantsModelImpl.initDatabase(this)
    }
}