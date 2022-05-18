package Publishing.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import Publishing.dao.BookDAO;
import Publishing.models.Book;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/books")
public class BooksController {

	private final BookDAO bookDAO;
	
	@Autowired
	public BooksController(BookDAO bookDAO) {
		this.bookDAO = bookDAO;
	}
	
	@GetMapping("")
	public String books(Model model) {
		model.addAttribute("books", bookDAO.index());
		return "books/books";
	}
	
	@GetMapping("/{id}")
	public String showBook(@PathVariable("id") int id, Model model){
		model.addAttribute("book", bookDAO.show(id));
		return "books/showBook";
	}
	
	@GetMapping("/new")
	public String newBook(Model model) {
		model.addAttribute("book", new Book());
		return "books/newBook";
	}
	
	@GetMapping("/{id}/edit")
	public String editBook(Model model, @PathVariable("id") int id) {
		model.addAttribute("book", bookDAO.show(id));
		return "books/editBook";
	}
	
	
	@PostMapping()
	public String add(@ModelAttribute("book") @Valid Book book, 
			BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "books/newBook";
		}
		
		bookDAO.save(book);
		return "redirect:/books";
	}
	
	@PatchMapping("/{id}")
	public String update(@ModelAttribute("book") @Valid Book book, 
			BindingResult bindingResult,@PathVariable("id") int id) {
		if (bindingResult.hasErrors()) {
			return "books/editBook";
		}
		
		bookDAO.update(id, book);
		return "redirect:/books";
	}
	
	
	@DeleteMapping("/{id}")
	public String delete(@PathVariable("id") int id) {
		bookDAO.delete(id);
		return "redirect:/books";
	}


}
