def call(String ProjectName, String ImageTag, String DockerHubUser){
  withCredentials([usernamePassword(credentialsId: 'docHubCred',usernameVariable: 'docHubUser',passwordVariable: 'docHubPass')]){
    sh "docker login -u ${docHubUser} -p ${docHubPass}"          
    }
    sh "docker push ${docHubUser}/${ProjectName}:${ImageTag}"
}
