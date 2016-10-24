<%-- 
    Document   : createprograms2p
    Created on : Oct 19, 2016, 6:04:14 PM
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

        <!-- Select2 -->
        <link href="../vendors/select2/dist/css/select2.min.css" rel="stylesheet">

        <!-- Custom Theme Style -->
        <link href="../../build/css/custom.min.css" rel="stylesheet">

        <!-- Breadcrumbs -->
        <link href="../css/breadcrumbs.css" rel="stylesheet"/>
        <link href="../css/additionalcss.css" rel="stylesheet"/>
        <!-- jQuery -->
        <script src="../../vendors/jquery/dist/jquery.min.js"></script>
        <!--highchart.js -->
        <script src="../js/highchart/highcharts.js"></script>
        <script src="../js/highchart/modules/exporting.js"></script>

        <script>
            $(function () {
                $('#municipalyield').highcharts({
                    chart: {
                        type: 'column'
                    },
                    title: {
                        text: 'Monthly Average Rainfall'
                    },
                    subtitle: {
                        text: 'Source: WorldClimate.com'
                    },
                    xAxis: {
                        categories: [
                            'Municipality1',
                            'Municipality2',
                            'Municipality3',
                            'Municipality4',
                            'Municipality5',
                            'Municipality6',
                            'Municipality7',
                            'Municipality8',
                            'Municipality9',
                            'Municipality10',
                            'Municipality11',
                            'Municipality12',
                            'Municipality13',
                            'Municipality14',
                            'Municipality15',
                            'Municipality16',
                            'Municipality17',
                            'Municipality18',
                            'Municipality19',
                            'Municipality20',
                            'Municipality21',
                            'Municipality22',
                            'Municipality23',
                            'Municipality24'
                        ],
                        crosshair: true
                    },
                    yAxis: {
                        min: 0,
                        title: {
                            text: 'Rainfall (mm)'
                        }
                    },
                    tooltip: {
                        headerFormat: '<span style="font-size:10px">{point.key}</span><table>',
                        pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
                                '<td style="padding:0"><b>{point.y:.1f} mm</b></td></tr>',
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
                    series: [{
                            name: 'Tokyo',
                            data: [49.9, 71.5, 106.4, 129.2, 144.0, 176.0, 135.6, 148.5, 216.4, 194.1, 95.6, 54.4, 49.9, 71.5, 106.4, 129.2, 144.0, 176.0, 135.6, 148.5, 216.4, 194.1, 95.6, 54.4]

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
                                    <h2>Step 2: Create Provision</h2>
                                    <div class="clearfix"></div>
                                </div>
                                <div class="x_content">
                                    <ul class="breadcrumb">
                                        <li><a href="createprograms1.jsp">Program Type</a></li>
                                        <li>Create Provision</li>
                                    </ul>

                                    <div class="row">
                                        <div class="col-md-8 col-sm-8 col-xs-12">
                                            <h4>Avg Yield Comparison By Municipality</h4>
                                            <div id="municipalyield" style="min-width: fit-content; height: 450px; margin: 0 auto"></div>
                                            <br/>
                                            <table class="table table-bordered">
                                                <thead>
                                                    <tr>
                                                        <th>Municipal</th>
                                                        <th>Average Yield</th>
                                                        <th>Most Used Seed Variety</th>
                                                        <th>Most Used Fertilizer</th>
                                                    </tr>
                                                </thead>
                                            </table>
                                        </div>

                                        <div class="col-md-4 col-sm-4 col-xs-12">
                                            <h4>Provision Detail</h4>
                                            <form class="form-horizontal form-label-left">
                                                <div class="form-group">
                                                    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="provision-name">Provision Name</label>
                                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                                        <input type="text" id="provision-name" required="required" class="form-control col-md-7 col-xs-12">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="description">Description</label>
                                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                                        <textarea id="description" required="required" class="form-control col-md-7 col-xs-12"></textarea>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="municipality">Municipality</label>
                                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                                        <input type="text" id="municipality" required="required" class="form-control col-md-7 col-xs-12">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="seed-variety">Seed Variety</label>
                                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                                        <input type="text" id="seed-variety" required="required" class="form-control col-md-7 col-xs-12">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="seed-bag">Seed Bag</label>
                                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                                        <input type="number" id="seed-bag" required="required" class="form-control col-md-7 col-xs-12">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="fertilizer">Fertilizer</label>
                                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                                        <input type="text" id="fertilizer" required="required" class="form-control col-md-7 col-xs-12">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="fertilizer-bag">Fertilizer Bag</label>
                                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                                        <input type="number" id="fertilizer-bag" required="required" class="form-control col-md-7 col-xs-12">
                                                    </div>
                                                </div>
                                            </form>
                                        </div>
                                    </div>
                                    <br/><br/>
                                    <div>
                                        <div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-5">
                                            <button type="submit" class="btn btn-lg btn-primary">Cancel</button>
                                            <button type="submit" class="btn btn-lg btn-success">Next</button>
                                            <a href="createprograms3p.jsp">provision</a>
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
