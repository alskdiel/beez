<!DOCTYPE html>
<html lang="en"></html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
  <meta name="description" content="">
  <meta name="author" content="">
  <title>Amaretti</title>
  <link rel="stylesheet" type="text/css" href="../../resources/assets/lib/stroke-7/style.css"/>
  <link rel="stylesheet" type="text/css" href="../../resources/assets/lib/jquery.nanoscroller/css/nanoscroller.css"/><!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
  <![endif]-->
  <link rel="stylesheet" type="text/css" href="../../resources/assets/lib/font-awesome/css/font-awesome.min.css"/>
  <link rel="stylesheet" href="../../resources/assets/css/style.css" type="text/css"/>
</head>
<body class="am-splash-screen">
  <div class="am-wrapper am-login am-signup">
    <div class="am-content">
      <div class="main-content">
        <div class="login-container sign-up">
          <div class="panel panel-default">
            <div class="panel-heading"><img src="../../resources/assets/img/logo-full-retina.png" alt="logo" width="150px" height="39px" class="logo-img"><span>Please enter your user information.</span></div>
            <div class="panel-body">
              <form action="index.html" parsley-validate="" novalidate="" method="get" class="form-horizontal">
                <div class="title"><span>Sign up with</span></div>
                <div class="sign-up-form"> 
                  <div class="form-group row social-signup">
                    <div class="col-xs-6">
                      <button type="button" class="btn btn-block btn-social btn-facebook"><i class="fa fa-facebook icon icon-left"></i> Facebook</button>
                    </div>
                    <div class="col-xs-6">
                      <button type="button" class="btn btn-block btn-social btn-twitter"><i class="fa fa-twitter icon icon-left"></i> Twitter</button>
                    </div>
                  </div>
                  <div class="title"><span class="title">Or</span></div>
                  <div class="form-group">
                    <div id="nick-handler" class="input-group"><span class="input-group-addon"><i class="icon s7-user"></i></span>
                      <input type="text" name="nick" data-parsley-trigger="change" data-parsley-errors-messages-disabled="true" data-parsley-class-handler="#nick-handler" required="" placeholder="Username" autocomplete="off" class="form-control">
                    </div>
                  </div>
                  <div class="form-group">
                    <div id="email-handler" class="input-group"><span class="input-group-addon"><i class="icon s7-mail"></i></span>
                      <input type="email" name="email" data-parsley-trigger="change" data-parsley-errors-messages-disabled="true" data-parsley-class-handler="#email-handler" required="" placeholder="E-mail" autocomplete="off" class="form-control">
                    </div>
                  </div>
                  <div class="form-group row">
                    <div class="col-xs-6">
                      <div id="password-handler" class="input-group"><span class="input-group-addon"><i class="icon s7-lock"></i></span>
                        <input id="pass1" type="password" data-parsley-errors-messages-disabled="true" placeholder="Password" data-parsley-class-handler="#password-handler" required="" class="form-control">
                      </div>
                    </div>
                    <div class="col-xs-6">
                      <div id="confirm-handler" class="input-group"><span class="input-group-addon"><i class="icon s7-lock"></i></span>
                        <input parsley-equalto="#pass1" type="password" data-parsley-errors-messages-disabled="true" data-parsley-class-handler="#confirm-handler" required="" placeholder="Confirm" class="form-control">
                      </div>
                    </div>
                  </div>
                </div>
                <p class="conditions">By creating an account, you agree with the <a href="#">Terms and Conditions</a>.</p>
                <button type="submit" class="btn btn-block btn-primary btn-lg">Sign Up</button>
              </form>
            </div>
          </div>
          <div class="text-center out-links"><a href="#">� 2015 Your Company</a></div>
        </div>
      </div>
    </div>
  </div>
  <script src="../../resources/assets/lib/jquery/jquery.min.js" type="text/javascript"></script>
  <script src="../../resources/assets/lib/jquery.nanoscroller/javascripts/jquery.nanoscroller.min.js" type="text/javascript"></script>
  <script src="../../resources/assets/js/main.js" type="text/javascript"></script>
  <script src="../../resources/assets/lib/bootstrap/dist/js/bootstrap.min.js" type="text/javascript"></script>
  <script src="../../resources/assets/lib/parsley/parsley.min.js" type="text/javascript"></script>
  <script type="text/javascript">
    $(document).ready(function(){
    	//initialize the javascript
    	App.init();
    	
    	$('form').parsley();
    	
    });
  </script>
</body>