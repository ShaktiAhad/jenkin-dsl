def call(region, rule){
    def awsGetEventStatus = awsDescribeEventRule(region, rule)
    return ("Rule_name: ${awsGetEventStatus["Name"]}, Status: ${awsGetEventStatus["State"]}")
}
