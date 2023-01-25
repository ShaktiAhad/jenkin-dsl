def call(region, rule){
    println (awsCommand("events describe-rule --region ${region} --name ${rule}"))
}