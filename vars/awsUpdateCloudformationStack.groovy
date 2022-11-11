def call(stack, params){
    return (awsCommand("cloudformation update-stack --stack-name ${stack} --use-previous-template --parameters '${params}' --capabilities CAPABILITY_NAMED_IAM"))
}