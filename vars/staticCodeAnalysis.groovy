def call(Map params){

    withSonarQubeEnv(params.credentialsId){
        sh '$SCANNER_HOME/bin/sonar-scanner -Dsonar.projectKey=${params.projectKey}'
    }
}