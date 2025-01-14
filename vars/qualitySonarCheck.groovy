 def call() {
         withSonarQubeEnv('SONAR_LATEST') {
               sh """
               $SCANNER_HOME/bin/sonar-scanner \
               -Dsonar.projectKey=${env.BRANCH_NAME.replace('/', '_')} \
               -Dsonar.projectName=${env.BRANCH_NAME} \
               -Dsonar.java.binaries=target/classes
               """
           }
       }

