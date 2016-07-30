<%-- 
    Document   : barangay
    Created on : Jun 24, 2016, 7:08:39 PM
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

        <title>B.I.G.A.S. System | Season - Municipal</title>

        <!-- Bootstrap -->
        <link href="/BIGAS/vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
        <!-- Font Awesome -->
        <link href="/BIGAS/vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet">
        <!-- iCheck -->
        <link href="/BIGAS/vendors/iCheck/skins/flat/green.css" rel="stylesheet">
        <!-- bootstrap-progressbar -->
        <link href="/BIGAS/vendors/bootstrap-progressbar/css/bootstrap-progressbar-3.3.4.min.css" rel="stylesheet">

        <!-- Custom Theme Style -->
        <link href="/BIGAS/build/css/custom.min.css" rel="stylesheet">

        <!--Google Map Responsive -->
        <link href="/BIGAS/web/css/maps/googlemaps.css" rel="stylesheet">
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
                            <h3>Barangay Details</h3>
                        </div>

                        <div class="clearfix">

                        </div>

                        <!--page content container-->
                        <div class="row">

                            <!--production data-->
                            <div style="margin: 20px">
                                <table class="table table-bordered">
                                    <thead>
                                        <tr>
                                            <th style="width: 15%">Farm Name</th>
                                            <th style="width: 20%">Farmer</th>
                                            <th style="width: 10%">Seed Variety</th>
                                            <th style="width: 15%">Area Planted</th>
                                            <th style="width: 15%">Harvested</th>
                                            <th style="width: 15%">Damage</th>
                                            <th style="width: 10%">Average Yield</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <%
                                            ArrayList<GenericObject> production = (ArrayList<GenericObject>) session.getAttribute("production");
                                            for (int a = 0; a < production.size(); a++) {
                                        %>
                                        <tr>
                                            <td><%=production.get(a).getAttribute1()%></td>
                                            <td><%=production.get(a).getAttribute2()%></td>
                                            <td><%=production.get(a).getAttribute3()%></td>
                                            <td><%=production.get(a).getAttribute4()%></td>
                                            <td><%=production.get(a).getAttribute5()%></td>
                                            <td><%=production.get(a).getAttribute6()%></td>
                                            <td><%=production.get(a).getAttribute7()%></td>
                                        </tr>
                                        <%
                                            }
                                        %>
                                    </tbody>
                                </table>
                            </div>
                            <!--end: production data-->

                        </div>
                    </div>
                    <!-- page content -->
                </div>
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
        <!-- iCheck -->
        <script src="/BIGAS/vendors/iCheck/icheck.min.js"></script>
        <!-- Skycons -->
        <script src="/BIGAS/vendors/skycons/skycons.js"></script>

        <!-- Custom Theme Scripts -->
        <script src="/BIGAS/build/js/custom.min.js"></script>
    </body>
</html>

