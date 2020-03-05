<!doctype html>
<html lang="en">

<#include "../common/header.ftl">


<body>

<div id="wrapper" class="toggled">

    <#--边栏-->
    <#include "../common/nav.ftl">

    <#--主要内容-->
    <div id="page-content-wrapper">

        <div class="container-fluid">

            <div class="row clearfix">
                <div class="col-md-12 column">
                    <table class="table table-bordered table-hover">
                        <thead>
                        <tr>
                            <th>id</th>
                            <th>书名</th>
                            <th>封面</th>
                            <th>描述</th>
                            <th>作者</th>
                            <th>创建时间</th>
                            <#--<th colspan="2">操作</th>-->
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td>123456</td>
                            <td>深度学习</td>
                            <td><img class="pic01" src="/images/login.jpg"></td>
                            <td>带你走进深度学习的神秘大门</td>
                            <td>阿黄</td>
                            <td>2020-3-05</td>
                            <#--<td>${user.createTime?string("yyyy-MM-dd HH:mm")}</td>-->
                        </tr>
                        </tbody>
                    </table>

<h3>章节列表</h3>
                    <div class="col-md-12 column">
                        <table class="table table-bordered table-hover">
                            <thead>
                            <tr>
                                <th>id</th>
                                <th>书名</th>
                                <th>封面</th>
                                <th>描述</th>
                                <th>作者</th>
                                <th>创建时间</th>
                                <#--<th colspan="2">操作</th>-->
                            </tr>
                            </thead>
                            <tbody>
                            <tr>
                                <td>123456</td>
                                <td>深度学习</td>
                                <td><img class="pic01" src="/images/login.jpg"></td>
                                <td>带你走进深度学习的神秘大门</td>
                                <td>阿黄</td>
                                <td>2020-3-05</td>
                                <#--<td>${user.createTime?string("yyyy-MM-dd HH:mm")}</td>-->
                            </tr>
                            </tbody>
                        </table>
                    </div>

                    <#--<h3>共${usersList.getTotal()}条记录</h3>-->
                    <#--<div style="display: flex;flex-direction: row">-->
                    <#--<ul class="pagination" style="margin-left: 20px">-->
                    <#--<li>-->
                    <#--<a href="/admin/userlist?page=1" aria-label="Previous">-->
                    <#--<span aria-hidden="true">&laquo;</span>-->
                    <#--</a>-->
                    <#--</li>-->

                    <#--<#if currentPage lte 1>-->
                    <#--<li class="disabled">-->
                    <#--<a href=""><span aria-hidden="true">&lt</span></a>-->
                    <#--</li>-->
                    <#--<#else>-->
                    <#--<li>-->
                    <#--<a href="/admin/userlist?page=${currentPage-1}">-->
                    <#--<span aria-hidden="true">&lt</span>-->
                    <#--</a>-->
                    <#--</li>-->
                    <#--</#if>-->

                    <#--<#if totalPage lte 5>-->

                    <#--<#list 1..totalPage as index>-->
                    <#--<#if currentPage==index>-->
                    <#--<li class="disabled">-->
                    <#--<a href="/admin/userlist?page=${index}">${index}</a>-->
                    <#--</li>-->
                    <#--<#else >-->
                    <#--<li>-->
                    <#--<a href="/admin/userlist?page=${index}">${index}</a>-->
                    <#--</li>-->
                    <#--</#if>-->
                    <#--</#list>-->

                    <#--<#else>-->

                    <#--<#if currentPage gte 5>-->
                    <#--<#if currentPage+3 lte totalPage>-->
                    <#--<#list currentPage-2..currentPage+3 as index>-->
                    <#--<#if currentPage==index>-->
                    <#--<li class="disabled">-->
                    <#--<a href="/admin/userlist?page=${index}">${index}</a>-->
                    <#--</li>-->
                    <#--<#else >-->
                    <#--<li>-->
                    <#--<a href="/admin/userlist?page=${index}">${index}</a>-->
                    <#--</li>-->
                    <#--</#if>-->
                    <#--</#list>-->
                    <#--<#else >-->
                    <#--<#list totalPage-4..totalPage as index>-->
                    <#--<#if currentPage==index>-->
                    <#--<li class="disabled">-->
                    <#--<a href="/admin/userlist?page=${index}">${index}</a>-->
                    <#--</li>-->
                    <#--<#else >-->
                    <#--<li>-->
                    <#--<a href="/admin/userlist?page=${index}">${index}</a>-->
                    <#--</li>-->
                    <#--</#if>-->
                    <#--</#list>-->
                    <#--</#if>-->

                    <#--<#else >-->
                    <#--<#list 1..5 as index>-->
                    <#--<#if currentPage==index>-->
                    <#--<li class="disabled">-->
                    <#--<a href="/admin/userlist?page=${index}">${index}</a>-->
                    <#--</li>-->
                    <#--<#else >-->
                    <#--<li>-->
                    <#--<a href="/admin/userlist?page=${index}">${index}</a>-->
                    <#--</li>-->
                    <#--</#if>-->
                    <#--</#list>-->
                    <#--</#if>-->

                    <#--</#if>-->

                    <#--<#if currentPage gte totalPage>-->
                    <#--<li class="disabled">-->
                    <#--<a href=""><span aria-hidden="true">&gt</span></a>-->
                    <#--</li>-->
                    <#--<#else >-->
                    <#--<li>-->
                    <#--<a href="/admin/userlist?page=${currentPage+1}">-->
                    <#--<span aria-hidden="true">&gt</span>-->
                    <#--</a>-->
                    <#--</li>-->
                    <#--</#if>-->

                    <#--<li>-->
                    <#--<a href="/admin/userlist?page=${totalPage}" aria-label="Next">-->
                    <#--<span aria-hidden="true">&raquo;</span>-->
                    <#--</a>-->
                    <#--</li>-->
                    <#--</ul>-->
                    <#--&lt;#&ndash;<div style="display:flex;flex-direction:row;margin-left: 40px;margin-top: 20px">&ndash;&gt;-->
                    <#--&lt;#&ndash;<h5>前往第</h5>&ndash;&gt;-->
                    <#--&lt;#&ndash;<input type="text" style="width:36px; height:26px;margin: 7px" placeholder="1">&ndash;&gt;-->
                    <#--&lt;#&ndash;<h5>页</h5>&ndash;&gt;-->
                    <#--&lt;#&ndash;<a href="" style="margin-top: 10px;margin-left: 5px">确定</a>&ndash;&gt;-->
                    <#--&lt;#&ndash;</div>&ndash;&gt;-->
                    <#--</div>-->

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