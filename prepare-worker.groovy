node {
    stage("Initialize") {
        withCredentials([sshUserPrivateKey(credentialsId: 'jenkins-master', keyFileVariable: 'SSHKEY', passphraseVariable: '', usernameVariable: 'SSHUSERNAME')]) {
            sh "ssh -o StrictHostKeyChecking=no -i $SSHKEY $SSHUSERNAME@206.189.194.142 yum install epel-release -y "
        }
    }
}
