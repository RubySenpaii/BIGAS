<%-- 
    Document   : template
    Created on : Jun 1, 2016, 7:04:34 PM
    Author     : RubySenpaii

this jsp is to be deleted after development
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

        <title>B.I.G.A.S. System </title>

        <!-- Bootstrap -->
        <link href="/BIGAS/vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
        <!-- Font Awesome -->
        <link href="/BIGAS/vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet">
        <!-- iCheck -->
        <link href="/BIGAS/vendors/iCheck/skins/flat/green.css" rel="stylesheet">

        <!-- bootstrap-progressbar -->
        <link href="/BIGAS/vendors/bootstrap-progressbar/css/bootstrap-progressbar-3.3.4.min.css" rel="stylesheet">

        <!-- Datatables -->
        <link href="/BIGAS/vendors/datatables.net-bs/css/dataTables.bootstrap.min.css" rel="stylesheet">
        <link href="/BIGAS/vendors/datatables.net-buttons-bs/css/buttons.bootstrap.min.css" rel="stylesheet">
        <link href="/BIGAS/vendors/datatables.net-fixedheader-bs/css/fixedHeader.bootstrap.min.css" rel="stylesheet">
        <link href="/BIGAS/vendors/datatables.net-responsive-bs/css/responsive.bootstrap.min.css" rel="stylesheet">
        <link href="/BIGAS/vendors/datatables.net-scroller-bs/css/scroller.bootstrap.min.css" rel="stylesheet">

        <!-- Custom Theme Style -->
        <link href="/BIGAS/build/css/custom.min.css" rel="stylesheet">

        <!-- jQuery -->
        <script src="/BIGAS/vendors/jquery/dist/jquery.min.js"></script>


        <!--highchart.js -->
        <script src="../js/highchart/highcharts.js"></script>
        <script src="../js/highchart/modules/exporting.js"></script>
        <script src="../js/highchart/modules/drilldown.js"></script>

        <!--Map-->
        <script src='/BIGAS/Mapbox/mapbox.js'></script>
        <link href='/BIGAS/Mapbox/mapbox.css' rel='stylesheet' />
        <style type="text/css">
            #map {height:700px; width:780px;}
        </style>

        <script>
            var today = new Date();
            var dd = today.getDate();
            var mm = today.getMonth() + 1; //January is 0!
            var yyyy = today.getFullYear();

            if (dd < 10) {
                dd = '0' + dd;
            }

            if (mm < 10) {
                mm = '0' + mm;
            }

            today = mm + '/' + dd + '/' + yyyy;

            $(function () {
                $('#currproduction').highcharts({
                    chart: {
                        type: 'line'
                    },
                    title: {
                        text: 'Production Progress'
                    },
                    xAxis: {
                        categories: ['Week 1', 'Week 2', 'Week 3', 'Week 4', 'Week 5', 'Week 6', 'Week 7']
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
                            data: [7.0, 7.8, 9.5, 14.5, 18.4, 21.5, 25.2]
                        }, {
                            name: 'Target',
                            data: [30, 30, 30, 30, 30, 30, 30]
                        }]
                });

                $('#production').highcharts({
                    chart: {
                        type: 'column'
                    },
                    title: {
                        text: 'Production Review from 2013 to 2016'
                    },
                    xAxis: {
                        categories: ['2013', '2014', '2015', '2016']
                    },
                    yAxis: {
                        min: 0,
                        title: {
                            text: 'Metric Tons'
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
                                color: (Highcharts.theme && Highcharts.theme.dataLabelsColor) || 'white'
                            }
                        }
                    },
                    series: [{
                            name: 'Dry Season',
                            data: [5, 3, 4, 7]
                        }, {
                            name: 'Dry Season',
                            data: [2, 2, 3, 2]
                        }]
                });

                Highcharts.chart('yield', {
                    chart: {
                        zoomType: 'xy'
                    },
                    title: {
                        text: 'Yield and Sufficiency'
                    },
                    subtitle: {
                        text: '---- to ----'
                    },
                    xAxis: [{
                            categories: ['2013', '2014', '2015', '2016'],
                            crosshair: true
                        }],
                    yAxis: [{// Primary yAxis
                            labels: {
                                format: '{value}°C',
                                style: {
                                    color: Highcharts.getOptions().colors[1]
                                }
                            },
                            title: {
                                text: 'Temperature',
                                style: {
                                    color: Highcharts.getOptions().colors[1]
                                }
                            }
                        }, {// Secondary yAxis
                            title: {
                                text: 'Rainfall',
                                style: {
                                    color: Highcharts.getOptions().colors[0]
                                }
                            },
                            labels: {
                                format: '{value} mm',
                                style: {
                                    color: Highcharts.getOptions().colors[0]
                                }
                            },
                            opposite: true
                        }],
                    tooltip: {
                        shared: true
                    },
                    legend: {
                        layout: 'vertical',
                        align: 'left',
                        x: 120,
                        verticalAlign: 'top',
                        y: 100,
                        floating: true,
                        backgroundColor: (Highcharts.theme && Highcharts.theme.legendBackgroundColor) || '#FFFFFF'
                    },
                    series: [{
                            name: 'Production',
                            type: 'column',
                            yAxis: 1,
                            data: [8, 18, 28, 38],
                            tooltip: {
                                valueSuffix: ' mm'
                            }
                        }, {
                            name: 'Target',
                            type: 'spline',
                            data: [10, 20, 30, 40],
                            tooltip: {
                                valueSuffix: '°C'
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
                    <div class="row">
                        <div class="x_title">
                            <h2>Production Monitoring - San Rafael, Bulacan</h2>
                            <div class="clearfix"></div>
                        </div>
                        <!--1ST COLUMN-->
                        <div class="col-md-6 col-xs-12">

                            <div class="tile-stats col-md-6 col-xs-6">
                                <div class="icon"><i class="fa fa-caret-square-o-right"></i></div>
                                <div class="count">27,000 MT</div>
                                <h3>Target Production</h3>
                                <p>Dry Season 2016</p>
                            </div>

                            <div class="tile-stats col-md-6 col-xs-6">
                                <div class="icon"><i class="fa fa-bar-chart"></i></div>
                                <div class="count">- MT</div>
                                <h3>Actual Production</h3>
                                <p>As of <script>document.write(today);</script> </p>
                            </div>

                            <div class="x_panel">
                                <div id="currproduction" class="col-md-12 col-sm-12 col-xs-12" style="min-width: 310px; height: 400px; margin: 0 auto"></div>
                            </div>

                            <div class="tile-stats col-md-6 col-xs-6">
                                <div class="icon"></div>
                                <div class="count">- MT/ha</div>
                                <h3>Yield</h3>
                                <p>Charot</p>
                            </div>

                            <div class="tile-stats col-md-6 col-xs-6">
                                <div class="icon"></div>
                                <div class="count">- %</div>
                                <h3>Sufficiency</h3>
                                <p>Charing</p>
                            </div>

                            <!--                            MAP
                                                        <div class="x_panel">
                                                            <div id="map"></div>
                                                        </div>
                                                        //MAP-->
                        </div>
                        <!--//1ST COLUMN-->

                        <!--2ND COLUMN-->
                        <div class="col-md-6 col-xs12">


                            <!--                            <div class="x_panel">
                                                            <div class="x_title">
                                                                <h2>Production Review</h2>
                                                                <br>
                                                            </div>
                                                            <div class="x_content">
                                                                <br />
                                                                <form id="demo-form2" data-parsley-validate class="form-horizontal form-label-left">
                                                                    <div class="col-md-4 col-sm-4 col-xs-12 form-group">
                                                                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="first-name">From<span class="required"></span>
                                                                        </label>
                                                                        <div class="col-md-8 col-sm-8 col-xs-12">
                                                                            <select class="form-control">
                                                                                <option></option>
                                                                                <option value="2016">2016</option>
                                                                                <option value="2015">2015</option>
                                                                                <option value="2014">2014</option>
                                                                                <option value="2013">2013</option>
                                                                                <option value="2012">2012</option>
                                                                            </select>
                                                                        </div>
                                                                    </div>
                            
                                                                    <div class="col-md-4 col-sm-4 col-xs-12 form-group">
                                                                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="first-name">To<span class="required"></span>
                                                                        </label>
                                                                        <div class="col-md-8 col-sm-8 col-xs-12">
                                                                            <select class="form-control">
                                                                                <option></option>
                                                                                <option value="2015">2015</option>
                                                                                <option value="2014">2014</option>
                                                                                <option value="2013">2013</option>
                                                                                <option value="2012">2012</option>
                                                                            </select>
                                                                        </div>
                                                                    </div>
                            
                                                                    <div class="col-md-1 col-sm-1 col-xs-12 form-group">
                                                                    </div>
                                                                    <div class="col-md-1 col-sm-1 col-xs-12 form-group">
                                                                        <button type="submit" class="btn btn-success">Submit</button>                                      
                                                                    </div>
                                                                </form>
                                                            </div>
                                                        </div>-->

                            <div class="x_panel">
                                <div id="production"></div>
                            </div>

                            <div class="x_panel">
                                <div id="yield"></div>
                            </div>

                        </div>
                        <!--//2ND COLUMN-->
                    </div>
                </div>
            </div>
            <!-- /page content -->
            <jsp:include page="pagefooter.jsp"/>
        </div>


        <!-- Bootstrap -->
        <script src="/BIGAS/vendors/bootstrap/dist/js/bootstrap.min.js"></script>
        <!-- FastClick -->
        <script src="/BIGAS/vendors/fastclick/lib/fastclick.js"></script>
        <!-- NProgress -->
        <script src="/BIGAS/vendors/nprogress/nprogress.js"></script>
        <!-- bootstrap-progressbar -->
        <script src="/BIGAS/vendors/bootstrap-progressbar/bootstrap-progressbar.min.js"></script>
        <!-- iCheck -->
        <script src="/BIGAS/vendors/iCheck/icheck.min.js"></script>
        <!-- Skycons -->
        <script src="/BIGAS/vendors/skycons/skycons.js"></script>
        <!-- bootstrap-daterangepicker -->
        <script src="../js/moment/moment.min.js"></script>
        <script src="../js/datepicker/daterangepicker.js"></script>
        <!-- Datatables -->
        <script src="/BIGAS/vendors/datatables.net/js/jquery.dataTables.min.js"></script>
        <script src="/BIGAS/vendors/datatables.net-bs/js/dataTables.bootstrap.min.js"></script>
        <script src="/BIGAS/vendors/datatables.net-buttons/js/dataTables.buttons.min.js"></script>
        <script src="/BIGAS/vendors/datatables.net-buttons-bs/js/buttons.bootstrap.min.js"></script>
        <script src="/BIGAS/vendors/datatables.net-buttons/js/buttons.flash.min.js"></script>
        <script src="/BIGAS/vendors/datatables.net-buttons/js/buttons.html5.min.js"></script>
        <script src="/BIGAS/vendors/datatables.net-buttons/js/buttons.print.min.js"></script>
        <script src="/BIGAS/vendors/datatables.net-fixedheader/js/dataTables.fixedHeader.min.js"></script>
        <script src="/BIGAS/vendors/datatables.net-keytable/js/dataTables.keyTable.min.js"></script>
        <script src="/BIGAS/vendors/datatables.net-responsive/js/dataTables.responsive.min.js"></script>
        <script src="/BIGAS/vendors/datatables.net-responsive-bs/js/responsive.bootstrap.js"></script>
        <script src="/BIGAS/vendors/datatables.net-scroller/js/datatables.scroller.min.js"></script>
        <script src="/BIGAS/vendors/jszip/dist/jszip.min.js"></script>
        <script src="/BIGAS/vendors/pdfmake/build/pdfmake.min.js"></script>
        <script src="/BIGAS/vendors/pdfmake/build/vfs_fonts.js"></script>
        <!-- Custom Theme Scripts -->
        <script src="/BIGAS/build/js/custom.min.js"></script>

        <!-- Datatables -->
        <script>
                                    $(document).ready(function () {
                                        TableManageButtons = function () {
                                            "use strict";
                                            return {
                                                init: function () {
                                                    handleDataTableButtons();
                                                }
                                            };
                                        }();

                                        $('#datatable').dataTable();
                                        $('#datatable1').dataTable();
                                        $('#datatable-keytable').DataTable({
                                            keys: true
                                        });

                                        $('#datatable-responsive').DataTable();

                                        $('#datatable-scroller').DataTable({
                                            ajax: "js/datatables/json/scroller-demo.json",
                                            deferRender: true,
                                            scrollY: 380,
                                            scrollCollapse: true,
                                            scroller: true
                                        });

                                        var table = $('#datatable-fixed-header').DataTable({
                                            fixedHeader: true
                                        });

                                        TableManageButtons.init();
                                    });
        </script>
        <!-- /Datatables -->

        <!--MAP-->
        <script>
            L.mapbox.accessToken = 'pk.eyJ1IjoibWprYXJpbm8iLCJhIjoiY2lvbDdlbzQ0MDA4M3ZjbTEyeXNramV2NCJ9.KInedeiVZz2TS5jLH3WP8Q';
            var mapboxTiles = L.tileLayer('https://api.mapbox.com/v4/mapbox.streets/{z}/{x}/{y}.png?access_token=' + L.mapbox.accessToken, {
                attribution: '© <a href="https://www.mapbox.com/map-feedback/">Mapbox</a> © <a href="http://www.openstreetmap.org/copyright">OpenStreetMap</a>'});

            var map = L.map('map').addLayer(mapboxTiles).setView([14.97681, 121.00635], 10);
            //SAN RAFAEL
            var sanrafael = L.polygon([
                [14.9901, 121.06568],
                [14.987604, 121.052568],
                [14.984597, 121.039043],
                [14.959218, 121.025076],
                [14.958482, 120.999209],
                [14.948127, 120.990431],
                [14.958033, 120.960366],
                [14.957541, 120.951940],
                [14.968246, 120.915548],
                [15.01715, 120.89693],
                [15.01594, 120.89318],
                [15.032263, 120.891514],
                [15.022181, 120.903167],
                [15.023587, 120.914213],
                [15.038358, 120.915426], //1
                [15.04069, 120.93113],
                [15.038105, 120.957235], //2
                [15.00294, 120.98661],
                [15.015128, 121.018169],
                [14.99351, 121.02633],
                [15.00588, 121.06079], //
                [15.00115, 121.06458],
                [14.9901, 121.06568]
            ], {color: 'red',
                fillColor: '#f03',
                fillOpacity: 0.5,
                fill: true}).addTo(map);

            // BOCAUE
            var bocaue = L.polygon([
                [14.78666, 120.95964],
                [14.813273, 120.943084],
                [14.84299, 120.95271],
                [14.842922, 120.944467],
                [14.825286, 120.924317],
                [14.796409, 120.910498],
                [14.786700, 120.914790],
                [14.78271, 120.90312],
                [14.76827, 120.91413],
                [14.76389, 120.92239],
                [14.77381, 120.93025],
                [14.78666, 120.95964]
            ], {color: 'red',
                fillColor: '#f03',
                fillOpacity: 0.5,
                fill: true}).addTo(map);

            // BALIUAG
            var baliuag = L.polygon([
                [14.907399, 120.890228],
                [14.929460, 120.887825],
                [14.96828, 120.91554],
                [15.01715, 120.89694],
                [15.010388, 120.875809],
                [14.982531, 120.880787],
                [14.971420, 120.848171],
                [14.924650, 120.853493],
                [14.923489, 120.868427],
                [14.917020, 120.870830],
                [14.907399, 120.890228]
            ], {color: 'red',
                fillColor: '#f03',
                fillOpacity: 0.5,
                fill: true}).addTo(map);

            var sanidelfonso = L.polygon([
                [15.11488, 121.0626],
                [15.05019, 121.07416],
                [15.0059, 121.06084],
                [14.99351, 121.02633],
                [15.015475, 121.018322],
                [15.00294, 120.98661], //
                [15.03811, 120.95724],
                [15.040675, 120.931118],
                [15.077144, 120.899532],
                [15.12102, 120.94424],
                [15.11237, 120.98266],
                [15.099685, 120.990856],
                [15.11488, 121.0626]
            ], {color: 'red',
                fillColor: '#f03',
                fillOpacity: 0.5,
                fill: true}).addTo(map);

            var calumpit = L.polygon([
                [14.934503, 120.795311],
                [14.890711, 120.804580],
                [14.886895, 120.801834],
                [14.889052, 120.789646],
                [14.86698, 120.78101],
                [14.868977, 120.774368],
                [14.881254, 120.774368],
                [14.874950, 120.739006],
                [14.865742, 120.717891],
                [14.883826, 120.723900],
                [14.904065, 120.730251],
                [14.916174, 120.728191],
                [14.928283, 120.732998],
                [14.930108, 120.754627],
                [14.923141, 120.771965],
                [14.934503, 120.795311]
            ], {color: 'red',
                fillColor: '#f03',
                fillOpacity: 0.5,
                fill: true}).addTo(map);

            var hagonoy = L.polygon([
                [14.88126, 120.77437],
                [14.87495, 120.73901],
                [14.86575, 120.71789],
                [14.824053, 120.689326],
                [14.814428, 120.696192],
                [14.803807, 120.688982],
                [14.796836, 120.663233],
                [14.768288, 120.654993],
                [14.768952, 120.667353],
                [14.779243, 120.664606],
                [14.788206, 120.675936],
                [14.786878, 120.684176],
                [14.771939, 120.689326],
                [14.771275, 120.754557],
                [14.759324, 120.755930],
                [14.765300, 120.767260],
                [14.794513, 120.774813],
                [14.822394, 120.762110],
                [14.861222, 120.767260],
                [14.861554, 120.774470],
                [14.88126, 120.77437]
            ], {color: 'red',
                fillColor: '#f03',
                fillOpacity: 0.5,
                fill: true}).addTo(map);

            var paombong = L.polygon([
                [14.86901, 120.77448],
                [14.86156, 120.77446],
                [14.86123, 120.76726],
                [14.8224, 120.76208],
                [14.79449, 120.77479],
                [14.76531, 120.7673],
                [14.755546, 120.801788],
                [14.75803, 120.80385],
                [14.795051, 120.799728],
                [14.7947, 120.79957],
                [14.84184, 120.80042],
                [14.84402, 120.79098],
                [14.86306, 120.79339],
                [14.86901, 120.77448]
            ], {color: 'red',
                fillColor: '#f03',
                fillOpacity: 0.5,
                fill: true}).addTo(map);

            var bulacan = L.polygon([
                [14.823361, 120.876720],
                [14.803446, 120.847881],
                [14.793488, 120.846508],
                [14.800791, 120.825222],
                [14.750332, 120.835521],
                [14.710155, 120.885647],
                [14.728418, 120.902126],
                [14.754316, 120.898350],
                [14.753652, 120.910022],
                [14.768259, 120.914142],
                [14.795148, 120.893543],
                [14.813736, 120.892513],
                [14.823361, 120.876720]
            ], {color: 'red',
                fillColor: '#f03',
                fillOpacity: 0.5,
                fill: true}).addTo(map);

            var malolos = L.polygon([
                [14.89072, 120.80459],
                [14.88692, 120.80183],
                [14.889114, 120.789784],
                [14.86697, 120.78102],
                [14.863067, 120.793389],
                [14.843985, 120.790985],
                [14.841828, 120.800427],
                [14.794698, 120.799568],
                [14.758015, 120.803860],
                [14.760007, 120.818108],
                [14.75698, 120.8342],
                [14.8008, 120.82523],
                [14.79354, 120.8465],
                [14.80346, 120.84787],
                [14.81663, 120.86699],
                [14.866219, 120.857762],
                [14.886626, 120.827893],
                [14.884303, 120.811756],
                [14.89072, 120.80459]
            ], {color: 'red',
                fillColor: '#f03',
                fillOpacity: 0.5,
                fill: true}).addTo(map);

            var plaridel = L.polygon([
                [14.9008, 120.80244],
                [14.904927, 120.823854],
                [14.900946, 120.858873],
                [14.887674, 120.858186],
                [14.893315, 120.876726],
                [14.903600, 120.880159],
                [14.90743, 120.89023],
                [14.92178, 120.88866],
                [14.92243, 120.90886], //
                [14.90403, 120.90886],
                [14.90002, 120.90301],
                [14.872079, 120.907281],
                [14.86803, 120.91485],
                [14.86628, 120.90186],
                [14.861958, 120.880331],
                [14.865857, 120.876297],
                [14.86621, 120.85775],
                [14.88661, 120.82815],
                [14.88432, 120.8118],
                [14.89072, 120.80458],
                [14.9008, 120.80244]
            ], {color: 'red',
                fillColor: '#f03',
                fillOpacity: 0.5,
                fill: true}).addTo(map);

            var obando = L.polygon([
                [14.74825, 120.89923],
                [14.74584, 120.91784],
                [14.74003, 120.91954],
                [14.696753, 120.950474],
                [14.688865, 120.945239],
                [14.713523, 120.919060],
                [14.700987, 120.906100],
                [14.713772, 120.899834],
                [14.71745, 120.9037],
                [14.74825, 120.89923]
            ], {color: 'red',
                fillColor: '#f03',
                fillOpacity: 0.5,
                fill: true}).addTo(map);

            var meycauayan = L.polygon([
                [14.719860, 120.959641],
                [14.734387, 120.948483],
                [14.737375, 120.936896],
                [14.733391, 120.934664],
                [14.740031, 120.919558],
                [14.745842, 120.917841],
                [14.74824, 120.89924],
                [14.75435, 120.89834],
                [14.75369, 120.91],
                [14.76827, 120.91414],
                [14.76391, 120.92238],
                [14.763272, 120.932089],
                [14.756632, 120.934149],
                [14.751818, 120.927454],
                [14.740197, 120.942732],
                [14.75163, 120.95188],
                [14.78276, 120.99723],
                [14.78076, 121.01337],
                [14.77281, 121.01101],
                [14.77478, 121.0271],
                [14.763106, 121.023413],
                [14.751154, 120.992857],
                [14.745012, 120.991827],
                [14.741359, 120.982043],
                [14.725588, 120.976035],
                [14.719860, 120.959641]
            ], {color: 'red',
                fillColor: '#f03',
                fillOpacity: 0.5,
                fill: true}).addTo(map);

            var marilao = L.polygon([
                [14.74028, 120.94276],
                [14.751866, 120.927542],
                [14.75663, 120.93414],
                [14.76329, 120.93208],
                [14.7639, 120.92238],
                [14.773777, 120.930288],
                [14.79157, 120.97091],
                [14.791039, 120.995520],
                [14.802325, 121.004790],
                [14.801993, 121.020239],
                [14.774773, 121.027105],
                [14.772781, 121.010969],
                [14.780748, 121.013373],
                [14.782740, 120.997236],
                [14.751534, 120.951918],
                [14.74028, 120.94276]
            ], {color: 'red',
                fillColor: '#f03',
                fillOpacity: 0.5,
                fill: true}).addTo(map);

            var sanjose = L.polygon([
                [14.85347, 121.02949],
                [14.822225, 121.026204],
                [14.802, 121.02024],
                [14.78111, 121.02548],
                [14.770111, 121.100018],
                [14.808949, 121.140530],
                [14.802642, 121.148770],
                [14.814591, 121.161129],
                [14.82717, 121.1619],
                [14.84829, 121.08822],
                [14.86683, 121.07192],
                [14.85347, 121.02949]
            ], {color: 'red',
                fillColor: '#f03',
                fillOpacity: 0.5,
                fill: true}).addTo(map);

            //DRT
            var DRT = L.polygon([
                [14.996405, 121.348261],
                [14.91711, 121.3477],
                [14.92308, 121.08392],
                [14.93736, 121.06655],
                [14.942857, 121.067857],
                [14.95632, 121.05994],
                [14.95809, 121.05487],
                [14.96753, 121.05698],
                [14.97539, 121.06243],
                [14.98172, 121.06188],
                [14.9901, 121.06568],
                [15.001129, 121.064596],
                [15.005853, 121.060793],
                [15.050184, 121.074181],
                [15.11488, 121.0626],
                [15.17732, 121.0884],
                [15.26875, 121.08222],
                [15.269302, 121.113777],
                [15.250966, 121.170795],
                [15.204100, 121.283776],
                [15.194419, 121.291696],
                [15.192381, 121.308590],
                [15.165886, 121.320733],
                [15.159771, 121.320733],
                [15.152127, 121.337099],
                [15.135820, 121.337099],
                [15.131233, 121.330764],
                [15.101162, 121.331820],
                [15.085870, 121.329708],
                [14.998174, 121.343963],
                [14.996134, 121.348186],
                [14.996405, 121.348261]

            ], {color: 'red',
                fillColor: '#f03',
                fillOpacity: 0.5,
                fill: true}).addTo(map);

            var norzagaray = L.polygon([
                [14.91716, 121.34617],
                [14.92308, 121.08392],
                [14.93736, 121.06655],
                [14.894443, 121.021287],
                [14.853404, 121.029453],
                [14.866822, 121.071914],
                [14.848274, 121.088245],
                [14.816305, 121.199706],
                [14.821831, 121.241759],
                [14.843538, 121.296469],
                [14.860508, 121.311576],
                [14.865638, 121.341788],
                [14.91716, 121.34617]
            ], {color: 'red',
                fillColor: '#f03',
                fillOpacity: 0.5,
                fill: true}).addTo(map);

            var guiguinto = L.polygon([
                [14.86625, 120.90186],
                [14.861913, 120.880487],
                [14.865895, 120.875852],
                [14.86621, 120.85777],
                [14.81666, 120.86698],
                [14.82338, 120.87671],
                [14.81374, 120.89252],
                [14.818438, 120.892846],
                [14.825408, 120.891988],
                [14.826901, 120.897996],
                [14.833041, 120.900056],
                [14.840508, 120.898168],
                [14.85873, 120.90323],
                [14.86625, 120.90186]
            ], {color: 'red',
                fillColor: '#f03',
                fillOpacity: 0.5,
                fill: true}).addTo(map);

            //BALAGTAS
            var balagtas = L.polygon([
                [14.796551, 120.910581],
                [14.7867, 120.91479],
                [14.78268, 120.90312],
                [14.79514, 120.89355], //1

                [14.82541, 120.89198],
                [14.8269, 120.89801],
                [14.83305, 120.90007],
                [14.84051, 120.89816],
                [14.858742, 120.903222],
                [14.86627, 120.90186],
                [14.868015, 120.914858],
                [14.860518, 120.918329],
                [14.856374, 120.922820],
                [14.852428, 120.921187],
                [14.845324, 120.920982],
                [14.841180, 120.922207],
                [14.836444, 120.923228],
                [14.832892, 120.926903],
                [14.829537, 120.923024],
                [14.82861, 120.9281],
                [14.825262, 120.924313],
            ], {color: 'red',
                fillColor: '#f03',
                fillOpacity: 0.5,
                fill: true}).addTo(map);

            //ANGAT
            var angat = L.polygon([
                [14.917832, 120.999520],
                [14.900580, 120.978577],
                [14.908874, 120.972398],
                [14.914846, 120.970681],
                [14.921149, 120.956605],
                [14.932428, 120.955575],
                [14.949346, 120.959008],
                [14.95802, 120.96038],
                [14.94815, 120.99046],
                [14.95848, 120.9992],
                [14.958965, 121.016686],
                [14.95925, 121.02507],
                [14.974554, 121.033166],
                [14.98459, 121.03905],
                [14.99011, 121.06567],
                [14.98172, 121.06188],
                [14.97539, 121.06243],
                [14.96753, 121.05698],
                [14.95809, 121.05487],
                [14.95632, 121.05994],
                [14.94288, 121.06786],
                [14.93742, 121.06652],
                [14.929111, 121.057542],
                [14.89449, 121.02123],
                [14.89764, 121.00438],
                [14.89031, 120.9987],
                [14.89065, 120.99495],
                [14.908543, 121.000207],
                [14.917832, 120.999520]
            ], {color: 'red',
                fillColor: '#f03',
                fillOpacity: 0.5,
                fill: true}).addTo(map);

            //SANTA MARIA
            var santamaria = L.polygon([
                [14.89449, 121.02123],
                [14.85347, 121.02942],
                [14.82224, 121.02621],
                [14.80201, 121.02023],
                [14.8024, 121.00488],
                [14.79107, 120.99552],
                [14.790875, 120.992879],
                [14.790875, 120.984296],
                [14.791539, 120.970906],
                [14.78665, 120.95964],
                [14.81329, 120.94309],
                [14.842985, 120.952710],
                [14.842985, 120.950822],
                [14.851779, 120.952367],
                [14.860241, 120.979146],
                [14.890626, 120.994939],
                [14.890294, 120.998715],
                [14.897594, 121.004380],
                [14.89449, 121.02123]
            ], {color: 'red',
                fillColor: '#f03',
                fillOpacity: 0.5,
                fill: true}).addTo(map);

            //PULILAN
            var pulilan = L.polygon([
                [14.93451, 120.79531],
                [14.935759, 120.802466],
                [14.934432, 120.804011],
                [14.935925, 120.804354],
                [14.933769, 120.815684],
                [14.936422, 120.815512],
                [14.939242, 120.818087],
                [14.945130, 120.817486],
                [14.949691, 120.820920],
                [14.951930, 120.821435],
                [14.953588, 120.825726],
                [14.956988, 120.832764],
                [14.955744, 120.834996],
                [14.954666, 120.838429],
                [14.95587, 120.84993],
                [14.92466, 120.8535],
                [14.92351, 120.86843],
                [14.91703, 120.87081],
                [14.90742, 120.89023],
                [14.90362, 120.88015],
                [14.89331, 120.87673],
                [14.88769, 120.85818],
                [14.90096, 120.85887],
                [14.90495, 120.82385],
                [14.9008, 120.80245],
                [14.93451, 120.79531]
            ], {color: 'red',
                fillColor: '#f03',
                fillOpacity: 0.5,
                fill: true}).addTo(map);

            var sanmiguel = L.polygon([
                [15.268745, 121.082221],
                [15.177313, 121.088400],
                [15.11488, 121.0626],
                [15.09968, 120.99085],
                [15.112358, 120.982657],
                [15.12102, 120.94424],
                [15.128267, 120.944205],
                [15.136221, 120.951071],
                [15.144838, 120.934592],
                [15.154117, 120.921546],
                [15.178638, 120.916739],
                [15.183939, 120.920859],
                [15.185265, 120.926352],
                [15.213758, 120.930472],
                [15.215745, 120.940085],
                [15.228334, 120.946265],
                [15.231647, 120.974417],
                [15.225021, 120.981284],
                [15.247547, 121.006690],
                [15.255496, 121.042395],
                [15.263445, 121.047202],
                [15.268745, 121.082221]
            ], {color: 'red',
                fillColor: '#f03',
                fillOpacity: 0.5,
                fill: true}).addTo(map);

            var pandi = L.polygon([
                [14.91784, 120.99951],
                [14.90855, 121.00021],
                [14.89063, 120.99493],
                [14.86025, 120.97915],
                [14.851964, 120.952591],
                [14.84299, 120.95081],
                [14.84292, 120.94447],
                [14.82863, 120.92809],
                [14.82954, 120.92302],
                [14.83289, 120.92691],
                [14.83645, 120.92324],
                [14.84533, 120.92098],
                [14.85244, 120.92118],
                [14.85638, 120.92282],
                [14.86054, 120.91832],
                [14.86803, 120.91485],
                [14.87209, 120.90729],
                [14.89225, 120.90419],
                [14.89441, 120.91264],
                [14.898584, 120.916886],
                [14.900243, 120.932164],
                [14.905054, 120.936970],
                [14.908869, 120.956025],
                [14.919983, 120.959114],
                [14.91486, 120.97068],
                [14.90888, 120.97238],
                [14.9006, 120.97858],
                [14.91784, 120.99951]
            ], {color: 'red',
                fillColor: '#f03',
                fillOpacity: 0.5,
                fill: true}).addTo(map);

            var bustos = L.polygon([
                [14.90889, 120.95602],
                [14.90507, 120.93697],
                [14.90024, 120.93217],
                [14.8986, 120.91689],
                [14.894395, 120.912640],
                [14.89224, 120.90419],
                [14.900035, 120.903027],
                [14.904016, 120.908864],
                [14.922429, 120.908864],
                [14.92177, 120.88865],
                [14.92948, 120.88783], //1
                [14.96825, 120.91556],
                [14.95754, 120.95195],
                [14.95803, 120.96037],
                [14.93247, 120.95558],
                [14.92117, 120.9566],
                [14.92003, 120.9591],
                [14.90889, 120.95602]
            ], {color: 'red',
                fillColor: '#f03',
                fillOpacity: 0.5,
                fill: true}).addTo(map);


//            sanrafael.bindPopup("San Rafael" + " " + "<a onClick='ViewSanRafael();' href='#'>View</a>");
//            bocaue.bindPopup("Bocaue" + " " + "<a onClick='ViewBocaue();' href='#'>View</a>");
//            baliuag.bindPopup("Baliuag" + " " + "<a onClick='ViewBaliuag();' href='#'>View</a>");
//            pulilan.bindPopup("Puliilan" + " " + "<a onClick='ViewPulilan();' href='#'>View</a>");
//            sanidelfonso.bindPopup("San Idelfonso" + " " + "<a onClick='ViewSanIdelfonso();' href='#'>View</a>");
//            calumpit.bindPopup("Calumpit" + " " + "<a onClick='ViewCalumpit();' href='#'>View</a>");
//            hagonoy.bindPopup("Hagonoy" + " " + "<a onClick='ViewHagonoy();' href='#'>View</a>");
//            paombong.bindPopup("Paombong" + " " + "<a onClick='ViewPaombong();' href='#'>View</a>");
//            bulacan.bindPopup("Bulacan" + " " + "<a onClick='ViewBulacan();' href='#'>View</a>");
//            malolos.bindPopup("Malolos" + " " + "<a onClick='ViewMalolos();' href='#'>View</a>");
//            plaridel.bindPopup("Plaridel" + " " + "<a onClick='ViewPlaridel();' href='#'>View</a>");
//            obando.bindPopup("Obando" + " " + "<a onClick='ViewObando();' href='#'>View</a>");
//            meycauayan.bindPopup("Meycauayan" + " " + "<a onClick='ViewMeycauayan();' href='#'>View</a>");
//            marilao.bindPopup("Marilao" + " " + "<a onClick='ViewMarilao();' href='#'>View</a>");
//            sanjose.bindPopup("San Jose" + " " + "<a onClick='ViewSanJose();' href='#'>View</a>");
//            norzagaray.bindPopup("Norgazaray " + " " + "<a onClick='ViewNorgazaray();' href='#'>View</a>");
//            guiguinto.bindPopup("Guiguinto" + " " + "<a onClick='ViewGuiguinto();' href='#'>View</a>");
//            balagtas.bindPopup("Balagtas" + " " + "<a onClick='ViewBalagtas();' href='#'>View</a>");
//            angat.bindPopup("Angat" + " " + "<a onClick='ViewAngat();' href='#'>View</a>");
//            santamaria.bindPopup("Santa Maria" + " " + "<a onClick='ViewSantaMaria();' href='#'>View</a>");
//            pulilan.bindPopup("Pulilan" + " " + "<a onClick='ViewPulilan();' href='#'>View</a>");
//            DRT.bindPopup("DRT" + " " + "<a onClick='ViewDRT();' href='#'>View</a>");
//            sanmiguel.bindPopup("San Miguel" + " " + "<a onClick='ViewSanMiguel();' href='#'>View</a>");
//            pandi.bindPopup("Pandi" + " " + "<a onClick='ViewPandi();' href='#'>View</a>");
//            bustos.bindPopup("Bustos" + " " + "<a onClick='ViewBustos();' href='#'>View</a>");

//            function ViewSanRafael() {
//                map.setView([14.989514, 120.965985], 12.5);
//                map.closePopup();
//            }
//
//            function ViewBocaue() {
//                map.setView([, ], 12);
//                map.closePopup();
//            }
//
//            function ViewBaliuag() {
//                map.setView([, ], 12);
//                map.closePopup();
//            }
//
//            function ViewSanIdelfonso() {
//                map.setView([, ], 12);
//                map.closePopup();
//            }
//
//            function ViewCalumpit() {
//                map.setView([, ], 12);
//                map.closePopup();
//            }
//
//            function ViewHagonoy() {
//                map.setView([, ], 12);
//                map.closePopup();
//            }
//
//            function ViewPaombong() {
//                map.setView([, ], 12);
//                map.closePopup();
//            }
//
//            function ViewBulacan() {
//                map.setView([, ], 12);
//                map.closePopup();
//            }
//
//            function ViewMalolos() {
//                map.setView([, ], 12);
//                map.closePopup();
//            }
//
//            function ViewPlaridel() {
//                map.setView([, ], 12);
//                map.closePopup();
//            }
//
//            function ViewObando() {
//                map.setView([, ], 12);
//                map.closePopup();
//            }
//
//            function ViewMeycauayan() {
//                map.setView([, ], 12);
//                map.closePopup();
//            }
//
//            function ViewMarilao() {
//                map.setView([, ], 12);
//                map.closePopup();
//            }
//
//            function ViewSanJose() {
//                map.setView([, ], 12);
//                map.closePopup();
//            }
//
//            function ViewNorzagaray() {
//                map.setView([, ], 12);
//                map.closePopup();
//            }
//
//            function ViewGuiguinto() {
//                map.setView([, ], 12);
//                map.closePopup();
//            }
//
//            function ViewBalagtas() {
//                map.setView([, ], 12);
//                map.closePopup();
//            }
//
//            function ViewAngat() {
//                map.setView([, ], 12);
//                map.closePopup();
//            }
//
//            function ViewSantaMaria() {
//                map.setView([, ], 12);
//                map.closePopup();
//            }
//
//            function ViewPulilan() {
//                map.setView([, ], 12);
//                map.closePopup();
//            }
//
//            function ViewDRT() {
//                map.setView([15.06844, 121.19705], 12);
//                map.closePopup();
//            }
//
//            function ViewSanMiguel() {
//                map.setView([15.17848, 121.01166], 12);
//                map.closePopup();
//            }
//
//            function ViewPandi() {
//                map.setView([, ], 12);
//                map.closePopup();
//            }
//
//            function ViewBustos() {
//                map.setView([, ], 12);
//                map.closePopup();
//            }
//                FUNCTION TO GET COORDINATES ON CLICK

//            function onMapClick(e) {
//                alert("You clicked the map at " + e.latlng);
//            }
//
//            map.on('click', onMapClick);
//
            map.dragging.disable();
            map.touchZoom.disable();
            map.doubleClickZoom.disable();
            map.scrollWheelZoom.disable();
            map.keyboard.disable();
        </script>
        <!--//MAP-->
    </body>
</html>

