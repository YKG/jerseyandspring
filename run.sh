mvn clean package
docker build -t rest2 .
docker run -p 8080:8080 rest2
