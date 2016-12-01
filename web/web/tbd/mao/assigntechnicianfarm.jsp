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

        <title>B.I.G.A.S. System | Technician Assignment - Farms</title>

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
                                <div class="x_panel">
                                    <div class="x_title">
                                        <h2>Assign Technician - Farms</h2>
                                        <div class="clearfix"></div>
                                        <!--FIRST HALF-->
                                        <div class="col-md-5 col-sm-5 col-xs-5">
                                            <div class="x_panel">
                                                <div class="clearfix"></div>
                                                <div class="x_content">
                                                    <br />
                                                    <form id="demo-form2" data-parsley-validate class="form-horizontal form-label-left">

                                                        <div class="form-group">
                                                            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="first-name">Technician 1: <span class="required">*</span>
                                                            </label>
                                                            <div class="col-md-6 col-sm-6 col-xs-12">
                                                                <select id="tech1" class="form-control col-md-7 col-xs-12" type="text" name="tech1">
                                                                    <option></option>
                                                                    <option>Barangay Group 1</option>
                                                                    <option>Barangay Group 2</option>
                                                                    <option>Barangay Group 3</option>
                                                                </select>
                                                            </div>
                                                        </div>
                                                        <div class="form-group">
                                                            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="last-name">Technician 2: <span class="required">*</span>
                                                            </label>
                                                            <div class="col-md-6 col-sm-6 col-xs-12">
                                                                <select id="tech2" class="form-control col-md-7 col-xs-12" type="text" name="tech2">
                                                                    <option></option>
                                                                    <option>Barangay Group 1</option>
                                                                    <option>Barangay Group 2</option>
                                                                    <option>Barangay Group 3</option>
                                                                </select>
                                                            </div>
                                                        </div>
                                                        <div class="form-group">
                                                            <label for="middle-name" class="control-label col-md-3 col-sm-3 col-xs-12">Technician 3: <span class="required">*</span>
                                                            </label>
                                                            <div class="col-md-6 col-sm-6 col-xs-12">
                                                                <select id="tech3" class="form-control col-md-7 col-xs-12" type="text" name="tech3">
                                                                    <option></option>
                                                                    <option>Barangay Group 1</option>
                                                                    <option>Barangay Group 2</option>
                                                                    <option>Barangay Group 3</option>
                                                                </select>
                                                            </div>
                                                        </div>
                                                        <div class="ln_solid"></div>
                                                        <div class="form-group">
                                                            <div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
                                                                <button type="submit" class="btn btn-primary">Cancel</button>
                                                                <button type="submit" class="btn btn-success">Submit</button>
                                                            </div>
                                                        </div>

                                                    </form>
                                                </div>
                                            </div>
                                        </div>
                                        <!--//FIRST HALF-->

                                        <!--SECOND HALF-->
                                        <div class="col-md-7 col-sm-7 col-xs-7">
                                            <div class="x_panel">
                                                <div class="x_content">


                                                    <div class="" role="tabpanel" data-example-id="togglable-tabs">
                                                        <ul id="myTab" class="nav nav-tabs bar_tabs" role="tablist">
                                                            <li role="presentation" class="active"><a href="#tab_content1" id="brgy1" role="tab" data-toggle="tab" aria-expanded="true">Barangay Group 1</a>
                                                            </li>
                                                            <li role="presentation" class=""><a href="#tab_content2" role="tab" id="brgy2" data-toggle="tab" aria-expanded="false">Barangay Group 2</a>
                                                            </li>
                                                            <li role="presentation" class=""><a href="#tab_content3" role="tab" id="brgy3" data-toggle="tab" aria-expanded="false">Barangay Group 3</a>
                                                            </li>
                                                        </ul>
                                                        <div id="myTabContent" class="tab-content">
                                                            <div role="tabpanel" class="tab-pane fade active in" id="tab_content1" aria-labelledby="home-tab">
                                                                <!--TABLE FOR BRGYGRP1-->
                                                                <table class="table table-striped table-bordered col-md-12 col-sm-12 col-xs-12">
                                                                    <thead>
                                                                        <tr>
                                                                            <th>Barangay</th>
                                                                            <th>Area</th>
                                                                        </tr>
                                                                    </thead>
                                                                    <tr>
                                                                        <td>Ilang Ilang</td>
                                                                        <th>458 Ha</th>
                                                                    </tr>
                                                                </table>
                                                                <h2>Total # of Farms: </h2>
                                                                <br><br>
                                                                <h2>Total Ha:</h2>
                                                            </div>
                                                            <div role="tabpanel" class="tab-pane fade" id="tab_content2" aria-labelledby="profile-tab">
                                                                <!--TABLE FOR BRGYGRP2-->
                                                                <table class="table table-striped table-bordered col-md-12 col-sm-12 col-xs-12">
                                                                <thead>
                                                                    <tr>
                                                                        <th>Barangay</th>
                                                                        <th>Area</th>
                                                                    </tr>
                                                                </thead>
                                                                    <tr>
                                                                        <td>BMA/Balagtas</td>
                                                                        <td>22.5 Ha</td>
                                                                    </tr>
                                                                    <tr>
                                                                        <td>Banca Banca</td>
                                                                        <td>40 Ha</td>
                                                                    </tr>
                                                                    <tr>
                                                                        <td>Caingin</td>
                                                                        <td>201 Ha</td>
                                                                    </tr>
                                                                    <tr>
                                                                        <td>Capihan</td>
                                                                        <td>95 Ha</td>
                                                                    </tr>
                                                                    <tr>
                                                                        <td>Coral na Bato</td>
                                                                        <td>65 Ha</td>
                                                                    </tr>
                                                                    <tr>
                                                                        <td>Dagat Dagatan</td>
                                                                        <td>76.9 Ha</td>
                                                                    </tr>
                                                                    <tr>
                                                                        <td>Diliman I</td>
                                                                        <td>56 Ha</td>
                                                                    </tr>
                                                                    <tr>
                                                                        <td>Diliman II</td>
                                                                        <td>58.5 Ha</td>
                                                                    </tr>
                                                                    <tr>
                                                                        <td>Libis</td>
                                                                        <td>44 Ha</td>
                                                                    </tr>
                                                                    <tr>
                                                                        <td>Lico</td>
                                                                        <td>9.3 Ha</td>
                                                                    </tr>
                                                                    <tr>
                                                                        <td>Maasim</td>
                                                                        <td>73.5 Ha</td>
                                                                    </tr>
                                                                    <tr>
                                                                        <td>M-Balas</td>
                                                                        <td>20 Ha</td>
                                                                    </tr>
                                                                    <tr>
                                                                        <td>Maguinao</td>
                                                                        <td>26 Ha</td>
                                                                    </tr>
                                                                    <tr>
                                                                        <td>Ilang Ilang</td>
                                                                        <th>458 Ha</th>
                                                                    </tr>
                                                                </table>
                                                                <h2>Total # of Farms: </h2>
                                                                <br><br>
                                                                <h2>Total Ha:</h2>
                                                            </div>
                                                            <div role="tabpanel" class="tab-pane fade" id="tab_content3" aria-labelledby="profile-tab">
                                                                <!--TABLE FOR BRGYGRP3-->
                                                                <table class="table table-striped table-bordered col-md-12 col-sm-12 col-xs-12">
                                                                    <thead>
                                                                        <tr>
                                                                            <th>Barangay</th>
                                                                            <th>Area</th>
                                                                        </tr>
                                                                    </thead>
                                                                    <tr>
                                                                        <td>Ilang Ilang</td>
                                                                        <th>458 Ha</th>
                                                                    </tr>
                                                                </table>
                                                                <h2>Total # of Farms: </h2>
                                                                <br><br>
                                                                <h2>Total Ha:</h2>
                                                            </div>
                                                        </div>
                                                    </div>

                                                </div>
                                            </div>
                                        </div>
                                        <!--//SECOND HALF-->


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
