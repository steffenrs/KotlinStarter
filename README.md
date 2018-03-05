install postgres

docker pull postgres

`docker run --name some-postgres2 -p 5432:5432 -e POSTGRES_PASSWORD=test -d postgres`

# start existing docker container
docker start  `docker ps -q -l` # restart it in the background

connect psql:
`psql -h 0.0.0.0 -p 5432 -U postgres`
