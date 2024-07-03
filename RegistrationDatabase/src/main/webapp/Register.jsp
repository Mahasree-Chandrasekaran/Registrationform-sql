<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registration Form</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f0f0;
            background-image: url('PaIZyM.webp');
            background-size: cover;
            background-repeat: no-repeat;
            background-attachment: fixed;
            color: white;
            padding: 20px;
        }
        .container {
            max-width: 400px;
            background-color: rgba(255, 255, 255, 0.0);
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
            margin: 0 auto;
        }
        h2 {
            text-align: center;
            margin-bottom: 20px;
        }
        input[type="text"], input[type="email"], input[type="password"] {
            width: 100%;
            padding: 10px;
            margin: 8px 0;
            box-sizing: border-box;
            border: 1px solid #ccc;
            border-radius: 4px;
        }
        #b {
            background-color: #4CAF50;
            color: white;
            padding: 14px 20px;
            margin: 8px 0;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            width: 100%;
        }
        #b:hover {
            background-color: #45a049;
        }
        a:link {
            color: white;
            padding: 5px 5px;
            text-decoration: none;
            display: inline-block;
        }
        .error {
            color: red;
            list-style-type: none;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Registration Form</h2>
        <form action="Registers" method="post" enctype="multipart/form-data">
            <label for="fname">First Name</label>
            <input type="text" id="fname" name="fname" placeholder="Your first name.." required>
            <label for="lname">Last Name</label>
            <input type="text" id="lname" name="lname" placeholder="Your last name.." required>
            <label for="email">Email</label>
            <input type="email" name="email" placeholder="Your email.." required>
            <label for="password">Password</label>
            <input type="password" name="password" placeholder="Your password.." required>
            <label for="photo">Upload Photo</label><br><br>
            <input type="file" name="photo" required><br><br>
            <button id="b" type="submit">Register</button>
        </form>
        <br>
        <ul class="error">
            <c:forEach var="error" items="${errors}">
                <li>${error}</li>
            </c:forEach>
        </ul>
    </div>
</body>
</html>
