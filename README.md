<h1 align="center">:file_cabinet: Pizzaria ONLINE</h1> 

## :memo: Bem vindo(a) à pasta correspondente à nossa pizzaria online.

Este projeto foi desenvolvido como atividade complementar para a matéria de Aplicação de Linguagem de Programação Orientada a Objetos (ALPOO)
do quarto semestre, do curso Ciência da Computação.

O objetivo deste projeto é simular um site de compra e venda de pizza e bebidas de forma online e automática.
Desenvolvido em Java com springboot, thymeleaf e banco de dados H2, o usuário acessa o site, faz a seleção dos itens que gostaria de pedir e adiciona em seu carrinho. Ao entrar em finalizar compra, é apresentada a opção de criar conta ou fazer login, através desta o usuário cadastra seus dados e seu endereço, que pode ou não ser utilizado como endereço de entrada ao final de sua compra.
Projeto inicialmente simplificado com implementações e melhorias significativas previstas para o futuro. 

## :wrench: Tecnologias utilizadas
* Linguagem Java
* IDE VSCODE
* SPRINGBOOT MVC
* H2- DB
* THYMELEAF
  
## :rocket: Rodando o projeto

Para completa e garantida execução do código, recomendamos o uso das ferramentas abaixo, pois foram usadas durante o desenvolvimento:
- [Visual Studio Code](https://code.visualstudio.com)
- [Java](https://www.java.com/pt-BR/download/ie_manual.jsp?locale=pt_BR)
- [Spring Boot Extension Pack](https://marketplace.visualstudio.com/items?itemName=vmware.vscode-boot-dev-pack)
- [JDK 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)

Fazer o download do projeto e abrir a pasta completa com a IDE VS Code. 
Utilizando a extensão do SpringBoot (disponível na barra à esquerda), clicar em "Run" para subir a aplicação. 

Para vizualição web, acesse [http://localhost:8080](http://localhost:8080) e navegue na nossa página inicial. 

Também é possível acessar o banco de dados na memória pelo [http://localhost:8080/h2-console](http://localhost:8080/h2-console), preenchendo:
- JDBC URL: jdbc:h2:mem:pizzaria
- User Name: teste
- Password: teste

Vale lembrar que o programa deve estar sendo executado para obter sucesso acessando ambos os links.

## :books: Funcionalidades

* <b>Funcionalidade 1</b>: Apresentação da página inicial da Pizzaria ONLINE, onde é solicitado o login ou cadastro do novo cliente com seus dados. 
* <b>Funcionalidade 2</b>: Ao ser redirecionado para a loja online, é possível escolher entre os sabores de pizzas e bebidas para seu pedido. 
* <b>Funcionalidade 3</b>: Ao entrar em realizar pagamento, é confirmado os dados do cliente, podendo alterar o endereço de entrega para um endereço diferente do cadastrado ao criar a conta.
* <b>Funcionalidade 4</b>: É possível verificar todos os dados de pedidos, dos clientes e etc dentro do banco de dados como mostrado anteriormente.

## :soon: Implementação futura
* <b>React</b>: Aplicação de um método mais sofisticado, onde é possível colocar linguagens diferentes no site, implementar criptografias para o usuário e senha ao salvar no banco de dados, entre diversas outras funcionalidades

## :handshake: Colaboradores
<table>
  <tr>
    <td align="center">
      <a href="https://github.com/ToxicOtter">
        <img src="https://avatars.githubusercontent.com/u/56259137?v=4" width="100px;" alt="Foto de Toxic Otter no GitHub"/><br>
        <sub>
          <b>Luan Lima Lopes</b>
        </sub>
      </a>
    </td>
    <td align="center">
      <a href="https://github.com/IsaacKralik">
        <img src="https://avatars.githubusercontent.com/u/56259137?v=4" width="100px;" alt="Foto de Isaac Kralik no GitHub"/><br>
        <sub>
          <b>Isaac Kralik</b>
        </sub>
      </a>
    </td>
     <td align="center">
      <a href="https://www.linkedin.com/in/joão-cardoso-769a531b9/">
        <img src="https://avatars.githubusercontent.com/u/56259137?v=4" width="100px;" alt="Foto de João Augusto no GitHub"/><br>
        <sub>
          <b>João Augusto</b>
        </sub>
      </a>
    </td>
  </tr>
</table>
