<%-- 
    Document   : index
    Created on : 08/07/2010, 21:42:30
    Author     : nacho
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Formulari</title>
    </head>
    <body>
        <form action="controlador.html" method="post" enctype="multipart/form-data">
           <input type="file" name="file" />
           <input type="submit" name="submit" value="Pujar Arxiu" />
        </form>
    </body>
</html>
