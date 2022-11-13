def call(region, pipeline){
    return (awsCommand("codepipeline get-pipeline-state --region ${region} --name ${pipeline}"))
}