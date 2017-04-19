<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<!DOCTYPE>
<html>
<head>
    <%@include file="/public/header.jspf" %>
</head>
<body>
<!-- 导航栏-->
<div class="navbar navbar-default" role="navigation">
    <div class="navbar-header">
        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
        </button>
        <a class="" href="index.html"><span class="navbar-brand"><span class="fa fa-paper-plane"></span> Aircraft</span></a></div>

    <div class="navbar-collapse collapse" style="height: 1px;">
        <ul id="main-menu" class="nav navbar-nav navbar-right">
            <li class="dropdown hidden-xs">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                    <span class="glyphicon glyphicon-user padding-right-small" style="position:relative;top: 3px;"></span> Jack Smith
                    <i class="fa fa-caret-down"></i>
                </a>

                <ul class="dropdown-menu">
                    <li><a href="WEB-INF">My Account</a></li>
                    <li class="divider"></li>
                    <li class="dropdown-header">Admin Panel</li>
                    <li><a href="WEB-INF">Users</a></li>
                    <li><a href="WEB-INF">Security</a></li>
                    <li><a tabindex="-1" href="WEB-INF">Payments</a></li>
                    <li class="divider"></li>
                    <li><a tabindex="-1" href="sign-in.html">Logout</a></li>
                </ul>
            </li>
            <li class="visible-xs"><a href="#" data-target=".dashboard-menu" class="nav-header" data-toggle="collapse"><span class="glyphicon glyphicon-blackboard"></span> Dashboard<span class="glyphicon glyphicon-menu-down"></span></a></li><li class="visible-xs"><ul class="dashboard-menu nav nav-list collapse" style="height: 0px;">
            <li><a href="index.html"><span class="glyphicon glyphicon-triangle-right"></span> Main</a></li>
            <li><a href="users.html"><span class="glyphicon glyphicon-triangle-right"></span> User List</a></li>
            <li><a href="user.html"><span class="glyphicon glyphicon-triangle-right"></span> User Profile</a></li>
            <li><a href="media.html"><span class="glyphicon glyphicon-triangle-right"></span> Media</a></li>
            <li><a href="calendar.html"><span class="glyphicon glyphicon-triangle-right"></span> Calendar</a></li>
        </ul></li><li data-popover="true" data-content="Items in this group require a &lt;strong&gt;&lt;a href='http://portnine.com/bootstrap-themes/aircraft' target='blank'&gt;premium license&lt;/a&gt;&lt;strong&gt;." rel="popover" data-placement="right" data-original-title="" title="" class="visible-xs"><a href="#" data-target=".premium-menu" class="nav-header collapsed" data-toggle="collapse"><i class="glyphicon glyphicon-blackboard"></i> Premium Features<i class="glyphicon glyphicon-menu-down"></i></a></li><li class="visible-xs"><ul class="premium-menu nav nav-list collapse" style="height: 0px;">
            <li class="visible-xs visible-sm"><a href="#">- Premium features require a license -</a>
            </li><li><a href="premium-profile.html"><span class="glyphicon glyphicon-triangle-right"></span> Enhanced Profile</a></li>
            <li><a href="premium-blog.html"><span class="glyphicon glyphicon-triangle-right"></span> Blog</a></li>
            <li><a href="premium-blog-item.html"><span class="glyphicon glyphicon-triangle-right"></span> Blog Page</a></li>
            <li><a href="premium-pricing-tables.html"><span class="glyphicon glyphicon-triangle-right"></span> Pricing Tables</a></li>
            <li><a href="premium-upgrade-account.html"><span class="glyphicon glyphicon-triangle-right"></span> Upgrade Account</a></li>
            <li><a href="premium-widgets.html"><span class="glyphicon glyphicon-triangle-right"></span> Widgets</a></li>
            <li><a href="premium-timeline.html"><span class="glyphicon glyphicon-triangle-right"></span> Activity Timeline</a></li>
            <li><a href="premium-users.html"><span class="glyphicon glyphicon-triangle-right"></span> Enhanced Users List</a></li>
            <li><a href="premium-media.html"><span class="glyphicon glyphicon-triangle-right"></span> Enhanced Media</a></li>
            <li><a href="premium-invoice.html"><span class="glyphicon glyphicon-triangle-right"></span> Invoice</a></li>
            <li><a href="premium-build.html"><span class="glyphicon glyphicon-triangle-right"></span> Advanced Tools</a></li>
            <li><a href="premium-colors.html"><span class="glyphicon glyphicon-triangle-right"></span> Additional Color Themes</a></li>
        </ul></li><li class="visible-xs"><a href="#" data-target=".accounts-menu" class="nav-header collapsed" data-toggle="collapse"><i class="glyphicon glyphicon-blackboard"></i> Account <span class="label label-info">+3</span></a></li><li class="visible-xs"><ul class="accounts-menu nav nav-list collapse">
            <li><a href="sign-in.html"><span class="glyphicon glyphicon-triangle-right"></span> Sign In</a></li>
            <li><a href="sign-up.html"><span class="glyphicon glyphicon-triangle-right"></span> Sign Up</a></li>
            <li><a href="reset-password.html"><span class="glyphicon glyphicon-triangle-right"></span> Reset Password</a></li>
        </ul></li><li class="visible-xs"><a href="#" data-target=".legal-menu" class="nav-header collapsed" data-toggle="collapse"><i class="glyphicon glyphicon-blackboard"></i> Legal<i class="glyphicon glyphicon-menu-down"></i></a></li><li class="visible-xs"><ul class="legal-menu nav nav-list collapse">
            <li><a href="privacy-policy.html"><span class="glyphicon glyphicon-triangle-right"></span> Privacy Policy</a></li>
            <li><a href="terms-and-conditions.html"><span class="glyphicon glyphicon-triangle-right"></span> Terms and Conditions</a></li>
        </ul></li><li class="visible-xs"><a href="help.html" class="nav-header"><i class="fa fa-fw fa-question-circle"></i> Help</a></li><li class="visible-xs"><a href="faq.html" class="nav-header"><i class="fa fa-fw fa-comment"></i> Faq</a></li><li class="visible-xs"><a href="http://portnine.com/bootstrap-themes/aircraft" class="nav-header" target="blank"><i class="fa fa-fw fa-heart"></i> Get Premium</a></li></ul>

    </div>
