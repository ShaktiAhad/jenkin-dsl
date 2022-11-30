def call(region, pipeline){
    get_pipeline_state = awsPipelineStates(region, pipeline)
    for (stage in get_pipeline_state["stageStates"]){
        for (action in stage["actionStates"]){
            if (action.containsKey('latestExecution')){
            println("stageName: "+stage["stageName"]+ ", status: "+action['latestExecution']["status"])
            }
            else{
                println("stageName: "+stage["stageName"]+ ", status: null")
            }
        }
    }
}