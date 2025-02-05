<%@page contentType="text/html" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
            <!DOCTYPE html>
            <html lang="en">

            <head>
                <meta charset="utf-8" />
                <meta http-equiv="X-UA-Compatible" content="IE=edge" />
                <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
                <meta name="description" content="e-commerce website" />
                <meta name="author" content="minhhai205" />
                <title>Login</title>

                <link href="https://fonts.googleapis.com/css?family=Nunito:400,600,700,800&display=swap"
                    rel="stylesheet">

                <link rel="stylesheet" href="/client/css/auth.css" type="text/css">
            </head>

            <body>
                <div class="cont">
                    <form action="">
                        <div class="form sign-in">
                            <h2>Sign In</h2>
                            <label>
                                <span>Email Address</span>
                                <input type="email" name="email" />
                            </label>
                            <label>
                                <span>Password</span>
                                <input type="password" name="password" />
                            </label>
                            <button class="submit" type="submit">Sign In</button>


                            <div class="social-media">
                                <ul>
                                    <li><img src="images/facebook.png"></li>
                                    <li><img src="images/twitter.png"></li>
                                    <li><img src="images/linkedin.png"></li>
                                    <li><img src="images/instagram.png"></li>
                                </ul>
                            </div>
                        </div>
                    </form>


                    <div class="sub-cont">
                        <div class="img">
                            <div class="img-text m-up">
                                <h1>New here?</h1>
                                <p>sign up and discover</p>
                            </div>
                            <div class="img-text m-in">
                                <h1>One of us?</h1>
                                <p>just sign in</p>
                            </div>
                            <div class="img-btn">
                                <span class="m-up">Sign Up</span>
                                <span class="m-in">Sign In</span>
                            </div>
                        </div>

                        <form:form method="post" action="/auth/register" modelAttribute="registerUser">
                            <div class="form sign-up">
                                <h2>Sign Up</h2>
                                <label>
                                    <span>Name</span>
                                    <form:input type="text" path="name" />
                                </label>
                                <label>
                                    <span>Email</span>
                                    <form:input type="email" path="email" />
                                </label>
                                <label>
                                    <span>Password</span>
                                    <form:input type="password" path="password" />
                                </label>
                                <label>
                                    <span>Confirm Password</span>
                                    <form:input type="password" path="confirmPassword" />
                                </label>
                                <button type="submit" class="submit">Sign Up Now</button>
                            </div>
                        </form:form>
                    </div>


                </div>

                <script src="/client/js/auth.js"></script>

            </body>

            </html>