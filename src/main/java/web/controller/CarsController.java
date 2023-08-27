package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;
import web.service.CarServiceImpl;

import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/cars")
public class CarsController {

    private final CarServiceImpl carService;

    @Autowired
    public CarsController(CarServiceImpl carService) {
        this.carService = carService;
    }

    private List<Car> cars;

    {
        cars = new ArrayList<>();
        cars.add(new Car("AAA", 111, "White"));
        cars.add(new Car("BBB", 222, "Black"));
        cars.add(new Car("CCC", 333, "Green"));
        cars.add(new Car("DDD", 444, "Yellow"));
        cars.add(new Car("EEE", 555, "Red"));
    }

    @GetMapping(value = "")
    public String index(@RequestParam(value = "count", defaultValue = "5") int count, Model model) {
        model.addAttribute("cars", carService.getCars(cars, count));
        return "cars";
    }
}
