package bean;

public class Book {
	private Integer id;
	private String bookname;
	private String author;
	private double price;
	private String desca;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getDesca() {
		return desca;
	}
	public void setDesca(String desca) {
		this.desca = desca;
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", bookname=" + bookname + ", author=" + author + ", price=" + price + ", desca="
				+ desca + "]";
	}
	public Book(String bookname, String author, double price, String desca) {
		this.bookname = bookname;
		this.author = author;
		this.price = price;
		this.desca = desca;
	}
	public Book(Integer id, String bookname, String author, double price, String desca) {
		this.id = id;
		this.bookname = bookname;
		this.author = author;
		this.price = price;
		this.desca = desca;
	}
	public Book() {
	}
	
	
}
