package com.example.demo.worker;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.example.demo.variables.MultiInstanceProcessVariable;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.camunda.zeebe.client.api.response.ActivatedJob;
import io.camunda.zeebe.spring.client.annotation.JobWorker;

@Component
public class Worker {

    private ObjectMapper mapper = new ObjectMapper();

    @JobWorker
    public Map<String, MultiInstanceProcessVariable> createResult(final ActivatedJob job) {
        return Map.of("result", new MultiInstanceProcessVariable());
    }

    @JobWorker
    public Map<String, MultiInstanceProcessVariable> multiplyBy2(final ActivatedJob job) {
        Integer element = (Integer) job.getVariablesAsMap().get("element");
        MultiInstanceProcessVariable result = mapper.convertValue(job.getVariablesAsMap().get("result"),
                MultiInstanceProcessVariable.class);
        result.setBy2(element * 2);
        return Map.of("result", result);
    }

    @JobWorker
    public Map<String, MultiInstanceProcessVariable> multiplyBy3(final ActivatedJob job) {
        Integer element = (Integer) job.getVariablesAsMap().get("element");
        MultiInstanceProcessVariable result = mapper.convertValue(job.getVariablesAsMap().get("result"),
                MultiInstanceProcessVariable.class);
        result.setBy3(element * 3);
        return Map.of("result", result);
    }

    @JobWorker
    public Map<String, MultiInstanceProcessVariable> multiplyBy4(final ActivatedJob job) {
        Integer element = (Integer) job.getVariablesAsMap().get("element");
        MultiInstanceProcessVariable result = mapper.convertValue(job.getVariablesAsMap().get("result"),
                MultiInstanceProcessVariable.class);
        result.setBy4(element * 4);
        return Map.of("result", result);
    }

}
