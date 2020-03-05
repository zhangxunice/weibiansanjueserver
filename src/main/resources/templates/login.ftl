<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link href="https://cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdn.bootcss.com/bootstrap-fileinput/4.4.7/css/fileinput.min.css" media="all" rel="stylesheet" type="text/css" />
    <script src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js"></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"></script>
    <title>登录</title>
</head>
<body>


<div>
    <div class="row clearfix">
        <div class="col-md-8 column">
            <div style=" background: url('/images/login.jpg');
            background-size: 100% 100%;
            height: 100%;
            position: fixed;
            width: 65%;"></div>

        </div>
        <div class="col-md-3 column">
            <h2 style="margin-top: 100px;margin-left: 40px">韦编三绝后台管理系统</h2>
            <div style="margin-top: 135px">
            <form role="form">
                <div class="form-group">
                    <label for="exampleInputEmail1">账号</label><input type="text" class="form-control" id="exampleInputEmail1" />
                </div>
                <div class="form-group">
                    <label for="exampleInputPassword1">密码</label><input type="password" class="form-control" id="exampleInputPassword1" />
                </div>
                <button type="submit" class="btn btn-info btn-lg btn-block" style="margin-top: 20px">登录</button>

            </form>
            </div>
        </div>
    </div>
</div>




</body>
</html>