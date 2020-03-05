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
                            <th>用户id</th>
                            <th>用户名</th>
                            <th>建议内容</th>
                            <th>联系方式</th>
                            <th>建议时间</th>
                        </tr>
                        </thead>
                        <tbody>
                        <#list advices.records as advice>
                            <tr>
                                <td>${advice.id}</td>
                                <td>${advice.userId}</td>
                                <td>${advice.nickName}</td>
                                <td>${advice.content}</td>
                                <td>${advice.userPhone}</td>
                                <td>${advice.createTime?string("yyyy-MM-dd HH:mm")}</td>
                            </tr>
                        </#list>
                        </tbody>
                    </table>
                    <h3>共${advices.getTotal()}条记录</h3>
                    <div style="display: flex;flex-direction: row">
                        <ul class="pagination" style="margin-left: 20px">
                            <li>
                                <a href="/admin/advice?page=1" aria-label="Previous">
                                    <span aria-hidden="true">&laquo;</span>
                                </a>
                            </li>

                            <#if currentPage lte 1>
                                <li class="disabled">
                                    <a href=""><span aria-hidden="true">&lt</span></a>
                                </li>
                            <#else>
                                <li>
                                    <a href="/admin/advice?page=${currentPage-1}">
                                        <span aria-hidden="true">&lt</span>
                                    </a>
                                </li>
                            </#if>

                            <#if totalPage lte 5>

                                <#list 1..totalPage as index>
                                    <#if currentPage==index>
                                        <li class="disabled">
                                            <a href="/admin/advice?page=${index}">${index}</a>
                                        </li>
                                    <#else >
                                        <li>
                                            <a href="/admin/advice?page=${index}">${index}</a>
                                        </li>
                                    </#if>
                                </#list>

                            <#else>

                                <#if currentPage gte 5>
                                    <#if currentPage+3 lte totalPage>
                                        <#list currentPage-2..currentPage+3 as index>
                                            <#if currentPage==index>
                                                <li class="disabled">
                                                    <a href="/admin/advice?page=${index}">${index}</a>
                                                </li>
                                            <#else >
                                                <li>
                                                    <a href="/admin/advice?page=${index}">${index}</a>
                                                </li>
                                            </#if>
                                        </#list>
                                    <#else >
                                        <#list totalPage-4..totalPage as index>
                                            <#if currentPage==index>
                                                <li class="disabled">
                                                    <a href="/admin/advice?page=${index}">${index}</a>
                                                </li>
                                            <#else >
                                                <li>
                                                    <a href="/admin/advice?page=${index}">${index}</a>
                                                </li>
                                            </#if>
                                        </#list>
                                    </#if>

                                <#else >
                                    <#list 1..5 as index>
                                        <#if currentPage==index>
                                            <li class="disabled">
                                                <a href="/admin/advice?page=${index}">${index}</a>
                                            </li>
                                        <#else >
                                            <li>
                                                <a href="/admin/advice?page=${index}">${index}</a>
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
                                    <a href="/admin/advice?page=${currentPage+1}">
                                        <span aria-hidden="true">&gt</span>
                                    </a>
                                </li>
                            </#if>

                            <li>
                                <a href="/admin/advice?page=${totalPage}" aria-label="Next">
                                    <span aria-hidden="true">&raquo;</span>
                                </a>
                            </li>
                        </ul>

                    </div>

                </div>
            </div>

        </div>
    </div>
</div>

</body>
</html>