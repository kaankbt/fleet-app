package com.kaankubat.fleetapp.controllers;

import com.kaankubat.fleetapp.models.Vehicle;
import com.kaankubat.fleetapp.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class VehicleController<EmployeeService, VehicleStatusService> {

    @Autowired
    private VehicleService vehicleService;
    @Autowired
    private VehicleTypeService vehicleTypeService;
    @Autowired
    private VehicleMakeService vehicleMakeService;
    @Autowired
    private VehicleModelService vehicleModelService;
    @Autowired
    private LocationService locationService;



    //Get All Vehicles
    @GetMapping("vehicles")
    public String findAll(Model model) {
        model.addAttribute("vehicles", vehicleService.findAll());
        model.addAttribute("vehicleTypes", vehicleTypeService.findAll());
        model.addAttribute("vehicleModels", vehicleModelService.findAll());
        model.addAttribute("vehicleMakes", vehicleMakeService.findAll());
        model.addAttribute("locations", locationService.findAll());


        return "vehicle";
    }

    @RequestMapping("vehicles/findById")
    @ResponseBody
    public Optional<Vehicle> findById(Integer id) {
        return vehicleService.findById(id);
    }

    //Add Vehicle
    @PostMapping(value = "vehicles/addNew")
    public String addNew(Vehicle vehicle) {
        vehicleService.save(vehicle);
        return "redirect:/vehicles";
    }

    @RequestMapping(value = "vehicles/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(Vehicle vehicle) {
        vehicleService.save(vehicle);
        return "redirect:/vehicles";
    }

    @RequestMapping(value = "vehicles/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Integer id) {
        vehicleService.delete(id);
        return "redirect:/vehicles";
    }
}
