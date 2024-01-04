def call(String project, String userName, String imageTag, String credId){
    withCredentials([usernamePassword(
        credentialsId: credId,
        passwordVariable: 'PASS',
        usernameVariable: 'USER'
    )]) {
        sh "docker login -u '$USER' -p '$PASS' "
    }
    sh """
        docker image push ${userName}/${project}:${imageTag}
        docker image push ${userName}/${project}:latest
        docker rmi ${userName}/${project}:${imageTag}
        docker rmi ${userName}/${project}:latest
    """
}