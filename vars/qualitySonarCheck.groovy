def call(Map config){
  stage('SonarQube') {
        
            script {
                withSonarQubeEnv(config.sonarEnv ?: 'SONAR_LATEST') {
                    sh """
                    ${config.scannerHome ?: '$SCANNER_HOME'}/bin/sonar-scanner \
                    -Dsonar.projectKey=${config.BRANCH_NAME.replace('/', '_')} \
                    -Dsonar.projectName=${config.BRANCH_NAME} \
                    -Dsonar.java.binaries=target/classes
                    """
                }
            
        }
    }
}
