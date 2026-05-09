package com.narxoz.rpg.guild;

/**
 * Guild officer responsible for wounds, potions, and recovery plans.
 */
public class Healer extends GuildMember {

    public Healer(String name, GuildMediator mediator) {
        super(name, mediator);
    }

    public void prepareAid(String payload) {
    getMediator().dispatch("INJURY", this, payload);
}

   @Override
public void receive(String topic, GuildMember from, String payload) {
    System.out.println("[" + getName() + " (Healer)] Notification received.");
    System.out.println("   Topic: " + topic + " | From: " + from.getName());
    
    if (topic.equals("DANGER")) {
        System.out.println("   Action: Sharpening surgical tools and preparing bandages.");
    } else if (topic.equals("INJURY")) {
        System.out.println("   Action: Casting 'Greater Restoration' on the target.");
    }
}}