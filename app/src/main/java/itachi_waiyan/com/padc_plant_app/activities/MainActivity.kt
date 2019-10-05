package itachi_waiyan.com.padc_plant_app.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
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
        setContentView(R.layout.activity_main)

        mPresenter = PlantsListPresenter()
        mPresenter.initPresenter(this)

        rv_plants_list.setHasFixedSize(true)
        rv_plants_list.layoutManager = LinearLayoutManager(this)
        plantListAdapter = PlantListRecyclerAdapter(mPresenter)
        rv_plants_list.adapter = plantListAdapter

        mPresenter.onCreate()
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

    override fun navigateToDetail(plantId: String) {
        Toast.makeText(this,"Someone clicked me",Toast.LENGTH_SHORT).show()

        startActivity(DetailsActivity.newIntent(this,plantId))
    }
}
