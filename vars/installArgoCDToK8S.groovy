def call(){
    def isArgoCDInstalled = sh(returnStdout: true, script: "kubectl get pods -n argocd | grep argocd-server").trim()
    if (!isArgoCDInstalled) {
        sh """"
            kubectl create namespace argocd
            kubectl apply -n argocd -f https://raw.githubusercontent.com/argoproj/argo-cd/stable/manifests/install.yaml
            kubectl patch svc argocd-server -n argocd -p '{"spec": {"type": "LoadBalancer"}}'
        """
    } else {
        sh """
            echo 'ArgoCD is already installed. Skipping installation.'
        """
    }
}
