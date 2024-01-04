def call(String project, String userName, String imageTag){
    sh """
        docker build -t ${userName}/${project} .
        docker image tag ${userName}/${project} ${userName}/${project}:${imageTag}
        docker image tag ${userName}/${project} ${userName}/${project}:latest
    """
}