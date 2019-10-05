package itachi_waiyan.com.padc_plant_app.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import itachi_waiyan.com.padc_plant_app.R
import itachi_waiyan.com.padc_plant_app.data.models.PlantsModel
import itachi_waiyan.com.padc_plant_app.data.models.PlantsModelImpl

class MainActivity : AppCompatActivity() {

    val model: PlantsModel = PlantsModelImpl
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        model.getAllPlants("",
            {
                Log.d("test---", it[0].plant_photo)
                Log.d("test---","size "+it.size)
                Toast.makeText(this, it[0].plant_photo, Toast.LENGTH_SHORT).show()
            }, {
                Log.d("test---", it)
                Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
            })
    }
}
