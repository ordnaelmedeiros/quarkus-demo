export GRAALVM_HOME=/home/leandro/App/graalvm
./mvnw package -Pnative -Dnative-image.docker-build=true
target/restls-1.0-SNAPSHOT-runner
