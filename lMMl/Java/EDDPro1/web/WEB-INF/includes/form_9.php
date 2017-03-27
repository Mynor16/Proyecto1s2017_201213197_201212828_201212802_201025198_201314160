<?php	
	if(empty($_POST['descripcioneliminar']) && strlen($_POST['descripcioneliminar']) == 0)
	{
		return false;
	}
	
	$select_256 = $_POST['select_256'];
	$descripcioneliminar = $_POST['descripcioneliminar'];
	
	$to = 'receiver@yoursite.com'; // Email submissions are sent to this email

	// Create email	
	$email_subject = "Message from My Blocs Website.";
	$email_body = "You have received a new message. \n\n".
				  "Select_256: $select_256 \nDescripcioneliminar: $descripcioneliminar \n";
	$headers = "MIME-Version: 1.0\r\nContent-type: text/plain; charset=UTF-8\r\n";	
	$headers .= "From: contact@yoursite.com\n";
	$headers .= "Reply-To: DoNotReply@yoursite.com";	
	
	mail($to,$email_subject,$email_body,$headers); // Post message
	return true;			
?>