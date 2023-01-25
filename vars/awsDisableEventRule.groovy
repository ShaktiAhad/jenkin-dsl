def call(region, rule){
    println (awsCommand("events disable-rule --region ${region} --name ${rule}"))
}