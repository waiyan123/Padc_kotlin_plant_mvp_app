package itachi_waiyan.com.padc_plant_app.activities

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import itachi_waiyan.com.padc_plant_app.R
import itachi_waiyan.com.padc_plant_app.data.models.PlantsModelImpl
import itachi_waiyan.com.padc_plant_app.mvp.presenters.LoginPresenter
import itachi_waiyan.com.padc_plant_app.mvp.views.LoginView
import itachi_waiyan.com.padc_plant_app.persistence.MyDatabase
import itachi_waiyan.com.padc_plant_app.persistence.MyDatabase_Impl
import itachi_waiyan.com.padc_plant_app.persistence.UserEntity
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(),LoginView{

    lateinit var user:UserEntity
    lateinit var model:PlantsModelImpl
    lateinit var mPresenter : LoginPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        model = PlantsModelImpl
        mPresenter = LoginPresenter()
        mPresenter.initPresenter(this)
        mPresenter.onCreate()


        login_layout.setOnClickListener {
            var name = et_name.text.toString()
            var password = et_password.text.toString()
            if(name!="" && password!=""){
                mPresenter.login(name,password)
            }

        }
    }

    override fun navigateToMainActivity() {
        startActivity(MainActivity.newIntent(this))
        finish()
    }

    override fun errorMessage(error: String) {
        Toast.makeText(this,error,Toast.LENGTH_SHORT).show()
    }
}