package edu.du.sb1031.shipment;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ShipmentRepository extends JpaRepository<edu.du.sb1031.shipment.Shipment, Long> {
}