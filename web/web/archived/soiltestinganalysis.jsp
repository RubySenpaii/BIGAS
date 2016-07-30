<%-- 
    Document   : soiltestinganalysis
    Created on : Jun 15, 2016, 7:13:32 PM
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
                            <h3>Soil Testing and Analysis</h3>
                        </div>

                        <div class="clearfix">

                        </div>

                        <!--page content container-->
                        <div class="row">
                            <div class="col-md-12">
                                <div class="x_panel">
                                    <!--project information-->
                                    <div class="col-md-9 col-sm-9 col-xs-12">
                                        <table class="table table-bordered">
                                            <thead>
                                                <tr>
                                                    <th>Farmer</th>
                                                    <th>Location</th>
                                                    <th>Land Area</th>
                                                    <th>Soil Fertility</th>
                                                </tr>
                                            </thead>
                                        </table>
                                    </div>
                                    <!--end: project information-->

                                    <!--project details-->
                                    <div class="col-md-3 col-sm-3 col-xs-12">
                                        <section class="panel">
                                            <div class="x_title">
                                                <h2>Description</h2>
                                                <div class="clearfix"></div>
                                            </div>

                                            <div class="panel-body">
                                                <p>This project...</p>
                                            </div>
                                        </section>
                                    </div>
                                    <!--end: project details-->
                                </div>
                                <!--end: page content container-->
                            </div>
                        </div>
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

        <!--Custom Theme Scripts-->
        <script src="../../build/js/custom.min.js"></script>
    </body>
</html>