<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/register.css" />
    <title>Register</title>
</head>
<body>
<div>
    <h3>Registration Form</h3>
    <form action="register" method="post" style="border:1px solid #ccc; padding: 20px;">
            <div>
                <input id="name" required type="text" name="name" /><br />
                <label for="name" id="fn">First name</label>
            </div>

            <div>
                <input id="surname" required type="text" name="surname" /><br />
                <label for="surname" id="ln">Last name</label>
            </div>

            <div>
                <input id="username" required type="text" name="username" /><br />
                <label for="username">Username</label>
            </div>

            <div>
                <input id="password" required type="password" name="password" /><br />
                <label for="password">Password</label>
            </div>

            <div>
                <input id="email" required type="text" name="email" /><br />
                <label for="email">Email</label>
            </div>

            <div>
                    <select id="country" required name="country">
                        <c:forEach items="${countries}" var="country">
                            <option>${country}</option>
                        </c:forEach>
                </select><br/><br/>
                <label for="country">Country</label>
            </div>

        <div>
            <button type="submit" value="Submit">Create an account</button>
            <button type="button" onclick="location.href = 'login';">Back to login page</button>
        </div>
    </form>
</div>
</body>
</html>
