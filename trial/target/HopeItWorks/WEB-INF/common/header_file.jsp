<%-- 
    Document   : header_file
    Created on : 7 Feb, 2015, 3:18:29 PM
    Author     : shweta
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <style type="text/css">
            header{
                height:auto;
                width: 100%;
                //font-size: 2em;
                font-family: Helvetica;//, Verdana;   
                //text-align: center;
                line-height: 1.618em;
                background-color: #002263;
                overflow: hidden;

                -moz-box-shadow: 1px 1px 3px 2px #727290;
                -webkit-box-shadow: 1px 1px 3px 2px #727290;
                box-shadow:         1px 1px 3px 2px #727290;

            }
            h1{
                text-align: center;
                padding-top: 0.5em;
                padding-bottom: 0.5em;
                padding-left: 0.5em;
                margin: 0 auto;
                color: #ffffff; 
                font-weight: bold;
                text-shadow: 4px 4px 2px rgba(189,189,189, 0.8);
            }
            #div_grey{
                background-color: #e8e5c3;
                //width: 100%;
                height: 0.213em;
            }
            #div_blue{
                background-color: #002263;
                //width: 100%;
                height:0.4em;
            }
            #div_white{
                background-color: #e8e5c3;
                //width: 100%;
                height:0.15em;
            }
            @media only screen and (min-width: 700px){
                h1{
                    font-size: 2.5em;
                    padding-top: 1em;
                    padding-bottom: 1em;
                    text-align: center;
                }
            }
        </style>
        <title></title>
    </head>
    <body>
        <div class="header-container">
            <header>
                <!-- <img src="" alt="Logo" id="logo">-->
                <h1>RRC Constructions</h1>
                <div id="div_white"></div>
                <div id="div_blue"></div>
                <div id="div_white"></div>
                <div id="div_blue" style="height:0.7em;"></div>
            </header>

        </div>
    </body>
</html>
