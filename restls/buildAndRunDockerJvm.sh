./mvnw clean package
docker build -f src/main/docker/Dockerfile.jvm -t quarkus-teste .
docker run \
	-it --rm \
	-p 8080:8080 \
	-p 8443:8443 \
	-v /home/leandro/GitHub/ordnaelmedeiros/quarkus-demo/restls:/home/leandro/GitHub/ordnaelmedeiros/quarkus-demo/restls \
	quarkus-teste
