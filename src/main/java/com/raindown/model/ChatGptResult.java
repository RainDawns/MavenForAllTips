package com.raindown.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * chatGPT结果集
 */
@Setter
@Getter
public class ChatGptResult {

    private Integer created;

    private String model;

    private String id;

    private String object;

    private List<ChatGptChoice> choices;
}
