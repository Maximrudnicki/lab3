package Publishing.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import Publishing.models.Book;

@Component
public class BookDAO {

	private final JdbcTemplate jdbcTemplate;
	
	@Autowired
	public BookDAO(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public List<Book> index(){
		return jdbcTemplate.query("select * from books", new BeanPropertyRowMapper<>(Book.class));
	}
	
	public Book show(int id) {
		return jdbcTemplate.query("select * from books where id=?", new Object[] {id}, new BeanPropertyRowMapper<>(Book.class))
				.stream().findAny().orElse(null);
	}
	
	public void save(Book book) {
		jdbcTemplate.update("insert into books(name, author, year_of_publishing, amount, price) values(?,?,?,?,?)", book.getName(), 
				book.getAuthor(), book.getYear_of_publishing(), book.getAmount(), book.getPrice());
	}
	
	public void update(int id, Book updatedBook) {
		jdbcTemplate.update("UPDATE books SET name=?, author=?, year_of_publishing=?, amount=?, price=? WHERE id=?", 
				updatedBook.getName(), updatedBook.getAuthor(), updatedBook.getYear_of_publishing(),
				updatedBook.getAmount(), updatedBook.getPrice(), id);
	}
	
	public void delete(int id) {
		jdbcTemplate.update("delete from books where id=?", id);
	}
	
}
