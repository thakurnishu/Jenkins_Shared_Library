def call(Map stageParams){

    withSonarQubeEnv(stageParams.credentialsId){
        sh ''' $SCANNER_HOME/bin/sonar-scanner -Dsonar.projectName=${stageParams.projectName} \
                    -Dsonar.projectKey=${stageParams.projectKey} '''
    }
}