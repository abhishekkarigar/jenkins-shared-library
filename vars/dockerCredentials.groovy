def call(String appName, String buildNo) {
    script {
        withCredentials([usernamePassword(
           credentialsId: "dockerhub_id",
           usernameVariable: "USER",
           passwordVariable: "PASS"
        )]){
          sh "docker login -u $USER -p $PASS"
          sh "docker build -t $USER/$appName:$buildNo ."
          sh "docker push $USER/$appName:$BUILD_NUMBER"
        }
    }
}
