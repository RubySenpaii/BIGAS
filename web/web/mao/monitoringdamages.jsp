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

        <script>
            $(function () {
                Highcharts.chart('container', {
                    chart: {
                        type: 'area'
                    },
                    title: {
                        text: 'Damage Occurences per Category'
                    },
                    subtitle: {
                        text: 'For the Past 5 Years'
                    },
                    xAxis: {
                        categories: ['2012', '2013', '2014', '2015', '2016'],
                        tickmarkPlacement: 'on',
                        title: {
                            enabled: false
                        }
                    },
                    yAxis: {
                        title: {
                            text: 'Thousands'
                        },
                        labels: {
                            formatter: function () {
                                return this.value / 1000;
                            }
                        }
                    },
                    tooltip: {
                        split: true,
                        valueSuffix: ' Cases'
                    },
                    plotOptions: {
                        area: {
                            stacking: 'normal',
                            lineColor: '#666666',
                            lineWidth: 1,
                            marker: {
                                lineWidth: 1,
                                lineColor: '#666666'
                            }
                        }
                    },
                    series: [{
                            name: 'Disaster',
                            data: [502, 635, 809, 947, 1402]
                        }, {
                            name: 'Pest',
                            data: [106, 107, 111, 133, 221]
                        }, {
                            name: 'Disease',
                            data: [163, 203, 276, 408, 547]
                        }, {
                            name: 'Others',
                            data: [18, 31, 54, 156, 339]
                        }]
                });
            });

            $(function () {
                Highcharts.chart('piechart', {
                    chart: {
                        plotBackgroundColor: null,
                        plotBorderWidth: null,
                        plotShadow: false,
                        type: 'pie'
                    },
                    title: {
                        text: 'Damage Distribution for WS 2016'
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
                            name: 'Brands',
                            colorByPoint: true,
                            data: [{
                                    name: 'Disaster',
                                    y: 56.33
                                }, {
                                    name: 'Pest',
                                    y: 24.03,
                                    sliced: true,
                                    selected: true
                                }, {
                                    name: 'Disease',
                                    y: 10.38
                                }, {
                                    name: 'Others',
                                    y: 5.70
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
                        <div class="x_title">
                            <h2>Pest and Damage Monitoring - San Rafael, Bulacan</h2>
                            <div class="clearfix"></div>
                        </div>
                        <div class="col-md-5 col-xs-12">
                            <div class="tile-stats col-md-6 col-xs-6">
                                <div class="icon"><i class="fa fa-caret-square-o-right"></i></div>
                                <div class="count">20 Ha</div>
                                <h3>Damaged Area</h3>
                                <p>Dry Season 2016</p>
                            </div>

                            <div class="tile-stats col-md-6 col-xs-6">
                                <div class="icon"><i class="fa fa-bar-chart"></i></div>
                                <div class="count">5 Programs</div>
                                <h3>Ongoing</h3>
                                <p>For Damages</p>
                            </div>
                            <div class="x_panel">
                                <input type="checkbox" checked="checked"> Dry Season</input><br>
                                <input type="checkbox" checked="checked"> Dry Season</input>
                                <div id="container" class="col-md-12 col-sm-12 col-xs-12" style="min-width: 310px; height: 400px; margin: 0 auto"></div>
                            </div>
                        </div>

                        <!-- TABLE -->
                        <div class="col-md-7 col-sm-7 col-xs-12">
                            <div class="x_panel">
                                <div class="x_title">
                                    <h2>New Damage Reports</h2>
                                    <div class="clearfix"></div>
                                </div>
                                <div class="x_content">
                                    <table id="datatable1" class="table table-striped table-bordered">
                                        <thead>
                                            <tr>
                                                <th>Date Reported</th>
                                                <th>Name</th>
                                                <th>Address</th>
                                                <th>Damaged Area</th>
                                                <th>Caused By</th>
                                                <th>Details</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <tr>
                                                <td>Tatyana Fitzpatrick</td>
                                                <td>Regional Director</td>
                                                <td>London</td>
                                                <td>19</td>
                                                <td>2010/03/17</td>
                                                <td><a href="#">View Details</a></td>
                                            </tr>
                                            <tr>
                                                <td>Michael Silva</td>
                                                <td>Marketing Designer</td>
                                                <td>London</td>
                                                <td>66</td>
                                                <td>2012/11/27</td>
                                                <td>$198,500</td>
                                            </tr>
                                            <tr>
                                                <td>Paul Byrd</td>
                                                <td>Chief Financial Officer (CFO)</td>
                                                <td>New York</td>
                                                <td>64</td>
                                                <td>2010/06/09</td>
                                                <td>$725,000</td>
                                            </tr>
                                            <tr>
                                                <td>Gloria Little</td>
                                                <td>Systems Administrator</td>
                                                <td>New York</td>
                                                <td>59</td>
                                                <td>2009/04/10</td>
                                                <td>$237,500</td>
                                            </tr>
                                            <tr>
                                                <td>Bradley Greer</td>
                                                <td>Software Engineer</td>
                                                <td>London</td>
                                                <td>41</td>
                                                <td>2012/10/13</td>
                                                <td>$132,000</td>
                                            </tr>
                                            <tr>
                                                <td>Dai Rios</td>
                                                <td>Personnel Lead</td>
                                                <td>Edinburgh</td>
                                                <td>35</td>
                                                <td>2012/09/26</td>
                                                <td>$217,500</td>
                                            </tr>
                                            <tr>
                                                <td>Jenette Caldwell</td>
                                                <td>Development Lead</td>
                                                <td>New York</td>
                                                <td>30</td>
                                                <td>2011/09/03</td>
                                                <td>$345,000</td>
                                            </tr>
                                            <tr>
                                                <td>Yuri Berry</td>
                                                <td>Chief Marketing Officer (CMO)</td>
                                                <td>New York</td>
                                                <td>40</td>
                                                <td>2009/06/25</td>
                                                <td>$675,000</td>
                                            </tr>
                                            <tr>
                                                <td>Caesar Vance</td>
                                                <td>Pre-Sales Support</td>
                                                <td>New York</td>
                                                <td>21</td>
                                                <td>2011/12/12</td>
                                                <td>$106,450</td>
                                            </tr>
                                            <tr>
                                                <td>Doris Wilder</td>
                                                <td>Sales Assistant</td>
                                                <td>Sidney</td>
                                                <td>23</td>
                                                <td>2010/09/20</td>
                                                <td>$85,600</td>
                                            </tr>
                                            <tr>
                                                <td>Angelica Ramos</td>
                                                <td>Chief Executive Officer (CEO)</td>
                                                <td>London</td>
                                                <td>47</td>
                                                <td>2009/10/09</td>
                                                <td>$1,200,000</td>
                                            </tr>
                                            <tr>
                                                <td>Gavin Joyce</td>
                                                <td>Developer</td>
                                                <td>Edinburgh</td>
                                                <td>42</td>
                                                <td>2010/12/22</td>
                                                <td>$92,575</td>
                                            </tr>
                                            <tr>
                                                <td>Jennifer Chang</td>
                                                <td>Regional Director</td>
                                                <td>Singapore</td>
                                                <td>28</td>
                                                <td>2010/11/14</td>
                                                <td>$357,650</td>
                                            </tr>
                                            <tr>
                                                <td>Brenden Wagner</td>
                                                <td>Software Engineer</td>
                                                <td>San Francisco</td>
                                                <td>28</td>
                                                <td>2011/06/07</td>
                                                <td>$206,850</td>
                                            </tr>
                                            <tr>
                                                <td>Fiona Green</td>
                                                <td>Chief Operating Officer (COO)</td>
                                                <td>San Francisco</td>
                                                <td>48</td>
                                                <td>2010/03/11</td>
                                                <td>$850,000</td>
                                            </tr>
                                        </tbody>
                                    </table>
                                </div>
                            </div>

                            <div class="x_panel"class="col-md-6 col-sm-6 col-xs-6">
                                <div id="piechart" class="col-md-12 col-sm-12 col-xs-12" style="min-width: 310px; height: 400px; margin: 0 auto"></div>
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
</body>
</html>

