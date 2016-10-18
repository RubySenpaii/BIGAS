<%-- 
    Document   : farmerlist
    Created on : Jun 1, 2016, 7:04:06 PM
    Author     : RubySenpaii
--%>

<%@page import="objects.GenericObject"%>
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

        <title>B.I.G.A.S. System | Farmers List</title>

        <!-- Bootstrap -->
        <link href="/BIGAS/vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
        <!-- Font Awesome -->
        <link href="/BIGAS/vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet">
        <!-- iCheck -->
        <link href="/BIGAS/vendors/iCheck/skins/flat/green.css" rel="stylesheet">
        <!-- Datatables -->
        <link href="/BIGAS/vendors/datatables.net-bs/css/dataTables.bootstrap.min.css" rel="stylesheet">
        <link href="/BIGAS/vendors/datatables.net-buttons-bs/css/buttons.bootstrap.min.css" rel="stylesheet">

        <!-- Custom Theme Style -->
        <link href="/BIGAS/build/css/custom.min.css" rel="stylesheet">
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
                            <h3>Farmer List</h3>
                        </div>

                        <div class="clearfix">

                        </div>
                        <!--page content container-->
                        <div class="row">
                            <div class="col-md-12">
                                <div class="x_panel">
                                    <div class="x_title">
                                        <h2>Farmers</h2>

                                        <div class="clearfix">

                                        </div>
                                    </div>

                                    <div class="x_content">
                                        <div class="row">
                                            <table id="datatable-buttons" class="table table-bordered">
                                                <thead>
                                                    <tr>
                                                        <th style="width: 5%">FarmerID</th>
                                                        <th style="width: 20%">Farmer Name</th>
                                                        <th style="width: 15%">Farm Name</th>
                                                        <th style="width: 15%">Muncipality</th>
                                                        <th style="width: 15%">Barangay</th>
                                                        <th style="width: 10%">Area</th>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                    <%
                                                        ArrayList<GenericObject> farmers = (ArrayList<GenericObject>) session.getAttribute("farmers");
                                                        for (int a = 0; a < farmers.size(); a++) {
                                                    %>
                                                    <tr>
                                                        <td><a href="farmerinformation.jsp"><%=farmers.get(a).getAttribute1()%></a></td>
                                                        <td><%=farmers.get(a).getAttribute2()%></td>
                                                        <td><%=farmers.get(a).getAttribute3()%></td>
                                                        <td><%=farmers.get(a).getAttribute4()%></td>
                                                        <td><%=farmers.get(a).getAttribute5()%></td>
                                                        <td><%=farmers.get(a).getAttribute6()%></td>
                                                    </tr>
                                                    <%
                                                        }
                                                    %>

                                                </tbody>
                                            </table>
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

        <!-- jQuery -->
        <script src="/BIGAS/vendors/jquery/dist/jquery.min.js"></script>
        <!-- Bootstrap -->
        <script src="/BIGAS/vendors/bootstrap/dist/js/bootstrap.min.js"></script>
        <!-- FastClick -->
        <script src="/BIGAS/vendors/fastclick/lib/fastclick.js"></script>
        <!-- NProgress -->
        <script src="/BIGAS/vendors/nprogress/nprogress.js"></script>

        <!-- Datatables -->
        <script src="/BIGAS/vendors/datatables.net/js/jquery.dataTables.min.js"></script>
        <script src="/BIGAS/vendors/datatables.net-bs/js/dataTables.bootstrap.min.js"></script>
        <script src="/BIGAS/vendors/datatables.net-buttons/js/dataTables.buttons.min.js"></script>
        <script src="/BIGAS/vendors/datatables.net-buttons-bs/js/buttons.bootstrap.min.js"></script>
        <script src="/BIGAS/vendors/datatables.net-buttons/js/buttons.flash.min.js"></script>
        <script src="/BIGAS/vendors/datatables.net-buttons/js/buttons.html5.min.js"></script>
        <script src="/BIGAS/vendors/datatables.net-buttons/js/buttons.print.min.js"></script>
        <script src="/BIGAS/vendors/datatables.net-fixedheader/js/dataTables.fixedHeader.min.js"></script>

        <!-- Custom Theme Scripts -->
        <script src="/BIGAS/build/js/custom.min.js"></script>


        <!-- Datatables -->
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

