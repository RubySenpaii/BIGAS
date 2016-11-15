<%-- 
    Document   : problemlist
    Created on : Oct 8, 2016, 6:21:06 PM
    Author     : RubySenpaii
--%>

<%@page import="extra.GenericObject"%>
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

        <!-- jQuery -->
        <script src="/BIGAS/vendors/jquery/dist/jquery.min.js"></script>
        <!--highchart.js -->
        <script src="/BIGAS/web/js/highchart/highcharts.js"></script>
        <script src="/BIGAS/web/js/highchart/modules/exporting.js"></script>

    </head>

    <body class="nav-md">
        <div class="container body">
            <div class="main_container">
                <jsp:include page="pagesidebar.jsp"/>
                <jsp:include page="pageheader.jsp"/>
                <br />

                <!-- page content -->
                <div class="right_col" role="main">
                    <div class="row">
                        <!--problem list-->
                        <div class="col-md-12 col-sm-12 col-xs-12">
                            <div class="x_panel">
                                <div class="x_title">
                                    <h2>Problems Logged</h2>
                                    <div class="clearfix"></div>
                                </div>
                                <div class="x_content">
                                    <table class="table table-bordered">
                                        <thead>
                                            <tr>
                                                <th>Problem Name</th>
                                                <th>Problem Details</th>
                                                <th>Municipality</th>
                                                <th>Total Area Affected</th>
                                                <th>Intervention Deployed</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <%
                                                ArrayList<GenericObject> objects = (ArrayList<GenericObject>) session.getAttribute("problemLogs");
                                                for (int a = 0; a < objects.size(); a++) {
                                            %>
                                            <tr>
                                                <td><%=objects.get(a).getAttribute1()%></td>
                                                <td><%=objects.get(a).getAttribute2()%></td>
                                                <td><%=objects.get(a).getAttribute3()%></td>
                                                <td><%=objects.get(a).getAttribute4()%></td>
                                                <td>
                                                    <%
                                                        if (objects.get(a).getAttribute5().equals("No programs deployed.")) {
                                                    %>
                                                    <a href="/BIGAS/ProgramRecommendation?action=recommendProgram&problemIdentified=<%=objects.get(a).getAttribute1()%>&municipality=<%=objects.get(a).getAttribute3()%>&problemId=<%=objects.get(a).getAttribute7()%>"><%=objects.get(a).getAttribute5()%></a>
                                                    <%
                                                        } else {
                                                    %>
                                                    <a href="/BIGAS/ViewProgram?action=viewProgramDetails&deployedID=<%=objects.get(a).getAttribute6()%>"><%=objects.get(a).getAttribute5()%></a>
                                                    <%
                                                        }
                                                    %>
                                                </td>
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
                </div>
                <!-- /page content -->
                <jsp:include page="pagefooter.jsp"/>
            </div>
        </div>

        <!-- Bootstrap -->
        <script src="/BIGAS/vendors/bootstrap/dist/js/bootstrap.min.js"></script>
        <!-- FastClick -->
        <script src="/BIGAS/vendors/fastclick/lib/fastclick.js"></script>
        <!-- NProgress -->
        <script src="/BIGAS/vendors/nprogress/nprogress.js"></script>
        <!-- gauge.js -->
        <script src="/BIGAS/vendors/bernii/gauge.js/dist/gauge.min.js"></script>
        <!-- bootstrap-progressbar -->
        <script src="/BIGAS/vendors/bootstrap-progressbar/bootstrap-progressbar.min.js"></script>

        <!-- Custom Theme Scripts -->
        <script src="/BIGAS/build/js/custom.min.js"></script>
    </body>
</html>
