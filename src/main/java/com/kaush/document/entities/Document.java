package com.kaush.document.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class Document {

	@Id
	private long id; 
	private String name;
	@Lob  // this is for large object | this will represent blob field in db(BLOB represent by byte -> binary large object)
	private byte[] data;  

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

}
