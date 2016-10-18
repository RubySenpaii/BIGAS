<%-- 
    Document   : soilmonitoring
    Created on : Jul 28, 2016, 11:53:23 AM
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
                $('#soilnutrients').highcharts({
                    chart: {
                        plotBackgroundColor: null,
                        plotBorderWidth: null,
                        plotShadow: false,
                        type: 'pie'
                    },
                    title: {
                        text: 'Nutrients of Soil'
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
                                    name: 'Potassium',
                                    y: 56.33
                                }, {
                                    name: 'Nitrogen',
                                    y: 24.03
                                }, {
                                    name: 'Calcium',
                                    y: 10.38
                                }, {
                                    name: 'Magnesium',
                                    y: 4.77
                                }]
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
                            <h3>Soil Monitoring</h3>
                        </div>

                        <div class="clearfix">

                        </div>

                        <!--page content container-->
                        <div class="row">
                            <div class="x_panel">
                                <div class="x_title">
                                    <form id="demo-form2" data-parsley-validate class="form-horizontal form-label-left">
                                        <div class="form-group">
                                            <label class="control-label col-md-4 col-sm-4 col-xs-12">Farm Name</label>
                                            <div class="col-md-3 col-sm-3 col-xs-12">
                                                <select type="number" required="required" class="form-control col-md-7 col-xs-12">
                                                </select>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                                <div class="x_content">
                                    <div class="row">
                                        <div class="col-md-2 col-sm-2 col-xs-12">
                                            <table class="table table-bordered">
                                                <thead>
                                                    <tr>
                                                        <th>Date</th>
                                                    </tr>
                                                </thead>
                                            </table>
                                        </div>

                                        <div class="col-md-9 col-sm-9 col-xs-12 col-md-offset-1">
                                            <h3>Farm Name</h3>
                                            <br><br>
                                            <div id="soilnutrients" style="min-width: 310px; height: 400px; max-width: 600px; margin: 0 auto"></div>
                                        </div>
                                    </div>
                                </div>
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
        <!-- bootstrap-daterangepicker -->
        <script src="../js/moment/moment.min.js"></script>
        <script src="../js/datepicker/daterangepicker.js"></script>

        <!-- Custom Theme Scripts -->
        <script src="../../build/js/custom.min.js"></script>
    </body>
</html>

