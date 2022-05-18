package Publishing.models;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class Book {

	private int id;
	
	@NotEmpty(message = "Should not be empty!")
    @Size(min = 2, max = 30, message = "Name should be between 2 and 30 characters!")
	private String name;
	
    @Size(min = 2, max = 100, message = "Name should be between 2 and 350 characters!")
	private String author;
	
	@NotEmpty(message = "Should not be empty!")
	private int year_of_publishing;
	
	@NotEmpty(message = "Should not be empty!")
	private int amount;
	
	@NotEmpty(message = "Should not be empty!")
	private double price;

	public Book() {
		
	}
	
	public Book(int id, String name, String author, int year_of_publishing, int amount, double price) {
		this.id = id;
		this.name = name;
		this.author = author;
		this.year_of_publishing = year_of_publishing;
		this.amount = amount;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
	
	public int getYear_of_publishing() {
		return year_of_publishing;
	}

	public void setYear_of_publishing(int year_of_publishing) {
		this.year_of_publishing = year_of_publishing;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	
}
