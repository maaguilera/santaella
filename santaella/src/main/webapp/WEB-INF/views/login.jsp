<%@ include file="/WEB-INF/views/include.jsp" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <!-- link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css"-->
        <link rel="stylesheet" href="web-resources/css/bootstrap.min.css">
        <link rel="stylesheet" href="web-resources/css/login.css">
       
        <title>Login</title>
        
        <style>
.error {
	color: red;
}
</style>
    </head>
    
    
    <body>
        <div class="container">

             <div class="text-center">
                <span><c:if test="${error == true}"><b class="error">Invalid login or password.</b></c:if></span>
            </div>
            <div class="text-center">
                <img src="web-resources/img/logo.png" alt="Metis Logo">
            </div>
            <div class="tab-content">
                <div id="login" class="tab-pane active">
                    <form method="post" action="<c:url value='j_spring_security_check'/>" class="form-signin">
                        <p class="muted text-center">
                            Enter your username and password
                        </p>
                        <input type="text" name="j_username" id="j_username" placeholder="Username" class="input-block-level" value="11111H">
                        <input type="password"  name="j_password" id="j_password" placeholder="Password" class="input-block-level" value="30823652H">
                        <button class="btn btn-large btn-primary btn-block" type="submit">Sign in</button>
                    </form>
                </div>
                <div id="forgot" class="tab-pane">
                    <form action="index.html" class="form-signin">
                        <p class="muted text-center">
                            Enter your valid e-mail
                        </p>
                        <input type="email" placeholder="mail@domain.com" required="required" class="input-block-level">
                        <br>
                        <br>
                        <button class="btn btn-large btn-danger btn-block" type="submit">Recover Password</button>
                    </form>
                </div>
                <div id="signup" class="tab-pane">
                    <form action="index.html" class="form-signin">
                        <input type="text" placeholder="username" class="input-block-level">
                        <input type="email" placeholder="mail@domain.com" class="input-block-level">
                        <input type="password" placeholder="password" class="input-block-level">
                        <button class="btn btn-large btn-success btn-block" type="submit">Register</button>

                    </form>
                </div>
            </div>
            <div class="text-center">
                <ul class="inline">
                    <li><a class="muted" href="#login" data-toggle="tab">Login</a></li>
                    <li><a class="muted" href="#forgot" data-toggle="tab">Forgot Password</a></li>
                    <li><a class="muted" href="#signup" data-toggle="tab">Signup</a></li>
                    <li><a class="muted"  href="${pageContext.request.contextPath}/home.htm" data-toggle="tab">Home Page</a></li>
                </ul>
            </div>


        </div>
         

        <script src="//ajax.googleapis.com/ajax/libs/jquery/1.10.1/jquery.min.js"></script>
        <script>window.jQuery || document.write('<script src="/web-resources/lib/jquery/jquery-1.10.1.min.js"><\/script>')</script>
        <script type="text/javascript" src="web-resources/lib/bootstrap-3.3.6/js/bootstrap.js"></script>

        <script>
            $('.inline li > a').click(function() {
                var activeForm = $(this).attr('href') + ' > form';
                //console.log(activeForm);
                $(activeForm).addClass('magictime swap');
                //set timer to 1 seconds, after that, unload the magic animation
                setTimeout(function() {
                    $(activeForm).removeClass('magictime swap');
                }, 1000);
            });

        </script>
    </body>
</html>