package com.umutserifler.githubrepository.screens.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.Observer

import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.umutserifler.githubrepository.R
import com.umutserifler.githubrepository.databinding.FragmentProjectListBinding
import com.umutserifler.githubrepository.screens.adapter.ProjectAdapter
import com.umutserifler.githubrepository.screens.callback.ProjectClickCallback
import com.umutserifler.githubrepository.service.models.Project
import com.umutserifler.githubrepository.viewModel.ProjectListViewModel


const val TAG_OF_PROJECT_LIST_FRAGMENT = "ProjectListFragment"

class ProjectListFragment : Fragment() {

    private val viewModel by lazy {
        ViewModelProvider(this).get(ProjectListViewModel::class.java)
    }

    private lateinit var binding: FragmentProjectListBinding
    private val projectAdapter: ProjectAdapter = ProjectAdapter(object : ProjectClickCallback {
        override fun onClick(project: Project) {
            if (lifecycle.currentState.isAtLeast(Lifecycle.State.STARTED) && activity is MainActivity) {
                (activity as MainActivity).show(project)
            }
        }
    })

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_project_list, container, false) //dataBinding
        binding.apply {
            projectList.adapter = projectAdapter
            isLoading = true
        }
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel.projectListLiveData.observe(viewLifecycleOwner, Observer { projects ->
            projects?.let {
                binding.isLoading = false
                projectAdapter.setProjectList(it)
            }
        })
    }
}
