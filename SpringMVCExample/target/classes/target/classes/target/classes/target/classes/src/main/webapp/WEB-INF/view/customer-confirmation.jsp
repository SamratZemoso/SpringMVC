<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!doctype html>
<html lang="en">
<head>
    <title>Customer Confirmation</title>
</head>
<body>
    Message : ${customer.firstName} ${customer.lastName}
    Passes : ${customer.freePasses}
    Postal Code : ${customer.postalCode}
</body>
</html>