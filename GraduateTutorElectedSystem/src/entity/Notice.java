package entity;

import java.util.Date;

public class Notice {
private Date time;
private String title;
private String content;
public Date getTime() {
	return time;
}
public void setTime(Date time) {
	this.time = time;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getContent() {
	return content;
}
public void setContent(String content) {
	this.content = content;
}

}
