 def call() {
    stage('Code Quality Scan'){
         withSonarQubeEnv(env.sonarEnv ?: 'SONAR_LATEST') {
            sh """
            ${env.scannerHome}/bin/sonar-scanner \
            -Dsonar.projectKey=${env.BRANCH_NAME.replace('/', '_')} \
            -Dsonar.projectName=${env.BRANCH_NAME} \
            -Dsonar.java.binaries=target/classes
            """
        }
    }
}
