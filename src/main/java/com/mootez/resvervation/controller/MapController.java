package com.mootez.resvervation.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.DecimalFormat;
@CrossOrigin(origins = "http://localhost:4200")

@Controller
public class MapController {

    private static final double EARTH_RADIUS = 6371; // Radius of the earth in km
    private static final DecimalFormat df = new DecimalFormat("0.00");

    @GetMapping("/showap")
    public String index(Model model,
                        @RequestParam(defaultValue = "36.177193") double lat1,
                        @RequestParam(defaultValue = "8.707446") double lon1,
                        @RequestParam(defaultValue = "36.842446") double lat2,
                        @RequestParam(defaultValue = "10.163240") double lon2,
                        @RequestParam(defaultValue = "36.1742") double lat3,
                        @RequestParam(defaultValue = "8.7049") double lon3) {
       
        double distanceToMalibu = haversine(lat1, lon1, lat2, lon2);
        double distanceToKef = haversine(lat1, lon1, lat3, lon3);
       
        model.addAttribute("distanceToMalibu", df.format(distanceToMalibu));
        model.addAttribute("distanceToKef", df.format(distanceToKef));
        return "index";
    }

    private double haversine(double lat1, double lon1, double lat2, double lon2) {
        double dLat = Math.toRadians(lat2 - lat1);
        double dLon = Math.toRadians(lon2 - lon1);
        double a =
                Math.sin(dLat / 2) * Math.sin(dLat / 2) +
                Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) *
                Math.sin(dLon / 2) * Math.sin(dLon / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        return EARTH_RADIUS * c; 
    }
}
