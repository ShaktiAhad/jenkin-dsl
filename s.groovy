// This file is for testing purpose only.

// // Create a plugin.groovy file and copy/paste following
// def plugins = jenkins.model.Jenkins.instance.getPluginManager().getPlugins()
// plugins.each {println "${it.getShortName()}: ${it.getVersion()}"}

// // execute command from CLI
// curl '<ip>:<port>/jnlpJars/jenkins-cli.jar' > jenkins-cli.jar
// java -jar jenkins-cli.jar -s http://<ip>:<port> -auth <user_name>:<password> groovy = < plugin.groovy > plugins.txt


// @Grab('org.yaml:snakeyaml:1.33')
// import org.yaml.snakeyaml.Yaml
// def content = new Yaml().load(("${workspace}/projects/${project_name}/config.yaml" as File).text)
// config = content["conf"]

// GroovyShell shell = new GroovyShell()
// def greetings = shell.parse(new File('greeting.groovy'))

// println(greetings.greeting('Shakti'))

// import groovy.yaml.YamlSlurper
// filename = "config.yaml"
// content = new YamlSlurper().parse(new File("projects/a/config.yaml"))
// pipeline_data = content["conf"]
// // https://stackoverflow.com/questions/46781417/how-to-update-a-key-value-in-json-dynamically


// import groovy.json.*
// d = '[{"ParameterValue":"test", "ParameterKey":"Environment"}, {"ParameterValue":"zcbscnbvdbscvb", "ParameterKey":"BucketPrefix"}]'
// def cfStackParams = new JsonSlurperClassic().parseText(d)
// def updateBranchValue = cfStackParams.find {it.'ParameterKey' == "BucketPrefix"}
// updateBranchValue.'ParameterValue' = "accord"
// println new JsonBuilder(cfStackParams).toPrettyString()
// println(d)

def d(name="shakti"){
    println ("hello ${name}")
}
d("ahad")