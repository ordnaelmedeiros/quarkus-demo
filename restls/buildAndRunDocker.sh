docker build -f src/main/docker/Dockerfile.native -t quarkus-teste .
docker run \
	-it --rm \
	-p 8080:8080 \
	-p 8443:8443 \
	-v /home/leandro/GitHub/ordnaelmedeiros/quarkus-demo/restls:/home/leandro/GitHub/ordnaelmedeiros/quarkus-demo/restls \
	-v /home/leandro/App/graalvm:/work/graalvm \
	quarkus-teste
