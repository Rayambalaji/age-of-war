package com.org.war.model;

import java.util.List;
import java.util.Map;

public class PlatoonAdvantageRule {

    public static final Map<PlatoonType, List<PlatoonType>> advantageMap = Map.of(
            PlatoonType.MILITIA, List.of(PlatoonType.SPEARMEN, PlatoonType.LIGHTCAVALRY),
            PlatoonType.SPEARMEN, List.of(PlatoonType.LIGHTCAVALRY, PlatoonType.HEAVYCAVALRY),
            PlatoonType.HEAVYCAVALRY, List.of(PlatoonType.MILITIA, PlatoonType.FOOTARCHER,PlatoonType.LIGHTCAVALRY),
            PlatoonType.FOOTARCHER, List.of(PlatoonType.MILITIA, PlatoonType.CAVALRYARCHER),
            PlatoonType.CAVALRYARCHER, List.of(PlatoonType.SPEARMEN, PlatoonType.HEAVYCAVALRY),
            PlatoonType.LIGHTCAVALRY, List.of(PlatoonType.FOOTARCHER, PlatoonType.CAVALRYARCHER)
    );
}
