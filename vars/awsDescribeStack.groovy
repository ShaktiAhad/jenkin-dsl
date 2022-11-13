def call(region, stack){
    return(awsCommand("cloudformation describe-stacks --region ${region} --stack-name ${stack}"))
}