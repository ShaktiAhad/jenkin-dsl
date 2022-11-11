def call(stack){
    return(awsCommand("cloudformation describe-stacks --stack-name ${stack}"))
}