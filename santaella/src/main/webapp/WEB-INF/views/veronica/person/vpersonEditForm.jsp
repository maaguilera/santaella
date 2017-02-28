<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>



    <c:url var="actionUrlEdit" value="/veronica/person/edit" />    
    
<div class="modal fade" id="exampleModalEdit1" tabindex="-1" role="dialog"
	aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			
			
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title" id="exampleModalLabel">Edit Utilizador</h4>
			</div>
			
			<div class="modal-body">

					<div id="modal-loader" style="display: none; text-align: center;">
				           <!-- ajax loader -->
			           <img src='<c:url value="/web-resources/img/veronica1.jpg"/>'>
			           
	           		</div>
	           
	             	<div id="dynamic-content">
	            
						
					</div> 
			</div>
						
			<div class="modal-footer"> 
            		
            			<button type="button" class="btn btn-default" data-dismiss="modal">Close</button> 
            			<button type="button" id="submitEdit" class="btn btn-default" data-dismiss="modal">Submit</button>  
        			
        	</div> 
						
		
			
			
		</div>
	</div>
</div>



<script>

$(document).ready(function() {

	$(".datepicker").datepicker({
		format: "yyyy-mm-dd",
		changeMonth : true,
		changeYear : true,
		showButtonPanel : true
	});



	$(".datepicker2").datepicker({
		format: "yyyy-mm-dd",
		changeMonth : true,
		changeYear : true,
		showButtonPanel : true
	});

	$("#submitEdit").click (function() {
       //alert(document.getElementById("formModalEdit"));
		document.getElementById("formModalEdit").submit();
		  // $("#formModalEdit").attr("action", "${actionUrlEdit}");
		   //$('#formModalEdit').submit();
        });

});
</script>

