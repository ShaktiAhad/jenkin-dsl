folders.each{tech, projects ->
    folder("${tech}")
    for (each_project in projects){
        projectFolder = "${tech}/${each_project}"
        folder("${projectFolder}")
    }
}