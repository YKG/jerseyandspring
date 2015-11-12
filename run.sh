mvn clean package
docker build -t rest2 .
#docker run --name some-app2 --link some-postgres:postgres -d rest2
#docker run -p 8080:8080 rest2

# run it if postgres is not run
#docker run --name mypostgres -e POSTGRES_PASSWORD=mysecretpassword -d postgres

docker run -p 8080:8080 --link mypostgres:postgres rest2
