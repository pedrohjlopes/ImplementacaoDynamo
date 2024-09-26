package com.imepac.ads.dynamodb2.entities;


import com.imepac.ads.dynamodb2.dto.NotaDto;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbAttribute;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbSortKey;

@DynamoDbBean
public class NotaEntity {
    private String PK; // matrícula
    private String SK; // NOTA#idDisciplina
    private double nota;
    private String disciplina;
    private String professor;

    @DynamoDbPartitionKey
    @DynamoDbAttribute("PK")
    public String getPK() {
        return PK;
    }

    public void setPK(String PK) {
        this.PK = PK;
    }

    @DynamoDbSortKey
    @DynamoDbAttribute("SK")
    public String getSK() {
        return SK;
    }

    public void setSK(String SK) {
        this.SK = SK;
    }

    @DynamoDbAttribute("nota")
    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    @DynamoDbAttribute("disciplina")
    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    @DynamoDbAttribute("professor")
    public String getProfessor() {
        return professor;
    }

    public void setProfessor(String professor) {
        this.professor = professor;
    }

    // Construtor que aceita NotaDto e outros parâmetros
    public NotaEntity(String PK, String SK, NotaDto notaDto) {
        this.PK = PK;
        this.SK = SK;
        this.nota = notaDto.nota();
        this.disciplina = notaDto.disciplina();
        this.professor = notaDto.professor();
    }

    // Construtor padrão
    public NotaEntity() {}
}
