package com.coding.mrpImplementation.controller;


import com.coding.mrpImplementation.model.Activity;
import com.coding.mrpImplementation.model.Machine;
import com.coding.mrpImplementation.model.Material;
import com.coding.mrpImplementation.service.persistence.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;

@Controller
@RequestMapping(path="/mrp")
public class MainController {
    @Autowired
    private ActivityRepository activityRepository;

    @GetMapping(path = "/activity")
    public @ResponseBody String addActivity (){
        ArrayList<Machine> machines=new ArrayList<>();
        ArrayList<Material> materials=new ArrayList<>();
        HashMap<Machine, ArrayList<Integer>> calendar=new HashMap<>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        Activity activity=new Activity("0","clorox");
        Machine machine=new Machine("m","1");
        Material material=new Material("a","maat",0,50,50,0,8,6,5);
        machines.add(machine);
        materials.add(material);
        list.add(5);
        calendar.put(machine,list);

        activityRepository.save(activity);
        return "Saved";
    }
}
