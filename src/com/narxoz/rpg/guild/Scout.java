package com.narxoz.rpg.guild;

/**
 * Guild officer responsible for route reports and reconnaissance.
 */
public class Scout extends GuildMember {

    public Scout(String name, GuildMediator mediator) {
        super(name, mediator);
    }
    public void reportDanger(String payload) {
    getMediator().dispatch("DANGER", this, payload);
}
    @Override
public void receive(String topic, GuildMember from, String payload) {
    System.out.println("[Scout " + getName() + "] Acknowledged " + topic + " updates.");
}}