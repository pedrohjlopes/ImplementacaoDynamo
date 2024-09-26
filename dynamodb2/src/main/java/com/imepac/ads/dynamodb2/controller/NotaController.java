package com.imepac.ads.dynamodb2.controller;

import io.awspring.cloud.dynamodb.DynamoDbTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.imepac.ads.dynamodb2.entities.NotaEntity;
import com.imepac.ads.dynamodb2.dto.NotaDto;




@RestController
@RequestMapping("/v1/notas")
public class NotaController {

    private final DynamoDbTemplate dynamoDbTemplate;

    @Autowired
    public NotaController(DynamoDbTemplate dynamoDbTemplate) {
        this.dynamoDbTemplate = dynamoDbTemplate;
    }

    @PostMapping("/salvar/{matricula}/{idDisciplina}")
    public String salvarNota(
            @PathVariable String matricula,
            @PathVariable String idDisciplina,
            @RequestBody NotaDto notaDto) {
        try {
            NotaEntity notaEntity = new NotaEntity(matricula, idDisciplina, notaDto);
            dynamoDbTemplate.save(notaEntity); // Usando save ao invés de put
            return "Nota salva com sucesso!";
        } catch (Exception e) {
            e.printStackTrace();
            return "Erro ao salvar a nota: " + e.getMessage();
        }
    }

    @PutMapping("/atualizar/{matricula}/{idDisciplina}")
    public String atualizarNota(
            @PathVariable String matricula,
            @PathVariable String idDisciplina,
            @RequestBody NotaDto notaDto) {
        try {
            NotaEntity notaEntity = new NotaEntity(matricula, idDisciplina, notaDto);
            dynamoDbTemplate.save(notaEntity); // Usando save ao invés de put
            return "Nota atualizada com sucesso!";
        } catch (Exception e) {
            e.printStackTrace();
            return "Erro ao atualizar a nota: " + e.getMessage();
        }
    }


}
