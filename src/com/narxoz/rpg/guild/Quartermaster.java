package com.narxoz.rpg.guild;

/**
 * Guild officer responsible for gear, supplies, and rewards.
 */
public class Quartermaster extends GuildMember {

    public Quartermaster(String name, GuildMediator mediator) {
        super(name, mediator);
    }

    public void requestSupplies(String payload) {
    getMediator().dispatch("SUPPLY", this, payload);
}

   @Override
    public void receive(String topic, GuildMember from, String payload) {
    System.out.println("[" + getName() + " (Quartermaster)] Received message on topic: " + topic);
    System.out.println("   From: " + from.getName());
    System.out.println("   Details: " + payload);

    if (topic.equals("SUPPLY")) {
        System.out.println("   Action: Logged in the ledger and preparing crates.");
    }
}}
