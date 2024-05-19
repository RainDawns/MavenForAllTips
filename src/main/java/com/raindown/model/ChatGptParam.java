package com.raindown.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * chatGpt 请求实体
 */
@Setter
@Getter
@Builder
public class ChatGptParam {

    /**
     * 问题
     */
    private String question;

    /**
     * 回答
     */
    private String answer;
}
