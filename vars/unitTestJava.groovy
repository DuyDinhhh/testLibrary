def call() {
      stage('Test') {
       
            sh 'mvn test'
        
    }
}
