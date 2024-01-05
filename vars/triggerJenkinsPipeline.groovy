def call(Map params){
    sh """
        curl -v -k --user ${params.jenkinsUser}:${params.jenkinsUserToken} \
            -X POST -H 'cache-control: no-cache' \
            -H 'content-type: application/x-www-form-urlencoded' \
            --data 'ImageTag=${params.imageTag}' \
            'http://${params.jenkinsIP}:${params.jenkinsPort}/job/${params.jenkinsJob}/buildWithParamters?token=${params.jenkinsJobToken}'
    """
}