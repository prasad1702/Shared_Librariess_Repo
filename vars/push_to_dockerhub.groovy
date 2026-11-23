def call(String ProjectName, String ImageTag, String DockerHubUser){
  withCredentials([usernamePassword(credentialsId: 'docHubCred',usernameVariable: 'docHubUser',passwordVariable: 'docHubPass')]){
    sh "docker login -u ${dockerhubuser} -p ${dockerhubPass}"          
    }
    sh "docker push ${dockerhubuser}/${ProjectName}:${ImageTag}
}
