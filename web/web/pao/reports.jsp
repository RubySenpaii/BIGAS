<%-- 
    Document   : reports
    Created on : Dec 1, 2016, 1:56:52 PM
    Author     : RubySenpaii
--%>

<%@page import="extra.GenericObject"%>
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

        <title>Gentallela Alela! | </title>

        <!-- Bootstrap -->
        <link href="/BIGAS/vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
        <!-- Font Awesome -->
        <link href="/BIGAS/vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet">
        <!-- iCheck -->
        <link href="/BIGAS/vendors/iCheck/skins/flat/green.css" rel="stylesheet">

        <!-- Custom Theme Style -->
        <link href="/BIGAS/build/css/custom.min.css" rel="stylesheet">

        <!-- Custom Table CSS-->
        <link href="/BIGAS/web/css/table/customtable.css" rel="stylesheet">
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
                        <div class="title_left">
                            <h3>Report</h3>
                        </div>

                        <div class="clearfix">

                        </div>

                        <!--page content container-->
                        <div class="row">
                            <div class="col-md-12 col-lg-12 col-sm-12" role="tabpanel" data-example-id="toggleable-tabs">
                                <!-- tab labels-->
                                <ul id="myTab" class="nav nav-tabs bar_tabs" role="tablist">
                                    <li role="presentation" class="active">
                                        <a href="#tab_content1" id="irrigated-tab" role="tab" data-toggle="tab" aria-expanded="true">Planted</a>
                                    </li>
                                    <li role="presentation" class>
                                        <a href="#tab_content2" id="rainfed-tab" role="tab" data-toggle="tab" aria-expanded="false">Harvested</a>
                                    </li>
                                    <li role="presentation" class>
                                        <a href="#tab_content3" id="total-tab" role="tab" data-toggle="tab" aria-expanded="false">Damaged</a>
                                    </li>
                                </ul>
                                <!--end: tab labels-->

                                <!--tab contents-->
                                <div id="myTabContent" class="tab-content">
                                    <div role="tabpanel" class="tab-pane fade active in" id="tab_content1" aria-labelledby="irrigated-tab">
                                        <!--irrigated-->
                                        <div class="report-table">
                                            <table class="table table-bordered"">
                                                <thead>
                                                    <tr>
                                                        <th></th>
                                                        <th style="text-align: center" colspan="22">Irrigated</th>
                                                        <th colspan="2"></th>
                                                        <th style="text-align: center" colspan="22">Rainfed</th>
                                                        <th colspan="2"></th>
                                                        <th style="text-align: center" colspan="22">Total</th>
                                                        <th colspan="2"></th>
                                                    </tr>
                                                    <tr>
                                                        <th></th>
                                                        <th style="text-align: center" colspan="6">Hybrid</th>
                                                        <th style="text-align: center" colspan="5">Registered Seed</th>
                                                        <th style="text-align: center" colspan="6">Certified Seed</th>
                                                        <th style="text-align: center" colspan="5">Good Seed</th>
                                                        <th colspan="2"></th>
                                                        <th style="text-align: center" colspan="6">Hybrid</th>
                                                        <th style="text-align: center" colspan="5">Registered Seed</th>
                                                        <th style="text-align: center" colspan="6">Certified Seed</th>
                                                        <th style="text-align: center" colspan="5">Good Seed</th>
                                                        <th colspan="2"></th>
                                                        <th style="text-align: center" colspan="6">Hybrid</th>
                                                        <th style="text-align: center" colspan="5">Registered Seed</th>
                                                        <th style="text-align: center" colspan="6">Certified Seed</th>
                                                        <th style="text-align: center" colspan="5">Good Seed</th>
                                                        <th colspan="2"></th>
                                                    </tr>
                                                    <tr>
                                                        <th style="text-align: center; min-width: 150px">Municipal</th>

                                                        <th style="text-align: center; min-width: 100px">HYTA Program</th>
                                                        <th style="text-align: center; min-width: 100px">HYTA Demo</th>
                                                        <th style="text-align: center; min-width: 100px">Direct Purchase</th>
                                                        <th style="text-align: center; min-width: 100px">MTD/PTD/Cluster</th>
                                                        <th style="text-align: center; min-width: 100px">PLGU/MLGU</th>
                                                        <th style="text-align: center; min-width: 100px">Total</th>

                                                        <th style="text-align: center; min-width: 100px">CSB</th>
                                                        <th style="text-align: center; min-width: 100px">SG</th>
                                                        <th style="text-align: center; min-width: 100px">MTD</th>
                                                        <th style="text-align: center; min-width: 100px">Others</th>
                                                        <th style="text-align: center; min-width: 100px">Total</th>

                                                        <th style="text-align: center; min-width: 100px">Rehab</th>
                                                        <th style="text-align: center; min-width: 100px">3rd Crop</th>
                                                        <th style="text-align: center; min-width: 100px">MLGU/ PLGU</th>
                                                        <th style="text-align: center; min-width: 100px">Direct Purchased</th>
                                                        <th style="text-align: center; min-width: 100px">Others</th>
                                                        <th style="text-align: center; min-width: 100px">Total</th>
                                                        <th style="text-align: center; min-width: 100px">HQS (from CSB)</th>
                                                        <th style="text-align: center; min-width: 100px">HQS (from untagged)</th>
                                                        <th style="text-align: center; min-width: 100px">FHSS</th>
                                                        <th style="text-align: center; min-width: 100px">GSR</th>
                                                        <th style="text-align: center; min-width: 100px">Total</th>

                                                        <th style="text-align: center; min-width: 100px">UPLAND</th>
                                                        <th style="text-align: center; min-width: 100px">GRAND TOTAL</th>

                                                        <th style="text-align: center; min-width: 100px">HYTA Program</th>
                                                        <th style="text-align: center; min-width: 100px">HYTA Demo</th>
                                                        <th style="text-align: center; min-width: 100px">Direct Purchase</th>
                                                        <th style="text-align: center; min-width: 100px">MTD/PTD/Cluster</th>
                                                        <th style="text-align: center; min-width: 100px">PLGU/MLGU</th>
                                                        <th style="text-align: center; min-width: 100px">Total</th>

                                                        <th style="text-align: center; min-width: 100px">CSB</th>
                                                        <th style="text-align: center; min-width: 100px">SG</th>
                                                        <th style="text-align: center; min-width: 100px">MTD</th>
                                                        <th style="text-align: center; min-width: 100px">Others</th>
                                                        <th style="text-align: center; min-width: 100px">Total</th>

                                                        <th style="text-align: center; min-width: 100px">Rehab</th>
                                                        <th style="text-align: center; min-width: 100px">3rd Crop</th>
                                                        <th style="text-align: center; min-width: 100px">MLGU/ PLGU</th>
                                                        <th style="text-align: center; min-width: 100px">Direct Purchased</th>
                                                        <th style="text-align: center; min-width: 100px">Others</th>
                                                        <th style="text-align: center; min-width: 100px">Total</th>
                                                        <th style="text-align: center; min-width: 100px">HQS (from CSB)</th>
                                                        <th style="text-align: center; min-width: 100px">HQS (from untagged)</th>
                                                        <th style="text-align: center; min-width: 100px">FHSS</th>
                                                        <th style="text-align: center; min-width: 100px">GSR</th>
                                                        <th style="text-align: center; min-width: 100px">Total</th>

                                                        <th style="text-align: center; min-width: 100px">UPLAND</th>
                                                        <th style="text-align: center; min-width: 100px">GRAND TOTAL</th>

                                                        <th style="text-align: center; min-width: 100px">HYTA Program</th>
                                                        <th style="text-align: center; min-width: 100px">HYTA Demo</th>
                                                        <th style="text-align: center; min-width: 100px">Direct Purchase</th>
                                                        <th style="text-align: center; min-width: 100px">MTD/PTD/Cluster</th>
                                                        <th style="text-align: center; min-width: 100px">PLGU/MLGU</th>
                                                        <th style="text-align: center; min-width: 100px">Total</th>

                                                        <th style="text-align: center; min-width: 100px">CSB</th>
                                                        <th style="text-align: center; min-width: 100px">SG</th>
                                                        <th style="text-align: center; min-width: 100px">MTD</th>
                                                        <th style="text-align: center; min-width: 100px">Others</th>
                                                        <th style="text-align: center; min-width: 100px">Total</th>

                                                        <th style="text-align: center; min-width: 100px">Rehab</th>
                                                        <th style="text-align: center; min-width: 100px">3rd Crop</th>
                                                        <th style="text-align: center; min-width: 100px">MLGU/ PLGU</th>
                                                        <th style="text-align: center; min-width: 100px">Direct Purchased</th>
                                                        <th style="text-align: center; min-width: 100px">Others</th>
                                                        <th style="text-align: center; min-width: 100px">Total</th>
                                                        <th style="text-align: center; min-width: 100px">HQS (from CSB)</th>
                                                        <th style="text-align: center; min-width: 100px">HQS (from untagged)</th>
                                                        <th style="text-align: center; min-width: 100px">FHSS</th>
                                                        <th style="text-align: center; min-width: 100px">GSR</th>
                                                        <th style="text-align: center; min-width: 100px">Total</th>

                                                        <th style="text-align: center; min-width: 100px">UPLAND</th>
                                                        <th style="text-align: center; min-width: 100px">GRAND TOTAL</th>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                    <%
                                                        ArrayList<GenericObject> planted = (ArrayList<GenericObject>) session.getAttribute("planted");
                                                        for (int a = 0; a < planted.size(); a++) {
                                                    %>
                                                    <tr>
                                                        <td><%=planted.get(a).getAttribute1()%></td>
                                                        <td><%=planted.get(a).getAttribute2()%></td>
                                                        <td><%=planted.get(a).getAttribute3()%></td>
                                                        <td><%=planted.get(a).getAttribute4()%></td>
                                                        <td><%=planted.get(a).getAttribute5()%></td>
                                                        <td><%=planted.get(a).getAttribute6()%></td>
                                                        <td><%=planted.get(a).getAttribute7()%></td>
                                                        <td><%=planted.get(a).getAttribute8()%></td>
                                                        <td><%=planted.get(a).getAttribute9()%></td>
                                                        <td><%=planted.get(a).getAttribute10()%></td>
                                                        <td><%=planted.get(a).getAttribute11()%></td>
                                                        <td><%=planted.get(a).getAttribute12()%></td>
                                                        <td><%=planted.get(a).getAttribute13()%></td>
                                                        <td><%=planted.get(a).getAttribute14()%></td>
                                                        <td><%=planted.get(a).getAttribute15()%></td>
                                                        <td><%=planted.get(a).getAttribute16()%></td>
                                                        <td><%=planted.get(a).getAttribute17()%></td>
                                                        <td><%=planted.get(a).getAttribute18()%></td>
                                                        <td><%=planted.get(a).getAttribute19()%></td>
                                                        <td><%=planted.get(a).getAttribute20()%></td>
                                                        <td><%=planted.get(a).getAttribute21()%></td>
                                                        <td><%=planted.get(a).getAttribute22()%></td>
                                                        <td><%=planted.get(a).getAttribute23()%></td>
                                                        <td><%=planted.get(a).getAttribute24()%></td>
                                                        <td><%=planted.get(a).getAttribute25()%></td>
                                                        <td><%=planted.get(a).getAttribute26()%></td>
                                                        <td><%=planted.get(a).getAttribute27()%></td>
                                                        <td><%=planted.get(a).getAttribute28()%></td>
                                                        <td><%=planted.get(a).getAttribute29()%></td>
                                                        <td><%=planted.get(a).getAttribute30()%></td>
                                                        <td><%=planted.get(a).getAttribute31()%></td>
                                                        <td><%=planted.get(a).getAttribute32()%></td>
                                                        <td><%=planted.get(a).getAttribute33()%></td>
                                                        <td><%=planted.get(a).getAttribute34()%></td>
                                                        <td><%=planted.get(a).getAttribute35()%></td>
                                                        <td><%=planted.get(a).getAttribute36()%></td>
                                                        <td><%=planted.get(a).getAttribute37()%></td>
                                                        <td><%=planted.get(a).getAttribute38()%></td>
                                                        <td><%=planted.get(a).getAttribute39()%></td>
                                                        <td><%=planted.get(a).getAttribute40()%></td>
                                                        <td><%=planted.get(a).getAttribute41()%></td>
                                                        <td><%=planted.get(a).getAttribute42()%></td>
                                                        <td><%=planted.get(a).getAttribute43()%></td>
                                                        <td><%=planted.get(a).getAttribute44()%></td>
                                                        <td><%=planted.get(a).getAttribute45()%></td>
                                                        <td><%=planted.get(a).getAttribute46()%></td>
                                                        <td><%=planted.get(a).getAttribute47()%></td>
                                                        <td><%=planted.get(a).getAttribute48()%></td>
                                                        <td><%=planted.get(a).getAttribute49()%></td>
                                                        <td><%=planted.get(a).getAttribute50()%></td>
                                                        <td><%=planted.get(a).getAttribute51()%></td>
                                                        <td><%=planted.get(a).getAttribute52()%></td>
                                                        <td><%=planted.get(a).getAttribute53()%></td>
                                                        <td><%=planted.get(a).getAttribute54()%></td>
                                                        <td><%=planted.get(a).getAttribute55()%></td>
                                                        <td><%=planted.get(a).getAttribute56()%></td>
                                                        <td><%=planted.get(a).getAttribute57()%></td>
                                                        <td><%=planted.get(a).getAttribute58()%></td>
                                                        <td><%=planted.get(a).getAttribute59()%></td>
                                                        <td><%=planted.get(a).getAttribute60()%></td>
                                                        <td><%=planted.get(a).getAttribute61()%></td>
                                                        <td><%=planted.get(a).getAttribute62()%></td>
                                                        <td><%=planted.get(a).getAttribute63()%></td>
                                                        <td><%=planted.get(a).getAttribute64()%></td>
                                                        <td><%=planted.get(a).getAttribute65()%></td>
                                                        <td><%=planted.get(a).getAttribute66()%></td>
                                                        <td><%=planted.get(a).getAttribute67()%></td>
                                                        <td><%=planted.get(a).getAttribute68()%></td>
                                                        <td><%=planted.get(a).getAttribute69()%></td>
                                                        <td><%=planted.get(a).getAttribute70()%></td>
                                                        <td><%=planted.get(a).getAttribute71()%></td>
                                                        <td><%=planted.get(a).getAttribute72()%></td>
                                                        <td><%=planted.get(a).getAttribute73()%></td>
                                                    </tr>
                                                    <%
                                                        }
                                                    %>
                                                </tbody>
                                            </table>
                                        </div>
                                        <!--end: irrigated-->
                                    </div>

                                    <div role="tabpanel" class="tab-pane fade" id="tab_content2" aria-labelledby="rainfed-tab">
                                        <!--rainfed-->
                                        <div class="report-table">
                                            <table class="table table-bordered"">
                                                <thead>
                                                    <tr>
                                                        <th></th>
                                                        <th style="text-align: center" colspan="22">Irrigated</th>
                                                        <th colspan="2"></th>
                                                        <th style="text-align: center" colspan="22">Rainfed</th>
                                                        <th colspan="2"></th>
                                                        <th style="text-align: center" colspan="22">Total</th>
                                                        <th colspan="2"></th>
                                                    </tr>
                                                    <tr>
                                                        <th></th>
                                                        <th style="text-align: center" colspan="6">Hybrid</th>
                                                        <th style="text-align: center" colspan="5">Registered Seed</th>
                                                        <th style="text-align: center" colspan="6">Certified Seed</th>
                                                        <th style="text-align: center" colspan="5">Good Seed</th>
                                                        <th colspan="2"></th>
                                                        <th style="text-align: center" colspan="6">Hybrid</th>
                                                        <th style="text-align: center" colspan="5">Registered Seed</th>
                                                        <th style="text-align: center" colspan="6">Certified Seed</th>
                                                        <th style="text-align: center" colspan="5">Good Seed</th>
                                                        <th colspan="2"></th>
                                                        <th style="text-align: center" colspan="6">Hybrid</th>
                                                        <th style="text-align: center" colspan="5">Registered Seed</th>
                                                        <th style="text-align: center" colspan="6">Certified Seed</th>
                                                        <th style="text-align: center" colspan="5">Good Seed</th>
                                                        <th colspan="2"></th>
                                                    </tr>
                                                    <tr>
                                                        <th style="text-align: center; min-width: 150px">Municipal</th>

                                                        <th style="text-align: center; min-width: 100px">HYTA Program</th>
                                                        <th style="text-align: center; min-width: 100px">HYTA Demo</th>
                                                        <th style="text-align: center; min-width: 100px">Direct Purchase</th>
                                                        <th style="text-align: center; min-width: 100px">MTD/PTD/Cluster</th>
                                                        <th style="text-align: center; min-width: 100px">PLGU/MLGU</th>
                                                        <th style="text-align: center; min-width: 100px">Total</th>

                                                        <th style="text-align: center; min-width: 100px">CSB</th>
                                                        <th style="text-align: center; min-width: 100px">SG</th>
                                                        <th style="text-align: center; min-width: 100px">MTD</th>
                                                        <th style="text-align: center; min-width: 100px">Others</th>
                                                        <th style="text-align: center; min-width: 100px">Total</th>

                                                        <th style="text-align: center; min-width: 100px">Rehab</th>
                                                        <th style="text-align: center; min-width: 100px">3rd Crop</th>
                                                        <th style="text-align: center; min-width: 100px">MLGU/ PLGU</th>
                                                        <th style="text-align: center; min-width: 100px">Direct Purchased</th>
                                                        <th style="text-align: center; min-width: 100px">Others</th>
                                                        <th style="text-align: center; min-width: 100px">Total</th>
                                                        <th style="text-align: center; min-width: 100px">HQS (from CSB)</th>
                                                        <th style="text-align: center; min-width: 100px">HQS (from untagged)</th>
                                                        <th style="text-align: center; min-width: 100px">FHSS</th>
                                                        <th style="text-align: center; min-width: 100px">GSR</th>
                                                        <th style="text-align: center; min-width: 100px">Total</th>

                                                        <th style="text-align: center; min-width: 100px">UPLAND</th>
                                                        <th style="text-align: center; min-width: 100px">GRAND TOTAL</th>

                                                        <th style="text-align: center; min-width: 100px">HYTA Program</th>
                                                        <th style="text-align: center; min-width: 100px">HYTA Demo</th>
                                                        <th style="text-align: center; min-width: 100px">Direct Purchase</th>
                                                        <th style="text-align: center; min-width: 100px">MTD/PTD/Cluster</th>
                                                        <th style="text-align: center; min-width: 100px">PLGU/MLGU</th>
                                                        <th style="text-align: center; min-width: 100px">Total</th>

                                                        <th style="text-align: center; min-width: 100px">CSB</th>
                                                        <th style="text-align: center; min-width: 100px">SG</th>
                                                        <th style="text-align: center; min-width: 100px">MTD</th>
                                                        <th style="text-align: center; min-width: 100px">Others</th>
                                                        <th style="text-align: center; min-width: 100px">Total</th>

                                                        <th style="text-align: center; min-width: 100px">Rehab</th>
                                                        <th style="text-align: center; min-width: 100px">3rd Crop</th>
                                                        <th style="text-align: center; min-width: 100px">MLGU/ PLGU</th>
                                                        <th style="text-align: center; min-width: 100px">Direct Purchased</th>
                                                        <th style="text-align: center; min-width: 100px">Others</th>
                                                        <th style="text-align: center; min-width: 100px">Total</th>
                                                        <th style="text-align: center; min-width: 100px">HQS (from CSB)</th>
                                                        <th style="text-align: center; min-width: 100px">HQS (from untagged)</th>
                                                        <th style="text-align: center; min-width: 100px">FHSS</th>
                                                        <th style="text-align: center; min-width: 100px">GSR</th>
                                                        <th style="text-align: center; min-width: 100px">Total</th>

                                                        <th style="text-align: center; min-width: 100px">UPLAND</th>
                                                        <th style="text-align: center; min-width: 100px">GRAND TOTAL</th>

                                                        <th style="text-align: center; min-width: 100px">HYTA Program</th>
                                                        <th style="text-align: center; min-width: 100px">HYTA Demo</th>
                                                        <th style="text-align: center; min-width: 100px">Direct Purchase</th>
                                                        <th style="text-align: center; min-width: 100px">MTD/PTD/Cluster</th>
                                                        <th style="text-align: center; min-width: 100px">PLGU/MLGU</th>
                                                        <th style="text-align: center; min-width: 100px">Total</th>

                                                        <th style="text-align: center; min-width: 100px">CSB</th>
                                                        <th style="text-align: center; min-width: 100px">SG</th>
                                                        <th style="text-align: center; min-width: 100px">MTD</th>
                                                        <th style="text-align: center; min-width: 100px">Others</th>
                                                        <th style="text-align: center; min-width: 100px">Total</th>

                                                        <th style="text-align: center; min-width: 100px">Rehab</th>
                                                        <th style="text-align: center; min-width: 100px">3rd Crop</th>
                                                        <th style="text-align: center; min-width: 100px">MLGU/ PLGU</th>
                                                        <th style="text-align: center; min-width: 100px">Direct Purchased</th>
                                                        <th style="text-align: center; min-width: 100px">Others</th>
                                                        <th style="text-align: center; min-width: 100px">Total</th>
                                                        <th style="text-align: center; min-width: 100px">HQS (from CSB)</th>
                                                        <th style="text-align: center; min-width: 100px">HQS (from untagged)</th>
                                                        <th style="text-align: center; min-width: 100px">FHSS</th>
                                                        <th style="text-align: center; min-width: 100px">GSR</th>
                                                        <th style="text-align: center; min-width: 100px">Total</th>

                                                        <th style="text-align: center; min-width: 100px">UPLAND</th>
                                                        <th style="text-align: center; min-width: 100px">GRAND TOTAL</th>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                    <%
                                                        ArrayList<GenericObject> harvested = (ArrayList<GenericObject>) session.getAttribute("harvested");
                                                        for (int a = 0; a < harvested.size(); a++) {
                                                    %>
                                                    <tr>
                                                        <td><%=harvested.get(a).getAttribute1()%></td>
                                                        <td><%=harvested.get(a).getAttribute2()%></td>
                                                        <td><%=harvested.get(a).getAttribute3()%></td>
                                                        <td><%=harvested.get(a).getAttribute4()%></td>
                                                        <td><%=harvested.get(a).getAttribute5()%></td>
                                                        <td><%=harvested.get(a).getAttribute6()%></td>
                                                        <td><%=harvested.get(a).getAttribute7()%></td>
                                                        <td><%=harvested.get(a).getAttribute8()%></td>
                                                        <td><%=harvested.get(a).getAttribute9()%></td>
                                                        <td><%=harvested.get(a).getAttribute10()%></td>
                                                        <td><%=harvested.get(a).getAttribute11()%></td>
                                                        <td><%=harvested.get(a).getAttribute12()%></td>
                                                        <td><%=harvested.get(a).getAttribute13()%></td>
                                                        <td><%=harvested.get(a).getAttribute14()%></td>
                                                        <td><%=harvested.get(a).getAttribute15()%></td>
                                                        <td><%=harvested.get(a).getAttribute16()%></td>
                                                        <td><%=harvested.get(a).getAttribute17()%></td>
                                                        <td><%=harvested.get(a).getAttribute18()%></td>
                                                        <td><%=harvested.get(a).getAttribute19()%></td>
                                                        <td><%=harvested.get(a).getAttribute20()%></td>
                                                        <td><%=harvested.get(a).getAttribute21()%></td>
                                                        <td><%=harvested.get(a).getAttribute22()%></td>
                                                        <td><%=harvested.get(a).getAttribute23()%></td>
                                                        <td><%=harvested.get(a).getAttribute24()%></td>
                                                        <td><%=harvested.get(a).getAttribute25()%></td>
                                                        <td><%=harvested.get(a).getAttribute26()%></td>
                                                        <td><%=harvested.get(a).getAttribute27()%></td>
                                                        <td><%=harvested.get(a).getAttribute28()%></td>
                                                        <td><%=harvested.get(a).getAttribute29()%></td>
                                                        <td><%=harvested.get(a).getAttribute30()%></td>
                                                        <td><%=harvested.get(a).getAttribute31()%></td>
                                                        <td><%=harvested.get(a).getAttribute32()%></td>
                                                        <td><%=harvested.get(a).getAttribute33()%></td>
                                                        <td><%=harvested.get(a).getAttribute34()%></td>
                                                        <td><%=harvested.get(a).getAttribute35()%></td>
                                                        <td><%=harvested.get(a).getAttribute36()%></td>
                                                        <td><%=harvested.get(a).getAttribute37()%></td>
                                                        <td><%=harvested.get(a).getAttribute38()%></td>
                                                        <td><%=harvested.get(a).getAttribute39()%></td>
                                                        <td><%=harvested.get(a).getAttribute40()%></td>
                                                        <td><%=harvested.get(a).getAttribute41()%></td>
                                                        <td><%=harvested.get(a).getAttribute42()%></td>
                                                        <td><%=harvested.get(a).getAttribute43()%></td>
                                                        <td><%=harvested.get(a).getAttribute44()%></td>
                                                        <td><%=harvested.get(a).getAttribute45()%></td>
                                                        <td><%=harvested.get(a).getAttribute46()%></td>
                                                        <td><%=harvested.get(a).getAttribute47()%></td>
                                                        <td><%=harvested.get(a).getAttribute48()%></td>
                                                        <td><%=harvested.get(a).getAttribute49()%></td>
                                                        <td><%=harvested.get(a).getAttribute50()%></td>
                                                        <td><%=harvested.get(a).getAttribute51()%></td>
                                                        <td><%=harvested.get(a).getAttribute52()%></td>
                                                        <td><%=harvested.get(a).getAttribute53()%></td>
                                                        <td><%=harvested.get(a).getAttribute54()%></td>
                                                        <td><%=harvested.get(a).getAttribute55()%></td>
                                                        <td><%=harvested.get(a).getAttribute56()%></td>
                                                        <td><%=harvested.get(a).getAttribute57()%></td>
                                                        <td><%=harvested.get(a).getAttribute58()%></td>
                                                        <td><%=harvested.get(a).getAttribute59()%></td>
                                                        <td><%=harvested.get(a).getAttribute60()%></td>
                                                        <td><%=harvested.get(a).getAttribute61()%></td>
                                                        <td><%=harvested.get(a).getAttribute62()%></td>
                                                        <td><%=harvested.get(a).getAttribute63()%></td>
                                                        <td><%=harvested.get(a).getAttribute64()%></td>
                                                        <td><%=harvested.get(a).getAttribute65()%></td>
                                                        <td><%=harvested.get(a).getAttribute66()%></td>
                                                        <td><%=harvested.get(a).getAttribute67()%></td>
                                                        <td><%=harvested.get(a).getAttribute68()%></td>
                                                        <td><%=harvested.get(a).getAttribute69()%></td>
                                                        <td><%=harvested.get(a).getAttribute70()%></td>
                                                        <td><%=harvested.get(a).getAttribute71()%></td>
                                                        <td><%=harvested.get(a).getAttribute72()%></td>
                                                        <td><%=harvested.get(a).getAttribute73()%></td>
                                                    </tr>
                                                    <%
                                                        }
                                                    %>
                                                </tbody>
                                            </table>
                                        </div>
                                        <!--end: rainfed-->
                                    </div>

                                    <div role="tabpanel" class="tab-pane fade" id="tab_content3" aria-labelledby="total-tab">
                                        <!--total-->
                                        <div class="report-table">
                                            <table class="table table-bordered"">
                                                <thead>
                                                    <tr>
                                                        <th></th>
                                                        <th style="text-align: center" colspan="22">Irrigated</th>
                                                        <th colspan="2"></th>
                                                        <th style="text-align: center" colspan="22">Rainfed</th>
                                                        <th colspan="2"></th>
                                                        <th style="text-align: center" colspan="22">Total</th>
                                                        <th colspan="2"></th>
                                                    </tr>
                                                    <tr>
                                                        <th></th>
                                                        <th style="text-align: center" colspan="6">Hybrid</th>
                                                        <th style="text-align: center" colspan="5">Registered Seed</th>
                                                        <th style="text-align: center" colspan="6">Certified Seed</th>
                                                        <th style="text-align: center" colspan="5">Good Seed</th>
                                                        <th colspan="2"></th>
                                                        <th style="text-align: center" colspan="6">Hybrid</th>
                                                        <th style="text-align: center" colspan="5">Registered Seed</th>
                                                        <th style="text-align: center" colspan="6">Certified Seed</th>
                                                        <th style="text-align: center" colspan="5">Good Seed</th>
                                                        <th colspan="2"></th>
                                                        <th style="text-align: center" colspan="6">Hybrid</th>
                                                        <th style="text-align: center" colspan="5">Registered Seed</th>
                                                        <th style="text-align: center" colspan="6">Certified Seed</th>
                                                        <th style="text-align: center" colspan="5">Good Seed</th>
                                                        <th colspan="2"></th>
                                                    </tr>
                                                    <tr>
                                                        <th style="text-align: center; min-width: 150px">Municipal</th>

                                                        <th style="text-align: center; min-width: 100px">HYTA Program</th>
                                                        <th style="text-align: center; min-width: 100px">HYTA Demo</th>
                                                        <th style="text-align: center; min-width: 100px">Direct Purchase</th>
                                                        <th style="text-align: center; min-width: 100px">MTD/PTD/Cluster</th>
                                                        <th style="text-align: center; min-width: 100px">PLGU/MLGU</th>
                                                        <th style="text-align: center; min-width: 100px">Total</th>

                                                        <th style="text-align: center; min-width: 100px">CSB</th>
                                                        <th style="text-align: center; min-width: 100px">SG</th>
                                                        <th style="text-align: center; min-width: 100px">MTD</th>
                                                        <th style="text-align: center; min-width: 100px">Others</th>
                                                        <th style="text-align: center; min-width: 100px">Total</th>

                                                        <th style="text-align: center; min-width: 100px">Rehab</th>
                                                        <th style="text-align: center; min-width: 100px">3rd Crop</th>
                                                        <th style="text-align: center; min-width: 100px">MLGU/ PLGU</th>
                                                        <th style="text-align: center; min-width: 100px">Direct Purchased</th>
                                                        <th style="text-align: center; min-width: 100px">Others</th>
                                                        <th style="text-align: center; min-width: 100px">Total</th>
                                                        <th style="text-align: center; min-width: 100px">HQS (from CSB)</th>
                                                        <th style="text-align: center; min-width: 100px">HQS (from untagged)</th>
                                                        <th style="text-align: center; min-width: 100px">FHSS</th>
                                                        <th style="text-align: center; min-width: 100px">GSR</th>
                                                        <th style="text-align: center; min-width: 100px">Total</th>

                                                        <th style="text-align: center; min-width: 100px">UPLAND</th>
                                                        <th style="text-align: center; min-width: 100px">GRAND TOTAL</th>

                                                        <th style="text-align: center; min-width: 100px">HYTA Program</th>
                                                        <th style="text-align: center; min-width: 100px">HYTA Demo</th>
                                                        <th style="text-align: center; min-width: 100px">Direct Purchase</th>
                                                        <th style="text-align: center; min-width: 100px">MTD/PTD/Cluster</th>
                                                        <th style="text-align: center; min-width: 100px">PLGU/MLGU</th>
                                                        <th style="text-align: center; min-width: 100px">Total</th>

                                                        <th style="text-align: center; min-width: 100px">CSB</th>
                                                        <th style="text-align: center; min-width: 100px">SG</th>
                                                        <th style="text-align: center; min-width: 100px">MTD</th>
                                                        <th style="text-align: center; min-width: 100px">Others</th>
                                                        <th style="text-align: center; min-width: 100px">Total</th>

                                                        <th style="text-align: center; min-width: 100px">Rehab</th>
                                                        <th style="text-align: center; min-width: 100px">3rd Crop</th>
                                                        <th style="text-align: center; min-width: 100px">MLGU/ PLGU</th>
                                                        <th style="text-align: center; min-width: 100px">Direct Purchased</th>
                                                        <th style="text-align: center; min-width: 100px">Others</th>
                                                        <th style="text-align: center; min-width: 100px">Total</th>
                                                        <th style="text-align: center; min-width: 100px">HQS (from CSB)</th>
                                                        <th style="text-align: center; min-width: 100px">HQS (from untagged)</th>
                                                        <th style="text-align: center; min-width: 100px">FHSS</th>
                                                        <th style="text-align: center; min-width: 100px">GSR</th>
                                                        <th style="text-align: center; min-width: 100px">Total</th>

                                                        <th style="text-align: center; min-width: 100px">UPLAND</th>
                                                        <th style="text-align: center; min-width: 100px">GRAND TOTAL</th>

                                                        <th style="text-align: center; min-width: 100px">HYTA Program</th>
                                                        <th style="text-align: center; min-width: 100px">HYTA Demo</th>
                                                        <th style="text-align: center; min-width: 100px">Direct Purchase</th>
                                                        <th style="text-align: center; min-width: 100px">MTD/PTD/Cluster</th>
                                                        <th style="text-align: center; min-width: 100px">PLGU/MLGU</th>
                                                        <th style="text-align: center; min-width: 100px">Total</th>

                                                        <th style="text-align: center; min-width: 100px">CSB</th>
                                                        <th style="text-align: center; min-width: 100px">SG</th>
                                                        <th style="text-align: center; min-width: 100px">MTD</th>
                                                        <th style="text-align: center; min-width: 100px">Others</th>
                                                        <th style="text-align: center; min-width: 100px">Total</th>

                                                        <th style="text-align: center; min-width: 100px">Rehab</th>
                                                        <th style="text-align: center; min-width: 100px">3rd Crop</th>
                                                        <th style="text-align: center; min-width: 100px">MLGU/ PLGU</th>
                                                        <th style="text-align: center; min-width: 100px">Direct Purchased</th>
                                                        <th style="text-align: center; min-width: 100px">Others</th>
                                                        <th style="text-align: center; min-width: 100px">Total</th>
                                                        <th style="text-align: center; min-width: 100px">HQS (from CSB)</th>
                                                        <th style="text-align: center; min-width: 100px">HQS (from untagged)</th>
                                                        <th style="text-align: center; min-width: 100px">FHSS</th>
                                                        <th style="text-align: center; min-width: 100px">GSR</th>
                                                        <th style="text-align: center; min-width: 100px">Total</th>

                                                        <th style="text-align: center; min-width: 100px">UPLAND</th>
                                                        <th style="text-align: center; min-width: 100px">GRAND TOTAL</th>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                    <%
                                                        ArrayList<GenericObject> damaged = (ArrayList<GenericObject>) session.getAttribute("damaged");
                                                        for (int a = 0; a < damaged.size(); a++) {
                                                    %>
                                                    <tr>
                                                        <td><%=damaged.get(a).getAttribute1()%></td>
                                                        <td><%=damaged.get(a).getAttribute2()%></td>
                                                        <td><%=damaged.get(a).getAttribute3()%></td>
                                                        <td><%=damaged.get(a).getAttribute4()%></td>
                                                        <td><%=damaged.get(a).getAttribute5()%></td>
                                                        <td><%=damaged.get(a).getAttribute6()%></td>
                                                        <td><%=damaged.get(a).getAttribute7()%></td>
                                                        <td><%=damaged.get(a).getAttribute8()%></td>
                                                        <td><%=damaged.get(a).getAttribute9()%></td>
                                                        <td><%=damaged.get(a).getAttribute10()%></td>
                                                        <td><%=damaged.get(a).getAttribute11()%></td>
                                                        <td><%=damaged.get(a).getAttribute12()%></td>
                                                        <td><%=damaged.get(a).getAttribute13()%></td>
                                                        <td><%=damaged.get(a).getAttribute14()%></td>
                                                        <td><%=damaged.get(a).getAttribute15()%></td>
                                                        <td><%=damaged.get(a).getAttribute16()%></td>
                                                        <td><%=damaged.get(a).getAttribute17()%></td>
                                                        <td><%=damaged.get(a).getAttribute18()%></td>
                                                        <td><%=damaged.get(a).getAttribute19()%></td>
                                                        <td><%=damaged.get(a).getAttribute20()%></td>
                                                        <td><%=damaged.get(a).getAttribute21()%></td>
                                                        <td><%=damaged.get(a).getAttribute22()%></td>
                                                        <td><%=damaged.get(a).getAttribute23()%></td>
                                                        <td><%=damaged.get(a).getAttribute24()%></td>
                                                        <td><%=damaged.get(a).getAttribute25()%></td>
                                                        <td><%=damaged.get(a).getAttribute26()%></td>
                                                        <td><%=damaged.get(a).getAttribute27()%></td>
                                                        <td><%=damaged.get(a).getAttribute28()%></td>
                                                        <td><%=damaged.get(a).getAttribute29()%></td>
                                                        <td><%=damaged.get(a).getAttribute30()%></td>
                                                        <td><%=damaged.get(a).getAttribute31()%></td>
                                                        <td><%=damaged.get(a).getAttribute32()%></td>
                                                        <td><%=damaged.get(a).getAttribute33()%></td>
                                                        <td><%=damaged.get(a).getAttribute34()%></td>
                                                        <td><%=damaged.get(a).getAttribute35()%></td>
                                                        <td><%=damaged.get(a).getAttribute36()%></td>
                                                        <td><%=damaged.get(a).getAttribute37()%></td>
                                                        <td><%=damaged.get(a).getAttribute38()%></td>
                                                        <td><%=damaged.get(a).getAttribute39()%></td>
                                                        <td><%=damaged.get(a).getAttribute40()%></td>
                                                        <td><%=damaged.get(a).getAttribute41()%></td>
                                                        <td><%=damaged.get(a).getAttribute42()%></td>
                                                        <td><%=damaged.get(a).getAttribute43()%></td>
                                                        <td><%=damaged.get(a).getAttribute44()%></td>
                                                        <td><%=damaged.get(a).getAttribute45()%></td>
                                                        <td><%=damaged.get(a).getAttribute46()%></td>
                                                        <td><%=damaged.get(a).getAttribute47()%></td>
                                                        <td><%=damaged.get(a).getAttribute48()%></td>
                                                        <td><%=damaged.get(a).getAttribute49()%></td>
                                                        <td><%=damaged.get(a).getAttribute50()%></td>
                                                        <td><%=damaged.get(a).getAttribute51()%></td>
                                                        <td><%=damaged.get(a).getAttribute52()%></td>
                                                        <td><%=damaged.get(a).getAttribute53()%></td>
                                                        <td><%=damaged.get(a).getAttribute54()%></td>
                                                        <td><%=damaged.get(a).getAttribute55()%></td>
                                                        <td><%=damaged.get(a).getAttribute56()%></td>
                                                        <td><%=damaged.get(a).getAttribute57()%></td>
                                                        <td><%=damaged.get(a).getAttribute58()%></td>
                                                        <td><%=damaged.get(a).getAttribute59()%></td>
                                                        <td><%=damaged.get(a).getAttribute60()%></td>
                                                        <td><%=damaged.get(a).getAttribute61()%></td>
                                                        <td><%=damaged.get(a).getAttribute62()%></td>
                                                        <td><%=damaged.get(a).getAttribute63()%></td>
                                                        <td><%=damaged.get(a).getAttribute64()%></td>
                                                        <td><%=damaged.get(a).getAttribute65()%></td>
                                                        <td><%=damaged.get(a).getAttribute66()%></td>
                                                        <td><%=damaged.get(a).getAttribute67()%></td>
                                                        <td><%=damaged.get(a).getAttribute68()%></td>
                                                        <td><%=damaged.get(a).getAttribute69()%></td>
                                                        <td><%=damaged.get(a).getAttribute70()%></td>
                                                        <td><%=damaged.get(a).getAttribute71()%></td>
                                                        <td><%=damaged.get(a).getAttribute72()%></td>
                                                        <td><%=damaged.get(a).getAttribute73()%></td>
                                                    </tr>
                                                    <%
                                                        }
                                                    %>
                                                </tbody>
                                            </table>
                                        </div>
                                        <!--end: total-->
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
        </div>

        <!-- jQuery -->
        <script src="/BIGAS/vendors/jquery/dist/jquery.min.js"></script>
        <!-- Bootstrap -->
        <script src="/BIGAS/vendors/bootstrap/dist/js/bootstrap.min.js"></script>
        <!-- FastClick -->
        <script src="/BIGAS/vendors/fastclick/lib/fastclick.js"></script>
        <!-- NProgress -->
        <script src="/BIGAS/vendors/nprogress/nprogress.js"></script>
        <!-- Chart.js -->
        <script src="/BIGAS/vendors/Chart.js/dist/Chart.min.js"></script>
        <!-- gauge.js -->
        <script src="/BIGAS/vendors/bernii/gauge.js/dist/gauge.min.js"></script>
        <!-- bootstrap-progressbar -->
        <script src="/BIGAS/vendors/bootstrap-progressbar/bootstrap-progressbar.min.js"></script>
        <!-- iCheck -->
        <script src="/BIGAS/vendors/iCheck/icheck.min.js"></script>

        <!-- Custom Theme Scripts -->
        <script src="/BIGAS/build/js/custom.min.js"></script>
    </body>
</html>

