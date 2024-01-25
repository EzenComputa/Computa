// package com.computa.controller;

// import
// org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
// import org.springframework.data.domain.Sort;
// import org.springframework.data.web.PageableDefault;
// import org.springframework.stereotype.Controller;
// import org.springframework.ui.Model;
// import org.springframework.web.bind.annotation.GetMapping;

// import com.computa.service.UsedProductService;

// public class UsedProductController {
// @GetMapping("/")
// public String UsedProductController(Long id, Model model,
// @PageableDefault(size = 10, sort = "id", direction = Sort.Direction.DESC)
// Pageable pageable){
// model.addAllAttributes("view",UsedProductService.updateiView(id));
// model.addAttribute("boardList", UsedProductService.getBoardList(pageable));
// model.addAttribute("previous", pageable.previousOrFirst().getPageNumber());
// // 이전 버튼
// model.addAttribute("next", pageable.next().getPageNumber()); // 다음 버튼
// model.addAttribute("check", UsedProductService.getListCheck(pageable)); //
// 마지막 글 체크

// return "index";
// }
// }
