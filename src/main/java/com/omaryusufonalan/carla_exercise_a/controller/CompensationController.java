package com.omaryusufonalan.carla_exercise_a.controller;

import com.omaryusufonalan.carla_exercise_a.service.CompensationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("compensation")
@RequiredArgsConstructor
public class CompensationController {
    private final CompensationService compensationService;

    @GetMapping
    public ResponseEntity<?> getAll(@RequestParam Map<String, String> params) {
        return new ResponseEntity<>(compensationService.getAll(params), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(
            @PathVariable("id") Long id,
            @RequestParam(required = false, defaultValue = "*") List<String> fields
    ) {
        return new ResponseEntity<>(compensationService.getResponseById(id, fields), HttpStatus.OK);
    }
}
