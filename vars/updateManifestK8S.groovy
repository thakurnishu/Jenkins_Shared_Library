def call(Map params){
    sh """
        cd Manifest_Files
        cat deployment.yml
        sed -i 's/${params.imageName}.*/${params.imageName}:${imageTag}' deployment.yml
        cat deployment.yml
    """
}