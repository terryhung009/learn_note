<!doctype html>
<html lang="en">
<head>
    <meta charset="Utf-8">
    <meta name="viewport"
          content="width=device-width,user-scalable=no,initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>歡迎來到購物趣</title>

</head>
<body>
<ul calss="nav">
    @if(session()->has('user_id'))
        <li><a href="/user/auth/sign-out">登出</a></li>
    @else
        <li><a href="/user/auth/sign-in">登入</a></li>
        <li><a href="/user/auth/sign-up">註冊</a></li>
    @endif
</ul>
<div>
    <a href="/">首頁</a>
    <a href="/merchandise/">查看商品清單頁面</a>
    <a href="/merchandise/create/">新建商品</a>
    <a href="/merchandise/manage/">管理商品</a>





</div>




</body>
<footer>

</footer>
</html>