<%@ taglib prefix = "form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>

<head>
<title>Student Registration Form</title>

</head>

<body>

     <form:form action="processForm" modelAttribute="student">
     
     First Name: <form:input path="firstName" />
     <br><br>
     
     Last  Name: <form:input path="lastName" />
     <br><br>
     
     <input type="submit" value="Submit"/>
     
     <br><br>
     
     <!-- Add a drop-down list option/ populate from class  -->
     Country:
     
     <form:select path="country">
     
     	<form:options items= "${student.countryOptions}" />
     	<!--  
     	<form:option value="France" label="France" />
     	<form:option value="Germany" label="Germany" />
     	<form:option value="India" label="India" />
         -->
     </form:select>
     
     <br><br>
     <!-- Add a radio-button -->
     Favorite Language:
      
     Java <form:radiobutton path="favoriteLanguage" value="Java"/>
	 C#   <form:radiobutton path="favoriteLanguage" value="C#"/>
	 PHP  <form:radiobutton path="favoriteLanguage" value="PHP"/>
	 Ruby <form:radiobutton path="favoriteLanguage" value="Ruby"/>   
	 
	 <br><br>
	 <!-- Add check-box -->  
	 Operating Systems:
	 
	 Linux  	<form:checkbox path="operatingSystems" value="Linux"/>
	 Mac Os 	<form:checkbox path="operatingSystems" value="Mac Os"/>
	 MS Windows <form:checkbox path="operatingSystems" value="MS Windows"/>
	 
	 <br><br>
	 
	 
	   
     </form:form>
</body>

</html>