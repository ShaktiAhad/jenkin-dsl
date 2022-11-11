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

import groovy.json.*
d = '[{"ParameterValue":"test", "ParameterKey":"Environment"}, {"ParameterValue":"zcbscnbvdbscvb", "ParameterKey":"BucketPrefix"}]'
def cfStackParams = new JsonSlurper().parseText(d)
def updateBranchValue = cfStackParams.find {it.'ParameterKey' == "BucketPrefix"}
updateBranchValue.'ParameterValue' = "accord"
println new JsonBuilder(cfStackParams).toPrettyString()