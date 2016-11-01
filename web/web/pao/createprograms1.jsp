<%-- 
    Document   : createprogram
    Created on : Oct 18, 2016, 6:07:37 PM
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
                                    <h2>Step 1: Choose Program Type</h2>
                                    <div class="clearfix"></div>
                                </div>
                                <div class="x_content">
                                    <ul class="breadcrumb">
                                        <li>Program Type</li>
                                    </ul>

                                    <div class="row">
                                        <div class="col-md-8 col-sm-8 col-xs-12 col-md-offset-3">
                                            <h1>Choose Program Type</h1>
                                            <div class="col-md-9 col-sm-9 col-xs-12 col-md-offset-1">
                                                <div class="container">
                                                    <ul class="customRadio">
                                                        <li>
                                                            <input type="radio" id="f-option" name="selector">
                                                            <label for="f-option">Provision - Create a program to provide seeds or fertilizer as an incentives to farmers.</label>

                                                            <div class="check"></div>
                                                        </li>
                                                        <li>
                                                            <input type="radio" id="s-option" name="selector">
                                                            <label for="s-option">Intervention - Provide program to improve the production of farmers.</label>

                                                            <div class="check"><div class="inside"></div></div>
                                                        </li>
                                                        <li>
                                                            <input type="radio" id="t-option" name="selector">
                                                            <label for="t-option">Rehabilitation - Provide assistance to farmers who suffered from damages caused by pest and diseases or calamities.</label>

                                                            <div class="check"><div class="inside"></div></div>
                                                        </li>
                                                    </ul>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <br/><br/>
                                    <div>
                                        <div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-5">
                                            <button type="submit" class="btn btn-lg btn-primary">Cancel</button>
                                            <button type="submit" class="btn btn-lg btn-success">Next</button>
                                            <a href="createprograms2p.jsp">provision</a>
                                            <a href="createprograms2r.jsp">rehab</a>
                                            <a href="createprograms2i.jsp">rehab</a>
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
