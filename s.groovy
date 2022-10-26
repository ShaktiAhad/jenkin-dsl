// This file is for testing purpose only.

// @Grab('org.yaml:snakeyaml:1.33')
// import org.yaml.snakeyaml.Yaml
// def content = new Yaml().load(("${workspace}/projects/${project_name}/config.yaml" as File).text)
// config = content["conf"]


import groovy.yaml.YamlSlurper
filename = "config.yaml"
content = new YamlSlurper().parse(new File("projects/a/config.yaml"))
pipeline_data = content["conf"]


// GroovyShell shell = new GroovyShell()
// def greetings = shell.parse(new File('greeting.groovy'))

// println(greetings.greeting('Shakti'))

params=[:]
pipeline_data.each{key, value ->
    value.each{pipeline_name, pipeline_val ->
        params[pipeline_name] = [:]
        if (pipeline_name != "common" && pipeline_name == "awsCodePipeline"){
            params[pipeline_name].codeCommitRepo = pipeline_val.get("codeCommitRepo", "empty")
            params[pipeline_name].cfStack = pipeline_val.get("cfStack", "empty")
            params[pipeline_name].codePipeline = pipeline_val.get("codePipeline", "empty")
            params[pipeline_name].region = pipeline_val.get("region", "empty")
        }
        else if (pipeline_name == "common"){
            params[pipeline_name].gitUrl = pipeline_val.get("gitUrl", "empty")
            params[pipeline_name].branch = pipeline_val.get("branch", "empty")
            params[pipeline_name].cred = pipeline_val.get("cred", "empty")
        }
    }
} 
println(params)