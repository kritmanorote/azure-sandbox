node {
      stage('init') {
        checkout scm
      }
      stage('build') {
        sh 'mvn clean package'
      }
      stage('deploy') {
        withCredentials([azureServicePrincipal('azure_service_principal')]) {
          // login to Azure
          sh '''
            az login --service-principal -u $AZURE_CLIENT_ID -p $AZURE_CLIENT_SECRET -t $AZURE_TENANT_ID
            az account set -s $AZURE_SUBSCRIPTION_ID
          '''  
          // Set default resource group name and service name. Replace <resource group name> and <service name> with the right values
          sh 'az config set defaults.group=azureSpringCloudService-rg'
          sh 'az config set defaults.spring-cloud=chill-azure-spring-cloud'
          // Deploy applications
          sh 'az spring-cloud app deploy -n gateway --jar-path ./target/azure-sandbox-0.0.1-SNAPSHOT.jar'
          sh 'az logout'
        }
      }
    }