<%-- 
    Document   : pagesidebar
    Created on : Sep 9, 2016, 5:34:13 PM
    Author     : RubySenpaii
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <div class="col-md-3 left_col">
        <div class="left_col scroll-view">
            <div class="navbar nav_title" style="border: 0;">
                <a href="../pages-admin/paodashboard.jsp" class="site_title"><i class="fa fa-tree"></i> <span>B.I.G.A.S. System</span></a>
            </div>

            <div class="clearfix"></div>

            <!-- menu profile quick info -->
            <div class="profile">
                <div class="profile_pic">
                    <img src="../images/img.jpg" alt="..." class="img-circle profile_img">
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
                    <h3>General</h3>
                    <ul class="nav side-menu">
                        <li><a href="../mao/homepage.jsp"><i class="fa fa-home"></i> Home Page</a></li>
                        <li><a href="../mao/monitoringcropgrowth.jsp"><i class="fa fa-leaf"></i> Crop Monitoring</a></li>
                        <li><a href="../mao/monitoringsoil.jsp"><i class="fa fa-globe"></i> Soil Monitoring</a></li>
                        <li><a href="../mao/monitoringproduction.jsp"><i class="fa fa-map-marker"></i> Production Monitoring </a></li>
                        <li><a><i class="fa fa-laptop"></i> Programs Assignment<span class="fa fa-chevron-down"></span></a>
                            <ul class="nav child_menu">
                                <li><a href="../mao/assignintervention.jsp">Interventions</a></li>
                                <li><a href="../mao/assignprovision.jsp">Provisions</a></li>
                                <li><a href="../mao/assignrehabilitation.jsp">Rehabilitation</a></li>
                            </ul>
                        </li>
                        <li><a href="../mao/monitoringdamages.jsp"><i class="fa fa-bug"></i> Pest and Damages</a></li>
                        <li><a><i class="fa fa-database"></i> People <span class="fa fa-chevron-down"></span></a>
                            <ul class="nav child_menu">
                                <li><a href="../pages-database/maoemployee.jsp">MAO Employee</a></li>
                                <li><a href="../pages-database/ricemechanization.jsp">Technician List</a></li>
                                <li><a href="/BIGAS/FarmerList">Farmers List</a></li>
                            </ul>
                        </li>
                        <li><a><i class="fa fa-bar-chart"></i> Reports <span class="fa fa-chevron-down"></span></a>
                            <ul class="nav child_menu">
                                <li><a href="../mao/reportsplanting.jsp">Planting Report</a></li>
                                <li><a href="../pages-reports/harvestreport.jsp">Harvest Report</a></li>
                                <li><a href="../pages-reports/damagereports.jsp">Pest and Diseases Report</a></li>-->
                                <li><a href="../pages-reports/damagereports.jsp">Damage Estimate Report</a></li>
                                <!--<li><a href="../pages-reports/damagereports.jsp">Accomplishment Report</a></li>-->
                            </ul>
                        </li>
                    </ul>
                </div>

            </div>
            <!-- /sidebar menu -->
        </div>
    </div> 
</html>
