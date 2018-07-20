package library;

public class BookModel {
	
	private String id;
	private String title;
	private String publisher;
	private String yearPublished;
	private boolean status;
	public static int count = 0;
	
	public BookModel(String id, String title, String publisher, String yearPublished, boolean status) {
		this.id = id;
		this.title = title;
		this.publisher = publisher;
		this.yearPublished = yearPublished;
		this.status = status;
		count ++;
	}
	
	public String getID() {
		return this.id;
	}
	
	public boolean getStatus() {
		return this.status;
	}
	
	public void setStatus(boolean available) {
		this.status = available;
	}
	
	public String getTitle() {
		return this.title;
	}
	
	public String toString() {
		String status = "Available";
		if(!this.status) status = "Borrowed";
		return this.id + "  " + this.title + "  " + this.publisher + "  " + this.yearPublished + "  " + status;
	}

}
