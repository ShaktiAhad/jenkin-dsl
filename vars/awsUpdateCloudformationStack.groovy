def call(region, stack, params){
    return (shReturnJson("aws cloudformation update-stack --region ${region} --stack-name ${stack} --use-previous-template --parameters '${params}' --capabilities CAPABILITY_NAMED_IAM"))
}