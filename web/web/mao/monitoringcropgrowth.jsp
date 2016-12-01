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
        <script src="../js/highchart/highcharts-more.js"></script>
        <script src="../js/highchart/modules/exporting.js"></script>
        <script src="../js/highchart/modules/drilldown.js"></script>
        <script src="../js/highchart/modules/solid-gauge.js"></script>

        <script>
            $(function () {
                $('#pie').highcharts({
                    chart: {
                        plotBackgroundColor: null,
                        plotBorderWidth: 0,
                        plotShadow: false
                    },
                    title: {
                        text: 'Wet<br>Season<br>2016',
                        align: 'center',
                        verticalAlign: 'middle',
                        y: 40
                    },
                    tooltip: {
                        pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
                    },
                    plotOptions: {
                        pie: {
                            dataLabels: {
                                enabled: true,
                                distance: -50,
                                style: {
                                    fontWeight: 'bold',
                                    color: 'white'
                                }
                            },
                            startAngle: -90,
                            endAngle: 90,
                            center: ['50%', '75%']
                        }
                    },
                    series: [{
                            type: 'pie',
                            name: 'Contribution',
                            innerSize: '50%',
                            data: [
                                ['Newly Planted', 10.38],
                                ['Tillering', 56.33],
                                ['Reproductive', 29.71],
                                ['Harvest', 0.0],
                                {
                                    name: 'Proprietary or Undetectable',
                                    y: 0.2,
                                    dataLabels: {
                                        enabled: false
                                    }
                                }
                            ]
                        }]
                });

                $('#GDD').highcharts({
                    chart: {
                        type: 'line'
                    },
                    title: {
                        text: 'GDD - Estimated to Start Harvest by --/--/----'
                    },
                    xAxis: {
                        categories: ['11/18', '11/19', '11/20', '11/21', '11/22', '11/23', '11/24']
                    },
                    yAxis: {
                        title: {
                            text: 'Hectares'
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
                            name: 'GDU',
                            data: [7.0, 7.8, 9.5, 14.5, 18.4, 21.5, 25.2]
                        }, {
                            name: 'GDD',
                            data: [30, 30, 30, 30, 30, 30, 30]
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
                            <h2>Crop Growth Monitoring - San Rafael, Bulacan</h2>
                            <div class="clearfix"></div>
                        </div>
                        <div class="col-md-5 col-xs-12">

                            <div class="tile-stats col-md-6 col-xs-6">
                                <div class="icon"><i class="fa fa-caret-square-o-right"></i></div>
                                <div class="count">200 Ha</div>
                                <h3>Current Planted Area</h3>
                                <p>Dry Season 2016</p>
                            </div>

                            <div class="tile-stats col-md-6 col-xs-6">
                                <div class="icon"><i class="fa fa-bar-chart"></i></div>
                                <div class="count">600 Ha</div>
                                <h3>Total Plantable Area</h3>
                                <p>.</p>
                            </div>

                            <div class="x_panel">
                                <div class="x_title">
                                    <h2>Current Palay Stages</h2>
                                    <div class="clearfix"></div>
                                </div>
                                <div class="x_content">
                                    <div id="pie" style="min-width: 310px; height: 400px; margin: 0 auto"></div>
                                </div>
                            </div>
                        </div>

                        <!-- TABLE -->
                        <div class="col-md-7 col-sm-7 col-xs-12">
                            <div class="x_panel">
                                <div class="x_title">
                                    <h2>New Planting Reports</h2>
                                    <div class="clearfix"></div>
                                </div>
                                <div class="x_content">
                                    <table id="datatable1" class="table table-striped table-bordered">
                                        <thead>
                                            <tr>
                                                <th>Date Reported</th>
                                                <th>Farmer Name</th>
                                                <th>Address</th>
                                                <th>Area Planted</th>
                                                <th>Seed Planted</th>
                                                <th>Assigned Technician</th>
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
                            <div class="x_panel">
                                <div id="GDD"></div>
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

