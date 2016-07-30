<%-- 
    Document   : createintervention
    Created on : Jul 10, 2016, 1:49:31 PM
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
                            <h3>Create Intervention</h3>
                        </div>

                        <div class="clearfix">

                        </div>

                        <!--page content container-->
                        <div class="row">
                            <div class="x_panel">
                                <div class="x_content">
                                    <div id="wizard" class="form_wizard wizard_horizontal">
                                        <ul class="wizard_steps">
                                            <li>
                                                <a href="#step-1">
                                                    <span class="step_no">1</span>
                                                    <span class="step_descr">
                                                        Step 1<br />
                                                        <small>Step 1 Create Program</small>
                                                    </span>
                                                </a>
                                            </li>
                                            <li>
                                                <a href="#step-2">
                                                    <span class="step_no">2</span>
                                                    <span class="step_descr">
                                                        Step 2<br />
                                                        <small>Step 2 Provide Program Description</small>
                                                    </span>
                                                </a>
                                            </li>
                                        </ul>

                                        <!--step 1-->
                                        <div id="step-1">
                                            <form class="form-horizontal form-label-left" id="form-shower">
                                                <div class="form-group">
                                                    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="type">Program Type <span class="required">*</span>
                                                    </label>
                                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                                        <select id="type" required="required" class="form-control col-md-6 col-xs-12">
                                                            <option value="" selected="selected"></option>
                                                            <option value="intervention">Intervention</option>
                                                            <option value="rehabilitation">Rehabilitation</option>
                                                            <option value="provision">Provision</option>
                                                        </select>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="type">Program Name <span class="required">*</span>
                                                    </label>
                                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                                        <select id="program-name" required="required" class="form-control col-md-6 col-xs-12">
                                                            <option value="" selected="selected"></option>
                                                            <option>Program 1</option>
                                                            <option>Program 2</option>
                                                            <option>Program 3</option>
                                                        </select>

                                                    </div>
                                                    <button type="button" class="btn btn-primary" data-toggle="modal" data-target=".bs-example-modal-sm">+</button>

                                                    <div class="modal fade bs-example-modal-sm" tabindex="-1" role="dialog" aria-hidden="true">
                                                        <div class="modal-dialog modal-sm">
                                                            <div class="modal-content">

                                                                <div class="modal-header">
                                                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span>
                                                                    </button>
                                                                    <h4 class="modal-title" id="myModalLabel2">Create New Program</h4>
                                                                </div>
                                                                <div class="modal-body">
                                                                    <div class="form-group">
                                                                        <label class="control-label">Program Name: </label>
                                                                        <input type="text" class="form-control">
                                                                    </div>
                                                                    <div class="form-group">
                                                                        <label class="control-label">Program Description: </label>
                                                                        <textarea class="form-control"></textarea>
                                                                    </div>
                                                                </div>
                                                                <div class="modal-footer">
                                                                    <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
                                                                    <button type="button" class="btn btn-primary">Save</button>
                                                                </div>

                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </form>
                                        </div>
                                        <!--end: step 1-->

                                        <!--step 2-->
                                        <div id="step-2">
                                            <form name="intervention" id="intervention" style="display:none" class="form-horizontal form-label-left">
                                                <!---- THIS IS INTERVENTION---->
                                                <div class="form-group">
                                                    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="municipality">Municipality <span class="required">*</span>
                                                    </label>
                                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                                        <select id="municipality" required="required" class="form-control col-md-7 col-xs-12">
                                                            <option></option>
                                                        </select>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="handled-by">Handled By <span class="required">*</span>
                                                    </label>
                                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                                        <select id="handled-by" required="required" class="form-control col-md-7 col-xs-12">
                                                            <option></option>
                                                        </select>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="control-label col-md-3 col-sm-3 col-xs-12">Start Date <span class="required">*</span>
                                                    </label>
                                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                                        <input id="startDate" class="date-picker form-control col-md-7 col-xs-12" required="required" type="text">
                                                    </div>
                                                </div>
                                            </form>

                                            <form name="rehabilitation" id="rehabilitation" style="display:none">
                                                <!---- THIS IS REHABILITATION---->
                                                <div class="form-horizontal form-label-left">
                                                    <div class="form-group">
                                                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="municipality">Municipality <span class="required">*</span>
                                                        </label>
                                                        <div class="col-md-6 col-sm-6 col-xs-12">
                                                            <select id="municipality" required="required" class="form-control col-md-7 col-xs-12">
                                                                <option></option>
                                                            </select>
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="handled-by">Handled By <span class="required">*</span>
                                                        </label>
                                                        <div class="col-md-6 col-sm-6 col-xs-12">
                                                            <select id="handled-by" required="required" class="form-control col-md-7 col-xs-12">
                                                                <option></option>
                                                            </select>
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <label class="control-label col-md-3 col-sm-3 col-xs-12">Start Date <span class="required">*</span>
                                                        </label>
                                                        <div class="col-md-6 col-sm-6 col-xs-12">
                                                            <input id="startDate" class="date-picker form-control col-md-7 col-xs-12" required="required" type="text">
                                                        </div>
                                                    </div>
                                                </div>
                                                <br>
                                                <table class="table table-bordered">
                                                    <thead>
                                                        <tr>
                                                            <th>Item Type</th>
                                                            <th>Item Provided</th>
                                                            <th>Item Quantity</th>
                                                        </tr>
                                                    </thead>
                                                    <tbody>
                                                        <tr>
                                                            <td>
                                                                <select>
                                                                    <option></option>
                                                                    <option>Seed</option>
                                                                    <option>Fertilizer</option>
                                                                </select>
                                                            </td>
                                                            <td><input type="text"></td>
                                                            <td><input type="number"></td>
                                                        </tr>
                                                    </tbody>
                                                    <tfoot>
                                                        <tr>
                                                            <td colspan="3"><button style="width: 100%">Add Row</button></td>
                                                        </tr>
                                                    </tfoot>
                                                </table>
                                            </form>

                                            <form name="provision" id="provision" style="display:none">
                                                <!---- THIS IS PROVISION---->
                                                <div class="form-horizontal form-label-left">
                                                    <div class="form-group">
                                                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="municipality">Municipality <span class="required">*</span>
                                                        </label>
                                                        <div class="col-md-6 col-sm-6 col-xs-12">
                                                            <select id="municipality" required="required" class="form-control col-md-7 col-xs-12">
                                                                <option></option>
                                                            </select>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="form-horizontal form-label-left">
                                                    <div class="form-group">
                                                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="location">Location <span class="required">*</span>
                                                        </label>
                                                        <div class="col-md-6 col-sm-6 col-xs-12">
                                                            <input id="location" required="required" class="form-control col-md-7 col-xs-12">
                                                        </div>
                                                    </div>
                                                </div>
                                                <br>
                                                <table class="table table-bordered">
                                                    <thead>
                                                        <tr>
                                                            <th>Item Type</th>
                                                            <th>Item Provided</th>
                                                            <th>Item Quantity</th>
                                                        </tr>
                                                    </thead>
                                                    <tbody>
                                                        <tr>
                                                            <td>
                                                                <select>
                                                                    <option></option>
                                                                    <option>Seed</option>
                                                                    <option>Fertilizer</option>
                                                                </select>
                                                            </td>
                                                            <td><input type="text"></td>
                                                            <td><input type="number"></td>
                                                        </tr>
                                                    </tbody>
                                                    <tfoot>
                                                        <tr>
                                                            <td colspan="3"><button style="width: 100%">Add Row</button></td>
                                                        </tr>
                                                    </tfoot>
                                                </table>
                                            </form>
                                        </div>
                                        <!--end: step 2-->
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
        <!-- jQuery Smart Wizard -->
        <script src="../../vendors/jQuery-Smart-Wizard/js/jquery.smartWizard.js"></script>
        <!-- bootstrap-daterangepicker -->
        <script src="../js/moment/moment.min.js"></script>
        <script src="../js/datepicker/daterangepicker.js"></script>


        <!-- Custom Theme Scripts -->
        <script src="../../build/js/custom.min.js"></script>

        <!-- jQuery Smart Wizard -->
        <script>
            $(document).ready(function () {
                $('#wizard').smartWizard();

                $('#wizard_verticle').smartWizard({
                    transitionEffect: 'slide'
                });

                $('.buttonNext').addClass('btn btn-success');
                $('.buttonPrevious').addClass('btn btn-primary');
                $('.buttonFinish').addClass('btn btn-default');

                $('#startDate').daterangepicker({
                    singleDatePicker: true,
                    calender_style: "picker_4"
                }, function (start, end, label) {
                    console.log(start.toISOString(), end.toISOString(), label);
                });
            });
        </script>
        <!-- /jQuery Smart Wizard -->

        <script>
            $("#type").on("change", function () {
                $("#" + $(this).val()).show().siblings().hide();
            })
        </script>
    </body>
</html>
