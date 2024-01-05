def call(Map params){
    sh """
        git config --global user.name "${params.githubUserName}"
        git config --global user.email "${params.githubEmail}"
        git add Manifest_Files/deployment.yml
        git commit -m "Updated Deployment Manifest with ${params.imageTag} version"
    """
    withCredentials([gitUsernamePassword(credentialsId: "${params.githubCredID}", gitToolName: 'Default')]){
        sh "git push https://${params.githubURL} main"
    }
}