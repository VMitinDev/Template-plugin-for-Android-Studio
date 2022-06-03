package com.github.vmitindev.templatepluginforandroidstudio.services

import com.intellij.openapi.project.Project
import com.github.vmitindev.templatepluginforandroidstudio.MyBundle

class MyProjectService(project: Project) {

    init {
        println(MyBundle.message("projectService", project.name))
    }
}
