// This file is for testing purpose only.

// @Grab('org.yaml:snakeyaml:1.33')
// import org.yaml.snakeyaml.Yaml
// def content = new Yaml().load(("${workspace}/projects/${project_name}/config.yaml" as File).text)
// config = content["conf"]


import groovy.yaml.YamlSlurper
filename = "config.yaml"
content = new YamlSlurper().parse(new File("projects/a/config.yaml"))
pipeline_data = content["conf"]

// load_paramfile = new File("ss.groovy")

// println (load_paramfile.execute ("hello"))

GroovyShell sdsd = new GroovyShell()
def greetings = sdsd.parse(new File('ss.groovy'))

println(greetings.sd('Shakti'))