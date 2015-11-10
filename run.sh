mvn clean package
docker build -t rest2 .
#docker run --name some-app2 --link some-postgres:postgres -d rest2
#docker run -p 8080:8080 rest2
docker run -p 8080:8080 --name some-app4 --link some-postgres:postgres -d rest2
