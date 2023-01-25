def call(region, rule){
    awsDescribeEventRule = awsCommand("events describe-rule --region ${region} --name ${rule}")
    println ("Rule_name: ${awsDescribeEventRule["Name"]}, Status: ${awsDescribeEventRule["State"]}")
}