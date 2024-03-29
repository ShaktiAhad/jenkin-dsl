def call(region, pipeline, pipelineId){
    get_pipeline_state = awsPipelineStates(region, pipeline)
    for (stage in get_pipeline_state["stageStates"]){
        if (stage["latestExecution"]["pipelineExecutionId"] == pipelineId){
            for (action in stage["actionStates"]){
                println("stageName: ${stage["stageName"]}, actionName: ${action["actionName"]}, status: ${action['latestExecution']["status"]}")
            }
        }
    }
}