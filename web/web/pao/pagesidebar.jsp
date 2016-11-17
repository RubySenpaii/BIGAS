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
                <a href="/BIGAS/Dashboard?action=goToDashboard" class="site_title"><i class="fa fa-tree"></i> <span>B.I.G.A.S. System</span></a>
            </div>

            <div class="clearfix"></div>


            <!-- sidebar menu -->
            <div id="sidebar-menu" class="main_menu_side hidden-print main_menu">
                <div class="menu_section">
                    <ul class="nav side-menu">
                        <li><a href="/BIGAS/ProvincialStatus?action=getProvincialStatus"><i class="fa fa-home"></i> Province Status</a></li>
                        <!--<li><a href="/BIGAS/web/pages-monitoring/cropmonitoring.jsp"><i class="fa fa-leaf"></i> Crop Monitoring</a></li>
                        <li><a href="/BIGAS/web/pages-monitoring/soilmonitoring.jsp"><i class="fa fa-globe"></i> Soil Monitoring</a></li>
                        <li><a href="/BIGAS/web/pao/production.jsp"><i class="fa fa-map-marker"></i> Production Monitoring </a></li>-->
                        <li><a><i class="fa fa-laptop"></i> Programs<span class="fa fa-chevron-down"></span></a>
                            <ul class="nav child_menu">
                                <li><a href="/BIGAS/CreateProgramPlan?action=goToStep1">Create Program</a></li>
                                <li><a href="/BIGAS/ViewProgram?action=viewProgramList">Program History</a></li>
                            </ul>
                        </li>
                        <li><a href="/BIGAS/ProblemLog?action=viewProblemLogs"><i class="fa fa-bug"></i> Damage Monitoring</a></li>
                        <li><a><i class="fa fa-database"></i> Data Management <span class="fa fa-chevron-down"></span></a>
                            <ul class="nav child_menu">
                                <li><a href="/BIGAS/Employee?action=viewEmployeeList">Employee List</a></li>
                                <!--<li><a href="/BIGAS/web/pages-database/maoemployee.jsp">MAO Employee</a></li>-->
                                <li><a href="/BIGAS/Farmer?action=viewFarmerList">Farmers List</a></li>
                                <li><a href="/BIGAS/PestDiseases?action=viewPestDiseases">Pest and Diseases</a></li>
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
                
                <div class="menu_section">
                    <h3>Additional Pages</h3>
                    <ul class="nav side-menu">
                        <!--<li><a href="/BIGAS/ProblemLog?action=viewProblemLogs"><i class="fa fa-mobile"></i> Problem Log</a></li>
                        <li><a href=""><i class="fa fa-mobile"></i> Create Disaster Warning</a></li>
                        <li><a href=""><i class="fa fa-mobile"></i> Generate Reports</a></li>-->
                        <li><a href="/BIGAS/web/pao/targetproduction.jsp"><i class="fa fa-mobile"></i> Set Target Production</a></li>
                    </ul>
                </div>
            </div>
            <!-- /sidebar menu -->
        </div>
    </div> 
</html>
