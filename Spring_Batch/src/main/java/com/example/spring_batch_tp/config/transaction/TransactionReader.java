package com.example.spring_batch_tp.config.transaction;

import com.example.spring_batch_tp.config.transaction.model.TransactionItem;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

@Configuration
public class TransactionReader {

    @Bean
    public ItemReader<TransactionItem> transactionFlatFileItemReader(@Value("${file.input}") Resource resource) {
        FlatFileItemReader<TransactionItem> transactionFlatFileItemReader = new FlatFileItemReader<TransactionItem>();
        transactionFlatFileItemReader.setName("CSVReader");
        transactionFlatFileItemReader.setResource(resource);
        transactionFlatFileItemReader.setLineMapper(lineMapper());
        return transactionFlatFileItemReader;
    }

    @Bean
    public LineMapper<TransactionItem> lineMapper() {
        DefaultLineMapper<TransactionItem> lineMapper = new DefaultLineMapper<TransactionItem>();

        DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
        lineTokenizer.setDelimiter(",");
        lineTokenizer.setStrict(false);
        lineTokenizer.setNames("transactionId", "accountId", "amount", "transactionDate");
        lineMapper.setLineTokenizer(lineTokenizer);

        BeanWrapperFieldSetMapper<TransactionItem> fieldSetMapper = new BeanWrapperFieldSetMapper<TransactionItem>();
        fieldSetMapper.setTargetType(TransactionItem.class);
        lineMapper.setFieldSetMapper(fieldSetMapper);

        return lineMapper;
    }
}