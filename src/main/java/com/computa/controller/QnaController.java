package com.computa.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import com.computa.entity.PagingInfo;
import com.computa.entity.Qna;
import com.computa.entity.QnaComment;
import com.computa.entity.User;
import com.computa.persistence.QnaRepository;
import com.computa.service.QnaCommentService;
import com.computa.service.QnaService;
import com.computa.service.UserService;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;



@Controller
@SessionAttributes({"user", "pagingInfo"})
public class QnaController {

    public PagingInfo pagingInfo = new PagingInfo();

    @Autowired
    Environment environment;
    
    @Value("${path.upload}")
    public String uploadFolder;

    @Value("${path.download}")
    public String downloadFolder;

    @ModelAttribute("user")
    public User getUser() {
        return new User();
    }

    private UserService userService;

    private final QnaRepository qnaRepository;

    private final QnaService qnaService;

    @Autowired
    private final QnaCommentService qnaCommentService;

    // 생성자 주입
    @Autowired
    public QnaController(UserService userService, QnaRepository qnaRepository, QnaService qnaService
    , QnaCommentService qnaCommentService) {
        this.userService = userService;
        this.qnaRepository = qnaRepository;
        this.qnaService = qnaService;
        this.qnaCommentService = qnaCommentService;
    }

    @RequestMapping("/getQnaList")
    public String QnaList(Model model, 
                @RequestParam(defaultValue = "0") int curPage,
                @RequestParam(defaultValue = "10") int rowSizePerPage,
                @RequestParam(defaultValue = "seq") String searchType,
                @RequestParam(defaultValue = "") String searchWord) {

        Pageable pageable = PageRequest.of(curPage, rowSizePerPage, Sort.by(searchType).ascending());
        Page<Qna> pagedResult = qnaService.getQnalist(pageable, searchType, searchWord);

        int totalRowCount = pagedResult.getNumberOfElements();
        int totalPageCount = pagedResult.getTotalPages();
        int pageSize = pagingInfo.getPageSize();
        int startPage = curPage / pageSize * pageSize + 1;
        int endPage = startPage + pageSize - 1;
        endPage = endPage > totalPageCount ? (totalPageCount > 0 ? totalPageCount : 1) : endPage;

        pagingInfo.setCurPage(curPage);
        pagingInfo.setTotalRowCount(totalRowCount);
        pagingInfo.setTotalPageCount(totalPageCount);
        pagingInfo.setStartPage(startPage);
        pagingInfo.setEndPage(endPage);
        pagingInfo.setSearchType(searchType);
        pagingInfo.setSearchWord(searchWord);
        pagingInfo.setRowSizePerPage(rowSizePerPage);

        model.addAttribute("pagingInfo", pagingInfo);
        model.addAttribute("pageResult", pagedResult);
        model.addAttribute("pageable", pageable);

        model.addAttribute("cp", curPage);
        model.addAttribute("sp", startPage);
		model.addAttribute("ep", endPage);
		model.addAttribute("ps", pageSize);
		model.addAttribute("rp", rowSizePerPage);
		model.addAttribute("tp", totalPageCount);
		model.addAttribute("st", searchType);
		model.addAttribute("sw", searchWord);


        return "getQnaList";
    }
    
    

    @GetMapping("/insertQnaBoard")
    public String insertQnaForm(Model model, @AuthenticationPrincipal UserDetails currentUser) { //  @ModelAttribute("user") = session.getAttribute("user")
        if(currentUser == null){
        return "redirect:/login";
    } else {
        User user = userService.findUserByUsername(currentUser.getUsername());
        model.addAttribute("user", user);
        return "insertQnaBoard";
        }
    }

    @PostMapping("/insertQnaBoard/submit")  // insertQnaBoart/submit
    public String insertQna(Model model, @AuthenticationPrincipal UserDetails currentUser, Qna qna) throws IOException {
        // 데이터베이스에 저장
        qnaRepository.save(qna);
        
        // 파일 업로드
        MultipartFile uploadFile = qna.getUploadFile();
        if(!uploadFile.isEmpty()) {
            
            String fileName = uploadFile.getOriginalFilename();

            // 저장 경로에 파일 저장
            uploadFile.transferTo(new File(uploadFolder + fileName));
            qna.setFileName(fileName);
        }
        
        qnaService.insertQna(qna);

        
        return "qnaregistered";
    }


