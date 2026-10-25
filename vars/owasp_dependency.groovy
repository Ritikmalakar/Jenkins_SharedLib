
def call() {
    dependencyCheck(
        additionalArguments: '--scan ./ --format XML',
        odcInstallation: 'OWASP',
        nvdCredentialsId: 'nvd-api-key'
    )

    dependencyCheckPublisher(
        pattern: '**/dependency-check-report.xml'
    )
}
