# # Turmaapp

É um mini CRUD feito em Spring Boot para representar as seguintes relações:
Um curso possui varias turmas
Uma turma possui varios blocos
Um bloco possui varias disciplinas

# Versão

1.0.0 - Projeto se encontra em seu estado inicial, porém a parte de delete se encontra em Cascata. 

## Pré-Requisitos

 - [Java 8](https://www.oracle.com/br/java/technologies/javase/javase-jdk8-downloads.html)
 - [Mysql](https://www.mysql.com/)

## Dependencias

 - [Spring Boot](https://spring.io/guides/gs/serving-web-content/) 
## Instalação
 - Clone o projeto
 - `git clone https://github.com/Andrebredadev/turma.git`
 - Maven Update
 - Troque o usuario e senha do banco de dados em src/main/resources/application.properties
 - Inicie a aplicação como Spring Boot App - 
## Try me
Acesse clicando [aqui](http://turmaapp.herokuapp.com/escola/) uma versão do projeto rodando.
## TODO
 - [ ] Retirar o delete de cascata e tratar os dados apenas retirando as FK de seus respectivos campos.
 - [ ] Tratar exceções. 
 - [ ] Adicionar paginas de erro.
## Explicação de Dependencias
Spring Boot tras tudo necessario para criar uma aplicação WEB na criaçào do projeto, por exemplo: Ao iniciar um projeto Spring ja se pode selecionar dependencia de conexào ao mysql, servidor web etc.
