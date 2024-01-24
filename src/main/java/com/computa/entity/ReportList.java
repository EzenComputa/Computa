package com.computa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="reportlist")
public class ReportList {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 신고유형
    @JoinColumn(nullable = false)

    // 신고자 닉네임
    @ManyToOne
    @JoinColumn(name = "user_nickname", referencedColumnName="ID", nullable = false)
    private User nickname;

    // 신고링크


}

// enum
public enum ReportType {

}
