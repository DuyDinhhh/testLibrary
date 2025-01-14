 def call() {
   stage('Code Quality Analysis') {
         env.SCANNER_HOME = tool 'sonar-scanner'
         withSonarQubeEnv('SONAR_LATEST') {
               sh """
               ${env.SCANNER_HOME}/bin/sonar-scanner \
               -Dsonar.projectKey=${env.BRANCH_NAME.replace('/', '_')} \
               -Dsonar.projectName=${env.BRANCH_NAME} \
               -Dsonar.java.binaries=target/classes
               """
           }
       }
 }

