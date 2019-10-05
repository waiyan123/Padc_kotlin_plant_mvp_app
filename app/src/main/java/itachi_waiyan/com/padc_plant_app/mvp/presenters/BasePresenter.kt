package itachi_waiyan.com.padc_plant_app.mvp.presenters

import itachi_waiyan.com.padc_plant_app.mvp.views.BaseView

abstract class BasePresenter <T:BaseView> {


    protected lateinit var mView : T

    open fun initPresenter(view : T){
        this.mView = view
    }
    open fun onCreate(){

    }

    open fun onStart(){

    }

    open fun onPause(){

    }

    open fun onResume(){

    }

    open fun onStop(){

    }

    open fun onDestroy(){

    }

}