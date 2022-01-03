package com.example.spring_batch_tp.config;

import com.example.spring_batch_tp.config.transaction.model.TransactionItem;
import com.example.spring_batch_tp.model.Transaction;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBatchProcessing
public class BatchConfig {

    @Autowired
    public JobBuilderFactory jobBuilderFactory;
    @Autowired
    public StepBuilderFactory stepBuilderFactory;
    @Autowired
    private ItemReader<TransactionItem> itemReader;
    @Autowired
    private ItemProcessor<TransactionItem, Transaction> itemProcessor;
    @Autowired
    private ItemWriter<Transaction> itemWriter;


    @Bean
    public Job job() {
        Step step = stepBuilderFactory.get("load-data-steppp")
                .<TransactionItem, Transaction>chunk(100)
                .reader(itemReader)
                .processor(itemProcessor)
                .writer(itemWriter)
                .build();
        return jobBuilderFactory.get("transactions-job")
                .start(step)
                .build();
    }
}