node {

    def remote = [:]
    remote.allowAnyHosts = true

    try {
         stage('Git'){
            git branch: 'develop', credentialsId: 'host-updates', url: 'git@gitlab.local.snjdigitalsolutions.com:jparham/elastic-helper.git'
        }

        stage('Build Executable'){
            sh'mvn package -Dmaven.test.skip=true && ls'
        }

        stage('Publish Snapshot'){
            sh'mvn deploy:deploy-file -DgroupId=com.snjdigitalsolutions \
                 -DartifactId=elastichelper \
                 -Dversion=0.0.1-SNAPSHOT \
                 -Dpackaging=jar \
                 -Dfile=target/elastichelper-0.0.1-SNAPSHOT.jar \
                 -DrepositoryId=snapshots \
                 -Durl=http://archiva.k3.snjdigitalsolutions.com/repository/snapshots/'
        }

        emailext( to: 'jparham@snjdigitalsolutions.com',
        subject: '${DEFAULT_SUBJECT} - Pass',
        body: '${DEFAULT_CONTENT}',
        attachLog: true)

    } catch(e) {
        emailext( to: 'jparham@snjdigitalsolutions.com',
        subject: '${DEFAULT_SUBJECT} - Fail',
        body: '${DEFAULT_CONTENT}',
        attachLog: true)
        throw e
    }
}