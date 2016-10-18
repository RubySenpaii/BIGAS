<%-- 
    Document   : cropprotection
    Created on : Jun 15, 2016, 7:13:10 PM
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
                            <h3>Interventions</h3>
                        </div>

                        <div class="clearfix">

                        </div>

                        <!--page content container-->
                        <div class="row">
                            <div class="col-md-12">
                                <div class="x_panel">
                                    <!--project information-->
                                    <div class="col-md-12 col-sm-12 col-xs-12">
                                        <table class="table table-bordered">
                                            <thead>
                                                <tr>
                                                    <th style="width: 10%">Interventions</th>
                                                    <th style="width: 20%">Purpose</th>
                                                    <th style="width: 15%">Municipality</th>
                                                    <th style="width: 10%">Participants</th>
                                                    <th style="width: 10%">Handled By</th>
                                                    <th style="width: 10%">Start Date</th>
                                                    <th style="width: 10%">End Date</th>
                                                    <th style="width: 15%">Remarks</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <%
                                                    ArrayList<GenericObject> interventions = (ArrayList<GenericObject>) session.getAttribute("interventions");
                                                    for (int a = 0; a < interventions.size(); a++) {
                                                %>
                                                <tr>
                                                    <td><%=interventions.get(a).getAttribute1()%></td>
                                                    <td><%=interventions.get(a).getAttribute2()%></td>
                                                    <td><%=interventions.get(a).getAttribute3()%></td>
                                                    <td><%=interventions.get(a).getAttribute4()%></td>
                                                    <td><%=interventions.get(a).getAttribute5()%></td>
                                                    <td><%=interventions.get(a).getAttribute6()%></td>
                                                    <td><%=interventions.get(a).getAttribute7()%></td>
                                                    <td><%=interventions.get(a).getAttribute8()%></td>
                                                </tr>
                                                <%
                                                    }
                                                %>
                                            </tbody>
                                        </table>
                                            
                                            <button>Create Intervention</button>
                                    </div>
                                    <!--end: project information-->
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