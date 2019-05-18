package vo;

import lombok.Getter;

@Getter
public class Reward extends Node {
    private Person person;

    public Reward(String name) {
        super(name);
    }

    public void setPerson(Person person) {
        this.person = person;

        if (person.getReward() != this) {
            person.setReward(this);
        }
    }
}
