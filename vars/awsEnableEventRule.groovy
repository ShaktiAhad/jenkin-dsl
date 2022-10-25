def call(region, rule){
    return (shReturnJson("aws events enable-rule --region ${region} --name ${rule}"))
}