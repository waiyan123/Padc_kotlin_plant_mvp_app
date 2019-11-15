package itachi_waiyan.com.padc_plant_app.activities

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.View
import android.view.animation.AccelerateDecelerateInterpolator
import android.view.animation.BounceInterpolator
import android.view.animation.OvershootInterpolator
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityOptionsCompat
import itachi_waiyan.com.padc_plant_app.R
import itachi_waiyan.com.padc_plant_app.data.models.PlantsModelImpl
import itachi_waiyan.com.padc_plant_app.mvp.presenters.LoginPresenter
import itachi_waiyan.com.padc_plant_app.mvp.views.LoginView
import itachi_waiyan.com.padc_plant_app.persistence.MyDatabase
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

        animatorForTitle().start()

    }

    fun animatorForTitle() : ObjectAnimator {
        layout_title.visibility = View.VISIBLE
        val animator = ObjectAnimator.ofFloat(
            layout_title,
            View.ALPHA,
            0f,
            1f
        )
        animator.addListener(object : AnimatorListenerAdapter(){
            override fun onAnimationEnd(animation: Animator?) {
                animatorForUserInfo().start()
            }
        })
        animator.interpolator = AccelerateDecelerateInterpolator()
        animator.duration = 6000
        return animator
    }

    fun animatorForUserInfo() : ObjectAnimator {
        layout_user_info.visibility = View.VISIBLE
        val animator = ObjectAnimator.ofFloat(
            layout_user_info,
            View.TRANSLATION_X,
            800f,
            layout_user_info.width.toFloat()
        )
        animator.addListener(object : AnimatorListenerAdapter(){
            override fun onAnimationEnd(animation: Animator?) {
                animatorForLoginButton().start()
            }
        })
        animator.interpolator = BounceInterpolator()
        animator.duration = 3000
        return animator
    }

    fun animatorForLoginButton() : ObjectAnimator{
        login_layout.visibility = View.VISIBLE
        val animator = ObjectAnimator.ofFloat(
            login_layout,
            View.TRANSLATION_X,
            -800f,
            login_layout.width.toFloat()
        )
        animator.interpolator = OvershootInterpolator()
        animator.duration = 2000
        return animator
    }

    override fun navigateToMainActivity() {
        startActivity(MainActivity.newIntent(this),ActivityOptionsCompat.makeSceneTransitionAnimation(this).toBundle())
        finish()
    }

    override fun errorMessage(error: String) {
        Toast.makeText(this,error,Toast.LENGTH_SHORT).show()
    }
}