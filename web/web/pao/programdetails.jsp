<%-- 
    Document   : programdetails
    Created on : Nov 9, 2016, 7:40:15 PM
    Author     : RubySenpaii
--%>

<%@page import="objects.ProgramPlan"%>
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
                                    <h2>Program Plan Detail</h2>
                                    <div class="clearfix"></div>
                                </div>
                                <div class="x_content">
                                    <div class="row">
                                        <div class="col-md-9 col-sm-9 col-xs-12">
                                            <h4>Program Procedure and Progress</h4>
                                            <table class="table table-bordered">
                                                <thead>
                                                    <tr>
                                                        <th style="width: 10%">Procedure No</th>
                                                        <th style="width: 20%">Phase</th>
                                                        <th style="width: 50%">Activity</th>
                                                        <th style="width: 20%">Date Completed</th>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                    <%
                                                        ArrayList<GenericObject> procedureProgress = (ArrayList<GenericObject>) session.getAttribute("procedureProgress");
                                                        for (int a = 0; a < procedureProgress.size(); a++) {
                                                    %>
                                                    <tr>
                                                        <td><%=procedureProgress.get(a).getAttribute1()%></td>
                                                        <td><%=procedureProgress.get(a).getAttribute2()%></td>
                                                        <td><%=procedureProgress.get(a).getAttribute3()%></td>
                                                        <td><%=procedureProgress.get(a).getAttribute4()%></td>
                                                    </tr>
                                                    <%
                                                        }
                                                    %>
                                                </tbody>
                                            </table>
                                        </div>

                                        <!-- start project-detail sidebar -->
                                        <div class="col-md-3 col-sm-3 col-xs-12">

                                            <section class="panel">

                                                <div class="x_title">
                                                    <h2>Project Description</h2>
                                                    <div class="clearfix"></div>
                                                </div>
                                                <div class="panel-body">
                                                    <%
                                                        ProgramPlan programPlan = (ProgramPlan) session.getAttribute("programPlan");
                                                    %>
                                                    <h3 class="green"> <%=programPlan.getProgramName()%></h3>

                                                    <p><%=programPlan.getDescription()%></p>
                                                    <br />

                                                    <div class="project_detail">
                                                        <p class="title">Project Members - Position</p>
                                                        <%
                                                            ArrayList<GenericObject> programMembers = (ArrayList<GenericObject>) session.getAttribute("programMembers");
                                                            for (int a = 0; a < programMembers.size(); a++) {
                                                        %>
                                                        <p><%=programMembers.get(a).getAttribute1() + " - " + programMembers.get(a).getAttribute2()%></p>
                                                        <%
                                                            }
                                                        %>

                                                        <br/>

                                                        <div class="row">
                                                            <div class="col-md-6">
                                                                <p class="title">Seed Provided</p>
                                                                <p><%=(String) session.getAttribute("seedVarietyProvided")%></p>
                                                            </div>
                                                            <div class="col-md-6">
                                                                <p class="title">Fertilizer Provided</p>
                                                                <p><%=(String) session.getAttribute("fertilizerProvided")%></p>
                                                            </div>
                                                        </div>

                                                        <br/>

                                                        <!--div class="row">
                                                            <div class="col-md-12">
                                                                <p class="title">Damage Report IDs</p>
                                                                <p>1</p>
                                                            </div>
                                                        </div-->
                                                    </div>

                                                    <h3>Beneficiaries</h3>
                                                    <table class="table table-bordered">
                                                        <thead>
                                                            <tr>
                                                                <th style="width: 40%">Farmer Name</th>
                                                                <th style="width: 30%">Seeds Allocated</th>
                                                                <th style="width: 30%">Fertilizer Allocated</th>
                                                            </tr>
                                                        </thead>
                                                        <tbody>
                                                            <%
                                                                ArrayList<GenericObject> programParticipants = (ArrayList<GenericObject>) session.getAttribute("programParticipants");
                                                                for (int a = 0; a < programParticipants.size(); a++) {
                                                            %>
                                                            <tr>
                                                                <td><%=programParticipants.get(a).getAttribute1()%></td>
                                                                <td><%=programParticipants.get(a).getAttribute2()%></td>
                                                                <td><%=programParticipants.get(a).getAttribute3()%></td>
                                                            </tr>
                                                            <%
                                                                }
                                                            %>
                                                        </tbody>
                                                    </table>
                                                </div>
                                            </section>
                                        </div>
                                        <!-- end project-detail sidebar -->
                                    </div>
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
