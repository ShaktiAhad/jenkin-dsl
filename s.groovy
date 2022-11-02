// This file is for testing purpose only.

// @Grab('org.yaml:snakeyaml:1.33')
// import org.yaml.snakeyaml.Yaml
// def content = new Yaml().load(("${workspace}/projects/${project_name}/config.yaml" as File).text)
// config = content["conf"]

// GroovyShell shell = new GroovyShell()
// def greetings = shell.parse(new File('greeting.groovy'))

// println(greetings.greeting('Shakti'))

import groovy.yaml.YamlSlurper
filename = "config.yaml"
content = new YamlSlurper().parse(new File("projects/a/config.yaml"))
pipeline_data = content["conf"]


pipeline_data.each{key, value ->
    value.each{pipeline_name, pipeline_val -> 
        if(pipeline_val.inputParams){
            println(pipeline_val.inputParams)
            pipeline_val.inputParams.each {param_type, param_detail -> 
                println(param_type)
                println(param_detail)
                // parameters{
                //     println()
                //     if (param_type == "string"){
                //         param_detail.each{str_key, str_val -> 
                //             stringParam(str_key, str_val.defaultValue, str_val.description)
                //         }
                //     }
                //     else if (param_type == "choice"){
                //         param_detail.each{ch_key, ch_val ->
                //             choiceParam(ch_key, ch_val.choices, ch_val.description)
                //         } 
                //     }
                // }
            } 
        }
    }
}