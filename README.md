# Controle Estoque

## Dependencias
### PostgreSQL
```
docker run -p 5432:5432 -e POSTGRES_PASSWORD=estoque -e POSTGRES_USER=estoque -d postgres
```

Adicionar alguns itens ao estoque
```
INSERT INTO estoque (sku, quantidade) VALUES
('PRD0001A', 50), 
('PRD0001B', 50), 
('PRD0001C', 50), 
('PRD0003A', 50), 
('PRD0003B', 50), 
('PRD0003C', 50); 
```


### RabbitMQ
```
docker run -p 8080:15672 -p 5672:5672 -p 25676:25676 -d rabbitmq:3-management
```
