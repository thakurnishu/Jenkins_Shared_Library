def call(credentialsId){

    withSonarQubeEnv(credentialsId){
        sh '$SCANNER_HOME/bin/sonar-scanner'
    }
}