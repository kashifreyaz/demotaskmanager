# Task Manageer

A simple Task Manager application where a user can manage daily task. User should be able
categorize their task based on some label, prioritize their task based on predefined priority (Critical, High,
Medium, Low).

## Installation

### Prerequisites
1) IDE(Eclipse recommended)
2) Java (1.8 recommended)
3) MySQL

### Procdure
1) Download the Project source code.
2) Import the project to IDE(Eclipse recommended) 
3) Goto taskmanager->src/main/resource -- Execute ddl and dml sql(Make sure mysql server didn't have database named testtaskmanager).
4) Goto taskmanager->src/main/resource->application.properties and change spring.datasource.username={mysql server username} spring.datasource.password={mysql server password}
5) Goto taskmanager->src/main/java->com.demo.taskmanager->TaskManager.java
	Run TaskManager.java as java application (make sure no other application is running on port 8080)


## Usage

1) Label

URL->localhost:8080/label/save   
Request Type->POST   
Description->Will save the category of task.   
Request Body Type->JSON   
Request Body->{
"name":{label name}
}   
Response->{true}   

URL->localhost:8080/label/getall   
Request Type->GET   
Description->Will list all the category of task.   
Response->[
{
"id": {label id},
"name": {label name}
}
]   

URL->localhost:8080/label/get/{id}   
Request Type->GET   
Description->Will return the category of task of pirticular id.   
Response->{
"id": {id},
"name": {label name}
}   

URL->localhost:8080/label/update/{id}   
Request Type->PUT   
Description->Will update the category of task of pirticular id.   
Request Body Type->JSON   
Request Body->{
"name":{label name}
}   
Response->true or false   


URL->localhost:8080/label/delete/{id}   
Request Type->DELETE   
Description->Will delete the category of task of pirticular id.    
Response->true or false   

2) Priority

Predefined Priorities:{
{name(value)}
Low(1)
Medium(2)
High(3)
Critical(4)
}   

URL->localhost:8080/priority/save   
Request Type->POST   
Description->Will save the priority.   
Request Body Type->JSON   
Request Body->{
"name":{priority name},
"value":{priority value}
}   
Response->{true}    

URL->localhost:8080/priority/getall   
Request Type->GET   
Description->Will list all the priorities.   
Response->[
{
"id": {priority id},
"name": {priority name},
"value":{priority value}
}
]    

URL->localhost:8080/priority/get/{id}   
Request Type->GET   
Description->Will return the priority of pirticular id.   
Response->{
"id": {id},
"name": {priority name},
"value":{priority value}
}   

URL->localhost:8080/priority/update/{id}   
Request Type->PUT   
Description->Will update the priority of pirticular id.   
Request Body Type->JSON   
Request Body->{
"name":{priority name},
"value":{priority value}
}   
Response->true or false   


URL->localhost:8080/priority/delete/{id}   
Request Type->DELETE   
Description->Will delete the priority of pirticular id.   
Response->true or false   

3) Task

URL->localhost:8080/task/save   
Request Type->POST   
Description->Will save the task.   
Request Body Type->JSON   
Request Body->{
"name":{task name},
"priority":{
"id":{priority id}
},
"label":{
"id":{label id}
},
"taskDate":"YYYY-MM-DD"
}   
Response->{true}   

URL->localhost:8080/task/getall   
Request Type->GET   
Description->Will list all the tasks.    
Response->[
{
"id": {task id},
"name": {Task name},
				"label": {
					"id": {label id},
					"name": {label name}
				},
				"taskDate": 1558742400000,
				"priority": {
					"id": {priority id},
					"name": {priority name},
					"value": {priority value}
				},
				"status": 1
			}
		]   

URL->localhost:8080/task/get/{id}   
Request Type->GET   
Description->Will return task of pirticular id.   
Response->{
				"id": {task id},
				"name": {Task name},
				"label": {
					"id": {label id},
					"name": {label name}
				},
				"taskDate": 1558742400000,
				"priority": {
					"id": {priority id},
					"name": {priority name},
					"value": {priority value}
				},
				"status": 1
			}   
		
URL->localhost:8080/task/update/{id}   
Request Type->PUT   
Description->Will update the task of pirticular id.   
Request Body Type->JSON   
Request Body->{
				"name": {Task name},
				"label": {
					"id": {label id}
				},
				"taskDate": {YYYY-MM-DD},
				"priority": {
					"id": {priority id}
				}
			}   
Response->true or false   


URL->localhost:8080/task/delete/{id}   
Request Type->DELETE   
Description->Will delete the task of pirticular id.   
Response->true or false   

URL->localhost:8080/task/getbyfilter   
Request Type->GET   
Description->Will list the tasks matching request body.   
Request Body Type->JSON   
Request Body->{
				"label":{label name}, // to fetch tasks of pirticular label   
				"priority":[{priority name}], // to fetch tasks from priorities   
				"dayRange":{integer value}, // to fetch tasks in day duration e.g: for next 2 days value should be 2 , for previous 4 days value should be -4 and for current day value should be 0   
			}   
Response->true or false   
