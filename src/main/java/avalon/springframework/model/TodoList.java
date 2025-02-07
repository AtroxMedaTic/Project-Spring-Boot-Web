package avalon.springframework.model;

import javax.persistence.*;

@Entity
public class TodoList {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)

  private Integer id;
  private String todo;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getTodo() {
    return todo;
  }

  public void setTodo(String todo) {
    this.todo = todo;
  }
}
