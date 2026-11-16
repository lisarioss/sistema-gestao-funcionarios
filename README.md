
# Sistema de Gestão de Funcionários

Projeto desenvolvido para a implementação de um sistema de gestão de funcionários utilizando Java.

## Objetivo

Desenvolver uma solução para gerenciar funcionários, permitindo realizar operações de cadastro, consulta, atualização e exclusão.

## Tecnologias utilizadas

- Java 21
- Maven
- JUnit 5
- OpenAPI 3.0.3
- Swagger Editor

## Funcionalidades

- Cadastro de funcionários.
- Consulta de funcionário por ID.
- Listagem de funcionários.
- Atualização dos dados de funcionários.
- Exclusão de funcionários.
- Geração automática de identificadores.
- Validação dos dados.
- Tratamento de funcionário não encontrado.

## Armazenamento

Os dados são armazenados em memória utilizando a estrutura `Map` do Java.

## Testes

Os testes automatizados foram desenvolvidos com JUnit 5.

Para executar os testes, utilize:

```bash
mvn clean test
```

## Documentação da API

O contrato da API foi documentado utilizando OpenAPI 3.0.3.

Arquivo: `src/main/resources/openapi.yaml`

A documentação pode ser visualizada pelo Swagger Editor:

https://editor.swagger.io/

## Observação

O projeto implementa a camada de serviços e o armazenamento em memória, sem implementação de uma camada Web ou servidor HTTP.