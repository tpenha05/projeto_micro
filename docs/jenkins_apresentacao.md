# Apresentação

## Repositório

[GitHub do Projeto com Pipelines](https://github.com/tpenha05/projeto_micro)

## Vídeo

[Assista à apresentação (2-3 min)](https://youtube.com/...)

## Demonstração

Exemplo do Jenkinsfile (`account-service`):

```groovy
pipeline {
    agent any
    tools {
        maven 'maven-3'
        jdk 'jdk-21'
    }
    environment {
        SERVICE = 'account'
        NAME = "tpenha05/${env.SERVICE}"
        REGISTRY_CREDENTIALS = 'dockerhub-credentials'
    }
    stages {
        stage('Checkout Dependencies') {
            steps {
                script {
                    dir('libs/account') {
                        git branch: 'main', url: 'https://github.com/tpenha05/store-account.git'
                        sh 'mvn clean install -DskipTests'
                    }
                }
            }
        }
        stage('Build') { 
            steps {
                sh 'mvn -B -DskipTests clean package'
            }
        }      
        stage('Build & Push Image') {
            steps {
                script {
                    withCredentials([usernamePassword(credentialsId: env.REGISTRY_CREDENTIALS, 
                                                       usernameVariable: 'USERNAME', 
                                                       passwordVariable: 'TOKEN')]) {
                        sh '''
                            docker login -u $USERNAME -p $TOKEN
                            docker build -t ${env.NAME}:latest .
                            docker build -t ${env.NAME}:${env.BUILD_NUMBER} .
                            docker push ${env.NAME}:latest
                            docker push ${env.NAME}:${env.BUILD_NUMBER}
                        '''
                    }
                }
            }
        }
    }
}
```
