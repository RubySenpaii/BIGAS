<%-- 
    Document   : targetproduction
    Created on : Nov 3, 2016, 9:50:00 PM
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

        <script>
            $(function () {
                var values;
                
                $.ajax({
                    url: "PAOTargetProductionCharts",
                    type: 'POST',
                    dataType: 'JSON',
                    success: function (data) {
                        values = data;
                    },
                    async: false
                });
                
                var municipal = [];
                var planted = [];
                var harvested = [];
                var damaged = [];
                
                for (var a = 0; a < values[0].chartValues.length; a++) {
                    municipal.push(values[0].chartValues[a].municipality);
                    planted.push(values[0].chartValues[a].planted);
                    harvested.push(values[0].chartValues[a].harvested);
                    damaged.push(values[0].chartValues[a].damaged);
                }
                
                Highcharts.chart('production', {
                    chart: {
                        type: 'column'
                    },
                    title: {
                        text: 'Planted Area Per Muncipality'
                    },
                    xAxis: {
                        categories: municipal,
                        crosshair: true
                    },
                    yAxis: {
                        min: 0,
                        title: {
                            text: 'Planted Area (ha)'
                        }
                    },
                    tooltip: {
                        headerFormat: '<span style="font-size:10px">{point.key}</span><table>',
                        pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
                                '<td style="padding:0"><b>{point.y:.1f} ha</b></td></tr>',
                        footerFormat: '</table>',
                        shared: true,
                        useHTML: true
                    },
                    plotOptions: {
                        column: {
                            pointPadding: 0.2,
                            borderWidth: 0
                        }
                    },
                    series: [{ data: planted }]
                });

                Highcharts.chart('harvest', {
                    chart: {
                        type: 'column'
                    },
                    title: {
                        text: 'Harvest Amount Per Municipality'
                    },
                    xAxis: {
                        categories: municipal,
                        crosshair: true
                    },
                    yAxis: {
                        min: 0,
                        title: {
                            text: 'Harvested (MT)'
                        }
                    },
                    tooltip: {
                        headerFormat: '<span style="font-size:10px">{point.key}</span><table>',
                        pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
                                '<td style="padding:0"><b>{point.y:.1f} MT</b></td></tr>',
                        footerFormat: '</table>',
                        shared: true,
                        useHTML: true
                    },
                    plotOptions: {
                        column: {
                            pointPadding: 0.2,
                            borderWidth: 0
                        }
                    },
                    series: [{ data: harvested }]
                });

                Highcharts.chart('damaged', {
                    chart: {
                        type: 'column'
                    },
                    title: {
                        text: 'Damaged Area Per Municipality'
                    },
                    xAxis: {
                        categories: municipal,
                        crosshair: true
                    },
                    yAxis: {
                        min: 0,
                        title: {
                            text: 'Damaged Area (ha)'
                        }
                    },
                    tooltip: {
                        headerFormat: '<span style="font-size:10px">{point.key}</span><table>',
                        pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
                                '<td style="padding:0"><b>{point.y:.1f} ha</b></td></tr>',
                        footerFormat: '</table>',
                        shared: true,
                        useHTML: true
                    },
                    plotOptions: {
                        column: {
                            pointPadding: 0.2,
                            borderWidth: 0
                        }
                    },
                    series: [{ data: damaged }]
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
                    <div class="row">
                        <div class="col-md-12 col-sm-12 col-xs-12">
                            <div class="x_panel">
                                <div class="x_title">
                                    <br/>
                                    <div class="row">
                                        <div class="col-md-12 col-sm-12 col-xs-12">
                                            <form class="form-horizontal form-label-left TargetProduction">
                                                <div class="form-group">
                                                    <label class="control-label col-md-3 col-sm-3 col-xs-12">Target Production</label>
                                                    <div class="col-md-4 col-sm-4 col-xs-12">
                                                        <input type="number" class="form-control" name="targetProd">
                                                    </div>
                                                    <button class="btn btn-sm" type="submit" name="action" value="submitTargetProd">Submit</button>
                                                </div>
                                            </form>
                                        </div>
                                    </div>


                                    <div class="clearfix"></div>
                                </div>
                                <div class="x_content">
                                    <div class="row">
                                        <div class="col-md-8 col-sm-8 col-xs-12">
                                            <div class="row">
                                                <div class="col-md-12 col-sm-12 col-xs-12">
                                                    <h2>Planted Area Comparison</h2>
                                                    <div id="production" style="min-width: 310px; height: 400px; margin: 0 auto"></div>
                                                </div>
                                                <div class="col-md-12 col-sm-12 col-xs-12">
                                                    <h2>Harvest Amount Comparison</h2>
                                                    <div id="harvest" style="min-width: 310px; height: 400px; margin: 0 auto"></div>
                                                </div>
                                                <div class="col-md-12 col-sm-12 col-xs-12">
                                                    <h2>Damaged Area Comparison</h2>
                                                    <div id="damaged" style="min-width: 310px; height: 400px; margin: 0 auto"></div>
                                                </div>
                                            </div>
                                        </div>

                                        <div class="col-md-4 col-sm-4 col-xs-12">
                                            <h2>Production Table Contributed by Municipals</h2>

                                            <table class="table table-bordered">
                                                <thead>
                                                    <tr>
                                                        <th>Municipal</th>
                                                        <th>Planted Area</th>
                                                        <th>Amount Harvested</th>
                                                        <th>Damaged Area</th>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                    <%
                                                        ArrayList<GenericObject> objects = (ArrayList<GenericObject>) session.getAttribute("municipalitiesProduction");
                                                        for (int a = 0; a < objects.size(); a++) {
                                                    %>
                                                    <tr>
                                                        <td><%=objects.get(a).getAttribute1()%></td>
                                                        <td><%=objects.get(a).getAttribute2()%></td>
                                                        <td><%=objects.get(a).getAttribute3()%></td>
                                                        <td><%=objects.get(a).getAttribute4()%></td>
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
