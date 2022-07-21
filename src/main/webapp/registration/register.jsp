<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
</head>
<body>
<div>
    <h3>Registration Form</h3>
    <form action="register" method="post" style="border:1px solid #ccc; padding: 20px;">
            <div>
                <label for="name" id="fn">First name</label>
                <label for="surname" id="ln">Last name</label>
            </div>

            <div>
                <input id="name" required type="text" name="name"><br/>
                <input id="surname" required type="text" name="surname"><br/>
            </div>

            <div>
                <label for="username">Username</label>
                <label for="password">Password</label>
            </div>

            <div>
                <input id="username" required type="text" name="username"><br/>
                <input id="password" required type="password" name="password"><br/>
            </div>

            <div>
                <label for="email">Email</label>
                <label for="country">Country</label>
            </div>

            <div>
                <input id="email" required type="text" name="email"><br/>
                    <select id="country" required name="country">
                        <c:forEach items="${countries}" var="country">
                            <option>${country}</option>
                        </c:forEach>
                </select><br/><br/>
            </div>

        <div>
            <button type="submit" value="Submit">Create an account</button>
            <button type="button" onclick="location.href = 'login';">Back to login page</button>
        </div>
    </form>
</div>
</body>
</html>
