def call(region, pipeline){
    return (shReturnJson("aws codepipeline start-pipeline-execution --region ${region} --name ${pipeline}"))
}