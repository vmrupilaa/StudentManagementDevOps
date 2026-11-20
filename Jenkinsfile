
pipeline {
    agent any

    tools {
        maven 'Maven-3.9.9'
    }

    stages {

        stage('Checkout') {
            steps {
                echo 'Fetching Java project from GitHub'
                checkout scm
            }
        }

        stage('Build and Test') {
            steps {
                echo 'Compiling source code and running JUnit tests'
                sh 'mvn clean test'
            }
        }

        stage('Package') {
            steps {
                echo 'Creating executable JAR file'
                sh 'mvn package'
            }
        }

        stage('Archive') {
            steps {
                archiveArtifacts artifacts: 'target/*.jar',
                                 fingerprint: true
            }
        }
    }

    post {
        success {
            echo 'BUILD SUCCESSFUL!'
        }

        failure {
            echo 'BUILD FAILED. Check the console output.'
        }
    }
}
