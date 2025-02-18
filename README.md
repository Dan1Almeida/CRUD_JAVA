# AppContatos

> Este projeto CRUD tem como principal objetivo cadastrar pessoas com seus atributos pertinentes e assim podendo cadastrar vários contatos ligados a esta pessoa. Podendo manipular os dados de diversas maneiras possíveis e servir como uma agenda de contatos.

## Tecnologias Utilizadas

Gerado projeto Maven em Start.spring.io

```
https://start.spring.io/
```

- Tecnologias:
Project: Maven | Language: Java | Spring Boot: 3.4.2 | Packaging: Jar | Java: 21

- Metadada:
Group: br.com.dnl | Artifact e Name: AppContatos | Package name: br.com.dnl.AppContatos

- Dependências iniciais:
Spring Web | Spring Data JPA | H2 Database 

- Outras dependências:
  
```
	<dependency>
		<groupId>com.fasterxml.jackson.core</groupId>
		<artifactId>jackson-databind</artifactId>
	</dependency>
		
	<dependency>
		<groupId>org.springdoc</groupId>
		<artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
		<version>2.2.0</version>
	</dependency>
```

##  Métodos de aplicação 

Porta utilizada para a inicialização do projeto
```
https://localhost:8080:
```
Documentação OpenApi Swagger
```
https://localhost:8080:/swagger-ui.html
```

Banco de dados em memória H2
```
http://localhost:8080/h2-console
```

- Acesso ao banco de dados H2: `<spring.datasource.url=jdbc:h2:mem:pessoas spring.datasource.username=sa>`
  
- Visando ter a melhor localização de LOG personalizado no console, foi desabilitada a função de mostrar o SQL com a seguinte linha: `<spring.jpa.show-sql=false>`
  
- Utilizado o método para atualizar automaticamente o esquema do banco de dados com a seguinte linha `<spring.jpa.hibernate.ddl-auto=update>`

## Métodos de utilização de projeto
  > Durante o desenvolvimento do projeto, foram utilizados dois métodos para testes de funcionamento de projeto e nos métodos endpoints requeridos.
  
- Swagger: Presente com todos os endpoints do projeto, devendo alterar alguns padrões de métodos de entradas em POST e PUT (Consulte o tópico 3.1).
- Postman: Na pasta raiz com o nome "PostAppContatos" se encontra o arquivo para utilizar no programa, nele já está presente todos os endpoints com todos os exemplos de entradas de dados.

## Endpoints e métodos de entradas

  ### Pessoas
 	POST pessoa - save  `<http://localhost:8080/api/pessoas>` --> criar uma pessoa.

	```
	{
  		"nome": "Daniel Almeida",
  		"cpf": "010.101.010-10",
  		"orderLogradouro": "RUA",
  		"endereco": "Vincent Van Gogh",
  		"numero": 1,
  		"cep": "01010-101",
  		"cidade": "Osasco",
  		"orderUf": "SP"
	}
	```
	PUT pessoa - update `<http://localhost:8080/api/pessoas/{id}>` --> Atualiza uma pessoa com o {ID} requisitado, caso não haja é criado uma nova.

	```
	{
    	"nome": "Daniel Almeida",
    	"cpf": "010.101.010-11",
    	"orderLogradouro": "Avenida",
    	"endereco": "Agatha Christie",
    	"numero": 2,
    	"cep": "10101-010",
    	"cidade": "Rio de Janeiro",
    	"orderUf": "RJ"
	}
	```
 
	DELETE pessoa - delete `<http://localhost:8080/api/pessoas/{ID}>` --> Deleta uma pessoa com o {ID} requisitado.
	
	GET pessoa - FindByid `<http://localhost:8080/api/pessoas/{ID}>` --> Encontra uma pessoa com o {ID} requisitado.
	
	GET pessoa - FindAll `<http://localhost:8080/api/pessoas>` --> Lista todas pessoas cadastradas.
	
	GET pessoa - MalaDireta `<http://localhost:8080/api/pessoas/maladireta/{ID}>` --> Encontra uma pessoa com o {ID} requisitado em versão mala direta.
	
	GET pessoa - MalaDiretaFindAll  `<http://localhost:8080/api/pessoas/maladireta>` --> Lista em versão Mala Direta todas pessoas cadastradas.
	
	### Contatos
	
	POST contato - save `<http://localhost:8080/api/contatos>` --> cria um contato e liga a uma pessoa.
	```
	{
 	"orderTipo": 0,
 	"contato": "(11) 12345-7890",
 	"pessoa" :{
 		"id": 1
    	}
	}
	```
	PUT contato - update `<http://localhost:8080/api/contatos/{ID}>`--> Atualiza um contato com o {ID} requisitado.
	```
	{
 	"orderTipo": 0,
 	"contato": "(11) 93635-7794"
	}
	```
	DELETE contato - delete `<http://localhost:8080/api/contatos/{ID}>` --> Deleta um contato com o {ID} requisitado.
	
	GET contato - findById `<http://localhost:8080/api/contatos/{ID}>` --> Encontra um contato com o {ID} requisitado.
	
	GET contato - findAll `<http://localhost:8080/api/contatos>` --> Lista todos contatos cadastrados.

	GET contato - findbyPessoa `<http://localhost:8080/api/contatos/pessoas/{ID}>` --> Lista todos contatos de uma pessoa.

## Métodos de validação de atributos

> Para garantir o melhor controle no tratamento de dados que o projeto recebe, foram implantadas validações em todos os atributos para que, assim, os dados que serão alocados no banco de dados seja apenas o correspondente com sua finalidade.

### Pessoas
- Nome: Não pode ser nulo | Deve ter mais de uma palavra (Nome completo) | Não pode possuir números | Deve ter no máximo 150 caracteres.
