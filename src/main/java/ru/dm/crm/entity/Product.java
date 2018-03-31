package ru.dm.crm.entity;

import javax.persistence.*;

/**
 * Created by denis on 31/03/2018.
 */
@Entity
@Table(name = "products", schema = "public")
public class Product {
    private Long id;
    private String articule;
    private String name;

    public Product() {
    }

    public Product(String articule, String name) {
        this.articule = articule;
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "articule")
    public String getArticule() {
        return articule;
    }

    public void setArticule(String articule) {
        this.articule = articule;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product that = (Product) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (articule != null ? !articule.equals(that.articule) : that.articule != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (articule != null ? articule.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
