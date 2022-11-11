def call(pipeline){
    get_exec_id = awsCommand("codepipeline list-pipeline-executions --pipeline-name ${pipeline}")["pipelineExecutionSummaries"]["pipelineExecutionId"][0]
    return(awsCommand("codepipeline get-pipeline-execution --pipeline-execution-id ${get_exec_id} --pipeline-name ${pipeline}")["pipelineExecution"]["status"])
}