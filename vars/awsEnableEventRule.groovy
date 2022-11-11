def call(rule){
    return (awsCommand("events enable-rule --name ${rule}"))
}