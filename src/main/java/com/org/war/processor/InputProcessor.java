package com.org.war.processor;

import com.org.war.model.Platoon;
import com.org.war.model.PlatoonType;

import java.util.ArrayList;
import java.util.List;

public class InputProcessor {

    public List<Platoon> processInput(String platoonsData){
        ArrayList<Platoon> platoonsList = new ArrayList<>();
        String[] splitPlatoons = platoonsData.split(";");

        for(String platoon: splitPlatoons){
            int delimiterIndex = platoon.indexOf("#");
            PlatoonType platoonClass = PlatoonType.valueOf(platoon.substring(0,delimiterIndex).toUpperCase());
            int platoonCount = Integer.parseInt(platoon.substring(delimiterIndex+1));
            platoonsList.add(new Platoon(platoonClass, platoonCount));
        }
        return platoonsList;
    }
}
