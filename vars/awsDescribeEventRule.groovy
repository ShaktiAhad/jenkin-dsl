def call(region, rule){
    awsDescribeRule = awsCommand("events describe-rule --region ${region} --name ${rule}")
    println ("Rule_name: ${awsDescribeRule["Name"]}, Status: ${awsDescribeRule["State"]}")
}