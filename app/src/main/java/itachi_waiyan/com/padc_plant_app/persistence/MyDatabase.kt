package itachi_waiyan.com.padc_plant_app.persistence

import android.content.Context
import androidx.room.*
import itachi_waiyan.com.padc_plant_app.data.vos.PlantVO
import itachi_waiyan.com.padc_plant_app.persistence.daos.PlantsDao
import itachi_waiyan.com.padc_plant_app.persistence.typeconverters.PlantTypeConverter
import itachi_waiyan.com.padc_plant_app.persistence.typeconverters.TipsConverter
import itachi_waiyan.com.padc_plant_app.persistence.typeconverters.UploadedUserConverter

@Database(entities = arrayOf(PlantVO::class),version = 1,exportSchema = false)
@TypeConverters(TipsConverter::class,UploadedUserConverter::class,PlantTypeConverter::class)
abstract class MyDatabase : RoomDatabase(){

    abstract fun plantsDao() : PlantsDao

    companion object {
        private var instance : MyDatabase?=null
        fun getInstance(context: Context):MyDatabase{
            if(instance==null){
                instance = Room.databaseBuilder(context,MyDatabase::class.java,"MyDatabase")
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build()
            }
            val db = instance!!
            return db
        }
    }

}