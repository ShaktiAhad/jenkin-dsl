def call(repo, version){
    return (awsCommand("codecommit get-branch --repository-name ${repo} --branch-name ${version}"))
}