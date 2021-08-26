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
        <header class="header--style-1 header--box-shadow">

            <!--====== Nav 1 ======-->
            <nav class="primary-nav primary-nav-wrapper--border">
                <div class="container">

                    <!--====== Primary Nav ======-->
                    <div class="primary-nav">

                        <!--====== Main Logo ======-->

                        <a class="main-logo" href="index.html">

                            <img src="${pageContext.request.contextPath}/resources/images/logo/logo-1.png" alt=""></a>
                        <!--====== End - Main Logo ======-->


                        <!--====== Search Form ======-->
                        <form class="main-form">

                            <label for="main-search"></label>

                            <input class="input-text input-text--border-radius input-text--style-1" type="text" id="main-search" placeholder="Search">

                            <button class="btn btn--icon fas fa-search main-search-button" type="submit"></button></form>
                        <!--====== End - Search Form ======-->


                        <!--====== Dropdown Main plugin ======-->
                        <div class="menu-init" id="navigation">

                            <button class="btn btn--icon toggle-button fas fa-cogs" type="button"></button>

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
                                            <li>

                                                <a href="dashboard.html"><i class="fas fa-user-circle u-s-m-r-6"></i>

                                                    <span>Account</span></a></li>

                                            <form:form action="${pageContext.request.contextPath}/logout"
                                                       method="post" id="sign-out-form">
                                                <li>

                                                    <a id="sign-out-btt" href="#"><i class="fas fa-lock-open u-s-m-r-6 sign-out-btt-1"></i>
                                                        <span>Signout</span></a>
                                                        <%--                                                    <input type="submit" value="Logout" /><i class="fas fa-lock-open u-s-m-r-6"></i>--%>
                                                        <%--                                                    <span>Signout</span></a></li>--%>

                                                </li>
                                            </form:form>
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

                                                            <a href="index.html"><i class="fas fa-utensils u-s-m-r-6"></i>

                                                                <span>Food & Supplies</span></a>

                                                            <span class="js-menu-toggle"></span></li>
                                                        <li>

                                                            <a href="index.html"><i class="fas fa-couch u-s-m-r-6"></i>

                                                                <span>Furniture & Decor</span></a>

                                                            <span class="js-menu-toggle"></span></li>
                                                        <li>

                                                            <a href="index.html"><i class="fas fa-football-ball u-s-m-r-6"></i>

                                                                <span>Sports & Game</span></a>

                                                            <span class="js-menu-toggle"></span></li>
                                                        <li>

                                                            <a href="index.html"><i class="fas fa-heartbeat u-s-m-r-6"></i>

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

                            <button class="btn btn--icon toggle-button fas fa-cog" type="button"></button>

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

                                                        <a href="index.html">Home 1</a></li>
                                                    <li>

                                                        <a href="index-2.html">Home 2</a></li>
                                                    <li>

                                                        <a href="index-3.html">Home 3</a></li>
                                                </ul>
                                                <!--====== End - Dropdown ======-->
                                            </li>
                                            <li class="has-dropdown has-dropdown--ul-left-100">

                                                <a>Account<i class="fas fa-angle-down i-state-right u-s-m-l-6"></i></a>

                                                <!--====== Dropdown ======-->

                                                <span class="js-menu-toggle"></span>
                                                <ul style="width:200px">
                                                    <li>

                                                        <a href="signin.html">Signin / Already Registered</a></li>
                                                    <li>

                                                        <a href="signup.html">Signup / Register</a></li>
                                                    <li>

                                                        <a href="lost-password.html">Lost Password</a></li>
                                                </ul>
                                                <!--====== End - Dropdown ======-->
                                            </li>
                                            <li class="has-dropdown has-dropdown--ul-left-100">

                                                <a href="dashboard.html">Dashboard<i class="fas fa-angle-down i-state-right u-s-m-l-6"></i></a>

                                                <!--====== Dropdown ======-->

                                                <span class="js-menu-toggle"></span>
                                                <ul style="width:200px">
                                                    <li class="has-dropdown has-dropdown--ul-left-100">

                                                        <a href="dashboard.html">Manage My Account<i class="fas fa-angle-down i-state-right u-s-m-l-6"></i></a>

                                                        <!--====== Dropdown ======-->

                                                        <span class="js-menu-toggle"></span>
                                                        <ul style="width:180px">
                                                            <li>

                                                                <a href="dash-edit-profile.html">Edit Profile</a></li>
                                                            <li>

                                                                <a href="dash-address-book.html">Edit Address Book</a></li>
                                                            <li>

                                                                <a href="dash-manage-order.html">Manage Order</a></li>
                                                        </ul>
                                                        <!--====== End - Dropdown ======-->
                                                    </li>
                                                    <li>

                                                        <a href="dash-my-profile.html">My Profile</a></li>
                                                    <li class="has-dropdown has-dropdown--ul-left-100">

                                                        <a href="dash-address-book.html">Address Book<i class="fas fa-angle-down i-state-right u-s-m-l-6"></i></a>

                                                        <!--====== Dropdown ======-->

                                                        <span class="js-menu-toggle"></span>
                                                        <ul style="width:180px">
                                                            <li>

                                                                <a href="dash-address-make-default.html">Address Make Default</a></li>
                                                            <li>

                                                                <a href="dash-address-add.html">Add New Address</a></li>
                                                            <li>

                                                                <a href="dash-address-edit.html">Edit Address Book</a></li>
                                                        </ul>
                                                        <!--====== End - Dropdown ======-->
                                                    </li>
                                                    <li>

                                                        <a href="dash-track-order.html">Track Order</a></li>
                                                    <li>

                                                        <a href="dash-my-order.html">My Orders</a></li>
                                                    <li>

                                                        <a href="dash-payment-option.html">My Payment Options</a></li>
                                                    <li>

                                                        <a href="dash-cancellation.html">My Returns & Cancellations</a></li>
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

                                                        <a href="product-detail.html">Product Details</a></li>
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

                            <button class="btn btn--icon toggle-button fas fa-shopping-bag toggle-button-shop" type="button"></button>

                            <span class="total-item-round">${total_amount}</span>

                            <!--====== Menu ======-->
                            <div class="ah-lg-mode">

                                <span class="ah-close">✕ Close</span>

                                <!--====== List ======-->
                                <ul class="ah-list ah-list--design1 ah-list--link-color-secondary">
                                    <li>

                                        <a href="index.html"><i class="fas fa-home"></i></a></li>
                                    <li>

                                        <a href="wishlist.html"><i class="far fa-heart"></i></a></li>
                                    <li class="has-dropdown">

                                        <a class="mini-cart-shop-link"><i class="fas fa-shopping-bag"></i>

                                            <span class="total-item-round">${total_amount}</span></a>

                                        <!--====== Dropdown ======-->

                                        <span class="js-menu-toggle"></span>
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

                                                                <a href="shop-side-version-2.html">${cart_product.type}</a></span>

                                                                <span class="mini-product__name">

                                                                <a href="product-detail.html">${cart_product.name}</a></span>

                                                                <span class="mini-product__quantity">${cart_product.amount} x</span>

                                                                <span class="mini-product__price">${cart_product.total_money} VNĐ</span></div>
                                                        </div>

                                                        <a class="mini-product__delete-link far fa-trash-alt"></a>
                                                    </div>
                                                </c:forEach>

                                            </div>
                                            <!--====== End - Mini Product Container ======-->


                                            <!--====== Mini Product Statistics ======-->
                                            <div class="mini-product-stat">
                                                <div class="mini-total">

                                                    <span class="subtotal-text">SUBTOTAL</span>

                                                    <span class="subtotal-value">$16</span></div>
                                                <div class="mini-action">

                                                    <a class="mini-link btn--e-brand-b-2" href="checkout.jsp">PROCEED TO CHECKOUT</a>

                                                    <a class="mini-link btn--e-transparent-secondary-b-2" href="${pageContext.request.contextPath}/cart/">VIEW CART</a></div>
                                            </div>
                                            <!--====== End - Mini Product Statistics ======-->
                                        </div>
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

            <!--====== Section 1 ======-->
            <div class="u-s-p-y-60">

                <!--====== Section Content ======-->
                <div class="section__content">
                    <div class="container">
                        <div class="breadcrumb">
                            <div class="breadcrumb__wrap">
                                <ul class="breadcrumb__list">
                                    <li class="has-separator">

                                        <a href="${pageContext.request.contextPath}/">Home</a></li>
                                    <li class="is-marked">

                                        <a href="${pageContext.request.contextPath}/checkout/">Checkout</a></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!--====== End - Section 1 ======-->


            <!--====== Section 2 ======-->

            <!--====== End - Section 2 ======-->


            <!--====== Section 3 ======-->
            <div class="u-s-p-b-60">

                <!--====== Section Content ======-->
                <div class="section__content">
                    <div class="container">
                        <div class="checkout-f">
                            <div class="row">
                                <div class="col-lg-6">
                                    <h1 class="checkout-f__h1">DELIVERY INFORMATION</h1>
                                    <form class="checkout-f__delivery">
                                        <div class="u-s-m-b-30">
                                            <div class="u-s-m-b-15">

                                                <!--====== Check Box ======-->
                                                <div class="check-box">

                                                    <input type="checkbox" id="get-address">
                                                    <div class="check-box__state check-box__state--primary">

                                                        <label class="check-box__label" for="get-address">Use default shipping and billing address from account</label></div>
                                                </div>
                                                <!--====== End - Check Box ======-->
                                            </div>

                                            <!--====== First Name, Last Name ======-->
                                            <div class="gl-inline">
                                                <div class="u-s-m-b-15">

                                                    <label class="gl-label" for="billing-fname">FIRST NAME *</label>

                                                    <input class="input-text input-text--primary-style" type="text" id="billing-fname" data-bill=""></div>
                                                <div class="u-s-m-b-15">

                                                    <label class="gl-label" for="billing-lname">LAST NAME *</label>

                                                    <input class="input-text input-text--primary-style" type="text" id="billing-lname" data-bill=""></div>
                                            </div>
                                            <!--====== End - First Name, Last Name ======-->


                                            <!--====== E-MAIL ======-->
                                            <div class="u-s-m-b-15">

                                                <label class="gl-label" for="billing-email">E-MAIL *</label>

                                                <input class="input-text input-text--primary-style" type="text" id="billing-email" data-bill=""></div>
                                            <!--====== End - E-MAIL ======-->


                                            <!--====== PHONE ======-->
                                            <div class="u-s-m-b-15">

                                                <label class="gl-label" for="billing-phone">PHONE *</label>

                                                <input class="input-text input-text--primary-style" type="text" id="billing-phone" data-bill=""></div>
                                            <!--====== End - PHONE ======-->


                                            <!--====== Street Address ======-->
                                            <div class="u-s-m-b-15">

                                                <label class="gl-label" for="billing-street">STREET ADDRESS *</label>

                                                <input class="input-text input-text--primary-style" type="text" id="billing-street" placeholder="House name and street name" data-bill=""></div>
                                            <div class="u-s-m-b-15">

                                                <label for="billing-street-optional"></label>

                                                <input class="input-text input-text--primary-style" type="text" id="billing-street-optional" placeholder="Apartment, suite unit etc. (optional)" data-bill=""></div>
                                            <!--====== End - Street Address ======-->


                                            <!--====== Country ======-->
                                            <div class="u-s-m-b-15">

                                                <!--====== Select Box ======-->

                                                <label class="gl-label" for="billing-country">COUNTRY *</label><select class="select-box select-box--primary-style" id="billing-country" data-bill="">
                                                    <option selected value="">Choose Country</option>
                                                    <option value="uae">United Arab Emirate (UAE)</option>
                                                    <option value="uk">United Kingdom (UK)</option>
                                                    <option value="us">United States (US)</option>
                                                </select>
                                                <!--====== End - Select Box ======-->
                                            </div>
                                            <!--====== End - Country ======-->


                                            <!--====== Town / City ======-->
                                            <div class="u-s-m-b-15">

                                                <label class="gl-label" for="billing-town-city">TOWN/CITY *</label>

                                                <input class="input-text input-text--primary-style" type="text" id="billing-town-city" data-bill=""></div>
                                            <!--====== End - Town / City ======-->


                                            <!--====== STATE/PROVINCE ======-->
                                            <div class="u-s-m-b-15">

                                                <!--====== Select Box ======-->

                                                <label class="gl-label" for="billing-state">STATE/PROVINCE *</label><select class="select-box select-box--primary-style" id="billing-state" data-bill="">
                                                    <option selected value="">Choose State/Province</option>
                                                    <option value="al">Alabama</option>
                                                    <option value="al">Alaska</option>
                                                    <option value="ny">New York</option>
                                                </select>
                                                <!--====== End - Select Box ======-->
                                            </div>
                                            <!--====== End - STATE/PROVINCE ======-->


                                            <!--====== ZIP/POSTAL ======-->
                                            <div class="u-s-m-b-15">

                                                <label class="gl-label" for="billing-zip">ZIP/POSTAL CODE *</label>

                                                <input class="input-text input-text--primary-style" type="text" id="billing-zip" placeholder="Zip/Postal Code" data-bill=""></div>
                                            <!--====== End - ZIP/POSTAL ======-->
                                            <div class="u-s-m-b-10">

                                                <!--====== Check Box ======-->
                                                <div class="check-box">

                                                    <input type="checkbox" id="make-default-address" data-bill="">
                                                    <div class="check-box__state check-box__state--primary">

                                                        <label class="check-box__label" for="make-default-address">Make default shipping and billing address</label></div>
                                                </div>
                                                <!--====== End - Check Box ======-->
                                            </div>
                                            <div class="u-s-m-b-10">

                                                <a class="gl-link" href="#create-account" data-toggle="collapse">Want to create a new account?</a></div>
                                            <div class="collapse u-s-m-b-15" id="create-account">

                                                <span class="gl-text u-s-m-b-15">Create an account by entering the information below. If you are a returning customer please login at the top of the page.</span>
                                                <div>

                                                    <label class="gl-label" for="reg-password">Account Password *</label>

                                                    <input class="input-text input-text--primary-style" type="text" data-bill id="reg-password"></div>
                                            </div>
                                            <div class="u-s-m-b-10">

                                                <label class="gl-label" for="order-note">ORDER NOTE</label><textarea class="text-area text-area--primary-style" id="order-note"></textarea></div>
                                            <div>

                                                <button class="btn btn--e-transparent-brand-b-2" type="submit">SAVE</button></div>
                                        </div>
                                    </form>
                                </div>
                                <div class="col-lg-6">
                                    <h1 class="checkout-f__h1">ORDER SUMMARY</h1>

                                    <!--====== Order Summary ======-->
                                    <div class="o-summary">
                                        <div class="o-summary__section u-s-m-b-30">
                                            <div class="o-summary__item-wrap gl-scroll">
                                                <c:forEach var="cart" items="${cartProductList}">
                                                    <div class="o-card">
                                                        <div class="o-card__flex">
                                                            <div class="o-card__img-wrap">

                                                                <img class="u-img-fluid" src="${pageContext.request.contextPath}/resources/images/product/electronic/product3.jpg" alt=""></div>
                                                            <div class="o-card__info-wrap">

                                                            <span class="o-card__name">

                                                                <a href="${pageContext.request.contextPath}/product/product_detail?id=${cart.idProduct}">${cart.name}</a></span>

                                                                <span class="o-card__quantity">Quantity x ${cart.amount}</span>

                                                                <span class="o-card__price">${cart.total_money} VND</span></div>
                                                        </div>

                                                        <a class="o-card__del far fa-trash-alt"></a>
                                                    </div>
                                                </c:forEach>

                                            </div>
                                        </div>
                                        <div class="o-summary__section u-s-m-b-30">
                                            <div class="o-summary__box">
                                                <h1 class="checkout-f__h1">DELIVERY ADDRESS</h1>
                                                <div class="ship-b">

                                                    <span class="ship-b__text">Ship to:</span>
                                                    <div class="ship-b__box u-s-m-b-10">
                                                        <p class="ship-b__p">${customer_address}</p>

                                                        <a class="ship-b__edit btn--e-transparent-platinum-b-2" data-modal="modal" data-modal-id="#edit-ship-address">Edit</a>
                                                    </div>
                                                    
                                                </div>
                                            </div>
                                        </div>
                                        <div class="o-summary__section u-s-m-b-30">
                                            <div class="o-summary__box">
                                                <h1 class="checkout-f__h1">SHIPPING OPTION</h1>
                                                <c:forEach var="ship" items="${shippingCompanyList}">
                                                    <table class="o-summary__table">
                                                        <tr>
                                                            <td><div class="radio-box">
                                                                <input type="radio" class="giao-hang" name="shipping" onchange="changeVale();" value="${ship.idSCompany}">
                                                                <div class="radio-box__state radio-box__state--primary">
                                                                    <label class="radio-box__label" for="giao-hang">${ship.nameSCompany}</label></div>
                                                            </div></td>
                                                            <td class="shipping-company-fee"></td>
                                                        </tr>
                                                    </table>
                                                    <span class="gl-text u-s-m-t-6">Receive by 10 Aug - 15 Aug</span>
                                                </c:forEach>



                                                <br>
                                                <label class="ship-b__text" for="delivery-time">Preferred delivery time</label>
                                                    <select class="select-box select-box--primary-style" id="delivery-time">
                                                        <option selected value="">Choose Delivery Time</option>
                                                        <option value="any-time">Deliver any time</option>
                                                        <option value="office-hours">Deliver during office hours</option>
                                                    </select>
                                            </div>
                                        </div>
                                        
                                        
                                        <div class="o-summary__section u-s-m-b-30">
                                            <div class="o-summary__box">
                                                <h1 class="checkout-f__h1">PAYMENT INFORMATION</h1>
                                                <form:form class="checkout-f__payment" id="form-payment" action="${pageContext.request.contextPath}/checkout/" method="post" modelAttribute="orderModel">
                                                    <table class="o-summary__table">
                                                        <tr>
                                                            <td><div class="radio-box">
                                                            <input type="radio" id="cash-on-delivery" class="payment-method" value="1" onclick="checkChecked(this);"/>
                                                            <div class="radio-box__state radio-box__state--primary">
                                                            <label class="radio-box__label" for="cash-on-delivery">
                                                                <i class="fas fa-money-bill"></i>   Cash on Delivery</label></div>
                                                            </div></td>         
                                                        </tr>
                                                    </table>
                                                    <table class="o-summary__table">
                                                        <tr>
                                                            <td><div class="radio-box">
                                                            <input type="radio" id="pay-with-momo" class="payment-method" value="2" onclick="checkChecked(this);"/>
                                                            <div class="radio-box__state radio-box__state--primary">
                                                            <label class="radio-box__label" for="pay-with-momo">
                                                                <i class="fas fa-wallet"></i>   MOMO wallet</label></div>
                                                            </div></td>         
                                                            <td><a href="checkout-momo.html" class="ship-b__edit btn--e-transparent-platinum-b-2">Add</a></td>         
                                                        </tr>
                                                    </table>
                                                    <span class="gl-text u-s-m-t-6">Please add your MOMO wallet</span>
                                                    <table class="o-summary__table">
                                                        <tr>
                                                            <td><div class="radio-box">
                                                            <input type="radio" id="pay-with-card"  class="payment-method"  value="3" onclick="checkChecked(this);"/>
                                                            <div class="radio-box__state radio-box__state--primary">
                                                            <label class="radio-box__label" for="pay-with-card">
                                                                <i class="fas fa-credit-card"></i>  Credit / Debit Card${customer_bankAccount} </label>

                                                            </div>
                                                            </div></td>
                                                            <td><a href="checkout-bank-account.html" class="ship-b__edit btn--e-transparent-platinum-b-2">Add</a></td>         
                                                        </tr>
                                                    </table>
                                                    <span class="gl-text u-s-m-t-6">Please add your bank account or card number</span>
                                                    
                                                    <div class="u-s-m-b-15">

                                                        <!--====== Check Box ======-->
                                                        <div class="check-box">

                                                            <input type="checkbox" id="term-and-condition">
                                                            <div class="check-box__state check-box__state--primary">

                                                                <label class="check-box__label" for="term-and-condition">I consent to the</label></div>
                                                        </div>
                                                        <!--====== End - Check Box ======-->

                                                        <a class="gl-link">Terms of Service.</a>
                                                    </div>
                                                    <div class="o-summary__section u-s-m-b-30">
                                                        <div class="o-summary__box">
                                                            <table class="o-summary__table">
                                                                <tbody>
                                                                    <tr>
                                                                        <td>MERCHANDISE</td>
                                                                        <td id="total_val">${total_money} VND</td>




                                                                     </tr>
                                                                    <tr>
                                                                        <td>SHIPPING</td>
                                                                        <td id="ship_value"></td>
                                                                    </tr>
                                                                    <tr>
                                                                        <td>COUPON</td>
                                                                        <td>0 VND</td>
                                                                    </tr>
                                                                    <tr>
                                                                        <td>GRAND TOTAL</td>
                                                                        <td id="grand_value"></td>
                                                                    </tr>
                                                                </tbody>
                                                            </table>
                                                        </div>
                                                    </div>
                                                    <div>

                                                        <button class="btn btn--e-brand-b-2" type="button" onclick="submitFunction();" >PLACE ORDER</button></div>
                                                </form:form>
                                                <form:form class="checkout-f__payment" id="form-payment-2" action="${pageContext.request.contextPath}/checkout/" method="post" modelAttribute="cartProductModel">
                                                    <form:hidden path="tranMethod" id="cartProductTranMethod" value =""/>
                                                    <form:hidden path="idSCompany" id="cartProductIdSC" value=""/>
                                                </form:form>
                                            </div>
                                        </div>
                                    </div>
                                    <!--====== End - Order Summary ======-->
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <!--====== End - Section Content ======-->
            </div>
            <!--====== End - Section 3 ======-->
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

                                                    <a href="${pageContext.request.contextPath}/cart/">Cart</a></li>
                                                <li>

                                                    <a href="dashboard.html">Account</a></li>
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

                                                    <a href="index.html">Sitemap</a></li>
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

                                    <a href="index.html">Reshop</a>

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


        <!--====== Shipping Address Add Modal ======-->
        <div class="modal fade" id="edit-ship-address">
            <div class="modal-dialog modal-dialog-centered">
                <div class="modal-content">
                    <div class="modal-body">
                        <div class="checkout-modal2">
                            <div class="u-s-m-b-30">
                                <div class="dash-l-r">
                                    <h1 class="gl-modal-h1">Shipping Address</h1>
                                    <div class="dash__link dash__link--brand">

                                        <a data-modal="modal" data-modal-id="#add-ship-address" data-dismiss="modal">Add new Address</a></div>
                                </div>
                            </div>
                            <form class="checkout-modal2__form">
                                <div class="dash__table-2-wrap u-s-m-b-30 gl-scroll">
                                    <table class="dash__table-2">
                                        <thead>
                                            <tr>
                                                <th>Action</th>
                                                <th>Full Name</th>
                                                <th>Address</th>
                                                <th>Region</th>
                                                <th>Phone Number</th>
                                                <th>Status</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <tr>
                                                <td>

                                                    <!--====== Radio Box ======-->
                                                    <div class="radio-box">

                                                        <input type="radio" id="address-1" name="default-address" checked="">
                                                        <div class="radio-box__state radio-box__state--primary">

                                                            <label class="radio-box__label" for="address-1"></label></div>
                                                    </div>
                                                    <!--====== End - Radio Box ======-->
                                                </td>
                                                <td>John Doe</td>
                                                <td>4247 Ashford Drive Virginia VA-20006 USA</td>
                                                <td>Virginia VA-20006 USA</td>
                                                <td>(+0) 900901904</td>
                                                <td>
                                                    <div class="gl-text">Default Shipping Address</div>
                                                    <div class="gl-text">Default Billing Address</div>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td>

                                                    <!--====== Radio Box ======-->
                                                    <div class="radio-box">

                                                        <input type="radio" id="address-2" name="default-address">
                                                        <div class="radio-box__state radio-box__state--primary">

                                                            <label class="radio-box__label" for="address-2"></label></div>
                                                    </div>
                                                    <!--====== End - Radio Box ======-->
                                                </td>
                                                <td>Doe John</td>
                                                <td>1484 Abner Road</td>
                                                <td>Eau Claire WI - Wisconsin</td>
                                                <td>(+0) 7154419563</td>
                                                <td></td>
                                            </tr>
                                        </tbody>
                                    </table>
                                </div>
                                <div class="gl-modal-btn-group">

                                    <button class="btn btn--e-brand-b-2" type="submit">SAVE</button>

                                    <button class="btn btn--e-grey-b-2" type="button" data-dismiss="modal">CANCEL</button></div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!--====== End - Shipping Address Add Modal ======-->


        <!--====== Shipping Address Add Modal ======-->
        <div class="modal fade" id="add-ship-address">
            <div class="modal-dialog modal-dialog-centered">
                <div class="modal-content">
                    <div class="modal-body">
                        <div class="checkout-modal1">
                            <form class="checkout-modal1__form">
                                <div class="u-s-m-b-30">
                                    <h1 class="gl-modal-h1">Add new Shipping Address</h1>
                                </div>
                                <div class="gl-inline">
                                    <div class="u-s-m-b-30">

                                        <label class="gl-label" for="address-fname">FIRST NAME *</label>

                                        <input class="input-text input-text--primary-style" type="text" id="address-fname" placeholder="First Name"></div>
                                    <div class="u-s-m-b-30">

                                        <label class="gl-label" for="address-lname">LAST NAME *</label>

                                        <input class="input-text input-text--primary-style" type="text" id="address-lname" placeholder="Last Name"></div>
                                </div>
                                <div class="gl-inline">
                                    <div class="u-s-m-b-30">

                                        <label class="gl-label" for="address-phone">PHONE *</label>

                                        <input class="input-text input-text--primary-style" type="text" id="address-phone"></div>
                                    <div class="u-s-m-b-30">

                                        <label class="gl-label" for="address-street">STREET ADDRESS *</label>

                                        <input class="input-text input-text--primary-style" type="text" id="address-street" placeholder="House Name and Street"></div>
                                </div>
                                <div class="gl-inline">
                                    <div class="u-s-m-b-30">

                                        <!--====== Select Box ======-->

                                        <label class="gl-label" for="address-country">COUNTRY *</label><select class="select-box select-box--primary-style" id="address-country">
                                            <option selected value="">Choose Country</option>
                                            <option value="uae">United Arab Emirate (UAE)</option>
                                            <option value="uk">United Kingdom (UK)</option>
                                            <option value="us">United States (US)</option>
                                        </select>
                                        <!--====== End - Select Box ======-->
                                    </div>
                                    <div class="u-s-m-b-30">

                                        <!--====== Select Box ======-->

                                        <label class="gl-label" for="address-state">STATE/PROVINCE *</label><select class="select-box select-box--primary-style" id="address-state">
                                            <option selected value="">Choose State/Province</option>
                                            <option value="al">Alabama</option>
                                            <option value="al">Alaska</option>
                                            <option value="ny">New York</option>
                                        </select>
                                        <!--====== End - Select Box ======-->
                                    </div>
                                </div>
                                <div class="gl-inline">
                                    <div class="u-s-m-b-30">

                                        <label class="gl-label" for="address-city">TOWN/CITY *</label>

                                        <input class="input-text input-text--primary-style" type="text" id="address-city"></div>
                                    <div class="u-s-m-b-30">

                                        <label class="gl-label" for="address-street">ZIP/POSTAL CODE *</label>

                                        <input class="input-text input-text--primary-style" type="text" id="address-postal" placeholder="Zip/Postal Code"></div>
                                </div>
                                <div class="gl-modal-btn-group">

                                    <button class="btn btn--e-brand-b-2" type="submit">SAVE</button>

                                    <button class="btn btn--e-grey-b-2" type="button" data-dismiss="modal">CANCEL</button></div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!--====== End - Shipping Address Add Modal ======-->
        <!--====== End - Modal Section ======-->
    </div>
    <!--====== End - Main App ======-->

    <script>
        function checkChecked(e){
            e.checked = true
            let temp = document.getElementsByClassName("payment-method")
            for (let i = 0; i < temp.length; i++) {
                if (temp[i] != e){
                    temp[i].checked = false
                }
            }



        }
        function submitFunction(){
            let tempSelect = document.getElementsByClassName("payment-method");
            let tempSelect2 = document.getElementsByClassName("giao-hang");
            for (let i = 0; i < tempSelect.length; i++) {
                if (tempSelect[i].checked){
                    document.getElementById("cartProductTranMethod").value = tempSelect[i].value
                }
            }
            for (let i = 0; i < tempSelect2.length; i++) {
                if (tempSelect2[i].checked){
                    document.getElementById("cartProductIdSC").value = tempSelect2[i].value
                }
            }
            // document.getElementById("form-payment").submit()
            document.getElementById("form-payment-2").submit()
        }
        function changeVale(){
            let selectTemp = document.getElementsByClassName("giao-hang")
            let total = document.getElementById("total_val").innerHTML
            let totalVal = parseInt(total.split(" ")[0])
            for (let i = 0; i < selectTemp.length; i++) {
                if (selectTemp[i].checked){
                    let address = document.getElementsByClassName("ship-b__p")[0].innerHTML
                    let city = address.split(",")[2].trim().toLowerCase()
                    if (city === "ho chi minh" || city ==="ha noi" || city ==="da nang")
                    {
                        document.getElementById("ship_value").innerHTML = 30000+" VND"
                        let tempVal = totalVal + 30000
                        document.getElementById("grand_value").innerHTML = tempVal +" VND"
                    }
                    else{
                        document.getElementById("ship_value").innerHTML = 50000+" VND"
                        let tempVal = totalVal + 50000
                        document.getElementById("grand_value").innerHTML = tempVal +" VND"
                    }
                }
            }
        }

    </script>
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