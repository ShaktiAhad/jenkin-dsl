def call(region, pipeline){
    get_exec_id = awsCommand("codepipeline list-pipeline-executions --region ${region} --pipeline-name ${pipeline}")["pipelineExecutionSummaries"]["pipelineExecutionId"][0]
    return(awsCommand("codepipeline get-pipeline-execution --region ${region} --pipeline-execution-id ${get_exec_id} --pipeline-name ${pipeline}")["pipelineExecution"]["status"])
}