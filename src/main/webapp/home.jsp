<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="text/html;charset=UTF-8"/>
  <title>Home</title>
  <link rel="icon" href="resources/static/icons/icon-my.png" type="image/png" sizes="64x64">
  <link rel="stylesheet" type="text/css" href="resources/static/css/main.css"/>
  <link rel="stylesheet" type="text/css" href="resources/static/css/home.css"/>
</head>
<body>
  <nav class="top-nav">
    <button onclick="myFunction()" class="menu" type="button" name="menu"
    style="border-style: none; margin-left: 10px">
      <img class="menu" src="resources/static/icons/menu.png" alt="menu">
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
        <img class="home" src="resources/static/icons/home.png" alt="home">
      </a>
    </button>
    <input class="search-top" type="search" name="search">
    <button onclick="myFunction2()" class="account" type="button"
    name="account" style="border-style: none; margin-right: 25px">
      <img class="account" src="resources/static/icons/account.png" alt="account">
      <div id="account-list" class="account-list">
        <a href="saves.HTML">Saves</a>
        <a href="settings.HTML">Settings</a>
        <a href="${pageContext.request.contextPath}/logout">Quit</a>
      </div>
    </button>
  </nav>

  <div class="flex-container">
    <img class="i-want" src="resources/static/icons/want.png" alt="I want">
    <div class="groups">
      <input class="search-line" name="search-main" type="search" tabindex="0">
      <button id="button" type="button">Go</button>
    </div>
    <div class="groups">
      <button class="b2" type="button" name="random-music">
        <a class="a-b2" href="${pageContext.request.contextPath}/music?sort=random">Random Music</a></button>
      <button class="b2" type="button" name="random-movie">
        <a class="a-b2" href="">Random Movie</a></button>
      <button class="b2" type="button" name="random-series">
        <a class="a-b2" href="">Random Series</a></button>
    </div>
  </div>

  <script src="resources/static/js/main.js"></script>
</body>
</html>
