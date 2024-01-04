def call(String project, String userName){
    sh """
        trivy image ${userName}/${project}:latest > scan.txt
        cat scan.txt
    """
}