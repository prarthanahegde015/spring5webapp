package guru.springframework.spring5webapp.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String title;
	private String isbn;
	
	@ManyToOne
	private Publisher publishers;
	
	@ManyToMany
	@JoinTable(name= "author_book", joinColumns = @JoinColumn(name ="book_id"),
	inverseJoinColumns = @JoinColumn(name = "author_id"))
	private Set<Author> authors = new HashSet<>();
	
	public Book() {
		
	}
	
	public Book(String title,String isbn) {
		this.title=title;
		this.isbn=isbn;
	}
	
	public Publisher getPublisher() {
		return publishers;
	}
	
	public void setPublisher(Publisher publishers) {
		this.publishers=publishers;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id=id;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title=title;
	}
	
	public String getIsbn() {
		return isbn;
	}
	
	public void setIsbn(String isbn) {
		this.isbn=isbn;
	}
	
	public Publisher getPublishers() {
		return publishers;
	}
	
	public void setPublishers(Publisher publishers) {
		this.publishers=publishers;
	}
	
	public Set<Author> getAuthors() {
		return authors;
	}
	
	public void setAuthors(Set<Author> authors) {
		this.authors=authors;
	}
	
	@Override
	public String toString() {
		return "Author {" +
				"id ="+id+
				",title = "+title + '\''+
				", isbn = "+isbn + '\''+
				
	'}';
	}
	@Override
	public boolean equals(Object o) {
		if(this== o) return true;
		if(o==null || getClass() !=o.getClass()) 
			return false;
		
		Book book = (Book) o;
		return id!=null ? id.equals(book.id) : book.id == null;
	}
	
	@Override
	public int hashCode() {
		return id!=null ? id.hashCode() : 0;
	}
}

