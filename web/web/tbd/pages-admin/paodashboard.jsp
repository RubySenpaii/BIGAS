<%-- 
    Document   : dashboard
    Created on : May 29, 2016, 10:14:34 AM
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
    <a href="paodashboard.jsp"></a>
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
                $('#productionGraph').highcharts({
                    chart: {
                        type: 'line'
                    },
                    title: {
                        text: 'Actual vs Target'
                    },
                    xAxis: {
                        categories: ['2010', '2011', '2012', '2013', '2014', '2015', '2016']
                    },
                    yAxis: {
                        title: {
                            text: 'Metric Tons'
                        }
                    },
                    plotOptions: {
                        line: {
                            dataLabels: {
                                enabled: true
                            },
                            enableMouseTracking: false
                        }
                    },
                    series: [{
                            name: 'Actual',
                            data: [7.0, 6.9, 9.5, 14.5, 18.4, 21.5, 25.2]
                        }, {
                            name: 'Target',
                            data: [3.9, 4.2, 5.7, 8.5, 11.9, 15.2, 17.0]
                        }]
                });

                $('#damages').highcharts({
                    chart: {
                        plotBackgroundColor: null,
                        plotBorderWidth: null,
                        plotShadow: false,
                        type: 'pie'
                    },
                    title: {
                        text: 'Cause of Damages'
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
                            name: 'Percentage',
                            colorByPoint: true,
                            data: [{
                                    name: 'Black Bugs',
                                    y: 56.33
                                }, {
                                    name: 'Typhoon Yolanda',
                                    y: 24.03
                                }, {
                                    name: 'Rat Infestation',
                                    y: 10.38
                                }, {
                                    name: 'Earthquake',
                                    y: 4.77
                                }]
                        }]
                });
                
                $('#plantedArea').highcharts({
                    chart: {
                        type: 'line'
                    },
                    title: {
                        text: 'Weekly Planted Area'
                    },
                    xAxis: {
                        categories: ['Week1', 'Week2', 'Week3', 'Week4', 'Week5', 'Week6', 'Week7']
                    },
                    yAxis: {
                        title: {
                            text: 'Area (ha)'
                        }
                    },
                    plotOptions: {
                        line: {
                            dataLabels: {
                                enabled: true
                            },
                            enableMouseTracking: false
                        }
                    },
                    series: [{
                            name: 'Planted Area',
                            data: [7.0, 6.9, 9.5, 14.5, 18.4, 21.5, 25.2]
                        }]
                });
            });
        </script>
    </head>

    <body class="nav-md">
        <div class="container body">
            <div class="main_container">
                <jsp:include page="sidebar.jsp"/>
                <jsp:include page="header.jsp"/>
                <br />

                <!-- page content -->
                <div class="right_col" role="main">
                    <div class="row">
                        <div class="col-md-7 col-sm-7 col-xs-12">
                            <div class="x_panel">
                                <div class="x_title">
                                    <h2>Annual Target and Production<small><a href="targetproduction.jsp">Click here to set target</a></small></h2>
                                    

                                    <div class="clearfix"></div>
                                </div>
                                <div class="x_content">
                                    <div id="productionGraph" style="min-width: 310px; height: 400px; margin: 0 auto"></div>
                                </div>
                            </div>
                        </div>

                        <div class="col-md-5 col-sm-5 col-xs-12">
                            <div class="x_panel">
                                <div class="x_title">
                                    <h2>Cause of Damages</h2>

                                    <div class="clearfix"></div>
                                </div>
                                <div class="x_content">
                                    <div id="damages" style="min-width: 310px; height: 400px; max-width: 600px; margin: 0 auto"></div>
                                </div>
                            </div>
                        </div>
                    </div>
                    
                    <div class="row">
                        <div class="col-md-12 col-sm-12 col-xs-12">
                            <div class="x_panel">
                                <div class="x_title">
                                    <h2>Weekly Planted Area</h2>

                                    <div class="clearfix"></div>
                                </div>
                                <div class="x_content">
                                    <div id="plantedArea" style="min-width: 310px; height: 400px; margin: 0 auto"></div>
                                </div>
                        </div>
                    </div>
                </div>
                <!-- /page content -->
                <jsp:include page="footer.jsp"/>
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

