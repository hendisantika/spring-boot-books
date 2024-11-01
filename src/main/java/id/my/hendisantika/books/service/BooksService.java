package id.my.hendisantika.books.service;

import id.my.hendisantika.books.entity.Books;
import id.my.hendisantika.books.repository.BooksRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Project : books
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 01/11/24
 * Time: 07.57
 * To change this template use File | Settings | File Templates.
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class BooksService {

    private final BooksRepository bookRepository;

    public List<Books> getAllBooks() {
      log.info("Getting all books");
        return bookRepository.findAll();
    }

    public Books getBookById(Long id) {
        log.info("Getting book by id {}", id);
        return bookRepository.findById(id).orElse(null);
    }
}
