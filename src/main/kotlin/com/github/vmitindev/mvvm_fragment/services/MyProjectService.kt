package com.github.vmitindev.mvvm_fragment.services

import com.intellij.openapi.project.Project
import com.github.vmitindev.mvvm_fragment.MyBundle

class MyProjectService(project: Project) {

    init {
        println(MyBundle.message("projectService", project.name))
    }
}
