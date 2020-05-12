job('RunGatlingTests') {
    triggers {
        scm('* * * * *')
    }

    scm {
        git {
            remote {
                github('sobraljuanpa/JenkinsDSLGatling', 'https')
                credentials('githubCredentials')
            }
        }
    }

    steps {
        shell('cd POC && mvn clean gatling:test -Dgatling.simulationClass=test.LibraryAPI')
    }
}