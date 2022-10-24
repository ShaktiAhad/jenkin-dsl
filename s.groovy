d = [common:[region:'ap-northeast-1'], 
awsCodePipeline:[codeCommitRepo:'shakti-test-repo', cfStack:'s3-bucket-cf', codePipeline:'shakti-test-nodejs'], 
awsEventRule:[eventRule:'test']
]
println(d.awsCodePipeline.get("codeCommitRepo", "k"))