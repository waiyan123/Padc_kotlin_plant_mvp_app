package itachi_waiyan.com.padc_plant_app.persistence.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import itachi_waiyan.com.padc_plant_app.data.vos.PlantVO

@Dao
abstract class PlantsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertMovies(movies:MutableList<PlantVO>) : LongArray

    @Query("select * from plant_table")
    abstract fun getAllMovies():MutableList<PlantVO>

    @Query("select * from plant_table where plant_id=:id")
    abstract fun getMovieById(id:Int): PlantVO

    fun MoviesInDbExist():Boolean {
        return getAllMovies().isNotEmpty()
    }
}