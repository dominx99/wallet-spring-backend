up:
	@docker-compose up -d

down:
	@docker-compose down

upmysql:
	@docker-compose up mysql -d

install:
	@./mvnw clean install

build:
	@docker-compose build

reup: down upmysql install up
