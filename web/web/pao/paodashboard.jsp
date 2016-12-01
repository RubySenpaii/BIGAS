<%-- 
    Document   : paodashboard
    Created on : Nov 16, 2016, 3:37:09 PM
    Author     : RubySenpaii
--%>

<%@page import="extra.GenericObject"%>
<%@page import="java.util.ArrayList"%>
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
        <script src="/BIGAS/web/js/highchart/modules/drilldown.js"></script>

        <script type="text/javascript">
            $(function () {
                var values;

                $.ajax({
                    url: "PAODashboard",
                    type: 'POST',
                    dataType: 'JSON',
                    success: function (data) {
                        values = data;
                    },
                    async: false
                });

                var plantData = [];
                var categoriesP = [];
                for (var a = 0; a < values[0].planting.length; a++) {
                    categoriesP.push(values[0].planting[a].municipal);
                    plantData.push(values[0].planting[a].value);
                }

                var harvestData = [];
                var categoriesH = [];
                for (var a = 0; a < values[0].production.length; a++) {
                    categoriesH.push(values[0].production[a].municipal);
                    harvestData.push(values[0].production[a].value);
                }

                var targetHarvest = [];
                for (var a = 0; a < values[0].productionTarget.length; a++) {
                    targetHarvest.push(values[0].productionTarget[a].value);
                }

                var targetPlanting = [];
                for (var a = 0; a < values[0].plantingTarget.length; a++) {
                    targetPlanting.push(values[0].plantingTarget[a].value);
                }


                Highcharts.chart('plantingComparison', {
                    chart: {
                        zoomType: 'xy'
                    },
                    title: {
                        text: 'Planted Area Per Municpality'
                    },
                    subtitle: {
                        text: ''
                    },
                    xAxis: [{
                            categories: categoriesP,
                            crosshair: true
                        }],
                    yAxis: [{// Primary yAxis
                            labels: {
                                format: '{value}kg/ha',
                                style: {
                                    color: Highcharts.getOptions().colors[1]
                                }
                            }

                        }],
                    tooltip: {
                        shared: true
                    },
                    legend: {
                        layout: 'vertical',
                        align: 'left',
                        x: 80,
                        verticalAlign: 'top',
                        y: 55,
                        floating: true,
                        backgroundColor: (Highcharts.theme && Highcharts.theme.legendBackgroundColor) || '#FFFFFF'
                    },
                    series: [{
                            name: 'Seeds Planted/Area',
                            type: 'column',
                            data: plantData,
                            tooltip: {
                                valueSuffix: ' kg/ha'
                            }
                        }, {
                            name: 'Target Seeds Planted/Area',
                            type: 'spline',
                            data: targetPlanting,
                            tooltip: {
                                valueSuffix: ' kg/ha'
                            }
                        }]
                });

                Highcharts.chart('harvestComparison', {
                    chart: {
                        zoomType: 'xy'
                    },
                    title: {
                        text: 'Production Yield Per Municipality'
                    },
                    subtitle: {
                        text: ''
                    },
                    xAxis: [{
                            categories: categoriesH,
                            crosshair: true
                        }],
                    yAxis: [{// Primary yAxis
                            labels: {
                                format: '{value}MT/ha',
                                style: {
                                    color: Highcharts.getOptions().colors[1]
                                }
                            },
                            title: {
                                text: 'Yield',
                                style: {
                                    color: Highcharts.getOptions().colors[1]
                                }
                            }

                        }],
                    tooltip: {
                        shared: true
                    },
                    legend: {
                        layout: 'vertical',
                        align: 'left',
                        x: 80,
                        verticalAlign: 'top',
                        y: 55,
                        floating: true,
                        backgroundColor: (Highcharts.theme && Highcharts.theme.legendBackgroundColor) || '#FFFFFF'
                    },
                    series: [{
                            name: 'Production Yield',
                            type: 'column',
                            data: harvestData,
                            tooltip: {
                                valueSuffix: ' MT/ha'
                            }

                        }, {
                            name: 'Target Yield',
                            type: 'spline',
                            data: targetHarvest,
                            tooltip: {
                                valueSuffix: ' MT/ha'
                            }
                        }]
                });
            });
        </script>
    </head>

    <body class="nav-md">
        <div class="container body">
            <div class="main_container">
                <jsp:include page="pagesidebar.jsp"/>
                <jsp:include page="pageheader.jsp"/>
                <br />

                <!-- page content -->
                <div class="right_col" role="main">
                    <jsp:include page="notifications.jsp"/>
                    <div class="row">
                        <div class="col-md-12 col-sm-12 col-xs-12">
                            <div class="x_panel">
                                <div class="x_title">
                                    <h2>Harvest Amount Comparison</h2>


                                    <div class="clearfix"></div>
                                </div>
                                <div class="x_content">
                                    <div id="harvestComparison" style="min-width: fit-content; height: 400px; margin: 0 auto"></div>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <div class="x_panel">
                                <div class="x_title">
                                    <h2>Suggested Programs For Production</h2>

                                    <div class="clearfix"></div>
                                </div>
                                <div class="x_content">
                                    <table class="table table-bordered table-striped">
                                        <thead>
                                            <tr>
                                                <th>Program Name</th>
                                                <th>Description</th>
                                                <th>Action</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <%
                                                ArrayList<GenericObject> suggestedProgramsProduction = (ArrayList<GenericObject>) session.getAttribute("suggestedProgramsProduction");
                                                for (int a = 0; a < suggestedProgramsProduction.size(); a++) {
                                            %>
                                            <tr>
                                                <td><%=suggestedProgramsProduction.get(a).getAttribute1()%></td>
                                                <td><%=suggestedProgramsProduction.get(a).getAttribute2()%></td>
                                                <td>
                                                    <form action="ProgramDeployment">
                                                        <input type="hidden" name="programName" value="<%=suggestedProgramsProduction.get(a).getAttribute1()%>">
                                                        <input type="hidden" name="action" value="submitProgramProdDetail">
                                                        <button type="submit" class="btn btn-sm btn-success">Deploy</button>
                                                    </form>
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

                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <div class="x_panel">
                                <div class="x_title">
                                    <h2>Active Programs For Production</h2>

                                    <div class="clearfix"></div>
                                </div>
                                <div class="x_content">
                                    <table class="table table-bordered table-striped">
                                        <thead>
                                            <tr>
                                                <th>Program Name</th>
                                                <th>Description</th>
                                                <th>Status</th>
                                                <th>Date Started</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <%
                                                ArrayList<GenericObject> activeProgramsProduction = (ArrayList<GenericObject>) session.getAttribute("activeProgramsProduction");
                                                for (int a = 0; a < activeProgramsProduction.size(); a++) {
                                            %>
                                            <tr>
                                                <td><%=activeProgramsProduction.get(a).getAttribute1()%></td>
                                                <td><%=activeProgramsProduction.get(a).getAttribute2()%></td>
                                                <td><%=activeProgramsProduction.get(a).getAttribute3()%></td>
                                                <td><%=activeProgramsProduction.get(a).getAttribute4()%></td>
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

                    <div class="row">
                        <div class="col-md-12 col-sm-12 col-xs-12">
                            <div class="x_panel">
                                <div class="x_title">
                                    <h2>Planted Area Comparison</h2>
                                    <div class="clearfix"></div>
                                </div>
                                <div class="x_content">
                                    <div id="plantingComparison" style="min-width: fit-content; height: 400px; margin: 0 auto"></div>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <div class="x_panel">
                                <div class="x_title">
                                    <h2>Suggested Programs For Planting and Growth</h2>

                                    <div class="clearfix"></div>
                                </div>
                                <div class="x_content">
                                    <table class="table table-bordered table-striped">
                                        <thead>
                                            <tr>
                                                <th>Program Name</th>
                                                <th>Description</th>
                                                <th>Action</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <%
                                                ArrayList<GenericObject> suggestedProgramsPlanting = (ArrayList<GenericObject>) session.getAttribute("suggestedProgramsPlanting");
                                                for (int a = 0; a < suggestedProgramsPlanting.size(); a++) {
                                            %>
                                            <tr>
                                                <td><%=suggestedProgramsPlanting.get(a).getAttribute1()%></td>
                                                <td><%=suggestedProgramsPlanting.get(a).getAttribute2()%></td>
                                                <td>
                                                    <form action="ProgramDeployment">
                                                        <input type="hidden" name="programName" value="<%=suggestedProgramsPlanting.get(a).getAttribute1()%>">
                                                        <input type="hidden" name="action" value="submitProgramProdDetail">
                                                        <button class="btn btn-sm btn-success">Deploy</button>
                                                    </form>
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

                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <div class="x_panel">
                                <div class="x_title">
                                    <h2>Active Programs For Planting and Growth</h2>

                                    <div class="clearfix"></div>
                                </div>
                                <div class="x_content">
                                    <table class="table table-bordered table-striped">
                                        <thead>
                                            <tr>
                                                <th>Program Name</th>
                                                <th>Description</th>
                                                <th>Status</th>
                                                <th>Date Started</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <%
                                                ArrayList<GenericObject> activeProgramsPlanting = (ArrayList<GenericObject>) session.getAttribute("activeProgramsPlanting");
                                                for (int a = 0; a < activeProgramsPlanting.size(); a++) {
                                            %>
                                            <tr>
                                                <td><%=activeProgramsPlanting.get(a).getAttribute1()%></td>
                                                <td><%=activeProgramsPlanting.get(a).getAttribute2()%></td>
                                                <td><%=activeProgramsPlanting.get(a).getAttribute3()%></td>
                                                <td><%=activeProgramsPlanting.get(a).getAttribute4()%></td>
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
