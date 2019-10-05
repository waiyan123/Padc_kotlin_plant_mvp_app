package itachi_waiyan.com.padc_plant_app.mvp.presenters

import itachi_waiyan.com.padc_plant_app.data.models.PlantsModel
import itachi_waiyan.com.padc_plant_app.data.models.PlantsModelImpl
import itachi_waiyan.com.padc_plant_app.delegates.PlantsItemDelegate
import itachi_waiyan.com.padc_plant_app.mvp.views.LoginView
import itachi_waiyan.com.padc_plant_app.persistence.UserEntity

class LoginPresenter : BasePresenter<LoginView>(){

    override fun onCreate(){
        var user = PlantsModelImpl.alreadyLogin()
        if (user != null) {
            mView.navigateToMainActivity()
        }
    }
    fun login(name:String , password:String){
        PlantsModelImpl.login("",
            name,
            password,{
                mView.navigateToMainActivity()
            },
            {
                mView.errorMessage(it)
            })
    }
}