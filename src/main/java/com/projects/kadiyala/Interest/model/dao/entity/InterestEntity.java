package com.projects.kadiyala.Interest.model.dao.entity;
import javax.persistence.*;
import java.io.Serializable;




@Entity
@Table(name = "interest")
@NamedQueries({
        @NamedQuery(name = "InterestEntity.findOneByNameAndType",
                query = "SELECT i FROM InterestEntity i WHERE i.name = ?1 AND i.type = ?2")
})
public class InterestEntity implements Serializable {
    /**
     * serialVersionUID for the Interest Entity.
     */
    private static final long serialVersionUID = 1L;

    /**
     * The ID of the Interest
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * The name of the Interest
     */
    @Column(name = "name", nullable = false)
    private String name;


    /**
     * The type of the interest
     */
    @Column(name = "type", length = 50, nullable = false)
    private String type;

    /**
     * The description of the Interest
     */
    @Column(name = "description", length = 100, nullable = false)
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "InterestEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
