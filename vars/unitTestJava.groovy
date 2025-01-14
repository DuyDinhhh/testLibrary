def call() {
     def jdkTool = tool 'jdk17'
     withEnv(["JAVA_HOME=${jdkTool}"]) {
      sh 'mvn test'
    }
}
