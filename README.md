# Weather Web App

A simple **Weather Web App** that allows users to get real-time weather information for any city using the [OpenWeather API](https://openweathermap.org/).

## Features
- **City-Based Weather Search**: Enter any city name to get real-time weather data.
- **Display Weather Data**: Shows temperature (in °C), humidity, wind speed, weather condition, and date.
- **Dynamic Weather Icon**: The app dynamically changes the weather icon based on the condition (Clouds, Rain, Mist, Clear, etc.).
- **Responsive Design**: Styled using HTML, CSS, and JavaScript, making the UI visually appealing and user-friendly.
- **Technologies Used**: Servlet, JSP, Gson (for JSON parsing), HTML, CSS, JavaScript, and Java.

## How It Works
1. The user enters the name of a city and submits the form.
2. The app sends an HTTP GET request to the OpenWeather API, using the city name and the API key.
3. The weather data is returned in JSON format and parsed using Gson.
4. Important weather details such as temperature (converted from Kelvin to Celsius), humidity, wind speed, and weather conditions are extracted.
5. The data is dynamically displayed on the web page using JSP.

## Key Components
### Servlet
- **ServletWeb.java**: Handles POST requests to fetch weather data from the OpenWeather API using the city name provided by the user.
    - Constructs the API URL using the city and API key.
    - Sends the GET request and parses the JSON response using Gson.
    - Extracts data like temperature, humidity, wind speed, and weather conditions.
    - Forwards the data to a JSP page for dynamic rendering.

### JSP
- Displays the extracted weather details such as temperature, humidity, wind speed, and weather conditions on a visually appealing page.
- Dynamically updates the weather icon based on conditions like Clouds, Rain, Mist, etc.

### Front-End (HTML, CSS, JS)
- **HTML & CSS**: Provides the structure and styling of the web page, making the user interface clean and responsive.
- **JavaScript**: Dynamically sets the weather icon based on the weather condition using a switch-case structure.

## How to Run
1. Clone the repository.
2. Deploy it on a servlet container like Apache Tomcat.
3. Replace the API key in the `ServletWeb.java` file with your own OpenWeather API key.
4. Access the web app via the browser, enter a city name, and get the current weather details.

---
