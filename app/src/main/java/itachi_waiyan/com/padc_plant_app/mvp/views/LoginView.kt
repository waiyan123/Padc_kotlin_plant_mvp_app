package itachi_waiyan.com.padc_plant_app.mvp.views

interface LoginView :BaseView{
    fun navigateToMainActivity()

    fun errorMessage(error:String)

}