package itachi_waiyan.com.padc_plant_app.activities

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.ObjectAnimator
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.transition.Fade
import android.transition.Transition
import android.transition.TransitionListenerAdapter
import android.util.Log
import android.view.View
import android.view.Window
import android.view.animation.AccelerateDecelerateInterpolator
import android.view.animation.BounceInterpolator
import android.widget.ImageView
import android.widget.Toast
import androidx.core.app.ActivityOptionsCompat
import androidx.core.util.Pair
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import itachi_waiyan.com.padc_plant_app.R
import itachi_waiyan.com.padc_plant_app.adapters.PlantListRecyclerAdapter
import itachi_waiyan.com.padc_plant_app.data.models.PlantsModel
import itachi_waiyan.com.padc_plant_app.data.models.PlantsModelImpl
import itachi_waiyan.com.padc_plant_app.data.vos.PlantVO
import itachi_waiyan.com.padc_plant_app.delegates.PlantsItemDelegate
import itachi_waiyan.com.padc_plant_app.mvp.presenters.PlantsListPresenter
import itachi_waiyan.com.padc_plant_app.mvp.views.PlantsListView
import itachi_waiyan.com.padc_plant_app.persistence.MyDatabase
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),PlantsListView {

    private lateinit var mPresenter : PlantsListPresenter

    lateinit var plantListAdapter : PlantListRecyclerAdapter
    val model: PlantsModel = PlantsModelImpl

    companion object{
        const val EXTRA_EVENT_ID = "Extra_to_extra"
        fun newIntent(context: Context ): Intent{
            return Intent(context,MainActivity::class.java).apply {

            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setUpTransition()
        setContentView(R.layout.activity_main)

        mPresenter = PlantsListPresenter()
        mPresenter.initPresenter(this)

        rv_plants_list.setHasFixedSize(true)
        rv_plants_list.layoutManager = LinearLayoutManager(this)
        plantListAdapter = PlantListRecyclerAdapter(mPresenter)
        rv_plants_list.adapter = plantListAdapter

        mPresenter.onCreate()
    }


    fun setUpTransition(){
        with(window) {
            requestFeature(Window.FEATURE_CONTENT_TRANSITIONS)
            val fade = Fade()
            fade.duration = 5000
            enterTransition = fade
            exitTransition = fade

            fade.addListener(object : TransitionListenerAdapter(){
                override fun onTransitionEnd(transition: Transition?) {
                    setUpAnimation().start()
                }
            })

        }
    }

        fun setUpAnimation() : ObjectAnimator{
            rv_plants_list.visibility = View.VISIBLE
            val animator = ObjectAnimator.ofFloat(
                rv_plants_list,
                View.TRANSLATION_X,
                800f,
                rv_plants_list.width.toFloat()
            )
            animator.interpolator = AccelerateDecelerateInterpolator()
            animator.duration = 3000
            return animator
        }


    override fun onStart() {
        super.onStart()
        mPresenter.onStart()
    }

    override fun onPause() {
        super.onPause()
        mPresenter.onPause()
    }

    override fun onStop() {
        super.onStop()
        mPresenter.onStop()
    }

    override fun onResume() {
        super.onResume()
        mPresenter.onResume()
    }

    override fun onDestroy() {
        super.onDestroy()
        mPresenter.onDestroy()
    }

    override fun displayPlantsList(list: List<PlantVO>) {
        plantListAdapter.setNewData(list)
    }

    override fun displayError(error: String) {
        Toast.makeText(this,error,Toast.LENGTH_SHORT).show()
    }

    override fun navigateToDetail(plantId: String,imgView: ImageView) {
        Toast.makeText(this,"Someone clicked me",Toast.LENGTH_SHORT).show()

        val imagePair = Pair.create(imgView as View, "img_plant")
        val options = ActivityOptionsCompat.makeSceneTransitionAnimation(this,imagePair)
        startActivity(DetailsActivity.newIntent(this,plantId),options.toBundle())
    }
}
