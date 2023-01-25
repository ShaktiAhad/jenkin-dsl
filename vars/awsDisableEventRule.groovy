def call(region, rule){
    return (awsCommand("events disable-rule --region ${region} --name ${rule}"))
}