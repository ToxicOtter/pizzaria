# Site da nossa Pizzaria

Bem vindo(a) à pasta correspondente à nossa pizzaria online.

Este projeto foi desenvolvido como atividade complementar para a matéria de Aplicação de Linguagem de Programação Orientada a Objetos (ALPOO)
do quarto semestre, do curso Ciência da Computação.

O objetivo deste projeto é simular um site de compra e venda de pizza e bebidas de forma online e automática.
Desenvolvido em Java com springboot, thymeleaf e banco de dados H2, o usuário acessa o site, faz a seleção dos itens que gostaria de pedir e adiciona em seu carrinho. Ao entrar em finalizar compra, é apresentada a opção de criar conta ou fazer login, através desta o usuário cadastra seus dados e seu endereço, que pode ou não ser utilizado como endereço de entrada ao final de sua compra.
Projeto inicialmente simplificado com implementações e melhorias significativas previstas para o futuro. 

## Instalação
Para completa e garantida execução do código, recomendamos o uso das ferramentas abaixo, pois foram usadas durante o desenvolvimento:
- [Visual Studio Code](https://code.visualstudio.com)
- [Java](https://www.java.com/pt-BR/download/ie_manual.jsp?locale=pt_BR)
- [Spring Boot Extension Pack](https://marketplace.visualstudio.com/items?itemName=vmware.vscode-boot-dev-pack)
- [JDK 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)

## Utilização
Fazer o download do projeto e abrir a pasta completa com a IDE VS Code. 
Utilizando a extensão do SpringBoot (disponível na barra à esquerda), clicar em "Run" para subir a aplicação. 

Para vizualição web, acesse [http://localhost:8080](http://localhost:8080) e navegue na nossa página inicial. 

Também é possível acessar o banco de dados na memória pelo [http://localhost:8080/h2-console](http://localhost:8080/h2-console), preenchendo:
- JDBC URL: jdbc:h2:mem:pizzaria
- User Name: teste
- Password: teste

Vale lembrar que o programa deve estar sendo executado para obter sucesso acessando ambos os links.
## Autores
- [@ToxicOtter](https://github.com/ToxicOtter)
- [@IsaacKralik](https://github.com/IsaacKralik)
- [@João](https://www.linkedin.com/in/joão-cardoso-769a531b9/)