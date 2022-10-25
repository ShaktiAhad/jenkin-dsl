@Grab('org.yaml:snakeyaml:1.33')
import org.yaml.snakeyaml.Yaml

def content = new Yaml().load(("projects/a/config.yaml" as File).text)
pipeline_data = content["conf"]


params=[:]
pipeline_data.each{key, value ->
    value.each{pipeline_name, pipeline_val -> 
        params[pipeline_name] = [:]
        if (pipeline_name != "common"){
            params[pipeline_name].codeCommitRepo = pipeline_val.get("codeCommitRepo", "empty")
            params[pipeline_name].cfStack = pipeline_val.get("cfStack", "empty")
            params[pipeline_name].codePipeline = pipeline_val.get("codePipeline", "empty")
            params[pipeline_name].eventRule = pipeline_val.get("eventRule", "empty")
            params[pipeline_name].region = pipeline_val.get("region", "empty")
            // // sd = []
            // params[pipeline_name].paramas = []
            // for (f in pipeline_val.parameters ){
            //     params[pipeline_name].paramas.add(["ParameterKey = ${f.key}, ParameterValue = ${f.value}"])

            // } 
        }
        else if (pipeline_name == "common")
            params[pipeline_name].gitUrl = pipeline_val.get("gitUrl", "empty")
            params[pipeline_name].branch = pipeline_val.get("branch", "empty")
            params[pipeline_name].cred = pipeline_val.get("cred", "empty")
    }
}

println (params)
