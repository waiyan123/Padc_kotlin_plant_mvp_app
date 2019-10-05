package itachi_waiyan.com.padc_plant_app.persistence.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import itachi_waiyan.com.padc_plant_app.data.vos.PlantVO
import itachi_waiyan.com.padc_plant_app.persistence.UserEntity

@Dao
abstract class PlantsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertMovies(movies:MutableList<PlantVO>) : LongArray

    @Query("select * from plant_table")
    abstract fun getAllPlants():MutableList<PlantVO>

    @Query("select * from plant_table where plant_id=:id")
    abstract fun getPlantById(id:String): PlantVO

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertUser(user:UserEntity)

    @Query("select * from user_table")
    abstract fun getUser():UserEntity

    fun MoviesInDbExist():Boolean {
        return getAllPlants().isNotEmpty()
    }

}