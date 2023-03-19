package com.csi.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    @Id

    private int custId;

    private String custName;

    private String custAddress;

    private double custSalary;

    private long custContactNumber;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date custDOB;

    @ManyToOne(cascade = CascadeType.ALL    )
    @JoinColumn(name="department_id")
    private Department department;


}
