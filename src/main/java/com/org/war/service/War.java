package com.org.war.service;

import com.org.war.model.Platoon;
import com.org.war.model.PlatoonType;

import java.util.*;

import static com.org.war.model.PlatoonAdvantageRule.advantageMap;

public class War {

    public LinkedHashSet<PlatoonType> matchedPlatoon;

    public void beginBattle(List<Platoon> ownArmy, List<Platoon> opponentArmy){

    List<List<Platoon>> allCombinations = generateCombinations(ownArmy, 0, new ArrayList<>());

    for(List<Platoon> platoons: allCombinations) {
        int winCount = 0;
        for(int i=0; i<5; i++){
            if(doesWin(platoons.get(i), opponentArmy.get(i))){
                winCount++;
            }
            if (winCount >= 3) {
                System.out.println(String.join(";", platoons.stream().map(Platoon::toString).toList()));
                return;
            }
        }

    }
        System.out.println("There is no chance of winning");
    }

    private static boolean doesWin(Platoon own, Platoon opp) {
        int ownPower;
        if (advantageMap.getOrDefault(own.getType(), List.of()).contains(opp.getType())) {
            ownPower = own.getCount() * 2;
        } else {
            ownPower = own.getCount();
        }

        return ownPower > opp.getCount();
    }

    public List<List<Platoon>> generateCombinations(List<Platoon> army, int start, List<List<Platoon>> result){

        if (start == army.size()) {
            result.add(new ArrayList<>(army));
            return result;
        }
        for (int i = start; i < army.size(); i++) {
            Collections.swap(army, i, start);
            generateCombinations(army, start + 1, result);
            Collections.swap(army, i, start);
        }
        return result;
    }

}
