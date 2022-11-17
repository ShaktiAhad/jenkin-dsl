def call(pipeline_data){
    params=[:]
    pipeline_data.each{key, value ->
        value.each{pipeline_name, pipeline_val ->
            params[pipeline_name] = [:]
            if (pipeline_name != "common" && pipeline_name == "awsCodePipeline"){
                params[pipeline_name].codeCommitRepo = pipeline_val.get("codeCommitRepo", "empty")
                params[pipeline_name].cfStack = pipeline_val.get("cfStack", "empty")
                params[pipeline_name].codePipeline = pipeline_val.get("codePipeline", "empty")
                params[pipeline_name].eventRule = pipeline_val.get("eventRule", null)
                params[pipeline_name].region = pipeline_val.get("region", "empty")
            }
            else if (pipeline_name == "common"){
                params[pipeline_name].gitUrl = pipeline_val.get("gitUrl", "empty")
                params[pipeline_name].branch = pipeline_val.get("branch", "empty")
                params[pipeline_name].cred = pipeline_val.get("cred", "empty")
            }
        }
    }  
    return params
}
return this