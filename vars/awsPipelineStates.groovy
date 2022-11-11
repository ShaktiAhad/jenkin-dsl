def call(pipeline){
    return (awsCommand("codepipeline get-pipeline-state --name ${pipeline}"))
}