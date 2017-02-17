package org.iths.domain;
public class Actor{
  private String nick;
  private String name;
  private int id;
  private Actor(ActorBuilder ab){
    this.name = ab.name;
    this.id   = ab.id;
    this.nick = ab.nick;
  }
  public static class ActorBuilder{
    private String name;
    private int id;
    private String nick="";
    public ActorBuilder name(String name){
      this.name = name;
      return this;
    }
    public ActorBuilder id(int id){
      this.id = id;
      return this;
    }
    public ActorBuilder nick(String nick){
      this.nick = nick;
      return this;
    }
    public Actor build(){
      return new Actor(this);
    }
  }
  @Override
  public String toString(){
    return new StringBuilder(name)
      .append(" ").append(id).append(nick.equals("")?nick:" Nick: " + nick).toString();
  }
}
