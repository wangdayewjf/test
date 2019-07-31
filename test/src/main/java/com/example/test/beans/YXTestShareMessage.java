package com.example.test.beans;

import lombok.Data;

import java.io.Serializable;

@Data
public class YXTestShareMessage implements Serializable {
	private String title;
	private String content;
	private String minImgUrl;
	private String articleUrl;
}
