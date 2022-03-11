package demo.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class Account implements Serializable {
    private Integer id;
    private String name;
    private Float money;
}
