<%-- 
    Document   : targetproduction
    Created on : Jul 9, 2016, 11:33:29 AM
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
                            <h3>Production Target</h3>
                        </div>

                        <div class="clearfix">

                        </div>

                        <!--page content container-->
                        <div class="row">
                            <div class="x_panel">
                                <div class="x_title">
                                    <form id="demo-form2" data-parsley-validate class="form-horizontal form-label-left">
                                        <div class="form-group">
                                            <label class="control-label col-md-4 col-sm-4 col-xs-12">Target Production</label>
                                            <div class="col-md-3 col-sm-3 col-xs-12">
                                                <input type="number" required="required" class="form-control col-md-7 col-xs-12">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="control-label col-md-4 col-sm-4 col-xs-12">Suggested Target</label>
                                            <div class="col-md-3 col-sm-3 col-xs-12">
                                                <input type="number" required="required" disabled class="form-control col-md-7 col-xs-12">
                                            </div>
                                        </div>
                                    </form>

                                    <div class="clearfix"></div>
                                </div>
                                <div class="x_content">
                                    <table class="table table-bordered">
                                        <thead>
                                            <tr>
                                                <th>Year</th>
                                                <th colspan="3">Land Area</th>
                                                <th colspan="3">Production</th>
                                                <th colspan="3">Damages</th>
                                                <th>Target Production</th>
                                            </tr>
                                            <tr>
                                                <th></th>
                                                <th>Wet Season</th>
                                                <th>Dry Season</th>
                                                <th>Total</th>
                                                <th>Wet Season</th>
                                                <th>Dry Season</th>
                                                <th>Total</th>
                                                <th>Wet Season</th>
                                                <th>Dry Season</th>
                                                <th>Total</th>
                                                <th></th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <tr>
                                                <td>2010-2011</td>
                                                <td>300 ha</td>
                                                <td>200 ha</td>
                                                <td>500 ha</td>
                                                <td>320 MT</td>
                                                <td>400 MT</td>
                                                <td>700 MT</td>
                                                <td>10 ha</td>
                                                <td>5 ha</td>
                                                <td>15 ha</td>
                                                <td>900 MT</td>
                                            </tr>
                                        </tbody>
                                    </table>
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
        <script src="../../vendors/jquery/dist/jquery.min.js"></script>
        <!-- Bootstrap -->
        <script src="../../vendors/bootstrap/dist/js/bootstrap.min.js"></script>
        <!-- FastClick -->
        <script src="../../vendors/fastclick/lib/fastclick.js"></script>
        <!-- NProgress -->
        <script src="../../vendors/nprogress/nprogress.js"></script>
        <!-- iCheck -->
        <script src="../../vendors/iCheck/icheck.min.js"></script>
        <!-- Skycons -->
        <script src="../../vendors/skycons/skycons.js"></script>
        

        <!-- Custom Theme Scripts -->
        <script src="../../build/js/custom.min.js"></script>
    </body>
</html>
