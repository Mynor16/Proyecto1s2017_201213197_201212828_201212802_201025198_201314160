<?php	
	if(empty($_POST['entrarcontraseña']) && strlen($_POST['entrarcontraseña']) == 0)
	{
		return false;
	}
	
	$entrarcontraseña = $_POST['entrarcontraseña'];
	
	$to = 'receiver@yoursite.com'; // Email submissions are sent to this email

	// Create email	
	$email_subject = "Message from My Blocs Website.";
	$email_body = "You have received a new message. \n\n".
				  "Entrarcontraseña: $entrarcontraseña \n";
	$headers = "MIME-Version: 1.0\r\nContent-type: text/plain; charset=UTF-8\r\n";	
	$headers .= "From: contact@yoursite.com\n";
	$headers .= "Reply-To: DoNotReply@yoursite.com";	
	
	mail($to,$email_subject,$email_body,$headers); // Post message
	return true;			
?>