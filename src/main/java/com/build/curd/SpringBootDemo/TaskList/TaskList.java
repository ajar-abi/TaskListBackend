package com.build.curd.SpringBootDemo.TaskList;

import java.util.ArrayList;

import org.bson.Document;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.build.curd.SpringBootDemo.db.TaskListDB;
import com.mongodb.client.FindIterable;
@CrossOrigin
@RestController
public class TaskList {
	TaskListDB taskdb = new TaskListDB();
	
	
	@PostMapping("/addList")
	public String addList(@RequestParam(name = "taskid") String taskid, @RequestParam(name = "taskName") String taskName) {
		return taskdb.addList(taskid, taskName);
	}
	
	@GetMapping("/viewList")
	public ArrayList viewList() {
		return taskdb.viewList();
	}
	
	@PostMapping("/deleteTask")
	public String deleteTask(@RequestParam(name = "taskid") String taskid) {
		return taskdb.deletetask(taskid);
	}
	
	

}

