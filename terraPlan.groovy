def call(Map params){
    sh """
        cd AKS_Module
        terraform plan \
            -var AZURE_SUBSCRIPTION_ID=${params.SUBSCRIPTION_ID} \
            -var AZURE_TENANT_ID=${params.TENANT_ID} \
            -var SERVICE_PRINCIPAL_ID=${params.PRINCIPAL_ID} \
            -var SERVICE_PRINCIPAL_PASSWORD=${params.PRINCIPAL_PASSWORD} \
            --var-file=./config/terraform.tfvars \
            -out="terraform.tfplan" 
                    
    """
}