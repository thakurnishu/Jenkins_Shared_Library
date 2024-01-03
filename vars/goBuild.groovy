def call(buildName){
    sh "/usr/local/go/bin/go build -o ${buildName}"
}