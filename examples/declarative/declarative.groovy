pipeline {
  agent {
    kubernetes {
      //cloud 'kubernetes'
      label 'mypod'
      yamlFile 'examples/declarative/Pod.yaml'
    }
  }
  stages {
    stage('Run maven') {
      steps {
        container('maven') {
          sh 'mvn -version'
        }
      }
    }
  }
}
