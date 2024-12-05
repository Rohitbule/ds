from flask import Flask, jsonify, request

app = Flask(__name__)

# Example endpoint
@app.route('/api/greet', methods=['GET'])
def greet():
    name = request.args.get('name', 'World')  # Get the 'name' parameter
    return jsonify({"message": f"Hello, {name}!"})

if __name__ == '__main__':
    app.run(host='0.0.0.0', port=5000)  # Runs on port 5000

"""

Flask Application (app.py):
Flask is used to create a RESTful web service.
The code defines an endpoint (/api/greet) which handles HTTP GET requests.
It retrieves the name parameter from the URL using request.args.get('name', 'World'). If no name is provided, it defaults to "World."
The result is returned as a JSON response (jsonify), sending back a message such as "Hello, Distributed Application!" when the name parameter is passed.
The application runs on port 5000 on all IP addresses (host='0.0.0.0'), making it accessible within the local network.

2. Service Consumer (client.py):
This script consumes the Flask web service using the requests library.
It sends a GET request to the /api/greet endpoint, passing the query parameter name=Distributed Application.
The response is checked for a successful status code (200 OK). If successful, the JSON response is printed.

Web services are applications that enable communication between devices or applications over a network (usually via HTTP). 
They allow different systems to interact using standardized protocols.

RESTful Web Services:
The Flask app here is an example of a RESTful web service, which is a lightweight architecture based on standard HTTP methods (GET, POST, PUT, DELETE).
REST services typically communicate via JSON, which is easy for both humans and machines to read and write.

HTTP Methods:
GET: Retrieves data (as used in your example).
POST: Submits data to the server.
PUT: Updates existing data.
DELETE: Removes data from the server.
"""
