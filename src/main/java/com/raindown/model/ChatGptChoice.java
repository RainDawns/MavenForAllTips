package com.raindown.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * chatGPT结果集
 */
@Setter
@Getter
public class ChatGptChoice {

    private String finishReason;

    private Integer index;

    private String text;

    private ChatGPTMessage message;
}
