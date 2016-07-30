<%-- 
    Document   : cropmonitoring
    Created on : Jul 29, 2016, 5:29:37 PM
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

        <!-- Custom Theme Style -->
        <link href="../../build/css/custom.min.css" rel="stylesheet">

        <!-- jQuery -->
        <script src="../../vendors/jquery/dist/jquery.min.js"></script>
        <!--highchart.js -->
        <script src="../js/highchart/highcharts.js"></script>
        <script src="../js/highchart/modules/exporting.js"></script>

        <script type="text/javascript">
            $(function () {
                $('#container').highcharts({
                    chart: {
                        type: 'column'
                    },
                    title: {
                        text: 'Barangay Areas with Stages'
                    },
                    xAxis: {
                        categories: ['Barangay1', 'Barangay2', 'Barangay3', 'Barangay4', 'Barangay5', 'Barangay6', 'Barangay7', 'Barangay8', 'Barangay9', 'Barangay10',
                            'Barangay11', 'Barangay12', 'Barangay13', 'Barangay14', 'Barangay15', 'Barangay16', 'Barangay17', 'Barangay18', 'Barangay19', 'Barangay20',
                            'Barangay21', 'Barangay22', 'Barangay23', 'Barangay24']
                    },
                    yAxis: {
                        min: 0,
                        title: {
                            text: 'Area'
                        },
                        stackLabels: {
                            enabled: true,
                            style: {
                                fontWeight: 'bold',
                                color: (Highcharts.theme && Highcharts.theme.textColor) || 'gray'
                            }
                        }
                    },
                    legend: {
                        align: 'right',
                        x: -30,
                        verticalAlign: 'top',
                        y: 25,
                        floating: true,
                        backgroundColor: (Highcharts.theme && Highcharts.theme.background2) || 'white',
                        borderColor: '#CCC',
                        borderWidth: 1,
                        shadow: false
                    },
                    tooltip: {
                        headerFormat: '<b>{point.x}</b><br/>',
                        pointFormat: '{series.name}: {point.y}<br/>Total: {point.stackTotal}'
                    },
                    plotOptions: {
                        column: {
                            stacking: 'normal',
                            dataLabels: {
                                enabled: true,
                                color: (Highcharts.theme && Highcharts.theme.dataLabelsColor) || 'white',
                                style: {
                                    textShadow: '0 0 3px black'
                                }
                            }
                        }
                    },
                    series: [{
                            name: 'Newly Planted',
                            data: [5, 3, 4, 7, 2, 7, 9, 11, 23, 12, 6, 8, 9, 12, 15, 21, 20, 7, 9, 10, 13, 15, 2, 8]
                        }, {
                            name: 'Tillering',
                            data: [2, 2, 3, 2, 1]
                        }, {
                            name: 'Reproductive',
                            data: [3, 4, 4, 2, 5]
                        }, {
                            name: 'Harvesting',
                            data: [2, 1, 3, 6, 9]
                        }]
                });
            });
        </script>
    </head>

    <body class="nav-md">
        <div class="container body">
            <div class="main_container">
                <jsp:include page="../pages-admin/sidebar.jsp"/>
                <jsp:include page="../pages-admin/header.jsp"/>
                <br />

                <!-- page content -->
                <div class="right_col" role="main">
                    <div class>
                        <!--page header-->
                        <div class="title_left">
                            <h3>Crop Stage Monitoring</h3>
                        </div>

                        <div class="clearfix">

                        </div>

                        <!--page content container-->
                        <div class="row">
                            <div class="col-md-12 col-sm-12 col-xs-12">
                                <div id="container" style="min-width: 310px; height: 700px; margin: 0 auto"></div>
                            </div>
                        </div>
                        
                        <div class="row">
                            <div class="col-md-3 col-sm-3 col-xs-12 col-md-offset-6">
                                <a>Click here for full details</a>
                            </div>
                        </div>
                        <!--end: page content container-->
                    </div>
                </div>
                <!-- /page content -->
                <jsp:include page="../pages-admin/footer.jsp"/>
            </div>
        </div>

        <!-- Bootstrap -->
        <script src="../../vendors/bootstrap/dist/js/bootstrap.min.js"></script>
        <!-- FastClick -->
        <script src="../../vendors/fastclick/lib/fastclick.js"></script>
        <!-- NProgress -->
        <script src="../../vendors/nprogress/nprogress.js"></script>
        <!-- bootstrap-progressbar -->
        <script src="../../vendors/bootstrap-progressbar/bootstrap-progressbar.min.js"></script>
        <!-- iCheck -->
        <script src="../../vendors/iCheck/icheck.min.js"></script>
        <!-- Skycons -->
        <script src="../../vendors/skycons/skycons.js"></script>

        <!-- Custom Theme Scripts -->
        <script src="../../build/js/custom.min.js"></script>
    </body>
</html>
