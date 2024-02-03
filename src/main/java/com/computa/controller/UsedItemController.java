package com.computa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import lombok.RequiredArgsConstructor;
import com.computa.dto.UsedItemFormDto;
import com.computa.service.UsedItemService;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@Controller
public class UsedItemController {

    private final UsedItemService usedItemService;

    @GetMapping(value = "/useditem")
    public String usedItemForm(Model model) {
        model.addAttribute("usedItemFormDto", new UsedItemFormDto());
        return "trade_write";
    }

    @GetMapping(value = "/user/useditem/{useditemId}")
    public String usedItemDetail(@PathVariable("usedItemId") Long usedItemId, Model model) {

        try {
            UsedItemFormDto usedItemFormDto = usedItemService.getUseditemDetail(usedItemId);
            model.addAttribute("usedItemFronDto", usedItemFormDto);
        } catch (EntityNotFoundException e) {
            model.addAttribute("errorMessage", "존재하지 않는 상품입니다,");
            model.addAttribute("usedItemFormDto", new UsedItemFormDto());
            return "useditem/useditemForm";
        }

        return "useditem/useditemForm";

    }

    @PostMapping(value = "/useditem/new")
    public String usedItemNew(@Valid UsedItemFormDto usedItemFormDto, BindingResult bindingResult, Model model,
            @RequestParam("usedItemImgFile") List<MultipartFile> useditemImgFileList) {
        System.out.println("나오긴해봐");
        if (bindingResult.hasErrors()) {
            return "useditem/useditemform";
        }

        if (useditemImgFileList.get(0).isEmpty() && usedItemFormDto.getId() == null) {
            model.addAttribute("errorMessage", "첫번째 상품 이미지는 필수 입력값 입니다.");
            return "useditem/useditemForm";
        }

        try {
            usedItemService.saveUsedItem(usedItemFormDto, useditemImgFileList);
        } catch (Exception e) {
            model.addAttribute("errorMessage", "상품 등록 중 에러가 발생하였습니다.");
            return "useditem/useditemForm";
        }

        return "redirect:/";

    }

    @PostMapping(value = "useditem/{useditemId}")
    public String usedItemUpdate(@Valid UsedItemFormDto usedItemFormDto, BindingResult bindingResult,
            @RequestParam("usedItemImgFile") List<MultipartFile> usedItemImgFilelList, Model model) {

        if (bindingResult.hasErrors()) {
            return "useditem/useditemForm";
        }

        if (usedItemImgFilelList.get(0).isEmpty() && usedItemFormDto.getId() == null) {
            model.addAttribute("errorMessage", "첫번째 상품 이미지는 필수 입력 값입니다.");
            return "useditem/useditemForm";
        }

        try {
            usedItemService.saveUsedItem(usedItemFormDto, usedItemImgFilelList);
        } catch (Exception e) {
            model.addAttribute("errorMessage", "상품 수정 중 에러가 발생하였습니다.");
            return "useditem/usditemForm";
        }

        return "redirect:/";
    }
}
