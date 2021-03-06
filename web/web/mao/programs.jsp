<%-- 
    Document   : technician
    Created on : Jul 9, 2016, 11:32:15 AM
    Author     : RubySenpaii
--%>

<%@page import="objects.Farmer"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- Meta, title, CSS, favicons, etc. -->
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <title>B.I.G.A.S. System | Program Monitoring - Farms</title>

        <!-- Bootstrap -->
        <link href="/BIGAS/vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
        <!-- Font Awesome -->
        <link href="/BIGAS/vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet">
        <!-- iCheck -->
        <link href="/BIGAS/vendors/iCheck/skins/flat/green.css" rel="stylesheet">
        <!-- bootstrap-progressbar -->
        <link href="/BIGAS/vendors/bootstrap-progressbar/css/bootstrap-progressbar-3.3.4.min.css" rel="stylesheet">
        <!-- jVectorMap -->
        <link href="../css/maps/jquery-jvectormap-2.0.3.css" rel="stylesheet"/>
        <!--bootstrap progressbar-->
        <link href="/BIGAS/vendors/bootstrap-progressbar/css/bootstrap-progressbar-3.3.4.min.css" rel="stylesheet">


        <!-- Custom Theme Style -->
        <link href="/BIGAS/build/css/custom.min.css" rel="stylesheet">
    </head>

    <body class="nav-md">
        <div class="container body">
            <div class="main_container">
                <jsp:include page="pagesidebar.jsp"/>
                <jsp:include page="pageheader.jsp"/>
                <br />

                <!-- page content -->
                <div class="right_col" role="main">
                    <div class>
                        <div class="row">
                            <div class="col-md-12 col-sm-12 col-xs-12">
                                
                                    <div class="x_title">
                                        <h2>Program Monitoring - San Rafael, Bulacan</h2>
                                        <div class="clearfix"></div>
                                        
                                        
                                        <div class="col-md-7 col-sm-7 col-xs-7">
                                            <br>
                                            <div class="x_panel">
                                            <div class="x_title">
                                                <h2>Program Recommendations from PAOB</h2>
                                                <div class="clearfix"></div>
                                            </div>
                                            <div class="x_content">
                                                <table id="datatable" class="table table-striped table-bordered">
                                                    <thead>
                                                    <th></th>
                                                    <th>Program Name</th>
                                                    <th>Type</th>
                                                    <th>Description</th>
                                                    <th>Date Submitted</th>
                                                    <th>Project Lead</th>
                                                    <th>.</th>
                                                    </thead>
                                                    <tr>
                                                        <td></td>
                                                        <td>Rat Killing Program</td>
                                                        <td>Intervention</td>
                                                        <td>Eradicate Rat Infestations</td>
                                                        <td>11/25/2016</td>
                                                        <td>Rain Dela Rosa</td>
                                                        <td><a href="assigntechnicianprogram.jsp">Assign Members</a></td>
                                                    </tr>
                                                    <tr>
                                                        <td></td>
                                                        <td>Rat Killing Program</td>
                                                        <td>Intervention</td>
                                                        <td>Eradicate Rat Infestations</td>
                                                        <td>11/17/2016</td>
                                                        <td>Rain Dela Rosa</td>
                                                        <td><a href="assigntechnicianprogram.jsp">Assign Members</a></td>
                                                    </tr>

                                                </table>
                                            </div>
                                            </div>
                                            <div class="x_panel">
                                            <div class="x_title">
                                                <h2>Active Programs</h2>
                                                <div class="clearfix"></div>
                                            </div>
                                            <div class="x_content">
                                                <table id="datatable1" class="table table-striped table-bordered">
                                                    <thead>
                                                    <th></th>
                                                    <th>Program Name</th>
                                                    <th>Type</th>
                                                    <th>Description</th>
                                                    <th>Date Started</th>
                                                    <th>Status</th>
                                                    <th>View</th>
                                                    </thead>
                                                    <tr>
                                                        <td></td>
                                                        <td>Rat Killing Program</td>
                                                        <td>Intervention</td>
                                                        <td>Eradicate Rat Infestations</td>
                                                        <td>10/31/2015</td>
                                                        <td>Started</td>
                                                        <td>View Details</td>
                                                    </tr>
                                                    <tr>
                                                        <td></td>
                                                        <td>Rat Killing Program</td>
                                                        <td>Intervention</td>
                                                        <td>Eradicate Rat Infestations</td>
                                                        <td>11/05/2016</td>
                                                        <td>Started</td>
                                                        <td>View Details</td>
                                                    </tr>

                                                </table>
                                            </div>
                                            </div>

                                        </div>
                                        <div class="col-md-5 col-sm-5 col-xs-5">


                                        </div>


                                    </div>
                                
                            </div>
                        </div>
                    </div>
                    <!--end: page content container-->
                </div>
            </div>
            <!-- /page content -->
            <jsp:include page="pagefooter.jsp"/>
        </div>

        <!-- jQuery -->
        <script src="/BIGAS/vendors/jquery/dist/jquery.min.js"></script>
        <!-- Bootstrap -->
        <script src="/BIGAS/vendors/bootstrap/dist/js/bootstrap.min.js"></script>
        <!-- FastClick -->
        <script src="/BIGAS/vendors/fastclick/lib/fastclick.js"></script>
        <!-- NProgress -->
        <script src="/BIGAS/vendors/nprogress/nprogress.js"></script>
        <!-- iCheck -->
        <script src="/BIGAS/vendors/iCheck/icheck.min.js"></script>
        <!-- Skycons -->
        <script src="/BIGAS/vendors/skycons/skycons.js"></script>
        <!--progressbar-->
        <script src="/BIGAS/vendors/bootstrap-progressbar/bootstrap-progressbar.min.js"></script>


        <!-- Custom Theme Scripts -->
        <script src="/BIGAS/build/js/custom.min.js"></script>

        <!--table-->
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

        <!-- Autosize -->
        <script>
            $(document).ready(function () {
                var handleDataTableButtons = function () {
                    if ($("#datatable-buttons").length) {
                        $("#datatable-buttons").DataTable({
                            dom: "Bfrtip",
                            buttons: [
                                {
                                    extend: "copy",
                                    className: "btn-sm"
                                },
                                {
                                    extend: "csv",
                                    className: "btn-sm"
                                },
                                {
                                    extend: "excel",
                                    className: "btn-sm"
                                },
                                {
                                    extend: "pdfHtml5",
                                    className: "btn-sm"
                                },
                                {
                                    extend: "print",
                                    className: "btn-sm"
                                },
                            ],
                            responsive: true
                        });
                    }
                };

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
                $('#datatable2').dataTable();
                $('#datatable3').dataTable();
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
        <!-- /Autosize -->
    </body>
</html>
