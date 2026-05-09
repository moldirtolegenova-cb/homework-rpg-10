package com.narxoz.rpg.guild;

/**
 * Guild officer responsible for orders and mission coordination.
 */
public class Captain extends GuildMember {

    public Captain(String name, GuildMediator mediator) {
        super(name, mediator);
    }

   public void issueOrder(String payload) {
    getMediator().dispatch("COMMAND", this, payload);
}
   @Override
public void receive(String topic, GuildMember from, String payload) {
    System.out.println("[Captain " + getName() + "] Received " + topic + " report: " + payload);
}}