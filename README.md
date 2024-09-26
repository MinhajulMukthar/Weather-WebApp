# Weather Web App Project

## Project Overview
This project is a **Weather Web Application** built using **Java Servlets**, **JSP**, **HTML**, **CSS**, and **JavaScript**. It retrieves real-time weather information for a user-provided city using the **OpenWeather API**. The app displays the weather conditions, including temperature, humidity, wind speed, and weather condition, like clouds or rain. The information is visually presented with weather icons, enhancing the user experience.

## Functionality
1. **User Input:**
   - The user enters the name of the city they want to get the weather for.
   - The input form is handled using **HTML** and **CSS**, with a search button that sends the city name to the server via an HTTP POST request.

2. **Backend (Java Servlet):**
   - When the user submits the form, the data is sent to the `ServletWeb` servlet.
   - The servlet constructs a request to the **OpenWeather API** using the entered city name and a predefined API key.
   - The servlet establishes an HTTPS connection to the API, retrieves the JSON response, and extracts relevant weather data (e.g., temperature, humidity, wind speed, weather conditions).

3. **Data Processing:**
   - The received JSON response is parsed using the **GSON** library.
   - Relevant data such as temperature (in Kelvin, converted to Celsius), humidity, wind speed, and the main weather condition (like rain or clear skies) is extracted.
   - The timestamp in the JSON response is converted to a human-readable date format.

4. **Front-End Rendering (JSP):**
   - The extracted weather information is passed to a JSP page for display.
   - The **JSP** page uses **EL (Expression Language)** to display data like city name, temperature, wind speed, and weather condition.
   - Based on the weather condition (e.g., Clouds, Rain, Clear), appropriate weather icons are displayed dynamically.

5. **Dynamic Weather Icon:**
   - The JavaScript code dynamically changes the weather icon based on the weather condition (e.g., sun for clear weather, rain for rainy weather). The icons are preloaded and mapped to specific weather conditions.

## Key Components
- **HTML/CSS:** 
  - Used for the structure and styling of the web page. The interface is user-friendly and responsive.
  
- **Java Servlet:** 
  - Acts as the backend engine that processes the user's request, interacts with the OpenWeather API, and returns the data to the front end.

- **JSP (JavaServer Pages):** 
  - Facilitates dynamic content generation and renders the data processed by the servlet into a structured and styled HTML format.

- **JavaScript:** 
  - Used to set the correct weather icon based on the weather condition retrieved from the API response.

- **GSON Library:** 
  - Simplifies parsing JSON data from the OpenWeather API, making it easier to extract and manipulate specific fields.

## Key Features
1. **Real-Time Weather Data:** 
   - The app fetches current weather data from OpenWeather's API, providing accurate and up-to-date information.
   
2. **City-Based Search:**
   - Users can search for any city worldwide to check its weather conditions.
   
3. **Weather Details Display:**
   - Displays temperature, weather condition, humidity, and wind speed.
   
4. **Dynamic Icons:**
   - Changes the weather icon based on the weather condition for a more intuitive user experience.

5. **Date and Time:**
   - Converts and displays the current date and time of the weather report.

## Technologies Used
- **Frontend:** 
  - HTML, CSS, JavaScript, JSP
- **Backend:** 
  - Java, Servlet, GSON library
- **API:** 
  - OpenWeather API for weather data

## How It Works
1. **User Enters City:** The user inputs a city name in the text field and submits the form.
2. **Servlet Fetches Data:** The servlet sends a GET request to the OpenWeather API with the city name.
3. **JSON Parsing:** The servlet parses the API's JSON response to extract weather data like temperature, humidity, and weather conditions.
4. **JSP Renders Output:** The extracted data is passed to a JSP page, which dynamically displays it along with a weather icon matching the current weather condition.
5. **Weather Icon Update:** JavaScript updates the weather icon based on the extracted weather condition (e.g., clouds, clear sky, rain).

This project serves as a simple yet effective demonstration of integrating a third-party API into a Java web application, providing real-time weather updates to users.
