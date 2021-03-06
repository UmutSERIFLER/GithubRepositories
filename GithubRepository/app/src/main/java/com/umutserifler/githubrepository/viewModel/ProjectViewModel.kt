package com.umutserifler.githubrepository.viewModel

import android.app.Application
import android.util.Log
import androidx.databinding.ObservableField
import androidx.lifecycle.*
import com.umutserifler.githubrepository.service.models.Project
import com.umutserifler.githubrepository.service.repository.ProjectRepository
import kotlinx.coroutines.launch
import com.umutserifler.githubrepository.R

class ProjectViewModel(
    private val myApplication: Application,
    private val mProjectID: String
) : AndroidViewModel(myApplication) {

    private val repository = ProjectRepository.instance
    val projectLiveData: MutableLiveData<Project> = MutableLiveData()

    var project = ObservableField<Project>()

    init {
        loadProject()
    }

    private fun loadProject() = viewModelScope.launch { //onCleared()
        try {
            val project = repository.getProjectDetails(myApplication.getString(R.string.github_user_name), mProjectID)
            if (project.isSuccessful) {
                projectLiveData.postValue(project.body())
            }
        } catch (e: Exception) {
            Log.e("loadProject:Failed", e.stackTrace.toString())
        }
    }


    fun setProject(project: Project) {
        this.project.set(project)
    }

    class Factory(private val application: Application, private val projectID: String) : ViewModelProvider.NewInstanceFactory() {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return ProjectViewModel(application, projectID) as T
        }
    }
}
