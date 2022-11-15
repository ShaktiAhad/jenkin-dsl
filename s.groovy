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
// https://stackoverflow.com/questions/46781417/how-to-update-a-key-value-in-json-dynamically


import groovy.json.*
d = '[{"ParameterValue":"test", "ParameterKey":"Environment"}, {"ParameterValue":"zcbscnbvdbscvb", "ParameterKey":"BucketPrefix"}]'
def cfStackParams = new JsonSlurperClassic().parseText(d)
def updateBranchValue = cfStackParams.find {it.'ParameterKey' == "BucketPrefix"}
updateBranchValue.'ParameterValue' = "accord"
println new JsonBuilder(cfStackParams).toPrettyString()
println(d)



import groovy.json.JsonSlurperClassic
import groovy.json.JsonBuilder
node('master'){
    properties([
        buildDiscarder(logRotator(daysToKeepStr: '3', numToKeepStr: '3')),
        parameters([
            string(
                name: 'bucket_name', 
                defaultValue: 'hello_weekend',
                description: 's3 bucket name', 
                trim: true
            )
        ])
    ])
    stage('describe Stack'){
        def credentialsFile = "/var/jenkins_home/credentials"
        withEnv(["AWS_SHARED_CREDENTIALS_FILE=${credentialsFile}"]){
            def result = sh(script: "aws cloudformation describe-stacks --stack-name s3-bucket-cf --region ap-northeast-1", returnStdout: true).trim()
            def parser = new JsonSlurperClassic()
            def cfStackParams = parser.parseText(result)["Stacks"]["Parameters"][0]
            
            def branchValue = cfStackParams.find {it.'ParameterKey' == "BucketPrefix"}
            if (branchValue.'ParameterValue' != "${bucket_name}"){
                branchValue.'ParameterValue' = "${bucket_name}"
                param_json = new JsonBuilder(cfStackParams).toPrettyString()
                println(param_json)
            }
            else{
                println ("proceeding code pipeline deploy stage")
            }
        }
    }
}