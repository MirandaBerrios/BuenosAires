/*
 *
 *   IBSS - custom js
 *   version 1.0.0
 *
 */

	
	
	
	 /***   FUNCION SELECT RADIO ***/
    function setRadio(idSi, idNo, valor){
    	
    	if (valor == null || valor == "null" || valor == "0" || valor == "N") {
    		$("#"+idSi+"").iCheck('uncheck');
    		$("#"+idNo+"").iCheck('check');
		}else{
			$("#"+idSi+"").iCheck('check');
    		$("#"+idNo+"").iCheck('uncheck');
		}
    	
       }   
    
    
   /*** FUNCION QUE RESCATA PARAMETROS DESDE URL ***/
    (function($) {  
	    $.get = function(key)   {  
	        key = key.replace(/[\[]/, '\\[');  
	        key = key.replace(/[\]]/, '\\]');  
	        var pattern = "[\\?&]" + key + "=([^&#]*)";  
	        var regex = new RegExp(pattern);  
	        var url = unescape(window.location.href);  
	        var results = regex.exec(url);  
	        if (results === null) {  
	            return null;  
	        } else {  
	            return results[1];  
	        }  
	    }  
	})(jQuery);  
    

    /***   VALIDACIONES ES  ***/
  	jQuery.extend(jQuery.validator.messages, {
		  required: "Este campo es obligatorio.",
		  remote: "Por favor, rellena este campo.",
		  email: "Por favor, escribe una dirección de correo válida",
		  url: "Por favor, escribe una URL válida.",
		  date: "Por favor, escribe una fecha válida.",
		  dateISO: "Por favor, escribe una fecha (ISO) válida.",
		  number: "Por favor, escribe un número entero válido.",
		  digits: "Por favor, escribe sólo dígitos.",
		  creditcard: "Por favor, escribe un número de tarjeta válido.",
		  equalTo: "Por favor, escribe el mismo valor de nuevo.",
		  accept: "Por favor, escribe un valor con una extensión aceptada.",
		  maxlength: jQuery.validator.format("Por favor, no escribas más de {0} caracteres."),
		  minlength: jQuery.validator.format("Por favor, no escribas menos de {0} caracteres."),
		  rangelength: jQuery.validator.format("Por favor, escribe un valor entre {0} y {1} caracteres."),
		  range: jQuery.validator.format("Por favor, escribe un valor entre {0} y {1}."),
		  max: jQuery.validator.format("Por favor, escribe un valor menor o igual a {0}."),
		  min: jQuery.validator.format("Por favor, escribe un valor mayor o igual a {0}.")
		});
  	
    //funciones jquery validate
    jQuery.validator.addMethod("validDate", function(value, element) {
        return this.optional(element) || moment(value,"DD/MM/YYYY").isValid();
    }, "Favor ingrese una fecha valida con formato DD/MM/YYYY");  	
	
    /***   ACTIVAR MENU  ***/     
    $(document).ready(function() {
    	var pathname = window.location.pathname;
        $("nav ul li a").each(function(){
   		 if($(this).attr("href") == pathname){
   			console.log($(this).attr('href'));
   			console.log($(this).closest('li'));
   			$(this).closest('li').addClass('active');
            $(this).parent().parent().parent().addClass('active');
   			$(this).parent().parent().addClass('in');
   			}
        })
    })
	
    /***   DATEPICKER ES  ***/ 
    
    try {
        $.fn.datepicker.dates['es'] = {
    		    days: ["Domingo", "Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado"],
    		    daysShort: ["Dom", "Lun", "Mar", "Mie", "Jue", "Vie", "Sab"],
    		    daysMin: ["Do", "Lu", "Ma", "Mi", "Ju", "Vi", "Sa"],
    		    months: ["Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"],
    		    monthsShort: ["Ene", "Feb", "Mar", "Abr", "May", "Jun", "Jul", "Ago", "Sep", "Oct", "Nov", "Dic"],
    		    today: "Hoy",
    		    clear: "Limpiar",
    		    format: "dd-mm-yyyy",
    		    titleFormat: "MM yyyy", /* Leverages same syntax as 'format' */
    		    weekStart: 1
    	};
	} catch (e) {
		// TODO: handle exception
	}    
    
  