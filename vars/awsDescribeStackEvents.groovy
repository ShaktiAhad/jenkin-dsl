def call(region, stack){
    return(shReturnJson("aws cloudformation describe-stack-events --region ${region} --stack-name ${stack}")["StackEvents"])
}