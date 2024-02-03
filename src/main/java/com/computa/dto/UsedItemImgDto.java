package com.computa.dto;

import com.computa.entity.UsedItemImg;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class UsedItemImgDto {

    private Long id;

    private String usedImgName;

    private String oriusedImgName;

    private String usedImgUrl;

    private String repUsedImgYn;

    @Builder
    public UsedItemImgDto(String usedImgName, String oriusedImgName, String usedImgUrl, String repUsedImgYn) {
        this.usedImgName = usedImgName;
        this.oriusedImgName = oriusedImgName;
        this.usedImgUrl = usedImgUrl;
        this.repUsedImgYn = repUsedImgYn;
    }

    public UsedItemImg toEntity(UsedItemImgDto dto) {
        UsedItemImg entity = UsedItemImg.builder()
                .usedImgName(dto.usedImgName)
                .oriusedImgName(dto.oriusedImgName)
                .usedImgUrl(dto.usedImgUrl)
                .repUsedImgYn(dto.repUsedImgYn)
                .build();

        return entity;
    }

    public static UsedItemImgDto of(UsedItemImg entity) {
        UsedItemImgDto dto = UsedItemImgDto.builder()
                .usedImgName(entity.getUsedImgName())
                .oriusedImgName(entity.getOriusedImgName())
                .usedImgUrl(entity.getUsedImgUrl())
                .repUsedImgYn(entity.getRepUsedImgYn())
                .build();

        return dto;
    }

}
