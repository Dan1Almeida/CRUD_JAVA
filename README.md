# AppContatos

> Este projeto CRUD tem como principal objetivo cadastrar pessoas com seus atributos pertinentes e assim podendo cadastrar vários contatos ligados a esta pessoa. Podendo manipular os dados de diversas maneiras possíveis e servir como uma agenda de contatos.

---
## 1. Tecnologias Utilizadas

Projeto Maven gerado em Start.spring.io

```
https://start.spring.io/
```

- **Tecnologias:**
Project: Maven | Language: Java | Spring Boot: 3.4.2 | Packaging: Jar | Java: 21

- **Metadada:**
Group: br.com.dnl | Artifact e Name: AppContatos | Package name: br.com.dnl.AppContatos

- **Dependências iniciais:**
Spring Web | Spring Data JPA | H2 Database 

- 	**Outras dependências:**
```java
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

---
##  2. Métodos de aplicação 

- Porta utilizada para a inicialização do projeto
```
https://localhost:8080:
```
- Documentação **OpenApi Swagger**
```
https://localhost:8080:/swagger-ui.html
```

- Banco de dados em memória **H2**
```
http://localhost:8080/h2-console
```

- Acesso ao banco de dados H2: `<spring.datasource.url=jdbc:h2:mem:pessoas spring.datasource.username=sa>`
  
- Visando ter a melhor localização de LOG personalizado no console, foi desabilitada a função de mostrar o SQL com a seguinte linha: `<spring.jpa.show-sql=false>`
  
- Utilizado o método para atualizar automaticamente o esquema do banco de dados com a seguinte linha `<spring.jpa.hibernate.ddl-auto=update>`

---
## 3. Métodos de utilização de projeto
  > Durante o desenvolvimento do projeto, foram utilizados dois métodos para testes de funcionamento de projeto e nos métodos endpoints requeridos.
  
**3.1 Swagger:** Presente com todos os endpoints do projeto, devendo alterar alguns padrões de métodos de entradas em POST e PUT.
  
**3.2 Postman:** Na pasta raiz com o nome "PostAppContatos" se encontra o arquivo para utilizar no programa, nele já está presente todos os endpoints com todos os exemplos de entradas de dados.

---
## 4. Endpoints e métodos de entradas

  ### 4.1 Pessoas
:new: **POST pessoa - save**  `<http://localhost:8080/api/pessoas>` --> criar uma pessoa.

```java
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
 
:arrows_counterclockwise: **PUT pessoa - update** `<http://localhost:8080/api/pessoas/{id}>` --> Atualiza uma pessoa com o {ID} requisitado, caso não haja é criado uma nova.

```java
	{
    		"nome": "Daniel Santos",
    		"cpf": "010.101.010-11",
    		"orderLogradouro": "Avenida",
    		"endereco": "Agatha Christie",
    		"numero": 2,
    		"cep": "10101-010",
    		"cidade": "Rio de Janeiro",
    		"orderUf": "RJ"
	}
```
 
:x: **DELETE pessoa - delete** `<http://localhost:8080/api/pessoas/{ID}>` --> Deleta uma pessoa com o {ID} requisitado.
	
:mag_right: **GET pessoa - FindByid** `<http://localhost:8080/api/pessoas/{ID}>` --> Encontra uma pessoa com o {ID} requisitado.
	
:mag_right: **GET pessoa - FindAll** `<http://localhost:8080/api/pessoas>` --> Lista todas pessoas cadastradas.
	
:mag_right: **GET pessoa - MalaDireta** `<http://localhost:8080/api/pessoas/maladireta/{ID}>` --> Encontra uma pessoa com o {ID} requisitado em versão mala direta.
	
:mag_right: **GET pessoa - MalaDiretaFindAll**  `<http://localhost:8080/api/pessoas/maladireta>` --> Lista em versão Mala Direta todas pessoas cadastradas.
	
### 4.2 Contatos
	
:new: **POST contato - save** `<http://localhost:8080/api/contatos>` --> cria um contato e liga a uma pessoa.
 
```java
	{
 	"orderTipo": 0,
 	"contato": "(11) 12345-7890",
 	"pessoa" :{
 		"id": 1
    		}
	}
```
 
:arrows_counterclockwise: **PUT contato - update** `<http://localhost:8080/api/contatos/{ID}>`--> Atualiza um contato com o {ID} requisitado.
	
