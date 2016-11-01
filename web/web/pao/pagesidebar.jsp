<%-- 
    Document   : pagesidebar
    Created on : Sep 14, 2016, 4:48:26 PM
    Author     : RubySenpaii
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <div class="col-md-3 left_col">
        <div class="left_col scroll-view">
            <div class="navbar nav_title" style="border: 0;">
                <a href="problemlist.jsp" class="site_title"><i class="fa fa-tree"></i> <span>B.I.G.A.S. System</span></a>
            </div>

            <div class="clearfix"></div>

            <!-- menu profile quick info 
            <div class="profile">
                <div class="profile_pic">
                    <img src="/BIGAS/web/images/img.jpg" alt="/BIGAS/web." class="img-circle profile_img">
                </div>
                <div class="profile_info">
                    <span>Welcome,</span>
                    <h2>John Doe</h2>
                    <br>
                </div>
            </div>
            <!-- /menu profile quick info -->


            <!-- sidebar menu -->
            <div id="sidebar-menu" class="main_menu_side hidden-print main_menu">
                <div class="menu_section">
                    <ul class="nav side-menu">
                        <li><a href="farmstatus.jsp"><i class="fa fa-home"></i> Home Page</a></li>
                        <!--<li><a href="/BIGAS/web/pages-monitoring/cropmonitoring.jsp"><i class="fa fa-leaf"></i> Crop Monitoring</a></li>
                        <li><a href="/BIGAS/web/pages-monitoring/soilmonitoring.jsp"><i class="fa fa-globe"></i> Soil Monitoring</a></li>-->
                        <li><a href="production.jsp"><i class="fa fa-map-marker"></i> Production Monitoring </a></li>
                        <li><a><i class="fa fa-laptop"></i> Programs Monitoring<span class="fa fa-chevron-down"></span></a>
                            <ul class="nav child_menu">
                                <li><a href="intervention.jsp">Interventions</a></li>
                                <li><a href="provision.jsp">Provisions</a></li>
                                <li><a href="rehabilitation.jsp">Rehabilitation</a></li>
                            </ul>
                        </li>
                        <li><a href="damagemonitoring.jsp"><i class="fa fa-bug"></i> Damage Monitoring</a></li>
                        <li><a><i class="fa fa-database"></i> Data Management <span class="fa fa-chevron-down"></span></a>
                            <ul class="nav child_menu">
                                <li><a href="paoemployee.jsp">PAO Employee</a></li>
                                <!--<li><a href="/BIGAS/web/pages-database/maoemployee.jsp">MAO Employee</a></li>-->
                                <li><a href="farmerlist.jsp">Farmers List</a></li>
                                <li><a href="pestanddiseases.jsp">Pest and Diseases</a></li>
                            </ul>
                        </li>
                        <li><a><i class="fa fa-bar-chart"></i> Reports <span class="fa fa-chevron-down"></span></a>
                            <ul class="nav child_menu">
                                <li><a href="/BIGAS/web/pages-reports/plantingreports.jsp">Planting Report</a></li>
                                <li><a href="/BIGAS/web/pages-reports/harvestreport.jsp">Harvest Report</a></li>
                                <!--<li><a href="/BIGAS/web/pages-reports/damagereports.jsp">Avg Yield Report</a></li>
                                <li><a href="/BIGAS/web/pages-reports/damagereports.jsp">Pest and Diseases Report</a></li>-->
                                <li><a href="/BIGAS/web/pages-reports/damagereports.jsp">Damage Estimate Report</a></li>
                            </ul>
                        </li>
                    </ul>
                </div>

            </div>
            <!-- /sidebar menu -->
        </div>
    </div> 
</html>
