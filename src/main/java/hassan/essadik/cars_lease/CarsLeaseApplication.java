package hassan.essadik.cars_lease;


import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import hassan.essadik.cars_lease.car.Car;
import hassan.essadik.cars_lease.car.CarRepository;
import hassan.essadik.cars_lease.car.CarService;
import hassan.essadik.cars_lease.contract.Contract;
import hassan.essadik.cars_lease.contract.ContractService;

@SpringBootApplication
public class CarsLeaseApplication implements CommandLineRunner{
	@Autowired
	CarService carService;
	
	@Autowired
	ContractService contractService;
	
	public static void main(String[] args) {
		SpringApplication.run(CarsLeaseApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Car car = new Car();
		
		car.setBrand("Mercedes");
		car.setColor("Noir");
		car.setFirstUse(Date.valueOf("2000-02-02"));
		
		carService.save(car);
		
		car = new Car();
		car.setBrand("Renault");
		car.setColor("Noir");
		carService.save(car);
		
		car = new Car();
		car.setBrand("Renault");
		car.setColor("Bleu");
		carService.save(car);
		
		Contract contract = new Contract();
		contract.setDate(Date.valueOf("2022-03-03"));
        contract.setStartLease(Date.valueOf("2022-03-03"));
        contract.setEndLease(Date.valueOf("2022-03-03"));
        contract.setTotalPrice(5000);
        contract.setAdvance(1500);
        contract.setLeftToPay(3500);
        contract.setPlaceOfReturn("Paris");
        
		contractService.save(contract);
		
		contract = new Contract();
		contract.setPlaceOfReturn("Lile");
		contractService.save(contract);
	}
	
	
}
