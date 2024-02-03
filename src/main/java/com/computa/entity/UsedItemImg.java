package com.computa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
@Table(name = "used_item_img")
@Entity
public class UsedItemImg {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "used_item_img_id")
    private Long id;

    private String usedImgName; // 중고 이미지 파일명

    private String oriusedImgName; // 중고 이미지 원본 파일명

    private String usedImgUrl; // 이미지 조회 경로

    private String repUsedImgYn; // 대표 이미지 여부

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "used_item_id")
    private UsedItem useditem;

    @Builder
    public UsedItemImg(String usedImgName, String oriusedImgName, String usedImgUrl, String repUsedImgYn,
            UsedItem useditem) {
        this.usedImgName = usedImgName;
        this.oriusedImgName = oriusedImgName;
        this.usedImgUrl = usedImgUrl;
        this.repUsedImgYn = repUsedImgYn;
        this.useditem = useditem;
    }

    public void updateUsedItemImg(String usedImgName, String oriusedImgName, String usedImgUrl) {
        this.usedImgName = usedImgName;
        this.oriusedImgName = oriusedImgName;
        this.usedImgUrl = usedImgUrl;
    }

}