    @GetMapping("/getQnaBoard")
    public String getQnaBoard(@RequestParam("seq") Long seq, Qna qna, @ModelAttribute("comment") QnaComment comment, Model model, Principal principal) {
        // use principal to get current user
        User user = userService.findUserByUsername(principal.getName());
        if (user == null) {
            return "redirect:/login";
        }

        // qnaService.updateReadCount(qna);
        model.addAttribute("qna", qnaService.getQnaBoard(qna));

        List<QnaComment> orderedComments = qnaCommentService.getOrderedComments(qna);
        model.addAttribute("orderedComments", orderedComments);
        model.addAttribute("reply", new QnaComment());
        return "getQnaBoard";

    }

    
    @PostMapping("/updateQna")
    public String updateQna(@ModelAttribute("user") User user, Qna qna, 
                            @AuthenticationPrincipal UserDetails currentUser,
                            Model model) {
        if(currentUser == null){
        return "redirect:/login";
        }


        // 현재 로그인한 사용자의 정보 확인
        // 현재 로그인한 사용자의 인증 정보를 가져옴
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

         String currentUsername = authentication.getName(); // 현재 로그인한 유저네임을 가져옴
         User currentUserInfo = userService.findUserByUsername(currentUsername); // 현재 로그인한 사용자의 정보를 데이터베이스에서 찾아옴
         String currentNickname = currentUserInfo.getNickname(); // 현재 로그인한 사용자의 닉네임을 가져옴
 
         
         
         // 글 작성자의 닉네임 가져오기
         String writerNickname = qnaService.getWriter(qna); // 주어진 Qna 객체에 대한 작성자의 닉네임을 가져옴
 
         // 현재 로그인한 사용자의 닉네임과 글 작성자의 닉네임을 비교
         if (currentNickname.equals(writerNickname)) {
             qnaService.updateQna(qna);  // 같으면 수정처리
             return "QnaModi";
         } else {
             // 작성자가 다른 경우에 대한 처리
             System.out.println(currentNickname + " " + writerNickname);
         }


        return "forward:getQnaList";
    }



    @GetMapping("/deleteQna")
	public String deleteQna(@ModelAttribute("user") User user, Qna qna, 
                            @AuthenticationPrincipal UserDetails currentUser,
                            Model model) {
		
            if(currentUser == null){
                return "redirect:/login";
                }

                Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        
                 String currentUsername = authentication.getName(); 
                 User currentUserInfo = userService.findUserByUsername(currentUsername);
                 String currentNickname = currentUserInfo.getNickname();

                 String writerNickname = qnaService.getWriter(qna);
            
                 if (currentNickname.equals(writerNickname)) {
                     qnaService.deleteQna(qna); 
                     return "QnaDel";
                 } else {
                     System.out.println(currentNickname + " " + writerNickname);
                 }
        
        
                return "forward:getQnaList";
	}

    @PostMapping("/getQnaBoard/{seq}/postReply")
    public String postReply(@ModelAttribute("comment") QnaComment comment, Principal principal, @PathVariable("seq") Long qnaSeq, @RequestParam(value = "parentId", required = false) Long parentId, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "errorPage";
        }
        User currentUser = userService.findUserByUsername(principal.getName());
        qnaCommentService.save(comment, currentUser, qnaSeq, parentId);

        return "redirect:/getQnaBoard?seq=" + qnaSeq;
    }

    @PostMapping("/getQnaBoard/{seq}/postComment")
    public String postComment(@ModelAttribute("comment") QnaComment comment, Principal principal, @PathVariable("seq") Long qnaSeq, @RequestParam(value = "parentId", required = false) Long parentId, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "errorPage";
        }
        User currentUser = userService.findUserByUsername(principal.getName());
        qnaCommentService.save(comment, currentUser, qnaSeq, parentId);

        return "redirect:/getQnaBoard?seq=" + qnaSeq;
    }
    // 내 문의내역 보류
    @GetMapping("/MyQnaList")
    public String MyQnaList(@ModelAttribute("user") User user, Qna qna, 
                            @AuthenticationPrincipal UserDetails currentUser,
                            Model model) {

          Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

           String currentUsername = authentication.getName(); 
           User currentUserInfo = userService.findUserByUsername(currentUsername);
           String currentNickname = currentUserInfo.getNickname();
           String writerNickname = qnaService.getWriter(qna);
    
           if (currentNickname.equals(writerNickname)) {
               qnaService.deleteQna(qna); 
               return "QnaDel";
           } else {
               System.out.println(currentNickname + " " + writerNickname);
           }


          return "forward:getQnaList";
    }

    

    @RequestMapping("/download")
    public void download(HttpServletRequest req, HttpServletResponse res) throws Exception {
        req.setCharacterEncoding("utf-8");
        String fileName = req.getParameter("fn");
        String fromPath = uploadFolder + fileName;
        String toPath = uploadFolder + fileName;

        byte[] b = new byte[4096];
        File f = new File(toPath);
        FileInputStream fis = new FileInputStream(fromPath);

        String sMimeType = req.getSession().getServletContext().getMimeType(fromPath); // mimetype = file type : pdf, exe, txt.... 
        if (sMimeType == null) sMimeType = "application/octet-stream";

        String sEncoding = new String(fileName.getBytes("utf-8"), "8859_1");
        String sEncoding1 = URLEncoder.encode(fileName, "utf-8");

        res.setContentType(sMimeType);
        res.setHeader("Content-Transfer-Encoding", "binary");
        res.setHeader("Content-Disposition", "attachment; filename = " + sEncoding1);

        int numRead;
        ServletOutputStream os = res.getOutputStream();

        while((numRead=fis.read(b, 0, b.length)) != -1 ) {
            os.write(b, 0, numRead);
        }

        os.flush();
        os.close();
        fis.close();
    }


    
    
    
    
}
