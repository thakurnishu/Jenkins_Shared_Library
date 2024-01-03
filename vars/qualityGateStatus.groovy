def call(token){
    waitForQualityGate abortPipeline: false, credentialsId: token
}