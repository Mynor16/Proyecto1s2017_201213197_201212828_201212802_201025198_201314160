<?php	
	if(empty($_POST['nuevocontraseña']) && strlen($_POST['nuevocontraseña']) == 0)
	{
		return false;
	}
	
	$nuevocontraseña = $_POST['nuevocontraseña'];
	
	$to = 'receiver@yoursite.com'; // Email submissions are sent to this email

	// Create email	
	$email_subject = "Message from My Blocs Website.";
	$email_body = "You have received a new message. \n\n".
				  "Nuevocontraseña: $nuevocontraseña \n";
	$headers = "MIME-Version: 1.0\r\nContent-type: text/plain; charset=UTF-8\r\n";	
	$headers .= "From: contact@yoursite.com\n";
	$headers .= "Reply-To: DoNotReply@yoursite.com";	
	
	mail($to,$email_subject,$email_body,$headers); // Post message
	return true;			
?>