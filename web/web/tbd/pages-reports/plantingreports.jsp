<%-- 
    Document   : plantingreports
    Created on : Jun 5, 2016, 12:47:31 PM
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
        <link href="../../../vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
        <!-- Font Awesome -->
        <link href="../../../vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet">
        <!-- iCheck -->
        <link href="../../../vendors/iCheck/skins/flat/green.css" rel="stylesheet">
        <!-- bootstrap-progressbar -->
        <link href="../../../vendors/bootstrap-progressbar/css/bootstrap-progressbar-3.3.4.min.css" rel="stylesheet">
        <!-- jVectorMap -->
        <link href="../../css/maps/jquery-jvectormap-2.0.3.css" rel="stylesheet"/>

        <!-- Custom Theme Style -->
        <link href="../../../build/css/custom.min.css" rel="stylesheet">

        <!-- Custom Table CSS-->
        <link href="../../css/table/../" rel="stylesheet">
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
                            <h3>Damage Report</h3>
                        </div>

                        <div class="clearfix">

                        </div>

                        <!--page content container-->
                        <div class="row">
                            <div class="col-md-12 col-lg-12 col-sm-12" role="tabpanel" data-example-id="toggleable-tabs">
                                <!-- tab labels-->
                                <ul id="myTab" class="nav nav-tabs bar_tabs" role="tablist">
                                    <li role="presentation" class="active">
                                        <a href="#tab_content1" id="irrigated-tab" role="tab" data-toggle="tab" aria-expanded="true">Irrigated</a>
                                    </li>
                                    <li role="presentation" class>
                                        <a href="#tab_content2" id="rainfed-tab" role="tab" data-toggle="tab" aria-expanded="false">Rainfed</a>
                                    </li>
                                    <li role="presentation" class>
                                        <a href="#tab_content3" id="total-tab" role="tab" data-toggle="tab" aria-expanded="false">Total</a>
                                    </li>
                                </ul>
                                <!--end: tab labels-->

                                <!--tab contents-->
                                <div id="myTabContent" class="tab-content">
                                    <div role="tabpanel" class="tab-pane fade active in" id="tab_content1" aria-labelledby="irrigated-tab">
                                        <!--irrigated-->
                                        <table class="table table-bordered">
                                            <thead>
                                                <tr>
                                                    <th></th>
                                                    <th style="text-align: center" colspan="21">Irrigated</th>
                                                    <th colspan="2"></th>
                                                </tr>
                                                <tr>
                                                    <th></th>
                                                    <th style="text-align: center" colspan="5">Hybrid</th>
                                                    <th style="text-align: center" colspan="5">Registered Seed</th>
                                                    <th style="text-align: center" colspan="6">Certified Seed</th>
                                                    <th style="text-align: center" colspan="5">Good Seed</th>
                                                    <th colspan="2"></th>
                                                </tr>
                                                <tr>
                                                    <th style="text-align: center; width: 8%">Municipal</th>

                                                    <th style="text-align: center; width: 4%">Rehab</th>
                                                    <th style="text-align: center; width: 4%">Direct Purchase</th>
                                                    <th style="text-align: center; width: 4%">Cluster</th>
                                                    <th style="text-align: center; width: 4%">Others</th>
                                                    <th style="text-align: center; width: 4%">Total</th>

                                                    <th style="text-align: center; width: 4%">CSB</th>
                                                    <th style="text-align: center; width: 4%">SG</th>
                                                    <th style="text-align: center; width: 4%">MTD</th>
                                                    <th style="text-align: center; width: 4%">Others</th>
                                                    <th style="text-align: center; width: 4%">Total</th>

                                                    <th style="text-align: center; width: 4%">Rehab</th>
                                                    <th style="text-align: center; width: 4%">3rd Crop</th>
                                                    <th style="text-align: center; width: 4%">MLGU/ PLGU</th>
                                                    <th style="text-align: center; width: 4%">Direct Purchased</th>
                                                    <th style="text-align: center; width: 4%">Others</th>
                                                    <th style="text-align: center; width: 4%">Total</th>
                                                    <th style="text-align: center; width: 4%">HQS (from CSB)</th>
                                                    <th style="text-align: center; width: 4%">HQS (from untagged)</th>
                                                    <th style="text-align: center; width: 4%">FHSS</th>
                                                    <th style="text-align: center; width: 4%">GSR</th>
                                                    <th style="text-align: center; width: 4%">Total</th>

                                                    <th style="text-align: center; width: 4%">UPLAND</th>
                                                    <th style="text-align: center; width: 4%">GRAND TOTAL</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <tr>
                                                    <td>San Rafael</td>

                                                    <td>200</td>
                                                    <td>200</td>
                                                    <td>200</td>
                                                    <td>200</td>
                                                    <td>200</td>

                                                    <td>200</td>
                                                    <td>200</td>
                                                    <td>200</td>
                                                    <td>200</td>
                                                    <td>200</td>

                                                    <td>200</td>
                                                    <td>200</td>
                                                    <td>200</td>
                                                    <td>200</td>
                                                    <td>200</td>
                                                    <td>200</td>

                                                    <td>200</td>
                                                    <td>200</td>
                                                    <td>200</td>
                                                    <td>200</td>
                                                    <td>200</td>

                                                    <td>200</td>
                                                    <td>200</td>
                                                </tr>
                                            </tbody>
                                        </table>
                                        <!--end: irrigated-->
                                    </div>

                                    <div role="tabpanel" class="tab-pane fade" id="tab_content2" aria-labelledby="rainfed-tab">
                                        <!--rainfed-->
                                        <table class="table table-bordered">
                                            <thead>
                                                <tr>
                                                    <th></th>
                                                    <th style="text-align: center" colspan="21">Rainfed</th>
                                                    <th colspan="2"></th>
                                                </tr>
                                                <tr>
                                                    <th></th>
                                                    <th style="text-align: center" colspan="5">Hybrid</th>
                                                    <th style="text-align: center" colspan="5">Registered Seed</th>
                                                    <th style="text-align: center" colspan="6">Certified Seed</th>
                                                    <th style="text-align: center" colspan="5">Good Seed</th>
                                                    <th colspan="2"></th>
                                                </tr>
                                                <tr>
                                                    <th style="text-align: center; width: 8%">Municipal</th>

                                                    <th style="text-align: center; width: 4%">Rehab</th>
                                                    <th style="text-align: center; width: 4%">Direct Purchase</th>
                                                    <th style="text-align: center; width: 4%">Cluster</th>
                                                    <th style="text-align: center; width: 4%">Others</th>
                                                    <th style="text-align: center; width: 4%">Total</th>

                                                    <th style="text-align: center; width: 4%">CSB</th>
                                                    <th style="text-align: center; width: 4%">SG</th>
                                                    <th style="text-align: center; width: 4%">MTD</th>
                                                    <th style="text-align: center; width: 4%">Others</th>
                                                    <th style="text-align: center; width: 4%">Total</th>

                                                    <th style="text-align: center; width: 4%">Rehab</th>
                                                    <th style="text-align: center; width: 4%">3rd Crop</th>
                                                    <th style="text-align: center; width: 4%">MLGU/ PLGU</th>
                                                    <th style="text-align: center; width: 4%">Direct Purchased</th>
                                                    <th style="text-align: center; width: 4%">Others</th>
                                                    <th style="text-align: center; width: 4%">Total</th>
                                                    <th style="text-align: center; width: 4%">HQS (from CSB)</th>
                                                    <th style="text-align: center; width: 4%">HQS (from untagged)</th>
                                                    <th style="text-align: center; width: 4%">FHSS</th>
                                                    <th style="text-align: center; width: 4%">GSR</th>
                                                    <th style="text-align: center; width: 4%">Total</th>

                                                    <th style="text-align: center; width: 4%">UPLAND</th>
                                                    <th style="text-align: center; width: 4%">GRAND TOTAL</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <tr>
                                                    <td>San Rafael</td>

                                                    <td>200</td>
                                                    <td>200</td>
                                                    <td>200</td>
                                                    <td>200</td>
                                                    <td>200</td>

                                                    <td>200</td>
                                                    <td>200</td>
                                                    <td>200</td>
                                                    <td>200</td>
                                                    <td>200</td>

                                                    <td>200</td>
                                                    <td>200</td>
                                                    <td>200</td>
                                                    <td>200</td>
                                                    <td>200</td>
                                                    <td>200</td>

                                                    <td>200</td>
                                                    <td>200</td>
                                                    <td>200</td>
                                                    <td>200</td>
                                                    <td>200</td>

                                                    <td>200</td>
                                                    <td>300</td>
                                                </tr>
                                            </tbody>
                                        </table>
                                        <!--end: rainfed-->
                                    </div>

                                    <div role="tabpanel" class="tab-pane fade" id="tab_content3" aria-labelledby="total-tab">
                                        <!--total-->
                                        <table class="table table-bordered">
                                            <thead>
                                                <tr>
                                                    <th></th>
                                                    <th style="text-align: center" colspan="21">Total</th>
                                                    <th colspan="2"></th>
                                                </tr>
                                                <tr>
                                                    <th></th>
                                                    <th style="text-align: center" colspan="5">Hybrid</th>
                                                    <th style="text-align: center" colspan="5">Registered Seed</th>
                                                    <th style="text-align: center" colspan="6">Certified Seed</th>
                                                    <th style="text-align: center" colspan="5">Good Seed</th>
                                                    <th colspan="2"></th>
                                                </tr>
                                                <tr>
                                                    <th style="text-align: center; width: 8%">Municipal</th>

                                                    <th style="text-align: center; width: 4%">Rehab</th>
                                                    <th style="text-align: center; width: 4%">Direct Purchase</th>
                                                    <th style="text-align: center; width: 4%">Cluster</th>
                                                    <th style="text-align: center; width: 4%">Others</th>
                                                    <th style="text-align: center; width: 4%">Total</th>

                                                    <th style="text-align: center; width: 4%">CSB</th>
                                                    <th style="text-align: center; width: 4%">SG</th>
                                                    <th style="text-align: center; width: 4%">MTD</th>
                                                    <th style="text-align: center; width: 4%">Others</th>
                                                    <th style="text-align: center; width: 4%">Total</th>

                                                    <th style="text-align: center; width: 4%">Rehab</th>
                                                    <th style="text-align: center; width: 4%">3rd Crop</th>
                                                    <th style="text-align: center; width: 4%">MLGU/ PLGU</th>
                                                    <th style="text-align: center; width: 4%">Direct Purchased</th>
                                                    <th style="text-align: center; width: 4%">Others</th>
                                                    <th style="text-align: center; width: 4%">Total</th>
                                                    <th style="text-align: center; width: 4%">HQS (from CSB)</th>
                                                    <th style="text-align: center; width: 4%">HQS (from untagged)</th>
                                                    <th style="text-align: center; width: 4%">FHSS</th>
                                                    <th style="text-align: center; width: 4%">GSR</th>
                                                    <th style="text-align: center; width: 4%">Total</th>

                                                    <th style="text-align: center; width: 4%">UPLAND</th>
                                                    <th style="text-align: center; width: 4%">GRAND TOTAL</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <tr>
                                                    <td>San Rafael</td>

                                                    <td>200</td>
                                                    <td>200</td>
                                                    <td>200</td>
                                                    <td>200</td>
                                                    <td>200</td>

                                                    <td>200</td>
                                                    <td>200</td>
                                                    <td>200</td>
                                                    <td>200</td>
                                                    <td>200</td>

                                                    <td>200</td>
                                                    <td>200</td>
                                                    <td>200</td>
                                                    <td>200</td>
                                                    <td>200</td>
                                                    <td>200</td>

                                                    <td>200</td>
                                                    <td>200</td>
                                                    <td>200</td>
                                                    <td>200</td>
                                                    <td>200</td>

                                                    <td>200</td>
                                                    <td>400</td>
                                                </tr>
                                            </tbody>
                                        </table>
                                        <!--end: total-->
                                    </div>
                                </div>
                            </div>

                            <div class="col-md-9 col-sm-9 col-xs-12 col-md-offset-5">
                                <button>Submit</button>
                                <button>Approve</button>
                                <button>Reject</button>
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
        <script src="../../../vendors/jquery/dist/jquery.min.js"></script>
        <!-- Bootstrap -->
        <script src="../../../vendors/bootstrap/dist/js/bootstrap.min.js"></script>
        <!-- FastClick -->
        <script src="../../../vendors/fastclick/lib/fastclick.js"></script>
        <!-- NProgress -->
        <script src="../../../vendors/nprogress/nprogress.js"></script>
        <!-- Chart.js -->
        <script src="../../../vendors/Chart.js/dist/Chart.min.js"></script>
        <!-- gauge.js -->
        <script src="../../../vendors/bernii/gauge.js/dist/gauge.min.js"></script>
        <!-- bootstrap-progressbar -->
        <script src="../../../vendors/bootstrap-progressbar/bootstrap-progressbar.min.js"></script>
        <!-- iCheck -->
        <script src="../../../vendors/iCheck/icheck.min.js"></script>
        <!-- Flot plugins -->
        <script src="../../js/flot/jquery.flot.orderBars.js"></script>
        <script src="../../js/flot/date.js"></script>
        <script src="../../js/flot/jquery.flot.spline.js"></script>
        <script src="../../js/flot/curvedLines.js"></script>
        <!-- jVectorMap -->
        <script src="../../js/maps/jquery-jvectormap-2.0.3.min.js"></script>
        <!-- bootstrap-daterangepicker -->
        <script src="../../js/moment/moment.min.js"></script>
        <script src="../../js/datepicker/daterangepicker.js"></script>

        <!-- Custom Theme Scripts -->
        <script src="../../../build/js/custom.min.js"></script>


        <!-- Doughnut Chart 
        <script>
            $(document).ready(function () {
                var options = {
                    legend: false,
                    responsive: false
                };

                new Chart(document.getElementById("canvas1"), {
                    type: 'doughnut',
                    tooltipFillColor: "rgba(51, 51, 51, 0.55)",
                    data: {
                        labels: [
                            "Symbian",
                            "Blackberry",
                            "Other",
                            "Android",
                            "IOS"
                        ],
                        datasets: [{
                                data: [15, 20, 30, 10, 30],
                                backgroundColor: [
                                    "#BDC3C7",
                                    "#9B59B6",
                                    "#E74C3C",
                                    "#26B99A",
                                    "#3498DB"
                                ],
                                hoverBackgroundColor: [
                                    "#CFD4D8",
                                    "#B370CF",
                                    "#E95E4F",
                                    "#36CAAB",
                                    "#49A9EA"
                                ]
                            }]
                    },
                    options: options
                });
            });
        </script>
        <!-- /Doughnut Chart -->

        <!-- gauge.js 
        <script>
            var opts = {
                lines: 12,
                angle: 0,
                lineWidth: 0.4,
                pointer: {
                    length: 0.75,
                    strokeWidth: 0.042,
                    color: '#1D212A'
                },
                limitMax: 'false',
                colorStart: '#1ABC9C',
                colorStop: '#1ABC9C',
                strokeColor: '#F0F3F3',
                generateGradient: true
            };
            var target = document.getElementById('foo'),
                    gauge = new Gauge(target).setOptions(opts);

            gauge.maxValue = 6000;
            gauge.animationSpeed = 32;
            gauge.set(3200);
            gauge.setTextField(document.getElementById("gauge-text"));
        </script>
        <!-- /gauge.js -->
    </body>
</html>

