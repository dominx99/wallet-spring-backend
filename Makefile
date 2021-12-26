up:
	@docker-compose up -d

down:
	@docker-compose down

upmysql:
	@docker-compose up mysql -d

install:
	docker run -v $(PWD):/app maven:3.8.3-openjdk-17 sh -c "cd /app && mvn clean install"

build:
	@docker-compose build

reup: down upmysql install up
