def call(region, stack, bucket="watashino-tesuto-bucketsu", params){
    shReturnJson("aws s3api delete-bucket --bucket ${bucket} --region ${region}")
    return (shReturnJson("aws cloudformation update-stack --region ${region} --stack-name ${stack} --use-previous-template --parameters [${params}, {"ParameterKey":"BucketPrefix", "ParameterValue": "${bucket}"}]--capabilities CAPABILITY_NAMED_IAM"))
}