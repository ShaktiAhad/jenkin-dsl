def call(region, stack, params){
    return (awsCommand("cloudformation update-stack --region ${region} --stack-name ${stack} --use-previous-template --parameters '${params}' --capabilities CAPABILITY_NAMED_IAM"))
}