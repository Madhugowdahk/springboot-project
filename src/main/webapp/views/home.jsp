<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Spring Boot JSP Example</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            padding: 20px;
        }
        .card {
            background: white;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
            width: 350px;
        }
        .btn {
            padding: 10px 20px;
            background: #007bff;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }
        .btn:hover {
            background: #0056b3;
        }
    </style>
</head>
<body>

<div class="card">
    <h2>Hello from JSP!</h2>

    <p>This is a sample JSP page running in Spring Boot.</p>

    <p>Your Name: <strong>${name}</strong></p>

    <form action="/submit" method="post">
        <input type="text" name="message" placeholder="Type something..." required>
        <button class="btn" type="submit">Submit</button>
    </form>
</div>

</body>
</html>
