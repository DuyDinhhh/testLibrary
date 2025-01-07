 
def call(Map config) {
         withSonarQubeEnv(config.sonarEnv ?: 'SONAR_LATEST') {
            def scannerHome = config.scannerHome ?: env.SCANNER_HOME
            def projectKey = config.BRANCH_NAME.replace('/', '_')
            def projectName = config.BRANCH_NAME

            sh """
            ${scannerHome}/bin/sonar-scanner \
            -Dsonar.projectKey=${projectKey} \
            -Dsonar.projectName=${projectName} \
            -Dsonar.java.binaries=target/classes
            """
        }
}
