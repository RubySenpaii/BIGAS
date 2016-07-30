<%-- 
    Document   : overview
    Created on : May 29, 2016, 11:03:44 AM
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

        <title>B.I.G.A.S. System | Map Overview</title>
        
        <!--MAP-->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
        <script src="/BIGAS/Mapbox/mapbox.js" type="text/javascript"></script>
        <link href="/BIGAS/Mapbox/mapbox.css" rel="stylesheet" type="text/css"/>

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
                            <h3>Map Overview</h3>
                        </div>

                        <div class="clearfix">

                        </div>

                        <!--page content container-->
                        <div class="row">
                            <!--container for map-->
                            <div class="col-md-6">
                                <div id="map">
                                </div>
                                <script>
                                    L.mapbox.accessToken = 'pk.eyJ1IjoibWprYXJpbm8iLCJhIjoiY2lxMXVxdnZyMDAwd3hsbTR3aTYxODByayJ9.1KAuU5CEUfUDAJRym0arLw';
                                        var mapboxTiles = L.tileLayer('https://api.mapbox.com/v4/mapbox.streets/{z}/{x}/{y}.png?access_token=' + L.mapbox.accessToken, {
                                            attribution: '© <a href="https://www.mapbox.com/map-feedback/">Mapbox</a> © <a href="http://www.openstreetmap.org/copyright">OpenStreetMap</a>'});

                                        var map = L.map('map', 'marker-symbol').addLayer(mapboxTiles).setView([14.989514, 120.976113], 12);

                                        var sanrafael = L.polygon([
                                            [14.9901, 121.06568],
                                            [14.987604, 121.052568],
                                            [14.984597, 121.039043],
                                            [14.959218, 121.025076],
                                            [14.958482, 120.999209],
                                            [14.948127, 120.990431],
                                            [14.958033, 120.960366],
                                            [14.957541, 120.951940],
                                            [14.968246, 120.915548],
                                            [15.01715, 120.89693],
                                            [15.01594, 120.89318],
                                            [15.032263, 120.891514],
                                            [15.022181, 120.903167],
                                            [15.023587, 120.914213],
                                            [15.038358, 120.915426], //1
                                            [15.04069, 120.93113],
                                            [15.038105, 120.957235], //2
                                            [15.00294, 120.98661],
                                            [15.015128, 121.018169],
                                            [14.99351, 121.02633],
                                            [15.00588, 121.06079], //
                                            [15.00115, 121.06458],
                                            [14.9901, 121.06568]
                                        ], {color: 'green',
                                            fillColor: 'green',
                                            fillOpacity: 0.5,
                                            fill: true}).addTo(map);

                                        var pansumaloc = L.polygon([
                                            [15.032263, 120.891514],
                                            [15.01594, 120.89318],
                                            [15.01715, 120.89693],
                                            [15.00572, 120.90119],
                                            [15.008832, 120.909349],
                                            [15.009290, 120.903171],
                                            [15.02545, 120.89931],
                                            [15.032263, 120.891514]
                                        ], {color: 'green',
                                            fillColor: 'green',
                                            fillOpacity: 0.5,
                                            fill: true}).addTo(map);

                                        map.dragging.disable();
                                        map.touchZoom.disable();
                                        map.doubleClickZoom.disable();
                                        map.scrollWheelZoom.disable();
                                        map.keyboard.disable();

                                        function ViewPansumaloc() {
                                            map.setView([15.017783, 120.898966], 15);
                                            map.closePopup();
                                            document.getElementById('weather').src = "http://forecast.io/embed/#lat=16&lon=122&name=Pansumaloc&units=si";
                                        }

                                        function ViewMap() {
                                            map.setView([14.989514, 120.976113], 13)
                                            map.closePopup();
                                        }

                                        function ViewGrowth() {

                                        }

                                        pansumaloc.bindPopup("Pansumaloc" + " " + "<a onClick='ViewPansumaloc()' href='#'>View | </a>" + "<a onClick='ViewMap();' href='#'>Back</a>");
                                </script>
                                <script src="https://maps.googleapis.com/maps/api/js?callback=initMap" async defer></script>
                            </div>
                            <!--end: container for map-->

                            <!--container for additional information-->
                            <div class="col-md-6">
                                <!--<div class>
                                    <iframe id="forecast_embed" type="text/html" frameborder="0" height="245" width="100%" src="http://forecast.io/embed/#lat=14.794273&lon=120.879901&name=Bulacan"> </iframe>
                                </div>-->

                                <div class="row">
                                    <div class="sidebar-widget col-md-12">
                                        <h4>Target Production For 2016-2017</h4>
                                        <div class="project_progress">
                                            <div class="progress">
                                                <div class="progress-bar" role="progress" data-transitiongoal="57"></div>
                                            </div>
                                            <div class="row">
                                                <div class="col-sm-5">
                                                    <h4 class="pull_left">0 MT</h4>
                                                </div>
                                                <div class="col-sm-2">
                                                    <h4>57%</h4>
                                                </div>
                                                <div class="col-sm-5">
                                                    <h4 class="pull-right">525,000 MT</h4>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>

                                <br>

                                <div class>

                                    <table class="table table-bordered border-aero">
                                        <thead>
                                            <tr>
                                                <th colspan="7" style="text-align: center">Wet Season</th>
                                            </tr>
                                            <tr>
                                                <th>Municipality</th>
                                                <th>Area Planted</th>
                                                <!--<th>Projected Production</th>
                                                <th>Area Harvested</th>-->
                                                <th>Harvested</th>
                                                <th>Actual Production</th>
                                                <th>Target Production</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <%
                                                ArrayList<GenericObject> municipals = (ArrayList<GenericObject>) session.getAttribute("municipals");
                                                for (int a = 0; a < municipals.size(); a++) {
                                            %>
                                            <tr>
                                                <td><a href="/BIGAS/Municipal?municipal=<%=municipals.get(a).getAttribute1()%>"><%=municipals.get(a).getAttribute1()%></a></td>
                                                <td><%=municipals.get(a).getAttribute2()%></td>
                                                <!--<td><%=municipals.get(a).getAttribute3()%></td>
                                                <td><%=municipals.get(a).getAttribute4()%></td>-->
                                                <td><%=municipals.get(a).getAttribute5()%></td>
                                                <td><%=municipals.get(a).getAttribute6()%></td>
                                                <td><%=municipals.get(a).getAttribute7()%></td>
                                            </tr>
                                            <%
                                                }
                                            %>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                            <!--end: container for additional information-->
                        </div>
                        <!-- /page content -->

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

                <!-- Custom Theme Scripts -->
                <script src="/BIGAS/build/js/custom.min.js"></script>

            </div>
        </div>
    </body>
</html>

