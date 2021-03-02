package com.example.FLC.FinanceLikeCoffee.domain.log;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "TB_VISIT_LOG",
       indexes = {
            @Index(name="VISIT_LOG_IDX01",columnList = "CREATE_TIME"),
            @Index(name="VISIT_LOG_IDX02",columnList = "IP")
})
@Getter
@Setter
@EqualsAndHashCode(of="logId")
@ToString
public class VisitLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LOG_ID")
    private Long logId;

    @Column(name = "CREATE_TIME")
    @CreationTimestamp
    private LocalDateTime createTIme;

    @Column(name = "UPDATE_TIME")
    @UpdateTimestamp
    private LocalDateTime updateTIme;

    @Column(name = "CHANNEL_TYPE", length = 6)
    private String channelType;

    @Column(name = "VISITOR_INFO", length = 200)
    private String visitorInfo;

    @Column(name = "IP", length = 20)
    private String ip;

    @Column(name = "PAGE_NAME", length = 20)
    private String pageName;

    public VisitLog() {

    }

    @Builder
    public VisitLog(String channelType,
                    String visitorInfo,
                    String ip,
                    String pageName) {
        this.channelType = channelType;
        this.visitorInfo = visitorInfo;
        this.ip = ip;
        this.pageName = pageName;
    }
}
