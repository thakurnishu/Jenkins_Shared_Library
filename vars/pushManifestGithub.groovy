def call(Map params){
    sh """
        git config --global user.name "${params.githubUserName}"
        git config --global user.email "${params.githubEmail}"
        git add Manifest_Files/deployment.yml
        git commit -m "Updated Deployment Manifest with ${params.imageTag} version"
        git branch -M main
    """
    withCredentials([usernamePassword(credentialsId: "${params.githubCredID}", passwordVariable: 'pass', usernameVariable: 'user')]){
        sh "git push https://$user:$pass@${params.githubURL} main"
    }
}