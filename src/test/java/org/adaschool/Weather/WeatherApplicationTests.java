package org.adaschool.Weather;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


import org.adaschool.Weather.controller.WeatherReportController;
import org.adaschool.Weather.data.WeatherReport;
import org.adaschool.Weather.service.WeatherReportService;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.Mockito.when;

@SpringBootTest
class WeatherApplicationTests {

	@Mock
	private WeatherReportService weatherReportService;

	private WeatherReportController weatherReportController;

	@BeforeEach
	void setUp() {
		weatherReportController = new WeatherReportController(weatherReportService);
	}

	@Test
	void testReturnsCorrectWeatherReport() {
		double latitude = 37.8267;
		double longitude = -122.4233;

		// Un objeto WeatherReport que devuelva el servicio
		WeatherReport expectedWeatherReport = new WeatherReport();
		expectedWeatherReport.setTemperature(25.0);
		expectedWeatherReport.setHumidity(70.0);

		when(weatherReportService.getWeatherReport(anyDouble(), anyDouble()))
				.thenReturn(expectedWeatherReport);

		WeatherReport actualWeatherReport = weatherReportController.getWeatherReport(latitude, longitude);

		// Verificar que el resultado del controlador sea igual al objeto esperado
		assertEquals(expectedWeatherReport, actualWeatherReport);
	}

}

