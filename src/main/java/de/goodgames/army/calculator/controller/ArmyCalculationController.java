package de.goodgames.army.calculator.controller;

import de.goodgames.army.calculator.dto.ArmyDto;
import de.goodgames.army.calculator.service.ArmyCalculationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ArmyCalculationController {

    final ArmyCalculationService armyCalculationService;

    public ArmyCalculationController(final ArmyCalculationService armyCalculationService) {
        this.armyCalculationService = armyCalculationService;
    }

    @GetMapping(value = "/randomArmy", produces = "application/json")
    public ArmyDto createRandomArmy(@RequestParam("amountOfTroops") int amountOfTroops) {
        return armyCalculationService.createRandomArmy(amountOfTroops);
    }

}
