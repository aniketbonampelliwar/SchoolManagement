<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Student Data</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<style>
.add-btn{
border-radius:25px;
font-size:20px;
height:50px;
width:210px;
background-color:#white;
text-color:white;
margin-left:77%

}
h1{
margin-top:20px;
margin-left:5px;
margin-bottom:10px;
}

a{
text-decoration:none;
}
.add{
display:flex;
align-items:center;
justify-content:left;

}
h1.add{
margin-left:4%;
}

.btn{
margin-left:38%;
}
</style>

</head>
<body>
	<div class = "add">
    <h1>Student Details:</h1>
    <div class = "btn"> <button type = "submit" class = "add-btn" ><a href = "index.html"><b>Add New Student</b></a></button>
    </div>
    </div>
    <table class = "table table-bordered">
        <tr>
            <th>ID</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Mother's Name</th>
            <th>Father's Name</th>
        </tr>
        
        <c:forEach var="student" items="${studentList}">
            <tr>
                <td>${student.id}</td>
                <td>${student.firstName}</td>
                <td>${student.lastName}</td>
                <td>${student.motherName}</td>
                <td>${student.fatherName}</td>
                <td><a href = "edit?id=${student.id}" class = "btn btn-primary">Edit</a>
                <td><a href = "delete?id=${student.id}" class = "btn btn-danger">Delete</a>
            </tr>
        </c:forEach>
    </table>
   
</body>
</html>
