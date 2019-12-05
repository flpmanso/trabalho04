package com.trabalho04.trabalho04.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Marcacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    private float latitude;
    private float longitude;
    @Column(name = "dataInclusao")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date dataInclusao;

}
