Exemplo de módulos no Maven
=====================

Projeto simples, idéia de um ERP, que simula o uso de multi-módulos no Maven.

Organização do projeto foi divida nos três diretórios:

* erp: Projeto principal, nele consta a qual é a versão do principal, as definições dos módulos e as dependências globais do Projeto.

* rh: Módulo de Recursos Humanos (RH) do projeto ERP. Nesse módulo é definida a entidade Funcionario, que depende da API JPA/Hibernate;

* financeiro: Módulo Financeiro do projeto ERP. Esse módulo define uma classe responsável por realizar o lançamento de salário. Por isso ela depende da classe Funcionario, contido no módulo rh.

Ambos os módulos definem classes de testes (junit).
