<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>LOGIN DENTYSTEM</title>        
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">               
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
        <link href="../../css/Dentystem.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div style="text-align: center;"> 
            <h1 style="text-align: center;">Bienvenidos Dentystem</h1>            
        </div>
        <div class="row">
            <div class="container" style="text-align: center; width: 500px; padding: 50px;">
                <form action="Login" method="GET">
                    <h1 style="text-align: center;">Login</h1> 
                    <hr><table style="text-align: center;" border="0" width="12">                        
                        <tbody>
                            <tr style="text-align: center;">
                                <td style="text-align: center;">Usuario:</td>
                                <td>
                                    <input type="email" name="txtUser" id="inputEmail" placeholder="Usuario"  required="true" autofocus="">  
                                </td>
                            </tr>
                            <tr>
                                <td>Contraseña:</td>
                                <td>
                                    <input type="password" name="txtPassword" id="inputPassword" placeholder="Contraseña" required="true" autofocus="">                        
                                </td>
                            </tr>
                        </tbody>
                    </table>                   
                    <hr>
                    <div class="form-group-lg" style="text-align: center" >
                        <input class="btn-primary btn-lg" type="submit" name="accion" value="Entrar"  >
                    </div>
                </form>                        
            </div>
        </div>
    </body>
    <jsp:include page="../../Vistas/Template/footer.jsp" />
</html>
