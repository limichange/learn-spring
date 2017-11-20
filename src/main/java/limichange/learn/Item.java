package limichange.learn;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
public class Item {

    @Id
    @GeneratedValue
    private Integer id;

    @Min(value=20)
    @NotNull
    private Integer size;

    @Min(value=0)
    @NotNull
    private Integer age;

    public Item() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", size=" + size +
                ", age=" + age +
                '}';
    }
}
