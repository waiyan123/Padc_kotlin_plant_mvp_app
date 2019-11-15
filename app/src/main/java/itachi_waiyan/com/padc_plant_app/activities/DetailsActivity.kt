package itachi_waiyan.com.padc_plant_app.activities

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.animation.AccelerateDecelerateInterpolator
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import itachi_waiyan.com.padc_plant_app.R
import itachi_waiyan.com.padc_plant_app.adapters.PlantDetailsRecyclerAdapter
import itachi_waiyan.com.padc_plant_app.data.vos.PlantVO
import itachi_waiyan.com.padc_plant_app.mvp.presenters.PlantDetailPresenter
import itachi_waiyan.com.padc_plant_app.mvp.views.PlantDetailView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_plant_details.*
import kotlinx.android.synthetic.main.activity_plant_details.img_owner
import kotlinx.android.synthetic.main.activity_plant_details.img_plant_pic
import kotlinx.android.synthetic.main.activity_plant_details.tv_plant_name
import kotlinx.android.synthetic.main.activity_plant_details.tv_plant_owner
import kotlinx.android.synthetic.main.plant_item_view.*

class DetailsActivity : AppCompatActivity(),PlantDetailView{


    lateinit var plantDetailPresenter: PlantDetailPresenter
    lateinit var plantDetailsRecyclerAdapter: PlantDetailsRecyclerAdapter
    companion object {
        const val EXTRA_EVENT_ID = "Extra_to_extra"
        fun newIntent(context : Context,id : String ) : Intent{
            return Intent(context,DetailsActivity::class.java).apply {
                putExtra(EXTRA_EVENT_ID,id)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_plant_details)
        plantDetailPresenter = PlantDetailPresenter()
        plantDetailPresenter.initPresenter(this)

        plantDetailsRecyclerAdapter = PlantDetailsRecyclerAdapter()
        rv_plant_details.setHasFixedSize(true)
        rv_plant_details.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        rv_plant_details.adapter = plantDetailsRecyclerAdapter

        img_back.setOnClickListener {
            finish()
        }
        val string = intent.getStringExtra(EXTRA_EVENT_ID)
        if(string!=null) {
            plantDetailPresenter.onUiReady(string)
        }
        plantDetailPresenter.onCreate()

        setUpAnimation().start()
    }

    fun setUpAnimation() : ObjectAnimator {
        rv_plant_details.visibility = View.VISIBLE
        val animator = ObjectAnimator.ofFloat(
            rv_plant_details,
            View.TRANSLATION_X,
            800f,
            rv_plant_details.width.toFloat()
        )
        animator.interpolator = AccelerateDecelerateInterpolator()
        animator.duration = 3000
        animator.addListener(object : AnimatorListenerAdapter(){
            override fun onAnimationEnd(animation: Animator?) {
                setUpAnimationForFavIcon()
            }
        })
        return animator
    }

    @SuppressLint("RestrictedApi")
    fun setUpAnimationForFavIcon(){
        img_float.visibility = View.VISIBLE
        val alphaAnimator = ObjectAnimator.ofFloat(
            img_float,
            View.ALPHA,
            0f,
            1f)

        val xAnimator = ObjectAnimator.ofFloat(
            img_float,
            View.SCALE_X,
            0f,
            1f
        )
        xAnimator.duration = 3000

        val yAnimator = ObjectAnimator.ofFloat(
            img_float,
            View.SCALE_Y,
            0f,
            1f
        )
        AnimatorSet().apply {
            play(alphaAnimator).with(xAnimator).with(yAnimator)
            start()
        }
    }

    override fun displayPlantDetail(plantVO: PlantVO) {
        Glide.with(this)
            .load(plantVO.plant_photo)
            .into(img_plant_pic)
        tv_plant_name.text = plantVO.plant_name
        Glide.with(this)
            .load(plantVO.uploaded_user.user_photo)
            .into(img_owner)
        tv_plant_owner.text = plantVO.uploaded_user.name
        tv_plant_details.text = plantVO.description

    }

    override fun getAllPlants(list: List<PlantVO>) {
        plantDetailsRecyclerAdapter.setNewData(list)
    }

}