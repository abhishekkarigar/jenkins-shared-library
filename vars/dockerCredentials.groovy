def call(String appName) {
    script {
        withCredentials([usernamePassword(
           credentialsId: "dockerhub_id",
           usernameVariable: "USER",
           passwordVariable: "PASS"
        )]){
          sh "docker login -u $USER -p $PASS"
          sh "docker build -t $USER/$appName:$BUILD_NUMBER ."
          sh "docker push $USER/$appName:$BUILD_NUMBER"
        }
    }
}
