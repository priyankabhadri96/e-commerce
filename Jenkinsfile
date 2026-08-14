stage('Test') {
    steps {
        echo 'Running tests...'
        sh 'mvn clean test'
    }
}

stage('Build') {
    steps {
        echo 'Building Spring Boot application...'
        sh 'mvn package -DskipTests'
    }
}