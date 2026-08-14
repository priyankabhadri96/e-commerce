pipeline {
    agent any

    stages {

        stage('Deploy to EC2') {
            steps {
                sshagent(['ec2-ssh-key']) {
                    sh '''
                        ssh -o StrictHostKeyChecking=no \
                        ec2-user@ec2-65-2-153-93.ap-south-1.compute.amazonaws.com \
                        "cd ~/ecommerce && docker-compose pull && docker-compose up -d"
                    '''
                }
            }
        }

    }
}