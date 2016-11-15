<%-- 
    Document   : createprograms3r
    Created on : Oct 24, 2016, 5:45:05 PM
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
        <link href="/BIGAS/vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
        <!-- Font Awesome -->
        <link href="/BIGAS/vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet">
        <!-- iCheck -->
        <link href="/BIGAS/vendors/iCheck/skins/flat/green.css" rel="stylesheet">
        <!-- bootstrap-progressbar -->
        <link href="/BIGAS/vendors/bootstrap-progressbar/css/bootstrap-progressbar-3.3.4.min.css" rel="stylesheet">
        <!-- jVectorMap -->
        <link href="/BIGAS/web/css/maps/jquery-jvectormap-2.0.3.css" rel="stylesheet"/>

        <!-- Select2 -->
        <link href="/BIGAS/web/vendors/select2/dist/css/select2.min.css" rel="stylesheet">

        <!-- Custom Theme Style -->
        <link href="/BIGAS/build/css/custom.min.css" rel="stylesheet">

        <!-- Breadcrumbs -->
        <link href="/BIGAS/web/css/breadcrumbs.css" rel="stylesheet"/>
        <link href="/BIGAS/web/css/additionalcss.css" rel="stylesheet"/>
        <!-- jQuery -->
        <script src="/BIGAS/vendors/jquery/dist/jquery.min.js"></script>
        <!--highchart.js -->
        <script src="/BIGAS/web/js/highchart/highcharts.js"></script>
        <script src="/BIGAS/web/js/highchart/modules/exporting.js"></script>

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
                        <!--problem list-->
                        <div class="col-md-12 col-sm-12 col-xs-12">
                            <div class="x_panel">
                                <div class="x_title">
                                    <h2>Step 3: Review Provision Details</h2>
                                    <div class="clearfix"></div>
                                </div>
                                <div class="x_content">
                                    <ul class="breadcrumb">
                                        <li><a href="createprograms1.jsp">Program Type</a></li>
                                        <li><a href="createprograms2p.jsp">Create Provision</a></li>
                                        <li>Review Details</li>
                                    </ul>

                                    <div class="row">
                                        <div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
                                            <h4>Review Rehabilitation Details</h4>
                                            <table class="table">
                                                <tbody>
                                                    <tr>
                                                        <th>Rehabilitation Name</th>
                                                        <td></td>
                                                    </tr>
                                                    <tr>
                                                        <th>Description</th>
                                                        <td></td>
                                                    </tr>
                                                    <tr>
                                                        <th>Municipal</th>
                                                        <td></td>
                                                    </tr>
                                                    <tr>
                                                        <th>Purpose</th>
                                                        <td></td>
                                                    </tr>
                                                    <tr>
                                                        <th>Seeds Variety (with amount)</th>
                                                        <td></td>
                                                    </tr>
                                                    <tr>
                                                        <th>Fertilizer (with amount)</th>
                                                        <td></td>
                                                    </tr>
                                                    <tr>
                                                        <td colspan="2">
                                                            <table class="table bordered">
                                                                <thead>
                                                                    <tr>
                                                                        <th>Step No</th>
                                                                        <th>Procedure</th>
                                                                    </tr>
                                                                </thead>
                                                                <tbody>
                                                                    
                                                                </tbody>
                                                            </table>
                                                        </td>
                                                    </tr>
                                                </tbody>
                                            </table>
                                        </div>
                                    </div>
                                    <br/><br/>
                                    <div>
                                        <div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-5">
                                            <button type="submit" class="btn btn-lg btn-primary">Back</button>
                                            <button type="submit" class="btn btn-lg btn-success">Finish</button>
                                            <a href="">Finish</a>
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
        <!-- gauge.js -->
        <script src="/BIGAS/vendors/bernii/gauge.js/dist/gauge.min.js"></script>
        <!-- bootstrap-progressbar -->
        <script src="/BIGAS/vendors/bootstrap-progressbar/bootstrap-progressbar.min.js"></script>

        <!-- Custom Theme Scripts -->
        <script src="/BIGAS/build/js/custom.min.js"></script>
    </body>
</html>
