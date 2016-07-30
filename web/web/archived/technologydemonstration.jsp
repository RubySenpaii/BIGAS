<%-- 
    Document   : technologydemonstration
    Created on : Jun 15, 2016, 2:07:58 PM
    Author     : RubySenpaii
--%>

<%@page import="objects.GenericObject"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- Meta, title, CSS, favicons, etc. -->
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <title>Gentallela Alela! | </title>

        <!-- Bootstrap -->
        <link href="/BIGAS/vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
        <!-- Font Awesome -->
        <link href="/BIGAS/vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet">
        <!-- iCheck -->
        <link href="/BIGAS/vendors/iCheck/skins/flat/green.css" rel="stylesheet">

        <!-- Custom Theme Style -->
        <link href="/BIGAS/build/css/custom.min.css" rel="stylesheet">
    </head>

    <body class="nav-md">
        <div class="container body">
            <div class="main_container">
                <jsp:include page="../pages-admin/sidebar.jsp"/>
                <jsp:include page="../pages-admin/header.jsp"/>
                <br />

                <!-- page content -->
                <div class="right_col" role="main">
                    <div class>
                        <!--page header-->
                        <div class="title_left">
                            <h3>Farmer Field School</h3>
                        </div>

                        <div class="clearfix">

                        </div>

                        <!--page content container-->
                        <div class="row">
                            <div class="col-md-12">
                                <div class="x_panel">
                                    <!--project information-->
                                    <div class="col-md-9 col-sm-9 col-xs-12">
                                        <table class="table table-bordered">
                                            <thead>
                                                <tr>
                                                    <th>Program ID</th>
                                                    <th>Site</th>
                                                    <th>Number of Participants</th>
                                                    <th>Progress</th>
                                                    <th>Updated By</th>
                                                    <th>Updated Date</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <%
                                                    ArrayList<GenericObject> programs = (ArrayList<GenericObject>) session.getAttribute("programs");
                                                    for (int a = 0; a < programs.size(); a++) {
                                                %>
                                                <tr>
                                                    <td><%=programs.get(a).getAttribute1()%></td>
                                                    <td><%=programs.get(a).getAttribute2()%></td>
                                                    <td><%=programs.get(a).getAttribute3()%></td>
                                                    <td><%=programs.get(a).getAttribute4()%></td>
                                                    <td><%=programs.get(a).getAttribute5()%></td>
                                                    <td><%=programs.get(a).getAttribute6()%></td>
                                                </tr>
                                                <%
                                                    }
                                                %>
                                            </tbody>
                                        </table>
                                    </div>
                                    <!--end: project information-->

                                    <!--project details-->
                                    <div class="col-md-3 col-sm-3 col-xs-12">
                                        <section class="panel">
                                            <div class="x_title">
                                                <h2>Description</h2>
                                                <div class="clearfix"></div>
                                            </div>

                                            <div class="panel-body">
                                                <p><%=(String) session.getAttribute("description")%></p>
                                            </div>
                                        </section>
                                    </div>
                                    <!--end: project details-->
                                </div>
                                <!--end: page content container-->
                            </div>
                        </div>
                    </div>
                </div>
                <!-- /page content -->
                <jsp:include page="../pages-admin/footer.jsp"/>
            </div>
        </div>

        <!-- jQuery -->
        <script src="/BIGAS/vendors/jquery/dist/jquery.min.js"></script>
        <!-- Bootstrap -->
        <script src="/BIGAS/vendors/bootstrap/dist/js/bootstrap.min.js"></script>
        <!-- FastClick -->
        <script src="/BIGAS/vendors/fastclick/lib/fastclick.js"></script>
        <!-- NProgress -->
        <script src="/BIGAS/vendors/nprogress/nprogress.js"></script>

        <!--Custom Theme Scripts-->
        <script src="/BIGAS/build/js/custom.min.js"></script>
    </body>
</html>