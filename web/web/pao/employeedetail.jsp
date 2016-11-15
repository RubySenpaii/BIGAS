<%-- 
    Document   : employeedetail
    Created on : Nov 12, 2016, 8:28:05 PM
    Author     : RubySenpaii
--%>

<%@page import="objects.Employee"%>
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
                                    <h2>Employee Details</h2>
                                    <div class="clearfix"></div>
                                </div>
                                <div class="x_content">
                                    <%
                                        String view = (String) session.getAttribute("view");
                                        if (view.equals("edit")) {
                                            view = "";
                                        } else {
                                            view = "disabled";
                                        }
                                        Employee employee = (Employee) session.getAttribute("employeeDetail");
                                    %>
                                    <form class="form-horizontal form-label-left" action="CreateProgramPlan">
                                        <div class="form-group">
                                            <label class="control-label col-md-3">Last Name</label>
                                            <div class="col-md-6">
                                                <input type="text" class="form-control" name="lastName" value="<%=employee.getLastName()%>" <%=view%>>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="control-label col-md-3">First Name</label>
                                            <div class="col-md-6">
                                                <input type="text" class="form-control" name="firstName" value="<%=employee.getFirstName()%>" <%=view%>>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="control-label col-md-3">Middle Name</label>
                                            <div class="col-md-6">
                                                <input type="text" class="form-control" name="middleName" value="<%=employee.getMiddleName()%>" <%=view%>>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="control-label col-md-3">Address</label>
                                            <div class="col-md-6">
                                                <input type="text" class="form-control" name="address" value="<%=employee.getAddress()%>" <%=view%>>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="control-label col-md-3">Birthday</label>
                                            <div class="col-md-6">
                                                <input type="text" class="form-control" name="birthday" value="<%=employee.getBirthday()%>" <%=view%>>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="control-label col-md-3">Office</label>
                                            <div class="col-md-6">
                                                <select class="form-control" name="office" <%=view%>>
                                                    <option>MAO</option>
                                                    <option>PAO</option>
                                                    <option>Technician</option>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="control-label col-md-3">Gender</label>
                                            <div class="col-md-6">
                                                <select class="form-control" name="gender" <%=view%>>
                                                    <option>Male</option>
                                                    <option>Female</option>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="control-label col-md-3">Contact No</label>
                                            <div class="col-md-6">
                                                <input type="text" class="form-control" name="contactNo" value="<%=employee.getContactNo()%>" <%=view%>>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="control-label col-md-3">Username</label>
                                            <div class="col-md-6">
                                                <input type="text" class="form-control" name="username" value="<%=employee.getUsername()%>" <%=view%>>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="control-label col-md-3">Password</label>
                                            <div class="col-md-6">
                                                <input type="text" class="form-control" name="password" <%=view%>>
                                            </div>
                                        </div>
                                        <br/><br/>
                                        <div class="col-md-offset-5">
                                            <input type="hidden" name="action" value="editEmployee">
                                            <button type="submit" class="btn btn-success">Submit</button>
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
