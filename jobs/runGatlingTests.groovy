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

    parameters {
        choiceParam('simulation', ['LibraryAPI', 'RecipesAPI'], 'Simulation to be executed')
        choiceParam('baseUrl', ['http://openlibrary.org', 'other'], 'Base URL for simulation')
    }

    steps {
        shell('cd POC && mvn clean gatling:test -Dgatling.simulationClass=test.${simulation} -DbaseUrl=${baseUrl}')
    }

    publishers {
        archiveGatling()
    }
}