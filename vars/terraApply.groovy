def call(){
    sh """
        cd AKS_Module
        terraform apply -auto-approve "terraform.tfplan" 
    """
}