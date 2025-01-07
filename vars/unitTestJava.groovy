def call() {
      stage('Test') {
        steps {
            sh 'mvn test'
        }
    }
}
