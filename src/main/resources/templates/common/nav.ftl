<nav class="navbar navbar-inverse navbar-fixed-top" id="sidebar-wrapper" role="navigation">
    <ul class="nav sidebar-nav">
        <li class="sidebar-brand">
            <a href="#">
                韦编三绝管理系统
            </a>
        </li>
        <#--首页-->
        <li>
            <a href="/admin/index"><i class="fa fa-fw fa-list-alt"></i> 首页</a>
        </li>

        <#--图书管理-->
        <li class="dropdown open">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-expanded="true"><i class="fa fa-fw fa-plus"></i> 图书管理 <span class="caret"></span></a>
            <ul class="dropdown-menu" role="menu" style="margin-left: 25px;">
                <li class="dropdown-header">操作</li>
                <li><a href="/admin/booklist">图书列表</a></li>
                <li><a href="/admin/checkbooks">图书审核</a></li>
            </ul>
        </li>

        <#--章节管理-->
        <li class="dropdown open">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-expanded="true"><i class="fa fa-fw fa-plus"></i> 章节管理 <span class="caret"></span></a>
            <ul class="dropdown-menu" role="menu" style="margin-left: 25px;">
                <li class="dropdown-header">操作</li>
                <li><a href="/sell/product/list">章节列表</a></li>
                <li><a href="/sell/product/index">章节审核</a></li>
            </ul>
        </li>

        <#--评论管理-->
        <li class="dropdown open">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-expanded="true"><i class="fa fa-fw fa-plus"></i> 评论管理 <span class="caret"></span></a>
            <ul class="dropdown-menu" role="menu" style="margin-left: 25px;">
                <li class="dropdown-header">操作</li>
                <li><a href="/sell/category/list">评论列表</a></li>
                <#--<li><a href="/sell/category/index">管理员管理</a></li>-->
            </ul>
        </li>

        <#--用户管理-->
        <li class="dropdown open">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-expanded="true"><i class="fa fa-fw fa-plus"></i> 用户管理 <span class="caret"></span></a>
            <ul class="dropdown-menu" role="menu" style="margin-left: 25px;">
                <li class="dropdown-header">操作</li>
                <li><a href="/admin/userlist">普通用户列表</a></li>
                <li><a href="/admin/adminlist">管理员管理</a></li>
            </ul>
        </li>

        <#--轮播图管理-->
        <li class="dropdown open">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-expanded="true"><i class="fa fa-fw fa-plus"></i> 轮播图管理 <span class="caret"></span></a>
            <ul class="dropdown-menu" role="menu" style="margin-left: 25px;">
                <li class="dropdown-header">操作</li>
                <li><a href="/admin/swiperlist">轮播图</a></li>
            </ul>
        </li>

        <#--建议-->
        <li class="dropdown open">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-expanded="true"><i class="fa fa-fw fa-plus"></i> 建议管理 <span class="caret"></span></a>
            <ul class="dropdown-menu" role="menu" style="margin-left: 25px;">
                <li class="dropdown-header">操作</li>
                <li><a href="/admin/advice">建议列表</a></li>
            </ul>
        </li>

    </ul>
</nav>