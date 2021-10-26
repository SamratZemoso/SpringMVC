<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <title>Spring MVC Student Confirmation</title>
</head>
<body>
       message for confirmation : ${student.firstName} ${student.lastName}
       <br><br>
       country : ${student.country}
       <br><br>
        Favourite Language: ${student.favLang}
       <br><br>
       Operating System :
        <ul>
            <c:forEach var="temp" items="${student.operatingSystem}" >
                <li> ${temp} </li>
            </c:forEach>
        </ul>
</body>
</html>