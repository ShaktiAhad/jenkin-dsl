def call(region, rule){
    def awsGetEventStatus = awsDescribeEventRule(region, rule)
    println ("Rule_name: ${awsGetEventStatus["Name"]}, Status: ${awsGetEventStatus["State"]}")
}
