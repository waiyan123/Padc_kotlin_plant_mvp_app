package itachi_waiyan.com.padc_plant_app.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import itachi_waiyan.com.padc_plant_app.R
import itachi_waiyan.com.padc_plant_app.adapters.PlantDetailsRecyclerAdapter
import itachi_waiyan.com.padc_plant_app.data.vos.PlantVO
import itachi_waiyan.com.padc_plant_app.mvp.presenters.PlantDetailPresenter
import itachi_waiyan.com.padc_plant_app.mvp.views.PlantDetailView
import kotlinx.android.synthetic.main.activity_plant_details.*

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