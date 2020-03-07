<!doctype html>
<html lang="en">

<#include "../common/header.ftl">


<body>

<div id="wrapper" class="toggled">

    <#--边栏-->
    <#include "../common/nav.ftl">

    <#--主要内容-->
    <div id="page-content-wrapper">

        <form style="margin: 20px" method="post" action="/admin/addswiper" enctype="multipart/form-data">
            <div class="form-group">
                <label>上传图片</label>
                <input type="file" name="file">
            </div>
            <button type="submit" class="btn btn-default btn-info" style="display:block;margin-top: 20px">
                确认添加
            </button>
        </form>

        <div class="container-fluid">

            <div class="row clearfix">
                <div class="col-md-12 column">
                    <table class="table table-hover">
                        <thead>
                        <tr>
                            <th>id</th>
                            <th>图片</th>
                            <th>上传时间</th>
                            <th >操作</th>
                        </tr>
                        </thead>
                        <tbody>
                        <#list swiperList as swiper>
                            <tr>
                                <td>${swiper.id}</td>
                                <td><img class="pic01" src="${swiper.imgUrl}"></td>
                                <td>${swiper.createTime?string("yyyy-MM-dd HH:mm")}</td>
                                <td><a href="/admin/delswiper?swiperId=${swiper.id}">删除</a></td>
                            </tr>
                        </#list>
                        </tbody>
                    </table>
                    <h3>共${swiperList?size}张轮播图</h3>

                </div>
            </div>

        </div>
    </div>
</div>
<div class="pic02">
    <img src="#">
</div>
<script>

    $('.pic01').on('click', function () {
        var picSrc = $(this).attr('src')
        $('.pic02 img').attr('src', picSrc)
        $('.pic02').show()
    })
    $('.pic02').on('click', function () {
        $('.pic02').hide()
    })

</script>
</body>
</html>