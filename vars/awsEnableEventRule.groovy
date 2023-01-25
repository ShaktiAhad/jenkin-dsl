def call(region, rule){
    println (awsCommand("events enable-rule --region ${region} --name ${rule}"))
}