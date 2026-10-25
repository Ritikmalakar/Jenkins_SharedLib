
def call() {
    def owaspHome = tool 'OWASP'

    withCredentials([
        string(credentialsId: 'nvd-api-key', variable: 'NVD_API_KEY')
    ]) {
        withEnv(["OWASP_HOME=${owaspHome}"]) {
            sh '''
                set +x

                "$OWASP_HOME/bin/dependency-check.sh" \
                  --scan ./ \
                  --format XML \
                  --out . \
                  --nvdApiKey "$NVD_API_KEY"
            '''
        }
    }

    dependencyCheckPublisher(
        pattern: '**/dependency-check-report.xml'
    )
}
