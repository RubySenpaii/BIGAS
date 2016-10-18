<%-- 
    Document   : technician
    Created on : Jul 9, 2016, 11:32:15 AM
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
                            <h3>Technician Task Assignment</h3>
                        </div>

                        <div class="clearfix">

                        </div>

                        <!--page content container-->
                        <div class="row">
                            <div class="x_panel">
                                <div class="x_title">
                                    <form id="demo-form2" data-parsley-validate class="form-horizontal form-label-left">
                                        <div class="form-group">
                                            <label class="control-label col-md-4 col-sm-4 col-xs-12">Technican</label>
                                            <div class="col-md-3 col-sm-3 col-xs-12">
                                                <select class="form-control col-md-7 col-xs-12">
                                                </select>
                                            </div>
                                        </div>
                                    </form>

                                    <div class="clearfix"></div>
                                </div>
                                <div class="x_content">
                                    <table class="table table-bordered">
                                        <thead>
                                            <tr>
                                                <th></th>
                                                <th>Farm Name</th>
                                                <th>Farmer</th>
                                                <th>Location</th>
                                                <th>Area</th>
                                                <th style="width:1%"></th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <tr>
                                                <td>001</td>
                                                <td>ABC Farm</td>
                                                <td>John Doe</td>
                                                <td>12 St. Lopez Avenue, San Rafael, Bulacan</td>
                                                <td>300 ha</td>
                                                <td><input type="checkbox"></td>
                                            </tr>
                                        </tbody>
                                    </table>
                                    
                                    <div class="col-md-9 col-sm-9 col-xs-12 col-md-offset-5">
                                        <button>Submit</button>
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
