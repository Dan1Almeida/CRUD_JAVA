# AppContatos

> Este projeto CRUD tem como principal objetivo cadastrar pessoas com seus atributos pertinentes e assim podendo cadastrar vários contatos ligados a esta pessoa. Podendo manipular os dados de diversas maneiras possíveis e servir como uma agenda de contatos.

---

## Índice

1. [Tecnologias Utilizadas](#tecnologias-utilizadas)
2. [Métodos de aplicação](#métodos-de-aplicação)
3. [Métodos de utilização de projeto](#métodos-de-utilização-de-projeto)
4. [Endpoints e métodos de entradas](#endpoints-e-métodos-de-entradas)
5. [Métodos de validação de atributos](#métodos-de-validação-de-atributos)
6. [Listas ENUM](#listas-enum)
7. [Resultados e Observações gerais](#resultados-e-observações-gerais)

## Tecnologias Utilizadas

Projeto Maven gerado em Start.spring.io

```
https://start.spring.io/
```

- **Tecnologias:**
 
	> Project: Maven | Language: Java | Spring Boot: 3.4.2 | Packaging: Jar | Java: 21

- **Metadada:**
  
	> Group: br.com.dnl | Artifact e Name: AppContatos | Package name: br.com.dnl.AppContatos

- **Dependências iniciais:**
  
	> Spring Web | Spring Data JPA | H2 Database 

- **Outras dependências:**
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
- **Ferramenta de desenvolvimento:**

	> Eclipse IDE for Java Developers - 2024-09

## Métodos de aplicação

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

- Acesso ao banco de dados H2:
  
```java
spring.datasource.url=jdbc:h2:mem:pessoas
spring.datasource.username=sa
```
  
- Visando ter a melhor localização de LOG personalizado no console, foi desabilitada a função de mostrar o SQL com a seguinte linha:
```java
spring.jpa.show-sql=false
```

- Utilizado o método para atualizar automaticamente o esquema do banco de dados com a seguinte linha:
```java
spring.jpa.hibernate.ddl-auto=update
```

## Métodos de utilização de projeto
  > Durante o desenvolvimento do projeto, foram utilizados dois métodos para testes de funcionamento do projeto e nos métodos endpoints requeridos.

---
  
**3.1 - Swagger:** Acessado através de navegador WEB, o Swagger já está com endpoints descritos e configurados, também documentado para melhor compreensão no momento de testes, devendo apenas alterar os padrões de métodos de entradas em POST e PUT. (Consulte como em [Endpoints e métodos de entradas](#endpoints-e-métodos-de-entradas))
  
**3.2 - Postman:** Na pasta raiz com o nome "PostAppContatos" se encontra o arquivo para importar ao programa, nele já está presente todos os endpoints com todos os exemplos de entradas de dados. Devendo apenas retornar o HttpStatus das requisições. De modo a evitar tempo gasto, já está presente também todas as validações de contatos separadamente por tipo.

## Endpoints e métodos de entradas
> Ao todo, o projeto apresenta [13] EndPoints, [2] POST de criação de entidade, [2] PUT de atualização de entidade, [2] DELETE para exclusão de entidade e [7] GET para buscar informações, isto tudo divido em [2] entidades, sendo elas PESSOAS e CONTATOS.

---

### 4.1 Pessoas :bust_in_silhouette:
:new: **POST pessoa - save**  `<http://localhost:8080/api/pessoas>` 

**--> Grava** uma nova pessoa.

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

:arrows_counterclockwise: **PUT pessoa - update** `<http://localhost:8080/api/pessoas/{id}>`

**--> Atualiza** uma pessoa com o {ID} requisitado, caso não haja é criado uma nova.

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
 
:x: **DELETE pessoa - delete** `<http://localhost:8080/api/pessoas/{ID}>`

**--> Deleta** uma pessoa com o {ID} requisitado.

	
:mag_right: **GET pessoa - FindByid** `<http://localhost:8080/api/pessoas/{ID}>` 

**--> Encontra** uma pessoa com o {ID} requisitado.

	
:mag_right: **GET pessoa - FindAll** `<http://localhost:8080/api/pessoas>`

**--> Lista** todas pessoas cadastradas.

	
:mag_right: **GET pessoa - MalaDireta** `<http://localhost:8080/api/pessoas/maladireta/{ID}>` 

**--> Encontra** uma pessoa com o {ID} requisitado em versão **Mala Direta.**

	
:mag_right: **GET pessoa - MalaDiretaFindAll**  `<http://localhost:8080/api/pessoas/maladireta>` 

**--> Lista** em versão **Mala Direta** todas pessoas cadastradas.

 ---
 
### 4.2 Contatos :phone:
	
:new: **POST contato - save** `<http://localhost:8080/api/contatos>` 

**--> Grava** um contato e liga a uma pessoa.
 
```java
	{
 	"orderTipo": 0,
 	"contato": "(11) 12345-7890",
 	"pessoa" :{
 		"id": 1
    		}
	}
```
 
:arrows_counterclockwise: **PUT contato - update** `<http://localhost:8080/api/contatos/{ID}>`

**--> Atualiza** um contato com o {ID} requisitado.
	
```java
	{
 	"orderTipo": 0,
 	"contato": "(11) 93635-7794"
	}

```

:x: **DELETE contato - delete** `<http://localhost:8080/api/contatos/{ID}>` 

**--> Deleta** um contato com o {ID} requisitado.

	
:mag_right: **GET contato - findById** `<http://localhost:8080/api/contatos/{ID}>` 

**--> Encontra** um contato com o {ID} requisitado.

	
:mag_right: **GET contato - findAll** `<http://localhost:8080/api/contatos>` 

**--> Lista** todos contatos cadastrados.


:mag_right: **GET contato - findbyPessoa** `<http://localhost:8080/api/contatos/pessoas/{ID}>` 

**--> Lista** todos contatos de uma **Pessoa.**


## Métodos de validação de atributos

> Para garantir o melhor controle no tratamento de dados que o projeto recebe, foram implantadas validações em todos os atributos para que, assim, os dados que serão alocados no banco de dados seja apenas o correspondente com sua finalidade.

---

### 5.1 Pessoas :bust_in_silhouette:
- **Nome:** Não pode ser nulo | Deve ter mais de uma palavra | Não pode possuir números | Deve ter no máximo 150 caracteres.
  > Exemplos: Daniel Silva | João pessoa neto | Arthur Conan Doyle
  
- **CPF:** Não pode ser nulo | Aceita apenas padrão de CPF com ponto e traço | Atributo com valor único.
  > Exemplos: 010.101.010-10 | 101.010.101-01
 
- **Tipo Logradouro:** Não pode ser nulo | Deve ser um tipo válido de logradouro, listado em ENUM. (Consulte as opções em [Listas ENUM](#listas-enum))
  > Exemplos: Rua | RUA | Avenida | AvEnIdA
  
- **Endereço:** Não pode ser nulo | Não pode possuir número | Deve ter no máximo 100 caracteres.
  > Exemplos: Vincent Van Gogh | Agatha Christie
  
- **Numero:** Não pode ser nulo | Deve ser um número inteiro entre 1 e 9999.
  > Exemplos: 1997 | 2025
  
- **CEP:** Não pode ser nulo | Aceita apenas padrão de CEP com traço.
  > Exemplos: 01010-101 | 10101-010
  
- **Cidade:** Não pode ser nulo | Deve ter no máximo 35 caracteres | Não pode possuir número.
  > Exemplos: São Paulo | Vila Bela da Santíssima Trindade
  
- **Unidade Federativa (UF):** Não pode ser nulo | Deve ser um tipo válido de UF, listado em ENUM. (Consulte as opções em [Listas ENUM](#listas-enum))
  > Exemplos: sp | SP | rJ | RJ 

---

### 5.2 Contatos :phone:
- **Tipo de Contato:** Não pode ser nulo | Deve ser um tipo válido entre 0 - 7, listado em ENUM. (Consulte as opções em [Listas ENUM](#listas-enum))
  > Exemplos: 0 | 7
  
- **Contato:** Neste atributo existem vários tipos de validações conforme o tipo de contato, como listado abaixo | Atributo com valor único.
   
	- **Escolha 0:** Aceita apenas no padrão contato de telefone residencial com DD e colchetes.
		> Exemplos: (11) 1010-1010 | (10) 0101-0101
  
   	- **Escolha 0 - 2:** Aceita apenas no padrão contato de telefone com DD e colchetes.
		> Exemplos: (11) 91010-1010 | (10) 90101-0101

	- **Escolha 3 - 4:** Aceita apenas no padrão e-mail, podendo ser @dominio.com, @dominio.com.br e @dominio.org.br 
   		> Exemplos: teste@teste.com | teste@teste.com.br | teste@teste.org.br

	-  **Escolha 5 :** Aceita apenas URL do padrão do LinkedIn
   		> Exemplos: https://www.linkedin.com/in/daniel-silva-almeida/

	- **Escolha 6 - 7:** Deve ter entre 3 e 15 caracteres | pode ter caracteres especiais.
   		> Exemplos: Gamer1234 | 1234Gamer


## Listas ENUM
  > Para controle de dados inseridos em campos com um número definido de escolhas, foram feitas listas de Enum, segue abaixo os campos.

---

### 6.1 Tipo de Logradouro (OrderLogradouro): 
Método de entrada String, onde compara a palavra que foi inserido com cada item da lista.

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

---

### 6.2 Unidade Federativa (OrderUf):
Método de entrada String, onde compara a sigla que foi inserido com cada item da lista.
   
```java
public enum OrderUf {
    
    AC("AC"), AL("AL"), AP("AP"), AM("AM"), BA("BA"), CE("CE"), DF("DF"), ES("ES"), GO("GO"), MA("MA"), 
    MT("MT"), MS("MS"), MG("MG"), PA("PA"), PB("PB"), PR("PR"), PE("PE"), PI("PI"), RJ("RJ"), RN("RN"), 
    RS("RS"), RO("RO"), RR("RR"), SC("SC"), SP("SP"), SE("SE"), TO("TO");
}
```

---

### 6.3 Tipo de contato (OrderTipo):
Método de entrada sendo Integer, onde cada número representa um tipo de contato e retorna ao usuário.

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

## Resultados e Observações gerais
> Este projeto tem como principal objetivo testar conhecimentos em java utilizando um CRUD e seu funcionamento como parâmetro. Após horas de desenvolvimento, pesquisas em documentos, sites e vídeos, o projeto se encontra com os seguintes _Status_:

---

### Objetivos Primários  

:white_check_mark: API documentada utilizando a biblioteca OpenAPI (Swagger)

:white_check_mark: Criação com Java com Spring Boot(Versão 3.4.2)

:white_check_mark: Utilização banco de dados H2 - Banco de dados em memória

:white_check_mark: Implantação de validações necessárias
      
:white_check_mark: CRUD de **Pessoas**

	- Criar Pessoa 
	- Atualizar pessoa por ID
	- Deletar pessoa por ID
	- Obter pesso por ID | Obter pessoa por ID para mala direta | Listar todas pessoas
  	      
:white_check_mark: CRUD de **Contatos**

	-  Adicionar um contato a uma pessoa
	-  Obter contatos por ID | Listar todos contatos de uma pessoa
  	-  Atualizar Contato por ID
  	-  Deletar Contato por ID
  	      
:white_check_mark: Criação da Entidade **Pessoas**

	- ID | Nome | Endereço | CEP | Cidade | UF
     
:white_check_mark: Criação da Entidade **Contatos**

	- ID | Tipo de contato | Contato | Relacionamento com a entidade pessoa

 :white_check_mark: Criação de uma **Dto Mala Direta**

---

### Objetivos Extras

:white_check_mark: Atributos Extras na entidade **Pessoas**

	- CPF | Tipo Logradouro | Número
       
:white_check_mark: Endpoint extra CRUD de **Pessoas**

	- Obter lista de pessoas para mala direta
       
:white_check_mark: Endpoint extra CRUD de **Contatos**

	- Lista todos contatos cadastrados 

:white_check_mark: Validação personalizada para cada tipo de contato

:white_check_mark: Atributos com valores únicos no banco de dados (CPF e Contato)

:white_check_mark: Controle extras de entradas de dados com ENUM (Tipo logradouro e Unidade Federativa)

:white_check_mark: LOGs personalizados no console para melhor compreensão.

:white_check_mark: Http Status em resource para futura comunicação com Front-end

---

### Observações gerais

- Projeto iniciado em **9 de fevereiro de 2025** | última modificação em **18 de fevereiro de 2025**.

- Utilizado como referência inicial o projeto **AppProdutos** desenvolvido em aula pelo professor Eduardo Henrique Marques Ferreira.
  
```
https://github.com/eduardohen1/Java2025JP202502/tree/main/AppProdutos
```  

- Projeto com escopo escalonável, como por exemplo, tipos de contatos e mais entidades ligadas à pessoa.

- Centralizado dentro do diretório **"Service"** todas as validações de ambas as entidades. (Com exceções de)
	- "Números" a validação de se o número é inteiro é feito no Model.
	- "OrderTipo" a validação se encontra direto no raio dos cadastros na mémoria entre 0 e 7.
   
 - Contribuindo com persistência de dados, foi colocado validações como `<@Pattern>` | `<@Size>` | `<Min>` | `<Max>` 

- Centralizado dentro do diretório **"Resource"** todas as possíveis respostas HttpStatus.
  
- O atributo **CPF** está presente no projeto visando criar uma pessoa **"única"** dentro do sistema, assim como utilizado em **Contato**.

- Foram criados e mantidos no projeto os **LOGs personalizados** a fim de melhorar a compreensão das respostas e ajudar no desenvolvimento.

- Toda documentação da API com  **OpenAPI(Swagger)** está presente nas classes Model e Resource de cada entidade.
  
- Ao excluir uma pessoa que esteja ligada a vários contatos, todos os contatos é excluído em consequência.

   	  

 

  	      
