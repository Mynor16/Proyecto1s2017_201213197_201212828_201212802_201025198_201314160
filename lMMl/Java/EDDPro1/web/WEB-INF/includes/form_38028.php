<?php	
	if(empty($_POST['input_1315_38028']) && strlen($_POST['input_1315_38028']) == 0)
	{
		return false;
	}
	
	$input_1315_38028 = $_POST['input_1315_38028'];
	
	$to = 'receiver@yoursite.com'; // Email submissions are sent to this email

	// Create email	
	$email_subject = "Message from My Blocs Website.";
	$email_body = "You have received a new message. \n\n".
				  "Input_1315_38028: $input_1315_38028 \n";
	$headers = "MIME-Version: 1.0\r\nContent-type: text/plain; charset=UTF-8\r\n";	
	$headers .= "From: contact@yoursite.com\n";
	$headers .= "Reply-To: DoNotReply@yoursite.com";	
	
	mail($to,$email_subject,$email_body,$headers); // Post message
	return true;			
?>