</div>

<!--侧边栏 -->
<div class="sidebar-nav">
    <ul>
        <li><a href="#" data-target=".dashboard-menu" class="nav-header collapsed" data-toggle="collapse"><i class="glyphicon glyphicon-blackboard"></i> Dashboard<i class="glyphicon glyphicon-menu-down"></i></a></li>
        <li><ul class="dashboard-menu nav nav-list collapse" style="height: 0px;">
            <li><a href="index.html"><span class="glyphicon glyphicon-triangle-right"></span> Main</a></li>
            <li><a href="users.html"><span class="glyphicon glyphicon-triangle-right"></span> User List</a></li>
            <li><a href="user.html"><span class="glyphicon glyphicon-triangle-right"></span> User Profile</a></li>
            <li><a href="media.html"><span class="glyphicon glyphicon-triangle-right"></span> Media</a></li>
            <li><a href="calendar.html"><span class="glyphicon glyphicon-triangle-right"></span> Calendar</a></li>
        </ul></li>

        <li data-popover="true" data-content="Items in this group require a &lt;strong&gt;&lt;a href='http://portnine.com/bootstrap-themes/aircraft' target='blank'&gt;premium license&lt;/a&gt;&lt;strong&gt;." rel="popover" data-placement="right" data-original-title="" title=""><a href="#" data-target=".premium-menu" class="nav-header collapsed" data-toggle="collapse"><i class="glyphicon glyphicon-blackboard"></i> Premium Features<i class="glyphicon glyphicon-menu-down"></i></a></li>
        <li><ul class="premium-menu nav nav-list collapse" style="height: 0px;">
            <li class="visible-xs visible-sm"><a href="#">- Premium features require a license -</a>
            </li><li><a href="premium-profile.html"><span class="glyphicon glyphicon-triangle-right"></span> Enhanced Profile</a></li>
            <li><a href="premium-blog.html"><span class="glyphicon glyphicon-triangle-right"></span> Blog</a></li>
            <li><a href="premium-blog-item.html"><span class="glyphicon glyphicon-triangle-right"></span> Blog Page</a></li>
            <li><a href="premium-pricing-tables.html"><span class="glyphicon glyphicon-triangle-right"></span> Pricing Tables</a></li>
            <li><a href="premium-upgrade-account.html"><span class="glyphicon glyphicon-triangle-right"></span> Upgrade Account</a></li>
            <li><a href="premium-widgets.html"><span class="glyphicon glyphicon-triangle-right"></span> Widgets</a></li>
            <li><a href="premium-timeline.html"><span class="glyphicon glyphicon-triangle-right"></span> Activity Timeline</a></li>
            <li><a href="premium-users.html"><span class="glyphicon glyphicon-triangle-right"></span> Enhanced Users List</a></li>
            <li><a href="premium-media.html"><span class="glyphicon glyphicon-triangle-right"></span> Enhanced Media</a></li>
            <li><a href="premium-invoice.html"><span class="glyphicon glyphicon-triangle-right"></span> Invoice</a></li>
            <li><a href="premium-build.html"><span class="glyphicon glyphicon-triangle-right"></span> Advanced Tools</a></li>
            <li><a href="premium-colors.html"><span class="glyphicon glyphicon-triangle-right"></span> Additional Color Themes</a></li>
        </ul></li>

        <li><a href="#" data-target=".accounts-menu" class="nav-header collapsed" data-toggle="collapse"><i class="glyphicon glyphicon-blackboard"></i> Account <span class="label label-info">+3</span></a></li>
        <li><ul class="accounts-menu nav nav-list collapse">
            <li><a href="sign-in.html"><span class="glyphicon glyphicon-triangle-right"></span> Sign In</a></li>
            <li><a href="sign-up.html"><span class="glyphicon glyphicon-triangle-right"></span> Sign Up</a></li>
            <li><a href="reset-password.html"><span class="glyphicon glyphicon-triangle-right"></span> Reset Password</a></li>
        </ul></li>

        <li><a href="#" data-target=".legal-menu" class="nav-header collapsed" data-toggle="collapse"><i class="glyphicon glyphicon-blackboard"></i> Legal<i class="glyphicon glyphicon-menu-down"></i></a></li>
        <li><ul class="legal-menu nav nav-list collapse">
            <li><a href="privacy-policy.html"><span class="glyphicon glyphicon-triangle-right"></span> Privacy Policy</a></li>
            <li><a href="terms-and-conditions.html"><span class="glyphicon glyphicon-triangle-right"></span> Terms and Conditions</a></li>
        </ul></li>

        <li><a href="help.html" class="nav-header"><i class="glyphicon glyphicon-blackboard"></i> Help</a></li>
        <li><a href="faq.html" class="nav-header"><i class="glyphicon glyphicon-blackboard"></i> Faq</a></li>
        <li><a href="http://portnine.com/bootstrap-themes/aircraft" class="nav-header" target="blank"><i class="glyphicon glyphicon-blackboard"></i> Get Premium</a></li>
    </ul>
