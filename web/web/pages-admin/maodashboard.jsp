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

        <title>B.I.G.A.S. System | Dashboard</title>

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
    </head>

    <body class="nav-md">
        <div class="container body">
            <div class="main_container">
                <jsp:include page="sidebar.jsp"/>
                <jsp:include page="header.jsp"/>
                <br />

                <!-- page content -->
                <div class="right_col" role="main">
                    <!-- top tiles -->
                    <div class="row tile_count">
                        <div class="col-md-3 col-sm-3 col-xs-6 tile_stats_count">
                            <span class="count_top"><i class="fa fa-pagelines"></i> Planted Area</span>
                            <div class="count">400 ha</div>
                            <span class="count_bottom"><i class="green"><i class="fa fa-sort-asc"></i>4% </i> From last Week</span>
                        </div>
                        <div class="col-md-3 col-sm-3 col-xs-6 tile_stats_count">
                            <span class="count_top"><i class="fa fa-clock-o"></i> Harvested</span>
                            <div class="count">----- MT</div>
                            <span class="count_bottom"><i class="green"><i class="fa fa-sort-asc"></i>-% </i> From last Week</span>
                        </div>
                        <div class="col-md-3 col-sm-3 col-xs-6 tile_stats_count">
                            <span class="count_top"><i class="fa fa-bug"></i> Damages</span>
                            <div class="count green">20 ha</div>
                            <span class="count_bottom"><i class="green"><i class="fa fa-sort-asc"></i>34% </i> From last Week</span>
                        </div>
                        <div class="col-md-3 col-sm-3 col-xs-6 tile_stats_count">
                            <span class="count_top"><i class="fa fa-line-chart"></i>Projected Production</span>
                            <div class="count">3000 MT</div>
                            <span class="count_bottom"><i class="red"><i class="fa fa-sort-desc"></i>6% </i> From Last Year</span>
                        </div>
                    </div>
                    <!-- /top tiles -->

                    <div class="row">
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <div class="x_panel">
                                <div class="x_title">
                                    <h2><a href="">Production</a></h2>

                                    <div class="clearfix"></div>
                                </div>
                                <div class="x_content">
                                    <canvas id="lineChart"></canvas>
                                </div>
                            </div>
                        </div>

                        <div class="row">
                            <div class="animated flipInY col-lg-3 col-md-3 col-sm-6 col-xs-12">
                                <div class="tile-stats">
                                    <div class="icon"><i class="fa fa-comments-o"></i>
                                    </div>
                                    <div class="count"><a href="../pages-monitoring/notifications.jsp">3</a></div>

                                    <h3><a href="../pages-monitoring/notifications.jsp">New Notifications</a></h3>
                                    <p>Click Header to View All</p>
                                </div>
                            </div>
                            <div class="animated flipInY col-lg-3 col-md-3 col-sm-6 col-xs-12">
                                <div class="tile-stats">
                                    <div class="icon"><i class="fa fa-sort-amount-desc"></i>
                                    </div>
                                    <div class="count"><a href="../pages-database/farmerlist.jsp">179</a></div>

                                    <h3><a href="../pages-employee/assigntechnician.jsp">Farmers to Visit</a></h3>
                                    <p>Accomplish within earliest Harvest date</p>
                                </div>
                            </div>
                            <div class="col-lg-6 col-md-3 col-sm-6 col-xs-12">
                                <iframe id="forecast_embed" type="text/html" frameborder="0" height="245" width="100%" src="http://forecast.io/embed/#lat=14.794273&lon=120.879901&name=San Rafael&units=si"> </iframe>
                            </div>


                        </div>
                    </div>
                </div>
                <!-- /page content -->
                <jsp:include page="footer.jsp"/>
            </div>
        </div>

        <!-- jQuery -->
        <script src="../../vendors/jquery/dist/jquery.min.js"></script>
        <!-- Bootstrap -->
        <script src="../../vendors/bootstrap/dist/js/bootstrap.min.js"></script>
        <!-- FastClick -->
        <script src="../../vendors/fastclick/lib/fastclick.js"></script>
        <!-- NProgress -->
        <script src="../../vendors/nprogress/nprogress.js"></script>
        <!-- Chart.js -->
        <script src="../../vendors/Chart.js/dist/Chart.min.js"></script>
        <!-- gauge.js -->
        <script src="../../vendors/bernii/gauge.js/dist/gauge.min.js"></script>
        <!-- bootstrap-progressbar -->
        <script src="../../vendors/bootstrap-progressbar/bootstrap-progressbar.min.js"></script>
        <!-- morris.js -->
        <script src="../../vendors/raphael/raphael.min.js"></script>
        <script src="../../vendors/morris.js/morris.min.js"></script>

        <!-- Custom Theme Scripts -->
        <script src="../../build/js/custom.min.js"></script>

        <script>
            // Line chart
            var ctx = document.getElementById("lineChart");
            var lineChart = new Chart(ctx, {
                type: 'line',
                data: {
                    labels: ["2010", "2011", "2012", "2013", "2014", "2015", "2016"],
                    datasets: [{
                            label: "Target",
                            backgroundColor: "rgba(38, 185, 154, 0.31)",
                            borderColor: "rgba(38, 185, 154, 0.7)",
                            pointBorderColor: "rgba(38, 185, 154, 0.7)",
                            pointBackgroundColor: "rgba(38, 185, 154, 0.7)",
                            pointHoverBackgroundColor: "#fff",
                            pointHoverBorderColor: "rgba(220,220,220,1)",
                            pointBorderWidth: 1,
                            data: [31, 74, 6, 39, 20, 85, 7]
                        }, {
                            label: "Actual",
                            backgroundColor: "rgba(3, 88, 106, 0.3)",
                            borderColor: "rgba(3, 88, 106, 0.70)",
                            pointBorderColor: "rgba(3, 88, 106, 0.70)",
                            pointBackgroundColor: "rgba(3, 88, 106, 0.70)",
                            pointHoverBackgroundColor: "#fff",
                            pointHoverBorderColor: "rgba(151,187,205,1)",
                            pointBorderWidth: 1,
                            data: [82, 23, 66, 9, 99, 4, 2]
                        }]
                },
            });

            // Bar chart
            var ctx = document.getElementById("mybarChart");
            var mybarChart = new Chart(ctx, {
                type: 'bar',
                data: {
                    labels: ["Municipal1", "Municipal2", "Municipal3", "Municipal4", "Municipal5", "Municipal6", "Municipal7", "Municipal8",
                        "Municipal9", "Municipal10", "Municipal11", "Municipal12", "Municipal13", "Municipal14", "Municipal15", "Municipal16", "Municipal17", "Municipal18",
                        "Municipal19", "Municipal20", "Municipal21", "Municipal22", "Municipal23", "Municipal24"],
                    datasets: [{
                            label: 'Production',
                            backgroundColor: "#26B99A",
                            data: [51, 30, 40, 28, 92, 50, 45, 35, 69, 19, 25, 51, 30, 40, 28, 92, 50, 45, 35, 69, 19, 25, 32, 56]
                        }]
                },
                options: {
                    scales: {
                        yAxes: [{
                                ticks: {
                                    beginAtZero: true
                                }
                            }]
                    }
                }
            });

        </script>
    </body>
</html>

