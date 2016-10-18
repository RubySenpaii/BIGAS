<%-- 
    Document   : createtargetproduction
    Created on : Oct 12, 2016, 7:42:45 PM
    Author     : RubySenpaii
--%>

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
        <link href="../../vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
        <!-- Font Awesome -->
        <link href="../../vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet">
        <!-- iCheck -->
        <link href="../../vendors/iCheck/skins/flat/green.css" rel="stylesheet">
        <!-- bootstrap-progressbar -->
        <link href="../../vendors/bootstrap-progressbar/css/bootstrap-progressbar-3.3.4.min.css" rel="stylesheet">
        <!-- jVectorMap -->
        <link href="../css/maps/jquery-jvectormap-2.0.3.css" rel="stylesheet"/>

        <!-- Custom Theme Style -->
        <link href="../../build/css/custom.min.css" rel="stylesheet">

        <!-- jQuery -->
        <script src="../../vendors/jquery/dist/jquery.min.js"></script>
        <!--highchart.js -->
        <script src="../js/highchart/highcharts.js"></script>
        <script src="../js/highchart/modules/exporting.js"></script>

        <script type="text/javascript">
            $(function () {
                $('#productionpie').highcharts({
                    chart: {
                        plotBackgroundColor: null,
                        plotBorderWidth: null,
                        plotShadow: false,
                        type: 'pie'
                    },
                    title: {
                        text: 'Browser market shares January, 2015 to May, 2015'
                    },
                    tooltip: {
                        pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
                    },
                    plotOptions: {
                        pie: {
                            allowPointSelect: true,
                            cursor: 'pointer',
                            dataLabels: {
                                enabled: true,
                                format: '<b>{point.name}</b>: {point.percentage:.1f} %',
                                style: {
                                    color: (Highcharts.theme && Highcharts.theme.contrastTextColor) || 'black'
                                }
                            }
                        }
                    },
                    series: [{
                            name: 'Area',
                            colorByPoint: true,
                            data: [{
                                    name: 'Area Harvested',
                                    y: 56.33
                                }, {
                                    name: 'Pest and Diseases',
                                    y: 24.03,
                                }, {
                                    name: 'Natural Calamity',
                                    y: 10.38
                                }, {
                                    name: 'Other',
                                    y: 4.77
                                }]
                        }]
                });

                $('#yearlyproduction').highcharts({
                    title: {
                        text: 'Yearly Production and Target',
                        x: -20 //center
                    },
                    subtitle: {
                        text: 'Source: WorldClimate.com',
                        x: -20
                    },
                    xAxis: {
                        categories: ['2011', '2012', '2013', '2014', '2015']
                    },
                    yAxis: {
                        title: {
                            text: 'Temperature (°C)'
                        },
                        plotLines: [{
                                value: 0,
                                width: 1,
                                color: '#808080'
                            }]
                    },
                    tooltip: {
                        valueSuffix: '°C'
                    },
                    legend: {
                        layout: 'vertical',
                        align: 'right',
                        verticalAlign: 'middle',
                        borderWidth: 0
                    },
                    series: [{
                            name: 'Actual',
                            data: [245.21, 312.21, 124.22, 231.32, 301.21]
                        }, {
                            name: 'Target',
                            data: [221.12, 311.32, 140.25, 241.68, 331.21]
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
                    <div class="row">
                        <!--problem list-->
                        <div class="col-md-12 col-sm-12 col-xs-12">
                            <div class="x_panel">
                                <div class="x_title">
                                    <h2>Set Target Production</h2>
                                    <div class="clearfix"></div>
                                </div>
                                <div class="x_content">
                                    <div class="row">
                                        <div class="col-md-9 col-sm-9 col-xs-12">
                                            <h4>Yearly Comparison</h4>
                                            <div class="col-md-6 col-sm-6 col-xs-12">
                                                <div id="yearlyproduction" style="min-width: fit-content; height: 300px; margin: 0  auto"></div>
                                            </div>
                                            <div class="col-md-6 col-sm-6 col-xs-12">
                                                <div id="productionpie" style="min-width: fit-content; height: 300px; margin: 0 auto"></div>
                                            </div>

                                            <table class="table table-bordered">
                                                <thead>
                                                    <tr>
                                                        <th>Municipality</th>
                                                        <th>Farm Area</th>
                                                        <th>Production</th>
                                                        <th>Estimated Damages</th>
                                                    </tr>
                                                </thead>
                                                <tfoot>
                                                    <tr>
                                                        <td colspan="2">Total</td>
                                                        <td></td>
                                                        <td></td>
                                                    </tr>
                                                </tfoot>
                                            </table>
                                        </div>

                                        <div class="col-md-3 col-sm-3 col-xs-12">
                                            <h4>Set Target production</h4>

                                            <div class="row">
                                                <div class="col-md-6">
                                                    <div class="project_detail">
                                                        <br/>
                                                        <p class="title">Recommended Target: </p>
                                                        <p>36,000 MT</p>
                                                    </div><br/>
                                                </div>
                                            </div>


                                            <form class="form-horizontal form-label-left">
                                                <div class="form-group">
                                                    <label class="control-label col-md-5 col-sm-5 col-xs-12">Target Production: </label>
                                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                                        <input type="text" class="form-control col-md-6 col-sm-6 col-xs-12">
                                                    </div>
                                                </div>
                                            </form>
                                        </div>
                                    </div>

                                    <div class="row">
                                        <div class="col-md-12 col-sm-12 col-xs-12">
                                            <!--tabs-->
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
        <script src="../../vendors/bootstrap/dist/js/bootstrap.min.js"></script>
        <!-- FastClick -->
        <script src="../../vendors/fastclick/lib/fastclick.js"></script>
        <!-- NProgress -->
        <script src="../../vendors/nprogress/nprogress.js"></script>
        <!-- gauge.js -->
        <script src="../../vendors/bernii/gauge.js/dist/gauge.min.js"></script>
        <!-- bootstrap-progressbar -->
        <script src="../../vendors/bootstrap-progressbar/bootstrap-progressbar.min.js"></script>

        <!-- Custom Theme Scripts -->
        <script src="../../build/js/custom.min.js"></script>
    </body>
</html>
