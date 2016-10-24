<%-- 
    Document   : pestanddamages
    Created on : Sep 20, 2016, 1:33:51 PM
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
                                    name: 'Pests',
                                    y: 56.33
                                }, {
                                    name: 'Natural Calamities',
                                    y: 24.03
                                }]
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
                        <div class="col-md-12 col-sm-12 col-xs-12">
                            <div class="x_panel">
                                <div class="x_title">
                                    <h2>Pest and Damages</h2>


                                    <div class="clearfix"></div>
                                </div>
                                <div class="x_content">
                                    <div class="row">
                                        <div class="col-md-12 col-sm-12 col-xs-12">
                                            <form id="demo-form2" data-parsley-validate class="form-horizontal form-label-left" novalidate>
                                                <div class="form-group">
                                                    <label class="control-label col-md-3 col-sm-3 col-xs-12 col-md-offset-2">Season and Year</label>
                                                    <div class="col-md-2 col-sm-2 col-xs-12">
                                                        <select class="form-control">
                                                            <option>Wet Season 2016</option>
                                                        </select>
                                                    </div>
                                                </div>
                                            </form>
                                        </div>
                                        
                                        <div class="col-md-5 col-sm-5 col-xs-12">
                                            <div class="x_panel">
                                                <div class="x_title">
                                                    <h2>Cause of Damages For Wet Season of 2016</h2>

                                                    <div class="clearfix"></div>
                                                </div>
                                                <div class="x_content">
                                                    <div id="damages" style="min-width: 310px; height: 400px; max-width: 600px; margin: 0 auto"></div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-md-7 col-sm-7 col-xs-12">
                                            <table class="table table-bordered table-striped">
                                                <thead>
                                                    <tr>
                                                        <th>Damage ID</th>
                                                        <th>Description</th>
                                                        <th>Farm Name</th>
                                                        <th>Date Reported</th>
                                                        <th>Remarks</th>
                                                    </tr>
                                                </thead>
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
