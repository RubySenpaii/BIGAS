<%-- 
    Document   : homepage
    Created on : Sep 9, 2016, 5:35:46 PM
    Author     : RubySenpaii
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="dao.WeeklyReportsDAO"%>
<%@page import="servlet.web.Dashboard"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- Meta, title, CSS, favicons, etc. -->
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <title>B.I.G.A.S. System | Dashboard</title>
        <!-- jQuery -->
        <script src="/BIGAS/vendors/jquery/dist/jquery.min.js"></script>
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
        <!--highchart.js -->
        <script src="/BIGAS/web/js/highchart/highcharts.js" type="text/javascript"></script>
        <script src="/BIGAS/web/js/highchart/modules/exporting.js" type="text/javascript"></script>
        <!-- Custom Theme Style -->
        <link href="/BIGAS/build/css/custom.min.css" rel="stylesheet">
        <!-- Datatables -->
        <link href="/BIGAS/vendors/datatables.net-bs/css/dataTables.bootstrap.min.css" rel="stylesheet">
        <link href="/BIGAS/vendors/datatables.net-buttons-bs/css/buttons.bootstrap.min.css" rel="stylesheet">
        <link href="/BIGAS/vendors/datatables.net-fixedheader-bs/css/fixedHeader.bootstrap.min.css" rel="stylesheet">
        <link href="/BIGAS/vendors/datatables.net-responsive-bs/css/responsive.bootstrap.min.css" rel="stylesheet">
        <link href="/BIGAS/vendors/datatables.net-scroller-bs/css/scroller.bootstrap.min.css" rel="stylesheet">

        <script type="text/javascript">
            $(function () {
                $('#productionGraph').highcharts({
                    chart: {
                        type: 'line'
                    },
                    title: {
                        text: 'Planted Area by Week'
                    },
                    xAxis: {
                        categories: ['Week 1', 'Week 2', 'Week 3', 'Week 4', 'Week 5', 'Week 6', 'Week 7']
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
                            name: 'Actual',
                            data: [7.0, 7.8, 9.5, 14.5, 18.4, 21.5, 25.2]
                        }, {
                            name: 'Total Area',
                            data: [30, 30, 30, 30, 30, 30, 30]
                        }]
                });

//                PIE CHART
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
                    <div class="x_title">
                        <h2>Dashboard - San Rafael, Bulacan - <%=session.getAttribute("Season")%></h2>
                        <div class="clearfix"></div>
                    </div>
                    <!-- top tiles -->
                    <div class="row tile_count">
                        <div class="col-md-3 col-sm-3 col-xs-6 tile_stats_count">
                            <span class="count_top"><i class="fa fa-pagelines"></i> Current Ideal Stage</span>
                            <div class="count"><%=(String) session.getAttribute("currStage")%></div>
                            <span class="count_bottom"><p class="green"><%=(Double) session.getAttribute("farmPercentage")%> % of Farms are in this stage</p></span>
                        </div>
                        <div class="col-md-3 col-sm-3 col-xs-6 tile_stats_count">
                            <span class="count_top"><i class="fa fa-clock-o"></i> Planting Reports</span>
                            <div class="count"><a href="/BIGAS/web/mao/monitoringcropgrowth.jsp">8 New</a></div>
                            <span class="count_bottom">Click to View</span>
                        </div>
                        <div class="col-md-3 col-sm-3 col-xs-6 tile_stats_count">
                            <span class="count_top"><i class="fa fa-bug"></i> Damage Reports</span>
                            <div class="count"><a href="/BIGAS/web/mao/monitoringdamages.jsp">2 New</a></div>
                            <span class="count_bottom">Click to View</span>
                        </div>
                        <div class="col-md-3 col-sm-3 col-xs-6 tile_stats_count">
                            <span class="count_top"><i class="fa fa-line-chart"></i> Target Production</span>
                            <div class="count"><a href="/BIGAS/web/mao/monitoringproduction.jsp">3000 MT</a></div>                 
                        </div>
                    </div>
                    <!-- /top tiles -->
                    <div class="row">
                        <div class="col-md-5 col-sm-5 col-xs-12">
                            <div class="x_panel">
                                <div class="x_title">
                                    <h2>Total Planted Area - -% Complete</h2>
                                    <div class="clearfix"></div>
                                </div>
                                <div class="x_content">
                                    <div id="productionGraph" style="min-width: 310px; height: 400px; margin: 0 auto"></div>
                                </div>
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

                        <div class="col-md-7 col-sm-7 col-xs-12">

                            <div class="col-lg-6 col-md-6 col-sm-6 col-xs-6">

                            </div>

                            <div class="col-lg-6 col-md-6 col-sm-6 col-xs-6">
                                <iframe id="forecast_embed" type="text/html" frameborder="0" height="245" width="100%" src="http://forecast.io/embed/#lat=14.794273&lon=120.879901&name=San Rafael&units=si"> </iframe>
                            </div>

                            <div class="x_panel">
                                <div class="col-md-12 col-sm-12 col-xs-12">
                                    <div class="x_panel">
                                        <div class="x_title">
                                            <h2><a href="viewassignedfarms.jsp">Unvisited Farms</a></h2>
                                            <div class="clearfix"></div>
                                        </div>
                                        <div class="x_content">



                                            <table id="datatable" class="table table-striped table-bordered">
                                                <thead>
                                                    <tr>
                                                        <th>Name</th>
                                                        <th>Address</th>
                                                        <th>Land Area</th>
                                                        <th>Assigned Technician</th>
                                                        <th>View</th>
                                                    </tr>
                                                </thead>


                                                <tbody>
                                                    <tr>
                                                        <td>Tatyana Fitzpatrick</td>
                                                        <td>Regional Director</td>
                                                        <td>London</td>
                                                        <td>19</td>
                                                        <td>2010/03/17</td>
                                                    </tr>
                                                    <tr>
                                                        <td>Michael Silva</td>
                                                        <td>Marketing Designer</td>
                                                        <td>London</td>
                                                        <td>66</td>
                                                        <td>2012/11/27</td>

                                                    </tr>
                                                    <tr>
                                                        <td>Paul Byrd</td>
                                                        <td>Chief Financial Officer (CFO)</td>
                                                        <td>New York</td>
                                                        <td>64</td>
                                                        <td>2010/06/09</td>
                                                    </tr>
                                                    <tr>
                                                        <td>Gloria Little</td>
                                                        <td>Systems Administrator</td>
                                                        <td>New York</td>
                                                        <td>59</td>
                                                        <td>2009/04/10</td>
                                                    </tr>
                                                    <tr>
                                                        <td>Bradley Greer</td>
                                                        <td>Software Engineer</td>
                                                        <td>London</td>
                                                        <td>41</td>
                                                        <td>2012/10/13</td>
                                                    </tr>
                                                    <tr>
                                                        <td>Dai Rios</td>
                                                        <td>Personnel Lead</td>
                                                        <td>Edinburgh</td>
                                                        <td>35</td>
                                                        <td>2012/09/26</td>
                                                    </tr>
                                                    <tr>
                                                        <td>Jenette Caldwell</td>
                                                        <td>Development Lead</td>
                                                        <td>New York</td>
                                                        <td>30</td>
                                                        <td>2011/09/03</td>
                                                    </tr>
                                                    <tr>
                                                        <td>Gavin Joyce</td>
                                                        <td>Developer</td>
                                                        <td>Edinburgh</td>
                                                        <td>42</td>
                                                        <td>2010/12/22</td>
                                                    </tr>
                                                    <tr>
                                                        <td>Jennifer Chang</td>
                                                        <td>Regional Director</td>
                                                        <td>Singapore</td>
                                                        <td>28</td>
                                                        <td>2010/11/14</td>
                                                    </tr>
                                                    <tr>
                                                        <td>Brenden Wagner</td>
                                                        <td>Software Engineer</td>
                                                        <td>San Francisco</td>
                                                        <td>28</td>
                                                        <td>2011/06/07</td>
                                                    </tr>
                                                    <tr>
                                                        <td>Fiona Green</td>
                                                        <td>Chief Operating Officer (COO)</td>
                                                        <td>San Francisco</td>
                                                        <td>48</td>
                                                        <td>2010/03/11</td>
                                                    </tr>
                                                    <tr>
                                                        <td>Shou Itou</td>
                                                        <td>Regional Marketing</td>
                                                        <td>Tokyo</td>
                                                        <td>20</td>
                                                        <td>2011/08/14</td>
                                                    </tr>
                                                    <tr>
                                                        <td>Michelle House</td>
                                                        <td>Integration Specialist</td>
                                                        <td>Sidney</td>
                                                        <td>37</td>
                                                        <td>2011/06/02</td>
                                                    </tr>
                                                    <tr>
                                                        <td>Suki Burks</td>
                                                        <td>Developer</td>
                                                        <td>London</td>
                                                        <td>53</td>
                                                        <td>2009/10/22</td>
                                                    </tr>
                                                    <tr>
                                                        <td>Prescott Bartlett</td>
                                                        <td>Technical Author</td>
                                                        <td>London</td>
                                                        <td>27</td>
                                                        <td>2011/05/07</td>
                                                    </tr>
                                                    <tr>
                                                        <td>Gavin Cortez</td>
                                                        <td>Team Leader</td>
                                                        <td>San Francisco</td>
                                                        <td>22</td>
                                                        <td>2008/10/26</td>
                                                    </tr>
                                                    <tr>
                                                        <td>Martena Mccray</td>
                                                        <td>Post-Sales support</td>
                                                        <td>Edinburgh</td>
                                                        <td>46</td>
                                                        <td>2011/03/09</td>
                                                    </tr>
                                                    <tr>
                                                        <td>Unity Butler</td>
                                                        <td>Marketing Designer</td>
                                                        <td>San Francisco</td>
                                                        <td>47</td>
                                                        <td>2009/12/09</td>
                                                    </tr>
                                                    <tr>
                                                        <td>Howard Hatfield</td>
                                                        <td>Office Manager</td>
                                                        <td>San Francisco</td>
                                                        <td>51</td>
                                                        <td>2008/12/16</td>
                                                    </tr>
                                                    <tr>
                                                        <td>Hope Fuentes</td>
                                                        <td>Secretary</td>
                                                        <td>San Francisco</td>
                                                        <td>41</td>
                                                        <td>2010/02/12</td>
                                                    </tr>
                                                    <tr>
                                                        <td>Vivian Harrell</td>
                                                        <td>Financial Controller</td>
                                                        <td>San Francisco</td>
                                                        <td>62</td>
                                                        <td>2009/02/14</td>
                                                        <td>$452,500</td>
                                                    </tr>
                                                    <tr>
                                                        <td>Timothy Mooney</td>
                                                        <td>Office Manager</td>
                                                        <td>London</td>
                                                        <td>37</td>
                                                        <td>2008/12/11</td>
                                                    </tr>
                                                    <tr>
                                                        <td>Jackson Bradshaw</td>
                                                        <td>Director</td>
                                                        <td>New York</td>
                                                        <td>65</td>
                                                        <td>2008/09/26</td>
                                                    </tr>
                                                    <tr>
                                                        <td>Olivia Liang</td>
                                                        <td>Support Engineer</td>
                                                        <td>Singapore</td>
                                                        <td>64</td>
                                                        <td>2011/02/03</td>
                                                    </tr>
                                                </tbody>
                                            </table>
                                        </div>
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
    <script src="/BIGAS/vendors/bootstrap/dist/js/bootstrap.min.js"></script>
    <!-- FastClick -->
    <script src="/BIGAS/vendors/fastclick/lib/fastclick.js"></script>
    <!-- NProgress -->
    <script src="/BIGAS/vendors/nprogress/nprogress.js"></script>
    <!-- Chart.js -->
    <script src="/BIGAS/vendors/Chart.js/dist/Chart.min.js"></script>
    <!-- gauge.js -->
    <script src="/BIGAS/vendors/bernii/gauge.js/dist/gauge.min.js"></script>
    <!-- bootstrap-progressbar -->
    <script src="/BIGAS/vendors/bootstrap-progressbar/bootstrap-progressbar.min.js"></script>
    <!-- bootstrap-daterangepicker -->
    <script src="/BIGAS/web/js/moment/moment.min.js"></script>
    <script src="/BIGAS/web/js/datepicker/daterangepicker.js"></script>
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
    <!-- morris.js -->
    <script src="/BIGAS/vendors/raphael/raphael.min.js"></script>
    <script src="/BIGAS/vendors/morris.js/morris.min.js"></script>


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