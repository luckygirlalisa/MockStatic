pipeline {
    agent any
    stages {
        stage("Pull Code") {
            steps {
                git branch: "master", url: "git@github.com:luckygirlalisa/MockStatic.git"
            }
        }

        stage("build") {
            steps {
                script {
                    sh("mvn clean install -Ptest")
                }
            }
        }

    }
    post {
        always {
            junit '**/reports/junit/*.xml'
        }
    }

    stages {
        stage('test numbers'){
            steps {
                script {
                    def testResult = build.testResultAction
                    def totalTest = testResult.totalCount

                    print totalTest
                }
            }
        }
    }
}
