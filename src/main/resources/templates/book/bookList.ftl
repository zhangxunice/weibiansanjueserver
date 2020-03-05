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
                            <th>状态</th>
                            <th>创建时间</th>
                            <th colspan="2">操作</th>
                        </tr>
                        </thead>
                        <tbody>
                        <#list booksList.records as book>
                            <tr>
                                <td>${book.bookId}</td>
                                <td>${book.bookName}</td>
                                <td><img class="pic01" src="${book.bookIcon}"></td>
                                <#--<img height="100px" width="100px" src="${book.bookIcon}">-->
                                <td>${book.bookDesc}</td>
                                <td><span class="label label-info">${book.bookStatusEnum().msg}</span></td>
                                <td>${book.createTime?string("yyyy-MM-dd HH:mm")}</td>
                                <td><a href="">详情</a></td>
                                <td>
                                    <#if book.bookStatus==1>
                                        <a href="/admin/finish?bookId=${book.bookId}">点击完结</a>
                                    </#if>
                                </td>
                            </tr>
                        </#list>
                        </tbody>
                    </table>
                    <h3>共${booksList.getTotal()}条记录</h3>
                    <div style="display: flex;flex-direction: row">
                        <ul class="pagination" style="margin-left: 20px">
                            <li>
                                <a href="/admin/booklist?page=1" aria-label="Previous">
                                    <span aria-hidden="true">&laquo;</span>
                                </a>
                            </li>

                            <#if currentPage lte 1>
                                <li class="disabled">
                                    <a href=""><span aria-hidden="true">&lt</span></a>
                                </li>
                            <#else>
                                <li>
                                    <a href="/admin/booklist?page=${currentPage-1}">
                                        <span aria-hidden="true">&lt</span>
                                    </a>
                                </li>
                            </#if>

                            <#if totalPage lte 5>

                                <#list 1..totalPage as index>
                                    <#if currentPage==index>
                                        <li class="disabled">
                                            <a href="/admin/booklist?page=${index}">${index}</a>
                                        </li>
                                    <#else >
                                        <li>
                                            <a href="/admin/booklist?page=${index}">${index}</a>
                                        </li>
                                    </#if>
                                </#list>

                            <#else>

                                <#if currentPage gte 5>
                                    <#if currentPage+3 lte totalPage>
                                        <#list currentPage-2..currentPage+3 as index>
                                            <#if currentPage==index>
                                                <li class="disabled">
                                                    <a href="/admin/booklist?page=${index}">${index}</a>
                                                </li>
                                            <#else >
                                                <li>
                                                    <a href="/admin/booklist?page=${index}">${index}</a>
                                                </li>
                                            </#if>
                                        </#list>
                                    <#else >
                                        <#list totalPage-4..totalPage as index>
                                            <#if currentPage==index>
                                                <li class="disabled">
                                                    <a href="/admin/booklist?page=${index}">${index}</a>
                                                </li>
                                            <#else >
                                                <li>
                                                    <a href="/admin/booklist?page=${index}">${index}</a>
                                                </li>
                                            </#if>
                                        </#list>
                                    </#if>

                                <#else >
                                    <#list 1..5 as index>
                                        <#if currentPage==index>
                                            <li class="disabled">
                                                <a href="/admin/booklist?page=${index}">${index}</a>
                                            </li>
                                        <#else >
                                            <li>
                                                <a href="/admin/booklist?page=${index}">${index}</a>
                                            </li>
                                        </#if>
                                    </#list>
                                </#if>

                            </#if>

                            <#if currentPage gte totalPage>
                                <li class="disabled">
                                    <a href=""><span aria-hidden="true">&gt</span></a>
                                </li>
                            <#else >
                                <li>
                                    <a href="/admin/booklist?page=${currentPage+1}">
                                        <span aria-hidden="true">&gt</span>
                                    </a>
                                </li>
                            </#if>

                            <li>
                                <a href="/admin/booklist?page=${totalPage}" aria-label="Next">
                                    <span aria-hidden="true">&raquo;</span>
                                </a>
                            </li>
                        </ul>
                        <#--<div style="display:flex;flex-direction:row;margin-left: 40px;margin-top: 20px">-->
                        <#--<h5>前往第</h5>-->
                        <#--<input type="text" style="width:36px; height:26px;margin: 7px" placeholder="1">-->
                        <#--<h5>页</h5>-->
                        <#--<a href="" style="margin-top: 10px;margin-left: 5px">确定</a>-->
                        <#--</div>-->
                    </div>

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