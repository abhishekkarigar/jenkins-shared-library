def call(String appName, String buildNo) {
    withCredentials([usernamePassword(
            credentialsId: "docker",
            usernameVariable: "USER",
            passwordVariable: "PASS"
    )]){
        sh "docker login -u $USER -p $PASS"
        sh "docker build -t $USER/$appName:$buildNo ."
        sh "docker push $USER/$appName:$BUILD_NUMBER"
    }
}
