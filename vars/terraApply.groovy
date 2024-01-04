def call(){
    sh """
        cd AKS_Module
        terraform apply "terraform.tfplan"
    """
}