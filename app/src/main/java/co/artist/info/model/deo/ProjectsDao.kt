package co.artist.info.model.deo

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import co.artist.info.model.ArtistiTunesResponse


@Dao
interface ProjectsDao {
    @get:Query("SELECT * from project")
    val getAllProjects: LiveData<List<ArtistiTunesResponse.Projects>>

    @Insert
    fun insert(projects: ArtistiTunesResponse.Projects)

    @Insert
    fun insert(projects: List<ArtistiTunesResponse.Projects>)

    @Query("DELETE FROM project")
    fun deleteAll()


}
