package demo.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 应用JPA注解
 */
@Data
@Entity
@Table(name = "customer")
public class Customer implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "source")
    private String source;

    @Column(name = "industry")
    private String industry;

    @Column(name = "level")
    private String level;

    @Column(name = "address")
    private String address;

    @Column(name = "phone")
    private String phone;
}
