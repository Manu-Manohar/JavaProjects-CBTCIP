<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Guess the Number</title>
    <link rel="stylesheet" type="text/css" href="css/styles.css">
    <style>
   body {
    font-family: Arial, sans-serif;
    background-color: #f2f2f2;
}

.container {
    text-align: center;
    margin-top: 50px;
}

button {
    margin-top: 10px;
    padding: 10px 20px;
    background-color: #4caf50;
    color: white;
    border: none;
    cursor: pointer;
    transition: background-color 0.3s ease;
}

button:hover {
    background-color: #45a049;
}

#message {
    font-size: 18px;
    margin-top: 20px;
    color: #333;
}
    
    </style>
</head>
<body>
   <body>
    <div class="container">
        <h1>Guess the Number</h1>
        <p>Guess a number between 1 and 100:</p>
        <form id="guessForm" action="guess" method="post">
            <input type="number" name="guess" id="guessInput" required>
            <input type="hidden" name="username" value="${sessionScope.username}">
            <button type="submit" id="submitGuess">Submit Guess</button>
        </form>
        <p id="message">${message}</p>
        <p>Attempts left: ${sessionScope.attempts}</p>
    </div>

    <script>
    document.getElementById("guessForm").addEventListener("submit", function(event) {
        event.preventDefault(); // Prevent form submission
                
        // Get the input value
        var guessInput = document.getElementById("guessInput").value;
        
        // Validate input (must be between 1 and 100)
        if (guessInput < 1 || guessInput > 100) {
            alert("Please enter a number between 1 and 100.");
            return;
        }
        
        // If input is valid, submit the form
        this.submit();
    });
    </script>
</body>
</html>
