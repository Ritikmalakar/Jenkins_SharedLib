
def call() {
    withCredentials([
        string(credentialsId: 'nvd-api-key', variable: 'NVD_API_KEY')
    ]) {
        sh '''
            set +x

            "$OWASP_HOME/bin/dependency-check.sh" \
              --scan ./ \
              --format XML \
              --out . \
              --nvdApiKey "$NVD_API_KEY"
        '''
    }

    dependencyCheckPublisher(
        pattern: '**/dependency-check-report.xml'
    )
}

