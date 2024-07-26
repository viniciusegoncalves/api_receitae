# API Receitae

Uma API para gerenciamento de receitas culinárias, permitindo operações CRUD (Create, Read, Update, Delete) para receitas e ingredientes.

## Tabela de Conteúdos

- [Instalação e Configuração](#instalação-e-configuração)
- [Uso](#uso)
- [Endpoints da API](#endpoints-da-api)
- [Tecnologias Utilizadas](#tecnologias-utilizadas)
- [Contribuição](#contribuição)
- [Licença](#licença)
- [Contato](#contato)

## Instalação e Configuração

### Pré-requisitos

- Java 11+
- Maven
- MySQL (ou outro banco de dados relacional)

### Passos

1. Clone o repositório:
    ```bash
    git clone https://github.com/viniciusegoncalves/api_receitae.git
    cd api_receitae
    ```

2. Configure o banco de dados no arquivo `application.properties`:
    ```properties
    spring.datasource.url=jdbc:mysql://localhost:3306/nomedobanco
    spring.datasource.username=seu_usuario
    spring.datasource.password=sua_senha
    spring.jpa.hibernate.ddl-auto=update
    ```

3. Compile e execute a aplicação:
    ```bash
    mvn clean install
    mvn spring-boot:run
    ```

## Uso

Para interagir com a API, você pode usar ferramentas como Postman ou cURL.

### Exemplo de Requisição cURL:

```bash
curl -X GET http://localhost:8080/receitas
```

## Endpoints da API

### Receitas

- **GET** `/receitas` - Lista todas as receitas
- **GET** `/receitas/{id}` - Obtém uma receita específica
- **POST** `/receitas` - Cria uma nova receita
- **PUT** `/receitas/{id}` - Atualiza uma receita existente
- **DELETE** `/receitas/{id}` - Exclui uma receita

### Ingredientes

- **GET** `/ingredientes` - Lista todos os ingredientes
- **GET** `/ingredientes/{id}` - Obtém um ingrediente específico
- **POST** `/ingredientes` - Cria um novo ingrediente
- **PUT** `/ingredientes/{id}` - Atualiza um ingrediente existente
- **DELETE** `/ingredientes/{id}` - Exclui um ingrediente

## Tecnologias Utilizadas

- Java 17
- Spring Boot
- Spring Data JPA
- MySQL
- Maven

## Contribuição

Contribuições são bem-vindas! Sinta-se à vontade para abrir issues e pull requests.

1. Fork o projeto
2. Crie uma nova branch (`git checkout -b feature/nova-feature`)
3. Commit suas alterações (`git commit -m 'Adiciona nova feature'`)
4. Push para a branch (`git push origin feature/nova-feature`)
5. Abra um Pull Request

## Licença

Este projeto está licenciado sob a Licença MIT. Veja o arquivo [LICENSE](LICENSE) para mais detalhes.

## Contato

Vinícius Gonçalves - [LinkedIn](https://www.linkedin.com/in/vinicius-ernande/) - viniciusegoncalves25@gmail.com
