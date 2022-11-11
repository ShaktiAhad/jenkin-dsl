def call(pipeline){
    return (awsCommand("codepipeline start-pipeline-execution --name ${pipeline}"))
}