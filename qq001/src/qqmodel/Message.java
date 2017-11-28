package qqmodel;

import java.io.Serializable;

public class Message implements Serializable{
	private qqUser to;
	private qqUser from;
	private String time;
	private String type;
	private String content;
	/**
	 * @return the to
	 */
	public qqUser getTo() {
		return to;
	}
	/**
	 * @param to the to to set
	 */
	public void setTo(qqUser to) {
		this.to = to;
	}
	/**
	 * @return the from
	 */
	public qqUser getFrom() {
		return from;
	}
	/**
	 * @param from the from to set
	 */
	public void setFrom(qqUser from) {
		this.from = from;
	}
	/**
	 * @return the time
	 */
	public String getTime() {
		return time;
	}
	/**
	 * @param time the time to set
	 */
	public void setTime(String time) {
		this.time = time;
	}
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}
	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}

	public Message() {
		super();
	}
	public Message(qqUser to, qqUser from, String time, String type, String content) {
		super();
		this.to = to;
		this.from = from;
		this.time = time;
		this.type = type;
		this.content = content;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Message [to=" + to + ", from=" + from + ", time=" + time + ", type=" + type + ", content=" + content
				+ "]";
	}
	
}
