package com.demo.houseManagerAPI.controller;

import org.springframework.web.bind.annotation.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/house/predict")
public class PredictController {

    @GetMapping
    @ResponseBody
    public String getPredict(@RequestParam("id") String id) {
        try {
            URL urlForGetRequest = new URL("http://127.0.0.1:5000/predict/"+ id);
            String readLine = null;
            HttpURLConnection conection = (HttpURLConnection) urlForGetRequest.openConnection();
            conection.setRequestMethod("GET");
            int responseCode = conection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(conection.getInputStream()));
                StringBuffer response = new StringBuffer();
                while ((readLine = in .readLine()) != null) {
                    response.append(readLine);
                } in .close();
                // print result
                System.out.println("JSON String Result " + response.toString());
                return response.toString();
            } else {
                System.out.println("GET NOT WORKED");
            }
        } catch (Error e) {

        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "404";
    }
}
