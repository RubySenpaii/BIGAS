<%-- 
    Document   : municipal
    Created on : Jun 7, 2016, 1:44:13 PM
    Author     : RubySenpaii
--%>

<%@page import="objects.GenericObject"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- Meta, title, CSS, favicons, etc. -->
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <title>B.I.G.A.S. System | Season - Municipal</title>

        <!-- Bootstrap -->
        <link href="/BIGAS/vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
        <!-- Font Awesome -->
        <link href="/BIGAS/vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet">
        <!-- iCheck -->
        <link href="/BIGAS/vendors/iCheck/skins/flat/green.css" rel="stylesheet">
        <!-- bootstrap-progressbar -->
        <link href="/BIGAS/vendors/bootstrap-progressbar/css/bootstrap-progressbar-3.3.4.min.css" rel="stylesheet">

        <!-- Custom Theme Style -->
        <link href="/BIGAS/build/css/custom.min.css" rel="stylesheet">

        <!--Google Map Responsive -->
        <link href="/BIGAS/web/css/maps/googlemaps.css" rel="stylesheet">
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
                            <h3>Municipal Map</h3>
                        </div>

                        <div class="clearfix">

                        </div>

                        <!--page content container-->
                        <!--<div class="row">-->
                            <!--container for map
                            <div class="col-md-11">
                                <div id="municipalMap">
                                </div>
                                <script>
                                    function initMap() {
                                        var mapDiv = document.getElementById('municipalMap');
                                        var map = new google.maps.Map(mapDiv, {
                                            center: {lat: 14.984558, lng: 121.131376},
                                            zoom: 10
                                        });
                                    }
                                </script>
                                <script src="https://maps.googleapis.com/maps/api/js?callback=initMap" async defer></script>
                            </div>
                            <!--end: container for map-->

                            <!--<div class="col-md-1">
                                <button type="button" class="btn btn-info" style="width: 100%; height: 35px">Growth</button>
                                <button type="button" class="btn btn-success" style="width: 100%; height: 35px">Production</button>
                                <button type="button" class="btn btn-dark" style="width: 100%; height: 35px">Soil</button>
                                <button type="button" class="btn btn-danger" style="width: 100%; height: 35px">Damages</button>
                                <button type="button" class="btn btn-warning" style="width: 100%; height: 35px">Pests</button>
                            </div>
                        </div>-->
                        <br>
                        <div class="row">
                            <div class="col-md-12">
                                <table class="table table-bordered">
                                    <thead>
                                        <tr>
                                            <th>Barangay</th>
                                            <th>Area Planted</th>
                                            <th>Total Production</th>
                                            <th>Average Yield</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <%
                                            ArrayList<GenericObject> barangays = (ArrayList<GenericObject>) session.getAttribute("barangays");
                                            for (int a = 0; a < barangays.size(); a++) {
                                        %>
                                        <tr>
                                            <td><a href="/BIGAS/MunicipalDetails?barangay=<%=barangays.get(a).getAttribute1()%>"><%=barangays.get(a).getAttribute1()%></a></td>
                                            <td><%=barangays.get(a).getAttribute2()%></td>
                                            <td><%=barangays.get(a).getAttribute3()%></td>
                                            <td><%=barangays.get(a).getAttribute4()%></td>
                                        </tr>
                                        <%
                                            }
                                        %>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                        <!-- page content -->
                    </div>
                </div>
                <jsp:include page="../pages-admin/footer.jsp"/>
            </div>
        </div>
        <!-- jQuery -->
        <script src="/BIGAS/vendors/jquery/dist/jquery.min.js"></script>
        <!-- Bootstrap -->
        <script src="/BIGAS/vendors/bootstrap/dist/js/bootstrap.min.js"></script>
        <!-- FastClick -->
        <script src="/BIGAS/vendors/fastclick/lib/fastclick.js"></script>
        <!-- NProgress -->
        <script src="/BIGAS/vendors/nprogress/nprogress.js"></script>
        <!-- bootstrap-progressbar -->
        <script src="/BIGAS/vendors/bootstrap-progressbar/bootstrap-progressbar.min.js"></script>
        <!-- iCheck -->
        <script src="/BIGAS/vendors/iCheck/icheck.min.js"></script>
        <!-- Skycons -->
        <script src="/BIGAS/vendors/skycons/skycons.js"></script>

        <!-- Custom Theme Scripts -->
        <script src="/BIGAS/build/js/custom.min.js"></script>
    </body>
</html>

