package sample.spring.domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Review {
	
	private String id;
	private String title;
	private Date createdDate;
	private String summary;
	
	private SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
	
	public Review(){
		
	}
	
	public Review(String id, String title, String summary, String date) throws ParseException{
		this.id = id;
		this.title = title;
		this.summary = summary;
		this.createdDate = format.parse(date);
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getCreatedDate() {
		return format.format(createdDate);
	}
	
	public void setCreatedDate(String created) throws ParseException {
		this.createdDate = format.parse(created);
	}
	
	public String getSummary() {
		return summary;
	}
	
	public void setSummary(String summary) {
		this.summary = summary;
	}
	

	public String toString(){
		StringBuilder value = new StringBuilder("ReviewEntry(");
		value.append("Id: ");
		value.append(id);
		value.append(",Title: ");
		value.append(title);
		value.append(",Summary: ");
		value.append(summary);
		value.append(",Created date: ");
		value.append(getCreatedDate());
		value.append(")");
		return value.toString();
	}
}
