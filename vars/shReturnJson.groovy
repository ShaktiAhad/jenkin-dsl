import groovy.json.JsonSlurperClassic

def call(aws_command){
    withCredentials([aws(accessKeyVariable: 'AWS_ACCESS_KEY_ID', credentialsId: 'aws-cred', secretKeyVariable: 'AWS_SECRET_ACCESS_KEY')]){
        def result = sh(script: "${aws_command}", returnStdout: true).trim()
        if (result.length() == 0){
            println (" ## No json output.")
        }
        else{
            def parser = new JsonSlurperClassic()
            def json = parser.parseText(result)
            return json
        }
    }
}
