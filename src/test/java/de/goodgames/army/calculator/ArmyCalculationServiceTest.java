package de.goodgames.army.calculator;

import de.goodgames.army.calculator.dto.ArmyDto;
import de.goodgames.army.calculator.entity.Troop;
import de.goodgames.army.calculator.exception.IllegalArmySizeException;
import de.goodgames.army.calculator.service.ArmyCalculationService;
import de.goodgames.army.calculator.service.ArmyFactoryService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class ArmyCalculationServiceTest {
    final ArmyFactoryService armyFactoryService = new ArmyFactoryService();
    final ArmyCalculationService armyCalculationService = new ArmyCalculationService(armyFactoryService);

    @Test
    public void test_calculateRandomArmy_sum100() {
        checkSumOfTroops(100);
    }

    @Test
    public void test_calculateRandomArmy_sum1000() {
        checkSumOfTroops(1000);

    }

    @Test
    public void test_calculateRandomArmy_sum10000() {
        checkSumOfTroops(10000);

    }

    private void checkSumOfTroops(long armyAmount) {
        final ArmyDto armyDto = armyCalculationService.createRandomArmy(armyAmount);
        final long sumOfTroops = armyDto.troops().stream().mapToLong(Troop::getAmount).sum();
        assertEquals(armyAmount, sumOfTroops);
    }

    @Test
    public void test_calculateRandomArmy_armyTooSmall() {
        assertThrows(IllegalArmySizeException.class, () -> {
            armyCalculationService.createRandomArmy(1);
        });
    }

    @Test
    public void test_calculateRandomArmy_minArmyAmount() {
        final long ARMY_AMOUNT = 3;
        final ArmyDto armyDto = armyCalculationService.createRandomArmy(ARMY_AMOUNT);
        final long sumOfTroops = armyDto.troops().stream().mapToLong(Troop::getAmount).sum();
        assertEquals(ARMY_AMOUNT, sumOfTroops);
        armyDto.troops().stream().mapToLong(Troop::getAmount).forEach(amountOfTroop -> {
            assertEquals(1, amountOfTroop);
        });
    }

    /*
    This test should not be used in a productive environment because this test fails
    if 2 random armies are equal. (even if this highly unlikely)
     */
    @Test
    public void test_calculateRandomArmy_randomness() {
        final long ARMY_AMOUNT = Long.MAX_VALUE;
        final ArmyDto armyDto = armyCalculationService.createRandomArmy(ARMY_AMOUNT);
        final List<Long> randomArmyAsAmountsList = armyDto.troops().stream().map(Troop::getAmount).toList();
        for (int i = 0; i < 10000; i++) {
            ArmyDto randomArmy = armyCalculationService.createRandomArmy(ARMY_AMOUNT);
            List<Long> anotherRandomArmyAsAmountsList = randomArmy.troops().stream().map(Troop::getAmount).toList();
            assertFalse(randomArmyAsAmountsList.containsAll(anotherRandomArmyAsAmountsList));
        }
    }
}
