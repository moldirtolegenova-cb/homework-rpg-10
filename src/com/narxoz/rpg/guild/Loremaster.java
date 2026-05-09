package com.narxoz.rpg.guild;

public class Loremaster extends GuildMember {
    public Loremaster(String name, GuildMediator mediator) {
        super(name, mediator);
    }

    @Override
    public void receive(String topic, GuildMember from, String payload) {
        if (topic.equals("HISTORY")) {
            System.out.println("[" + getName() + "] Consulting ancient texts regarding: " + payload);
        }
    }
}