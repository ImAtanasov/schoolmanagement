# School Management API

This API allows you to manage students, teachers, courses, and groups in a school management system. 
Below are the `curl` commands to demonstrate the functionalities of the REST APIs. Basic CRUD operations are not mentioned below, being intuitive enough. Automatic creation of tables and inserting dummy data is done at init. 
Tests are covering just some parts of the units, just for demonstrating purpose. 

###Starting
1. From UI - running main in SchoolmanagementApplication. 
Tests:
Running test class from the test class itself
2. Maven
```sh
mvn spring-boot:run
```
Run tests
```sh
mvn test
```


## Example API calls

How many students we have

```sh
curl -X GET http://localhost:8080/students/count
```

How many teachers we have
```sh
curl -X GET http://localhost:8080/teachers/count
```

How many courses by type we have
```sh
curl -X GET http://localhost:8080/courses/count-by-type
```

Which students participate in a specific course
```sh
curl -X GET http://localhost:8080/students/course/{courseName}

curl -X GET http://localhost:8080/students/course/Course2
```

Which students participate in a specific group
```sh
curl -X GET http://localhost:8080/students/group/{groupName}

curl -X GET http://localhost:8080/students/group/GroupA
```

Find all students for a specific group and course
```sh
curl -X GET http://localhost:8080/students/{groupName}/{courseName}

curl -X GET http://localhost:8080/students/GroupA/Course7
```


Find all teachers for a specific group and course
```sh
curl -X GET http://localhost:8080/teachers/{groupName}/{courseName}

curl -X GET http://localhost:8080/teachers/GroupA/Course7
```

Find all teachers and students for a specific group and course
```sh
curl -X GET http://localhost:8080/common/groups/{groupName}/courses/{courseName}/members


curl -X GET http://localhost:8080/common/groups/GroupB/courses/Course1/members
```

Find all students older than a specific age and participate in a specific course
```sh
curl -X GET http://localhost:8080/students/age/{age}/course/{courseName}

curl -X GET http://localhost:8080/students/age/20/course/Course7
```