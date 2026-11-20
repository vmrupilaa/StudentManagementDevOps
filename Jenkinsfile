
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
                echo 'Compiling Java code and running JUnit tests'
                sh 'mvn clean test'
            }
        }

        stage('Package') {
            steps {
                echo 'Creating executable JAR'
                sh 'mvn package'
            }
        }

        stage('Archive') {
            steps {
                archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
            }
        }

        stage('Docker Build') {
            steps {
                echo 'Building Java application Docker image'
                sh 'docker build -t student-management:v1 .'
            }
        }
    }

    post {
        success {
            echo 'BUILD SUCCESSFUL! Java application and Docker image created.'
        }
        failure {
            echo 'BUILD FAILED. Check the Console Output.'
        }
    }
}
