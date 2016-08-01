<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="header.jsp" %>
<html>
    <head>
        <link rel="stylesheet" href="Semantic-UI-1.0/dist/semantic.min.css" type="text/css">
        <link rel="stylesheet" href="css/constant.css" type="text/css">
        <link rel="stylesheet" href="css/homepage.css" type="text/css">
         <script src="js/jquery-2.1.4.min.js"></script>
          <script src="js/constant.js"></script>
         <script src="Semantic-UI-1.0/dist/semantic.min.js"></script>
         <link href="css/cdn.css" rel="stylesheet">
        <title>E-HEALTH|LOGIN PAGE</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        
        
        <div class="container">
        <div class="ui two column middle aligned very relaxed stackable grid" align="center">
            <form method="post" action="LoginServlet.do" onsubmit="return true">
            <div class="column">
                <div class="ui form">
                    <div class="field">
                        <label>Username</label>
                            <div class="ui left icon input">
                                <input type="text" placeholder="Username or E-mail ID" name="userName" value autofocus required pattern="^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\.[a-zA-Z0-9-.]+$" data-error="Invalid email address">
                                    <i class="user icon"></i>
                            </div>
                    </div>
                    <div class="field">
                        <label>Password</label>
                            <div class="ui left icon input">
                                <input type="password" placeholder="Password" name="passWord" value autofocus required>
                                    <i class="lock icon"></i>
                            </div>
                    </div>
                    <!--<div class="ui blue submit button" onclick="return true">Login</div>-->
                    <div class="col-xs-offset-3 col-xs-9">
                        <input type="submit" class="ui positive large button" name="validate" value="Submit">
                        <input type="reset" class="ui negative large button" value="Reset">
                    </div>
                </div>
            </div>
            <!--
            <div class="ui vertical divider">
                Or
            </div>
            
            <div class="center aligned column">
                <label> 
                    Sign Up Using
                </label>    <br>
                <button class="ui facebook button large">
                    <i class="facebook icon"></i>
                        Facebook
                </button>
                <button class="ui twitter button large">
                    <i class="twitter icon"></i>
                        Twitter
                </button>
                
                <button class="ui google plus button large">
                    <i class="google plus icon"></i>
                        Google Plus
                </button>
                
                <button class="ui vk button large">
                    <i class="vk icon"></i>
                    VK 
                </button>
                
                &nbsp;&nbsp;
                <button class="ui linkedin button large">
                    <i class="linkedin icon"></i>
                        LinkedIn
                </button>
                
            </div> 
            -->
            </form>
        </div>   
        </div> 
        <footer>
            <div class="ui inverted footer vertical segment center bottom" style=" position : absolute;bottom : 0;height: auto;margin-top : 40px; width: 100%;">
                <div class="ui stackable center aligned page grid">
                    <div class="three column row">

                        <div class="column">
                            <h5 class="ui inverted header">Schemes</h5>
                            <div class="ui inverted link list">
                                <a class="item">Schemes For SC/ST/OBC</a>
                                <a class="item">Schemes For The Old</a>
                                <a class="item">Schemes for BPL</a>
                                <a class='item'> Schemes For Handicapped </a>
                            </div>
                        </div>
                        <div class="column">
                            <h5 class="ui inverted header">Hospitals</h5>
                            <div class="ui inverted link list">
                                <a class="item">View List</a>
                            </div>
                        </div>


                        <div class="column">
                            <h5 class="ui inverted header">Designed By</h5>
                            Us!


                        </div>
                    </div>

copyright @ content
        <br />
       
        <br />
        <%= request.getParameter("subTitle")%>
        <br />
        ${param.subTitle}

                </div>
            </div>
            </footer>
        
        

       
    </body>
    
</html>