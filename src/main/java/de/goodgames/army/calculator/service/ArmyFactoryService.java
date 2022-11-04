package de.goodgames.army.calculator.service;

import de.goodgames.army.calculator.entity.ArcherTroop;
import de.goodgames.army.calculator.entity.SpearmanTroop;
import de.goodgames.army.calculator.entity.SwordsmanTroop;
import de.goodgames.army.calculator.entity.Troop;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ArmyFactoryService {
    public List<Troop> createArmy(){
        return new ArrayList<Troop>() {{
            add(new ArcherTroop());
            add(new SpearmanTroop());
            add(new SwordsmanTroop());
        }};
    }
}
