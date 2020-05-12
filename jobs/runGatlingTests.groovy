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
        choiceParam('simulation', ['LibraryAPI (default)', 'RecipesAPI'], 'Simulation to be executed')
    }

    steps {
        shell('cd POC && mvn clean gatling:test -Dgatling.simulationClass=test.LibraryAPI')
    }
}