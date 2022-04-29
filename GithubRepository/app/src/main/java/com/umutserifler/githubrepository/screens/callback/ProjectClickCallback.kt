package com.umutserifler.githubrepository.screens.callback

import com.umutserifler.githubrepository.service.models.Project

/**
 * @link onClick(Project project) Get Detail Screen
 */
interface ProjectClickCallback {
    fun onClick(project: Project)
}