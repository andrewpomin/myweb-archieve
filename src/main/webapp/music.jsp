<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.io.*" %>
<%@ page import="myprojects.helpers.Music" %>
<%
  Music music = new Music();
  PrintWriter pw = response.getWriter();
%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>Music</title>
  <link rel="icon" href="resources/static/icons/icon-my.png" type="image/png" sizes="64x64">
  <link rel="stylesheet" type="text/css" href="resources/static/css/main.css">
  <link rel="stylesheet" type="text/css" href="resources/static/css/music.css">
</head>
<body>
  <nav class="top-nav">
    <button onclick="myFunction()" class="menu" type="button" name="menu"
    style="border-style: none; margin-left: 10px">
      <img class="menu" src="resources/static/icons/menu.png">
      <div id="menu-list" class="menu-list">
        <a href="${pageContext.request.contextPath}/music">Music</a>
        <a href="${pageContext.request.contextPath}/movies">Movies</a>
        <a href="${pageContext.request.contextPath}/tvseries">TV Series</a>
        <a href="${pageContext.request.contextPath}/games">Games</a>
        <a href="${pageContext.request.contextPath}/gallery">Gallery</a>
      </div>
    </button>
    <button class="home" type="button" name="home" style="border-style: none;">
      <a href="${pageContext.request.contextPath}/home">
        <img class="home" src="resources/static/icons/home.png">
      </a>
    </button>
    <input class="search-top" type="search" name="search">
    <button onclick="myFunction2()" class="account" type="button"
    name="account" style="border-style: none; margin-right: 25px">
      <img class="account" src="resources/static/icons/account.png">
      <div id="account-list" class="account-list">
        <a href="saves.HTML">Saves</a>
        <a href="settings.HTML">Settings</a>
        <a href="${pageContext.request.contextPath}/logout">Quit</a>
      </div>
    </button>
  </nav>

  <%
    if (request.getParameter("sort") == null) {
      pw.write(music.printMusic());
    } else if (request.getParameter("sort").equals("random")) {
      pw.write(music.printRandomMusic());
    } else {
      pw.write(music.printMusic());
    }
  %>

<script src="resources/static/js/main.js"></script>
</body>
</html>