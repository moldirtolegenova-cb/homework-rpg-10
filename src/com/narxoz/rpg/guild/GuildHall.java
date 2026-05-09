package com.narxoz.rpg.guild;

public class GuildHall implements GuildMediator {
    private final java.util.Map<String, java.util.List<GuildMember>> membersByTopic = new java.util.HashMap<>();
    private int totalRouted = 0;

    @Override
    public void register(GuildMember member) {
        if (member instanceof Scout) addSubscriber("DANGER", member);
        if (member instanceof Healer) addSubscriber("INJURY", member);
        if (member instanceof Quartermaster) addSubscriber("SUPPLY", member);
        if (member instanceof Captain) {
            addSubscriber("DANGER", member);
            addSubscriber("SUPPLY", member);
        }
    }

    @Override
    public void dispatch(String topic, GuildMember from, String payload) {
        for (GuildMember member : subscribersFor(topic)) {
            if (member != from) {
                member.receive(topic, from, payload);
                totalRouted++;
            }
        }
    }

    public int getTotalRouted() { return totalRouted; }

    protected void addSubscriber(String topic, GuildMember member) {
        membersByTopic.computeIfAbsent(topic, key -> new java.util.ArrayList<>()).add(member);
    }

    protected java.util.List<GuildMember> subscribersFor(String topic) {
        return membersByTopic.getOrDefault(topic, java.util.List.of());
    }
}