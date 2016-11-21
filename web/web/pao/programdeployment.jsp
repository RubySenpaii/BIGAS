<%-- 
    Document   : programdeployment
    Created on : Nov 5, 2016, 11:06:03 PM
    Author     : RubySenpaii
--%>

<%@page import="objects.Fertilizer"%>
<%@page import="objects.SeedVariety"%>
<%@page import="extra.GenericObject"%>
<%@page import="objects.ProgramProcedure"%>
<%@page import="objects.ProgramObjectives"%>
<%@page import="java.util.ArrayList"%>
<%@page import="objects.ProgramPlan"%>
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
                                    <h2>Program Deployment</h2>
                                    <div class="clearfix"></div>
                                </div>
                                <div class="x_content">
                                    <form class="ProgramDeployment">
                                        <div class="row">
                                            <div class="col-md-8 col-sm-8 col-xs-12">
                                                <h4>Program Details</h4>

                                                <%
                                                    ProgramPlan programPlan = (ProgramPlan) session.getAttribute("programPlan");
                                                %>
                                                <div class="row">
                                                    <div class="col-md-8">
                                                        <div class="col-md-4">
                                                            <div class="project_detail">
                                                                <p class="title">Program Name:</p>
                                                                <p><%=programPlan.getProgramName()%></p>
                                                            </div><br/>
                                                        </div>
                                                        <div class="col-md-4">
                                                            <div class="project_detail">
                                                                <p class="title">Type:</p>
                                                                <p><%=programPlan.getType()%></p>
                                                            </div><br/>
                                                        </div>
                                                        <div class="col-md-12">
                                                            <div class="project_detail">
                                                                <p class="title">Description:</p>
                                                                <p><%=programPlan.getDescription()%></p>
                                                            </div>
                                                        </div>
                                                    </div>

                                                    <div class="col-md-4">
                                                        <h4>Objectives</h4>
                                                        <table class="table table-bordered">
                                                            <thead>
                                                                <tr>
                                                                    <th>Indicator</th>
                                                                    <th>Target Value</th>
                                                                </tr>
                                                            </thead>
                                                            <tbody>
                                                                <%
                                                                    ArrayList<ProgramObjectives> objectives = (ArrayList<ProgramObjectives>) session.getAttribute("programObjectives");
                                                                    for (int a = 0; a < objectives.size(); a++) {
                                                                %>
                                                                <tr>
                                                                    <td><%=objectives.get(a).getIndicator()%></td>
                                                                    <td><%=objectives.get(a).getTargetValue()%></td>
                                                                </tr>
                                                                <%
                                                                    }
                                                                %>
                                                            </tbody>
                                                        </table>
                                                    </div>
                                                </div>

                                                <div class="col-md-12">
                                                    <h4>Activities for Program</h4>
                                                    <table class="table table-bordered">
                                                        <thead>
                                                            <tr>
                                                                <th style="width: 30px">#</th>
                                                                <th style="width: 35%">Phase</th>
                                                                <th style="width: 65%">Activity</th>
                                                            </tr>
                                                        </thead>
                                                        <tbody>
                                                            <%
                                                                ArrayList<ProgramProcedure> procedures = (ArrayList<ProgramProcedure>) session.getAttribute("programProcedures");
                                                                for (int a = 0; a < procedures.size(); a++) {
                                                            %>
                                                            <tr>
                                                                <td><%=procedures.get(a).getProcedureNo()%></td>
                                                                <td><%=procedures.get(a).getPhase()%></td>
                                                                <td><%=procedures.get(a).getActivity()%></td>
                                                            </tr>
                                                            <%
                                                                }
                                                            %>
                                                        </tbody>
                                                    </table>
                                                </div>
                                            </div>

                                            <div class="col-md-4 col-sm-4 col-xs-12">
                                                <div class="row">
                                                    <div class="col-md-12 col-sm-12 col-xs-12">
                                                        <h4>Program Beneficiaries</h4>

                                                        <table class="table table-bordered">
                                                            <thead>
                                                                <tr>
                                                                    <th style="width: 40%">Barangay</th>
                                                                    <th style="width: 30%">Area Affected</th>
                                                                    <th style="width: 30%">No of Farmers</th>
                                                                </tr>
                                                            </thead>
                                                            <tbody>
                                                                <%
                                                                    ArrayList<extra.GenericObject> beneficiaries = (ArrayList<extra.GenericObject>) session.getAttribute("barangayBeneficiaries");
                                                                    for (int a = 0; a < beneficiaries.size(); a++) {
                                                                %>
                                                                <tr>
                                                                    <td><%=beneficiaries.get(a).getAttribute1()%></td>
                                                                    <td><%=beneficiaries.get(a).getAttribute2()%></td>
                                                                    <td><%=beneficiaries.get(a).getAttribute3()%></td>
                                                                </tr>
                                                                <%
                                                                    }
                                                                %>
                                                            </tbody>
                                                        </table>
                                                    </div>

                                                    <div class="col-md-12 col-sm-12 col-xs-12">
                                                        <div class="row">
                                                            <div class="col-md-12">
                                                                <label>Project Lead: </label>
                                                                <input type="text" class="form-control" name="projectLead">
                                                            </div>
                                                        </div>
                                                    </div>

                                                    <div class="col-md-12 col-sm-12 col-xs-12">
                                                        <h4>Provisions (Optional)</h4>

                                                        <div class="row">
                                                            <div class="col-md-8">
                                                                <label>Seed Variety</label>
                                                                <select name="seedVariety" class="form-control">
                                                                    <%
                                                                        ArrayList<SeedVariety> varieties = (ArrayList<SeedVariety>) session.getAttribute("seedVarieties");
                                                                        for (int a = 0; a < varieties.size(); a++) {
                                                                    %>
                                                                    <option><%=varieties.get(a).getVarietyName()%></option>
                                                                    <%
                                                                        }
                                                                    %>
                                                                </select>
                                                            </div>
                                                            <div class="col-md-4">
                                                                <label>Amount Provided</label>
                                                                <input type="text" class="form-control" name="seedAmount">
                                                            </div>
                                                        </div>
                                                        <div class="row">
                                                            <div class="col-md-8">
                                                                <label>Fertilizer</label>
                                                                <select name="fertilizer" class="form-control">
                                                                    <%
                                                                        ArrayList<Fertilizer> fertilizers = (ArrayList<Fertilizer>) session.getAttribute("fertilizers");
                                                                        for (int a = 0; a < fertilizers.size(); a++) {
                                                                    %>
                                                                    <option><%=fertilizers.get(a).getFertilizerName()%></option>
                                                                    <%
                                                                        }
                                                                    %>
                                                                </select>
                                                            </div>
                                                            <div class="col-md-4">
                                                                <label>Amount Provided</label>
                                                                <input type="text" class="form-control" name="fertilizerAmount">
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>

                                        <div>
                                            <div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-5">
                                                <button type="submit" class="btn btn-lg btn-primary" name="action">Cancel</button>
                                                <button type="submit" class="btn btn-lg btn-success" name="action" value="submitProgramDetail">Next</button>
                                            </div>
                                        </div>
                                    </form>
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
