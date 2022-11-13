def call(region, stack){
    return(awsCommand("cloudformation describe-stack-events --region ${region} --stack-name ${stack}")["StackEvents"])
}