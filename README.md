### Backend

### Pré-Requisitos

- Java 11 instalado e definido nas variáveis de ambiente.
- Maven 3.9.6.

### Para executar

1. Navegue até o diretório do projeto.
2. Execute o comando `./mvnw spring-boot:run` para iniciar o servidor.

### Ficha Técnica

JAVA: Definido pelo teste como 11.

Spring Boot 2.5.9: LTS com suporte para jdk 11.

Lombok: Praticidade e facilidade de futuras implementações.

H2: Banco sugerido pelo teste.

Swagger: Facilitar a visualização dos endpoints expostos para integração com front-end

Slf4j log: Optei pelo Slf4j por atender ao que está sendo pedido e pensando na versatilidade em caso de implementação do logback. Não utilizei o antigo log4j por possuir vulnerabilidades, avisado no próprio site deles.

Specification na busca de taxa: Utilizei specification visando aumentar a flexibilidade e manutenção da busca pelas taxas, possiblitando a adição de novas colunas a serem consideradas nesta busca. 