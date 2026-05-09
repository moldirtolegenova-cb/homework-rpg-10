package com.narxoz.rpg;

import com.narxoz.rpg.combatant.Hero;
import com.narxoz.rpg.council.*;
import com.narxoz.rpg.guild.*;
import com.narxoz.rpg.quest.*;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.out.println("=== Homework 10 Demo: Iterator + Mediator ===");

        QuestLog log = new QuestLog();
        log.add(new Quest("Kill Rats", QuestPriority.LOW, 10, false));
        log.add(new Quest("Slay Dragon", QuestPriority.URGENT, 5000, true));
        log.add(new Quest("Clear Ruin", QuestPriority.HIGH, 500, false));

        GuildHall hall = new GuildHall();
        new Captain("Valerius", hall);
        new Scout("Elara", hall);
        
        new Loremaster("Thalric", hall); 

        System.out.println("\n--- Quests Sorted by Reward (Extension) ---");
        QuestIterator rewardIt = new RewardSortedQuestIterator(log);
        while (rewardIt.hasNext()) {
            System.out.println(rewardIt.next());
        }

        List<Hero> party = List.of(new Hero("Grog", 100, 20, 10));
        CouncilEngine engine = new CouncilEngine();
        
        CouncilRunResult result = engine.runCouncil(party, log, hall);

        System.out.println("\n--- Final Report ---");
        System.out.println(result);
    }
}