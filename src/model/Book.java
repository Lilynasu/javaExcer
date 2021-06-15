package model;

public class Book {

	private String isbn;
	private String title;
	private int price;
	private String author;
	private String feature;
	
	public Book() {}

	public Book(String isbn, String title, int price, String author, String feature) {
		setIsbn(isbn);
		setTitle(title);
		setPrice(price);
		setAuthor(author);
		setFeature(feature);
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		if(isbn.equals("")) {
			throw new IllegalArgumentException("ISBNの値が不正です");
		}
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		if(title.equals("")) {
			throw new IllegalArgumentException("タイトルの値が不正です");
		}
		this.title = title;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		if(price < 0) {
			throw new IllegalArgumentException("価格の値が不正です");
		}
		this.price = price;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		if(author.equals("")) {
			throw new IllegalArgumentException("著者名の値が不正です");
		}
		this.author = author;
	}

	public String getFeature() {
		return feature;
	}

	public void setFeature(String feature) {
		if(feature.equals("")) {
			throw new IllegalArgumentException("特徴の値が不正です");
		}	
		this.feature = feature;
	}
	
	
	
	
	
}
