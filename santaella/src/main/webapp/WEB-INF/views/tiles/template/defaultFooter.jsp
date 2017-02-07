<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<hr/>
<div id="footer">
<div class="container">

  <div class="row">
    
      <div class="col-sm-3">
        <div class="foot-header">
          Acerca de Nosotros <img src="http://200.27.156.170/ean_default/img/cocha/icon-cocha.png">
        </div>
        <div class="foot-links">
          <a href="http://internet.cocha.com/nuestra-empresa/nuestra-empresa.html">Deportes Santaella</a><br>
          <a href="http://cms.cocha.com/sucursales.html">Localización Oficina</a>

        </div>
      </div><!--/col-sm-3-->
    <div class="col-sm-3">
      <div class="foot-header"> Servicio al utilizador <img src="http://200.27.156.170/ean_default/img/cocha/servicio-al-cliente-icon.png"></div>
      <div class="foot-links">
      	<a href="javascript:Contacto()">Contáctanos</a>
      <br>
        <a href="http://internet.cocha.com/_DisenoWeb/minisitios/sitio/faq.html?cid=preguntas-frecuentes">Preguntas frecuentes</a>
       <br> <a href="http://cms.cocha.com/terminos-y-condiciones">Términos y Condiciones Generales</a>

      </div>
    </div>
    <div class="col-sm-3">
      <div class="foot-header">
        Medios de pago <img src="http://200.27.156.170/ean_default/img/cocha/card-icon.png">
      </div>
      <div class="foot-links">
        <p>
          <i class="fa fa-check text-success"></i> Tarjetas de crédito<br>
          <img src="http://200.27.156.170/ean_default/img/cocha/visa-card.png">
          <img src="http://200.27.156.170/ean_default/img/cocha/master-card.png">
        
        </p>
     
      </div>
    </div><!--/col-sm-3-->
    <div class="col-sm-3">
      <div class=row> <a href="http://www.santaella.es" style="float: left;">
        <img src='<c:url value="/web-resources/img/escudo.png"/>' width="70" height="110" alt="Ayuntamiento de Santaella">
      </a></div>
      <div class=row>
      <a href="http://www.santaella.es" style="float: left;">Ayuntamiento Santaella</a>
      </div>
   
    </div>
    
    
  	</div><!--/row-->
  <div class="row">
    <center><img src="http://200.27.156.170/ean_default/img/cocha/footer-bg.png"></center>
    <div id="bottom-footer">
      <div class="row">
        <div class="col-md-8">
    	<a href='<c:url value="/myHome.html"/>'>Inicio</a>
        <a href='<c:url value="/person/listPersons"/>'>/ Admin</a>
        </div>
        <div class="col-md-4 phone" >
          <img src="http://200.27.156.170/ean_default/img/cocha/phone-icon.png" class="pull-left">
          <div class="pull-left">
            <span class="red"> Tfo Pabellón: 345 654 321</span>
          </div>
          <div class="pull-left">
            <span class="red">Tfo Ayuntamiento: 435 345 345</span>
          </div>
          </div>
    </div>
  </div><!--/row 2-->
      <div class="row" id="final-footer">
        <div class="col-sm-4">
          <img src="http://200.27.156.170/ean_default/img/cocha/RapidSSL_SEAL-90x50.gif">
        </div>
        <div class="col-sm-4 text-center">
        	Copyright © 2016 MAAC. All Rights Reserved
			Santaella, kordoves@gmail.com
        </div>
        <div class="col-sm-4 text-right">
        	<span class="fa-stack fa-lg">
              <i class="fa fa-circle text-primary fa-stack-2x"></i>
              <i class="fa fa-facebook fa-stack-1x fa-inverse"></i>
            </span>
          <span class="fa-stack fa-lg">
              <i class="fa fa-circle text-info fa-stack-2x"></i>
              <i class="fa fa-twitter fa-stack-1x fa-inverse"></i>
            </span>
          <span class="fa-stack fa-lg">
              <i class="fa fa-circle text-danger fa-stack-2x"></i>
              <i class="fa fa-youtube fa-stack-1x fa-inverse"></i>
            </span>
        </div>
      </div>
  </div><!--/container-->
</div><!--/footer--></div>


<script type="text/javascript"
		src='<c:url value="/web-resources/lib/jquery/jquery-1.10.2.js"/>'></script>
	<script type="text/javascript"
		src='<c:url value="/web-resources/lib/jquery/jquery-ui-1.10.4.custom.js"/>'></script>
	<script type="text/javascript"
		src='<c:url value="/web-resources/lib/jquery/jquery.ui.datepicker.js"/>'></script>
	<script type="text/javascript"
		src='<c:url value="/web-resources/lib/bootstrap-3.3.6/js/bootstrap.min.js"/>'></script>
	
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.5.0/js/bootstrap-datepicker.min.js"></script>
		<script>
		$(document).ready(function() {
			
			$('#header').css('background-color', '#EEEEEE');
			$('#footer').css('background-color', '#EEEEEE');
			
			//$('#pepe').css('background-color', '#EFFBFB');			   
		});
		</script>
