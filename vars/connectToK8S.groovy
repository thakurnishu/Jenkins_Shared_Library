def call(){
    sh """
        cd AKS_Module
        mkdir -p /var/lib/jenkins/.kube/
        cp kubeconfig /var/lib/jenkins/.kube/config
        kubectl get nodes
    """
}