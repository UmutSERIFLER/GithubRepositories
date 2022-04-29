package com.umutserifler.githubrepository.service.repository

import com.umutserifler.githubrepository.service.models.Project

import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val HTTPS_API_GITHUB_URL = "https://api.github.com/"

/**
 * Data provider for ViewModel
 */
class ProjectRepository {

    //https://medium.com/swlh/kotlin-basics-of-companion-objects-a8422c96779b
    companion object Factory {
        val instance: ProjectRepository
            @Synchronized get() {
                return ProjectRepository()
            }
    }

    private val retrofit = Retrofit.Builder()
        .baseUrl(HTTPS_API_GITHUB_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val githubService: GithubService = retrofit.create(GithubService::class.java)

    /*
    * Suspending functions are at the center of everything coroutines.
    * A suspending function is simply a function that can be paused and resumed at a later time.
    * They can execute a long running operation and wait for it to complete without blocking.
    * https://stackoverflow.com/a/52925057
    * */
    suspend fun getProjectList(userId: String): Response<List<Project>> =
        githubService.getProjectList(userId)

    suspend fun getProjectDetails(userID: String, projectName: String): Response<Project> =
        githubService.getProjectDetails(userID, projectName)
}
