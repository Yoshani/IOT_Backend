package com.rpi.springboot.api.controller;

import com.rpi.springboot.api.controller.dto.Alert;
import com.rpi.springboot.api.controller.dto.Parameter;
import com.rpi.springboot.api.entity.Humidity;
import com.rpi.springboot.api.entity.Pressure;
import com.rpi.springboot.api.entity.Rainfall;
import com.rpi.springboot.api.entity.Temperature;
import com.rpi.springboot.api.repository.HumidityRepository;
import com.rpi.springboot.api.repository.PressureRepository;
import com.rpi.springboot.api.repository.RainfallRepository;
import com.rpi.springboot.api.repository.TemperatureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class ParameterController {

    @Autowired TemperatureRepository temperatureRepository;
    @Autowired HumidityRepository humidityRepository;
    @Autowired PressureRepository pressureRepository;
    @Autowired RainfallRepository rainfallRepository;

    @PostMapping(path = "/saveValues",  consumes = MediaType.APPLICATION_XML_VALUE, produces = MediaType.APPLICATION_XML_VALUE)
    public void save(@RequestBody Alert alert){
        List<Parameter> parameters = alert.getInfo().getParameters();

        // get data
        String date = "";
        String temperature_mean = "";
        String temperature_sd = "";
        String humidity_mean = "";
        String humidity_sd = "";
        String pressure_mean = "";
        String pressure_sd = "";
        String rainfall_mean = "";
        String rainfall_sd = "";

        for (Parameter parameter: parameters){
            switch (parameter.getValueName()){
                case "Date":
                    date = parameter.getValue();
                case "TemperatureMean":
                    temperature_mean = parameter.getValue();
                case "TemperatureSD":
                    temperature_sd = parameter.getValue();
                case "HumidityMean":
                    humidity_mean = parameter.getValue();
                case "HumiditySD":
                    humidity_sd = parameter.getValue();
                case "PressureMean":
                    pressure_mean = parameter.getValue();
                case "PressureSD":
                    pressure_sd = parameter.getValue();
                case "RainfallMean":
                    rainfall_mean = parameter.getValue();
                case "RainfallSD":
                    rainfall_sd = parameter.getValue();
            }
        }

        Temperature temperature = new Temperature(date, temperature_mean, temperature_sd);
        Humidity humidity = new Humidity(date, humidity_mean, humidity_sd);
        Pressure pressure = new Pressure(date, pressure_mean, pressure_sd);
        Rainfall rainfall = new Rainfall(date, rainfall_mean, rainfall_sd);

        temperatureRepository.save(temperature);
        humidityRepository.save(humidity);
        pressureRepository.save(pressure);
        rainfallRepository.save(rainfall);


    }

}





