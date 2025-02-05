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
                <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>

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
                                    <c:set var="nameHasBindError">
                                        <form:errors path="email" style="color: #dc3545; font-size: 0.8em" />
                                    </c:set>
                                    <span>Email</span>
                                    <form:input type="email" path="email" />
                                    ${nameHasBindError}
                                </label>
                                <label>
                                    <span>Password</span>
                                    <form:input type="password" path="password" />
                                </label>
                                <label>
                                    <c:set var="nameHasBindError">
                                        <form:errors path="confirmPassword" style="color: #dc3545; font-size: 0.8em" />
                                    </c:set>
                                    <span>Confirm Password</span>
                                    <form:input type="password" path="confirmPassword" />
                                    ${nameHasBindError}
                                </label>
                                <button type="submit" class="submit">Sign Up</button>
                            </div>
                        </form:form>
                    </div>


                </div>
                <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
                    crossorigin="anonymous"></script>
                <script src="/client/js/auth.js"></script>

            </body>

            </html>