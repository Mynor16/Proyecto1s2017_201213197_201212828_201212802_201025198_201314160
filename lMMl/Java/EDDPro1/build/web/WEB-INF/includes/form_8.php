<?php	
	if(empty($_POST['nombre']) && strlen($_POST['nombre']) == 0 || empty($_POST['descripcion']) && strlen($_POST['descripcion']) == 0)
	{
		return false;
	}
	
	$nombre = $_POST['nombre'];
	$descripcion = $_POST['descripcion'];
	
	$to = 'receiver@yoursite.com'; // Email submissions are sent to this email

	// Create email	
	$email_subject = "Message from My Blocs Website.";
	$email_body = "You have received a new message. \n\n".
				  "Nombre: $nombre \nDescripcion: $descripcion \n";
	$headers = "MIME-Version: 1.0\r\nContent-type: text/plain; charset=UTF-8\r\n";	
	$headers .= "From: contact@yoursite.com\n";
	$headers .= "Reply-To: DoNotReply@yoursite.com";	
	
	mail($to,$email_subject,$email_body,$headers); // Post message
	return true;			
?>