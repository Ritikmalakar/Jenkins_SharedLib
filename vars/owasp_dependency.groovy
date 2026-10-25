def call() {
    dependencyCheck(
        odcInstallation: 'OWASP',
        nvdCredentialsId: 'nvd-api-key',
        additionalArguments: '--scan . --format XML --out . --nvdApiDelay 6000 --log dependency-check-debug.log'
    )

    dependencyCheckPublisher(
        pattern: '**/dependency-check-report.xml'
    )
}
