<%-- 
    Document   : showusers
    Created on : Feb 21, 2017, 5:28:57 PM
    Author     : Thomas Hartmann - tha@cphbusiness.dk
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List, control.User, com.google.gson.Gson, com.google.gson.reflect.TypeToken, java.lang.reflect.Type" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Show users</title>

    </head>
    <body>
        <h1>Users:</h1>
        <div id="content"/>
        <script>
            <%
                Gson gson = new Gson();
                List<User> users = (List<User>) session.getAttribute("userlist");
                Type listOfUserObjects = new TypeToken<List<User>>() {
                }.getType();
                String jsonString = gson.toJson(users, listOfUserObjects);

            %>

            var arr = <%=jsonString%>;

            //write all users to the DOM
            var contentDiv = document.getElementById("content");
            content = "<table>";
            totalAge = 0;
            arr.forEach( function(user) {
                content = content + '<tr><td> ' + user.id + ' </td><td>' + user.username + ' </td><td> ' + user.age + '</td></tr>';
                totalAge += user.age;
            });
            content = content + "</table>";

            contentDiv.innerHTML = content + '<br>Total age for all users: ' + totalAge;
            
        </script>
    </body>
</html>
