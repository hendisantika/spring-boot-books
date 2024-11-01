package id.my.hendisantika.books.controller;

import id.my.hendisantika.books.entity.Books;
import id.my.hendisantika.books.repository.BookInstanceRepository;
import id.my.hendisantika.books.repository.BooksRepository;
import id.my.hendisantika.books.repository.CheckoutRepository;
import id.my.hendisantika.books.repository.UserRepository;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;

/**
 * Created by IntelliJ IDEA.
 * Project : books
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 01/11/24
 * Time: 08.23
 * To change this template use File | Settings | File Templates.
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class BooksControllerTest {
    static PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>(
            "postgres:17-alpine3.20"
    );
    @LocalServerPort
    private Integer port;
    @Autowired
    private BooksRepository booksRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BookInstanceRepository bookInstanceRepository;
    @Autowired
    private CheckoutRepository checkoutRepository;

    @BeforeAll
    static void beforeAll() {
        postgres.start();
    }

    @AfterAll
    static void afterAll() {
        postgres.stop();
    }

    @DynamicPropertySource
    static void configureProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", postgres::getJdbcUrl);
        registry.add("spring.datasource.username", postgres::getUsername);
        registry.add("spring.datasource.password", postgres::getPassword);
    }

    @BeforeEach
    void setUp() {
        RestAssured.baseURI = "http://localhost:" + port;
        checkoutRepository.deleteAll();
        bookInstanceRepository.deleteAll();
        userRepository.deleteAll();
        booksRepository.deleteAll();
    }

//    @Test
//    @Order(value = 1)
//    void testConnectionToDatabase() {
//        Assertions.assertNotNull(booksRepository);
//    }

    @Test
    void shouldGetAllCustomers() {
        List<Books> customers = List.of(
                new Books(null, "Jujutsu Kaisen", "Itadori Yuji", "2021"),
                new Books(null, "One Piece", "Eichiro Oda","1998"),
                new Books(null, "Dan Da Dan", "Hikari","2024")
        );
        booksRepository.saveAll(customers);

        given()
                .contentType(ContentType.JSON)
                .when()
                .get("/api/books")
                .then()
                .statusCode(200)
                .body(".", hasSize(3));
    }
}
