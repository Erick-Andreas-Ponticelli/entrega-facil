# EntregaFácil — base da Etapa 1

Projeto-base de persistência para o Gerenciador de Trabalhos Acadêmicos. O código implementa as seis entidades de domínio JPA e seus repositórios Spring Data JPA, conforme o documento de concepção.

## O que está incluído

- Java 17 e Spring Boot 3.5.16.
- Entidades `Usuario`, `Disciplina`, `Trabalho`, `Comentario`, `Categoria` e `TrabalhoCategoria`.
- Relacionamentos JPA `@OneToMany` e `@ManyToOne`; a relação N:M entre trabalho e categoria usa a entidade associativa `TrabalhoCategoria`.
- Seis interfaces `JpaRepository`, com consultas derivadas para usuário, disciplina, prazo, situação e associação de categorias.
- Banco H2 em memória para execução local.

Esta base atende à modelagem e à camada de persistência da Etapa 1. Controladores REST, autenticação funcional, telas e publicação da aplicação ainda precisam ser desenvolvidos para transformar a base em um produto completo. Não use a senha em texto puro: o campo `senhaHash` foi preparado para receber somente um hash quando a autenticação for implementada.

## Requisitos para executar

Instale Java 17 ou superior e Maven 3.6.3 ou superior. A documentação oficial do Spring Boot 3.5 confirma esses requisitos.

No Windows, abra o terminal dentro desta pasta e execute:

```powershell
mvn spring-boot:run
```

O H2 é temporário: os dados são apagados quando a aplicação é encerrada. Enquanto o servidor estiver ativo, a console local fica em `http://localhost:8080/h2-console` com estes dados:

- JDBC URL: `jdbc:h2:mem:entregafacil`
- Usuário: `sa`
- Senha: deixe em branco

A console H2 está habilitada apenas para desenvolvimento local.

## Publicar no GitHub

1. Entre no GitHub e escolha **New repository**.
2. Use o nome `entregafacil`. Se a disciplina não especificar privacidade, deixe o repositório público para que o professor consiga acessá-lo.
3. Crie o repositório sem adicionar outro README, `.gitignore` ou licença, pois estes arquivos já estão nesta pasta.
4. No terminal, dentro desta pasta do projeto, execute os comandos abaixo, substituindo `SEU-USUARIO` pelo seu usuário do GitHub:

```powershell
git init
git add .
git commit -m "Entrega inicial do EntregaFacil"
git branch -M main
git remote add origin https://github.com/SEU-USUARIO/entregafacil.git
git push -u origin main
```

5. Copie a URL do repositório e cole no campo correspondente do documento de concepção. Preencha seu nome completo. Se não publicar a aplicação, informe `não publicada nesta etapa`.

## Observação para a entrega

O código-fonte deve ser revisado e completado conforme as instruções do professor. O link do repositório só existirá depois que você criar a página no GitHub e enviar estes arquivos.
