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
    }
    
    environmentVariables {
        env('BASE_URL', 'http://openlibrary.org')
    }

    steps {
        shell('cd POC && mvn clean gatling:test -Dgatling.simulationClass=test.${simulation}')
    }
}