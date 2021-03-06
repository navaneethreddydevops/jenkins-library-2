@Library('github.com/Statemood/jenkins-library@dev') _

def repo = 'https://github.com/Statemood/simple-java-maven-app.git'

pipeline {
    agent any

    options {
        timestamps()
        timeout(time: 30, unit: 'MINUTES')
        buildDiscarder(logRotator(numToKeepStr: '10'))
    }

    parameters {
        gitParameter(
            branch: '', branchFilter: 'origin/(.*)', defaultValue: 'master', listSize: '10', 
            name: 'GIT_REVISION', quickFilterEnabled: true, selectedValue: 'NONE', 
            sortMode: 'DESCENDING_SMART', tagFilter: '*', type: 'PT_BRANCH_TAG', 
            description: 'Please select a branch or tag to build',
            useRepository: repo)
    }

    stages {
        stage ("Initial Stages") {
            steps {
                script {
                    log.i "Acquire config data"
                    
                    set(["repo": repo,                       
                         "lang": "java",
                         "build_command": "mvn",
                         "build_options": "-U clean -Dmaven.test.skip=true package dependency:tree"])   
                }
            }
        }
    }

    post {
        aborted {
            script {
                log.i "Post Action: aborted"
            }
        }

        always {
            script {
                log.i "Post Action: always"
            }
        }

        changed {
            script {
                log.i "Post Action: changed"
            }
        }

        failure {
            script {
                currentBuild.result = "FAILURE"
                log.i "Post Action: failure"  

                // Send mail
            }
        }

        success {
            script {
                log.i "Post Action: success"
            }
        }

        unstable {
            script {
                log.i "Post Action: unstable"
            }
        }  
    }
}