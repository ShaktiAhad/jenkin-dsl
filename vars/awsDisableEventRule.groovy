def call(region, rule){
    return (shReturnJson("aws events disable-rule --region ${region} --name ${rule}"))
}