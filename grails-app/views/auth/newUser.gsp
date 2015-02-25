<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta name="layout" content="main" />
    <title>New User</title>
</head>
<body>
    <div class="container">
        <div class=" bg-danger ">
            <g:if test="${msg != null}">
                <h1>${msg}</h1>
            </g:if>
        </div>
        <g:form action="createNewUser" role="form">
            <form role="form">
                <div class="form-group">
                    <label for="newUserName">User Name:</label>
                    <input type="text" name="newUserName" id="newUserName" class="form-control" required>
                </div>
                <div class="form-group">
                    <label for="newName">Name:</label>
                    <input type="text" name="newName" id="newName" class="form-control" required>
                </div>
                <div class="form-group">
                    <label for="newLastName">Last Name:</label>
                    <input type="text" name="newLastName" id="newLastName" class="form-control" required>
                </div>
                <div class="form-group">
                    <label for="email">Email address:</label>
                    <input type="email" name="newEmail" class="form-control" id="email" required>
                </div>
                <div class="form-group">
                    <label for="pwd">Password:</label>
                    <input type="password" name="newPassword" class="form-control" id="pwd" required>
                </div>
                <button type="submit" class="btn btn-default">Submit</button>
            </form>
        </g:form>
    </div>
</body>
</html>
