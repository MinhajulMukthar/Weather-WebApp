package com.MyServlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Date;
import java.util.Scanner;

import javax.net.ssl.HttpsURLConnection;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

/**
 * Servlet implementation class WebServlet
 */
@WebServlet("/ServletWeb")
public class ServletWeb extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletWeb() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String apikey = "885ec4d1f5ef08e380af043f2f20cdc8";
		String city = request.getParameter("city");
		response.getWriter().write("Entered City : " + city);

		// Create URL using City and API Key
		String apiURL ="https://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=" + apikey;

		// Converted string to URL
		try {
		@SuppressWarnings("deprecation")
		URL url = new URL(apiURL);

		// Converted to Https to open and manage url
		HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
		connection.setRequestMethod("GET");

		// Reading the data from http or URL
		InputStream inputStream = connection.getInputStream();
		InputStreamReader inputStreamReader = new InputStreamReader(inputStream);

		// After reading we have to store in string so we declare String Builder
		StringBuilder builder = new StringBuilder();

		// Till When we have to read to specify that we created scanner and implemented
		// in While loop
		Scanner scanner = new Scanner(inputStreamReader);
		while (scanner.hasNext()) {
			builder.append(scanner.nextLine());
		}

		// Closing and printing the value from the API
		scanner.close();
//		System.out.println(builder);
		// Value in String of Array Object
		response.getWriter().append(builder);

		// We have to convert String Format to JSON Format
//		For small or straightforward cases, you can manually create a JSON string.
//		For more complex cases or if you're working with APIs, use a library like org.json, Jackson, or Gson, which handle the conversion automatically and efficiently.
		// So I am Using GSON

		// Created a JSON instance
		Gson gson = new Gson();
		// We can use this instance to convert Java objects to JSON and JSON to Java objects.
		JsonObject jsonObject = gson.fromJson(builder.toString(), JsonObject.class);

//		System.out.println(jsonObject);
//		response.getWriter().print(jsonObject);

//The overall purpose of this code is to take a JSON-formatted string (in this case, represented by responseContent), 
//parse it, and convert it into a JsonObject.
//This allows you to easily manipulate and access the data contained within the JSON.

		// Extracting Date from JSON
		// Date is in seconds
		long datetime = jsonObject.get("dt").getAsLong() * 1000;
		// Date constructor expects milliseconds so we multiply by 1000
		String date = new Date(datetime).toString();

		// Temperature
		double temperatureKelvin = jsonObject.getAsJsonObject("main").get("temp").getAsDouble();
		// Converting kelvin to celsius
		int temperatureCelsius = (int) (temperatureKelvin - 273.15);

		// Humidity
		int humidity = jsonObject.getAsJsonObject("main").get("humidity").getAsInt();

		// Wind Speed
		double windSpeed = jsonObject.getAsJsonObject("wind").get("speed").getAsDouble();

		// Weather Condition
		String weatherCondition = jsonObject.getAsJsonArray("weather").get(0).getAsJsonObject().get("main").getAsString();

		// Setting the data to send the web Page
		request.setAttribute("date", date);
		request.setAttribute("temperature", temperatureCelsius);
		request.setAttribute("city", city);
		request.setAttribute("humidity", humidity);
		request.setAttribute("wind", windSpeed);
		request.setAttribute("weatherCondidtion", weatherCondition);
		request.setAttribute("weatherData", builder.toString());
			
		// Discounting the connection after completing work
		connection.disconnect();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// Sending data to the web page to display
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}
