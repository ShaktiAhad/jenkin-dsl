def call(stack){
    return(awsCommand("cloudformation describe-stack-events --stack-name ${stack}")["StackEvents"])
}