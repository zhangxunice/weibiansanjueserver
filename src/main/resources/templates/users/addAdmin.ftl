<!doctype html>
<html lang="en">

<#include "../common/header.ftl">


<body>

<div id="wrapper" class="toggled">

    <#--边栏-->
    <#include "../common/nav.ftl">


    <#--主要内容-->
    <div id="page-content-wrapper" style="margin-left: 106px;margin-top: 20px">
        <h3 style="margin-left: 20px">添加管理员</h3>
        <div class="container-fluid">

            <div class="row clearfix">
                <div class="col-md-6 column">

                    <form role="form" method="post" action="/admin/addAdmin">
                        <div class="form-group">
                            <label>账号</label>
                            <input name="name" type="text" class="form-control" value="${(adminVO.name)!''}"/>
                        </div>
                        <div class="form-group">
                            <label>密码</label>
                            <input name="password" type="text" class="form-control" value="${(adminVO.password)!''}"/>
                        </div>
                        分配角色<br/><br/>
                        <div class="form-group">
                            <#--<#if (roleList)??>-->
                            <#list roleList as rol>
                                <label><input name="roles" type="checkbox" value="${rol.id}"
                                            <#if adminVO??><#list adminVO.roles as arole>
                                                    <#if (arole.id)?? && arole.id==rol.id>checked</#if>
                                                </#list></#if>
                                    />${rol.roleName} </label>
                            </#list>
                            <#--</#if>-->
                        </div>
                        <input hidden type="text" name="adminId" value="${(adminVO.id)!''}">
                        <h5 style="color: red">${msg!''}</h5>
                        <button type="submit" class="btn btn-default btn-info" style="display:block;margin-top: 20px">
                            确认添加
                        </button>
                    </form>

                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>