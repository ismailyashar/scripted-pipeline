properties([
    parameters([
        string(defaultValue: '', description: 'Provide node IP', name: 'node', trim: true)
        ])
    ])

node {
    stage("Pull Repo"){
        sh "git clone https://github.com/ismailyashar/scripted-pipeline.git"
    }

    stage("Install Melodi"){
        ansiblePlaybook become: true, colorized: true, credentialsId: 'Jenkins-master', disableHostKeyChecking: true, inventory: "${params.node},", playbook: 'ansible-melodi/main.yml'
    }    
}
