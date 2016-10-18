<%-- 
    Document   : programlist
    Created on : Jun 1, 2016, 8:25:11 PM
    Author     : RubySenpaii
--%>

<%@page import="objects.program.Program"%>
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
        <!-- bootstrap-progressbar -->
        <link href="/BIGAS/vendors/bootstrap-progressbar/css/bootstrap-progressbar-3.3.4.min.css" rel="stylesheet">
        <!-- jVectorMap -->
        <link href="/BIGAS/web/css/maps/jquery-jvectormap-2.0.3.css" rel="stylesheet"/>

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
                            <h3>Program List</h3>
                        </div>

                        <div class="clearfix">

                        </div>

                        <div class="row">
                            <div class="col-md-12">
                                <table class="table table-bordered">
                                    <thead>
                                        <tr>
                                            <th style="width: 20%">Program Code</th>
                                            <th style="width: 20%">Program Name</th>
                                            <th style="width: 60%">Description</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <%
                                            ArrayList<Program> programs = (ArrayList<Program>) session.getAttribute("programs");
                                            for (int a = 0; a < programs.size(); a++) {
                                        %>
                                        <tr>
                                            <td><%=programs.get(a).getProgramCode()%></td>
                                            <td><%=programs.get(a).getProgramName()%></td>
                                            <td><%=programs.get(a).getDescription()%></td>
                                        </tr>
                                        <%
                                            }
                                        %>
                                    </tbody>
                                </table>
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
        <!-- bootstrap-progressbar -->
        <script src="/BIGAS/vendors/bootstrap-progressbar/bootstrap-progressbar.min.js"></script>


        <!-- Custom Theme Scripts -->
        <script src="/BIGAS/build/js/custom.min.js"></script>


    </body>
</html>

