package com.app.entity;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum UserProfileImage {

    // user profile image
    IMAGE1("image1"),
    IMAGE2("image2"),
    IMAGE3("image3"),
    IMAGE4("image4"),
    IMAGE5("image5");

    

    private final String desc;

}
