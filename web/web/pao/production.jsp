<%-- 
    Document   : production
    Created on : Sep 19, 2016, 8:33:08 PM
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

        <title>B.I.G.A.S. System | Map Overview</title>

        <!-- Bootstrap -->
        <link href="../../vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
        <!-- Font Awesome -->
        <link href="../../vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet">
        <!-- iCheck -->
        <link href="../../vendors/iCheck/skins/flat/green.css" rel="stylesheet">
        <!-- bootstrap-progressbar -->
        <link href="../../vendors/bootstrap-progressbar/css/bootstrap-progressbar-3.3.4.min.css" rel="stylesheet">

        <!-- Custom Theme Style -->
        <link href="../../build/css/custom.min.css" rel="stylesheet">

        <!--Google Map Responsive -->
        <link href="../../web/css/maps/googlemaps.css" rel="stylesheet">

        <!-- jQuery -->
        <script src="../../vendors/jquery/dist/jquery.min.js"></script>
        <!--highchart.js -->
        <script src="../js/highchart/highcharts.js"></script>
        <script src="../js/highchart/modules/data.js"></script>
        <script src="../js/highchart/modules/drilldown.js"></script>

        <script>
            $(function () {
                // Create the chart
                $('#productionGraph').highcharts({
                    chart: {
                        type: 'column'
                    },
                    title: {
                        text: 'Production per Municipality'
                    },
                    subtitle: {
                        text: 'Click columns for barangay breakdown'
                    },
                    xAxis: {
                        type: 'category'
                    },
                    yAxis: {
                        title: {
                            text: 'Total Production'
                        }

                    },
                    legend: {
                        enabled: false
                    },
                    plotOptions: {
                        series: {
                            borderWidth: 0,
                            dataLabels: {
                                enabled: true,
                                format: '{point.y:.1f} MT'
                            }
                        }
                    },
                    tooltip: {
                        headerFormat: '<span style="font-size:11px">{series.name}</span><br>',
                        pointFormat: '<span style="color:{point.color}">{point.name}</span>: <b>{point.y:.2f}</b> MT produced<br/>'
                    },
                    series: [{
                            name: 'Municipal',
                            colorByPoint: false,
                            data: [{
                                    name: 'Municipal1',
                                    y: 56.33,
                                    drilldown: 'Municipal1'
                                }, {
                                    name: 'Municipal2',
                                    y: 24.03,
                                    drilldown: 'Municipal2'
                                }, {
                                    name: 'Municipal3',
                                    y: 24.03,
                                    drilldown: 'Municipal3'
                                }, {
                                    name: 'Municipal4',
                                    y: 10.38,
                                    drilldown: 'Municipal4'
                                }, {
                                    name: 'Municipal5',
                                    y: 4.77,
                                    drilldown: 'Municipal5'
                                }, {
                                    name: 'Municipal6',
                                    y: 0.91,
                                    drilldown: 'Municipal6'
                                }, {
                                    name: 'Municipal7',
                                    y: 0.2,
                                    drilldown: 'Municipal7'
                                }, {
                                    name: 'Municipal8',
                                    y: 0.2,
                                    drilldown: 'Municipal8'
                                }, {
                                    name: 'Municipal9',
                                    y: 0.2,
                                    drilldown: 'Municipal9'
                                }, {
                                    name: 'Municipal10',
                                    y: 0.2,
                                    drilldown: 'Municipal10'
                                }, {
                                    name: 'Municipal11',
                                    y: 56.33,
                                    drilldown: 'Municipal11'
                                }, {
                                    name: 'Municipal12',
                                    y: 24.03,
                                    drilldown: 'Municipal12'
                                }, {
                                    name: 'Municipal13',
                                    y: 24.03,
                                    drilldown: 'Municipal13'
                                }, {
                                    name: 'Municipal14',
                                    y: 10.38,
                                    drilldown: 'Municipal14'
                                }, {
                                    name: 'Municipal15',
                                    y: 4.77,
                                    drilldown: 'Municipal15'
                                }, {
                                    name: 'Municipal16',
                                    y: 0.91,
                                    drilldown: 'Municipal16'
                                }, {
                                    name: 'Municipal17',
                                    y: 0.2,
                                    drilldown: 'Municipal17'
                                }, {
                                    name: 'Municipal18',
                                    y: 0.2,
                                    drilldown: 'Municipal18'
                                }, {
                                    name: 'Municipal19',
                                    y: 0.2,
                                    drilldown: 'Municipal19'
                                }, {
                                    name: 'Municipal20',
                                    y: 0.2,
                                    drilldown: 'Municipal20'
                                }, {
                                    name: 'Municipal21',
                                    y: 56.33,
                                    drilldown: 'Municipal21'
                                }, {
                                    name: 'Municipal22',
                                    y: 24.03,
                                    drilldown: 'Municipal22'
                                }, {
                                    name: 'Municipal23',
                                    y: 24.03,
                                    drilldown: 'Municipal23'
                                }, {
                                    name: 'Municipal24',
                                    y: 10.38,
                                    drilldown: 'Municipal24'
                                }]
                        }],
                    drilldown: {
                        series: [{
                                name: 'Municipal1',
                                id: 'Municipal1',
                                data: [
                                    [
                                        'Barangay1',
                                        24.13
                                    ],
                                    [
                                        'Barangay2',
                                        17.2
                                    ],
                                    [
                                        'Barangay3',
                                        8.11
                                    ],
                                    [
                                        'Barangay4',
                                        5.33
                                    ],
                                    [
                                        'Barangay5',
                                        1.06
                                    ],
                                    [
                                        'Barangay6',
                                        0.5
                                    ]
                                ]
                            }, {
                                name: 'Municipal2',
                                id: 'Municipal2',
                                data: [
                                    [
                                        'Barangay1',
                                        5
                                    ],
                                    [
                                        'Barangay2',
                                        4.32
                                    ],
                                    [
                                        'Barangay3',
                                        3.68
                                    ],
                                    [
                                        'Barangay4',
                                        2.96
                                    ],
                                    [
                                        'Barangay5',
                                        2.53
                                    ],
                                    [
                                        'Barangay6',
                                        1.45
                                    ]
                                ]
                            }, {
                                name: 'Firefox',
                                id: 'Firefox',
                                data: [
                                    [
                                        'v35',
                                        2.76
                                    ],
                                    [
                                        'v36',
                                        2.32
                                    ],
                                    [
                                        'v37',
                                        2.31
                                    ],
                                    [
                                        'v34',
                                        1.27
                                    ],
                                    [
                                        'v38',
                                        1.02
                                    ],
                                    [
                                        'v31',
                                        0.33
                                    ],
                                    [
                                        'v33',
                                        0.22
                                    ],
                                    [
                                        'v32',
                                        0.15
                                    ]
                                ]
                            }, {
                                name: 'Safari',
                                id: 'Safari',
                                data: [
                                    [
                                        'v8.0',
                                        2.56
                                    ],
                                    [
                                        'v7.1',
                                        0.77
                                    ],
                                    [
                                        'v5.1',
                                        0.42
                                    ],
                                    [
                                        'v5.0',
                                        0.3
                                    ],
                                    [
                                        'v6.1',
                                        0.29
                                    ],
                                    [
                                        'v7.0',
                                        0.26
                                    ],
                                    [
                                        'v6.2',
                                        0.17
                                    ]
                                ]
                            }, {
                                name: 'Opera',
                                id: 'Opera',
                                data: [
                                    [
                                        'v12.x',
                                        0.34
                                    ],
                                    [
                                        'v28',
                                        0.24
                                    ],
                                    [
                                        'v27',
                                        0.17
                                    ],
                                    [
                                        'v29',
                                        0.16
                                    ]
                                ]
                            }]
                    }
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
                    <div class>
                        <!--page header-->
                        <div class="title_left">
                            <h3>Map Overview</h3>
                        </div>

                        <div class="clearfix">

                        </div>

                        <!--page content container-->
                        <div class="row">
                            <div class="col-md-12 col-sm-12 col-xs-12">
                                <div id="productionGraph" style="min-width: 310px; height: 700px; margin: 0 auto"></div>
                                <!--a href="productiondetails.jsp">Click here for more details</a-->
                            </div>
                        </div>
                        <!-- /page content -->
                    </div>
                </div>
                <jsp:include page="pagefooter.jsp"/>
            </div>
        </div>
    </body>

    <!-- Bootstrap -->
    <script src="../../vendors/bootstrap/dist/js/bootstrap.min.js"></script>
    <!-- FastClick -->
    <script src="../../vendors/fastclick/lib/fastclick.js"></script>
    <!-- NProgress -->
    <script src="../../vendors/nprogress/nprogress.js"></script>
    <!-- bootstrap-progressbar -->
    <script src="../../vendors/bootstrap-progressbar/bootstrap-progressbar.min.js"></script>

    <!-- Custom Theme Scripts -->
    <script src="../../build/js/custom.min.js"></script>
</html>

