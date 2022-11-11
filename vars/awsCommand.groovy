def call(region="ap-northeast-1", command){
    return (shReturnJson("aws ${command} --region ${region}"))
}