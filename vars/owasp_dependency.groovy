
def call() {
    withCredentials([
        string(
            credentialsId: 'nvd-api-key',
            variable: 'NVD_API_KEY'
        )
    ]) {
        dependencyCheck(
            additionalArguments: '--scan ./ --format XML',
            odcInstallation: 'OWASP',
            nvdCredentialsId: 'nvd-api-key'
        )
    }

    dependencyCheckPublisher(
        pattern: '**/dependency-check-report.xml'
    )
}
}
