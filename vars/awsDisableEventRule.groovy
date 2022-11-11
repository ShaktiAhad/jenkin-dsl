def call(rule){
    return (awsCommand("events disable-rule --name ${rule}"))
}