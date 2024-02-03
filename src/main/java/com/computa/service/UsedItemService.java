package com.computa.service;

import jakarta.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.computa.dto.UsedItemFormDto;
import com.computa.dto.UsedItemImgDto;
import com.computa.dto.UsedItemSearchDto;
import com.computa.entity.UsedItem;
import com.computa.entity.UsedItemImg;
import com.computa.persistence.UsedItemImgRepository;
import com.computa.persistence.UsedItemRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Transactional
@Service
@Component
public class UsedItemService {
    private final UsedItemRepository usedItemRepository;
    private final UsedItemImgService usedItemImgService;
    private final UsedItemImgRepository usedItemImgRepository;

    public Long saveUsedItem(UsedItemFormDto useditemFormDto, List<MultipartFile> useditemImgFileList)
            throws Exception {

        // 상품 등록
        UsedItem useditem = useditemFormDto.toEntity(useditemFormDto);
        usedItemRepository.save(useditem);

        // 이미지 등록
        for (int i = 0, max = useditemImgFileList.size(); i < max; i++) {
            UsedItemImg useditemImg = UsedItemImg.builder()
                    .useditem(useditem)
                    .repUsedImgYn(i == 0 ? "Y" : "N")
                    .build();

            usedItemImgService.saveUsedItemImg(useditemImg, useditemImgFileList.get(i));
        }

        return useditem.getId();
    }

    @Transactional // (readOnly = true)
    public UsedItemFormDto getUseditemDetail(Long useditemId) {

        List<UsedItemImg> usedItemImgList = usedItemImgRepository.findByUseditem_IdOrderByIdAsc(useditemId);
        List<UsedItemImgDto> usedItemImgDtoList = new ArrayList<>();

        for (UsedItemImg usedItemImg : usedItemImgList) {
            UsedItemImgDto usedItemImgDto = UsedItemImgDto.of(usedItemImg);
            usedItemImgDtoList.add(usedItemImgDto);
        }

        UsedItem usedItem = usedItemRepository.findById(useditemId).orElseThrow(EntityNotFoundException::new);
        UsedItemFormDto useditemFormDto = UsedItemFormDto.of(usedItem);
        useditemFormDto.setUsedItemImgDtoList(usedItemImgDtoList);

        return useditemFormDto;
    }

    public Long updateUsedItem(UsedItemFormDto usedItemFormDto, List<MultipartFile> usedItemFileList) throws Exception {

        // 상품수정
        UsedItem usedItem = usedItemRepository.findById(usedItemFormDto.getId())
                .orElseThrow(EntityNotFoundException::new);
        usedItem.updateUsedItem(usedItemFormDto);

        List<Long> useditemImgIds = usedItemFormDto.getUsedItemImgIds();

        // 이미지 등록
        for (int i = 0, max = usedItemFileList.size(); i < max; i++) {
            usedItemImgService.updateUsedItemImg(useditemImgIds.get(i), usedItemFileList.get(i));
        }
        return usedItem.getId();
    }

    @Transactional(readOnly = true)
    public UsedItemFormDto getUsedITemDetail(Long useditemId) {
        List<UsedItemImg> useditemimgList = usedItemImgRepository.findByUseditem_IdOrderByIdAsc(useditemId);
        List<UsedItemImgDto> usedItemImgDtoList = new ArrayList<>();

        for (UsedItemImg usedItemImg : useditemimgList) {
            UsedItemImgDto usedItemImgDto = UsedItemImgDto.of(usedItemImg);
            usedItemImgDtoList.add(usedItemImgDto);
        }

        UsedItem usedItem = usedItemRepository.findById(useditemId).orElseThrow(EntityNotFoundException::new);
        UsedItemFormDto usedItemFormDto = UsedItemFormDto.of(usedItem);
        usedItemFormDto.setUsedItemImgDtoList(usedItemImgDtoList);

        return usedItemFormDto;
    }

    // @Transactional(readOnly = true)
    // public Page<UsedItem> getUserUsedItemPage(UsedItemSearchDto
    // usedItemSearchDto, Pageable pageable)
    // return usedItemRepository.getUserUsedItemPage(usedItemSearchDto,pageable);

}
