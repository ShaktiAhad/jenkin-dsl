def call(command){
    return (shReturnJson("aws ${command}"))
}