def call(String saywhat = "nothing"){
    if (saywhat=="hi"){
        script {
            sh """
                echo Hi alice
            """
        }
    }
    else if (saywhat == "hello") {
        script {
            sh """
                echo hello alice
            """
        }
    }
    else {
        script {
            sh """
                echo what Whats up Alice
            """
        }
    }
}
