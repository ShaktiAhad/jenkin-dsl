def call(command){
    def credentialsFile = "/var/jenkins_home/credentials"
    withEnv(["AWS_SHARED_CREDENTIALS_FILE=${credentialsFile}"]){
        return (shReturnJson("aws ${command}"))
    }
}