package com.shagie.dbtest.db.objects;

public class Data {
	final private int id;
	final private String txt;

	public Data(int id, String txt) {
		this.id = id;
		this.txt = txt;
	}

	public int getId() {
		return id;
	}

	public String getTxt() {
		return txt;
	}
}
