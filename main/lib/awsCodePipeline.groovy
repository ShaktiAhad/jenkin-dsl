def call(pipeline_data){
    params=[:]
    pipeline_data.each{key, value ->
        value.each{pipeline_name, pipeline_val -> 
            params[pipeline_name] = [:]
            if (pipeline_name != "common"){
                params[pipeline_name].codeCommitRepo = pipeline_val.get("codeCommitRepo", "empty")
                params[pipeline_name].cfStack = pipeline_val.get("cfStack", "empty")
                params[pipeline_name].codePipeline = pipeline_val.get("codePipeline", "empty")
                params[pipeline_name].eventRule = pipeline_val.get("eventRule", "empty")
            }
            else if (pipeline_name == "common")
                params[pipeline_name].region = pipeline_val.get("region", "empty")
        }
    }  
    return params
}
return this