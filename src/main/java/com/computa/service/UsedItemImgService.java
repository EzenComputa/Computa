package com.computa.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.computa.entity.UsedItemImg;
import com.computa.persistence.UsedItemImgRepository;

import io.micrometer.common.util.StringUtils;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Transactional
@Service
public class UsedItemImgService {

    @Value("${usedItemImgLocation}")
    private String usedItemImgLocation;

    private final UsedItemImgRepository usedItemImgRepository;

    private final FileService fileService;

    public void saveUsedItemImg(UsedItemImg usedItemImg, MultipartFile useditemFile) throws Exception {
        String oriusedImgName = useditemFile.getOriginalFilename();
        String usedImgName = "";
        String usedImgUrl = "";

        // 파일 업로드
        if (!StringUtils.isEmpty(oriusedImgName)) {
            usedImgName = fileService.uploadFile(usedItemImgLocation, oriusedImgName, useditemFile.getBytes());
            usedImgUrl = "/images/useditem" + usedImgName;
        }

        // 상품 이미지 정보 저장
        usedItemImg.updateUsedItemImg(oriusedImgName, usedImgName, usedImgUrl);
        usedItemImgRepository.save(usedItemImg);
    }

    public void updateUsedItemImg(Long usedItemImgId, MultipartFile usedItemImgFile) throws Exception {

        if (!usedItemImgFile.isEmpty()) {
            UsedItemImg savedUsedItemImg = usedItemImgRepository.findById(usedItemImgId)
                    .orElseThrow(EntityNotFoundException::new);

            if (!StringUtils.isEmpty(savedUsedItemImg.getUsedImgName())) {
                fileService.deleteFile(usedItemImgLocation + "/" + savedUsedItemImg.getUsedImgName());
            }

            String oriUsedImgName = usedItemImgFile.getOriginalFilename();
            String usedimgName = fileService.uploadFile(usedItemImgLocation, oriUsedImgName,
                    usedItemImgFile.getBytes());
            String usedimgUrl = "/images/uesditem/" + usedimgName;
            savedUsedItemImg.updateUsedItemImg(oriUsedImgName, usedimgName, usedimgUrl);
        }
    }

}
