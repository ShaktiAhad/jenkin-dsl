def call(region, rule){
    return (shReturnJson("aws events describe-rule --region ${region} --name ${rule}"))
}