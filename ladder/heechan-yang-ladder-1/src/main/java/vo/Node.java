package vo;

import lombok.Getter;

@Getter
public abstract class Node implements Cloneable{
    private final String name;

    public Node(String name) {
        this.name = name;
    }
}
