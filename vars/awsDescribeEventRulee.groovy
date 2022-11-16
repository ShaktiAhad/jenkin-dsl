def call(region, rule){
    return (awsCommand("events describe-rule --region ${region} --name ${rule}"))
}