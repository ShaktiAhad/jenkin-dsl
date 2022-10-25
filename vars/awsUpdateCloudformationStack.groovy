def call(region, stack, bucket="watashino-tesuto-bucketsu"){
    shReturnJson("aws s3 rb s3://${bucket} --force")
    return (shReturnJson("aws cloudformation update-stack --region ${region} --stack-name ${stack} --use-previous-template --parameters ParameterKey=BucketPrefix,ParameterValue=${bucket} --capabilities CAPABILITY_NAMED_IAM"))
}