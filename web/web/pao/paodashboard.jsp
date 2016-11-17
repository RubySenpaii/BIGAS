<%-- 
    Document   : paodashboard
    Created on : Nov 16, 2016, 3:37:09 PM
    Author     : RubySenpaii
--%>

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
                    categoriesH.push(values[0].planting[a].municipal);
                    harvestData.push(values[0].production[a].value);
                }
                
                

                Highcharts.chart('plantingComparison', {
                    chart: {
                        zoomType: 'xy'
                    },
                    title: {
                        text: 'Average Planted Area'
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
                            data: [20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20],
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
                        text: 'Average Production Yield Per Municipality'
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
                                    color: Highcharts.getOptions().colors[2]
                                }
                            },
                            title: {
                                text: 'Target Yield',
                                style: {
                                    color: Highcharts.getOptions().colors[2]
                                }
                            },
                            opposite: true

                        }, {// Secondary yAxis
                            gridLineWidth: 0,
                            title: {
                                text: 'Production Yield',
                                style: {
                                    color: Highcharts.getOptions().colors[0]
                                }
                            },
                            labels: {
                                format: '{value} MT/ha',
                                style: {
                                    color: Highcharts.getOptions().colors[0]
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
                            yAxis: 1,
                            data: harvestData,
                            tooltip: {
                                valueSuffix: ' MT/ha'
                            }

                        }, {
                            name: 'Target Yield',
                            type: 'spline',
                            data: [7.0, 6.9, 9.5, 14.5, 18.2, 21.5, 25.2, 26.5, 23.3, 18.3, 13.9, 9.6],
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
                                    <h2>Suggested Programs For Planting</h2>

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
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>

                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <div class="x_panel">
                                <div class="x_title">
                                    <h2>Active Programs For Planting</h2>

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
