def call(rule){
    return (awsCommand("events describe-rule --name ${rule}"))
}