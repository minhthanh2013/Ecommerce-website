<%@ page import="java.security.Security" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html class="no-js" lang="en">
<head>
    <meta charset="UTF-8">
    <!--[if IE]><meta http-equiv="X-UA-Compatible" content="IE=edge"><![endif]-->
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link href="${pageContext.request.contextPath}/resources/images/favicon.png" rel="shortcut icon">
    <title>Ludus - Electronics, Apparel, Computers, Books, DVDs & more</title>

    <!--====== Google Font ======-->
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:400,600,700,800" rel="stylesheet">

    <!--====== Vendor Css ======-->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/vendor.css">

    <!--====== Utility-Spacing ======-->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/utility.css">

    <!--====== App ======-->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/app.css">

</head>
<body class="config">
    <div class="preloader is-active">
        <div class="preloader__wrap">

            <img class="preloader__img" src="${pageContext.request.contextPath}/resources/images/preloader.png" alt=""></div>
    </div>

    <!--====== Main App ======-->
    <div id="app">

        <!--====== Main Header ======-->
        <header class="header--style-1">

            <!--====== Nav 1 ======-->
            <nav class="primary-nav primary-nav-wrapper--border">
                <div class="container">

                    <!--====== Primary Nav ======-->
                    <div class="primary-nav">

                        <!--====== Main Logo ======-->

                        <a class="main-logo" href="index.jsp">

                            <img src="${pageContext.request.contextPath}/resources/images/logo/logo-1.png" alt=""></a>
                        <!--====== End - Main Logo ======-->


                        <!--====== Search Form ======-->
                        <form class="main-form" action="${pageContext.request.contextPath}/product" method="get">

                            <label for="main-search"></label>

                            <input class="input-text input-text--border-radius input-text--style-1" type="text" id="main-search" placeholder="Search" name="name">

                            <button class="btn btn--icon fas fa-search main-search-button" type="submit"></button></form>
                        <!--====== End - Search Form ======-->


                        <!--====== Dropdown Main plugin ======-->
                        <div class="menu-init" id="navigation">

                            <button class="btn btn--icon toggle-button toggle-button--secondary fas fa-cogs" type="button"></button>

                            <!--====== Menu ======-->
                            <div class="ah-lg-mode">

                                <span class="ah-close">✕ Close</span>

                                <!--====== List ======-->
                                <ul class="ah-list ah-list--design1 ah-list--link-color-secondary">
                                    <li class="has-dropdown" data-tooltip="tooltip" data-placement="left" title="Account">

                                        <a><i class="far fa-user-circle"></i></a>

                                        <!--====== Dropdown ======-->

                                        <span class="js-menu-toggle"></span>
                                        <ul style="width:120px">
                                            <security:authorize access="isAuthenticated()" >
                                            <li>

                                                <a href="${pageContext.request.contextPath}/dashboard/"><i class="fas fa-user-circle u-s-m-r-6"></i>

                                                    <span>Account</span></a></li>
                                            </security:authorize>
                                            <security:authorize access="isAnonymous()">


                                            <li>
                                                <a href="${pageContext.request.contextPath}/register"><i class="fas fa-user-plus u-s-m-r-6"></i>
                                                    <span>Signup</span></a></li>
                                            <li>

                                                <a href="${pageContext.request.contextPath}/login"><i class="fas fa-lock u-s-m-r-6"></i>

                                                    <span>Signin</span></a></li>
                                            </security:authorize>
                                            <security:authorize access="isAuthenticated()">
                                                <form:form action="${pageContext.request.contextPath}/logout"
                                                           method="post" id="sign-out-form">
                                                    <li>

                                                        <a id="sign-out-btt" href="#"><i class="fas fa-lock-open u-s-m-r-6 sign-out-btt-1"></i>
                                                            <span>Signout</span></a>
                                                            <%--                                                    <input type="submit" value="Logout" /><i class="fas fa-lock-open u-s-m-r-6"></i>--%>
                                                            <%--                                                    <span>Signout</span></a></li>--%>

                                                    </li>
                                                </form:form>
                                            </security:authorize>

                                        </ul>
                                        <!--====== End - Dropdown ======-->
                                    </li>
                                    <li class="has-dropdown" data-tooltip="tooltip" data-placement="left" title="Settings">

                                        <a><i class="fas fa-user-cog"></i></a>

                                        <!--====== Dropdown ======-->

                                        <span class="js-menu-toggle"></span>
                                        <ul style="width:120px">
                                            <li class="has-dropdown has-dropdown--ul-right-100">

                                                <a>Language<i class="fas fa-angle-down u-s-m-l-6"></i></a>

                                                <!--====== Dropdown ======-->

                                                <span class="js-menu-toggle"></span>
                                                <ul style="width:120px">
                                                    <li>

                                                        <a class="u-c-brand">ENGLISH</a></li>
                                                    <li>

                                                        <a>ARABIC</a></li>
                                                    <li>

                                                        <a>FRANCAIS</a></li>
                                                    <li>

                                                        <a>ESPANOL</a></li>
                                                </ul>
                                                <!--====== End - Dropdown ======-->
                                            </li>
                                            <li class="has-dropdown has-dropdown--ul-right-100">

                                                <a>Currency<i class="fas fa-angle-down u-s-m-l-6"></i></a>

                                                <!--====== Dropdown ======-->

                                                <span class="js-menu-toggle"></span>
                                                <ul style="width:225px">
                                                    <li>

                                                        <a class="u-c-brand">$ - US DOLLAR</a></li>
                                                    <li>

                                                        <a>£ - BRITISH POUND STERLING</a></li>
                                                    <li>

                                                        <a>€ - EURO</a></li>
                                                </ul>
                                                <!--====== End - Dropdown ======-->
                                            </li>
                                        </ul>
                                        <!--====== End - Dropdown ======-->
                                    </li>
                                    <li data-tooltip="tooltip" data-placement="left" title="Contact">

                                        <a href="tel:+0900901904"><i class="fas fa-phone-volume"></i></a></li>
                                    <li data-tooltip="tooltip" data-placement="left" title="Mail">

                                        <a href="mailto:contact@domain.com"><i class="far fa-envelope"></i></a></li>
                                </ul>
                                <!--====== End - List ======-->
                            </div>
                            <!--====== End - Menu ======-->
                        </div>
                        <!--====== End - Dropdown Main plugin ======-->
                    </div>
                    <!--====== End - Primary Nav ======-->
                </div>
            </nav>
            <!--====== End - Nav 1 ======-->


            <!--====== Nav 2 ======-->
            <nav class="secondary-nav-wrapper">
                <div class="container">

                    <!--====== Secondary Nav ======-->
                    <div class="secondary-nav">

                        <!--====== Dropdown Main plugin ======-->
                        <div class="menu-init" id="navigation1">

                            <button class="btn btn--icon toggle-mega-text toggle-button" type="button">M</button>

                            <!--====== Menu ======-->
                            <div class="ah-lg-mode">

                                <span class="ah-close">✕ Close</span>

                                <!--====== List ======-->
                                <ul class="ah-list">
                                    <li class="has-dropdown">

                                        <span class="mega-text">M</span>

                                        <!--====== Mega Menu ======-->

                                        <span class="js-menu-toggle"></span>
                                        <div class="mega-menu">
                                            <div class="mega-menu-wrap">
                                                <div class="mega-menu-list">
                                                    <ul>
                                                        <li class="js-active">

                                                            <a href="shop-side-version-2.html"><i class="fas fa-tv u-s-m-r-6"></i>

                                                                <span>Electronics</span></a>

                                                            <span class="js-menu-toggle js-toggle-mark"></span></li>
                                                        <li>

                                                            <a href="shop-side-version-2.html"><i class="fas fa-female u-s-m-r-6"></i>

                                                                <span>Women's Clothing</span></a>

                                                            <span class="js-menu-toggle"></span></li>
                                                        <li>

                                                            <a href="shop-side-version-2.html"><i class="fas fa-male u-s-m-r-6"></i>

                                                                <span>Men's Clothing</span></a>

                                                            <span class="js-menu-toggle"></span></li>
                                                        <li>

                                                            <a href="index.jsp"><i class="fas fa-utensils u-s-m-r-6"></i>

                                                                <span>Food & Supplies</span></a>

                                                            <span class="js-menu-toggle"></span></li>
                                                        <li>

                                                            <a href="index.jsp"><i class="fas fa-couch u-s-m-r-6"></i>

                                                                <span>Furniture & Decor</span></a>

                                                            <span class="js-menu-toggle"></span></li>
                                                        <li>

                                                            <a href="index.jsp"><i class="fas fa-football-ball u-s-m-r-6"></i>

                                                                <span>Sports & Game</span></a>

                                                            <span class="js-menu-toggle"></span></li>
                                                        <li>

                                                            <a href="index.jsp"><i class="fas fa-heartbeat u-s-m-r-6"></i>

                                                                <span>Beauty & Health</span></a>

                                                            <span class="js-menu-toggle"></span></li>
                                                    </ul>
                                                </div>

                                                <!--====== Electronics ======-->
                                                <div class="mega-menu-content js-active">

                                                    <!--====== Mega Menu Row ======-->
                                                    <div class="row">
                                                        <div class="col-lg-3">
                                                            <ul>
                                                                <li class="mega-list-title">

                                                                    <a href="shop-side-version-2.html">3D PRINTER & SUPPLIES</a></li>
                                                                <li>

                                                                    <a href="shop-side-version-2.html">3d Printer</a></li>
                                                                <li>

                                                                    <a href="shop-side-version-2.html">3d Printing Pen</a></li>
                                                                <li>

                                                                    <a href="shop-side-version-2.html">3d Printing Accessories</a></li>
                                                                <li>

                                                                    <a href="shop-side-version-2.html">3d Printer Module Board</a></li>
                                                            </ul>
                                                        </div>
                                                        <div class="col-lg-3">
                                                            <ul>
                                                                <li class="mega-list-title">

                                                                    <a href="shop-side-version-2.html">HOME AUDIO & VIDEO</a></li>
                                                                <li>

                                                                    <a href="shop-side-version-2.html">TV Boxes</a></li>
                                                                <li>

                                                                    <a href="shop-side-version-2.html">TC Receiver & Accessories</a></li>
                                                                <li>

                                                                    <a href="shop-side-version-2.html">Display Dongle</a></li>
                                                                <li>

                                                                    <a href="shop-side-version-2.html">Home Theater System</a></li>
                                                            </ul>
                                                        </div>
                                                        <div class="col-lg-3">
                                                            <ul>
                                                                <li class="mega-list-title">

                                                                    <a href="shop-side-version-2.html">MEDIA PLAYERS</a></li>
                                                                <li>

                                                                    <a href="shop-side-version-2.html">Earphones</a></li>
                                                                <li>

                                                                    <a href="shop-side-version-2.html">Mp3 Players</a></li>
                                                                <li>

                                                                    <a href="shop-side-version-2.html">Speakers & Radios</a></li>
                                                                <li>

                                                                    <a href="shop-side-version-2.html">Microphones</a></li>
                                                            </ul>
                                                        </div>
                                                        <div class="col-lg-3">
                                                            <ul>
                                                                <li class="mega-list-title">

                                                                    <a href="shop-side-version-2.html">VIDEO GAME ACCESSORIES</a></li>
                                                                <li>

                                                                    <a href="shop-side-version-2.html">Nintendo Video Games Accessories</a></li>
                                                                <li>

                                                                    <a href="shop-side-version-2.html">Sony Video Games Accessories</a></li>
                                                                <li>

                                                                    <a href="shop-side-version-2.html">Xbox Video Games Accessories</a></li>
                                                            </ul>
                                                        </div>
                                                    </div>
                                                    <!--====== End - Mega Menu Row ======-->
                                                    <br>

                                                    <!--====== Mega Menu Row ======-->
                                                    <div class="row">
                                                        <div class="col-lg-3">
                                                            <ul>
                                                                <li class="mega-list-title">

                                                                    <a href="shop-side-version-2.html">SECURITY & PROTECTION</a></li>
                                                                <li>

                                                                    <a href="shop-side-version-2.html">Security Cameras</a></li>
                                                                <li>

                                                                    <a href="shop-side-version-2.html">Alarm System</a></li>
                                                                <li>

                                                                    <a href="shop-side-version-2.html">Security Gadgets</a></li>
                                                                <li>

                                                                    <a href="shop-side-version-2.html">CCTV Security & Accessories</a></li>
                                                            </ul>
                                                        </div>
                                                        <div class="col-lg-3">
                                                            <ul>
                                                                <li class="mega-list-title">

                                                                    <a href="shop-side-version-2.html">PHOTOGRAPHY & CAMERA</a></li>
                                                                <li>

                                                                    <a href="shop-side-version-2.html">Digital Cameras</a></li>
                                                                <li>

                                                                    <a href="shop-side-version-2.html">Sport Camera & Accessories</a></li>
                                                                <li>

                                                                    <a href="shop-side-version-2.html">Camera Accessories</a></li>
                                                                <li>

                                                                    <a href="shop-side-version-2.html">Lenses & Accessories</a></li>
                                                            </ul>
                                                        </div>
                                                        <div class="col-lg-3">
                                                            <ul>
                                                                <li class="mega-list-title">

                                                                    <a href="shop-side-version-2.html">ARDUINO COMPATIBLE</a></li>
                                                                <li>

                                                                    <a href="shop-side-version-2.html">Raspberry Pi & Orange Pi</a></li>
                                                                <li>

                                                                    <a href="shop-side-version-2.html">Module Board</a></li>
                                                                <li>

                                                                    <a href="shop-side-version-2.html">Smart Robot</a></li>
                                                                <li>

                                                                    <a href="shop-side-version-2.html">Board Kits</a></li>
                                                            </ul>
                                                        </div>
                                                        <div class="col-lg-3">
                                                            <ul>
                                                                <li class="mega-list-title">

                                                                    <a href="shop-side-version-2.html">DSLR Camera</a></li>
                                                                <li>

                                                                    <a href="shop-side-version-2.html">Nikon Cameras</a></li>
                                                                <li>

                                                                    <a href="shop-side-version-2.html">Canon Camera</a></li>
                                                                <li>

                                                                    <a href="shop-side-version-2.html">Sony Camera</a></li>
                                                                <li>

                                                                    <a href="shop-side-version-2.html">DSLR Lenses</a></li>
                                                            </ul>
                                                        </div>
                                                    </div>
                                                    <!--====== End - Mega Menu Row ======-->
                                                    <br>

                                                    <!--====== Mega Menu Row ======-->
                                                    <div class="row">
                                                        <div class="col-lg-3">
                                                            <ul>
                                                                <li class="mega-list-title">

                                                                    <a href="shop-side-version-2.html">NECESSARY ACCESSORIES</a></li>
                                                                <li>

                                                                    <a href="shop-side-version-2.html">Flash Cards</a></li>
                                                                <li>

                                                                    <a href="shop-side-version-2.html">Memory Cards</a></li>
                                                                <li>

                                                                    <a href="shop-side-version-2.html">Flash Pins</a></li>
                                                                <li>

                                                                    <a href="shop-side-version-2.html">Compact Discs</a></li>
                                                            </ul>
                                                        </div>
                                                        <div class="col-lg-9 mega-image">
                                                            <div class="mega-banner">

                                                                <a class="u-d-block" href="shop-side-version-2.html">

                                                                    <img class="u-img-fluid u-d-block" src="${pageContext.request.contextPath}/resources/images/banners/banner-mega-0.jpg" alt=""></a></div>
                                                        </div>
                                                    </div>
                                                    <!--====== End - Mega Menu Row ======-->
                                                </div>
                                                <!--====== End - Electronics ======-->


                                                <!--====== Women ======-->
                                                <div class="mega-menu-content">

                                                    <!--====== Mega Menu Row ======-->
                                                    <div class="row">
                                                        <div class="col-lg-6 mega-image">
                                                            <div class="mega-banner">

                                                                <a class="u-d-block" href="shop-side-version-2.html">

                                                                    <img class="u-img-fluid u-d-block" src="${pageContext.request.contextPath}/resources/images/banners/banner-mega-1.jpg" alt=""></a></div>
                                                        </div>
                                                        <div class="col-lg-6 mega-image">
                                                            <div class="mega-banner">

                                                                <a class="u-d-block" href="shop-side-version-2.html">

                                                                    <img class="u-img-fluid u-d-block" src="${pageContext.request.contextPath}/resources/images/banners/banner-mega-2.jpg" alt=""></a></div>
                                                        </div>
                                                    </div>
                                                    <!--====== End - Mega Menu Row ======-->
                                                    <br>

                                                    <!--====== Mega Menu Row ======-->
                                                    <div class="row">
                                                        <div class="col-lg-3">
                                                            <ul>
                                                                <li class="mega-list-title">

                                                                    <a href="shop-side-version-2.html">HOT CATEGORIES</a></li>
                                                                <li>

                                                                    <a href="shop-side-version-2.html">Dresses</a></li>
                                                                <li>

                                                                    <a href="shop-side-version-2.html">Blouses & Shirts</a></li>
                                                                <li>

                                                                    <a href="shop-side-version-2.html">T-shirts</a></li>
                                                                <li>

                                                                    <a href="shop-side-version-2.html">Rompers</a></li>
                                                            </ul>
                                                        </div>
                                                        <div class="col-lg-3">
                                                            <ul>
                                                                <li class="mega-list-title">

                                                                    <a href="shop-side-version-2.html">INTIMATES</a></li>
                                                                <li>

                                                                    <a href="shop-side-version-2.html">Bras</a></li>
                                                                <li>

                                                                    <a href="shop-side-version-2.html">Brief Sets</a></li>
                                                                <li>

                                                                    <a href="shop-side-version-2.html">Bustiers & Corsets</a></li>
                                                                <li>

                                                                    <a href="shop-side-version-2.html">Panties</a></li>
                                                            </ul>
                                                        </div>
                                                        <div class="col-lg-3">
                                                            <ul>
                                                                <li class="mega-list-title">

                                                                    <a href="shop-side-version-2.html">WEDDING & EVENTS</a></li>
                                                                <li>

                                                                    <a href="shop-side-version-2.html">Wedding Dresses</a></li>
                                                                <li>

                                                                    <a href="shop-side-version-2.html">Evening Dresses</a></li>
                                                                <li>

                                                                    <a href="shop-side-version-2.html">Prom Dresses</a></li>
                                                                <li>

                                                                    <a href="shop-side-version-2.html">Flower Dresses</a></li>
                                                            </ul>
                                                        </div>
                                                        <div class="col-lg-3">
                                                            <ul>
                                                                <li class="mega-list-title">

                                                                    <a href="shop-side-version-2.html">BOTTOMS</a></li>
                                                                <li>

                                                                    <a href="shop-side-version-2.html">Skirts</a></li>
                                                                <li>

                                                                    <a href="shop-side-version-2.html">Shorts</a></li>
                                                                <li>

                                                                    <a href="shop-side-version-2.html">Leggings</a></li>
                                                                <li>

                                                                    <a href="shop-side-version-2.html">Jeans</a></li>
                                                            </ul>
                                                        </div>
                                                    </div>
                                                    <!--====== End - Mega Menu Row ======-->
                                                    <br>

                                                    <!--====== Mega Menu Row ======-->
                                                    <div class="row">
                                                        <div class="col-lg-3">
                                                            <ul>
                                                                <li class="mega-list-title">

                                                                    <a href="shop-side-version-2.html">OUTWEAR</a></li>
                                                                <li>

                                                                    <a href="shop-side-version-2.html">Blazers</a></li>
                                                                <li>

                                                                    <a href="shop-side-version-2.html">Basics Jackets</a></li>
                                                                <li>

                                                                    <a href="shop-side-version-2.html">Trench</a></li>
                                                                <li>

                                                                    <a href="shop-side-version-2.html">Leather & Suede</a></li>
                                                            </ul>
                                                        </div>
                                                        <div class="col-lg-3">
                                                            <ul>
                                                                <li class="mega-list-title">

                                                                    <a href="shop-side-version-2.html">JACKETS</a></li>
                                                                <li>

                                                                    <a href="shop-side-version-2.html">Denim Jackets</a></li>
                                                                <li>

                                                                    <a href="shop-side-version-2.html">Trucker Jackets</a></li>
                                                                <li>

                                                                    <a href="shop-side-version-2.html">Windbreaker Jackets</a></li>
                                                                <li>

                                                                    <a href="shop-side-version-2.html">Leather Jackets</a></li>
                                                            </ul>
                                                        </div>
                                                        <div class="col-lg-3">
                                                            <ul>
                                                                <li class="mega-list-title">

                                                                    <a href="shop-side-version-2.html">ACCESSORIES</a></li>
                                                                <li>

                                                                    <a href="shop-side-version-2.html">Tech Accessories</a></li>
                                                                <li>

                                                                    <a href="shop-side-version-2.html">Headwear</a></li>
                                                                <li>

                                                                    <a href="shop-side-version-2.html">Baseball Caps</a></li>
                                                                <li>

                                                                    <a href="shop-side-version-2.html">Belts</a></li>
                                                            </ul>
                                                        </div>
                                                        <div class="col-lg-3">
                                                            <ul>
                                                                <li class="mega-list-title">

                                                                    <a href="shop-side-version-2.html">OTHER ACCESSORIES</a></li>
                                                                <li>

                                                                    <a href="shop-side-version-2.html">Bags</a></li>
                                                                <li>

                                                                    <a href="shop-side-version-2.html">Wallets</a></li>
                                                                <li>

                                                                    <a href="shop-side-version-2.html">Watches</a></li>
                                                                <li>

                                                                    <a href="shop-side-version-2.html">Sunglasses</a></li>
                                                            </ul>
                                                        </div>
                                                    </div>
                                                    <!--====== End - Mega Menu Row ======-->
                                                    <br>

                                                    <!--====== Mega Menu Row ======-->
                                                    <div class="row">
                                                        <div class="col-lg-9 mega-image">
                                                            <div class="mega-banner">

                                                                <a class="u-d-block" href="shop-side-version-2.html">

                                                                    <img class="u-img-fluid u-d-block" src="${pageContext.request.contextPath}/resources/images/banners/banner-mega-3.jpg" alt=""></a></div>
                                                        </div>
                                                        <div class="col-lg-3 mega-image">
                                                            <div class="mega-banner">

                                                                <a class="u-d-block" href="shop-side-version-2.html">

                                                                    <img class="u-img-fluid u-d-block" src="${pageContext.request.contextPath}/resources/images/banners/banner-mega-4.jpg" alt=""></a></div>
                                                        </div>
                                                    </div>
                                                    <!--====== End - Mega Menu Row ======-->
                                                </div>
                                                <!--====== End - Women ======-->


                                                <!--====== Men ======-->
                                                <div class="mega-menu-content">

                                                    <!--====== Mega Menu Row ======-->
                                                    <div class="row">
                                                        <div class="col-lg-4 mega-image">
                                                            <div class="mega-banner">

                                                                <a class="u-d-block" href="shop-side-version-2.html">

                                                                    <img class="u-img-fluid u-d-block" src="${pageContext.request.contextPath}/resources/images/banners/banner-mega-5.jpg" alt=""></a></div>
                                                        </div>
                                                        <div class="col-lg-4 mega-image">
                                                            <div class="mega-banner">

                                                                <a class="u-d-block" href="shop-side-version-2.html">

                                                                    <img class="u-img-fluid u-d-block" src="${pageContext.request.contextPath}/resources/images/banners/banner-mega-6.jpg" alt=""></a></div>
                                                        </div>
                                                        <div class="col-lg-4 mega-image">
                                                            <div class="mega-banner">

                                                                <a class="u-d-block" href="shop-side-version-2.html">

                                                                    <img class="u-img-fluid u-d-block" src="${pageContext.request.contextPath}/resources/images/banners/banner-mega-7.jpg" alt=""></a></div>
                                                        </div>
                                                    </div>
                                                    <!--====== End - Mega Menu Row ======-->
                                                    <br>

                                                    <!--====== Mega Menu Row ======-->
                                                    <div class="row">
                                                        <div class="col-lg-3">
                                                            <ul>
                                                                <li class="mega-list-title">

                                                                    <a href="shop-side-version-2.html">HOT SALE</a></li>
                                                                <li>

                                                                    <a href="shop-side-version-2.html">T-Shirts</a></li>
                                                                <li>

                                                                    <a href="shop-side-version-2.html">Tank Tops</a></li>
                                                                <li>

                                                                    <a href="shop-side-version-2.html">Polo</a></li>
                                                                <li>

                                                                    <a href="shop-side-version-2.html">Shirts</a></li>
                                                            </ul>
                                                        </div>
                                                        <div class="col-lg-3">
                                                            <ul>
                                                                <li class="mega-list-title">

                                                                    <a href="shop-side-version-2.html">OUTWEAR</a></li>
                                                                <li>

                                                                    <a href="shop-side-version-2.html">Hoodies</a></li>
                                                                <li>

                                                                    <a href="shop-side-version-2.html">Trench</a></li>
                                                                <li>

                                                                    <a href="shop-side-version-2.html">Parkas</a></li>
                                                                <li>

                                                                    <a href="shop-side-version-2.html">Sweaters</a></li>
                                                            </ul>
                                                        </div>
                                                        <div class="col-lg-3">
                                                            <ul>
                                                                <li class="mega-list-title">

                                                                    <a href="shop-side-version-2.html">BOTTOMS</a></li>
                                                                <li>

                                                                    <a href="shop-side-version-2.html">Casual Pants</a></li>
                                                                <li>

                                                                    <a href="shop-side-version-2.html">Cargo Pants</a></li>
                                                                <li>

                                                                    <a href="shop-side-version-2.html">Jeans</a></li>
                                                                <li>

                                                                    <a href="shop-side-version-2.html">Shorts</a></li>
                                                            </ul>
                                                        </div>
                                                        <div class="col-lg-3">
                                                            <ul>
                                                                <li class="mega-list-title">

                                                                    <a href="shop-side-version-2.html">UNDERWEAR</a></li>
                                                                <li>

                                                                    <a href="shop-side-version-2.html">Boxers</a></li>
                                                                <li>

                                                                    <a href="shop-side-version-2.html">Briefs</a></li>
                                                                <li>

                                                                    <a href="shop-side-version-2.html">Robes</a></li>
                                                                <li>

                                                                    <a href="shop-side-version-2.html">Socks</a></li>
                                                            </ul>
                                                        </div>
                                                    </div>
                                                    <!--====== End - Mega Menu Row ======-->
                                                    <br>

                                                    <!--====== Mega Menu Row ======-->
                                                    <div class="row">
                                                        <div class="col-lg-3">
                                                            <ul>
                                                                <li class="mega-list-title">

                                                                    <a href="shop-side-version-2.html">JACKETS</a></li>
                                                                <li>

                                                                    <a href="shop-side-version-2.html">Denim Jackets</a></li>
                                                                <li>

                                                                    <a href="shop-side-version-2.html">Trucker Jackets</a></li>
                                                                <li>

                                                                    <a href="shop-side-version-2.html">Windbreaker Jackets</a></li>
                                                                <li>

                                                                    <a href="shop-side-version-2.html">Leather Jackets</a></li>
                                                            </ul>
                                                        </div>
                                                        <div class="col-lg-3">
                                                            <ul>
                                                                <li class="mega-list-title">

                                                                    <a href="shop-side-version-2.html">SUNGLASSES</a></li>
                                                                <li>

                                                                    <a href="shop-side-version-2.html">Pilot</a></li>
                                                                <li>

                                                                    <a href="shop-side-version-2.html">Wayfarer</a></li>
                                                                <li>

                                                                    <a href="shop-side-version-2.html">Square</a></li>
                                                                <li>

                                                                    <a href="shop-side-version-2.html">Round</a></li>
                                                            </ul>
                                                        </div>
                                                        <div class="col-lg-3">
                                                            <ul>
                                                                <li class="mega-list-title">

                                                                    <a href="shop-side-version-2.html">ACCESSORIES</a></li>
                                                                <li>

                                                                    <a href="shop-side-version-2.html">Eyewear Frames</a></li>
                                                                <li>

                                                                    <a href="shop-side-version-2.html">Scarves</a></li>
                                                                <li>

                                                                    <a href="shop-side-version-2.html">Hats</a></li>
                                                                <li>

                                                                    <a href="shop-side-version-2.html">Belts</a></li>
                                                            </ul>
                                                        </div>
                                                        <div class="col-lg-3">
                                                            <ul>
                                                                <li class="mega-list-title">

                                                                    <a href="shop-side-version-2.html">OTHER ACCESSORIES</a></li>
                                                                <li>

                                                                    <a href="shop-side-version-2.html">Bags</a></li>
                                                                <li>

                                                                    <a href="shop-side-version-2.html">Wallets</a></li>
                                                                <li>

                                                                    <a href="shop-side-version-2.html">Watches</a></li>
                                                                <li>

                                                                    <a href="shop-side-version-2.html">Tech Accessories</a></li>
                                                            </ul>
                                                        </div>
                                                    </div>
                                                    <!--====== End - Mega Menu Row ======-->
                                                    <br>

                                                    <!--====== Mega Menu Row ======-->
                                                    <div class="row">
                                                        <div class="col-lg-6 mega-image">
                                                            <div class="mega-banner">

                                                                <a class="u-d-block" href="shop-side-version-2.html">

                                                                    <img class="u-img-fluid u-d-block" src="${pageContext.request.contextPath}/resources/images/banners/banner-mega-8.jpg" alt=""></a></div>
                                                        </div>
                                                        <div class="col-lg-6 mega-image">
                                                            <div class="mega-banner">

                                                                <a class="u-d-block" href="shop-side-version-2.html">

                                                                    <img class="u-img-fluid u-d-block" src="${pageContext.request.contextPath}/resources/images/banners/banner-mega-9.jpg" alt=""></a></div>
                                                        </div>
                                                    </div>
                                                    <!--====== End - Mega Menu Row ======-->
                                                </div>
                                                <!--====== End - Men ======-->


                                                <!--====== No Sub Categories ======-->
                                                <div class="mega-menu-content">
                                                    <h5>No Categories</h5>
                                                </div>
                                                <!--====== End - No Sub Categories ======-->


                                                <!--====== No Sub Categories ======-->
                                                <div class="mega-menu-content">
                                                    <h5>No Categories</h5>
                                                </div>
                                                <!--====== End - No Sub Categories ======-->


                                                <!--====== No Sub Categories ======-->
                                                <div class="mega-menu-content">
                                                    <h5>No Categories</h5>
                                                </div>
                                                <!--====== End - No Sub Categories ======-->


                                                <!--====== No Sub Categories ======-->
                                                <div class="mega-menu-content">
                                                    <h5>No Categories</h5>
                                                </div>
                                                <!--====== End - No Sub Categories ======-->
                                            </div>
                                        </div>
                                        <!--====== End - Mega Menu ======-->
                                    </li>
                                </ul>
                                <!--====== End - List ======-->
                            </div>
                            <!--====== End - Menu ======-->
                        </div>
                        <!--====== End - Dropdown Main plugin ======-->


                        <!--====== Dropdown Main plugin ======-->
                        <div class="menu-init" id="navigation2">

                            <button class="btn btn--icon toggle-button toggle-button--secondary fas fa-cog" type="button"></button>

                            <!--====== Menu ======-->
                            <div class="ah-lg-mode">

                                <span class="ah-close">✕ Close</span>

                                <!--====== List ======-->
                                <ul class="ah-list ah-list--design2 ah-list--link-color-secondary">
                                    <li>

                                        <a href="shop-side-version-2.html">NEW ARRIVALS</a></li>
                                    <li class="has-dropdown">

                                        <a>PAGES<i class="fas fa-angle-down u-s-m-l-6"></i></a>

                                        <!--====== Dropdown ======-->

                                        <span class="js-menu-toggle"></span>
                                        <ul style="width:170px">
                                            <li class="has-dropdown has-dropdown--ul-left-100">

                                                <a>Home<i class="fas fa-angle-down i-state-right u-s-m-l-6"></i></a>

                                                <!--====== Dropdown ======-->

                                                <span class="js-menu-toggle"></span>
                                                <ul style="width:118px">
                                                    <li>

                                                        <a href="${pageContext.request.contextPath}/">Home 1</a></li>
                                                    <li>

                                                        <a href="${pageContext.request.contextPath}/">Home 2</a></li>
                                                    <li>

                                                        <a href="${pageContext.request.contextPath}/">Home 3</a></li>
                                                </ul>
                                                <!--====== End - Dropdown ======-->
                                            </li>
                                            <li class="has-dropdown has-dropdown--ul-left-100">

                                                <a>Account<i class="fas fa-angle-down i-state-right u-s-m-l-6"></i></a>

                                                <!--====== Dropdown ======-->

                                                <span class="js-menu-toggle"></span>
                                                <ul style="width:200px">
                                                <security:authorize access="isAnonymous()">
                                                    <li>

                                                        <a href="${pageContext.request.contextPath}/login">Signin / Already Registered</a></li>
                                                    <li>

                                                        <a href="${pageContext.request.contextPath}/register/">Signup / Register</a></li>
                                                </security:authorize>

                                                </ul>
                                                <!--====== End - Dropdown ======-->
                                            </li>
                                            <li class="has-dropdown has-dropdown--ul-left-100">

                                                <a href="${pageContext.request.contextPath}/dashboard/">Dashboard<i class="fas fa-angle-down i-state-right u-s-m-l-6"></i></a>

                                                <!--====== Dropdown ======-->

                                                <span class="js-menu-toggle"></span>
                                                <ul style="width:200px">
                                                    <li class="has-dropdown has-dropdown--ul-left-100">

                                                        <a href="dashboard.html">Manage My Account<i class="fas fa-angle-down i-state-right u-s-m-l-6"></i></a>

                                                        <!--====== Dropdown ======-->

                                                        <span class="js-menu-toggle"></span>
                                                        <ul style="width:180px">
                                                            <li>

                                                                <a href="${pageContext.request.contextPath}/dashboard/edit_profile">Edit Profile</a></li>
                                                            <li>

                                                                <a href="${pageContext.request.contextPath}/dashboard/edit_address">Edit Address Book</a></li>
                                                            <li>

                                                                <a href="${pageContext.request.contextPath}/dashboard/manage_order">Manage Order</a></li>
                                                        </ul>
                                                        <!--====== End - Dropdown ======-->
                                                    </li>
                                                    <li>

                                                        <a href="${pageContext.request.contextPath}/dashboard/my_profile">My Profile</a></li>
                                                    <li class="has-dropdown has-dropdown--ul-left-100">

                                                        <a href="${pageContext.request.contextPath}/dashboard/book_address">Address Book<i class="fas fa-angle-down i-state-right u-s-m-l-6"></i></a>

                                                        <!--====== Dropdown ======-->

                                                        <span class="js-menu-toggle"></span>
                                                        <ul style="width:180px">
                                                            <li>

                                                                <a href="${pageContext.request.contextPath}/dashboard/make_default_address">Address Make Default</a></li>

                                                            <li>

                                                                <a href="${pageContext.request.contextPath}/dashboard/edit_address">Edit Address Book</a></li>
                                                        </ul>
                                                        <!--====== End - Dropdown ======-->
                                                    </li>
                                                    <li>

                                                        <a href="${pageContext.request.contextPath}/dashboard/track_order">Track Order</a></li>
                                                    <li>

                                                        <a href="${pageContext.request.contextPath}/dashboard/my_order">My Orders</a></li>
                                                    <li>

                                                        <a href="${pageContext.request.contextPath}/dashboard/payment_option">My Payment Options</a></li>
                                                    <li>

                                                        <a href="${pageContext.request.contextPath}/dashboard/cancellation">My Returns & Cancellations</a></li>
                                                </ul>
                                                <!--====== End - Dropdown ======-->
                                            </li>
                                            <li class="has-dropdown has-dropdown--ul-left-100">

                                                <a>Empty<i class="fas fa-angle-down i-state-right u-s-m-l-6"></i></a>

                                                <!--====== Dropdown ======-->

                                                <span class="js-menu-toggle"></span>
                                                <ul style="width:200px">
                                                    <li>

                                                        <a href="empty-search.html">Empty Search</a></li>
                                                    <li>

                                                        <a href="empty-cart.html">Empty Cart</a></li>
                                                    <li>

                                                        <a href="empty-wishlist.html">Empty Wishlist</a></li>
                                                </ul>
                                                <!--====== End - Dropdown ======-->
                                            </li>
                                            <li class="has-dropdown has-dropdown--ul-left-100">

                                                <a>Product Details<i class="fas fa-angle-down i-state-right u-s-m-l-6"></i></a>

                                                <!--====== Dropdown ======-->

                                                <span class="js-menu-toggle"></span>
                                                <ul style="width:200px">
                                                    <li>

                                                        <a href="${pageContext.request.contextPath}/product/product_detail?id=1">Product Details</a></li>
                                                    <li>

                                                        <a href="product-detail-variable.html">Product Details Variable</a></li>
                                                    <li>

                                                        <a href="product-detail-affiliate.html">Product Details Affiliate</a></li>
                                                </ul>
                                                <!--====== End - Dropdown ======-->
                                            </li>
                                            <li class="has-dropdown has-dropdown--ul-left-100">

                                                <a>Shop Grid Layout<i class="fas fa-angle-down i-state-right u-s-m-l-6"></i></a>

                                                <!--====== Dropdown ======-->

                                                <span class="js-menu-toggle"></span>
                                                <ul style="width:200px">
                                                    <li>

                                                        <a href="shop-grid-left.html">Shop Grid Left Sidebar</a></li>
                                                    <li>

                                                        <a href="shop-grid-right.html">Shop Grid Right Sidebar</a></li>
                                                    <li>

                                                        <a href="shop-grid-full.html">Shop Grid Full Width</a></li>
                                                    <li>

                                                        <a href="shop-side-version-2.html">Shop Side Version 2</a></li>
                                                </ul>
                                                <!--====== End - Dropdown ======-->
                                            </li>
                                            <li class="has-dropdown has-dropdown--ul-left-100">

                                                <a>Shop List Layout<i class="fas fa-angle-down i-state-right u-s-m-l-6"></i></a>

                                                <!--====== Dropdown ======-->

                                                <span class="js-menu-toggle"></span>
                                                <ul style="width:200px">
                                                    <li>

                                                        <a href="shop-list-left.html">Shop List Left Sidebar</a></li>
                                                    <li>

                                                        <a href="shop-list-right.html">Shop List Right Sidebar</a></li>
                                                    <li>

                                                        <a href="shop-list-full.html">Shop List Full Width</a></li>
                                                </ul>
                                                <!--====== End - Dropdown ======-->
                                            </li>
                                            <li>

                                                <a href="${pageContext.request.contextPath}/cart/">Cart</a></li>
                                            <li>

                                                <a href="wishlist.html">Wishlist</a></li>
                                            <li>

                                                <a href="${pageContext.request.contextPath}/checkout/">Checkout</a></li>
                                            <li>

                                                <a href="faq.html">FAQ</a></li>
                                            <li>

                                                <a href="about.html">About us</a></li>
                                            <li>

                                                <a href="contact.html">Contact</a></li>
                                            <li>

                                                <a href="404.html">404</a></li>
                                        </ul>
                                        <!--====== End - Dropdown ======-->
                                    </li>
                                    <li class="has-dropdown">

                                        <a>BLOG<i class="fas fa-angle-down u-s-m-l-6"></i></a>

                                        <!--====== Dropdown ======-->

                                        <span class="js-menu-toggle"></span>
                                        <ul style="width:200px">
                                            <li>

                                                <a href="blog-left-sidebar.html">Blog Left Sidebar</a></li>
                                            <li>

                                                <a href="blog-right-sidebar.html">Blog Right Sidebar</a></li>
                                            <li>

                                                <a href="blog-sidebar-none.html">Blog Sidebar None</a></li>
                                            <li>

                                                <a href="blog-masonry.html">Blog Masonry</a></li>
                                            <li>

                                                <a href="blog-detail.html">Blog Details</a></li>
                                        </ul>
                                        <!--====== End - Dropdown ======-->
                                    </li>
                                    <li>

                                        <a href="shop-side-version-2.html">VALUE OF THE DAY</a></li>
                                    <li>

                                        <a href="shop-side-version-2.html">GIFT CARDS</a></li>
                                </ul>
                                <!--====== End - List ======-->
                            </div>
                            <!--====== End - Menu ======-->
                        </div>
                        <!--====== End - Dropdown Main plugin ======-->


                        <!--====== Dropdown Main plugin ======-->
                        <div class="menu-init" id="navigation3">

                            <button class="btn btn--icon toggle-button toggle-button--secondary fas fa-shopping-bag toggle-button-shop" type="button"></button>

                            <span class="total-item-round">${total_amount}</span>

                            <!--====== Menu ======-->
                            <div class="ah-lg-mode">

                                <span class="ah-close">✕ Close</span>

                                <!--====== List ======-->
                                <ul class="ah-list ah-list--design1 ah-list--link-color-secondary">
                                    <li>

                                        <a href="index.jsp"><i class="fas fa-home u-c-brand"></i></a></li>
                                    <li>

                                        <a href="wishlist.html"><i class="far fa-heart"></i></a></li>
                                    <li class="has-dropdown">

                                        <a class="mini-cart-shop-link"><i class="fas fa-shopping-bag"></i>

                                            <span class="total-item-round">${total_amount}</span></a>

                                        <!--====== Dropdown ======-->

                                        <span class="js-menu-toggle"></span>
                                        <security:authorize access="isAuthenticated()">
                                        <div class="mini-cart">

                                            <!--====== Mini Product Container ======-->
                                            <div class="mini-product-container gl-scroll u-s-m-b-15">

                                                <c:forEach var="cart_product" items="${cart_product_list}">
                                                    <div class="card-mini-product">
                                                        <div class="mini-product">
                                                            <div class="mini-product__image-wrapper">

                                                                <a class="mini-product__link" href="${pageContext.request.contextPath}/product/product_detail?id=${cart_product.idProduct}">

                                                                    <img class="u-img-fluid" src="${pageContext.request.contextPath}/resources/images/product/electronic/product3.jpg" alt=""></a></div>
                                                            <div class="mini-product__info-wrapper">

                                                            <span class="mini-product__category">

                                                                <a href="shop-side-version-2.html">Electronics</a></span>

                                                                <span class="mini-product__name">

                                                                <a href="${pageContext.request.contextPath}/product/product_detail?id=${cart_product.idProduct}">${cart_product.name}</a></span>

                                                                <span class="mini-product__quantity">${cart_product.amount} x</span>

                                                                <span class="mini-product__price">${cart_product.vnTotalMoney} </span></div>
                                                        </div>

                                                        <a class="mini-product__delete-link far fa-trash-alt"></a>
                                                    </div>
                                                </c:forEach>

                                            </div>
                                            <!--====== End - Mini Product Container ======-->


                                            <!--====== Mini Product Statistics ======-->
                                            <div class="mini- -stat">
                                                <div class="mini-total">

                                                    <span class="subtotal-text">SUBTOTAL</span>

                                                    <span class="subtotal-value">${cart_product_total}</span></div>
                                                <div class="mini-action">

                                                    <a class="mini-link btn--e-brand-b-2" href="${pageContext.request.contextPath}/checkout/">PROCEED TO CHECKOUT</a>

                                                    <a class="mini-link btn--e-transparent-secondary-b-2" href="${pageContext.request.contextPath}/cart/">VIEW CART</a></div>
                                            </div>
                                            <!--====== End - Mini Product Statistics ======-->
                                        </div>
                                        </security:authorize>
                                        <!--====== End - Dropdown ======-->
                                    </li>
                                </ul>
                                <!--====== End - List ======-->
                            </div>
                            <!--====== End - Menu ======-->
                        </div>
                        <!--====== End - Dropdown Main plugin ======-->
                    </div>
                    <!--====== End - Secondary Nav ======-->
                </div>
            </nav>
            <!--====== End - Nav 2 ======-->
        </header>
        <!--====== End - Main Header ======-->


        <!--====== App Content ======-->
        <div class="app-content">

            <!--====== Primary Slider ======-->
            <div class="s-skeleton s-skeleton--h-600 s-skeleton--bg-grey">
                <div class="owl-carousel primary-style-1" id="hero-slider">
                    <div class="hero-slide hero-slide--1">
                        <div class="container">
                            <div class="row">
                                <div class="col-12">
                                    <div class="slider-content slider-content--animation">

                                        <span class="content-span-1 u-c-secondary">Latest Update Stock</span>

                                        <span class="content-span-2 u-c-secondary">30% Off On Electronics</span>

                                        <span class="content-span-3 u-c-secondary">Find electronics on best prices, Also Discover most selling products of electronics</span>

                                        <span class="content-span-4 u-c-secondary">Starting At

                                            <span class="u-c-brand">100.000đ</span></span>

                                        <a class="shop-now-link btn--e-brand" href="${pageContext.request.contextPath}/">SHOP NOW</a></div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="hero-slide hero-slide--2">
                        <div class="container">
                            <div class="row">
                                <div class="col-12">
                                    <div class="slider-content slider-content--animation">

                                        <span class="content-span-1 u-c-white">Find Top Brands</span>

                                        <span class="content-span-2 u-c-white">10% Off On Electronics</span>

                                        <span class="content-span-3 u-c-white">Find electronics on best prices, Also Discover most selling products of electronics</span>

                                        <span class="content-span-4 u-c-white">Starting At

                                            <span class="u-c-brand">20.000đ</span></span>

                                        <a class="shop-now-link btn--e-brand" href="${pageContext.request.contextPath}/">SHOP NOW</a></div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="hero-slide hero-slide--3">
                        <div class="container">
                            <div class="row">
                                <div class="col-12">
                                    <div class="slider-content slider-content--animation">

                                        <span class="content-span-1 u-c-secondary">Find Top Brands</span>

                                        <span class="content-span-2 u-c-secondary">10% Off On Electronics</span>

                                        <span class="content-span-3 u-c-secondary">Find electronics on best prices, Also Discover most selling products of electronics</span>

                                        <span class="content-span-4 u-c-secondary">Starting At

                                            <span class="u-c-brand">50.000đ</span></span>

                                        <a class="shop-now-link btn--e-brand" href="${pageContext.request.contextPath}/">SHOP NOW</a></div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!--====== End - Primary Slider ======-->


            <!--====== Section 1 ======-->
            <div class="u-s-p-y-60">

                <!--====== Section Intro ======-->
                <div class="section__intro u-s-m-b-46">
                    <div class="container">
                        <div class="row">
                            <div class="col-lg-12">
                                <div class="section__text-wrap">
                                    <h1 class="section__heading u-c-secondary u-s-m-b-12">SHOP BY DEALS</h1>

                                    <span class="section__span u-c-silver">BROWSE FAVOURITE DEALS</span>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <!--====== End - Section Intro ======-->


                <!--====== Section Content ======-->
                <div class="section__content">
                    <div class="container">
                        <div class="row">
                            <div class="col-lg-5 col-md-5 u-s-m-b-30">

                                <a class="collection" href=${pageContext.request.contextPath}/">
                                    <div class="aspect aspect--bg-grey aspect--square">

                                        <img class="aspect__img collection__img" src="${pageContext.request.contextPath}/resources/images/collection/coll-1.jpg" alt=""></div>
                                </a></div>
                            <div class="col-lg-7 col-md-7 u-s-m-b-30">

                                <a class="collection" href="${pageContext.request.contextPath}/">
                                    <div class="aspect aspect--bg-grey aspect--1286-890">

                                        <img class="aspect__img collection__img" src="${pageContext.request.contextPath}/resources/images/collection/coll-2.jpg" alt=""></div>
                                </a></div>
                            <div class="col-lg-7 col-md-7 u-s-m-b-30">

                                <a class="collection" href="${pageContext.request.contextPath}/">
                                    <div class="aspect aspect--bg-grey aspect--1286-890">

                                        <img class="aspect__img collection__img" src="${pageContext.request.contextPath}/resources/images/collection/coll-3.jpg" alt=""></div>
                                </a></div>
                            <div class="col-lg-5 col-md-5 u-s-m-b-30">

                                <a class="collection" href="${pageContext.request.contextPath}/">
                                    <div class="aspect aspect--bg-grey aspect--square">

                                        <img class="aspect__img collection__img" src="${pageContext.request.contextPath}/resources/images/collection/coll-4.jpg" alt=""></div>
                                </a></div>
                        </div>
                    </div>
                </div>

                <!--====== Section Content ======-->
            </div>
            <!--====== End - Section 1 ======-->


            <!--====== Section 2 ======-->
            <div class="u-s-p-b-60">

                <!--====== Section Intro ======-->
                <div class="section__intro u-s-m-b-16">
                    <div class="container">
                        <div class="row">
                            <div class="col-lg-12">
                                <div class="section__text-wrap">
                                    <h1 class="section__heading u-c-secondary u-s-m-b-12">TOP TRENDING</h1>

                                    <span class="section__span u-c-silver">CHOOSE CATEGORY</span>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <!--====== End - Section Intro ======-->


                <!--====== Section Content ======-->
                <div class="section__content">
                    <div class="container">
                        <div class="row">
                            <div class="col-lg-12">
                                <div class="filter-category-container">
                                    <div class="filter__category-wrapper">

                                        <button class="btn filter__btn filter__btn--style-1 js-checked" type="button" data-filter="*">ALL</button></div>
                                    <div class="filter__category-wrapper">

                                        <button class="btn filter__btn filter__btn--style-1" type="button" data-filter=".men">MAN CLOTHING</button></div>
                                    <div class="filter__category-wrapper">

                                        <button class="btn filter__btn filter__btn--style-1" type="button" data-filter=".electronic">ELECTRONICS</button></div>
                                    <div class="filter__category-wrapper">

                                        <button class="btn filter__btn filter__btn--style-1" type="button" data-filter=".women">WOMEN CLOTHING</button></div>
                                    <div class="filter__category-wrapper">

                                        <button class="btn filter__btn filter__btn--style-1" type="button" data-filter=".game">GAME</button></div>
                                </div>
                                <div class="filter__grid-wrapper u-s-m-t-30">
                                    <div class="row">
                                        <c:forEach var="product" items="${listManCloth}">
                                            <div class="col-xl-3 col-lg-4 col-md-6 col-sm-6 u-s-m-b-30 filter__item men">
                                                <div class="product-o product-o--hover-on product-o--radius">
                                                    <div class="product-o__wrap">

                                                        <a class="aspect aspect--bg-grey aspect--square u-d-block" href="${pageContext.request.contextPath}/product/product_detail?id=${product.idProduct}">

                                                            <img class="aspect__img" src="${pageContext.request.contextPath}/resources/images/product/electronic/product2.jpg" alt=""></a>
                                                        <div class="product-o__action-wrap">
                                                            <ul class="product-o__action-list">
                                                                <li>

                                                                    <a data-modal="modal" data-modal-id="#quick-look-${product.idProduct}" data-tooltip="tooltip" data-placement="top" title="Quick View"><i class="fas fa-search-plus"></i></a></li>
                                                                <li>

                                                                    <a data-modal="modal" data-modal-id="#add-to-cart" data-tooltip="tooltip" data-placement="top" title="Add to Cart"><i class="fas fa-plus-circle"></i></a></li>
                                                                <li>

                                                                    <a href="${pageContext.request.contextPath}/login" data-tooltip="tooltip" data-placement="top" title="Add to Wishlist"><i class="fas fa-heart"></i></a></li>
                                                                <li>

                                                                    <a href="${pageContext.request.contextPath}/login" data-tooltip="tooltip" data-placement="top" title="Email me When the price drops"><i class="fas fa-envelope"></i></a></li>
                                                            </ul>
                                                        </div>
                                                    </div>

                                                    <span class="product-o__category">

                                                    <a href="shop-side-version-2.html">Men Clothing</a></span>

                                                    <span class="product-o__name">

                                                    <a href="${pageContext.request.contextPath}/product/product_detail?id=${product.idProduct}">${product.name}</a></span>
                                                    <div class="product-o__rating gl-rating-style"><i class="fas fa-star"></i><i class="fas fa-star"></i><i class="fas fa-star"></i><i class="fas fa-star"></i><i class="fas fa-star-half-alt"></i>

                                                        <span class="product-o__review">(23)</span></div>

                                                    <span class="product-o__price">${product.price}đ

                                                    <span class="product-o__discount">${product.price + 0.1*product.price}đ</span></span>
                                                </div>
                                            </div>
                                        </c:forEach>
                                        <c:forEach var="product" items="${listWomenCloth}">
                                            <div class="col-xl-3 col-lg-4 col-md-6 col-sm-6 u-s-m-b-30 filter__item women">
                                                <div class="product-o product-o--hover-on product-o--radius">
                                                    <div class="product-o__wrap">

                                                        <a class="aspect aspect--bg-grey aspect--square u-d-block" href="${pageContext.request.contextPath}/product/product_detail?id=${product.idProduct}">

                                                            <img class="aspect__img" src="${pageContext.request.contextPath}/resources/images/product/electronic/product4.jpg" alt=""></a>
                                                        <div class="product-o__action-wrap">
                                                            <ul class="product-o__action-list">
                                                                <li>

                                                                    <a data-modal="modal" data-modal-id="#quick-look-${product.idProduct}" data-tooltip="tooltip" data-placement="top" title="Quick View"><i class="fas fa-search-plus"></i></a></li>
                                                                <li>

                                                                    <a data-modal="modal" data-modal-id="#add-to-cart" data-tooltip="tooltip" data-placement="top" title="Add to Cart"><i class="fas fa-plus-circle"></i></a></li>
                                                                <li>

                                                                    <a href="${pageContext.request.contextPath}/login" data-tooltip="tooltip" data-placement="top" title="Add to Wishlist"><i class="fas fa-heart"></i></a></li>
                                                                <li>

                                                                    <a href="${pageContext.request.contextPath}/login" data-tooltip="tooltip" data-placement="top" title="Email me When the price drops"><i class="fas fa-envelope"></i></a></li>
                                                            </ul>
                                                        </div>
                                                    </div>

                                                    <span class="product-o__category">

                                                    <a href="shop-side-version-2.html">Women Cloth</a></span>

                                                    <span class="product-o__name">

                                                    <a href="${pageContext.request.contextPath}/product/product_detail?id=${product.idProduct}">${product.name}</a></span>
                                                    <div class="product-o__rating gl-rating-style"><i class="fas fa-star"></i><i class="fas fa-star"></i><i class="fas fa-star"></i><i class="fas fa-star"></i><i class="fas fa-star-half-alt"></i>

                                                        <span class="product-o__review">(23)</span></div>

                                                    <span class="product-o__price">${product.price}đ

                                                    <span class="product-o__discount">${product.price + 0.1*product.price}đ</span></span>
                                                </div>
                                            </div>
                                        </c:forEach>
                                        <c:forEach var="product" items="${listGame}" >
                                            <div class="col-xl-3 col-lg-4 col-md-6 col-sm-6 u-s-m-b-30 filter__item game">
                                                <div class="product-o product-o--hover-on product-o--radius">
                                                    <div class="product-o__wrap">

                                                        <a class="aspect aspect--bg-grey aspect--square u-d-block" href="${pageContext.request.contextPath}/product/product_detail?id=${product.idProduct}">

                                                            <img class="aspect__img" src="${pageContext.request.contextPath}/resources/images/product/electronic/product6.jpg" alt=""></a>
                                                        <div class="product-o__action-wrap">
                                                            <ul class="product-o__action-list">
                                                                <li>

                                                                    <a data-modal="modal" data-modal-id="#quick-look-${product.idProduct}" data-tooltip="tooltip" data-placement="top" title="Quick View"><i class="fas fa-search-plus"></i></a></li>
                                                                <li>

                                                                    <a data-modal="modal" data-modal-id="#add-to-cart" data-tooltip="tooltip" data-placement="top" title="Add to Cart"><i class="fas fa-plus-circle"></i></a></li>
                                                                <li>

                                                                    <a href="${pageContext.request.contextPath}/login" data-tooltip="tooltip" data-placement="top" title="Add to Wishlist"><i class="fas fa-heart"></i></a></li>
                                                                <li>

                                                                    <a href="${pageContext.request.contextPath}/login" data-tooltip="tooltip" data-placement="top" title="Email me When the price drops"><i class="fas fa-envelope"></i></a></li>
                                                            </ul>
                                                        </div>
                                                    </div>

                                                    <span class="product-o__category">

                                                    <a href="shop-side-version-2.html">GAME</a></span>

                                                    <span class="product-o__name">

                                                    <a href="${pageContext.request.contextPath}/product/product_detail?id=${product.idProduct}">${product.name}</a></span>
                                                    <div class="product-o__rating gl-rating-style"><i class="fas fa-star"></i><i class="fas fa-star"></i><i class="fas fa-star"></i><i class="fas fa-star"></i><i class="fas fa-star-half-alt"></i>

                                                        <span class="product-o__review">(20)</span></div>

                                                    <span class="product-o__price">${product.price}đ

                                                    <span class="product-o__discount">${product.price + 0.1*product.price}đ</span></span>
                                                </div>
                                            </div>
                                        </c:forEach>
                                        <c:forEach var="product" items="${listElectronics}">
                                            <div class="col-xl-3 col-lg-4 col-md-6 col-sm-6 u-s-m-b-30 filter__item electronic">
                                                <div class="product-o product-o--hover-on product-o--radius">
                                                    <div class="product-o__wrap">

                                                        <a class="aspect aspect--bg-grey aspect--square u-d-block" href="${pageContext.request.contextPath}/product/product_detail?id=${product.idProduct}">

                                                            <img class="aspect__img" src="${pageContext.request.contextPath}/resources/images/product/electronic/product8.jpg" alt=""></a>
                                                        <div class="product-o__action-wrap">
                                                            <ul class="product-o__action-list">
                                                                <li>

                                                                    <a data-modal="modal" data-modal-id="#quick-look-${product.idProduct}" data-tooltip="tooltip" data-placement="top" title="Quick View"><i class="fas fa-search-plus"></i></a></li>
                                                                <li>

                                                                    <a data-modal="modal" data-modal-id="#add-to-cart" data-tooltip="tooltip" data-placement="top" title="Add to Cart"><i class="fas fa-plus-circle"></i></a></li>
                                                                <li>

                                                                    <a href="${pageContext.request.contextPath}/login" data-tooltip="tooltip" data-placement="top" title="Add to Wishlist"><i class="fas fa-heart"></i></a></li>
                                                                <li>

                                                                    <a href="${pageContext.request.contextPath}/login" data-tooltip="tooltip" data-placement="top" title="Email me When the price drops"><i class="fas fa-envelope"></i></a></li>
                                                            </ul>
                                                        </div>
                                                    </div>

                                                    <span class="product-o__category">

                                                    <a href="shop-side-version-2.html">Electronics</a></span>

                                                    <span class="product-o__name">

                                                    <a href="${pageContext.request.contextPath}/product/product_detail?id=${product.idProduct}">${product.name}</a></span>
                                                    <div class="product-o__rating gl-rating-style"><i class="fas fa-star"></i><i class="fas fa-star"></i><i class="fas fa-star"></i><i class="fas fa-star"></i><i class="fas fa-star-half-alt"></i>

                                                        <span class="product-o__review">(30)</span></div>

                                                    <span class="product-o__price">${product.price}đ

                                                    <span class="product-o__discount">${product.price + 0.1*product.price}đ</span></span>
                                                </div>
                                            </div>
                                        </c:forEach>
                                </div>
                            </div>
                            <div class="col-lg-12">
                                <div class="load-more">

                                    <button class="btn btn--e-brand" type="button">Load More</button></div>
                            </div>
                        </div>
                    </div>
                </div>
                <!--====== End - Section Content ======-->
            </div>
            <!--====== End - Section 2 ======-->


            <!--====== Section 3 ======-->
            <div class="u-s-p-b-60">

                <!--====== Section Intro ======-->
                <div class="section__intro u-s-m-b-46">
                    <div class="container">
                        <div class="row">
                            <div class="col-lg-12">
                                <div class="section__text-wrap">
                                    <h1 class="section__heading u-c-secondary u-s-m-b-12">DEAL OF THE DAY</h1>

                                    <span class="section__span u-c-silver">BUY DEAL OF THE DAY, HURRY UP! THESE NEW PRODUCTS WILL EXPIRE SOON.</span>

                                    <span class="section__span u-c-silver">ADD THESE ON YOUR CART.</span>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <!--====== End - Section Intro ======-->


                <!--====== Section Content ======-->
                <div class="section__content">
                    <div class="container">
                        <div class="row">
                            <c:forEach var="product" items="${listTwoProducts}" >
                                <div class="col-lg-6 col-md-6 u-s-m-b-30">
                                    <div class="product-o product-o--radius product-o--hover-off u-h-100">
                                        <div class="product-o__wrap">

                                            <a class="aspect aspect--bg-grey aspect--square u-d-block" href="${pageContext.request.contextPath}/product/product_detail?id=${product.idProduct}">

                                                <img class="aspect__img" src="${pageContext.request.contextPath}/resources/images/product/electronic/product11.jpg" alt=""></a>
                                            <div class="product-o__special-count-wrap">
                                                <div class="countdown countdown--style-special" data-countdown="2021/09/01"></div>
                                            </div>
                                            <div class="product-o__action-wrap">
                                                <ul class="product-o__action-list">
                                                    <li>

                                                        <a data-modal="modal" data-modal-id="#quick-look" data-tooltip="tooltip" data-placement="top" title="Quick View"><i class="fas fa-search-plus"></i></a></li>
                                                    <li>

                                                        <a data-modal="modal" data-modal-id="#add-to-cart" data-tooltip="tooltip" data-placement="top" title="Add to Cart"><i class="fas fa-plus-circle"></i></a></li>
                                                    <li>

                                                        <a href="signin.html" data-tooltip="tooltip" data-placement="top" title="Add to Wishlist"><i class="fas fa-heart"></i></a></li>
                                                    <li>

                                                        <a href="signin.html" data-tooltip="tooltip" data-placement="top" title="Email me When the price drops"><i class="fas fa-envelope"></i></a></li>
                                                </ul>
                                            </div>
                                        </div>

                                        <span class="product-o__category">

                                        <a href="shop-side-version-2.html">Electronics</a></span>

                                        <span class="product-o__name">

                                        <a href="${pageContext.request.contextPath}/product/product_detail?id=15">${product.name}</a></span>
                                        <div class="product-o__rating gl-rating-style"><i class="fas fa-star"></i><i class="fas fa-star"></i><i class="fas fa-star"></i><i class="fas fa-star"></i><i class="fas fa-star"></i>

                                            <span class="product-o__review">(2)</span></div>

                                        <span class="product-o__price">${product.price}đ

                                        <span class="product-o__discount">${product.price + 0.1*product.price}đ</span></span>
                                    </div>
                                </div>
                            </c:forEach>


                        </div>
                    </div>
                </div>
                <!--====== End - Section Content ======-->
            </div>
            <!--====== End - Section 3 ======-->


            <!--====== Section 4 ======-->
            <div class="u-s-p-b-60">

                <!--====== Section Intro ======-->
                <div class="section__intro u-s-m-b-46">
                    <div class="container">
                        <div class="row">
                            <div class="col-lg-12">
                                <div class="section__text-wrap">
                                    <h1 class="section__heading u-c-secondary u-s-m-b-12">NEW ARRIVALS</h1>

                                    <span class="section__span u-c-silver">GET UP FOR NEW ARRIVALS</span>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <!--====== End - Section Intro ======-->


                <!--====== Section Content ======-->
                <div class="section__content">
                    <div class="container">
                        <div class="slider-fouc">
                            <div class="owl-carousel product-slider" data-item="4">
                                <c:forEach var="product" items="${listNewArrival}">
                                    <div class="u-s-m-b-30">
                                        <div class="product-o product-o--hover-on">
                                            <div class="product-o__wrap">

                                                <a class="aspect aspect--bg-grey aspect--square u-d-block" href="${pageContext.request.contextPath}/product/product_detail?id=${product.idProduct}">

                                                    <img class="aspect__img" src="${pageContext.request.contextPath}/resources/images/product/electronic/product13.jpg" alt=""></a>
                                                <div class="product-o__action-wrap">
                                                    <ul class="product-o__action-list">
                                                        <li>

                                                            <a data-modal="modal" data-modal-id="#quick-look" data-tooltip="tooltip" data-placement="top" title="Quick View"><i class="fas fa-search-plus"></i></a></li>
                                                        <li>

                                                            <a data-modal="modal" data-modal-id="#add-to-cart" data-tooltip="tooltip" data-placement="top" title="Add to Cart"><i class="fas fa-plus-circle"></i></a></li>
                                                        <li>

                                                            <a href="signin.html" data-tooltip="tooltip" data-placement="top" title="Add to Wishlist"><i class="fas fa-heart"></i></a></li>
                                                        <li>

                                                            <a href="signin.html" data-tooltip="tooltip" data-placement="top" title="Email me When the price drops"><i class="fas fa-envelope"></i></a></li>
                                                    </ul>
                                                </div>
                                            </div>

                                            <span class="product-o__category">

                                            <a href="shop-side-version-2.html">Electronics</a></span>

                                            <span class="product-o__name">

                                            <a href="${pageContext.request.contextPath}/product/product_detail?id=19">${product.name}</a></span>
                                            <div class="product-o__rating gl-rating-style"><i class="far fa-star"></i><i class="far fa-star"></i><i class="far fa-star"></i><i class="far fa-star"></i><i class="far fa-star"></i>

                                                <span class="product-o__review">(10)</span></div>

                                            <span class="product-o__price">${product.price}đ

                                            <span class="product-o__discount">${product.price + 0.1*product.price}đ</span></span>
                                        </div>
                                    </div>
                                </c:forEach>


                            </div>
                        </div>
                    </div>
                </div>
                <!--====== End - Section Content ======-->
            </div>
            <!--====== End - Section 4 ======-->


            <!--====== Section 5 ======-->
            <div class="banner-bg">

                <!--====== Section Content ======-->
                <div class="section__content">
                    <div class="container">
                        <div class="row">
                            <div class="col-lg-12">
                                <div class="banner-bg__countdown">
                                    <div class="countdown countdown--style-banner" data-countdown="2020/05/01"></div>
                                </div>
                                <div class="banner-bg__wrap">
                                    <div class="banner-bg__text-1">

                                        <span class="u-c-white">Global</span>

                                        <span class="u-c-secondary">Offers</span></div>
                                    <div class="banner-bg__text-2">

                                        <span class="u-c-secondary">Official Launch</span>

                                        <span class="u-c-white">Don't Miss!</span></div>

                                    <span class="banner-bg__text-block banner-bg__text-3 u-c-secondary">Enjoy Free Shipping when you buy 2 items and above!</span>

                                    <a class="banner-bg__shop-now btn--e-secondary" href="shop-side-version-2.html">Shop Now</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <!--====== End - Section Content ======-->
            </div>
            <!--====== End - Section 5 ======-->


            <!--====== Section 6 ======-->
            <div class="u-s-p-y-60">

                <!--====== Section Intro ======-->
                <div class="section__intro u-s-m-b-46">
                    <div class="container">
                        <div class="row">
                            <div class="col-lg-12">
                                <div class="section__text-wrap">
                                    <h1 class="section__heading u-c-secondary u-s-m-b-12">FEATURED PRODUCTS</h1>

                                    <span class="section__span u-c-silver">FIND NEW FEATURED PRODUCTS</span>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <!--====== End - Section Intro ======-->


                <!--====== Section Content ======-->
                <div class="section__content">
                    <div class="container">
                        <div class="row">
                            <div class="col-xl-3 col-lg-4 col-md-6 col-sm-6 u-s-m-b-30">
                                <div class="product-o product-o--hover-on u-h-100">
                                    <div class="product-o__wrap">

                                        <a class="aspect aspect--bg-grey aspect--square u-d-block" href="${pageContext.request.contextPath}/product/product_detail?id=30">

                                            <img class="aspect__img" src="${pageContext.request.contextPath}/resources/images/product/electronic/product19.jpg" alt=""></a>
                                        <div class="product-o__action-wrap">
                                            <ul class="product-o__action-list">
                                                <li>

                                                    <a data-modal="modal" data-modal-id="#quick-look" data-tooltip="tooltip" data-placement="top" title="Quick View"><i class="fas fa-search-plus"></i></a></li>
                                                <li>

                                                    <a data-modal="modal" data-modal-id="#add-to-cart" data-tooltip="tooltip" data-placement="top" title="Add to Cart"><i class="fas fa-plus-circle"></i></a></li>
                                                <li>

                                                    <a href="signin.html" data-tooltip="tooltip" data-placement="top" title="Add to Wishlist"><i class="fas fa-heart"></i></a></li>
                                                <li>

                                                    <a href="signin.html" data-tooltip="tooltip" data-placement="top" title="Email me When the price drops"><i class="fas fa-envelope"></i></a></li>
                                            </ul>
                                        </div>
                                    </div>

                                    <span class="product-o__category">

                                        <a href="shop-side-version-2.html">Electronics</a></span>

                                    <span class="product-o__name">

                                        <a href="${pageContext.request.contextPath}/product/product_detail?id=31">Tablet 14inch Screen</a></span>
                                    <div class="product-o__rating gl-rating-style"><i class="fas fa-star"></i><i class="fas fa-star"></i><i class="fas fa-star"></i><i class="fas fa-star"></i><i class="fas fa-star-half-alt"></i>

                                        <span class="product-o__review">(23)</span></div>

                                    <span class="product-o__price">125.00

                                        <span class="product-o__discount">$160.00</span></span>
                                </div>
                            </div>
                            <div class="col-xl-3 col-lg-4 col-md-6 col-sm-6 u-s-m-b-30">
                                <div class="product-o product-o--hover-on u-h-100">
                                    <div class="product-o__wrap">

                                        <a class="aspect aspect--bg-grey aspect--square u-d-block" href="${pageContext.request.contextPath}/product/product_detail?id=32">

                                            <img class="aspect__img" src="${pageContext.request.contextPath}/resources/images/product/electronic/product20.jpg" alt=""></a>
                                        <div class="product-o__action-wrap">
                                            <ul class="product-o__action-list">
                                                <li>

                                                    <a data-modal="modal" data-modal-id="#quick-look" data-tooltip="tooltip" data-placement="top" title="Quick View"><i class="fas fa-search-plus"></i></a></li>
                                                <li>

                                                    <a data-modal="modal" data-modal-id="#add-to-cart" data-tooltip="tooltip" data-placement="top" title="Add to Cart"><i class="fas fa-plus-circle"></i></a></li>
                                                <li>

                                                    <a href="signin.html" data-tooltip="tooltip" data-placement="top" title="Add to Wishlist"><i class="fas fa-heart"></i></a></li>
                                                <li>

                                                    <a href="signin.html" data-tooltip="tooltip" data-placement="top" title="Email me When the price drops"><i class="fas fa-envelope"></i></a></li>
                                            </ul>
                                        </div>
                                    </div>

                                    <span class="product-o__category">

                                        <a href="shop-side-version-2.html">Electronics</a></span>

                                    <span class="product-o__name">

                                        <a href="${pageContext.request.contextPath}/product/product_detail?id=33">Tablet 18inch Screen</a></span>
                                    <div class="product-o__rating gl-rating-style"><i class="fas fa-star"></i><i class="fas fa-star"></i><i class="fas fa-star"></i><i class="fas fa-star"></i><i class="fas fa-star-half-alt"></i>

                                        <span class="product-o__review">(23)</span></div>

                                    <span class="product-o__price">125.00

                                        <span class="product-o__discount">$160.00</span></span>
                                </div>
                            </div>
                            <div class="col-xl-3 col-lg-4 col-md-6 col-sm-6 u-s-m-b-30">
                                <div class="product-o product-o--hover-on u-h-100">
                                    <div class="product-o__wrap">

                                        <a class="aspect aspect--bg-grey aspect--square u-d-block" href="${pageContext.request.contextPath}/product/product_detail?id=34">

                                            <img class="aspect__img" src="${pageContext.request.contextPath}/resources/images/product/electronic/product21.jpg" alt=""></a>
                                        <div class="product-o__action-wrap">
                                            <ul class="product-o__action-list">
                                                <li>

                                                    <a data-modal="modal" data-modal-id="#quick-look" data-tooltip="tooltip" data-placement="top" title="Quick View"><i class="fas fa-search-plus"></i></a></li>
                                                <li>

                                                    <a data-modal="modal" data-modal-id="#add-to-cart" data-tooltip="tooltip" data-placement="top" title="Add to Cart"><i class="fas fa-plus-circle"></i></a></li>
                                                <li>

                                                    <a href="signin.html" data-tooltip="tooltip" data-placement="top" title="Add to Wishlist"><i class="fas fa-heart"></i></a></li>
                                                <li>

                                                    <a href="signin.html" data-tooltip="tooltip" data-placement="top" title="Email me When the price drops"><i class="fas fa-envelope"></i></a></li>
                                            </ul>
                                        </div>
                                    </div>

                                    <span class="product-o__category">

                                        <a href="shop-side-version-2.html">Electronics</a></span>

                                    <span class="product-o__name">

                                        <a href="${pageContext.request.contextPath}/product/product_detail?id=35">Tablet 13inch Screen Ram 16GB</a></span>
                                    <div class="product-o__rating gl-rating-style"><i class="fas fa-star"></i><i class="fas fa-star"></i><i class="fas fa-star"></i><i class="fas fa-star"></i><i class="fas fa-star-half-alt"></i>

                                        <span class="product-o__review">(23)</span></div>

                                    <span class="product-o__price">125.00

                                        <span class="product-o__discount">$160.00</span></span>
                                </div>
                            </div>
                            <div class="col-xl-3 col-lg-4 col-md-6 col-sm-6 u-s-m-b-30">
                                <div class="product-o product-o--hover-on u-h-100">
                                    <div class="product-o__wrap">

                                        <a class="aspect aspect--bg-grey aspect--square u-d-block" href="${pageContext.request.contextPath}/product/product_detail?id=36">

                                            <img class="aspect__img" src="${pageContext.request.contextPath}/resources/images/product/electronic/product22.jpg" alt=""></a>
                                        <div class="product-o__action-wrap">
                                            <ul class="product-o__action-list">
                                                <li>

                                                    <a data-modal="modal" data-modal-id="#quick-look" data-tooltip="tooltip" data-placement="top" title="Quick View"><i class="fas fa-search-plus"></i></a></li>
                                                <li>

                                                    <a data-modal="modal" data-modal-id="#add-to-cart" data-tooltip="tooltip" data-placement="top" title="Add to Cart"><i class="fas fa-plus-circle"></i></a></li>
                                                <li>

                                                    <a href="signin.html" data-tooltip="tooltip" data-placement="top" title="Add to Wishlist"><i class="fas fa-heart"></i></a></li>
                                                <li>

                                                    <a href="signin.html" data-tooltip="tooltip" data-placement="top" title="Email me When the price drops"><i class="fas fa-envelope"></i></a></li>
                                            </ul>
                                        </div>
                                    </div>

                                    <span class="product-o__category">

                                        <a href="shop-side-version-2.html">Electronics</a></span>

                                    <span class="product-o__name">

                                        <a href="${pageContext.request.contextPath}/product/product_detail?id=37">Tablet 12inch Screen Ram 16GB</a></span>
                                    <div class="product-o__rating gl-rating-style"><i class="fas fa-star"></i><i class="fas fa-star"></i><i class="fas fa-star"></i><i class="fas fa-star"></i><i class="fas fa-star-half-alt"></i>

                                        <span class="product-o__review">(23)</span></div>

                                    <span class="product-o__price">125.00

                                        <span class="product-o__discount">$160.00</span></span>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <!--====== End - Section Content ======-->
            </div>
            <!--====== End - Section 6 ======-->


            <!--====== Section 7 ======-->
            <div class="u-s-p-b-60">

                <!--====== Section Content ======-->
                <div class="section__content">
                    <div class="container">
                        <div class="row">
                            <div class="col-lg-4 col-md-4 col-sm-6 u-s-m-b-30">

                                <a class="promotion" href="shop-side-version-2.html">
                                    <div class="aspect aspect--bg-grey aspect--square">

                                        <img class="aspect__img promotion__img" src="${pageContext.request.contextPath}/resources/images/promo/promo-img-1.jpg" alt=""></div>
                                    <div class="promotion__content">
                                        <div class="promotion__text-wrap">
                                            <div class="promotion__text-1">

                                                <span class="u-c-secondary">ACCESSORIES FOR YOUR EVERYDAY</span></div>
                                            <div class="promotion__text-2">

                                                <span class="u-c-secondary">GET IN</span>

                                                <span class="u-c-brand">TOUCH</span></div>
                                        </div>
                                    </div>
                                </a></div>
                            <div class="col-lg-4 col-md-4 col-sm-6 u-s-m-b-30">

                                <a class="promotion" href="shop-side-version-2.html">
                                    <div class="aspect aspect--bg-grey aspect--square">

                                        <img class="aspect__img promotion__img" src="${pageContext.request.contextPath}/resources/images/promo/promo-img-2.jpg" alt=""></div>
                                    <div class="promotion__content">
                                        <div class="promotion__text-wrap">
                                            <div class="promotion__text-1">

                                                <span class="u-c-secondary">SMARTPHONE</span>

                                                <span class="u-c-brand">2021</span></div>
                                            <div class="promotion__text-2">

                                                <span class="u-c-secondary">NEW ARRIVALS</span></div>
                                        </div>
                                    </div>
                                </a></div>
                            <div class="col-lg-4 col-md-4 col-sm-6 u-s-m-b-30">

                                <a class="promotion" href="shop-side-version-2.html">
                                    <div class="aspect aspect--bg-grey aspect--square">

                                        <img class="aspect__img promotion__img" src="${pageContext.request.contextPath}/resources/images/promo/promo-img-3.jpg" alt=""></div>
                                    <div class="promotion__content">
                                        <div class="promotion__text-wrap">
                                            <div class="promotion__text-1">

                                                <span class="u-c-secondary">DSLR FOR NEW GENERATION</span></div>
                                            <div class="promotion__text-2">

                                                <span class="u-c-brand">GET UP TO 10% OFF</span></div>
                                        </div>
                                    </div>
                                </a></div>
                        </div>
                    </div>
                </div>
                <!--====== End - Section Content ======-->
            </div>
            <!--====== End - Section 7 ======-->


            <!--====== Section 8 ======-->
            <div class="u-s-p-b-60">

                <!--====== Section Content ======-->
                <div class="section__content">
                    <div class="container">
                        <div class="row">
                            <div class="col-lg-4 col-md-6 col-sm-6 u-s-m-b-30">
                                <div class="column-product">

                                    <span class="column-product__title u-c-secondary u-s-m-b-25">SPECIAL PRODUCTS</span>
                                    <ul class="column-product__list">
                                        <c:forEach var="product" items="${listTop3}">
                                            <li class="column-product__item">
                                                <div class="product-l">
                                                    <div class="product-l__img-wrap">

                                                        <a class="aspect aspect--bg-grey aspect--square u-d-block product-l__link" href="${pageContext.request.contextPath}/product/product_detail?id=${product.idProduct}">

                                                            <img class="aspect__img" src="${pageContext.request.contextPath}/resources/images/product/electronic/product23.jpg" alt=""></a></div>
                                                    <div class="product-l__info-wrap">

                                                    <span class="product-l__category">

                                                        <a href="shop-side-version-2.html">Electronics</a></span>

                                                        <span class="product-l__name">

                                                        <a href="${pageContext.request.contextPath}/product/product_detail?id=${product.idProduct}">${product.name}</a></span>

                                                        <span class="product-l__price">${product.price}đ</span></div>
                                                </div>
                                            </li>
                                        </c:forEach>


                                    </ul>
                                </div>
                            </div>
                            <div class="col-lg-4 col-md-6 col-sm-6 u-s-m-b-30">
                                <div class="column-product">

                                    <span class="column-product__title u-c-secondary u-s-m-b-25">WEEKLY PRODUCTS</span>
                                    <ul class="column-product__list">
                                        <c:forEach var="product" items="${listTop3}">
                                            <li class="column-product__item">
                                                <div class="product-l">
                                                    <div class="product-l__img-wrap">

                                                        <a class="aspect aspect--bg-grey aspect--square u-d-block product-l__link" href="${pageContext.request.contextPath}/product/product_detail?id=${product.idProduct}">

                                                            <img class="aspect__img" src="${pageContext.request.contextPath}/resources/images/product/electronic/product26.jpg" alt=""></a></div>
                                                    <div class="product-l__info-wrap">

                                                    <span class="product-l__category">

                                                        <a href="shop-side-version-2.html">Electronics</a></span>

                                                        <span class="product-l__name">

                                                        <a href="${pageContext.request.contextPath}/product/product_detail?id=${product.idProduct}">${product.name}</a></span>

                                                        <span class="product-l__price">${product.price}đ

                                                        <span class="product-l__discount">${product.price+ 0.1* product.price}đ</span></span></div>
                                                </div>
                                            </li>
                                        </c:forEach>


                                    </ul>
                                </div>
                            </div>
                            <div class="col-lg-4 col-md-6 col-sm-6 u-s-m-b-30">
                                <div class="column-product">

                                    <span class="column-product__title u-c-secondary u-s-m-b-25">FLASH PRODUCTS</span>
                                    <ul class="column-product__list">
                                        <c:forEach var="product" items="${listTop3}">
                                            <li class="column-product__item">
                                                <div class="product-l">
                                                    <div class="product-l__img-wrap">

                                                        <a class="aspect aspect--bg-grey aspect--square u-d-block product-l__link" href="${pageContext.request.contextPath}/product/product_detail?id=${product.idProduct}">

                                                            <img class="aspect__img" src="${pageContext.request.contextPath}/resources/images/product/electronic/product29.jpg" alt=""></a></div>
                                                    <div class="product-l__info-wrap">
                                                        <div class="product-l__rating gl-rating-style"><i class="fas fa-star"></i><i class="fas fa-star"></i><i class="fas fa-star"></i><i class="far fa-star"></i><i class="far fa-star"></i></div>

                                                        <span class="product-l__category">

                                                        <a href="shop-side-version-2.html">Electronics</a></span>

                                                        <span class="product-l__name">

                                                        <a href="${pageContext.request.contextPath}/product/product_detail?id=${product.idProduct}">${product.name}</a></span>

                                                        <span class="product-l__price">${product.price}đ</span>
                                                    </div>
                                                </div>
                                            </li>
                                        </c:forEach>

                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <!--====== End - Section Content ======-->
            </div>
            <!--====== End - Section 8 ======-->


            <!--====== Section 9 ======-->
            <div class="u-s-p-b-60">

                <!--====== Section Content ======-->
                <div class="section__content">
                    <div class="container">
                        <div class="row">
                            <div class="col-lg-4 col-md-6 u-s-m-b-30">
                                <div class="service u-h-100">
                                    <div class="service__icon"><i class="fas fa-truck"></i></div>
                                    <div class="service__info-wrap">

                                        <span class="service__info-text-1">Free Shipping</span>

                                        <span class="service__info-text-2">Free shipping on all US order or order above $200</span></div>
                                </div>
                            </div>
                            <div class="col-lg-4 col-md-6 u-s-m-b-30">
                                <div class="service u-h-100">
                                    <div class="service__icon"><i class="fas fa-redo"></i></div>
                                    <div class="service__info-wrap">

                                        <span class="service__info-text-1">Shop with Confidence</span>

                                        <span class="service__info-text-2">Our Protection covers your purchase from click to delivery</span></div>
                                </div>
                            </div>
                            <div class="col-lg-4 col-md-6 u-s-m-b-30">
                                <div class="service u-h-100">
                                    <div class="service__icon"><i class="fas fa-headphones-alt"></i></div>
                                    <div class="service__info-wrap">

                                        <span class="service__info-text-1">24/7 Help Center</span>

                                        <span class="service__info-text-2">Round-the-clock assistance for a smooth shopping experience</span></div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <!--====== End - Section Content ======-->
            </div>
            <!--====== End - Section 9 ======-->




            <!--====== Section 11 ======-->
            <div class="u-s-p-b-90 u-s-m-b-30">

                <!--====== Section Intro ======-->
                <div class="section__intro u-s-m-b-46">
                    <div class="container">
                        <div class="row">
                            <div class="col-lg-12">
                                <div class="section__text-wrap">
                                    <h1 class="section__heading u-c-secondary u-s-m-b-12">CLIENTS FEEDBACK</h1>

                                    <span class="section__span u-c-silver">WHAT OUR CLIENTS SAY</span>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <!--====== End - Section Intro ======-->


                <!--====== Section Content ======-->
                <div class="section__content">
                    <div class="container">

                        <!--====== Testimonial Slider ======-->
                        <div class="slider-fouc">
                            <div class="owl-carousel" id="testimonial-slider">
                                <div class="testimonial">
                                    <div class="testimonial__img-wrap">

                                        <img class="testimonial__img" src="${pageContext.request.contextPath}/resources/images/about/test-1.jpg" alt=""></div>
                                    <div class="testimonial__content-wrap">

                                        <span class="testimonial__double-quote"><i class="fas fa-quote-right"></i></span>
                                        <blockquote class="testimonial__block-quote">
                                            <p>"Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts. Separated they live in Bookmarksgrove right at the coast of the Semantics, a large language ocean."</p>
                                        </blockquote>

                                        <span class="testimonial__author">John D. / DVNTR Inc.</span>
                                    </div>
                                </div>
                                <div class="testimonial">
                                    <div class="testimonial__img-wrap">

                                        <img class="testimonial__img" src="${pageContext.request.contextPath}/resources/images/about/test-2.jpg" alt=""></div>
                                    <div class="testimonial__content-wrap">

                                        <span class="testimonial__double-quote"><i class="fas fa-quote-right"></i></span>
                                        <blockquote class="testimonial__block-quote">
                                            <p>"Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts. Separated they live in Bookmarksgrove right at the coast of the Semantics, a large language ocean."</p>
                                        </blockquote>

                                        <span class="testimonial__author">John D. / DVNTR Inc.</span>
                                    </div>
                                </div>
                                <div class="testimonial">
                                    <div class="testimonial__img-wrap">

                                        <img class="testimonial__img" src="${pageContext.request.contextPath}/resources/images/about/test-3.jpg" alt=""></div>
                                    <div class="testimonial__content-wrap">

                                        <span class="testimonial__double-quote"><i class="fas fa-quote-right"></i></span>
                                        <blockquote class="testimonial__block-quote">
                                            <p>"Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts. Separated they live in Bookmarksgrove right at the coast of the Semantics, a large language ocean."</p>
                                        </blockquote>

                                        <span class="testimonial__author">John D. / DVNTR Inc.</span>
                                    </div>
                                </div>
                                <div class="testimonial">
                                    <div class="testimonial__img-wrap">

                                        <img class="testimonial__img" src="${pageContext.request.contextPath}/resources/images/about/test-4.jpg" alt=""></div>
                                    <div class="testimonial__content-wrap">

                                        <span class="testimonial__double-quote"><i class="fas fa-quote-right"></i></span>
                                        <blockquote class="testimonial__block-quote">
                                            <p>"Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts. Separated they live in Bookmarksgrove right at the coast of the Semantics, a large language ocean."</p>
                                        </blockquote>

                                        <span class="testimonial__author">John D. / DVNTR Inc.</span>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!--====== End - Testimonial Slider ======-->
                    </div>
                </div>
                <!--====== End - Section Content ======-->
            </div>
            <!--====== End - Section 11 ======-->


            <!--====== Section 12 ======-->
            <div class="u-s-p-b-60">

                <!--====== Section Content ======-->
                <div class="section__content">
                    <div class="container">

                        <!--====== Brand Slider ======-->
                        <div class="slider-fouc">
                            <div class="owl-carousel" id="brand-slider" data-item="5">
                                <div class="brand-slide">

                                    <a href="shop-side-version-2.html">

                                        <img src="${pageContext.request.contextPath}/resources/images/brand/b1.png" alt=""></a></div>
                                <div class="brand-slide">

                                    <a href="shop-side-version-2.html">

                                        <img src="${pageContext.request.contextPath}/resources/images/brand/b2.png" alt=""></a></div>
                                <div class="brand-slide">

                                    <a href="shop-side-version-2.html">

                                        <img src="${pageContext.request.contextPath}/resources/images/brand/b3.png" alt=""></a></div>
                                <div class="brand-slide">

                                    <a href="shop-side-version-2.html">

                                        <img src="${pageContext.request.contextPath}/resources/images/brand/b4.png" alt=""></a></div>
                                <div class="brand-slide">

                                    <a href="shop-side-version-2.html">

                                        <img src="${pageContext.request.contextPath}/resources/images/brand/b5.png" alt=""></a></div>
                                <div class="brand-slide">

                                    <a href="shop-side-version-2.html">

                                        <img src="${pageContext.request.contextPath}/resources/images/brand/b6.png" alt=""></a></div>
                            </div>
                        </div>
                        <!--====== End - Brand Slider ======-->
                    </div>
                </div>
                <!--====== End - Section Content ======-->
            </div>
            <!--====== End - Section 12 ======-->
        </div>
        <!--====== End - App Content ======-->


        <!--====== Main Footer ======-->
        <footer>
            <div class="outer-footer">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-4 col-md-6">
                            <div class="outer-footer__content u-s-m-b-40">

                                <span class="outer-footer__content-title">Contact Us</span>
                                <div class="outer-footer__text-wrap"><i class="fas fa-home"></i>

                                    <span>4247 Ashford Drive Virginia VA-20006 USA</span></div>
                                <div class="outer-footer__text-wrap"><i class="fas fa-phone-volume"></i>

                                    <span>(+0) 900 901 904</span></div>
                                <div class="outer-footer__text-wrap"><i class="far fa-envelope"></i>

                                    <span>contact@domain.com</span></div>
                                <div class="outer-footer__social">
                                    <ul>
                                        <li>

                                            <a class="s-fb--color-hover" href="#"><i class="fab fa-facebook-f"></i></a></li>
                                        <li>

                                            <a class="s-tw--color-hover" href="#"><i class="fab fa-twitter"></i></a></li>
                                        <li>

                                            <a class="s-youtube--color-hover" href="#"><i class="fab fa-youtube"></i></a></li>
                                        <li>

                                            <a class="s-insta--color-hover" href="#"><i class="fab fa-instagram"></i></a></li>
                                        <li>

                                            <a class="s-gplus--color-hover" href="#"><i class="fab fa-google-plus-g"></i></a></li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-4 col-md-6">
                            <div class="row">
                                <div class="col-lg-6 col-md-6">
                                    <div class="outer-footer__content u-s-m-b-40">

                                        <span class="outer-footer__content-title">Information</span>
                                        <div class="outer-footer__list-wrap">
                                            <ul>
                                                <li>

                                                    <a href="cart.html">Cart</a></li>
                                                <li>

                                                    <a href="${pageContext.request.contextPath}/dashboard/">Account</a></li>
                                                <li>

                                                    <a href="shop-side-version-2.html">Manufacturer</a></li>
                                                <li>

                                                    <a href="dash-payment-option.html">Finance</a></li>
                                                <li>

                                                    <a href="shop-side-version-2.html">Shop</a></li>
                                            </ul>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-lg-6 col-md-6">
                                    <div class="outer-footer__content u-s-m-b-40">
                                        <div class="outer-footer__list-wrap">

                                            <span class="outer-footer__content-title">Our Company</span>
                                            <ul>
                                                <li>

                                                    <a href="about.html">About us</a></li>
                                                <li>

                                                    <a href="contact.html">Contact Us</a></li>
                                                <li>

                                                    <a href="index.jsp">Sitemap</a></li>
                                                <li>

                                                    <a href="dash-my-order.html">Delivery</a></li>
                                                <li>

                                                    <a href="shop-side-version-2.html">Store</a></li>
                                            </ul>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-4 col-md-12">
                            <div class="outer-footer__content">

                                <span class="outer-footer__content-title">Join our Newsletter</span>
                                <form class="newsletter">
                                    <div class="u-s-m-b-15">
                                        <div class="radio-box newsletter__radio">

                                            <input type="radio" id="male" name="gender">
                                            <div class="radio-box__state radio-box__state--primary">

                                                <label class="radio-box__label" for="male">Male</label></div>
                                        </div>
                                        <div class="radio-box newsletter__radio">

                                            <input type="radio" id="female" name="gender">
                                            <div class="radio-box__state radio-box__state--primary">

                                                <label class="radio-box__label" for="female">Female</label></div>
                                        </div>
                                    </div>
                                    <div class="newsletter__group">

                                        <label for="newsletter"></label>

                                        <input class="input-text input-text--only-white" type="text" id="newsletter" placeholder="Enter your Email">

                                        <button class="btn btn--e-brand newsletter__btn" type="submit">SUBSCRIBE</button></div>

                                    <span class="newsletter__text">Subscribe to the mailing list to receive updates on promotions, new arrivals, discount and coupons.</span>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="lower-footer">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-12">
                            <div class="lower-footer__content">
                                <div class="lower-footer__copyright">

                                    <span>Copyright © 2018</span>

                                    <a href="index.jsp">Reshop</a>

                                    <span>All Right Reserved</span></div>
                                <div class="lower-footer__payment">
                                    <ul>
                                        <li><i class="fab fa-cc-stripe"></i></li>
                                        <li><i class="fab fa-cc-paypal"></i></li>
                                        <li><i class="fab fa-cc-mastercard"></i></li>
                                        <li><i class="fab fa-cc-visa"></i></li>
                                        <li><i class="fab fa-cc-discover"></i></li>
                                        <li><i class="fab fa-cc-amex"></i></li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </footer>

        <!--====== Modal Section ======-->


        <!--====== Quick Look Modal ======-->
            <c:forEach var="product" items="${listManCloth}">
                <div class="modal fade" id="quick-look-${product.idProduct}">
                    <div class="modal-dialog modal-dialog-centered">
                        <div class="modal-content modal--shadow">

                            <button class="btn dismiss-button fas fa-times" type="button" data-dismiss="modal"></button>
                            <div class="modal-body">
                                <div class="row">
                                    <div class="col-lg-5">

                                        <!--====== Product Breadcrumb ======-->
                                        <div class="pd-breadcrumb u-s-m-b-30">
                                            <ul class="pd-breadcrumb__list">
                                                <li class="has-separator">

                                                    <a href="${pageContext.request.contextPath}/">Home</a></li>
                                                <li class="has-separator">

                                                    <a href="shop-side-version-2.html">Electronics</a></li>
                                                <li class="has-separator">

                                                    <a href="shop-side-version-2.html">Men Clothing</a></li>
                                                <li class="is-marked">

                                                    <a href="shop-side-version-2.html">Women Clothing</a></li>
                                            </ul>
                                        </div>
                                        <!--====== End - Product Breadcrumb ======-->


                                        <!--====== Product Detail ======-->
                                        <div class="pd u-s-m-b-30">
                                            <div class="pd-wrap">
                                                <div id="js-product-detail-modal">
                                                    <div>

                                                        <img class="u-img-fluid" src="${pageContext.request.contextPath}/resources/images/product/product-d-1.jpg" alt=""></div>
                                                    <div>

                                                        <img class="u-img-fluid" src="${pageContext.request.contextPath}/resources/images/product/product-d-2.jpg" alt=""></div>
                                                    <div>

                                                        <img class="u-img-fluid" src="${pageContext.request.contextPath}/resources/images/product/product-d-3.jpg" alt=""></div>
                                                    <div>

                                                        <img class="u-img-fluid" src="${pageContext.request.contextPath}/resources/images/product/product-d-4.jpg" alt=""></div>
                                                    <div>

                                                        <img class="u-img-fluid" src="${pageContext.request.contextPath}/resources/images/product/product-d-5.jpg" alt=""></div>
                                                </div>
                                            </div>
                                            <div class="u-s-m-t-15">
                                                <div id="js-product-detail-modal-thumbnail">
                                                    <div>

                                                        <img class="u-img-fluid" src="${pageContext.request.contextPath}/resources/images/product/product-d-1.jpg" alt=""></div>
                                                    <div>

                                                        <img class="u-img-fluid" src="${pageContext.request.contextPath}/resources/images/product/product-d-2.jpg" alt=""></div>
                                                    <div>

                                                        <img class="u-img-fluid" src="${pageContext.request.contextPath}/resources/images/product/product-d-3.jpg" alt=""></div>
                                                    <div>

                                                        <img class="u-img-fluid" src="${pageContext.request.contextPath}/resources/images/product/product-d-4.jpg" alt=""></div>
                                                    <div>

                                                        <img class="u-img-fluid" src="${pageContext.request.contextPath}/resources/images/product/product-d-5.jpg" alt=""></div>
                                                </div>
                                            </div>
                                        </div>
                                        <!--====== End - Product Detail ======-->
                                    </div>
                                    <div class="col-lg-7">

                                        <!--====== Product Right Side Details ======-->
                                        <div class="pd-detail">
                                            <div>

                                                <span class="pd-detail__name">${product.name}</span></div>
                                            <div>
                                                <div class="pd-detail__inline">

                                                    <span class="pd-detail__price">${product.price}đ</span>

                                                    <span class="pd-detail__discount">(10% OFF)</span><del class="pd-detail__del">${product.price + 0.1* product.price}đ</del></div>
                                            </div>
                                            <div class="u-s-m-b-15">
                                                <div class="pd-detail__rating gl-rating-style"><i class="fas fa-star"></i><i class="fas fa-star"></i><i class="fas fa-star"></i><i class="fas fa-star"></i><i class="fas fa-star-half-alt"></i>

                                                    <span class="pd-detail__review u-s-m-l-4">

                                                <a href="${pageContext.request.contextPath}/product/product_detail?id=${product.idProduct}">23 Reviews</a></span></div>
                                            </div>
                                            <div class="u-s-m-b-15">
                                                <div class="pd-detail__inline">

                                                    <span class="pd-detail__stock">200 in stock</span>

                                                    <span class="pd-detail__left">Only 2 left</span></div>
                                            </div>
                                            <div class="u-s-m-b-15">

                                                <span class="pd-detail__preview-desc">${product.description}.</span></div>
                                            <div class="u-s-m-b-15">
                                                <div class="pd-detail__inline">

                                            <span class="pd-detail__click-wrap"><i class="far fa-heart u-s-m-r-6"></i>

                                                <a href="signin.html">Add to Wishlist</a>

                                                <span class="pd-detail__click-count">(222)</span></span></div>
                                            </div>
                                            <div class="u-s-m-b-15">
                                                <div class="pd-detail__inline">

                                            <span class="pd-detail__click-wrap"><i class="far fa-envelope u-s-m-r-6"></i>

                                                <a href="signin.html">Email me When the price drops</a>

                                                <span class="pd-detail__click-count">(20)</span></span></div>
                                            </div>
                                            <div class="u-s-m-b-15">
                                                <ul class="pd-social-list">
                                                    <li>

                                                        <a class="s-fb--color-hover" href="#"><i class="fab fa-facebook-f"></i></a></li>
                                                    <li>

                                                        <a class="s-tw--color-hover" href="#"><i class="fab fa-twitter"></i></a></li>
                                                    <li>

                                                        <a class="s-insta--color-hover" href="#"><i class="fab fa-instagram"></i></a></li>
                                                    <li>

                                                        <a class="s-wa--color-hover" href="#"><i class="fab fa-whatsapp"></i></a></li>
                                                    <li>

                                                        <a class="s-gplus--color-hover" href="#"><i class="fab fa-google-plus-g"></i></a></li>
                                                </ul>
                                            </div>
                                            <div class="u-s-m-b-15">
                                                <form class="pd-detail__form">
                                                    <div class="pd-detail-inline-2">
                                                        <div class="u-s-m-b-15">

                                                            <!--====== Input Counter ======-->
                                                            <div class="input-counter">

                                                                <span class="input-counter__minus fas fa-minus"></span>

                                                                <input class="input-counter__text input-counter--text-primary-style" type="text" value="1" data-min="1" data-max="1000">

                                                                <span class="input-counter__plus fas fa-plus"></span></div>
                                                            <!--====== End - Input Counter ======-->
                                                        </div>
                                                        <div class="u-s-m-b-15">

                                                            <button class="btn btn--e-brand-b-2" type="submit">Add to Cart</button></div>
                                                    </div>
                                                </form>
                                            </div>
                                            <div class="u-s-m-b-15">

                                                <span class="pd-detail__label u-s-m-b-8">Product Policy:</span>
                                                <ul class="pd-detail__policy-list">
                                                    <li><i class="fas fa-check-circle u-s-m-r-8"></i>

                                                        <span>Buyer Protection.</span></li>
                                                    <li><i class="fas fa-check-circle u-s-m-r-8"></i>

                                                        <span>Full Refund if you don't receive your order.</span></li>
                                                    <li><i class="fas fa-check-circle u-s-m-r-8"></i>

                                                        <span>Returns accepted if product not as described.</span></li>
                                                </ul>
                                            </div>
                                        </div>
                                        <!--====== End - Product Right Side Details ======-->
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </c:forEach>
        <div class="modal fade" id="quick-look">
            <div class="modal-dialog modal-dialog-centered">
                <div class="modal-content modal--shadow">

                    <button class="btn dismiss-button fas fa-times" type="button" data-dismiss="modal"></button>
                    <div class="modal-body">
                        <div class="row">
                            <div class="col-lg-5">

                                <!--====== Product Breadcrumb ======-->
                                <div class="pd-breadcrumb u-s-m-b-30">
                                    <ul class="pd-breadcrumb__list">
                                        <li class="has-separator">

                                            <a href="${pageContext.request.contextPath}/">Home</a></li>
                                        <li class="has-separator">

                                            <a href="shop-side-version-2.html">Electronics</a></li>
                                        <li class="has-separator">

                                            <a href="shop-side-version-2.html">Men Clothing</a></li>
                                        <li class="is-marked">

                                            <a href="shop-side-version-2.html">Women Clothing</a></li>
                                    </ul>
                                </div>
                                <!--====== End - Product Breadcrumb ======-->


                                <!--====== Product Detail ======-->
                                <div class="pd u-s-m-b-30">
                                    <div class="pd-wrap">
                                        <div id="js-product-detail-modal">
                                            <div>

                                                <img class="u-img-fluid" src="${pageContext.request.contextPath}/resources/images/product/product-d-1.jpg" alt=""></div>
                                            <div>

                                                <img class="u-img-fluid" src="${pageContext.request.contextPath}/resources/images/product/product-d-2.jpg" alt=""></div>
                                            <div>

                                                <img class="u-img-fluid" src="${pageContext.request.contextPath}/resources/images/product/product-d-3.jpg" alt=""></div>
                                            <div>

                                                <img class="u-img-fluid" src="${pageContext.request.contextPath}/resources/images/product/product-d-4.jpg" alt=""></div>
                                            <div>

                                                <img class="u-img-fluid" src="${pageContext.request.contextPath}/resources/images/product/product-d-5.jpg" alt=""></div>
                                        </div>
                                    </div>
                                    <div class="u-s-m-t-15">
                                        <div id="js-product-detail-modal-thumbnail">
                                            <div>

                                                <img class="u-img-fluid" src="${pageContext.request.contextPath}/resources/images/product/product-d-1.jpg" alt=""></div>
                                            <div>

                                                <img class="u-img-fluid" src="${pageContext.request.contextPath}/resources/images/product/product-d-2.jpg" alt=""></div>
                                            <div>

                                                <img class="u-img-fluid" src="${pageContext.request.contextPath}/resources/images/product/product-d-3.jpg" alt=""></div>
                                            <div>

                                                <img class="u-img-fluid" src="${pageContext.request.contextPath}/resources/images/product/product-d-4.jpg" alt=""></div>
                                            <div>

                                                <img class="u-img-fluid" src="${pageContext.request.contextPath}/resources/images/product/product-d-5.jpg" alt=""></div>
                                        </div>
                                    </div>
                                </div>
                                <!--====== End - Product Detail ======-->
                            </div>
                            <div class="col-lg-7">

                                <!--====== Product Right Side Details ======-->
                                <div class="pd-detail">
                                    <div>

                                        <span class="pd-detail__name">Nikon Camera 4k Lens Zoom Pro</span></div>
                                    <div>
                                        <div class="pd-detail__inline">

                                            <span class="pd-detail__price">$6.99</span>

                                            <span class="pd-detail__discount">(76% OFF)</span><del class="pd-detail__del">$28.97</del></div>
                                    </div>
                                    <div class="u-s-m-b-15">
                                        <div class="pd-detail__rating gl-rating-style"><i class="fas fa-star"></i><i class="fas fa-star"></i><i class="fas fa-star"></i><i class="fas fa-star"></i><i class="fas fa-star-half-alt"></i>

                                            <span class="pd-detail__review u-s-m-l-4">

                                                <a href="${pageContext.request.contextPath}/product/product_detail/10">23 Reviews</a></span></div>
                                    </div>
                                    <div class="u-s-m-b-15">
                                        <div class="pd-detail__inline">

                                            <span class="pd-detail__stock">200 in stock</span>

                                            <span class="pd-detail__left">Only 2 left</span></div>
                                    </div>
                                    <div class="u-s-m-b-15">

                                        <span class="pd-detail__preview-desc">Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.</span></div>
                                    <div class="u-s-m-b-15">
                                        <div class="pd-detail__inline">

                                            <span class="pd-detail__click-wrap"><i class="far fa-heart u-s-m-r-6"></i>

                                                <a href="signin.html">Add to Wishlist</a>

                                                <span class="pd-detail__click-count">(222)</span></span></div>
                                    </div>
                                    <div class="u-s-m-b-15">
                                        <div class="pd-detail__inline">

                                            <span class="pd-detail__click-wrap"><i class="far fa-envelope u-s-m-r-6"></i>

                                                <a href="signin.html">Email me When the price drops</a>

                                                <span class="pd-detail__click-count">(20)</span></span></div>
                                    </div>
                                    <div class="u-s-m-b-15">
                                        <ul class="pd-social-list">
                                            <li>

                                                <a class="s-fb--color-hover" href="#"><i class="fab fa-facebook-f"></i></a></li>
                                            <li>

                                                <a class="s-tw--color-hover" href="#"><i class="fab fa-twitter"></i></a></li>
                                            <li>

                                                <a class="s-insta--color-hover" href="#"><i class="fab fa-instagram"></i></a></li>
                                            <li>

                                                <a class="s-wa--color-hover" href="#"><i class="fab fa-whatsapp"></i></a></li>
                                            <li>

                                                <a class="s-gplus--color-hover" href="#"><i class="fab fa-google-plus-g"></i></a></li>
                                        </ul>
                                    </div>
                                    <div class="u-s-m-b-15">
                                        <form class="pd-detail__form">
                                            <div class="pd-detail-inline-2">
                                                <div class="u-s-m-b-15">

                                                    <!--====== Input Counter ======-->
                                                    <div class="input-counter">

                                                        <span class="input-counter__minus fas fa-minus"></span>

                                                        <input class="input-counter__text input-counter--text-primary-style" type="text" value="1" data-min="1" data-max="1000">

                                                        <span class="input-counter__plus fas fa-plus"></span></div>
                                                    <!--====== End - Input Counter ======-->
                                                </div>
                                                <div class="u-s-m-b-15">

                                                    <button class="btn btn--e-brand-b-2" type="submit">Add to Cart</button></div>
                                            </div>
                                        </form>
                                    </div>
                                    <div class="u-s-m-b-15">

                                        <span class="pd-detail__label u-s-m-b-8">Product Policy:</span>
                                        <ul class="pd-detail__policy-list">
                                            <li><i class="fas fa-check-circle u-s-m-r-8"></i>

                                                <span>Buyer Protection.</span></li>
                                            <li><i class="fas fa-check-circle u-s-m-r-8"></i>

                                                <span>Full Refund if you don't receive your order.</span></li>
                                            <li><i class="fas fa-check-circle u-s-m-r-8"></i>

                                                <span>Returns accepted if product not as described.</span></li>
                                        </ul>
                                    </div>
                                </div>
                                <!--====== End - Product Right Side Details ======-->
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!--====== End - Quick Look Modal ======-->


        <!--====== Add to Cart Modal ======-->
        <div class="modal fade" id="add-to-cart">
            <div class="modal-dialog modal-dialog-centered">
                <div class="modal-content modal-radius modal-shadow">

                    <button class="btn dismiss-button fas fa-times" type="button" data-dismiss="modal"></button>
                    <div class="modal-body">
                        <div class="row">
                            <div class="col-lg-6 col-md-12">
                                <div class="success u-s-m-b-30">
                                    <div class="success__text-wrap"><i class="fas fa-check"></i>

                                        <span>Item is added successfully!</span></div>
                                    <div class="success__img-wrap">

                                        <img class="u-img-fluid" src="${pageContext.request.contextPath}/resources/images/product/electronic/product1.jpg" alt=""></div>
                                    <div class="success__info-wrap">

                                        <span class="success__name">Beats Bomb Wireless Headphone</span>

                                        <span class="success__quantity">Quantity: 1</span>

                                        <span class="success__price">$170.00</span></div>
                                </div>
                            </div>
                            <div class="col-lg-6 col-md-12">
                                <div class="s-option">

                                    <span class="s-option__text">1 item (s) in your cart</span>
                                    <div class="s-option__link-box">

                                        <a class="s-option__link btn--e-white-brand-shadow" data-dismiss="modal">CONTINUE SHOPPING</a>

                                        <a class="s-option__link btn--e-white-brand-shadow" href="${pageContext.request.contextPath}/cart/">VIEW CART</a>

                                        <a class="s-option__link btn--e-brand-shadow" href="checkout.html">PROCEED TO CHECKOUT</a></div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!--====== End - Add to Cart Modal ======-->


        <!--====== Newsletter Subscribe Modal ======-->
        <div class="modal fade new-l" id="newsletter-modal">
            <div class="modal-dialog modal-dialog-centered">
                <div class="modal-content modal--shadow">

                    <button class="btn new-l__dismiss fas fa-times" type="button" data-dismiss="modal"></button>
                    <div class="modal-body">
                        <div class="row u-s-m-x-0">
                            <div class="col-lg-6 new-l__col-1 u-s-p-x-0">

                                <a class="new-l__img-wrap u-d-block" href="shop-side-version-2.html">

                                    <img class="u-img-fluid u-d-block" src="${pageContext.request.contextPath}/resources/images/newsletter/newsletter.jpg" alt="">
                                </a>
                                
                                </div>
                            <div class="col-lg-6 new-l__col-2">
                                <div class="new-l__section u-s-m-t-30">
                                    <div class="u-s-m-b-8 new-l--center">
                                        <h3 class="new-l__h3">Newsletter</h3>
                                    </div>
                                    <div class="u-s-m-b-30 new-l--center">
                                        <p class="new-l__p1">Sign up for emails to get the scoop on new arrivals, special sales and more.</p>
                                    </div>
                                    <form class="new-l__form">
                                        <div class="u-s-m-b-15">

                                            <input class="news-l__input" type="text" placeholder="E-mail Address"></div>
                                        <div class="u-s-m-b-15">

                                            <button class="btn btn--e-brand-b-2" type="submit">Sign up!</button></div>
                                    </form>
                                    <div class="u-s-m-b-15 new-l--center">
                                        <p class="new-l__p2">By Signing up, you agree to receive Reshop offers,<br />promotions and other commercial messages. You may unsubscribe at any time.</p>
                                    </div>
                                    <div class="u-s-m-b-15 new-l--center">

                                        <a class="new-l__link" data-dismiss="modal">No Thanks</a></div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            </div>
        </div>
        <!--====== End - Newsletter Subscribe Modal ======-->
        <!--====== End - Modal Section ======-->
    </div>
    <!--====== End - Main App ======-->
    <script>
        document.getElementById("sign-out-btt").onclick = function() {
            <%HttpSession session1 = request.getSession();
            session1.removeAttribute("url_prior_login");
            %>


            document.getElementById("sign-out-form").submit();
        }
    </script>

    <!--====== Google Analytics: change UA-XXXXX-Y to be your site's ID ======-->
    <script>
        window.ga = function() {
            ga.q.push(arguments)
        };
        ga.q = [];
        ga.l = +new Date;
        ga('create', 'UA-XXXXX-Y', 'auto');
        ga('send', 'pageview')
    </script>
    <script src="https://www.google-analytics.com/analytics.js" async defer></script>

    <!--====== Vendor Js ======-->
    <script src="${pageContext.request.contextPath}/resources/js/vendor.js"></script>

    <!--====== jQuery Shopnav plugin ======-->
    <script src="${pageContext.request.contextPath}/resources/js/jquery.shopnav.js"></script>

    <!--====== App ======-->
    <script src="${pageContext.request.contextPath}/resources/js/app.js"></script>

    <!--====== Noscript ======-->
    <noscript>
        <div class="app-setting">
            <div class="container">
                <div class="row">
                    <div class="col-12">
                        <div class="app-setting__wrap">
                            <h1 class="app-setting__h1">JavaScript is disabled in your browser.</h1>

                            <span class="app-setting__text">Please enable JavaScript in your browser or upgrade to a JavaScript-capable browser.</span>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </noscript>

</body>
</html>