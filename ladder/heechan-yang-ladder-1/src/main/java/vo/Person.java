package vo;

import lombok.Getter;

@Getter
public class Person extends Node{

    private Reward reward;

    public Person(String name) {
        super(name);
    }

    public void setReward(Reward reward) {
        this.reward = reward;
        if(reward != null){
            reward.setPerson(this);
        }
    }

    public void swapWith(Person p){
        Reward reward = this.reward;
        this.reward = p.reward;
        p.setReward(reward);
    }
}