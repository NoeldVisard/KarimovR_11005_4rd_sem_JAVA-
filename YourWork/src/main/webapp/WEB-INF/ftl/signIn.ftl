<html>
<head>
    <title>Sign In</title>
    <link rel="stylesheet" href="/assets/css/style.css">

</head>
<body>
<form action="/signIn" method="post" class="form">
    <label>Sign in</label>
    <div id="wrapper">
        <div id="arrow"></div>
        <input name="login" id="login" placeholder="Login" type="text">
        <input name="password" id="password" placeholder="Password" type="password">
    </div>
    <button type="submit">Sign in</button>
</form>
<h3>${signInStatus!""}</h3>
</body>
</html>
