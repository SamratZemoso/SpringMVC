<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
    <title>Spring MVC Student Controller</title>
</head>
<body>
    <form:form action="processForm" modelAttribute="student">

        First Name : <form:input path="firstName" />

        <br><br>
        Last Name : <form:input path="lastName" />

        <br><br>
        Country : <form:select path="country">
            <form:options items="${student.countryOptions}" />
        </form:select>

        <br><br>
        Favourite Language :
            Java <form:radiobutton path="favLang" value="Java" />
            C++ <form:radiobutton path="favLang" value="C++" />
            Python <form:radiobutton path="favLang" value="Python" />

        <br><br>
        Operating System :
        Linux <form:checkbox path="operatingSystem" value="Linux" />
        Windows <form:checkbox path="operatingSystem" value="Windows" />
        OSX <form:checkbox path="operatingSystem" value="OSX" />

        <br><br>
        <input type="submit" value="submit" />

    </form:form>
</body>
</html>