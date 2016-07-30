<%-- 
    Document   : farmerinformation
    Created on : Jun 1, 2016, 7:59:33 PM
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

        <title>B.I.G.A.S. System | Farmer Information</title>

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
                            <h3>Farmer Information</h3>
                        </div>

                        <div class="clearfix">

                        </div>

                        <!--page content container-->
                        <div class="row">
                            <!--page content container-->
                            <div class="row">
                                <div class="col-md-12">
                                    <div class="x_panel">
                                        <div class="x_title">
                                            <h2>Farmers</h2>

                                            <div class="clearfix">

                                            </div>
                                        </div>

                                        <!--farmer information-->
                                        <div class="x_content">
                                            <div class="row">
                                                <div class="col-md-6">
                                                    <form class="form-horizontal form-label-left">
                                                        <!--farmer details-->
                                                        <div class="form-group">
                                                            <label class="control-label col-md-3">
                                                                Last Name
                                                            </label>
                                                            <div class="col-md-9">
                                                                <input type="text" class="form-control">
                                                            </div>
                                                        </div>

                                                        <div class="form-group">
                                                            <label class="control-label col-md-3">
                                                                First Name
                                                            </label>
                                                            <div class="col-md-9">
                                                                <input type="text" class="form-control">
                                                            </div>
                                                        </div>

                                                        <div class="form-group">
                                                            <label class="control-label col-md-3">
                                                                Age
                                                            </label>
                                                            <div class="col-md-9">
                                                                <input type="number" class="form-control">
                                                            </div>
                                                        </div>

                                                        <div class="form-group">
                                                            <label class="control-label col-md-3">
                                                                Gender
                                                            </label>
                                                            <div class="col-md-9">
                                                                <div class="col-md-6 col-sm-6 col-xs-12">
                                                                    <div id="gender" class="btn-group" data-toggle="buttons">
                                                                        <label class="btn btn-default" data-toggle-class="btn-primary" data-toggle-passive-class="btn-default">
                                                                            <input type="radio" name="gender" value="male"> &nbsp; Male &nbsp;
                                                                        </label>
                                                                        <label class="btn btn-primary" data-toggle-class="btn-primary" data-toggle-passive-class="btn-default">
                                                                            <input type="radio" name="gender" value="female"> Female
                                                                        </label>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                        
                                                        
                                                        <!--end: farmer details-->
                                                    </form>
                                                </div>
                                            </div>
                                        </div>
                                        <!--end: farmer information-->
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
            <!-- Chart.js -->
            <script src="../../vendors/Chart.js/dist/Chart.min.js"></script>
            <!-- gauge.js -->
            <script src="../../vendors/bernii/gauge.js/dist/gauge.min.js"></script>
            <!-- bootstrap-progressbar -->
            <script src="../../vendors/bootstrap-progressbar/bootstrap-progressbar.min.js"></script>
            <!-- iCheck -->
            <script src="../../vendors/iCheck/icheck.min.js"></script>
            <!-- Skycons -->
            <script src="../../vendors/skycons/skycons.js"></script>
            <!-- Flot -->
            <script src="../../vendors/Flot/jquery.flot.js"></script>
            <script src="../../vendors/Flot/jquery.flot.pie.js"></script>
            <script src="../../vendors/Flot/jquery.flot.time.js"></script>
            <script src="../../vendors/Flot/jquery.flot.stack.js"></script>
            <script src="../../vendors/Flot/jquery.flot.resize.js"></script>
            <!-- Flot plugins -->
            <script src="../js/flot/jquery.flot.orderBars.js"></script>
            <script src="../js/flot/date.js"></script>
            <script src="../js/flot/jquery.flot.spline.js"></script>
            <script src="../js/flot/curvedLines.js"></script>
            <!-- jVectorMap -->
            <script src="../js/maps/jquery-jvectormap-2.0.3.min.js"></script>
            <!-- bootstrap-daterangepicker -->
            <script src="../js/moment/moment.min.js"></script>
            <script src="../js/datepicker/daterangepicker.js"></script>

            <!-- Custom Theme Scripts -->
            <script src="../../build/js/custom.min.js"></script>


    </body>
</html>

