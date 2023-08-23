package com.example.demo.worker;

import java.util.Map;

import org.springframework.stereotype.Component;

import io.camunda.zeebe.client.api.response.ActivatedJob;
import io.camunda.zeebe.spring.client.annotation.JobWorker;

@Component
public class Worker {

    @JobWorker
    public Map<String, Integer> multiplyBy2(final ActivatedJob job) {
        Integer element = (Integer)job.getVariablesAsMap().get("element");
        return Map.of("result.2", element * 2);
    }

    @JobWorker
    public Map<String, Integer> multiplyBy3(final ActivatedJob job) {
        Integer element = (Integer)job.getVariablesAsMap().get("element");
        return Map.of("result.3", element * 3);
    }

    @JobWorker
    public Map<String, Integer> multiplyBy4(final ActivatedJob job) {
        Integer element = (Integer)job.getVariablesAsMap().get("element");
        return Map.of("result.4", element * 4);
    }

}
