<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css" />
    <title>Login</title>
</head>
<body>
<section>
<div>
    <div>
        <h2>Login</h2>
        <form action="authenticate" method="post">
            <div>
                <input id="username" name="username" type="text"><br />
                <label for="username">Username</label>
            </div>
            <div>
                <input id="password" name="password" type="password"><br />
                <label for="password">Password</label>
            </div>
            <div>
                <button type="submit">Log in</button>
            </div>
            </form>
    </div>
<hr />
        <div>
            <h2>Not a member yet?</h2>
            <a href="registration">Join now</a>
        </div>

</div>
</section>
</body>
</html>
