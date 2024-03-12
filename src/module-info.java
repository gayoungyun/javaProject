module javaProject {
	exports register.url;
	exports Member.dao;
	exports Member.service;
	exports Member.dto;
	exports Member.controller;
	exports Member.main;

	requires java.sql;
	requires javafx.base;
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;
}