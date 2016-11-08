<%-- 
    Document   : homepage
    Created on : Sep 14, 2016, 4:44:45 PM
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
                    url: "PAOProvinceStatus",
                    type: 'POST',
                    dataType: 'JSON',
                    success: function (data) {
                        values = data;
                    },
                    async: false
                });

                $('#productionGraph').highcharts({
                    chart: {
                        type: 'line'
                    },
                    title: {
                        text: 'Actual vs Target'
                    },
                    xAxis: {
                        categories: ['Jan2015', 'Feb2015', 'March2015', 'Apr2015', 'May2015', 'Jun2015']
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
                            data: [7.0, 6.9, 9.5, 14.5, 18.4, 21.5]
                        }, {
                            name: 'Target',
                            data: [40, 40, 40, 40, 40, 40]
                        }]
                });

                var districtTotal = [];
                var districts = [];

                var d1Production = 0;
                var d2Production = 0;
                var d3Production = 0;
                var d4Production = 0;

                var d1 = [];
                var d2 = [];
                var d3 = [];
                var d4 = [];
                
                for (var a = 0; a < values[0].districtShare.length; a++) {
                    item2 = {};
                    if (values[0].districtShare[a].district === "District 1") {
                        d1Production = d1Production + values[0].districtShare[a].productionYield;

                        item2["name"] = values[0].districtShare[a].municipality;
                        item2["y"] = values[0].districtShare[a].productionYield;
                        item2["drilldown"] = a;
                        d1.push(item2);
                    } else if (values[0].districtShare[a].district === "District 2") {
                        d2Production += values[0].districtShare[a].productionYield;

                        item2["name"] = values[0].districtShare[a].municipality;
                        item2["y"] = values[0].districtShare[a].productionYield;
                        item2["drilldown"] = a;
                        d2.push(item2);
                    } else if (values[0].districtShare[a].district === "District 3") {
                        d3Production += values[0].districtShare[a].productionYield;

                        item2["name"] = values[0].districtShare[a].municipality;
                        item2["y"] = values[0].districtShare[a].productionYield;
                        item2["drilldown"] = a;
                        d3.push(item2);
                    } else {
                        d4Production += values[0].districtShare[a].productionYield;

                        item2["name"] = values[0].districtShare[a].municipality;
                        item2["y"] = values[0].districtShare[a].productionYield;
                        item2["drilldown"] = a;
                        d4.push(item2);
                    }
                }

                for (var a = 0; a < 4; a++) {
                    item = {};
                    itemTotals = {};
                    itemTotals['name'] = "District " + (a + 1);
                    itemTotals['drilldown'] = "District " + (a + 1);
                    item["type"] = 'column';
                    if (a + 1 === 1) {
                        item["name"] = "District 1";
                        item["id"] = "District 1";
                        item["data"] = d1;
                        itemTotals['y'] = d1Production;
                    } else if (a + 1 === 2) {
                        item["name"] = "District 2";
                        item["id"] = "District 2";
                        item["data"] = d2;
                        item["type"] = 'column';
                        itemTotals['y'] = d2Production;
                    } else if (a + 1 === 3) {
                        item["name"] = "District 3";
                        item["id"] = "District 3";
                        item["data"] = d3;
                        item["type"] = 'column';
                        itemTotals['y'] = d3Production;
                    } else {
                        item["name"] = "District 4";
                        item["id"] = "District 4";
                        item["data"] = d4;
                        item["type"] = 'column';
                        itemTotals['y'] = d4Production;
                    }
                    districts.push(item);
                    districtTotal.push(itemTotals);
                }

                $('#districtproduction').highcharts({
                    chart: {
                        type: 'column'
                    },
                    title: {
                        text: 'Browser market shares. January, 2015 to May, 2015'
                    },
                    subtitle: {
                        text: '<a href="http://localhost:8084/BIGAS/WebLogin">For more info click here</a>'
                    },
                    xAxis: {
                        type: 'category'
                    },
                    yAxis: {
                        title: {
                            text: 'Production Yield'
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
                                format: '{point.y:.1f} MT/ha'
                            }
                        }
                    },
                    tooltip: {
                        headerFormat: '<span style="font-size:11px">{series.name}</span><br>',
                        pointFormat: '<span style="color:{point.color}">{point.name}</span>: <b>{point.y:.2f}MT/ha</b> produced<br/>'
                    },
                    series: [{
                            name: 'District',
                            data: districtTotal
                        }],
                    drilldown: {
                        series: districts
                    }
                });
                
                $('#cropStagesProduction').highcharts({
                    chart: {
                        type: 'column'
                    },
                    title: {
                        text: 'Browser market shares. January, 2015 to May, 2015'
                    },
                    subtitle: {
                        text: '<a href="http://localhost:8084/BIGAS/WebLogin">For more info click here</a>'
                    },
                    xAxis: {
                        type: 'category'
                    },
                    yAxis: {
                        title: {
                            text: 'Production Yield'
                        }
                    },
                    legend: {
                        enabled: false
                    },
                    plotOptions: {
                        series: {
                            stacking: 'normal',
                            borderWidth: 0,
                            dataLabels: {
                                enabled: true,
                                color: (Highcharts.theme && Highcarts.theme.dataLabelsColor) || 'white',
                                format: '{point.y:.1f} MT/ha'
                            }
                        }
                    },
                    tooltip: {
                        headerFormat: '<span style="font-size:11px">{series.name}</span><br>',
                        pointFormat: '<span style="color:{point.color}">{point.name}</span>: <b>{point.y:.2f}MT/ha</b> produced<br/>'
                    },
                    series: [{
                            name: 'District',
                            data: districtTotal
                        }, {
                            name: 'District',
                            data: districtTotal
                        }],
                    drilldown: {
                        series: districts
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
                    <jsp:include page="notifications.jsp"/>
                    <div class="row">
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <div class="x_panel">
                                <div class="x_title">
                                    <h2>Annual Target and Production</h2>


                                    <div class="clearfix"></div>
                                </div>
                                <div class="x_content">
                                    <div id="productionGraph" style="min-width: fit-content; height: 350px; margin: 0 auto"></div>
                                </div>
                            </div>
                        </div>
                        
                        <div class="col-md-6 col-sm-6 col-xs-7">
                            <div class="x_panel">
                                <div class="x_title">
                                    <h2>Production Share By District</h2>

                                    <div class="clearfix"></div>
                                </div>
                                <div class="x_content">
                                    <div id="districtproduction" style="min-width: fit-content; height: 350px; margin: 0 auto"></div>
                                </div>
                            </div>
                        </div>
                    </div>
                    
                    <div class="row">
                        <div class="col-md-12 col-sm-12 col-xs-12">
                            <div class="x_panel">
                                <div class="x_title">
                                    <h2>District Planting Stages</h2>
                                    <div class="clearfix"></div>
                                </div>
                                <div class="x_content">
                                    <div id="cropStagesProduction" style="min-width: fit-content; height: 400px; margin: 0 auto"></div>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-md-12 col-sm-12 col-xs-12">
                            <div class="x_panel">
                                <div class="x_title">
                                    <h2>Active Programs</h2>

                                    <div class="clearfix"></div>
                                </div>
                                <div class="x_content">
                                    <table class="table table-bordered table-striped">
                                        <thead>
                                            <tr>
                                                <th>Program ID</th>
                                                <th>Program Type</th>
                                                <th>Description</th>
                                                <th>Status</th>
                                                <th>Date Started</th>
                                            </tr>
                                        </thead>
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
