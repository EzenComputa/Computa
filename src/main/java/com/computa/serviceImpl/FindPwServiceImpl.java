// package com.computa.serviceImpl;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;

// import com.computa.entity.User;
// import com.computa.persistence.UserRepository;
// import com.computa.service.FindPwService;


// @Service
// public class FindPwServiceImpl implements FindPwService {

//     private final UserRepository userRepository;

//     @Autowired
//     public FindPwServiceImpl(UserRepository userRepository) {
//         this.userRepository = userRepository;
//     }

//     @Override
//     public String userCheck(String username, String ssid) {
//         User user = userRepository.findByUsername(username);

//         if (user == null || !user.getSsid().equals(ssid)) {
//             throw new RuntimeException("다시입력해주세요~");
//         } else {
//             return user.getNickname();
//         }
//     }
// }