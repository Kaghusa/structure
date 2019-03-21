<%@ page import = "java.io.*,java.util.*, javax.servlet.*" %>
<%@ page import = "javax.servlet.http.*" %>
<%@ page import = "org.apache.commons.fileupload.FileItem, org.apache.commons.fileupload.FileUploadException, org.apache.commons.fileupload.FileItemFactory" %>
<%@ page import = "org.apache.commons.fileupload.disk.DiskFileItemFactory" %>
<%@ page import = "org.apache.commons.fileupload.servlet.ServletFileUpload" %>
<%@ page import = "org.apache.commons.io.output.*" %>
<%@ page import="java.util.*, java.io.*" %>
<%@ page import="java.util.Iterator"%>
<%@ page import="java.util.List"%>
<%@ page import="java.io.File"%>
<%@page import="core.fileupload; " %>


<%
      fileupload file = new fileupload();
     
    if (ServletFileUpload.isMultipartContent(request))
    {
        //out.print(request.getParameter("email"));
        List items = file.upload.parseRequest(request);
        String path="/Users/olivier/NetBeansProjects/structure/web/profile/";
        Map field = new HashMap();
        field= file.uploadfile(items, path);
         Set <String> keys = field.keySet();
                for(String key: keys) 
                {
                 out.println(key+" :  "+field.get(key));
                }
    }
   
%>




<html>
<head> 
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>User|Registration</title>
  <!-- Tell the browser to be responsive to screen width -->
  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
  <!-- Bootstrap 3.3.6 -->
  <link rel="stylesheet" href="../../bootstrap/css/bootstrap.min.css">
  <!-- Font Awesome -->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css">
  <!-- Ionicons -->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="../../dist/css/AdminLTE.min.css">
  <!-- iCheck -->
  <link rel="stylesheet" href="../../plugins/iCheck/square/blue.css">
  
</head>
<body class="hold-transition register-page">
<div class="register-box">
  <div class="register-logo">
    <a href=""><b>USER REGISTRATION</b></a>
  </div>

  <div class="register-box-body">
    <!--<p class="login-box-msg">Register</p>-->

    <form action="" method="post" enctype="multipart/form-data"  >
  

      <div class="form-group has-feedback">
        <input type="email" class="form-control" name="email" placeholder="Email">
        <span class="glyphicon glyphicon-envelope form-control-feedback"></span>
      </div>
        
        <div class="form-group has-feedback">
        <input type="text" class="form-control" name="name" placeholder="`Enter you name">
        <span class="glyphicon glyphicon-envelope form-control-feedback"></span>
      </div>


    

     

      <div class="form-group has-feedback">
          <label> Upload Profile</label>  
          <input name="profile"  type="file">
          </div>

      <div class="row">
        <div class="col-xs-8">
          <div class="checkbox icheck">
            <!--<label>
              <input type="checkbox"> I agree to the <a href="#">terms</a>
            </label>-->
          </div>
        </div>
        <div class="col-xs-4">
          
       
        
     <div id="app"></div>    
    <script src="https://cdnjs.cloudflare.com/ajax/libs/react/0.14.7/react.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/react/0.14.7/react-dom.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/babel-core/5.8.23/browser.min.js"></script>
    <script type="text/babel">
        
        var HelloComponent = React.createClass({
                      
            render: function() {
                return (
               <button type="submit" name="next" class="btn btn-primary btn-block btn-flat"> Next</button>
                )
            }
        })
        
        ReactDOM.render(<HelloComponent />, document.querySelector('#app'))
    </script>
    
      </div>
         </div> 
    </form>
    <%
        //
    %>
    

<!-- jQuery 2.2.3 -->
<script src="../../plugins/jQuery/jquery-2.2.3.min.js"></script>
<!-- Bootstrap 3.3.6 -->
<script src="../../bootstrap/js/bootstrap.min.js"></script>
<!-- iCheck -->
<script src="../../plugins/iCheck/icheck.min.js"></script>
<script>
  $(function () {
    $('input').iCheck({
      checkboxClass: 'icheckbox_square-blue',
      radioClass: 'iradio_square-blue',
      increaseArea: '20%' // optional
    });
  });
</script>
</body>
</html>