def call(region, rule){
    return (awsCommand("events enable-rule --region ${region} --name ${rule}"))
}