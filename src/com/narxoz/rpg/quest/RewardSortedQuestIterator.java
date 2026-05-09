package com.narxoz.rpg.quest;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class RewardSortedQuestIterator implements QuestIterator {
    private final List<Quest> snapshot;
    private int cursor = 0;

    public RewardSortedQuestIterator(QuestLog questLog) {
        this.snapshot = new ArrayList<>(questLog.snapshot());
        this.snapshot.sort(Comparator.comparingInt(Quest::getRewardGold).reversed());
    }

    @Override
    public boolean hasNext() { return cursor < snapshot.size(); }

    @Override
    public Quest next() { return snapshot.get(cursor++); }
}