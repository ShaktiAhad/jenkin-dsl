def call(region, pipeline){
    return (shReturnJson("aws codepipeline get-pipeline-state --region ${region} --name ${pipeline}"))
}