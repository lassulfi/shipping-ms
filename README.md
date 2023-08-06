# Shipping Microservice

## Introdução

O projeto Shipping Microservice é uma API de cálculo de fretes a partir de uma entrada de dados contendo as informações do produto (largura, altura e peso). Como resultado é apresentado uma lista com todos os valores de frete de diversas empresas cadastradas na plataforma de vendas.

Cara transportadora possui seus requisitos para cálculo do frete, que são as seguintes:
- A altura do produto deve estar entre os valores máximo e mínimo estabelecidos pela transportadora;
- A largura do produto deve estar entre os valores máximo e mínimo estabelecidos pela transportadora;
- O peso do produto deve ser maior que zero.

Caso algum dos requisitos acima não seja atendido para uma determinada transportadora, o valor do frete para esta não será retornado.

Para o cálculo do frete os dados devem ser informados nas seguintes unidades:
- altura e largura em centímetros (cm)
- peso em gramas (g)

Caso nenhuma transportadora atenda o produto, será retornado uma lista vazia.

Esse projeto utiliza os conceitos de DDD (Domain Driven Design) e Arquitetura Limpa (Clean Architecture)

## Instalação

- Clonar o repositório [aqui]()
- Instalar as dependencias com o comando `mvn clean install`

## Testes

- Execute os testes com o comando `mvn test`

## Uso da aplicação

- Execute o comando `mvn spring-boot:run` para executar a aplicação
- Conecte-se a API utilizando o Postman ou Thunder Client na porta 8080
- Acesse da documentação (Swagger - OpenAPI) em http://localhost/api/v1/swagger-ui.html

## Docker

- Execute o comando `docker-compose up -d --build` para realizar o build da imagem da aplicação e iniciar a API
- Execute o comando `docker-compose up` para executar a aplicação sem o build da imagem

## Endpoints da API

| Verbo HTTP | Endpoint | Ação |
| --- | --- | --- |
| POST | /api/v1/shipping-companies | Calcular o frete de um determinado produto |

## Tecnologias utilizadas

[OpenJDK](https://openjdk.org/) Implementação open-source da plataforma Java. Para este projeto foi utilizada a versão 17.0.2
[Maven](https://maven.apache.org/) Gerenciamento de dependencias e processos da aplicação. Para este projeto foi utilizada a versão 3.8.2
[Spring Boot](https://spring.io/projects/spring-boot) Framework para desenvolvimento de aplicações Web. Para este projeto foi utilizada a versão 3.1.2.
[Docker](https://www.docker.com/) Plataforma para o desenvolvimento, compartilhamento e execução de aplicações em containers
