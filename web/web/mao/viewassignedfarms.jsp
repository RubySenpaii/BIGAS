<%-- 
    Document   : technician
    Created on : Jul 9, 2016, 11:32:15 AM
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

        <title>B.I.G.A.S. System | Farm Assignment</title>

        <!-- Bootstrap -->
        <link href="/BIGAS/vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
        <!-- Font Awesome -->
        <link href="/BIGAS/vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet">
        <!-- iCheck -->
        <link href="/BIGAS/vendors/iCheck/skins/flat/green.css" rel="stylesheet">
        <!-- bootstrap-progressbar -->
        <link href="/BIGAS/vendors/bootstrap-progressbar/css/bootstrap-progressbar-3.3.4.min.css" rel="stylesheet">
        <!-- jVectorMap -->
        <link href="../css/maps/jquery-jvectormap-2.0.3.css" rel="stylesheet"/>
        <!--bootstrap progressbar-->
        <link href="/BIGAS/vendors/bootstrap-progressbar/css/bootstrap-progressbar-3.3.4.min.css" rel="stylesheet">
        

        <!-- Custom Theme Style -->
        <link href="/BIGAS/build/css/custom.min.css" rel="stylesheet">
    </head>

    <body class="nav-md">
        <div class="container body">
            <div class="main_container">
                <jsp:include page="pagesidebar.jsp"/>
                <jsp:include page="pageheader.jsp"/>
                <br />

                <!-- page content -->
                <div class="right_col" role="main">
                    <div class>
                        <!--page header-->
                        
                        <div class="clearfix">
                        </div>
                        <!--page content container-->
                        <div class="row">
                            <div class="x_panel">
                                <div class="x_title">
                                    <div class="clearfix"></div>
                                </div>
                                <!--container-->
                                <div class="col-md-12 col-sm-12 col-xs-12">
                                    <div class="x_panel">
                                        <div class="x_title">
                                            <h2><i class="fa fa-bars"></i>Farm Assignment - San Rafael, Bulacan</h2>
                                            <ul class="nav navbar-right panel_toolbox">
                                            </ul>
                                            <div class="clearfix"></div>
                                        </div>
                                        <div class="x_content">

                                            <div class="col-xs-3">
                                                <!-- required for floating -->
                                                <!-- Nav tabs -->
                                                <ul class="nav nav-tabs tabs-left">
                                                    <li class="active">
                                                        <a href="#home" data-toggle="tab">Masaki Karino<br><small>Report Officer</small></a>
                                                    </li>
                                                    <li>
                                                        <a href="#profile" data-toggle="tab">Carmina Veneracion<br><small>Technician</small></a>
                                                    </li>
                                                    <li>
                                                        <a href="#messages" data-toggle="tab">Jemi Tiu<br><small>Technician</small></a>
                                                    </li>
                                                    <li>
                                                        <a href="#settings" data-toggle="tab">Josiah Barretto<br><small>Technician</small></a>
                                                    </li>
                                                </ul>
                                            </div>

                                            <div class="col-xs-9">
                                                <!-- Tab panes -->
                                                <div class="tab-content">
                                                    <div class="tab-pane active" id="home">
                                                        <!--profile widget-->
                                                        <div class="col-md-3 col-xs-12 widget widget_tally_box">
                                                            <div class="x_panel fixed_height_420">
                                                                <div class="x_content">

                                                                    <div class="flex">
                                                                        <ul class="list-inline widget_profile_box">
                                                                            <li>
                                                                                <a>
                                                                                    <i></i>
                                                                                </a>
                                                                            </li>
                                                                            <li>
                                                                                <img src="../images/charot.png" alt="..." class="img-circle profile_img">
                                                                            </li>
                                                                            <li>
                                                                                <a>
                                                                                    <i></i>
                                                                                </a>
                                                                            </li>
                                                                        </ul>
                                                                    </div>

                                                                    <h3 class="name">Masaki Karino</h3>
                                                                    <h5 class="name">Report Officer</h5>

                                                                    <div class="flex">
                                                                        <ul class="list-inline count">
                                                                            <li>
                                                                                <h3>40</h3>
                                                                                <span>Farms to Visit</span>
                                                                            </li>
                                                                            <li>
                                                                                <h3>30</h3>
                                                                                <span>Farms Visited</span>
                                                                            </li>
                                                                        </ul>
                                                                    </div>
                                                                    <div class="progress">
                                                                        <div class="progress-bar progress-bar-success" data-transitiongoal="90"></div>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <!--//profile widget-->

                                                        <!--farmers table-->
                                                        <div class="col-md-9 col-xs-12"
                                                             <div class="x_panel">
                                                                <div class="x_title">
                                                                    <h2>Farms to Visit</h2>
                                                                    <ul class="nav navbar-right panel_toolbox">
                                                                    </ul>
                                                                    <div class="clearfix"></div>
                                                                </div>
                                                                <div class="x_content">
                                                                    <table id="datatable" class="table table-striped table-bordered">
                                                                        <thead>
                                                                            <tr>
                                                                                <th>Farmer</th>
                                                                                <th>Address</th>
                                                                                <th>Area</th>
                                                                                <th>Barangay</th>
                                                                                <th>Ecosystem</th>
                                                                                <th></th>
                                                                            </tr>
                                                                        </thead>


                                                                        <tbody>
                                                                            <tr>
                                                                                <td>Tiger Nixon</td>
                                                                                <td>12 Castro Street</td>
                                                                                <td>1.0</td>
                                                                                <td>Capihan</td>
                                                                                <td>Rainfed</td>
                                                                                <td></td>
                                                                            </tr>
                                                                            <tr>
                                                                                <td>Garrett Winters</td>
                                                                                <td>245 Taft Avenue</td>
                                                                                <td>1.5</td>
                                                                                <td>Pulilan</td>
                                                                                <td>Rainfed</td>
                                                                                <td></td>
                                                                            </tr>
                                                                            <tr>
                                                                                <td>Ashton Cox</td>
                                                                                <td>90 Pablo Ocampo</td>
                                                                                <td>0.5</td>
                                                                                <td>Coral na Bato</td>
                                                                                <td>Rainfed</td>
                                                                                <td></td>
                                                                            </tr>
                                                                            <tr>
                                                                                <td>Cedric Kelly</td>
                                                                                <td>1455 Pedro Gil</td>
                                                                                <td>0.5</td>
                                                                                <td>Pasong Intsik</td>
                                                                                <td>Rainfed</td>
                                                                                <td></td>
                                                                            </tr>
                                                                            <tr>
                                                                                <td>Airi Satou</td>
                                                                                <td>13 U.N. Avenue</td>
                                                                                <td>1.0</td>
                                                                                <td>Pulo</td>
                                                                                <td>Rainfed</td>
                                                                                <td></td>
                                                                            </tr>
                                                                            <tr>
                                                                                <td>Brielle Williamson</td>
                                                                                <td>987 Rizal Avenue</td>
                                                                                <td>2.0</td>
                                                                                <td>Maguinao</td>
                                                                                <td>Irrigated</td>
                                                                                <td></td>
                                                                            </tr>
                                                                            <tr>
                                                                                <td>Herrod Chandler</td>
                                                                                <td>123 Abad Santos</td>
                                                                                <td>1.0</td>
                                                                                <td>Coral na Bato</td>
                                                                                <td>Irrigated</td>
                                                                                <td></td>
                                                                            </tr>
                                                                            <tr>
                                                                                <td>Rhona Davidson</td>
                                                                                <td>456 Karen Avenue</td>
                                                                                <td>1.0</td>
                                                                                <td>Pinacpinacan</td>
                                                                                <td>Rainfed</td>
                                                                                <td></td>
                                                                            </tr>
                                                                            <tr>
                                                                                <td>Colleen Hurst</td>
                                                                                <td>88 Blumentritt</td>
                                                                                <td>0.5</td>
                                                                                <td>Diliman I</td>
                                                                                <td>Irrigated</td>
                                                                                <td></td>
                                                                            </tr>
                                                                            <tr>
                                                                                <td>Sonya Frost</td>
                                                                                <td>99 Tayuman</td>
                                                                                <td>1.0</td>
                                                                                <td>Diliman II</td>
                                                                                <td>Rainfed</td>
                                                                                <td></td>
                                                                            </tr>
                                                                        </tbody>
                                                                    </table>
                                                                </div>
                                                            </div>
                                                            <!--//farmers table-->
                                                        </div>
                                                        <div class="tab-pane" id="profile">
                                                            <!--profile widget-->
                                                            <div class="col-md-3 col-xs-12 widget widget_tally_box">
                                                                <div class="x_panel fixed_height_420">
                                                                    <div class="x_content">

                                                                        <div class="flex">
                                                                            <ul class="list-inline widget_profile_box">
                                                                                <li>
                                                                                    <a>
                                                                                        <i></i>
                                                                                    </a>
                                                                                </li>
                                                                                <li>
                                                                                    <img src="../images/charot.png" alt="..." class="img-circle profile_img">
                                                                                </li>
                                                                                <li>
                                                                                    <a>
                                                                                        <i></i>
                                                                                    </a>
                                                                                </li>
                                                                            </ul>
                                                                        </div>

                                                                        <h3 class="name">Carmina Veneracion</h3>
                                                                        <h5 class="name">Technician</h5>

                                                                        <div class="flex">
                                                                            <ul class="list-inline count">
                                                                                <li>
                                                                                    <h3>40</h3>
                                                                                    <span>Farms to Visit</span>
                                                                                </li>
                                                                                <li>
                                                                                    <h3>30</h3>
                                                                                    <span>Farms Visited</span>
                                                                                </li>
                                                                            </ul>
                                                                        </div>

                                                                        <div class="progress">
                                                                        <div class="progress-bar progress-bar-success" data-transitiongoal="90"></div>
                                                                    </div>

                                                                    </div>
                                                                </div>
                                                            </div>
                                                            <!--//profile widget-->

                                                            <!--farmers table-->
                                                            <div class="col-md-9 col-xs-12"
                                                                 <div class="x_panel">
                                                                    <div class="x_title">
                                                                        <h2>Farms to Visit</h2>
                                                                        <ul class="nav navbar-right panel_toolbox">
                                                                        </ul>
                                                                        <div class="clearfix"></div>
                                                                    </div>
                                                                    <div class="x_content">
                                                                        <table id="datatable1" class="table table-striped table-bordered">
                                                                            <thead>
                                                                                <tr>
                                                                                    <th>Name</th>
                                                                                    <th>Position</th>
                                                                                    <th>Office</th>
                                                                                    <th>Age</th>
                                                                                    <th>Start date</th>
                                                                                    <th>Salary</th>
                                                                                </tr>
                                                                            </thead>


                                                                            <tbody>
                                                                                <tr>
                                                                                    <td>Tiger Nixon</td>
                                                                                    <td>System Architect</td>
                                                                                    <td>Edinburgh</td>
                                                                                    <td>61</td>
                                                                                    <td>2011/04/25</td>
                                                                                    <td>$320,800</td>
                                                                                </tr>
                                                                                <tr>
                                                                                    <td>Garrett Winters</td>
                                                                                    <td>Accountant</td>
                                                                                    <td>Tokyo</td>
                                                                                    <td>63</td>
                                                                                    <td>2011/07/25</td>
                                                                                    <td>$170,750</td>
                                                                                </tr>
                                                                                <tr>
                                                                                    <td>Ashton Cox</td>
                                                                                    <td>Junior Technical Author</td>
                                                                                    <td>San Francisco</td>
                                                                                    <td>66</td>
                                                                                    <td>2009/01/12</td>
                                                                                    <td>$86,000</td>
                                                                                </tr>
                                                                                <tr>
                                                                                    <td>Cedric Kelly</td>
                                                                                    <td>Senior Javascript Developer</td>
                                                                                    <td>Edinburgh</td>
                                                                                    <td>22</td>
                                                                                    <td>2012/03/29</td>
                                                                                    <td>$433,060</td>
                                                                                </tr>
                                                                                <tr>
                                                                                    <td>Airi Satou</td>
                                                                                    <td>Accountant</td>
                                                                                    <td>Tokyo</td>
                                                                                    <td>33</td>
                                                                                    <td>2008/11/28</td>
                                                                                    <td>$162,700</td>
                                                                                </tr>
                                                                                <tr>
                                                                                    <td>Brielle Williamson</td>
                                                                                    <td>Integration Specialist</td>
                                                                                    <td>New York</td>
                                                                                    <td>61</td>
                                                                                    <td>2012/12/02</td>
                                                                                    <td>$372,000</td>
                                                                                </tr>
                                                                                <tr>
                                                                                    <td>Herrod Chandler</td>
                                                                                    <td>Sales Assistant</td>
                                                                                    <td>San Francisco</td>
                                                                                    <td>59</td>
                                                                                    <td>2012/08/06</td>
                                                                                    <td>$137,500</td>
                                                                                </tr>
                                                                                <tr>
                                                                                    <td>Rhona Davidson</td>
                                                                                    <td>Integration Specialist</td>
                                                                                    <td>Tokyo</td>
                                                                                    <td>55</td>
                                                                                    <td>2010/10/14</td>
                                                                                    <td>$327,900</td>
                                                                                </tr>
                                                                                <tr>
                                                                                    <td>Colleen Hurst</td>
                                                                                    <td>Javascript Developer</td>
                                                                                    <td>San Francisco</td>
                                                                                    <td>39</td>
                                                                                    <td>2009/09/15</td>
                                                                                    <td>$205,500</td>
                                                                                </tr>
                                                                                <tr>
                                                                                    <td>Sonya Frost</td>
                                                                                    <td>Software Engineer</td>
                                                                                    <td>Edinburgh</td>
                                                                                    <td>23</td>
                                                                                    <td>2008/12/13</td>
                                                                                    <td>$103,600</td>
                                                                                </tr>
                                                                            </tbody>
                                                                        </table>
                                                                    </div>
                                                                </div>
                                                                <!--//farmers table-->
                                                            </div>
                                                            <div class="tab-pane" id="messages">
                                                                <!--profile widget-->
                                                                <div class="col-md-3 col-xs-12 widget widget_tally_box">
                                                                    <div class="x_panel fixed_height_420">
                                                                        <div class="x_content">

                                                                            <div class="flex">
                                                                                <ul class="list-inline widget_profile_box">
                                                                                    <li>
                                                                                        <a>
                                                                                            <i></i>
                                                                                        </a>
                                                                                    </li>
                                                                                    <li>
                                                                                        <img src="../images/charot.png" alt="..." class="img-circle profile_img">
                                                                                    </li>
                                                                                    <li>
                                                                                        <a>
                                                                                            <i></i>
                                                                                        </a>
                                                                                    </li>
                                                                                </ul>
                                                                            </div>

                                                                            <h3 class="name">Jemi Tiu</h3>
                                                                            <h5 class="name">Technician</h5>

                                                                            <div class="flex">
                                                                                <ul class="list-inline count">
                                                                                    <li>
                                                                                        <h3>40</h3>
                                                                                        <span>Farms to Visit</span>
                                                                                    </li>
                                                                                    <li>
                                                                                        <h3>30</h3>
                                                                                        <span>Farms Visited</span>
                                                                                    </li>
                                                                                </ul>
                                                                            </div>

                                                                            <div class="progress">
                                                                        <div class="progress-bar progress-bar-success" data-transitiongoal="90"></div>
                                                                    </div>

                                                                        </div>
                                                                    </div>
                                                                </div>
                                                                <!--//profile widget-->

                                                                <!--farmers table-->
                                                                <div class="col-md-9 col-xs-12"
                                                                     <div class="x_panel">
                                                                        <div class="x_title">
                                                                            <h2>Farms to Visit</h2>
                                                                            <ul class="nav navbar-right panel_toolbox">
                                                                            </ul>
                                                                            <div class="clearfix"></div>
                                                                        </div>
                                                                        <div class="x_content">
                                                                            <table id="datatable2" class="table table-striped table-bordered">
                                                                                <thead>
                                                                                    <tr>
                                                                                        <th>Name</th>
                                                                                        <th>Position</th>
                                                                                        <th>Office</th>
                                                                                        <th>Age</th>
                                                                                        <th>Start date</th>
                                                                                        <th>Salary</th>
                                                                                    </tr>
                                                                                </thead>
                                                                                <tbody>
                                                                                    <tr>
                                                                                        <td>Tiger Nixon</td>
                                                                                        <td>System Architect</td>
                                                                                        <td>Edinburgh</td>
                                                                                        <td>61</td>
                                                                                        <td>2011/04/25</td>
                                                                                        <td>$320,800</td>
                                                                                    </tr>
                                                                                    <tr>
                                                                                        <td>Garrett Winters</td>
                                                                                        <td>Accountant</td>
                                                                                        <td>Tokyo</td>
                                                                                        <td>63</td>
                                                                                        <td>2011/07/25</td>
                                                                                        <td>$170,750</td>
                                                                                    </tr>
                                                                                    <tr>
                                                                                        <td>Ashton Cox</td>
                                                                                        <td>Junior Technical Author</td>
                                                                                        <td>San Francisco</td>
                                                                                        <td>66</td>
                                                                                        <td>2009/01/12</td>
                                                                                        <td>$86,000</td>
                                                                                    </tr>
                                                                                    <tr>
                                                                                        <td>Cedric Kelly</td>
                                                                                        <td>Senior Javascript Developer</td>
                                                                                        <td>Edinburgh</td>
                                                                                        <td>22</td>
                                                                                        <td>2012/03/29</td>
                                                                                        <td>$433,060</td>
                                                                                    </tr>
                                                                                    <tr>
                                                                                        <td>Airi Satou</td>
                                                                                        <td>Accountant</td>
                                                                                        <td>Tokyo</td>
                                                                                        <td>33</td>
                                                                                        <td>2008/11/28</td>
                                                                                        <td>$162,700</td>
                                                                                    </tr>
                                                                                    <tr>
                                                                                        <td>Brielle Williamson</td>
                                                                                        <td>Integration Specialist</td>
                                                                                        <td>New York</td>
                                                                                        <td>61</td>
                                                                                        <td>2012/12/02</td>
                                                                                        <td>$372,000</td>
                                                                                    </tr>
                                                                                    <tr>
                                                                                        <td>Herrod Chandler</td>
                                                                                        <td>Sales Assistant</td>
                                                                                        <td>San Francisco</td>
                                                                                        <td>59</td>
                                                                                        <td>2012/08/06</td>
                                                                                        <td>$137,500</td>
                                                                                    </tr>
                                                                                    <tr>
                                                                                        <td>Rhona Davidson</td>
                                                                                        <td>Integration Specialist</td>
                                                                                        <td>Tokyo</td>
                                                                                        <td>55</td>
                                                                                        <td>2010/10/14</td>
                                                                                        <td>$327,900</td>
                                                                                    </tr>
                                                                                    <tr>
                                                                                        <td>Colleen Hurst</td>
                                                                                        <td>Javascript Developer</td>
                                                                                        <td>San Francisco</td>
                                                                                        <td>39</td>
                                                                                        <td>2009/09/15</td>
                                                                                        <td>$205,500</td>
                                                                                    </tr>
                                                                                    <tr>
                                                                                        <td>Sonya Frost</td>
                                                                                        <td>Software Engineer</td>
                                                                                        <td>Edinburgh</td>
                                                                                        <td>23</td>
                                                                                        <td>2008/12/13</td>
                                                                                        <td>$103,600</td>
                                                                                    </tr>
                                                                                </tbody>
                                                                            </table>
                                                                        </div>
                                                                    </div>
                                                                    <!--//farmers table-->
                                                                </div>
                                                                <div class="tab-pane" id="settings">
                                                                    <!--profile widget-->
                                                                    <div class="col-md-3 col-xs-12 widget widget_tally_box">
                                                                        <div class="x_panel fixed_height_420">
                                                                            <div class="x_content">

                                                                                <div class="flex">
                                                                                    <ul class="list-inline widget_profile_box">
                                                                                        <li>
                                                                                            <a>
                                                                                                <i></i>
                                                                                            </a>
                                                                                        </li>
                                                                                        <li>
                                                                                            <img src="../images/charot.png" alt="..." class="img-circle profile_img">
                                                                                        </li>
                                                                                        <li>
                                                                                            <a>
                                                                                                <i></i>
                                                                                            </a>
                                                                                        </li>
                                                                                    </ul>
                                                                                </div>

                                                                                <h3 class="name">Josiah Barretto</h3>
                                                                                <h5 class="name">Technician</h5>

                                                                                <div class="flex">
                                                                                    <ul class="list-inline count">
                                                                                        <li>
                                                                                            <h3>40</h3>
                                                                                            <span>Farms to Visit</span>
                                                                                        </li>
                                                                                        <li>
                                                                                            <h3>30</h3>
                                                                                            <span>Farms Visited</span>
                                                                                        </li>
                                                                                    </ul>
                                                                                </div>

                                                                               <div class="progress">
                                                                        <div class="progress-bar progress-bar-success" data-transitiongoal="90"></div>
                                                                    </div>

                                                                            </div>
                                                                        </div>
                                                                    </div>
                                                                    <!--//profile widget-->

                                                                    <!--farmers table-->
                                                                    <div class="col-md-9 col-xs-12"
                                                                         <div class="x_panel">
                                                                            <div class="x_title">
                                                                                <h2>Farms to Visit</h2>
                                                                                <ul class="nav navbar-right panel_toolbox">
                                                                                </ul>
                                                                                <div class="clearfix"></div>
                                                                            </div>
                                                                            <div class="x_content">
                                                                                <table id="datatable3" class="table table-striped table-bordered">
                                                                                    <thead>
                                                                                        <tr>
                                                                                            <th>Name</th>
                                                                                            <th>Position</th>
                                                                                            <th>Office</th>
                                                                                            <th>Age</th>
                                                                                            <th>Start date</th>
                                                                                            <th>Salary</th>
                                                                                        </tr>
                                                                                    </thead>


                                                                                    <tbody>
                                                                                        <tr>
                                                                                            <td>Tiger Nixon</td>
                                                                                            <td>System Architect</td>
                                                                                            <td>Edinburgh</td>
                                                                                            <td>61</td>
                                                                                            <td>2011/04/25</td>
                                                                                            <td>$320,800</td>
                                                                                        </tr>
                                                                                        <tr>
                                                                                            <td>Garrett Winters</td>
                                                                                            <td>Accountant</td>
                                                                                            <td>Tokyo</td>
                                                                                            <td>63</td>
                                                                                            <td>2011/07/25</td>
                                                                                            <td>$170,750</td>
                                                                                        </tr>
                                                                                        <tr>
                                                                                            <td>Ashton Cox</td>
                                                                                            <td>Junior Technical Author</td>
                                                                                            <td>San Francisco</td>
                                                                                            <td>66</td>
                                                                                            <td>2009/01/12</td>
                                                                                            <td>$86,000</td>
                                                                                        </tr>
                                                                                        <tr>
                                                                                            <td>Cedric Kelly</td>
                                                                                            <td>Senior Javascript Developer</td>
                                                                                            <td>Edinburgh</td>
                                                                                            <td>22</td>
                                                                                            <td>2012/03/29</td>
                                                                                            <td>$433,060</td>
                                                                                        </tr>
                                                                                        <tr>
                                                                                            <td>Airi Satou</td>
                                                                                            <td>Accountant</td>
                                                                                            <td>Tokyo</td>
                                                                                            <td>33</td>
                                                                                            <td>2008/11/28</td>
                                                                                            <td>$162,700</td>
                                                                                        </tr>
                                                                                        <tr>
                                                                                            <td>Brielle Williamson</td>
                                                                                            <td>Integration Specialist</td>
                                                                                            <td>New York</td>
                                                                                            <td>61</td>
                                                                                            <td>2012/12/02</td>
                                                                                            <td>$372,000</td>
                                                                                        </tr>
                                                                                        <tr>
                                                                                            <td>Herrod Chandler</td>
                                                                                            <td>Sales Assistant</td>
                                                                                            <td>San Francisco</td>
                                                                                            <td>59</td>
                                                                                            <td>2012/08/06</td>
                                                                                            <td>$137,500</td>
                                                                                        </tr>
                                                                                        <tr>
                                                                                            <td>Rhona Davidson</td>
                                                                                            <td>Integration Specialist</td>
                                                                                            <td>Tokyo</td>
                                                                                            <td>55</td>
                                                                                            <td>2010/10/14</td>
                                                                                            <td>$327,900</td>
                                                                                        </tr>
                                                                                        <tr>
                                                                                            <td>Colleen Hurst</td>
                                                                                            <td>Javascript Developer</td>
                                                                                            <td>San Francisco</td>
                                                                                            <td>39</td>
                                                                                            <td>2009/09/15</td>
                                                                                            <td>$205,500</td>
                                                                                        </tr>
                                                                                        <tr>
                                                                                            <td>Sonya Frost</td>
                                                                                            <td>Software Engineer</td>
                                                                                            <td>Edinburgh</td>
                                                                                            <td>23</td>
                                                                                            <td>2008/12/13</td>
                                                                                            <td>$103,600</td>
                                                                                        </tr>
                                                                                    </tbody>
                                                                                </table>
                                                                            </div>
                                                                        </div>
                                                                        <!--//farmers table-->
                                                                    </div>
                                                                </div>
                                                            </div>

                                                            <div class="clearfix"></div>

                                                        </div>
                                                    </div>
                                                </div>
                                                <!--//container-->



                                            </div>
                                        </div>

                                    </div>
                                </div>
                                <!--end: page content container-->
                            </div>
                        </div>
                        <!-- /page content -->
                        <jsp:include page="pagefooter.jsp"/>
                    </div>

                    <!-- jQuery -->
                    <script src="/BIGAS/vendors/jquery/dist/jquery.min.js"></script>
                    <!-- Bootstrap -->
                    <script src="/BIGAS/vendors/bootstrap/dist/js/bootstrap.min.js"></script>
                    <!-- FastClick -->
                    <script src="/BIGAS/vendors/fastclick/lib/fastclick.js"></script>
                    <!-- NProgress -->
                    <script src="/BIGAS/vendors/nprogress/nprogress.js"></script>
                    <!-- iCheck -->
                    <script src="/BIGAS/vendors/iCheck/icheck.min.js"></script>
                    <!-- Skycons -->
                    <script src="/BIGAS/vendors/skycons/skycons.js"></script>
                    <!--progressbar-->
                    <script src="/BIGAS/vendors/bootstrap-progressbar/bootstrap-progressbar.min.js"></script>


                    <!-- Custom Theme Scripts -->
                    <script src="/BIGAS/build/js/custom.min.js"></script>

                    <!--table-->
                    <script src="/BIGAS/vendors/datatables.net/js/jquery.dataTables.min.js"></script>
                    <script src="/BIGAS/vendors/datatables.net-bs/js/dataTables.bootstrap.min.js"></script>
                    <script src="/BIGAS/vendors/datatables.net-buttons/js/dataTables.buttons.min.js"></script>
                    <script src="/BIGAS/vendors/datatables.net-buttons-bs/js/buttons.bootstrap.min.js"></script>
                    <script src="/BIGAS/vendors/datatables.net-buttons/js/buttons.flash.min.js"></script>
                    <script src="/BIGAS/vendors/datatables.net-buttons/js/buttons.html5.min.js"></script>
                    <script src="/BIGAS/vendors/datatables.net-buttons/js/buttons.print.min.js"></script>
                    <script src="/BIGAS/vendors/datatables.net-fixedheader/js/dataTables.fixedHeader.min.js"></script>
                    <script src="/BIGAS/vendors/datatables.net-keytable/js/dataTables.keyTable.min.js"></script>
                    <script src="/BIGAS/vendors/datatables.net-responsive/js/dataTables.responsive.min.js"></script>
                    <script src="/BIGAS/vendors/datatables.net-responsive-bs/js/responsive.bootstrap.js"></script>
                    <script src="/BIGAS/vendors/datatables.net-scroller/js/datatables.scroller.min.js"></script>
                    <script src="/BIGAS/vendors/jszip/dist/jszip.min.js"></script>
                    <script src="/BIGAS/vendors/pdfmake/build/pdfmake.min.js"></script>
                    <script src="/BIGAS/vendors/pdfmake/build/vfs_fonts.js"></script>

                    <!-- Autosize -->
                    <script>
                        $(document).ready(function () {
                            var handleDataTableButtons = function () {
                                if ($("#datatable-buttons").length) {
                                    $("#datatable-buttons").DataTable({
                                        dom: "Bfrtip",
                                        buttons: [
                                            {
                                                extend: "copy",
                                                className: "btn-sm"
                                            },
                                            {
                                                extend: "csv",
                                                className: "btn-sm"
                                            },
                                            {
                                                extend: "excel",
                                                className: "btn-sm"
                                            },
                                            {
                                                extend: "pdfHtml5",
                                                className: "btn-sm"
                                            },
                                            {
                                                extend: "print",
                                                className: "btn-sm"
                                            },
                                        ],
                                        responsive: true
                                    });
                                }
                            };

                            TableManageButtons = function () {
                                "use strict";
                                return {
                                    init: function () {
                                        handleDataTableButtons();
                                    }
                                };
                            }();

                            $('#datatable').dataTable();
                            $('#datatable1').dataTable();
                            $('#datatable2').dataTable();
                            $('#datatable3').dataTable();
                            $('#datatable-keytable').DataTable({
                                keys: true
                            });

                            $('#datatable-responsive').DataTable();

                            $('#datatable-scroller').DataTable({
                                ajax: "js/datatables/json/scroller-demo.json",
                                deferRender: true,
                                scrollY: 380,
                                scrollCollapse: true,
                                scroller: true
                            });

                            var table = $('#datatable-fixed-header').DataTable({
                                fixedHeader: true
                            });

                            TableManageButtons.init();
                        });
                    </script>
                    <!-- /Autosize -->
                    </body>
                    </html>
