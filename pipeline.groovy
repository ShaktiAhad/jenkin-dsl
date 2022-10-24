
// new File("projects/").traverse(nameFilter: ~/config.*\.yaml/){
//     String folder_path = it
//     project_name = folder_path.split('/')[-2]


pipelines.each{key, value ->
    value.each{pipeline_name, pipeline_val -> 
        if (pipeline_name == "common"){
            gitInfo = [:]
            jenkinfilePath = [jenkinfilePath: pipeline_val.get("jenkinfilePath", '-')]
            gitInfo.gitUrl = pipeline_val.get("gitUrl", '-')
            gitInfo.branch = pipeline_val.get("branch", '-')
            gitInfo.cred = "personal-git-cred"

        }
        else if (pipeline_name != "common"){
            def folder_path = "${key}/${project}}"
            def pipline = "${folder_path}/${pipeline_name}"
            println (pipline)
            pipelineJob("${pipline}"){
                description ("Pipeline for ${pipeline_name} job")
                logRotator(-1, 3)
                definition{
                    cpsScm{
                        scm {
                            git {
                                remote {
                                    url(gitInfo.gitUrl)
                                    credentials(gitInfo.cred)
                                }
                                branch(gitInfo.branch)
                            }
                        }
                        scriptPath(jenkinfilePath.jenkinfilePath)
                    }
                }

                if(pipeline_val.inputParams){
                    pipeline_val.inputParams.each {param_type, param_detail -> 
                        parameters{
                            if (param_type == "string"){
                                param_detail.each{str_key, str_val -> 
                                    stringParam(str_key, str_val.defaultValue, str_val.description)
                                }
                            }
                            else if (param_type == "choice"){
                                param_detail.each{ch_key, ch_val ->
                                    choiceParam(ch_key, ch_val.choices, ch_val.description)
                                } 
                            }
                        }
                    } 
                }
            }
        }
    }
}