package com.coding.persistence.spring_jpa_mysql;


import com.coding.persistence.spring_jpa_mysql.models.Activity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller    // This means that this class is a Controller
@RequestMapping(path="/demo") // This means URL's start with /demo (after Application path)
public class MainController {
    @Autowired
    private ActivityRepository activityRepository;
    @Autowired
    private MachineRepository machineRepository;
    @Autowired
    private MaterialRepository materialRepository;
    @Autowired
    private SupplierRepository supplierRepository;

    @GetMapping(path="/add") // Map ONLY GET Requests
    public @ResponseBody String addNewUser (@RequestParam String name
            ) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        Activity activity = new Activity();
        activity.setName(name);
        activityRepository.save(activity);
        return "Saved";
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Activity> getAllActivities() {
        // This returns a JSON or XML
              return activityRepository.findAll();
    }

    
}

