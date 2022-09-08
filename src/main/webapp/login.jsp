<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.io.*, java.util.*" %>
<%
  String attribute = "hidden";
  int parameter = 0;

if (request.getParameter("error") != null) {
  parameter = 1;
}
  if(parameter == 1) {
    attribute = "";
  };
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Log In</title>
  <link rel="icon" href="resources/static/icons/icon-my.png" type="image/png" sizes="64x64">
    <link rel="stylesheet" type="text/css" href="resources/static/css/login.css"/>
</head>
<body>
  <div class="outer">
    <div class="inner">
      <form action="${pageContext.request.contextPath}/login" method="post" class="action">
      <label class="object">
        <span class="description">Email</span>
        <input class="input" type="email" name="login" placeholder="email@email.com">
      </label>
      <label class="object">
        <span class="description">Password</span>
        <input class="input" type="password" name="password" placeholder="password" autocomplete="current-password">
      </label>
      <label class="object">
        <span style="width: 100px"></span>
        <button type="submit" class="button">Log In</button>
      </label>
      <label class="object">
        <span style="width: 100px"></span>
        <span style="width: 176px; color: red; font-size: 16px; margin-left: 115px;" <%= attribute %>>
          *Wrong email or password</span>
      </label>
      </form>
      <form action="${pageContext.request.contextPath}/signup" class="action">
      <label class="object">
        <span style="width: 100px"></span>
        <span style="margin-left: 271px">or</span>
      </label>
      <label class="object">
        <span style="width: 100px"></span>
        <button class="buttonSignUp">Sign Up</button>
      </label>
      </form>
    </div>
  </div>
</body>
</html>
