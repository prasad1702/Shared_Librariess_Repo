def call(String ProjectName, String ImageTag, String DockerHubUser) {

    withCredentials([usernamePassword(
        credentialsId: 'docHubCred',
        usernameVariable: 'docHubUser',
        passwordVariable: 'docHubPass'
    )]) {

        // Login securely using password-stdin
        sh '''
            echo "$docHubPass" | docker login \
            -u "$docHubUser" \
            --password-stdin
        '''
    }

    // Push the image after successful login
    sh "docker push ${DockerHubUser}/${ProjectName}:${ImageTag}"
}
