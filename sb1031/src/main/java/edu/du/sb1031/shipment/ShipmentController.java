package edu.du.sb1031.shipment;

import edu.du.sb1031.shipmemt.ShipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/shipments")
public class ShipmentController {

    @Autowired
    private ShipmentService shipmentService;

    @PostMapping
    @ResponseBody
    public edu.du.sb1031.shipment.Shipment createShipment(@RequestBody edu.du.sb1031.shipment.Shipment shipment) {
        shipment.setStatus("주문 접수");
        return shipmentService.saveShipment(shipment);
    }

    @GetMapping
    public String getAllShipments(Model model) {
        List<edu.du.sb1031.shipment.Shipment> shipments = shipmentService.getAllShipments();
        model.addAttribute("shipments", shipments);
        return "/shipment/shipmentList";
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Optional<edu.du.sb1031.shipment.Shipment> getShipmentById(@PathVariable Long id) {
        return shipmentService.getShipmentById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public void deleteShipment(@PathVariable Long id) {
        shipmentService.deleteShipment(id);
    }

    @GetMapping("/new")
    public String newShipmentForm(Model model) {
        model.addAttribute("shipment", new edu.du.sb1031.shipment.Shipment());
        return "/shipment/shipmentForm";
    }

    @PostMapping("/save")
    public String saveShipment(@ModelAttribute edu.du.sb1031.shipment.Shipment shipment) {
        shipment.setStatus("주문 접수");
        shipmentService.saveShipment(shipment);
        return "redirect:/shipments";
    }

    @GetMapping("/delete/{id}")
    public String deleteShipment1(@PathVariable Long id) {
        shipmentService.deleteShipment(id);
        return "redirect:/shipments";
    }

    @PostMapping("/updateStatus")
    public String updateShipmentStatus(@RequestParam Long id, @RequestParam String status) {
        shipmentService.updateShipmentStatus(id, status);
        return "redirect:/shipments";
    }
}