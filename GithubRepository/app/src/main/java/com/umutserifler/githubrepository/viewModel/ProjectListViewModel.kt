package com.umutserifler.githubrepository.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.umutserifler.githubrepository.service.models.Project
import com.umutserifler.githubrepository.service.repository.ProjectRepository
import java.lang.Exception

import androidx.lifecycle.viewModelScope

import com.umutserifler.githubrepository.R
import kotlinx.coroutines.launch

class ProjectListViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = ProjectRepository.instance
    var projectListLiveData: MutableLiveData<List<Project>> = MutableLiveData()

    init {
        loadProjectList()
    }

    private fun loadProjectList() = viewModelScope.launch { //onCleared()
        try {
            val response = repository.getProjectList(getApplication<Application>().getString(R.string.github_user_name))
            if (response.isSuccessful) {
                projectListLiveData.postValue(response.body()) //Get data once、LiveData Update
            }
        } catch (e: Exception) {
            e.stackTrace
        }
    }
}
