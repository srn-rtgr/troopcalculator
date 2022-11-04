package de.goodgames.army.calculator.service;

import de.goodgames.army.calculator.dto.ArmyDto;
import de.goodgames.army.calculator.entity.Troop;
import de.goodgames.army.calculator.exception.IllegalArmySizeException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Random;

@Service
public class ArmyCalculationService {
    private final ArmyFactoryService armyFactoryService;

    public ArmyCalculationService(final ArmyFactoryService armyFactoryService) {
        this.armyFactoryService = armyFactoryService;
    }

    public ArmyDto createRandomArmy(final long amountOfTroops) throws IllegalArmySizeException {
        final List<Troop> troops = armyFactoryService.createArmy();

        if (amountOfTroops < troops.size()) {
            throw new IllegalArmySizeException("the minimum army-size is " + amountOfTroops);
        }
        //shuffle troops so that the maximum-troop-boundary is possible for all troops
        Collections.shuffle(troops);

        final Random random = new Random();
        long randomBoundary = amountOfTroops - 1;
        int index = 0;
        while (index < troops.size()) {
            if (!isLastLoop(troops, index)) {
                long randomTroopAmount = random.nextLong(randomBoundary);
                randomTroopAmount = randomTroopAmount > 0 ? randomTroopAmount : 1;
                troops.get(index).setAmount(randomTroopAmount);
                randomBoundary = randomBoundary - randomTroopAmount;
            } else {
                troops.get(index).setAmount(randomBoundary + 1);
            }
            index++;
        }

        return new ArmyDto(troops);
    }

    private static boolean isLastLoop(List<Troop> troops, int index) {
        return index == troops.size() - 1;
    }
}
