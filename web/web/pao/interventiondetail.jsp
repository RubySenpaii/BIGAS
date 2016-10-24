<%-- 
    Document   : interventiondetail
    Created on : Oct 17, 2016, 9:59:50 PM
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
                                    <h2>Intervention Detail</h2>
                                    <div class="clearfix"></div>
                                </div>
                                <div class="x_content">
                                    <div class="row">
                                        <div class="col-md-8 col-sm-8 col-xs-12">
                                            <h4>Procedure</h4>

                                            <table class="table table-bordered">
                                                <thead>
                                                    <tr>
                                                        <th style="width: 30px">#</th>
                                                        <th style="width: 85%">Steps</th>
                                                        <th style="width: 15%">Status</th>
                                                    </tr>
                                                </thead>
                                            </table>
                                        </div>

                                        <div class="col-md-4 col-sm-4 col-xs-12">
                                            <h4>Overview</h4>

                                            <div class="col-md-6">
                                                <div class="project_detail">
                                                    <br/>
                                                    <p class="title">Problem</p>
                                                    <p>Low production</p>
                                                    <p class="title">Date Reported</p>
                                                    <p>October 14, 2016</p>
                                                </div><br/>
                                            </div>
                                            
                                            <div class="col-md-6">
                                                <div class="project_detail">
                                                    <br/>
                                                    <p class="title">Handled By</p>
                                                    <p>John Tiberan</p>
                                                    <p class="title">Start Date</p>
                                                    <p>October 19, 2016</p>
                                                </div><br/>
                                            </div>

                                            <table class="table table-bordered">
                                                <thead>
                                                    <tr>
                                                        <th style="width: 40%">Barangay</th>
                                                        <th style="width: 60%">No of Farmers</th>
                                                    </tr>
                                                </thead>
                                            </table>
                                        </div>
                                    </div>
                                    
                                    <div class="row">
                                        <div class="col-md-12 col-sm-12 col-xs-12">
                                            <div class="" role="tabpanel" data-example-id="toggable-tabs">
                                                <ul id="interventionTabs" class="nav nav-tabs bar_tabs" role="tablist">
                                                    <li role="presentation" class="active">
                                                        <a href="#accomplishmentReports" id="home-tab" role="tab" data-toggle="tab" aria-expanded="true">Accomplishment Reports</a>
                                                    </li>
                                                    <li role="presentation">
                                                        <a href="#feedback" role="tab" id="profile-tab" data-toggle="tab" aria-expanded="false">Feedbacks/Suggestions</a>
                                                    </li>
                                                </ul>
                                                
                                                <div id="myTabContent" class="tab-content">
                                                    <div role="tabpanel" class="tab-pane fade active in" id="accomplishmentReports" aria-labelledby="home-tab">
                                                        <table class="table table-bordered">
                                                            <thead>
                                                                <tr>
                                                                    <th>Procedure No</th>
                                                                    <th>Date</th>
                                                                    <th>Farmer Name</th>
                                                                    <th>Comments</th>
                                                                </tr>
                                                            </thead>
                                                        </table>
                                                    </div>
                                                    
                                                    <div role="tabpanel" class="tab-pane fade" id="feedback" aria-labelledby="profile-tab">
                                                        <table class="table table-bordered">
                                                            <thead>
                                                                <tr>
                                                                    <th>Feedback Type</th>
                                                                    <th>Rating</th>
                                                                    <th>Date Filled</th>
                                                                    <th>Comments</th>
                                                                </tr>
                                                            </thead>
                                                        </table>
                                                    </div>
                                                </div>
                                            </div>
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
