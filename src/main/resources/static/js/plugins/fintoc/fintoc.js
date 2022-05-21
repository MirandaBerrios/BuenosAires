//METODO ACOUNT CONNECTION

window.getKey = function(){
   
	    const widget = Fintoc.create({
	      publicKey: 'pk_test_-mr-5ENyb9ubzKnoeU8xixkuazvH3yvp',
	      holderType: 'business',
	      product: 'movements',
	      webhookUrl: 'https://a212-2803-c180-2002-97a2-55fb-30db-25b3-a74c.ngrok.io/webhook/link',
	      
	      onSuccess: (link) => {
	        console.log('Success!');
	        console.log(link);
	      },
	      onExit: () => {
	        console.log('Widget closing!');
	      },
	      onEvent: (event) => {
	        console.log('An event just happened!');
	        console.log(event);
	      },
	    });
	    widget.open();
}