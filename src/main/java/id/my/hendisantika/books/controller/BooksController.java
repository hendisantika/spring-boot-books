package id.my.hendisantika.books.controller;

import id.my.hendisantika.books.entity.Books;
import id.my.hendisantika.books.service.BooksService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Project : books
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 01/11/24
 * Time: 07.58
 * To change this template use File | Settings | File Templates.
 */
@RestController
@RequestMapping("/api/books")
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class BooksController {

    private final BooksService booksService;

    @GetMapping
    public List<Books> getAllBooks() {
        return booksService.getAllBooks();
    }

    @GetMapping("/{id}")
    public Books getBookById(@PathVariable Long id) {
        return booksService.getBookById(id);
    }
}
