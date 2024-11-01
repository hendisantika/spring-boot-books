package id.my.hendisantika.books.repository;

import id.my.hendisantika.books.entity.Books;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by IntelliJ IDEA.
 * Project : books
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 01/11/24
 * Time: 07.56
 * To change this template use File | Settings | File Templates.
 */
@Repository
public interface BooksRepository extends JpaRepository<Books, Long> {
}
