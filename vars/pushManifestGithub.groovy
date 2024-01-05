def call(Map params){
    // Added git branch and checkout as in jenkins git run in detached state
    sh """
        git config --global user.name "${params.githubUserName}"
        git config --global user.email "${params.githubEmail}"
        git add Manifest_Files/deployment.yml
        git commit -m "Updated Deployment Manifest with ${params.imageTag} version"
        git branch test
        git checkout test
    """
    // change test -> main while push 
    withCredentials([usernamePassword(credentialsId: "${params.githubCredID}", passwordVariable: 'pass', usernameVariable: 'user')]){
        sh "git push https://$user:$pass@${params.githubURL} test:main"
    }
}