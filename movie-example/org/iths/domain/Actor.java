package org.iths.domain;
public class Actor{
  private String name;
  private Actor(ActorBuilder ab){
    this.name = ab.name;
  }
  public static class ActorBuilder{
    private String name;
    public ActorBuilder name(String name){
      this.name = name;
      return this;
    }
    public Actor build(){
      return new Actor(this);
    }
  }
  @Override
  public String toString(){
    return new StringBuilder(name)
      .toString();
  }
}
