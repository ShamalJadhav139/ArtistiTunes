package co.artist.info.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import co.artist.info.model.ArtistiTunesResponse
import co.artist.info.model.repo.ProjectsRepository



class ProjectsViewModel(application: Application) :
    AndroidViewModel(application) {
    private val mRepository: ProjectsRepository = ProjectsRepository(application)
    internal val allWords: LiveData<List<ArtistiTunesResponse.Projects>>

    init {
        allWords = mRepository.listLiveData!!
    }

    internal fun insert(word: ArtistiTunesResponse.Projects) {
        mRepository.insert(word)
    }

    internal fun insertAll(word: List<ArtistiTunesResponse.Projects>) {
        mRepository.insertAll(word)
    }

    internal fun deleteAll() {
        mRepository.deleteAll()
    }

}
