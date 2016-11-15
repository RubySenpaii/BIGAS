<%-- 
    Document   : createprogram3
    Created on : Nov 9, 2016, 12:14:49 AM
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

        <!-- Custom Theme Style -->
        <link href="/BIGAS/build/css/custom.min.css" rel="stylesheet">

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
                        <div class="col-md-12 col-sm-12 col-xs-12">
                            <div class="x_panel">
                                <div class="x_title">
                                    <h2>Create Program Plan</h2>
                                    <div class="clearfix"></div>
                                </div>
                                <div class="x_content">
                                    <ul class="breadcrumb">
                                        <li><a href="">Step 1: Program Plan Info</a></li>
                                        <li><a href="">Step 2: Goals</a></li>
                                        <li>Step 3: Activities</li>
                                    </ul>

                                    <form action="CreateProgramPlan">
                                        <table class="table table-bordered" >
                                            <thead>
                                                <tr>
                                                    <th style="width: 2%"><input type="checkbox" class="check_all" onclick="select_all()"></th>
                                                    <th style="width: 2%">#</th>
                                                    <th style="width: 36%">Phase</th>
                                                    <th style="width: 60%">Activity</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <tr>
                                                    <td><input type="checkbox" class="case"></td>
                                                    <td><span id='snum'>1</span></td>
                                                    <td>
                                                        <select style="width: 100%; height: 100%" name="phases">
                                                            <option>Pre-Implementation</option>
                                                        </select>
                                                    </td>
                                                    <td>
                                                        <textarea style="width: 100%; resize: none" rows="1" maxlength="600" name="activities"></textarea>
                                                    </td>
                                                </tr>
                                            </tbody>
                                            <button type="button" class='delete'>- Delete</button>
                                            <button type="button" class='addmore'>+ Add More</button>
                                        </table>
                                        <br/><br/>
                                        <div class="col-md-offset-5">
                                            <input type="hidden" name="action" value="createProgram">
                                            <button type="submit" class="btn btn-success">Next</button>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- /page content -->
                <jsp:include page="pagefooter.jsp"/>
            </div>
        </div>
        <script>
            $(".delete").on('click', function () {
                $('.case:checkbox:checked').parents("tr").remove();
                $('.check_all').prop("checked", false);
                check();

            });
            var i = 2;
            $(".addmore").on('click', function () {
                count = $('table tr').length;
                var data = "<tr><td><input type='checkbox' class='case'/></td><td><span id='snum"+i+"'>"+count+".</span></td>";
                data += "<td><select style='width: 100%; height: 100%' name='phases'><option>Pre-Implementation</option><option>Implementation</option></select></td><td><textarea style='width: 100% ; resize: none' rows='1' maxlength='600' name='activities'></textarea></td></tr>";
                        $('table').append(data);
                i++;
            });

            function select_all() {
                $('input[class=case]:checkbox').each(function () {
                    if ($('input[class=check_all]:checkbox:checked').length == 0) {
                        $(this).prop("checked", false);
                    } else {
                        $(this).prop("checked", true);
                    }
                });
            }

            function check() {
                obj = $('table tr').find('span');
                $.each(obj, function (key, value) {
                    id = value.id;
                    $('#' + id).html(key + 1);
                });
            }
        </script>

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
