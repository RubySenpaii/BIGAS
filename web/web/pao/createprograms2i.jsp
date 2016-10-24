<%-- 
    Document   : createprograms2r
    Created on : Oct 22, 2016, 6:20:33 PM
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

        <!-- Select2 -->
        <link href="../vendors/select2/dist/css/select2.min.css" rel="stylesheet">

        <!-- Custom Theme Style -->
        <link href="../../build/css/custom.min.css" rel="stylesheet">

        <!-- Breadcrumbs -->
        <link href="../css/breadcrumbs.css" rel="stylesheet"/>
        <link href="../css/additionalcss.css" rel="stylesheet"/>
        <!-- jQuery -->
        <script src="../../vendors/jquery/dist/jquery.min.js"></script>
        <!--highchart.js -->
        <script src="../js/highchart/highcharts.js"></script>
        <script src="../js/highchart/modules/exporting.js"></script>

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
                                    <h2>Step 2: Create Intervention Plan</h2>
                                    <div class="clearfix"></div>
                                </div>
                                <div class="x_content">
                                    <ul class="breadcrumb">
                                        <li><a href="createprograms1.jsp">Program Type</a></li>
                                        <li>Create Intervention Plan</li>
                                    </ul>

                                    <div class="row">
                                        <form id="demo-form2" data-parsley-validate class="form-horizontal form-label-left">
                                            <div class="form-group">
                                                <label class="control-label col-md-3 col-sm-3 col-xs-12" for="rehab-name">Intervention Name</label>
                                                <div class="col-md-6 col-sm-6 col-xs-12">
                                                    <input type="text" id="intervention-name" required="required" class="form-control col-md-7 col-xs-12">
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="control-label col-md-3 col-sm-3 col-xs-12" for="description">Description</label>
                                                <div class="col-md-6 col-sm-6 col-xs-12">
                                                    <textarea id="description" required="required" class="form-control col-md-7 col-xs-12"></textarea>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="control-label col-md-3 col-sm-3 col-xs-12" for="purpose">Purpose</label>
                                                <div class="col-md-6 col-sm-6 col-xs-12">
                                                    <textarea id="purpose" required="required" class="form-control col-md-7 col-xs-12"></textarea>
                                                </div>
                                            </div>
                                            <br/>
                                            <div class="form-group">
                                                <table class="table table-bordered">
                                                    <thead>
                                                        <tr>
                                                            <th style="width: 5%">Step No</th>
                                                            <th>Procedure</th>
                                                        </tr>
                                                    </thead>
                                                </table>
                                            </div>
                                        </form>
                                    </div>
                                    <br/><br/>
                                    <div>
                                        <div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-5">
                                            <button type="submit" class="btn btn-lg btn-primary">Cancel</button>
                                            <button type="submit" class="btn btn-lg btn-success">Next</button>
                                            <a href="createprograms3i.jsp">provision</a>
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
        <script src="../../vendors/bootstrap/dist/js/bootstrap.min.js"></script>
        <!-- FastClick -->
        <script src="../../vendors/fastclick/lib/fastclick.js"></script>
        <!-- NProgress -->
        <script src="../../vendors/nprogress/nprogress.js"></script>
        <!-- gauge.js -->
        <script src="../../vendors/bernii/gauge.js/dist/gauge.min.js"></script>
        <!-- bootstrap-progressbar -->
        <script src="../../vendors/bootstrap-progressbar/bootstrap-progressbar.min.js"></script>

        <!-- Custom Theme Scripts -->
        <script src="../../build/js/custom.min.js"></script>
    </body>
</html>