</div>

<!--内容主题-->
<div class="content">
    <div class="header">
        <div class="stats">
            <p class="stat"><span class="label label-info">5</span> Tickets</p>
            <p class="stat"><span class="label label-success">27</span> Tasks</p>
            <p class="stat"><span class="label label-danger">15</span> Overdue</p>
        </div>

        <h1 class="page-title">Dashboard</h1>
        <ul class="breadcrumb">
            <li><a href="index.html">Home</a> </li>
            <li class="active">Dashboard</li>
        </ul>

    </div>
    <div class="main-content">





        <div class="panel panel-default">
            <a href="#page-stats" class="panel-heading" data-toggle="collapse">Latest Stats</a>
            <div id="page-stats" class="panel-collapse panel-body collapse in">

                <div class="row">
                    <div class="col-md-3 col-sm-6">
                        <div class="knob-container">
                            <div style="display: inline; width: 200px; height: 200px;"><canvas width="200" height="200"></canvas><input class="knob" data-width="200" data-min="0" data-max="3000" data-displayprevious="true" value="2500" data-fgcolor="#92A3C2" data-readonly="true;" readonly="readonly" style="width: 104px; height: 66px; position: absolute; vertical-align: middle; margin-top: 66px; margin-left: -152px; border: 0px none; background: transparent none repeat scroll 0% 0%; font: bold 33px Arial; text-align: center; color: rgb(146, 163, 194); padding: 0px;"></div>
                            <h3 class="text-muted text-center">Accounts</h3>
                        </div>
                    </div>
                    <div class="col-md-3 col-sm-6">
                        <div class="knob-container">
                            <div style="display: inline; width: 200px; height: 200px;"><canvas width="200" height="200"></canvas><input class="knob" data-width="200" data-min="0" data-max="4500" data-displayprevious="true" value="3299" data-fgcolor="#92A3C2" data-readonly="true;" readonly="readonly" style="width: 104px; height: 66px; position: absolute; vertical-align: middle; margin-top: 66px; margin-left: -152px; border: 0px none; background: transparent none repeat scroll 0% 0%; font: bold 33px Arial; text-align: center; color: rgb(146, 163, 194); padding: 0px;"></div>
                            <h3 class="text-muted text-center">Subscribers</h3>
                        </div>
                    </div>
                    <div class="col-md-3 col-sm-6">
                        <div class="knob-container">
                            <div style="display: inline; width: 200px; height: 200px;"><canvas width="200" height="200"></canvas><input class="knob" data-width="200" data-min="0" data-max="2700" data-displayprevious="true" value="1840" data-fgcolor="#92A3C2" data-readonly="true;" readonly="readonly" style="width: 104px; height: 66px; position: absolute; vertical-align: middle; margin-top: 66px; margin-left: -152px; border: 0px none; background: transparent none repeat scroll 0% 0%; font: bold 33px Arial; text-align: center; color: rgb(146, 163, 194); padding: 0px;"></div>
                            <h3 class="text-muted text-center">Pending</h3>
                        </div>
                    </div>
                    <div class="col-md-3 col-sm-6">
                        <div class="knob-container">
                            <div style="display: inline; width: 200px; height: 200px;"><canvas width="200" height="200"></canvas><input class="knob" data-width="200" data-min="0" data-max="15000" data-displayprevious="true" value="10067" data-fgcolor="#92A3C2" data-readonly="true;" readonly="readonly" style="width: 104px; height: 66px; position: absolute; vertical-align: middle; margin-top: 66px; margin-left: -152px; border: 0px none; background: transparent none repeat scroll 0% 0%; font: bold 28px Arial; text-align: center; color: rgb(146, 163, 194); padding: 0px;"></div>
                            <h3 class="text-muted text-center">Completed</h3>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col-sm-6 col-md-6">
                <div class="panel panel-default">
                    <div class="panel-heading no-collapse">Not Collapsible<span class="label label-warning">+10</span></div>
                    <table class="table table-bordered table-striped">
                        <thead>
                        <tr>
                            <th>First Name</th>
                            <th>Last Name</th>
                            <th>Username</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td>Mark</td>
                            <td>Tompson</td>
                            <td>the_mark7</td>
                        </tr>
                        <tr>
                            <td>Ashley</td>
                            <td>Jacobs</td>
                            <td>ash11927</td>
                        </tr>
                        <tr>
                            <td>Audrey</td>
                            <td>Ann</td>
                            <td>audann84</td>
                        </tr>
                        <tr>
                            <td>John</td>
                            <td>Robinson</td>
                            <td>jr5527</td>
                        </tr>
                        <tr>
                            <td>Aaron</td>
                            <td>Butler</td>
                            <td>aaron_butler</td>
                        </tr>
                        <tr>
                            <td>Chris</td>
                            <td>Albert</td>
                            <td>cab79</td>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </div>
            <div class="col-sm-6 col-md-6">
                <div class="panel panel-default">
                    <a href="#widget1container" class="panel-heading" data-toggle="collapse">Collapsible </a>
                    <div id="widget1container" class="panel-body collapse in">
                        <h2>Here's a Tip</h2>
                        <p>This template was developed with <a href="http://middlemanapp.com/" target="_blank">Middleman</a> and includes .erb layouts and views.</p>
                        <p>All of the views you see here (sign in, sign up, users, etc) are already split up so you don't have to waste your time doing it yourself!</p>
                        <p>The layout.erb file includes the header, footer, and side navigation and all of the views are broken out into their own files.</p>
                        <p>If you aren't using Ruby, there is also a set of plain HTML files for each page, just like you would expect.</p>
                    </div>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col-sm-6 col-md-6">
                <div class="panel panel-default">
                    <div class="panel-heading no-collapse">
                <span class="panel-icon pull-right">
                    <a href="#" class="demo-cancel-click" rel="tooltip" title="" data-original-title="Click to refresh"><i class="fa fa-refresh"></i></a>
                </span>

                        Needed to Close
                    </div>
                    <table class="table list">
                        <tbody>
                        <tr>
                            <td>
                                <a href="#"><p class="title">Care Hospital</p></a>
                                <p class="info">Sales Rating: 86%</p>
                            </td>
                            <td>
                                <p>Date: 7/19/2012</p>
                                <a href="#">View Transaction</a>
                            </td>
                            <td>
                                <p class="text-danger h3 pull-right" style="margin-top: 12px;">$20,500</p>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <a href="#"><p class="title">Custom Eyesight</p></a>
                                <p class="info">Sales Rating: 58%</p>
                            </td>
                            <td>
                                <p>Date: 7/19/2012</p>
                                <a href="#">View Transaction</a>
                            </td>
                            <td>
                                <p class="text-danger h3 pull-right" style="margin-top: 12px;">$12,600</p>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <a href="#"><p class="title">Clear Dental</p></a>
                                <p class="info">Sales Rating: 76%</p>
                            </td>
                            <td>
                                <p>Date: 7/19/2012</p>
                                <a href="#">View Transaction</a>
                            </td>
                            <td>
                                <p class="text-danger h3 pull-right" style="margin-top: 12px;">$2,500</p>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <a href="#"><p class="title">Safe Insurance</p></a>
                                <p class="info">Sales Rating: 82%</p>
                            </td>
                            <td>
                                <p>Date: 7/19/2012</p>
                                <a href="#">View Transaction</a>
                            </td>
                            <td>
                                <p class="text-danger h3 pull-right" style="margin-top: 12px;">$22,400</p>
                            </td>
                        </tr>

                        </tbody>
                    </table>
                </div>
            </div>
            <div class="col-sm-6 col-md-6">
                <div class="panel panel-default">
                    <a href="#widget2container" class="panel-heading" data-toggle="collapse">Collapsible </a>
                    <div id="widget2container" class="panel-body collapse in">
                        <h2>Built with Less</h2>
                        <p>The CSS is built with Less. There is a compiled version included if you prefer plain CSS.</p>
                        <p>Fava bean jícama seakale beetroot courgette shallot amaranth pea garbanzo carrot radicchio peanut leek pea sprouts arugula brussels sprout green bean. Spring onion broccoli chicory shallot winter purslane pumpkin gumbo cabbage squash beet greens lettuce celery. Gram zucchini swiss chard mustard burdock radish brussels sprout groundnut. Asparagus horseradish beet greens broccoli brussels.</p>
                        <p><a class="btn btn-primary">Learn more »</a></p>
                    </div>
                </div>
            </div>
        </div>


        <footer>
            <hr>


            <p class="pull-right">Collect from <a href="http://www.cssmoban.com/" title="网页模板" target="_blank">网页模板</a></p>
            <p>&copy; 2014 <a href="#" target="_blank">Portnine</a></p>
        </footer>
    </div>
</div>
</body>
</html>
