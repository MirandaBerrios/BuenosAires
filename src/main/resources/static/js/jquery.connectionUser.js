    

//METODO COUNT CONNECTION
window.getCount = function(){
	
	 var empresa = $('#cbEmpresa').val(); 
//     if (empresa.length < 1) {
//     	empresa = "false";
//     }
	
   	  jQuery.ajax ({
  		    url: "/admin/ajax/getsessionsCount/"+empresa+"",
  		    type: "POST",
  		    success: function(data){
  		    	//console.log("PRUEBA ===> "+data);
  		    	try {
  		    		if (data.includes('<!DOCTYPE html>')) {
  	  					window.location ="/admin/login";
  	  				}
					
				} catch (e) {
					// TODO: handle exception
					$( "#count" ).html("");
  	  		    	var count = "<i class=\"fa fa-users\" style=\" font-size: 20px;\">"+
  	  		    	"</i>"  +
  	  		    	"<span class=\"label label-primary\" >"+data+"</span>"
  	  		    	$( "#count" ).append(count);
				}
  		    	
  		}  
     	  
  		});		//FIN AJAX	 
	}

//
$( "#listaUserLog" ).html(""); 
$('#user_connect').on('shown.bs.dropdown', function(event){
	
	 var empresa = $('#cbEmpresa').val(); 
//   if (empresa.length < 1) {
//   	empresa = "false";
//   }
	
	   $('#user_connect').removeClass("open");
	  $( "#listaUserLog" ).html("");
	  jQuery.ajax ({
	    url: "/admin/ajax/getsessions/"+empresa+"",
	    type: "POST",
	    success: function(data){
//	    	console.log(data.length);
	    	
	    data.forEach(function( item, key ) {	 
//	    		  console.log(item);
	    	
    		var row = "<li>"+
	                    "<div class=\"dropdown-messages-box\">"+
	                    "<div class=\"media-body \">"+
	                        "<strong>"+item.nombre.toUpperCase()+"</strong>"+
	                        "<br>"+
	                        "<strong class=\"pull-right text-navy\">"+item.perfilCuadratura.nombre+"</strong>"+
	                        "<br>"+
	                        "<small class=\"text-muted\">"+item.ultima_conexion+"</small>"+
	                    "</div>"+
		                "</div>"+
		            "</li>"+
		            "<li class=\"divider\"></li>";
				 $( "#listaUserLog" ).append(row);
	    	
	  });
	    
	    getCount();
	    
	    if(data.length>0){
	    	$('#user_connect').addClass("open");
	    }
	    	
	  
	}  
	  
	});		//FIN AJAX	 
	    
	  });