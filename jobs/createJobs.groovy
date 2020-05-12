job('Create jobs from repository') {
    triggers {
        scm('* * * * *')
    }

    scm {
        git {
            remote {
                github('sobraljuanpa/JenkinsGatlingDSL', 'https')
                credentials('githubCredentials')
            }
        }
    }

    steps {
        dsl {
            external('**/*.groovy')
        }
    }
}