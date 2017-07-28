import com.lesfurets.jenkins.unit.global.lib.Library
@Library('jenkins-pipeline-unit-example@master')

def execute() {

    stage ('test') {
        node() {
           sleep(2000)
        }
    }
}

return this

