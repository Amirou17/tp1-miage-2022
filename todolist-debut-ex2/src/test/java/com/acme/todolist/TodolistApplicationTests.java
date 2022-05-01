package com.acme.todolist;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import com.acme.todolist.configuration.TodolistApplication;
import com.acme.todolist.domain.TodoItem;

@SpringBootTest
@ContextConfiguration(classes = TodolistApplication.class)
public class TodolistApplicationTests {
 
	@Test
	public void contextLoads() {
	}
	  @Test 
	public void addLateInTodoItemContentTest() {
	     Instant inst = Instant.now().plus(-2, ChronoUnit.DAYS); 
	     TodoItem todoItem = new TodoItem("0f8-06eb17ba8d34",inst, "Test");
	     String result = "[LATE!] Test";
	     assertEquals(result, todoItem.finalContent());
	     
	}
  @Test 
	public void notAddLateInTodoItemContentTest() {
	     Instant inst = Instant.now(); 
	     TodoItem todoItem = new TodoItem("0f8-06eb17ba8d34",inst, "Test");
	     String result = "Test";
	     assertEquals(result, todoItem.finalContent());
	     
	}
  
}
