package id.my.hendisantika.books.service;

import id.my.hendisantika.books.entity.Books;
import id.my.hendisantika.books.repository.BooksRepository;
import lombok.RequiredArgsConstructor;
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
@Service
@RequiredArgsConstructor
public class BooksService {

    private final BooksRepository bookRepository;

    public List<Books> getAllBooks() {
        return bookRepository.findAll();
    }

    public Books getBookById(Long id) {
        return bookRepository.findById(id).orElse(null);
    }
}
