function addPerson() {

	$('#bookDialog').dialog("option", "title", 'Add Person');
	$('#bookDialog').dialog('open');
	initializeDatePicker()
}

function editPerson(id) {
	
	$.get("get/" + id, function(result) {

		$("#bookDialog2").html(result);

		$('#bookDialog2').dialog("option", "title", 'Edit Person');

		$("#bookDialog2").dialog('open');

		initializeDatePicker();
	});
}

function initializeDatePicker() {
	$(".datepicker").datepicker({
		dateFormat : "yy-mm-dd",
		changeMonth : true,
		changeYear : true,
		showButtonPanel : true
	});
}

function resetDialog(form) {

	form.find("input").val("");
}

$(document).ready(function() {

	
	
	$('#bookDialog2').dialog({

		autoOpen : false,
		position : 'center',
		modal : true,
		resizable : false,
		width : 700,
		buttons : {
			"Save" : function() {
				$('#personEditForm').submit();
			},
			"Cancel" : function() {
				$(this).dialog('close');
			}
		},
		close : function() {

			resetDialog($('#personEditForm'));

			$(this).dialog('close');
		}
	});
	
	$('#bookDialog').dialog({

		autoOpen : false,
		position : 'center',
		modal : true,
		resizable : false,
		width : 440,
		buttons : {
			"Save" : function() {
				$('#personForm').submit();
			},
			"Cancel" : function() {
				$(this).dialog('close');
			}
		},
		close : function() {

			resetDialog($('#personForm'));

			$(this).dialog('close');
		}
	});

	
});
