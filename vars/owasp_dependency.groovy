def call() {
    dependencyCheck(
        additionalArguments: '--scan ./ --format XML --out .',
        odcInstallation: 'OWASP',
        nvdCredentialsId: 'nvd-api-key'
    )

    dependencyCheckPublisher(
        pattern: '**/dependency-check-report.xml'
    )
}
