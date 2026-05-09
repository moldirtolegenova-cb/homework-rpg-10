package com.narxoz.rpg.council;

import com.narxoz.rpg.combatant.Hero;
import com.narxoz.rpg.guild.*;
import com.narxoz.rpg.quest.*;
import java.util.List;

public class CouncilEngine {
    public CouncilRunResult runCouncil(List<Hero> party, QuestLog questLog, GuildMediator hall) {
        int questsCount = 0;
        
        // 1. Iterate through ALL quests (Arrival Order)
        QuestIterator it = questLog.ordered();
        while(it.hasNext()) {
            Quest q = it.next();
            questsCount++;
            hall.dispatch("SUPPLY", null, "Evaluating resources for: " + q.getTitle());
        }

        // 2. Iterate through HIGH priority quests only
        QuestIterator priorityIt = questLog.priorityAtLeast(QuestPriority.HIGH);
        while(priorityIt.hasNext()) {
            Quest q = priorityIt.next();
            hall.dispatch("DANGER", null, "Urgent threat detected: " + q.getTitle());
        }

        // Note: Casting to GuildHall here just to get the counter for the result
        int messages = (hall instanceof GuildHall) ? ((GuildHall) hall).getTotalRouted() : 0;
        return new CouncilRunResult(questsCount, messages, messages);
    }
}