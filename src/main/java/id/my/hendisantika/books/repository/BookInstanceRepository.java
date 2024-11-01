package id.my.hendisantika.books.repository;

import id.my.hendisantika.books.entity.BookInstance;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by IntelliJ IDEA.
 * Project : books
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 01/11/24
 * Time: 08.44
 * To change this template use File | Settings | File Templates.
 */
public interface BookInstanceRepository extends JpaRepository<BookInstance, Long> {
}
