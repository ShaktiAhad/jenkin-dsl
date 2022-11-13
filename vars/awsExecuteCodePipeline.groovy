def call(region, pipeline){
    return (awsCommand("codepipeline start-pipeline-execution --region ${region} --name ${pipeline}"))
}