```java
	{
 	"orderTipo": 0,
 	"contato": "(11) 93635-7794"
	}

```

:x: **DELETE contato - delete** `<http://localhost:8080/api/contatos/{ID}>` --> Deleta um contato com o {ID} requisitado.
	
:mag_right: **GET contato - findById** `<http://localhost:8080/api/contatos/{ID}>` --> Encontra um contato com o {ID} requisitado.
	
:mag_right: **GET contato - findAll** `<http://localhost:8080/api/contatos>` --> Lista todos contatos cadastrados.

:mag_right: **GET contato - findbyPessoa** `<http://localhost:8080/api/contatos/pessoas/{ID}>` --> Lista todos contatos de uma pessoa.

## 4.Métodos de validação de atributos

> Para garantir o melhor controle no tratamento de dados que o projeto recebe, foram implantadas validações em todos os atributos para que, assim, os dados que serão alocados no banco de dados seja apenas o correspondente com sua finalidade.

### Pessoas
1. **Nome:** Não pode ser nulo | Deve ter mais de uma palavra | Não pode possuir números | Deve ter no máximo 150 caracteres.
  
2. **CPF:** Não pode ser nulo | Aceita apenas padrão de CPF (010.101.010-10) | Atributo com valor único.
 
3. **Tipo Logradouro:** Não pode ser nulo | Deve ser um tipo válido de logradouro, listado em ENUM.
  
4. **Endereço:** Não pode ser nulo | Não pode possuir número | Deve ter no máximo 100 caracteres.
  
5. **Numero:** Não pode ser nulo | Deve ser um número inteiro entre 1 e 9999.
  
6. **CEP:** Não pode ser nulo | Aceita apenas padrão de CEP (01010-101).
  
7. **Cidade:** Não pode ser nulo | Deve ter no máximo 35 caracteres | Não pode possuir número.
  
8. **Unidade Federativa (UF):** Não pode ser nulo | Deve ser um tipo válido de UF, listado em ENUM.

### Contatos
1. **Tipo de Contato:** Não pode ser nulo | Deve ser um tipo válido entre 0 - 7, listado em ENUM.
  
2. **Contato:** Neste atributo existem vários tipos de validações conforme o tipo de contato, como listado abaixo | Atributo com valor unico.
   
	> **Escolha 0 - 2:** Aceita apenas no padrão contato de telefone com DD e colchetes. | (11) 90000-0000

	> **Escolha 3 - 4:** Aceita apenas no padrão e-mail, podendo ser @dominio.com, @dominio.com.br e @dominio.org.br |

	>  **Escolha 5 :** Aceita apenas URL do padrão do LinkedIn |

	> **Escolha 6 - 7:** Deve ter entre 3 e 15 caracteres e não pode ter caracteres especiais. |

---
## 5. Listas ENUM
  > Para controle de dados inseridos em campos com um número definido de escolhas, foram feitas lista de Enum, segue abaixo os campos.

**5.1 Tipo de Logradouro:** Método de entrada String, onde compara a palavra que foi inserido com cada item da lista.

```java
public enum OrderLogradouro {
	RUA("Rua"),
	AVENIDA("Avenida"),
	ESTRADA("Estrada"),
	TRAVESSA("Travessa"),
	VILA("Vila"),
	QUADRA("Quadra");
}
```

**5.2 Unidade Federativa (UF):**  Método de entrada String, onde compara a sigla que foi inserido com cada item da lista.
   
```java
public enum OrderUf {
    
    AC("AC"), AL("AL"), AP("AP"), AM("AM"), BA("BA"), CE("CE"), DF("DF"), ES("ES"), GO("GO"), MA("MA"), 
    MT("MT"), MS("MS"), MG("MG"), PA("PA"), PB("PB"), PR("PR"), PE("PE"), PI("PI"), RJ("RJ"), RN("RN"), 
    RS("RS"), RO("RO"), RR("RR"), SC("SC"), SP("SP"), SE("SE"), TO("TO");
}
```

**5.3 Tipo de contato**:  Método de entrada sendo Integer, onde cada número representa um tipo de contato e retorna ao usuário.

```java
public enum OrderTipo {
	
	Residencial(0),
	celular(1),
	Tel_Profissional(2),
	email_pessoal(3),
	email_profissional(4),
	linkedin(5),
	XboxLive(6),
	PSN(7);
}
```

