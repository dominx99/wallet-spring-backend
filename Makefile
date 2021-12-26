up:
	@docker-compose up -d

down:
	@docker-compose down

upmysql:
	@docker-compose up mysql -d

build:
	@docker-compose build

reup: down upmysql build up
