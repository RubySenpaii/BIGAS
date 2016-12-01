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
                <a href="/BIGAS/web/mao/homepage.jsp" class="site_title"><i class="fa fa-tree"></i> <span>B.I.G.A.S. System</span></a>
            </div>

            <div class="clearfix"></div>



            <!-- sidebar menu -->
            <div id="sidebar-menu" class="main_menu_side hidden-print main_menu">
                <div class="menu_section">
                    <ul class="nav side-menu">
                        <li><a href="/BIGAS/web/mao/homepage.jsp"><i class="fa fa-home"></i> Home Page</a></li>
                        <li><a href="/BIGAS/web/mao/monitoringcropgrowth.jsp"><i class="fa fa-leaf"></i> Crop Monitoring</a></li>
                        <li><a href="/BIGAS/web/mao/monitoringsoil.jsp"><i class="fa fa-globe"></i> Soil Monitoring</a></li>
                        <li><a href="/BIGAS/web/mao/monitoringproduction.jsp"><i class="fa fa-map-marker"></i> Production </a></li>
                        <li><a href="/BIGAS/web/mao/programs.jsp"><i class="fa fa-laptop"></i> Programs</a></li>
                        <li><a href="/BIGAS/web/mao/monitoringdamages.jsp"><i class="fa fa-bug"></i> Pest and Damages</a></li>
                        <li><a><i class="fa fa-database"></i> People <span class="fa fa-chevron-down"></span></a>
                            <ul class="nav child_menu">
                                <li><a href="/BIGAS/web/mao/viewassignedfarms.jsp">Technician Assignments</a></li>
                                <li><a href="/BIGAS/web/mao/farmerlist.jsp">Farmers List</a></li>
                            </ul>
                        </li>
                    </ul>
                </div>

            </div>
            <!-- /sidebar menu -->
        </div>
    </div> 
</html>
