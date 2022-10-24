// @Grab('org.yaml:snakeyaml:1.33')
// import org.yaml.snakeyaml.Yaml

// workspace = "${WORKSPACE}"
// def contentt = new Yaml().load(("${workspace}/projects.yaml" as File).text)

def d(content){
    contentt = content
}

contentt.each{tech, projects ->
    folder("${tech}")
    for (each_project in projects){
        projectFolder = "${tech}/${each_project}"
        folder("${projectFolder}")
        // def f = load ("${workspace}/pipelineCreator.groovy")
        // f(workspace, each_project)
    }
}