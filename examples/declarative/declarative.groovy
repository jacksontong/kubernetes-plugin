pipeline {
  agent {
    kubernetes {
      //cloud 'kubernetes'
      label 'mypod'
      yamlFile 'examples/declarative/Pod.yaml'
    }
  }
  stages {
    stage('Run docker') {
      steps {
        container('docker') {
          sh 'docker build -t jenkinsci/jenkins-agent .'
        }
      }
    }
  }
}
