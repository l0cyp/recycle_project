package com.trashformer.springboot_recycle.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class RecommendEntity {
        
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String userEmail;
        private int recommendCount; // 추천 수를 저장하는 필드
    
        @JsonIgnore
        @ManyToOne
        @JoinColumn(name = "reform_board_id", nullable = false)
        private ReformBoardEntity reformBoardEntity; // 게시글과의 관계

        @JsonIgnore
        @ManyToOne
        @JoinColumn(name = "kakao_user_id", nullable = false)
        private KakaoUserEntity kakaoUserEntity; // 사용자와의 관계
}
    