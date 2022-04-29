package com.umutserifler.githubrepository.service.repository

import com.umutserifler.githubrepository.service.models.Project

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface GithubService {

    //List Repos
    @GET("users/{user}/repos")
    suspend fun getProjectList(@Path("user") user: String): Response<List<Project>>

    //Detail
    @GET("/repos/{user}/{reponame}")
    suspend fun getProjectDetails(@Path("user") user: String, @Path("reponame") projectName: String): Response<Project>
}