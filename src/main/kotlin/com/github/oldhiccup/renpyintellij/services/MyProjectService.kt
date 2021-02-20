package com.github.oldhiccup.renpyintellij.services

import com.github.oldhiccup.renpyintellij.MyBundle
import com.intellij.openapi.project.Project

class MyProjectService(project: Project) {

    init {
        println(MyBundle.message("projectService", project.name))
    }
}
