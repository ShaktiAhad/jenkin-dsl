def call(region, repo, version){
    return (awsCommand("codecommit get-branch --region ${region} --repository-name ${repo} --branch-name ${version}"))
}