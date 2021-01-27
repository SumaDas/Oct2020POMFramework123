pipeline{
    agent any
    stages{
        stage("Build")
        {
            steps{
                echo("Building")
            }
        }
        stage("DEV Deploy")
        {
            steps{
                echo("Dev Deployment")
            }
        }
        stage("QA Deploy")
        {
            steps{
                echo("QA Deployment")
            }
        }
        stage("Regression Test Automation")
        {
            steps{
                echo("Run Test Automation")
            }
        }
        stage("stage Deploy")
        {
            steps{
                echo("Stage Deployment")
            }
        }
        stage("Sanity Test")
        {
            steps{
                echo("Sanity Test on Stage")
            }
        }
        stage("PROD Deploy")
        {
            steps{
                echo("PROD Deployment")
            }
        }
    }
}