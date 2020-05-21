package co.artist.info.model.repo

import android.app.Application
import android.os.AsyncTask
import androidx.lifecycle.LiveData
import co.artist.info.database.AppDatabase
import co.artist.info.model.ArtistiTunesResponse
import co.artist.info.model.deo.ProjectsDao


class ProjectsRepository(application: Application) {
    private val projectsDao: ProjectsDao
    var listLiveData: LiveData<List<ArtistiTunesResponse.Projects>>? = null


    init {
        val database = AppDatabase.getDatabase(application)
        projectsDao = database.projectsDao()
        listLiveData = projectsDao.getAllProjects


    }

    fun insert(word: ArtistiTunesResponse.Projects) {
        InsertAsyncTask(projectsDao).execute(word)
    }

    fun insertAll(word: List<ArtistiTunesResponse.Projects>) {
        InsertAllAsyncTask(projectsDao).execute(word)
    }



    fun deleteAll() {
        DeleteAsyncTask(projectsDao).execute()
    }

    private class InsertAsyncTask internal constructor(private val mAsyncTaskDao: ProjectsDao) :
        AsyncTask<ArtistiTunesResponse.Projects, Void, Void>() {

        override fun doInBackground(vararg params: ArtistiTunesResponse.Projects): Void? {
            mAsyncTaskDao.insert(params[0])
            return null
        }
    }

    private class InsertAllAsyncTask internal constructor(private val mAsyncTaskDao: ProjectsDao) :
        AsyncTask<List<ArtistiTunesResponse.Projects>, Void, Void>() {

        override fun doInBackground(vararg params: List<ArtistiTunesResponse.Projects>): Void? {
            mAsyncTaskDao.insert(params[0])
            return null
        }
    }

    private class DeleteAsyncTask internal constructor(private val mAsyncTaskDao: ProjectsDao) :
        AsyncTask<ArtistiTunesResponse.Projects, Void, Void>() {

        override fun doInBackground(vararg params: ArtistiTunesResponse.Projects): Void? {
            mAsyncTaskDao.deleteAll()
            return null
        }
    }


}


