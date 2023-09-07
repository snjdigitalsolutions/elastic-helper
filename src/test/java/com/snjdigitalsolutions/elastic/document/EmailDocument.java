package com.snjdigitalsolutions.elastic.document;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class EmailDocument {

    private LocalDateTime date_received;
    private String domain;
    private String from;
    private String subject;
    private String to;

}
