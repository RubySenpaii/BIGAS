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

                $('#districtproduction').highcharts({
                    chart: {
                        type: 'column'
                    },
                    title: {
                        text: 'Browser market shares. January, 2015 to May, 2015'
                    },
                    subtitle: {
                        text: 'Click the columns to view versions. Source: <a href="http://netmarketshare.com">netmarketshare.com</a>.'
                    },
                    xAxis: {
                        type: 'category'
                    },
                    yAxis: {
                        title: {
                            text: 'Total percent market share'
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
                                format: '{point.y:.1f}%'
                            }
                        }
                    },
                    tooltip: {
                        headerFormat: '<span style="font-size:11px">{series.name}</span><br>',
                        pointFormat: '<span style="color:{point.color}">{point.name}</span>: <b>{point.y:.2f}%</b> of total<br/>'
                    },
                    series: [{
                            name: 'Brands',
                            colorByPoint: true,
                            data: [{
                                    name: 'District I',
                                    y: 56.33,
                                    drilldown: 'District I'
                                }, {
                                    name: 'District II',
                                    y: 24.03,
                                    drilldown: 'District II'
                                }, {
                                    name: 'District III',
                                    y: 10.38,
                                    drilldown: 'District III'
                                }, {
                                    name: 'District IV',
                                    y: 4.77,
                                    drilldown: 'District IV'
                                }]
                        }],
                    drilldown: {
                        series: [{
                                name: 'District I',
                                id: 'District I',
                                data: [
                                    [
                                        'Municipality1',
                                        24.13
                                    ],
                                    [
                                        'Municipality2',
                                        17.2
                                    ],
                                    [
                                        'Municipality3',
                                        8.11
                                    ],
                                    [
                                        'Municipality4',
                                        5.33
                                    ],
                                    [
                                        'Municipality5',
                                        1.06
                                    ],
                                    [
                                        'Municipality6',
                                        0.5
                                    ]
                                ]
                            }, {
                                name: 'District II',
                                id: 'District II',
                                data: [
                                    [
                                        'Municipality7',
                                        5
                                    ],
                                    [
                                        'Municipality8',
                                        4.32
                                    ],
                                    [
                                        'Municipality9',
                                        3.68
                                    ],
                                    [
                                        'Municipality10',
                                        2.96
                                    ],
                                    [
                                        'Municipality11',
                                        2.53
                                    ],
                                    [
                                        'Municipality12',
                                        1.45
                                    ]
                                ]
                            }, {
                                name: 'District III',
                                id: 'District III',
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
                    <div class="row">
                        <!--Notifications / Alerts
                        <div class="col-md-12 col-sm-12 col-xs-12">
                            <div class="alert alert-danger alert-dismissable fade in" role="alert">
                                <button type="button" class="close" data-dismiss="alert" arial-label="close">
                                    <span aria-hidden="true">x</span>
                                </button>
                                <center><font size="4">Rat infestation reported. Deploy rehabilitation <a href="farmerlist.jsp">here</a>.</font></center>
                            </div>
                        </div>-->

                        <div class="col-md-10 col-sm-10 col-xs-12">
                            <div class="x_panel">
                                <div class="x_title">
                                    <h2>Annual Target and Production</h2>


                                    <div class="clearfix"></div>
                                </div>
                                <div class="x_content">
                                    <div id="productionGraph" style="min-width: 310px; height: 300px; margin: 0 auto"></div>
                                </div>
                            </div>
                        </div>

                        <div class="col-md-2 col-sm-2 col-xs-12">
                            <div class="x_panel">
                                <div class="x_title">
                                    <h2>Actions</h2>

                                    <div class="clearfix"></div>
                                </div>
                                <div class="x_content">
                                    <div class="btn-group-vertical">
                                        <a href="createprograms1.jsp" class="btn btn-default">Create Program</a><br>
                                        <a href="problemlist.jsp" class="btn btn-default">Show Problem Log</a><br>
                                        <button type="button" class="btn btn-default" data-toggle="modal" data-target=".disaster-alert-modal">Create Disaster Alert</button><br/>

                                        <div class="modal fade disaster-alert-modal" tabindex="-1" role="dialog" aria-hidden="true">
                                            <div class="modal-dialog modal-sm">
                                                <div class="modal-content">
                                                    <form class="form-horizontal form-label-left">
                                                        <div class="modal-header">
                                                            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span>
                                                            </button>
                                                            <h4 class="modal-title" id="myModalLabel2">Create Disaster Alert</h4>
                                                        </div>
                                                        <div class="modal-body">
                                                            <div class="form-group">
                                                                <label class="control-label col-md-3 col-sm-3 col-xs-12" for="message">Message: </label>
                                                                <div class="col-md-8 col-sm-8 col-xs-12">
                                                                    <textarea  id="message" class="form-control col-md-8 col-sm-8 col-xs-12"></textarea>
                                                                </div>
                                                            </div>
                                                            <div class="form-group">
                                                                <label class="control-label col-md-3 col-sm-3 col-xs-12" for="date">Date </label>
                                                                <div class="col-md-8 col-sm-8 col-xs-12">
                                                                    <input type="text" id="date" class="form-control col-md-8 col-sm-8 col-xs-12">
                                                                </div>
                                                            </div>
                                                            <div class="form-group">
                                                                <label class="control-label col-md-3 col-sm-3 col-xs-12" for="validity">Validity </label>
                                                                <div class="col-md-8 col-sm-8 col-xs-12">
                                                                    <input type="number" id="validity" class="form-control col-md-8 col-sm-8 col-xs-12">
                                                                </div><br/>
                                                            </div>
                                                        </div>
                                                        <div class="modal-footer">
                                                            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                                                            <button type="button" class="btn btn-primary">Save changes</button>
                                                        </div>
                                                    </form>
                                                </div>
                                            </div>
                                        </div>
                                        <a href="createintervention.jsp" class="btn btn-default">Create Report</a><br>
                                        <a href="createtargetproduction.jsp" class="btn btn-default">Set Target Production</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-md-12 col-sm-12 col-xs-12">
                            <div class="x_panel">
                                <div class="x_title">
                                    <h2>Production Share</h2>

                                    <div class="clearfix"></div>
                                </div>
                                <div class="x_content">
                                    <div id="districtproduction" style="min-width: fit-content; height: 400px; margin: 0 auto"></div>
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
